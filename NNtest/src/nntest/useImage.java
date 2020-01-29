/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nntest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ejml.simple.SimpleMatrix;

/**
 *
 * @author fabia
 */
public class useImage {
    
    public static SimpleMatrix[] getMatrix(final BufferedImage image, final Dimension resolution){
        try {
            SimpleMatrix[] rgbMatrix = new SimpleMatrix[3];
            for(int i = 0; i < 3; i++){
                SimpleMatrix colorMatrix = new SimpleMatrix(resolution.height, resolution.width);
                rgbMatrix[i] = colorMatrix;
            }
            
            final CountDownLatch cdl = new CountDownLatch(4);
            final SimpleMatrix[][] parts = new SimpleMatrix[4][];
            new Thread(() -> {
                parts[0] = getMatrixPart(image, resolution, 0);
                cdl.countDown();
            }).start();
            new Thread(() -> {
                parts[1] = getMatrixPart(image, resolution, 1);
                cdl.countDown();
            }).start();
            new Thread(() -> {
                parts[2] = getMatrixPart(image, resolution, 2);
                cdl.countDown();
            }).start();
            new Thread(() -> {
                parts[3] = getMatrixPart(image, resolution, 3);
                cdl.countDown();
            }).start();
            
            cdl.await();
            for(int j=0; j < 4; j++){
                for(int i=0; i < 3; i++){
                    rgbMatrix[i] = rgbMatrix[i].plus(parts[j][i]);
                }
            }
            
            return rgbMatrix;
        } catch (InterruptedException ex) {
            Logger.getLogger(useImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    
    
    private static SimpleMatrix[] getMatrixPart(BufferedImage image, Dimension resolution, int part){
        SimpleMatrix[] rgbPartMatrix = new SimpleMatrix[3];
        for(int i = 0; i < 3; i++){
            SimpleMatrix colorMatrix = new SimpleMatrix(resolution.height, resolution.width);
            rgbPartMatrix[i] = colorMatrix;
        }
        
        int imgWidth = image.getWidth();
        int imgHeight = image.getHeight();
        
        for(int matrixArrayPos=0; matrixArrayPos < 3; matrixArrayPos++){
            for(int heightPos=(imgHeight / 4) * part; heightPos < (imgHeight / 4) * (part + 1); heightPos++){
                for(int widthPos=(imgWidth / 4) * part; widthPos < (imgWidth / 4) * (part + 1); widthPos++){
                    Color pixColor = new Color(image.getRGB(widthPos, heightPos));
                    rgbPartMatrix[matrixArrayPos].set(heightPos, widthPos, (matrixArrayPos == 0 ? pixColor.getRed() : (matrixArrayPos == 1 ? pixColor.getGreen() : pixColor.getBlue())));
                }
            }
        }
        return rgbPartMatrix;
    }
            
    //Old Version
    //very complicated and useless using a CNN
//    private void setMatrix(BufferedImage image) throws Exception{
//        int imgWidth = image.getWidth();
//        int imgHeight = image.getHeight();
//        imageDimension.width = imgWidth;
//        imageDimension.height = imgHeight;
//        ImageDivider divider = getDivider(imageDimension);
//        div = divider;
//        if(div.err){
//            throw new Exception("unable to convert image!");
//        }
//        
//        int startWidth = (imgWidth - divider.dimension.width) / 2;
//        int startHeight = (imgHeight - divider.dimension.height) / 2;
//        
//        int endWidth = imgWidth - startWidth;
//        int endHeight = imgHeight - startHeight;
//        
//        double pix = 0;
//        
//        int counter = 0;
//        for(int i = startHeight; i < endHeight; i += divider.divider){
//            for(int j = startWidth; j < endWidth; j += divider.divider){
//                pix = 0;
//                for(int k = i; k < i + divider.divider && k < endHeight; k++){
//                    for(int l = j; l < j + divider.divider && l < endWidth; l++){
//                        Color pixColor = new Color(image.getRGB(l, k));
//                        pix += (pixColor.getBlue() + pixColor.getGreen() + pixColor.getRed()) / 3;
//                    }
//                }
//                if(counter == arrayAmount){
//                    return;
//                }
//                pixelGreyScale[counter] = pix / (divider.divider * divider.divider);
//                counter++;
//            }
//        }
//    }
//    
//    private ImageDivider getDivider(Dimension dimension){
//        try{
//            int gcd = gcd(dimension.width, dimension.height);
//            ImageDivider divider = new ImageDivider(gcd, dimension);
//            double requriedSize; 
//            divider.dimension = dimension;
//            
//            int testLoop = 0;
//            while(true){
//           
//                requriedSize = (dimension.width / gcd) * (dimension.height / gcd);
//                if(requriedSize > arrayAmount){
//                    if(testLoop == 2){
//                        break;
//                    }
//                    gcd++;
//                    testLoop = 1;
//                }else{
//                    if(requriedSize == arrayAmount){
//                        divider.divider = gcd;
//                        return divider;
//                    }
//                    gcd--;
//                    if(testLoop == 1){
//                        break;
//                    }
//                    testLoop = 2;
//                }
//            }
//            divider.divider = gcd;
//            requriedSize = (dimension.width / gcd) * (dimension.height / gcd);
//            while(requriedSize > arrayAmount || requriedSize < 39600){
//                
//                dimension = slice(dimension, requriedSize);
//                requriedSize = (dimension.width / gcd) * (dimension.height / gcd);
//            }
//            divider.dimension = dimension;
//            return divider;
//            
//        }catch(ArithmeticException e){
//            ImageDivider errDivider = new ImageDivider(true);
//            return errDivider;
//        }
//    }
//    
//    private Dimension slice(Dimension dimension, double requriedSize){
//        double ratio = (double)(dimension.width * dimension.height) / arrayAmount;
//        int difference = (int)(requriedSize - arrayAmount);
//        difference += 300;
//        
//        int realDifference = (int)(difference * ratio);
//
//        double percentageWidth = (double)dimension.width / dimension.height;
//
//        int deltaHeight = (int)(realDifference / (percentageWidth + 1));
//        int deltaWidth = (int)(deltaHeight * percentageWidth);
//
//        if(deltaHeight + deltaWidth - realDifference > 10){
//            throw  new ArithmeticException("Something went wrong with calculating the deltas of the slicing! Height difference: " + deltaHeight + 
//                    " Width difference: " + deltaWidth + System.lineSeparator() +
//                    " Real difference: " + realDifference + " Estimated Sum: " + (deltaWidth + deltaHeight)
//            );
//        }
//        
//        Dimension newDimension = new Dimension();
//        
//        int heightCut = 1;
//        
//        while(heightCut * dimension.width * 2 < deltaHeight){
//            heightCut++;
//        }
//        
//        int widthCut = 1;
//        
//        while(widthCut * dimension.height * 2 < deltaWidth){
//            widthCut++;
//        }
//        
//        newDimension.width = dimension.width - widthCut;
//
//        newDimension.height = dimension.height - heightCut;
//        
//        return newDimension;
//    }
//    
//    public static double[] getPixels(int iteration, BufferedImage image){   
//        return new double[0];
//    }
//    
//    public void showImage(Point posPoint){
//        double[] pixelArray = pixelGreyScale;
//        
//        JFrame imageDisplay = new JFrame();
//        
//        
//        imageDisplay.setLocation(posPoint);
//        imageDisplay.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        
//        int dimension = div.divider;
//        
//        imageDisplay.setSize(new Dimension(div.dimension.width / dimension + 50, div.dimension.height / dimension + 50));
//
//        if(dimension == 1){
//            imageDisplay.setLayout(new GridLayout(0, div.dimension.width / dimension + 1));
//        }else{
//            imageDisplay.setLayout(new GridLayout(0, div.dimension.width / dimension));
//        }
//        int width = (div.dimension.width / dimension);
//        
//        if(div.dimension.width % dimension != 0){
//            ArrayList<Integer> stepOverArr = div.getStepOver();
//            for(int i=0; i < arrayAmount; i++){
//                int steps = testStepOver(i, width, stepOverArr);
//                JPanel pixel = new JPanel();
//                pixel.setBackground(new Color((int)pixelArray[i], (int)pixelArray[i], (int)pixelArray[i]));
//                imageDisplay.add(pixel);
//                i += steps;
//            }
//        }else{
//            for(int i=0; i < arrayAmount; i++){
//                JPanel pixel = new JPanel();
//                pixel.setBackground(new Color((int)pixelArray[i], (int)pixelArray[i], (int)pixelArray[i]));
//                imageDisplay.add(pixel);
//            }
//        }
//        
//        imageDisplay.setVisible(true);
//    }
}
