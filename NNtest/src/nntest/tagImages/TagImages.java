/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nntest.tagImages;

import java.util.Scanner;
import java.util.TreeMap;
import nntest.NameInfo;

/**
 *
 * @author fabia
 */
public class TagImages {
    public TreeMap<Integer, Integer[]> resultMap;
    
    public TagImages(String path) {
        this.resultMap = GetImageMap.getResultMap(path);
    }

    public Integer[] getResultMap(NameInfo imgInfo) {
        return resultMap.get(imgInfo.name.hashCode() + imgInfo.number.hashCode());
    }
}
