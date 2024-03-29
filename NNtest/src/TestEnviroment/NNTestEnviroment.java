/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestEnviroment;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import nntest.CNNetwork;
import nntest.NetworkUntils;


/**
 *
 * @author fabia
 */
public class NNTestEnviroment extends javax.swing.JFrame {
    private MainPageCenter mainPageCenter1;
    private JFrame loadingFrame = new JFrame();
    private Thread trainInfoDialog = new Thread(() -> checkTrainInfoDialog());
    private nntest.CNNetwork net;
    private String lastImgPath = "C:\\";
    private RunDialog trainProgress = new RunDialog(this, true);
    
    public void setLoadingScreen(){
        loadingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loadingFrame.setUndecorated(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        loadingFrame.setLocation(screenSize.width / 2 - 249, screenSize.height / 2 - 150);
        loadingFrame.add(new LoadingPanel());
        loadingFrame.pack();
        loadingFrame.setVisible(true);
    }
    
    public void removeLoadingScreen(){
        loadingFrame.setVisible(false);
    }
    
    public static void main(String[] args) {
        NNTestEnviroment newGui = new NNTestEnviroment();
        newGui.setLoadingScreen();
        
        CNNetwork net = new CNNetwork("Onata");
        newGui.setNet(net);
        newGui.setVisible(true);
        newGui.removeLoadingScreen();
        
    }
    
    /**
     * Creates new form NNTestEnviroment
     */
    public void setNet(CNNetwork net){
        this.net = net;
        mainPageCenter1 = new MainPageCenter(net);
        trainInfoDialog.start();
    }
    
    public NNTestEnviroment(){
        initComponents();
        Dimension screenPos = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(screenPos.width / 2 - getSize().width / 2, screenPos.height / 2 - getSize().height / 2);
    }
    
    private void checkTrainInfoDialog(){
        try {
            while(true){
                if(mainPageCenter1.callTrainInfo){
                    mainPageCenter1.callTrainInfo = false;
                    GetTrainInfo getTrainInfo = new GetTrainInfo(this, true);
                    Rectangle dialogPos = getBounds();
                    getTrainInfo.setLocation(dialogPos.x + dialogPos.width / 2 - 225, dialogPos.y + dialogPos.height / 2 - 90);
                    getTrainInfo.setVisible(true);
                    JFileChooser inputImgs = new JFileChooser(lastImgPath);
                    inputImgs.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    inputImgs.showOpenDialog(this);
                    lastImgPath = inputImgs.getSelectedFile().getPath();
                    System.out.println("-1");
                    Thread progressDialog = new Thread(() -> updateProgress(getTrainInfo.iterations));
                    Thread trainThread = new Thread(() -> NetworkUntils.trainCycle(getTrainInfo.iterations,
                                                                                   getTrainInfo.saveInterval, 
                                                                                   net, inputImgs.getSelectedFiles(), 
                                                                                   inputImgs.getSelectedFile().getPath()));
                    System.out.println("0");
                    trainThread.start();
                    progressDialog.start();
                    trainProgress.setVisible(true);
                }
                Thread.sleep(100);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(NNTestEnviroment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateProgress(int total){
        while(true){
            try {
                int prog = nntest.NetworkUntils.getProgress();
                long time = nntest.NetworkUntils.getAvgTimePerIteration();
                time = (long)time / 1000; 
                
                String hours = "Hours: " + ((int)time / 3600);
                String mins = "Minutes: " + ((int)time / 60);
                
                trainProgress.setTime(hours + "  " + mins);
                trainProgress.setProgress((prog / total) * 1000);
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(NNTestEnviroment.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public NNTestEnviroment(MainPageCenter mainPageCenter1, CNNetwork net, CMenuBar cMenuBar1, JMenuItem decreaseScale, JMenu editMenu, JMenu fileMenu, JMenuItem increaseScale, JMenuItem jMenuItem1, JMenuItem jMenuItem2, JMenu previewMenu, JMenu viewMenu) throws HeadlessException {
        this.mainPageCenter1 = mainPageCenter1;
        this.net = net;
        this.cMenuBar1 = cMenuBar1;
        this.decreaseScale = decreaseScale;
        this.editMenu = editMenu;
        this.fileMenu = fileMenu;
        this.increaseScale = increaseScale;
        this.jMenuItem1 = jMenuItem1;
        this.jMenuItem2 = jMenuItem2;
        this.previewMenu = previewMenu;
        this.viewMenu = viewMenu;
    }
    
    
    public NNTestEnviroment(CNNetwork net) {
        mainPageCenter1 = new MainPageCenter(net);
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
        setLookAndFeel();
        add(mainPageCenter1, BorderLayout.CENTER);
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
