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
    public static TestEnviroment.NNTestEnviroment newGui;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CNNetwork nn = new CNNetwork("Onata");
        newGui = new TestEnviroment.NNTestEnviroment(nn);
        newGui.setVisible(true);
    }

}
