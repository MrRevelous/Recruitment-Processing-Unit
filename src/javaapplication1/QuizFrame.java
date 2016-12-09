/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import com.mongodb.*;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
/**
 *
 * @author Dell
 */
public class QuizFrame extends javax.swing.JFrame {

    /**
     * Creates new form QuizFrame
    */
    
    String name; String email; String quizname;
    private int currentQuestion=0; 
    String answers[]=new String[10];
    String ActualAnswers[]=new String[10];
    QuestionsPanel[] questions=new QuestionsPanel[10];
    private float total=0.0f;
    public QuizFrame() {
        initComponents();
        this.setSize(1200,1200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }
    
    public void decideWhichTest(String testname,String email)
    {
        
        int i=0; this.quizname=testname;
        try (MongoClient mongoClient = new MongoClient("localhost",27017)) {
            DB db=mongoClient.getDB("rpu");
            switch(testname)
            {
                case "qlr": jLabel1.setText("Basic QLR Test");
                DBCollection coll=db.getCollection("qlrquiz");
                DBCursor cursor=coll.find();
                while(cursor.hasNext())
                {
                    DBObject dbo=cursor.next();
                    questions[i]=new QuestionsPanel();
                    this.add(questions[i]);
                    questions[i].setBounds(10, 40, 1100, 1100);
                    questions[i].QuestionLabel.setText((String)dbo.get("question"));
                    questions[i].OptionALabel.setText((String)dbo.get("optA"));
                    questions[i].OptionBLabel.setText((String)dbo.get("optB"));
                    questions[i].OptionCLabel.setText((String)dbo.get("optC"));
                    questions[i].OptionDLabel.setText((String)dbo.get("optD"));
                    ActualAnswers[i]=(String)dbo.get("answer");
                    i++;
                }
                total=--i;
                cursor.close();
                break; 
                case "cjava": jLabel1.setText("Basic CORE JAVA Test");
                DBCollection coll1=db.getCollection("cjavaquiz");
                DBCursor cursor1=coll1.find();
                while(cursor1.hasNext())
                {
                    DBObject dbo=cursor1.next();
                    questions[i]=new QuestionsPanel();
                    this.add(questions[i]);
                    questions[i].setBounds(10, 40, 1100, 1100);
                    questions[i].QuestionLabel.setText((String)dbo.get("question"));
                    questions[i].OptionALabel.setText((String)dbo.get("optA"));
                    questions[i].OptionBLabel.setText((String)dbo.get("optB"));
                    questions[i].OptionCLabel.setText((String)dbo.get("optC"));
                    questions[i].OptionDLabel.setText((String)dbo.get("optD"));
                    ActualAnswers[i]=(String)dbo.get("answer");
                    i++;
                    
                }
                total=--i;
                cursor1.close();
                break;
                case "frame": jLabel1.setText("Frameworks Test");
                DBCollection coll2=db.getCollection("framequiz");
                DBCursor cursor2=coll2.find();
                while(cursor2.hasNext())
                {
                    DBObject dbo=cursor2.next();
                    questions[i]=new QuestionsPanel();
                    this.add(questions[i]);
                    questions[i].setBounds(10, 40, 1100, 1100);
                    questions[i].QuestionLabel.setText((String)dbo.get("question"));
                    questions[i].OptionALabel.setText((String)dbo.get("optA"));
                    questions[i].OptionBLabel.setText((String)dbo.get("optB"));
                    questions[i].OptionCLabel.setText((String)dbo.get("optC"));
                    questions[i].OptionDLabel.setText((String)dbo.get("optD"));
                    ActualAnswers[i]=(String)dbo.get("answer");
                    i++;
                    
                }
                total=--i;
                cursor2.close();
                break;
                case "android": jLabel1.setText("Android Test");
                DBCollection coll3=db.getCollection("andquiz");
                DBCursor cursor3=coll3.find();
                while(cursor3.hasNext())
                {
                    DBObject dbo=cursor3.next();
                    questions[i]=new QuestionsPanel();
                    this.add(questions[i]);
                    questions[i].setBounds(10, 40, 1100, 1100);
                    questions[i].QuestionLabel.setText((String)dbo.get("question"));
                    questions[i].OptionALabel.setText((String)dbo.get("optA"));
                    questions[i].OptionBLabel.setText((String)dbo.get("optB"));
                    questions[i].OptionCLabel.setText((String)dbo.get("optC"));
                    questions[i].OptionDLabel.setText((String)dbo.get("optD"));
                    ActualAnswers[i]=(String)dbo.get("answer");
                    i++;
                    
                }
                total=--i;
                cursor3.close();
                break;
                default: System.out.println("Error 1");
            } this.email=email;
        }
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AnswerGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        PreviousButton = new javax.swing.JButton();
        NextButton = new javax.swing.JButton();
        SubmitButton = new javax.swing.JButton();
        StartTestButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("NSimSun", 0, 18)); // NOI18N
        jLabel1.setText("Basic QLR Test");

        PreviousButton.setText("Previous");
        PreviousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousButtonActionPerformed(evt);
            }
        });

        NextButton.setText("Next");
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonActionPerformed(evt);
            }
        });

        SubmitButton.setText("Submit");
        SubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitButtonActionPerformed(evt);
            }
        });

        StartTestButton.setText("Start Test");
        StartTestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartTestButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(StartTestButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(PreviousButton)
                        .addGap(18, 18, 18)
                        .addComponent(NextButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                        .addComponent(SubmitButton)))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StartTestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PreviousButton)
                    .addComponent(NextButton)
                    .addComponent(SubmitButton))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
                if(currentQuestion<total)
                {
                    questions[currentQuestion].setVisible(false);
                    currentQuestion++;
                    questions[currentQuestion].setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "End of Questions");
                }
                // TODO add your handling code here:
                
    }//GEN-LAST:event_NextButtonActionPerformed

    private void PreviousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousButtonActionPerformed
                if(currentQuestion>0)
                {
                    questions[currentQuestion].setVisible(false);
                    currentQuestion--;
                    questions[currentQuestion].setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "End of Questions");
                }
              
    }//GEN-LAST:event_PreviousButtonActionPerformed

    private void StartTestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartTestButtonActionPerformed
            StartTestButton.setVisible(false);
            questions[0].setBounds(10, 40, 1100, 1100);
            questions[0].setVisible(true);
            
            
            
    }//GEN-LAST:event_StartTestButtonActionPerformed

    private void SubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitButtonActionPerformed
        int i=0;
        float right=0.0f;
        while(i<=total)
        {
        for (Enumeration<AbstractButton> buttons = questions[i].OptionButtons.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                answers[i]=button.getLabel();
            }
        }
        i++;
        }
        for(i=0;i<=total;i++)
        {
            System.out.println("\t"+answers[i]);
            if(ActualAnswers[i].equals(answers[i]))
            {
                right++;
            }
        }
        total++;
        
        System.out.println(right);
        System.out.println(total);
        float perc=(right/total)*100;
        System.out.println(perc);
        try(MongoClient mongoClient = new MongoClient("localhost",27017)) 
        {
            DB db=mongoClient.getDB("rpu");
            switch(quizname)
            {
                case "qlr":DBCollection coll=db.getCollection("qlrresult");
                            BasicDBObject dbo=new BasicDBObject().append("EmailID",this.email);
                            dbo.append("Percentage",perc);
                            coll.insert(dbo);
                            break;
                case "cjava":DBCollection coll1=db.getCollection("cjavaresult");
                             BasicDBObject dbo1=new BasicDBObject().append("EmailID",this.email);
                            dbo1.append("Percentage",perc);
                            coll1.insert(dbo1);
                            break;
                 case "frame":DBCollection coll2=db.getCollection("frameresult");
                             BasicDBObject dbo2=new BasicDBObject().append("EmailID",this.email);
                            dbo2.append("Percentage",perc);
                            coll2.insert(dbo2);
                            break;
                  case "android":DBCollection coll3=db.getCollection("andresult");
                             BasicDBObject dbo3=new BasicDBObject().append("EmailID",this.email);
                            dbo3.append("Percentage",perc);
                            coll3.insert(dbo3);
                            break;
            }       
            DBCursor cursor=db.getCollection("candidatelogin").find(new BasicDBObject().append("EmailID",this.email));
            name=(String)cursor.next().get("First_Name");
            cursor.close();
                 
            JOptionPane.showMessageDialog(this, "Thank you. Your Result will be displayed.");
            this.setVisible(false);
            this.dispose();
            CandidateMainPage m1=new CandidateMainPage();
            m1.setCandidateName(name,email);
            m1.setVisible(true);
        }
        catch(Exception e){}
          // TODO add your handling code here:
    }//GEN-LAST:event_SubmitButtonActionPerformed

    /**
     * @param args the command line arguments
     */
   /* public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuizFrame().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup AnswerGroup;
    private javax.swing.JButton NextButton;
    private javax.swing.JButton PreviousButton;
    private javax.swing.JButton StartTestButton;
    private javax.swing.JButton SubmitButton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
