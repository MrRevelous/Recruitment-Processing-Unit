/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class CompanyLoginPage extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     * @param parentFrame
     */
    public CompanyLoginPage(LoginScreen parentFrame) {
        initComponents();
        this.parentFrame=parentFrame;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        CompanyIDLabel = new javax.swing.JLabel();
        CompanyIDTextField = new javax.swing.JTextField();
        CompanyPasswordLabel = new javax.swing.JLabel();
        CompanyPasswordField = new javax.swing.JPasswordField();
        CompanyLoginButton = new javax.swing.JButton();
        CompanyResetButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setLayout(null);

        CompanyIDLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        CompanyIDLabel.setForeground(new java.awt.Color(255, 255, 255));
        CompanyIDLabel.setLabelFor(CompanyIDTextField);
        CompanyIDLabel.setText("Enter Company ID:");
        add(CompanyIDLabel);
        CompanyIDLabel.setBounds(167, 145, 190, 40);

        CompanyIDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompanyIDTextFieldActionPerformed(evt);
            }
        });
        add(CompanyIDTextField);
        CompanyIDTextField.setBounds(360, 150, 240, 30);

        CompanyPasswordLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        CompanyPasswordLabel.setForeground(new java.awt.Color(204, 204, 204));
        CompanyPasswordLabel.setLabelFor(CompanyPasswordField);
        CompanyPasswordLabel.setText("Enter Password:");
        add(CompanyPasswordLabel);
        CompanyPasswordLabel.setBounds(187, 216, 170, 40);
        add(CompanyPasswordField);
        CompanyPasswordField.setBounds(361, 223, 240, 30);

        CompanyLoginButton.setFont(new java.awt.Font("Nyala", 0, 24)); // NOI18N
        CompanyLoginButton.setText("Login");
        CompanyLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompanyLoginButtonActionPerformed(evt);
            }
        });
        add(CompanyLoginButton);
        CompanyLoginButton.setBounds(206, 287, 115, 37);

        CompanyResetButton.setFont(new java.awt.Font("Nyala", 0, 24)); // NOI18N
        CompanyResetButton.setText("Reset");
        add(CompanyResetButton);
        CompanyResetButton.setBounds(457, 287, 103, 37);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/haribhai.jpg"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 790, 500);
    }// </editor-fold>//GEN-END:initComponents

    private void CompanyIDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompanyIDTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CompanyIDTextFieldActionPerformed

    private void CompanyLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompanyLoginButtonActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        String company_name=null,accountType=null,accountStatus=null;
        boolean login_flag=false;
        try(MongoClient mongoClient=new MongoClient("localhost",27017)){
            DB db=mongoClient.getDB("rpu");
            DBCollection dBCollection=db.getCollection("AllRegisteredCompanies");
            BasicDBObject basicDBObject=new BasicDBObject("username",this.CompanyIDTextField.getText());
            basicDBObject.append("password",CompanyPasswordField.getText());
            try(DBCursor dBCursor=dBCollection.find(basicDBObject)){
                if(dBCursor.hasNext()){
                    DBObject dBObject=dBCursor.next();
                    System.out.println(dBObject.toString());
                    company_name=(String)dBObject.get("company_name");
                    accountType=(String)dBObject.get("accountType");
                    login_flag=true;
                }
            }
            if(accountType!=null){
                if(accountType.equals("Paid")){
                    dBCollection=db.getCollection("payments");
                    basicDBObject=new BasicDBObject("CompanyName",company_name);
                    String dateofExpiryStr=null;
                    try(DBCursor dBCursor=dBCollection.find(basicDBObject)){            
                        if(dBCursor.hasNext()){
                            DBObject dBObject=dBCursor.next();
                            System.out.println(dBObject.toString());
                            dateofExpiryStr=(String)dBObject.get("dateofExpiry");
                        }
                    }
                    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd:MM:yyyy");
                    Date todaysdate=new Date();
                    String todaysdateStr=simpleDateFormat.format(todaysdate);
                    todaysdate = (Date)simpleDateFormat.parse(todaysdateStr);
                    Date dateofExpiry=new Date();
                    dateofExpiry=(Date)simpleDateFormat.parse(dateofExpiryStr);
                    if(!(dateofExpiry.compareTo(todaysdate)==1)){
                        System.out.println(dateofExpiry.toString());
                        dBCollection.remove(basicDBObject);
                        dBCollection=db.getCollection("AllRegisteredCompanies");
                        basicDBObject=new BasicDBObject("$set",new BasicDBObject("accountType","Free"));
                        BasicDBObject findBy=new BasicDBObject("company_name",company_name);
                        dBCollection.update(findBy, basicDBObject);
                        accountStatus="Expired";
                        accountType="Free";
                    }
                }
            }
            if(login_flag==true){
                JOptionPane.showMessageDialog(this.parentFrame, "Welcome "+company_name);
                CompanyPage companyPage=new CompanyPage(company_name,accountStatus,accountType);
                companyPage.setVisible(true);
                this.setVisible(false);
                this.parentFrame.setVisible(false);
                this.parentFrame.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this.parentFrame,"Incorrect Username/Password!!!");
            }
        }catch(ParseException | HeadlessException E){
            E.getMessage();
        }
    }//GEN-LAST:event_CompanyLoginButtonActionPerformed

    private final LoginScreen parentFrame;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CompanyIDLabel;
    private javax.swing.JTextField CompanyIDTextField;
    private javax.swing.JButton CompanyLoginButton;
    private javax.swing.JPasswordField CompanyPasswordField;
    private javax.swing.JLabel CompanyPasswordLabel;
    private javax.swing.JButton CompanyResetButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
