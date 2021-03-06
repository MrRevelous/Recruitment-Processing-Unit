/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;

/**
 *
 * @author BaZinGa
 */
public class PaymentGateway extends javax.swing.JFrame {

    /**
     * Creates new form PaymentGateway
     * @param companyName
     */
    public PaymentGateway(String companyName) {
        initComponents();
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.companyName=companyName;
        this.companyLabel.setText(this.companyName);
        this.arrayListJPanles=new ArrayList<>();
        this.setSize(830,507);
        this.setLocationRelativeTo(null);
        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(this.creditcardRadioButton);
        buttonGroup.add(this.debitCardRadioButton);
        buttonGroup.add(this.netBankingRadioButton);
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
        creditcardRadioButton = new javax.swing.JRadioButton();
        debitCardRadioButton = new javax.swing.JRadioButton();
        netBankingRadioButton = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        paymentPane = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        companyLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 204, 255));

        jLayeredPane1.setBackground(new java.awt.Color(0, 204, 204));
        jLayeredPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        creditcardRadioButton.setText("Credit Card");
        creditcardRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditcardRadioButtonActionPerformed(evt);
            }
        });

        debitCardRadioButton.setText("Debit Card");
        debitCardRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debitCardRadioButtonActionPerformed(evt);
            }
        });

        netBankingRadioButton.setText("Net Banking");
        netBankingRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                netBankingRadioButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Select Payment Method");

        jLayeredPane1.setLayer(creditcardRadioButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(debitCardRadioButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(netBankingRadioButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(netBankingRadioButton)
                    .addComponent(debitCardRadioButton)
                    .addComponent(creditcardRadioButton))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(creditcardRadioButton)
                .addGap(18, 18, 18)
                .addComponent(debitCardRadioButton)
                .addGap(18, 18, 18)
                .addComponent(netBankingRadioButton)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        paymentPane.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout paymentPaneLayout = new javax.swing.GroupLayout(paymentPane);
        paymentPane.setLayout(paymentPaneLayout);
        paymentPaneLayout.setHorizontalGroup(
            paymentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        paymentPaneLayout.setVerticalGroup(
            paymentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("One More Step...");

        companyLabel.setFont(new java.awt.Font("NSimSun", 3, 18)); // NOI18N
        companyLabel.setForeground(new java.awt.Color(0, 0, 204));
        companyLabel.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(paymentPane)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(companyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(275, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                    .addComponent(companyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(paymentPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void creditcardRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditcardRadioButtonActionPerformed
        // TODO add your handling code here:
        this.hideOtherPanels();
        CreditCardPanel creditCardPanel=new CreditCardPanel(this,this.companyName);
        this.arrayListJPanles.add(creditCardPanel);
        creditCardPanel.setBounds(10,20,350,450);
        paymentPane.add(creditCardPanel);
        paymentPane.revalidate();
        paymentPane.repaint();
    }//GEN-LAST:event_creditcardRadioButtonActionPerformed

    private void debitCardRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_debitCardRadioButtonActionPerformed
        // TODO add your handling code here:
        this.hideOtherPanels();
        DebitCardPanel debitCardPanel=new DebitCardPanel(this,this.companyName);
        this.arrayListJPanles.add(debitCardPanel);
        debitCardPanel.setBounds(10,20,580,390);
        paymentPane.add(debitCardPanel);
        paymentPane.revalidate();
        paymentPane.repaint();
    }//GEN-LAST:event_debitCardRadioButtonActionPerformed

    private void netBankingRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_netBankingRadioButtonActionPerformed
        // TODO add your handling code here:
        this.hideOtherPanels();
        NetBankingPanel netBankingPanel =new NetBankingPanel(this,this.companyName);
        this.arrayListJPanles.add(netBankingPanel);
        netBankingPanel.setBounds(10,20,580,390);
        paymentPane.add(netBankingPanel);
        paymentPane.revalidate();
        paymentPane.repaint();
        
    }//GEN-LAST:event_netBankingRadioButtonActionPerformed

    /**
     */
    protected void hideOtherPanels(){
        Iterator<JPanel> itr=arrayListJPanles.iterator();
        while(itr.hasNext()){
            JPanel jPanel=itr.next();
            jPanel.setVisible(false);
            this.remove(jPanel);
        }
    }
    private String companyName;
    private ArrayList<JPanel> arrayListJPanles;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel companyLabel;
    private javax.swing.JRadioButton creditcardRadioButton;
    private javax.swing.JRadioButton debitCardRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JRadioButton netBankingRadioButton;
    private javax.swing.JLayeredPane paymentPane;
    // End of variables declaration//GEN-END:variables
}
