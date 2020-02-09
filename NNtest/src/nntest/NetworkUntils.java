/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nntest;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import nntest.tagImages.TagImages;
import org.ejml.simple.SimpleMatrix;

/**
 *
 * @author fabia
 */
public class NetworkUntils {
    private static int trainProgress=0;
    private static long avgTimePerIteration = 0;
    
    public static int getProgress(){
        return trainProgress;
    }

    public static long getAvgTimePerIteration() {
        return avgTimePerIteration;
    }
    
    public static boolean trainCycle(int iterations, int saveInterval, CNNetwork net, File[] inputImgs, String path){
        System.out.println("1");
        TagImages imgTag = new TagImages(path);
        System.out.println("2");
        long startTime = System.nanoTime();
        for(int i=0; i < iterations; i++){
            try {
                int img = (int)(Math.random() * inputImgs.length);
                if(i % saveInterval == 0){
                    net.saveInstance();
                }
                BufferedImage bufferedImage = ImageIO.read(inputImgs[img]);
                SimpleMatrix[] imgMatrix = useImage.getMatrix(bufferedImage);
                
                net.train(imgMatrix, imgTag.resultMap.get(getImageNameInfo(inputImgs[img].getName())));
                trainProgress++;
                avgTimePerIteration = (System.nanoTime() - startTime) / i;
            } catch (IOException ex) {
                Logger.getLogger(NetworkUntils.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(NetworkUntils.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        trainProgress = 0;
        avgTimePerIteration = 0;
        return true;
    }
    
    public static NameInfo getImageNameInfo(String name) {
        String[] nameInfoRaw = name.split("_");
        NameInfo nameInfo = new NameInfo(nameInfoRaw[0], Integer.parseInt(nameInfoRaw[1]));

        return nameInfo;
    }
}
