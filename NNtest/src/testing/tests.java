/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import java.util.Random;
import org.ejml.simple.SimpleMatrix;

/**
 *
 * @author fabia
 */
public class tests {
    public static void main(String[] args) {
        SimpleMatrix matrix = SimpleMatrix.random_DDRM(1000, 47196, -1, 1, new Random());
        SimpleMatrix vector = SimpleMatrix.random_DDRM(1, 47196, -1, 1, new Random());
        
        SimpleMatrix weightedVectors = new SimpleMatrix(matrix.numCols(), 1);
        for(int i = 0; i < matrix.numCols();){
            weightedVectors.set(i, matrix.rows(i, ++i).elementMult(vector).elementSum());
        }
        System.out.println(weightedVectors);
    }
}
