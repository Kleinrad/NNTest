/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestEnviroment;

import javax.swing.ImageIcon;

/**
 *
 * @author fabia
 */
public class LoadingPanel extends javax.swing.JPanel {

    /**
     * Creates new form LoadingPanel
     */
    public LoadingPanel() {
        initComponents();
        ImageIcon loadingIcon = new ImageIcon(".\\misc\\img\\loading.png");
        jLabel1.setIcon(loadingIcon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        imgField = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.GridLayout());

        jLayeredPane1.setLayout(new javax.swing.OverlayLayout(jLayeredPane1));

        imgField.setLayout(new java.awt.GridLayout());

        jLabel1.setToolTipText("");
        imgField.add(jLabel1);

        jLayeredPane1.add(imgField);

        add(jLayeredPane1);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel imgField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    // End of variables declaration//GEN-END:variables
}
