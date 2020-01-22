/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestEnviroment;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;

/**
 *
 * @author fabia
 */
public class MainPageCenter extends javax.swing.JPanel {
    private nntest.CNNetwork net;
    
    private DefaultListModel listModel = new DefaultListModel();
    
    private ImageIcon imgPreview = new ImageIcon(".\\misc\\img\\noImage.jpg");
    
    private ImageIcon runIdleIcon = new ImageIcon(".\\misc\\img\\runNoToggle.png");
    private ImageIcon runToggleIcon = new ImageIcon(".\\misc\\img\\runToggle.png");
    
    private ImageIcon uploadIdleIcon = new ImageIcon(".\\misc\\img\\imageIcon.png");
    private ImageIcon uploadToggleIcon = new ImageIcon(".\\misc\\img\\imageIconToggle.png");
    
    private ImageIcon trainToggleIcon = new ImageIcon(".\\misc\\img\\trainToggle.png");
    private ImageIcon trainIdleIcon = new ImageIcon(".\\misc\\img\\trainNoToggle.png");
    
    private double previewScale = 0.5;
    private File imgFile;
    /**
     * Creates new form MainPageCenter
     */
    public MainPageCenter(nntest.CNNetwork net) {
        this.net = net;
        initComponents();
        startUp();
    }
    
    private void startUp(){
        paint_(south2, EnvUtils.primColor);
        paint_(southPanel, EnvUtils.primColor);
        paint_(imageField, EnvUtils.primColor);
        paint_(imageContainer, EnvUtils.primColor);
        
        runButton.setIcon(runIdleIcon);
        uploadButton.setIcon(uploadIdleIcon);
        trainButton.setIcon(trainIdleIcon);
        
        updatePreviewImg();
        
        imageField.setBackground(EnvUtils.primColor);
        imageContainer.setBorder(EnvUtils.buttonBorder);
        
        jList1.setBackground(EnvUtils.listColor);
        jList1.setModel(listModel);
    }
    
    private void updatePreviewImg(){
        
        int imgWidth = imgPreview.getIconWidth();
        int imgHeight = imgPreview.getIconHeight();
        
        int newWidth = (int)(imgWidth * previewScale);
        int newHeight = (int)(imgHeight * previewScale);
        
        Image convImage = imgPreview.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        image.setIcon(new ImageIcon(convImage));
    }
    
    private static void paint_(JComponent comp, Color color){
        for(Component c : comp.getComponents()){
            c.setBackground(color);
        }
        comp.setBackground(color);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageField = new javax.swing.JPanel();
        southPanel = new javax.swing.JPanel();
        northStut = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 10));
        south2 = new javax.swing.JPanel();
        uploadButton = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(40, 0), new java.awt.Dimension(10, 32767));
        runButton = new javax.swing.JLabel();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(35, 0), new java.awt.Dimension(20, 32767));
        trainButton = new javax.swing.JLabel();
        southStut = new javax.swing.Box.Filler(new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 5), new java.awt.Dimension(32767, 5));
        imageContainer = new javax.swing.JPanel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        image = new javax.swing.JLabel();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        imageProperties = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setLayout(new java.awt.BorderLayout());

        imageField.setToolTipText("");
        imageField.setLayout(new java.awt.BorderLayout());

        southPanel.setLayout(new java.awt.BorderLayout());
        southPanel.add(northStut, java.awt.BorderLayout.NORTH);

        uploadButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                uploadButtonMousePressed(evt);
            }
        });
        south2.add(uploadButton);
        south2.add(filler2);

        runButton.setMaximumSize(new java.awt.Dimension(50, 50));
        runButton.setPreferredSize(new java.awt.Dimension(65, 65));
        runButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                runButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                runButtonMouseReleased(evt);
            }
        });
        south2.add(runButton);
        south2.add(filler5);

        trainButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                trainButtonMousePressed(evt);
            }
        });
        south2.add(trainButton);

        southPanel.add(south2, java.awt.BorderLayout.CENTER);
        southPanel.add(southStut, java.awt.BorderLayout.SOUTH);

        imageField.add(southPanel, java.awt.BorderLayout.SOUTH);

        imageContainer.setMinimumSize(new java.awt.Dimension(360, 129));
        imageContainer.setPreferredSize(new java.awt.Dimension(360, 129));
        imageContainer.setLayout(new java.awt.BorderLayout());
        imageContainer.add(filler3, java.awt.BorderLayout.NORTH);

        image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image.setPreferredSize(new java.awt.Dimension(260, 100));
        imageContainer.add(image, java.awt.BorderLayout.CENTER);
        imageContainer.add(filler4, java.awt.BorderLayout.SOUTH);

        imageField.add(imageContainer, java.awt.BorderLayout.CENTER);

        add(imageField, java.awt.BorderLayout.CENTER);

        imageProperties.setMinimumSize(new java.awt.Dimension(50, 50));

        jList1.setMaximumSize(new java.awt.Dimension(100, 90));
        jList1.setMinimumSize(new java.awt.Dimension(100, 90));
        jList1.setPreferredSize(new java.awt.Dimension(100, 90));
        imageProperties.setViewportView(jList1);

        add(imageProperties, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    
    private void runButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_runButtonMousePressed
        try {
            runButton.setIcon(runToggleIcon);
            runButton.setBorder(EnvUtils.buttonBorder);
            BufferedImage bImage = ImageIO.read(imgFile);
            net.predict(nntest.useImage.getMatrix(bImage));
        } catch (IOException ex) {
            Logger.getLogger(MainPageCenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_runButtonMousePressed

    private void runButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_runButtonMouseReleased
        runButton.setIcon(runIdleIcon);
        runButton.setBorder(null);
    }//GEN-LAST:event_runButtonMouseReleased

    private void uploadButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uploadButtonMousePressed
        uploadButton.setIcon(uploadToggleIcon);
        uploadButton.setBorder(EnvUtils.buttonBorder);
        JFileChooser fchooser = new JFileChooser();
        int result = fchooser.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION){
            imgPreview = new ImageIcon(fchooser.getSelectedFile().getPath());
            imgFile = fchooser.getSelectedFile();
        }
        updatePreviewImg();
        uploadButton.setBorder(null);
        uploadButton.setIcon(uploadIdleIcon);
    }//GEN-LAST:event_uploadButtonMousePressed

    private void trainButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trainButtonMousePressed
        trainButton.setIcon(trainToggleIcon);
        trainButton.setBorder(EnvUtils.buttonBorder);
    }//GEN-LAST:event_trainButtonMousePressed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.JLabel image;
    private javax.swing.JPanel imageContainer;
    private javax.swing.JPanel imageField;
    private javax.swing.JScrollPane imageProperties;
    private javax.swing.JList<String> jList1;
    private javax.swing.Box.Filler northStut;
    private javax.swing.JLabel runButton;
    private javax.swing.JPanel south2;
    private javax.swing.JPanel southPanel;
    private javax.swing.Box.Filler southStut;
    private javax.swing.JLabel trainButton;
    private javax.swing.JLabel uploadButton;
    // End of variables declaration//GEN-END:variables

    public void increaseScale(){
        if(previewScale < 1){
            previewScale += 0.1;
        }
    }
    
    public void decreaseScale(){
        if(previewScale > 0.2){
            previewScale -= 0.1;
        }
    }
    
    public void refresh(){
        updatePreviewImg();
        repaint();
    }
}
