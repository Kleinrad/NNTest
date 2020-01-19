/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nntest;

import java.awt.Dimension;
import java.util.ArrayList;

/**
 *
 * @author fabia
 */
public class ImageDivider {
    public int divider;
    public Dimension dimension;
    public boolean err;
    
    public ImageDivider(int divider, Dimension dimension) {
        this.divider = divider;
        this.dimension = dimension;
        this.err = false;
    } 

    public ImageDivider(boolean err) {
        this.err = err;
    }
    
    public ArrayList<Integer> getStepOver(){
        ArrayList<Integer> stepOver = new ArrayList<Integer>();
        double divisor = getLineUneveness();
        for(int i=0; i < 10; i++){
            if(divisor == 0.0){
                break;
            }
            stepOver.add((int)(1 / divisor));
            divisor = Math.round(((double)(1 / divisor) - stepOver.get(i)) * 1000000);
            divisor /= 1000000;
            if(stepOver.get(i) == 1){
                break;
            }
        }
        return stepOver;
    }
    
    public static int rangeSum(int i, ArrayList<Integer> arr){
        int sum = 0;
        if(i >=  arr.size()){
            i = arr.size();
        }
        for(int j = 0; j < i; j++){
            sum += arr.get(j);
        }
        return sum;
    }
    
    public double getLineUneveness(){
        return (double)dimension.width / divider - getLineLenght();
    }
    
    public int getLineLenght(){
        return dimension.width / divider;
    }
}
