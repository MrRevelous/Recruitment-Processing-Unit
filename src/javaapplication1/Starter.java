/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this  template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author BaZinGa
 */
public class Starter extends javax.swing.JFrame {

    /**
     * Creates new form Starter
     * @throws java.io.IOException
     */
    
    //here
    public Starter() throws IOException {
        this.setResizable(false);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        initComponents();
        this.setLocationRelativeTo(null);
        this.progressBar.setValue(0);
        progressBar.setStringPainted(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        progressBar = new javax.swing.JProgressBar(0,100);
        statusLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, -90, 590, -1));

        progressBar.setBackground(new java.awt.Color(0, 0, 0));
        progressBar.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(progressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 600, -1));

        statusLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        statusLabel.setForeground(new java.awt.Color(255, 255, 255));
        statusLabel.setText("Loading Components...");
        getContentPane().add(statusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 197, 22));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/recruitment-process-outsourcing.jpg"))); // NOI18N
        jLabel1.setText(" ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 600, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void createServer() throws InterruptedException
    {
        try{
            String command="startServer.bat";
            this.process = Runtime.getRuntime().exec(command);
            System.out.println(command);
        }catch (IOException ex) {
                Logger.getLogger(Starter.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=this.complete;i<50;++i){
            this.progressBar.setValue(i);
            this.complete=i;
            TimeUnit.MILLISECONDS.sleep(20);
        }
        this.statusLabel.setText("Server Started...");
    }
    
    public void startLoginFrame(){
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }
    public static void main(String args[]) throws IOException, InterruptedException {
        Starter starter=new Starter();
        starter.setVisible(true);
        for(int i=starter.complete;i<25;++i){
            starter.progressBar.setValue(i);
            starter.complete=i;
            TimeUnit.MILLISECONDS.sleep(20);
        }
        starter.statusLabel.setText("Starting Server...");
        starter.createServer();
        starter.statusLabel.setText("Loading Login Screen...");
        for(int i=starter.complete;i<75;++i){
            starter.progressBar.setValue(i);
            starter.complete=i;
            TimeUnit.MILLISECONDS.sleep(20);
        }
        for(int i=starter.complete;i<100;++i){
            starter.progressBar.setValue(i);
            starter.complete=i;
            TimeUnit.MILLISECONDS.sleep(15);
        }
        starter.startLoginFrame();
    }
    private int complete=0;
    private Process process; 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}
