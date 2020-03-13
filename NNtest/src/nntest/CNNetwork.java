/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nntest;

import java.awt.Dimension;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ejml.simple.SimpleMatrix;
/**
 *
 * @author fabia
 */

//Network has a minimum of one input Layer, two hidden Layers, one output and maximum of one input, n hidden, one output
public class CNNetwork {
    
    //Variables to calculate The Accuracy
    private int computed = 0;
    private int correctComputed = 0;
    private double dropOutChance = 0;
    private String arc;
    private Dimension imgDimension = new Dimension();
    private FFNetwork fCLayer = null;
    
    private SimpleMatrix[][][] filters = new SimpleMatrix[2][][];

    private SimpleMatrix[] weights = new SimpleMatrix[3];
    private int fcFirstLayerCount = 0;
    
    
    private Integer[] convReps = {2, 3};
    
    public CNNetwork(String arc) {
        try {
            this.arc = arc;
            init();
        } catch (Exception ex) {
            Logger.getLogger(CNNetwork.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void init() throws Exception{
        filters[0] = new SimpleMatrix[convReps[0]][];
        filters[1] = new SimpleMatrix[convReps[1]][];
        
        for(int i=0; i < convReps[0]; i++){
            filters[0][i] = new SimpleMatrix[2];
            for(int j=0; j < 2; j++){
                filters[0][i][j] = initFilter(5);
            }
        }
        
        for(int i=0; i < convReps[1]; i++){
            filters[1][i] = new SimpleMatrix[3];
            for(int j=0; j < 3; j++){
                filters[1][i][j] = initFilter(3);
            }
        }
    }
    
    //inputMatrixs is the output of useImage | arc is the used architecture
    public double[] predict(SimpleMatrix[] inputMatrixs, Dimension imgDimension){
        try {
            this.imgDimension = imgDimension;
            if(!checkInputMatrices(inputMatrixs)){
                throw new IllegalArgumentException("Matrices not compatible!");
            }
            SimpleMatrix inceptionVector = inceptionCycle(inputMatrixs);
            
            if(fCLayer == null){
                Integer[] hiddenNums = {5000, 500};
                fCLayer = new FFNetwork(fcFirstLayerCount, hiddenNums, 4, 2);
            }
            return fCLayer.feedForward(inceptionVector);
        } catch (Exception ex) {
            Logger.getLogger(CNNetwork.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    private SimpleMatrix inceptionCycle(SimpleMatrix[] resMatrixs){
        SimpleMatrix[][] resFirstCycle = new SimpleMatrix[convReps[0]][3];
        for(int i=0; i < convReps[0]; i++){
            SimpleMatrix[] inMatrix = resMatrixs;
            resFirstCycle[i] = covolute(inMatrix, filters[0][i][0], imgDimension);
            inMatrix = resFirstCycle[i];
            
            resFirstCycle[i] = relu(inMatrix, imgDimension);
            inMatrix = resFirstCycle[i];
            
            resFirstCycle[i] = covolute(inMatrix, filters[0][i][1], imgDimension);
            inMatrix = resFirstCycle[i];
            
            resFirstCycle[i] = maxPooling(inMatrix, 6, imgDimension);
            NetworkUntils.raiseIterationProgress();
        }
        System.out.println(resFirstCycle[0][0].get(0));
        SimpleMatrix[][] resSecCycle = new SimpleMatrix[convReps[1] * resFirstCycle.length][];
        for(int i=0; i < convReps[1]; i++){
            for(int j=0; j < resFirstCycle.length; j++){
                int outPos = i * resFirstCycle.length + j;
                SimpleMatrix[] inMatrix = resFirstCycle[j];
                SimpleMatrix[] outMatrix = new SimpleMatrix[3];
                outMatrix = covolute(inMatrix, filters[1][i][0], imgDimension);
                inMatrix = outMatrix;
                
                outMatrix = relu(inMatrix, imgDimension);
                inMatrix = outMatrix;
                
                outMatrix = covolute(inMatrix, filters[1][i][1], imgDimension);
                inMatrix = outMatrix;
                
                outMatrix = relu(inMatrix, imgDimension);
                inMatrix = outMatrix;
                
                outMatrix = covolute(inMatrix, filters[1][i][2], imgDimension);
                inMatrix = outMatrix;
                outMatrix = maxPooling(inMatrix, 4, imgDimension);
                resSecCycle[outPos] = outMatrix;
            }
            NetworkUntils.raiseIterationProgress();
        }
        System.out.println(resSecCycle[0][0].get(0));
        return flattenCLO(resSecCycle);
    }
    //Flattens output of convolution Layers
    private SimpleMatrix flattenCLO(SimpleMatrix[][] inputMatrixs){
        if(fcFirstLayerCount == 0){
            fcFirstLayerCount = inputMatrixs.length * inputMatrixs[0].length * inputMatrixs[0][0].getNumElements();
        }
        SimpleMatrix vector = new SimpleMatrix(fcFirstLayerCount, 1);
        int idx = 0;
        for(int i=0; i < inputMatrixs.length; i++){
            for(int j=0; j < inputMatrixs[i].length; j++){
                for(int k=0; k < inputMatrixs[i][j].numCols() * inputMatrixs[i][j].numRows(); k++){
                    vector.set(idx++, inputMatrixs[i][j].get(k));
                }
            }
        }
        return vector;
    }
    
    public void train(SimpleMatrix[] input, Integer[] targets_arr) throws Exception{
        SimpleMatrix inceptionOutput = inceptionCycle(input);
        if(NetworkUntils.getIterationProgress() < 6){
            NetworkUntils.setIterationProgress(6);
        }
        fCLayer.train(inceptionOutput, targets_arr);
    }
    
    public void saveInstance(){
        
    }
    
//    private double predictXception(SimpleMatrix[] resMatrixs){
//        return 0.0;
//    }
//    
//    private SimpleMatrix[] xceptionCycle(SimpleMatrix[] inputMatrixs){
//        //Convolution with 3x3 filters
//        SimpleMatrix[] resBaseConv = inputMatrixs;
//        for(int i=0; i < 3; i++){
//            resBaseConv = covolute(resBaseConv, filters[0][i]);
//        }
//        //First Convolution block
//        SimpleMatrix[] resConvA = resBaseConv;
//        for(int i=0; i < 3; i++){
//            resConvA = xceptionConvA(resConvA, filters[1]);
//        }
//        //Second Convolution block
//        SimpleMatrix[] resConvB = resConvA;
//        for(int i=0; i < 8; i++){
//            resConvB = xceptionConvB(resConvB, filters[2]);
//        }
//        //Third Convolution block
//        SimpleMatrix[] resConvC = xceptionConvC(resConvB, filters[3]);
//        
//        SimpleMatrix[] resFCL2;
//        
//        return resFCL2;
//    }
//    
//    private SimpleMatrix[] xceptionConvA(SimpleMatrix[] inputMatrixs, SimpleMatrix[] filter){
//        
//        inputMatrixs = relu(inputMatrixs);
//        
//        SimpleMatrix[] cycleResult = covolute(inputMatrixs, filter[0]);
//        cycleResult = relu(cycleResult);
//        
//        cycleResult = covolute(cycleResult, filter[1]);
//        
//        cycleResult = maxPooling(cycleResult, 3);
//        
//        return cycleResult;
//    }
//    
//    private SimpleMatrix[] xceptionConvB(SimpleMatrix[] inputMatrixs, SimpleMatrix[] filter){
//        
//        inputMatrixs = relu(inputMatrixs);
//        
//        SimpleMatrix[] cycleResult = covolute(inputMatrixs, filter[0]);
//        cycleResult = relu(cycleResult);
//        cycleResult = covolute(cycleResult, filter[1]);
//        cycleResult = relu(cycleResult);
//        
//        cycleResult = covolute(cycleResult, filter[0]);
//        
//        return cycleResult;
//    }
//    
//    private SimpleMatrix[] xceptionConvC(SimpleMatrix[] inputMatrix, SimpleMatrix[] filters){
//        
//        inputMatrix = relu(inputMatrix);
//        
//        SimpleMatrix[] cycleResult = covolute(inputMatrix, filters[0]);
//        cycleResult = relu(cycleResult);
//        cycleResult = covolute(cycleResult, filters[1]);
//        cycleResult = maxPooling(cycleResult, 3);
//        
//        //Should add conv 1x1
//        
//        for(int i=0; i < 2; i++){
//            cycleResult = covolute(cycleResult, filters[3 + i]);
//        }
//        
//        return cycleResult;
//    }
    
    private static SimpleMatrix initFilter (int dim){
        SimpleMatrix filter= new SimpleMatrix(dim, dim);
       
        for(int i=0; i < dim * dim; i++){
            filter.set(i, Math.random() * 2 - 1);
        }
        return filter;
    }
    
    private static SimpleMatrix[] covolute(SimpleMatrix[] inputMatrices, SimpleMatrix filter, Dimension imgDimension){
        
        //3D Matrix with width, height and the 3 Color channels Red Green and Blue
        //represented by the length of the SimpleMatrix array
        SimpleMatrix[] outputMatrices = new SimpleMatrix[inputMatrices.length];
        
        //The amout off pixel the filter shifts each turn
        int stride = 1;
        
        int filterRows = filter.numRows();
        int filterColumns = filter.numCols();
        
        //getting the output Dimensions
        int newWidth = inputMatrices[0].numCols() - (filterColumns - 1);
        int newHeight = inputMatrices[0].numRows() - (filterRows - 1);
        
        //initializing the ouput Matrices
        outputMatrices[0] = new SimpleMatrix(newHeight, newWidth);
        outputMatrices[1] = new SimpleMatrix(newHeight, newWidth);
        outputMatrices[2] = new SimpleMatrix(newHeight, newWidth);
        
        //Iterating line by line over the Red Matrix of the input
        //and moving the filte over the image Matrix
        SimpleMatrix redMatrix = inputMatrices[0];
        
        for(int heightPosition=0; heightPosition + filterRows - 1 < imgDimension.height; heightPosition += stride){
            for(int widthPosition=0; widthPosition + filterColumns -1 < imgDimension.width; widthPosition += stride){
                double value = dotProductLoop(redMatrix, filter, new Point(widthPosition, heightPosition));
                outputMatrices[0].set(heightPosition, widthPosition, value);
            }
        }
        
        //Iterating line by line over Green Matrix
        SimpleMatrix greenMatrix = inputMatrices[1];
        
        for(int heightPosition=0; heightPosition + filterRows - 1 < imgDimension.height; heightPosition += stride){
            for(int widthPosition=0; widthPosition + filterColumns -1 < imgDimension.width; widthPosition += stride){
                double value = dotProductLoop(greenMatrix, filter, new Point(widthPosition, heightPosition));
                outputMatrices[1].set(heightPosition, widthPosition, value);
            }
        }
        
        //Iterating line by line over Blue Matrix
        SimpleMatrix blueMatrix = inputMatrices[2];
        
        for(int heightPosition=0; heightPosition + filterRows - 1 < imgDimension.height; heightPosition += stride){
            for(int widthPosition=0; widthPosition + filterColumns -1 < imgDimension.width; widthPosition += stride){
                double value = dotProductLoop(blueMatrix, filter, new Point(widthPosition, heightPosition));
                outputMatrices[2].set(heightPosition, widthPosition, value);
            }
        }
        imgDimension.height = newHeight;
        imgDimension.width = newWidth;
        
        return outputMatrices;
    }
    
    //calculates the dot Product of bigMatrix and filter 
    //mainly used for the covolute function the calculate dot product
    //of filter and part of input Matrix
    private static double dotProductLoop(SimpleMatrix bigMatrix, SimpleMatrix filter, Point scope){
        double dotProduct = 0;
        
        for(int heightPosition=0; heightPosition < filter.numRows(); heightPosition++){
            for(int widthPosition=0; widthPosition < filter.numCols(); widthPosition++){
                double bigMatrixValue = bigMatrix.get(heightPosition + scope.y, widthPosition + scope.x);
                dotProduct += filter.get(heightPosition, widthPosition) * bigMatrixValue;
            }
        }
        return dotProduct;
    }    
    
    //testing without
    
    //Batch-Normalization is used to eliminate any arbatrary large results
    //that could cause any problems by cascading throw the network
//    private static SimpleMatrix[] batchNorm(SimpleMatrix[] inputMatricies){
//        SimpleMatrix[] normed = new SimpleMatrix[3];
//        
//        int inputRows = inputMatricies[0].numRows();
//        int inputCols = inputMatricies[0].numCols();
//        
//        //Initialize the normed Matricies
//        normed[0] = new SimpleMatrix(inputRows, inputCols);
//        normed[1] = new SimpleMatrix(inputRows, inputCols);
//        normed[2] = new SimpleMatrix(inputRows, inputCols);
//        
//        for(int row=0; row < inputRows; row++){
//            for(int column=0; column < inputCols; column++){
//                
//            }
//        }
//    }
//    
    private static SimpleMatrix[] relu(SimpleMatrix[] inputMatrices, Dimension imgDimension){
        SimpleMatrix[] reluMatrices = new SimpleMatrix[inputMatrices.length];
        
        int newRows = inputMatrices[0].numRows();
        int newCols = inputMatrices[0].numCols();
        reluMatrices[0] = new SimpleMatrix(newRows, newCols);
        reluMatrices[1] = new SimpleMatrix(newRows, newCols);
        reluMatrices[2] = new SimpleMatrix(newRows, newCols);
        
        for(int i=0; i < 3; i++){
            SimpleMatrix matrix = inputMatrices[i];
            
            for(int heightPos=0; heightPos < imgDimension.height; heightPos++){
                for(int widthPos=0; widthPos < imgDimension.width; widthPos++){
                    double matrixValue = matrix.get(heightPos, widthPos);
                    reluMatrices[i].set(heightPos, widthPos, Math.max(matrixValue, 0.0));
                }
            }
        }
        
        return reluMatrices;
    }
    
    //Max Pooling is used for extracting significant features and getting rid of 
    //the liniarity that came from the convolution step and also reduces the information
    private static SimpleMatrix[] maxPooling(SimpleMatrix[] inputMatrices, int poolingRange, Dimension imgDimension){
        SimpleMatrix[] maxPoolingMatrices = new SimpleMatrix[inputMatrices.length];
        
        //New Dimension for output Matrices
        int newWidth = inputMatrices[0].numCols() % poolingRange != 0 ? (int)(inputMatrices[0].numCols() / poolingRange) + 1 : (int)(inputMatrices[0].numCols() / poolingRange);
        int newHeight = inputMatrices[0].numRows()% poolingRange != 0 ? (int)(inputMatrices[0].numRows()/ poolingRange) + 1 : (int)(inputMatrices[0].numRows()/ poolingRange);
        
        //Initializing ouput Matricies
        maxPoolingMatrices[0] = new SimpleMatrix(newHeight, newWidth);
        maxPoolingMatrices[1] = new SimpleMatrix(newHeight, newWidth);
        maxPoolingMatrices[2] = new SimpleMatrix(newHeight, newWidth);
        
        //iterating over input Matrices
        for(int i = 0; i < 3; i++){
            SimpleMatrix matrix = inputMatrices[i];
            //iterating over single Matrix
            for(int heightPos = 0; heightPos < imgDimension.height; heightPos += poolingRange){
                for(int widthPos = 0; widthPos < imgDimension.width; widthPos += poolingRange){

                    //Simple Max Function
                    double max = max(heightPos, widthPos, poolingRange, matrix);
                    maxPoolingMatrices[i].set(heightPos / poolingRange, widthPos / poolingRange, max);
                }
            }
        }
        imgDimension.height = newHeight;
        imgDimension.width = newWidth;
        
        return maxPoolingMatrices;
    }
    
    public static double max(int heightPos, int widthPos, int poolingRange, SimpleMatrix matrix){
        double max = matrix.get(heightPos, widthPos);
        for(int i=0; i < poolingRange; i++){
            for(int j=0; j < poolingRange; j++){
                double checkMax = 0;
                if(heightPos + i < matrix.numRows() && widthPos + j < matrix.numCols()){
                    checkMax = matrix.get(heightPos + i, widthPos + j);
                    max = (checkMax > max ? checkMax : max);
                }
                
            }
        }
        return max;
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
    
    private boolean checkInputMatrices(SimpleMatrix[] inMatrixs){
        if(inMatrixs.length != 3){
            return false;
        }
        if(inMatrixs[0].numCols() != inMatrixs[1].numCols() || inMatrixs[1].numCols() != inMatrixs[2].numCols()){
            return false;
        }
        if(inMatrixs[0].numRows()!= inMatrixs[1].numRows()|| inMatrixs[1].numRows()!= inMatrixs[2].numRows()){
            return false;
        }
        
        return true;
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
    
    private static SimpleMatrix[] initMatricies(SimpleMatrix[] inputMatrixs){
        SimpleMatrix[] matricies = new SimpleMatrix[inputMatrixs.length];
        
        int inputRows = inputMatrixs[0].numRows();
        int inputCols = inputMatrixs[0].numCols();
        
        matricies[0] = new SimpleMatrix(inputRows, inputCols);
        matricies[1] = new SimpleMatrix(inputRows, inputCols);
        matricies[2] = new SimpleMatrix(inputRows, inputCols);
        
        return matricies;
    }
    
    //GUI related functions
    public String getAccuracy(){
        if(computed == 0){
            return "Accuracy: " + 0.0 + "%";
        }
        double percentage = (double)correctComputed / computed;
        percentage *= 10000;
        percentage = Math.round(percentage);
        return "Accuracy: " + (double)percentage / 100 + "%";
    }
    
    public void raiseCorrect() {
        correctComputed++;
        computed++;
    }
    
    public void raiseComputed() {
        computed++;
    }
    
}
