/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nntest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ejml.simple.SimpleMatrix;

/**
 *
 * @author fabia
 */
public class FFNetwork {
    
    //Variables to calculate The Accuracy
    private double learning_rate = 0.1;
    
    //Network related
    ArrayList<Integer> layerSizes = new ArrayList<Integer>();
    static ArrayList<FFNetwork> networks = new ArrayList<>();
    
    //Weights
    private SimpleMatrix weights_ih;
    private ArrayList<SimpleMatrix> weights_hidden = new ArrayList<SimpleMatrix>();
    private SimpleMatrix weights_ho;

    //Biasis
    private double bias_ih = Math.random() * 2 - 1;
    private ArrayList<Double> bias_hidden = new ArrayList<Double>();
    private double bias_ho = Math.random() * 2 - 1;
    
    public FFNetwork(int inputNum, Integer[] hiddenNum, int outputNum, int hiddenLayers) throws Exception {
        if(hiddenNum.length != hiddenLayers){
            throw new Exception("Hidden Neurons don't match up with Hidden Layers!");
        }
        networks.add(this);
        layerSizes.add(0, inputNum);
        layerSizes.add(1, outputNum);
        layerSizes.add(2, hiddenLayers);
        
        //Initialize the weight Maticies with the according pattern columns = from-Connection Amount of Neurons and rows = to-Connection Amout of Neurons, with a double between -1 and 1 
        weights_ih = SimpleMatrix.random_DDRM(hiddenNum[0], inputNum, -1, 1, new Random());
        weights_ho = SimpleMatrix.random_DDRM(outputNum, hiddenNum[hiddenNum.length - 1], -1, 1, new Random());
        
        //Adds a new Random Matrix to the list 
        for(int i=1; i < hiddenLayers; i++){
            layerSizes.add(i + 2, hiddenNum[i - 1]);
            weights_hidden.add(SimpleMatrix.random_DDRM(hiddenNum[i - 1], hiddenNum[i], -1, 1, new Random()));
            bias_hidden.add(Math.random() * 2 - 1);
        }
        layerSizes.add(hiddenNum.length + 2, hiddenNum[hiddenNum.length - 1]);
    } 
    
    //FeedForward Algorithm computes the input to outputs, it feeds the input forward to the outputs
    public double [] feedForward(SimpleMatrix input) {     
        
        //Multiplay weights_ih with input Matrix | Get Weighted Sum
        SimpleMatrix inputWeightedSums = weights_ih.mult(input);
        inputWeightedSums.plus(bias_ih);
        inputWeightedSums = activation(inputWeightedSums);  
        
        //Multiplay all weights_hidden with previous Result/ next input Matrix
        SimpleMatrix hiddenWeightedSums = inputWeightedSums;
        for(int i = 0; i < weights_hidden.size(); i++){
            hiddenWeightedSums = weights_hidden.get(i).mult(hiddenWeightedSums);
            hiddenWeightedSums.plus(bias_hidden.get(i));
            hiddenWeightedSums = activation(hiddenWeightedSums);
        }

        //Multiplay weights_oh with last hidden result Matrix
        SimpleMatrix outputWeightedSums = weights_ho.mult(hiddenWeightedSums);
        outputWeightedSums.plus(bias_ho);
        outputWeightedSums = activation(outputWeightedSums);
        
        double[] output_arr = toArray(outputWeightedSums);
        return output_arr;
    }
 
    public void train (SimpleMatrix input, double[] targets_arr) throws Exception{
        if(input.numCols() != weights_ih.numCols()){
            throw new Exception("Input is not valid. It must match up with input nodes!");
        }else if(targets_arr.length != weights_ho.numRows()){
            throw new Exception("Result is not valid. It must match up with output nodes!");    
        }
        
        //Multiplay weights_ih with input Matrix | Get Weighted Sum
        SimpleMatrix firstHiddenSum = weights_ih.mult(input);
        firstHiddenSum.plus(bias_ih);
        firstHiddenSum = activation(firstHiddenSum);
        
        //Multiplay all weights_hidden with previous Result/ next input Matrix
        SimpleMatrix hiddenWeightedSums = firstHiddenSum;
        ArrayList<SimpleMatrix> hiddenResults = new ArrayList<SimpleMatrix>();
        hiddenResults.add(hiddenWeightedSums);
        for(int i = 0; i < weights_hidden.size(); i++){
            hiddenWeightedSums = weights_hidden.get(i).mult(hiddenWeightedSums);
            hiddenWeightedSums.plus(bias_hidden.get(i));
            hiddenWeightedSums = activation(hiddenWeightedSums);
            hiddenResults.add(hiddenWeightedSums);
        }

        //Multiplay weights_oh with last hidden result Matrix
        SimpleMatrix outputWeightedSums = weights_ho.mult(hiddenWeightedSums);
        outputWeightedSums.plus(bias_ho);
        outputWeightedSums = activation(outputWeightedSums);
        
        SimpleMatrix targets = toMatrix(targets_arr);
        
        
        //calculating the error of Output 
        SimpleMatrix errors_o =  targets.minus(outputWeightedSums);
        
        //calculating delta weights for ho
        SimpleMatrix weights_delta;
        SimpleMatrix gradient = dsigmoid(outputWeightedSums);
        //System.out.println(gradient);
        gradient = gradient.elementMult(errors_o);
        gradient = multScalar(learning_rate, gradient);
        
        bias_ho += gradient.get(0);
        
        weights_delta = gradient.mult(hiddenResults.get(hiddenResults.size() - 1).transpose());
        
        //calculating the error of hidden Layers
        SimpleMatrix errors_h = weights_ho.transpose().mult(errors_o);
        
        //adding delta weight to weight
        weights_ho = weights_ho.plus(weights_delta);
        
        //Loops throug backwarts starting with the next to last bacause last is picked above
        for(int i=weights_hidden.size(); i > 0; i--){
            gradient = dsigmoid(hiddenResults.get(i));
            gradient = gradient.elementMult(errors_h);
            gradient = multScalar(learning_rate, gradient);
            
            bias_hidden.set(i - 1, gradient.get(0));
            
            weights_delta = gradient.mult(hiddenResults.get(i - 1).transpose());
            
            weights_hidden.set(i - 1, weights_hidden.get(i - 1).plus(weights_delta));
            errors_h = weights_hidden.get(i - 1).transpose().mult(errors_h);
        }
        
        //calculate first hidden errors for ih
        //errors_h = weights_hidden.get(0).transpose().mult(errors_h);
        
        gradient = dsigmoid(hiddenResults.get(0));
        gradient = gradient.elementMult(errors_h);
        gradient = multScalar(learning_rate, gradient);
        
        bias_ih += gradient.get(0);
        
        weights_delta = gradient.mult(input.transpose());
        weights_ih = weights_ih.plus(weights_delta);
    }
    
    // Activation Function with sigmoid func
    private static SimpleMatrix activation(SimpleMatrix matrix){
        SimpleMatrix matrixActiv = new SimpleMatrix(matrix.numRows(), matrix.numCols());
        for(int i = 0; i < matrix.numRows(); i++){
            for(int j = 0; j < matrix.numCols(); j++){
                matrixActiv.set(i, j, sigmoid(matrix.get(i, j)));
            }
        }
        return matrixActiv;
    }
    
    
    //Help Functions 
    
    //Sigmoid Fuction return relativ to the input a number between 0 and 1
    private static double sigmoid(double x){
        return 1 / ( 1 + Math.exp(-x));
    }
    
    private static SimpleMatrix dsigmoid(SimpleMatrix matrix){
        SimpleMatrix dsigmMatrix = new SimpleMatrix(matrix.numRows(), matrix.numCols());
        for(int i=0; i < matrix.numRows(); i++){
            for(int j=0; j < matrix.numCols(); j++){
                double x = matrix.get(i, j);
                double dsig = (x * (1 - x));
                dsigmMatrix.set(i, j, dsig);
            }
        }
        return dsigmMatrix;
    }
    //To Matrix Function that converts array to matrix/Vektor
    private static SimpleMatrix toMatrix(double [] arr){
        SimpleMatrix matrix = new SimpleMatrix(arr.length, 1);
        for(int i=0; i < arr.length; i++){
            matrix.set(i, 0, arr[i]);
        }
        return matrix;
    }
    
    //To Array Function that converts matrix/Vektor to array
    private static double [] toArray(SimpleMatrix matrix){
        double[] arr = new double[matrix.numRows()];
        for(int i=0; i < arr.length; i++){
            arr[i] = matrix.get(i, 0);
        }
        return arr;
    }
    
    //print Array Function that prints an Array correctly
    public static void printArray(double [] arr){
        System.out.print("[");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + (i+1 != arr.length ? " ," : "]"));    
        }
        System.out.println("");
    }
    
    //Scalar mult multiplays matrix with sacalr 
    private static SimpleMatrix multScalar(double x, SimpleMatrix matrix){
        SimpleMatrix multMatrix = new SimpleMatrix(matrix.numRows(), matrix.numCols());
        for(int i=0; i < matrix.numRows(); i++){
            for(int j=0; j < matrix.numCols(); j++){
                multMatrix.set(i, j, matrix.get(i, j) * x);
            }
        }
        return multMatrix;
    }
}
