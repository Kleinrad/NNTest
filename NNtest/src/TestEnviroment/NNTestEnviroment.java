/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestEnviroment;

import java.awt.Component;
import java.awt.Cursor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author fabia
 */
public class NNTestEnviroment extends javax.swing.JFrame {
   
    /**
     * Creates new form NNTestEnviroment
     */
    public NNTestEnviroment() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPageCenter1 = new TestEnviroment.MainPageCenter();
        cMenuBar1 = new TestEnviroment.CMenuBar();
        fileMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        viewMenu = new javax.swing.JMenu();
        previewMenu = new javax.swing.JMenu();
        increaseScale = new javax.swing.JMenuItem();
        decreaseScale = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(1000, 640));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().add(mainPageCenter1, java.awt.BorderLayout.CENTER);

        fileMenu.setMnemonic('F');
        fileMenu.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setMnemonic('S');
        jMenuItem1.setText("Save Instance");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setMnemonic('L');
        jMenuItem2.setText("Load Instance");
        fileMenu.add(jMenuItem2);

        cMenuBar1.add(fileMenu);

        editMenu.setText("Edit");
        cMenuBar1.add(editMenu);

        viewMenu.setMnemonic('V');
        viewMenu.setText("View");
        viewMenu.setToolTipText("");

        previewMenu.setText("Preview");

        increaseScale.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_PLUS, java.awt.event.InputEvent.CTRL_MASK));
        increaseScale.setText("Scale+");
        increaseScale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                increaseScaleActionPerformed(evt);
            }
        });
        previewMenu.add(increaseScale);

        decreaseScale.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_MINUS, java.awt.event.InputEvent.CTRL_MASK));
        decreaseScale.setText("Scale-");
        decreaseScale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decreaseScaleActionPerformed(evt);
            }
        });
        previewMenu.add(decreaseScale);

        viewMenu.add(previewMenu);

        cMenuBar1.add(viewMenu);

        setJMenuBar(cMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        init();
    }//GEN-LAST:event_formWindowOpened

    private void decreaseScaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decreaseScaleActionPerformed
        mainPageCenter1.decreaseScale();
        mainPageCenter1.refresh();
    }//GEN-LAST:event_decreaseScaleActionPerformed

    private void increaseScaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_increaseScaleActionPerformed
        mainPageCenter1.increaseScale();
        mainPageCenter1.refresh();
    }//GEN-LAST:event_increaseScaleActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void init (){
        cMenuBar1.setColor(EnvUtils.barColor);
        cMenuBar1.setBorder(BorderFactory.createLineBorder(EnvUtils.primColor));

        for(int i=0; i < cMenuBar1.getMenuCount(); i++){
            cMenuBar1.getMenu(i).setForeground(EnvUtils.primForground);
        }
        
        mainPageCenter1.setBackground(EnvUtils.primColor);
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NNTestEnviroment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NNTestEnviroment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NNTestEnviroment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NNTestEnviroment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NNTestEnviroment().setVisible(true);
            }
        });
    }

    private void setLoading(boolean isLoading){
        for(Component c : this.getComponents()){
            c.setEnabled(isLoading);
            c.setCursor(isLoading ? Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR) : Cursor.getDefaultCursor());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private TestEnviroment.CMenuBar cMenuBar1;
    private javax.swing.JMenuItem decreaseScale;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem increaseScale;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private TestEnviroment.MainPageCenter mainPageCenter1;
    private javax.swing.JMenu previewMenu;
    private javax.swing.JMenu viewMenu;
    // End of variables declaration//GEN-END:variables
    
    private void setLookAndFeel(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NNTestEnviroment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(NNTestEnviroment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(NNTestEnviroment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(NNTestEnviroment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
