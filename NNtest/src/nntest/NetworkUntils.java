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
    
    public static boolean trainCycle(int iterations, int saveInterval, CNNetwork net, File[] inputImgs, String path){
        TagImages imgTag = new TagImages(path);
        for(int i=0; i < iterations; i++){
            try {
                int img = (int)(Math.random() * inputImgs.length);
                if(i % saveInterval == 0){
                    net.saveInstance();
                }
                BufferedImage bufferedImage = ImageIO.read(inputImgs[img]);
                SimpleMatrix[] imgMatrix = useImage.getMatrix(bufferedImage);
                
                net.train(imgMatrix, imgTag.resultMap.get(getImageNameInfo(inputImgs[img].getName())));
                
            } catch (IOException ex) {
                Logger.getLogger(NetworkUntils.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(NetworkUntils.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return true;
    }
    
    public static NameInfo getImageNameInfo(String name) {
        String[] nameInfoRaw = name.split("_");
        NameInfo nameInfo = new NameInfo(nameInfoRaw[0], Integer.parseInt(nameInfoRaw[1]));

        return nameInfo;
    }
}
