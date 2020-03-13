/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestEnviroment;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.Border;

/**
 *
 * @author fabia
 */
public class EnvUtils {
    static Color primColor = new Color(60, 60, 60);
    static Color primbuttonColor = new Color(70, 70, 70);
    static Color barColor = new Color(80, 80, 80);
    static Color listColor = new Color(65,65,65);
    static Color dialogColor = new Color(55, 55, 55);
    
    static Color primForground = new Color(200, 200, 200);
    
//    static Border buttonBorder = BorderFactory.createSoftBevelBorder(2, new Color(120, 120, 120), new Color(96, 96, 96));
    static Border buttonBorder = BorderFactory.createLineBorder(barColor);
    
    public static void paint_(JComponent comp, Color color){
        for(Component c : comp.getComponents()){
            c.setBackground(color);
        }
        comp.setBackground(color);
    }
}
