/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nntest;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author fabia
 */
public class NNTest {
    public static GUI newGui;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            int[] hiddenNums = new int[40];
            int counter = 0;
            for(double i=1; i > 0.4; i -= 0.015){
                hiddenNums[counter] = (int)(5000 * i);
                counter++;
            }
            CNNetwork nn = new CNNetwork(40000, hiddenNums, 4, 40, "Onata");
            newGui = new GUI();
        } catch (Exception ex) {
            Logger.getLogger(NNTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
