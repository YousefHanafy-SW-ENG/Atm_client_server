import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.lang.NullPointerException;
/**
 *
 * @author youssef
 */
public class ziad extends javax.swing.JFrame {
    private static ServerSocket ss;
    private static Socket s;
    private static BufferedReader br ;
    private static DataOutputStream data_output_stream;
    private static DataOutputStream data_output_stream1;
    private static DataInputStream data_input_stream;
    int balance=10000;
    int amount=0;


    
    public ziad() {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        WithdrawBtn = new javax.swing.JButton();
        DepositeBtn = new javax.swing.JButton();
        CheckBtn = new javax.swing.JButton();
        TransferBtn = new javax.swing.JButton();
        ExitBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        WithdrawBtn.setText("Withdraw");
        WithdrawBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WithdrawBtnActionPerformed(evt);
            }
        });

        DepositeBtn.setText("Deposite");
        DepositeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepositeBtnActionPerformed(evt);
            }
        });

        CheckBtn.setText("Check Balance");
        CheckBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBtnActionPerformed(evt);
            }
        });

        TransferBtn.setText("Transfore to other");
        TransferBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransferBtnActionPerformed(evt);
            }
        });

        ExitBtn.setText("Exit");
        ExitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitBtnActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(WithdrawBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TransferBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CheckBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(DepositeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addComponent(ExitBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(WithdrawBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CheckBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DepositeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TransferBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(ExitBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    try {
         String  exit="Ea";
             data_output_stream.writeUTF(exit);
         } catch (IOException ex) {
             Logger.getLogger(ziad.class.getName()).log(Level.SEVERE, null, ex);
         }
        dispose(); 
    }   
    private void WithdrawBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WithdrawBtnActionPerformed
String msg = JOptionPane.showInputDialog("Enter Withdraw Value here");
         try {
             data_output_stream.writeUTF("wo"+msg);
         } catch (IOException ex) {
             Logger.getLogger(ziad.class.getName()).log(Level.SEVERE, null, ex);
         }
          amount=Integer.parseInt(msg);
          
          if(amount<10000)
          {
      
            if (amount <= balance)
            {               
                JOptionPane.showMessageDialog(msgPanel, "You have Withdraw Successfully");
            }
             else 
            {              
                JOptionPane.showMessageDialog(msgPanel, "Insufficient balance");
            }
          }
           else
           {
                JOptionPane.showMessageDialog(msgPanel, "You cant withdraw more than 10000 EGP Try Again!!"); 
           }
         
                       // TODO add your handling code here:
    }//GEN-LAST:event_WithdrawBtnActionPerformed

    private void DepositeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepositeBtnActionPerformed
         String msg = JOptionPane.showInputDialog("Enter deposite amount");
         try {
             data_output_stream.writeUTF("do"+msg);
         } catch (IOException ex) {
             Logger.getLogger(ziad.class.getName()).log(Level.SEVERE, null, ex);
         }
                    JOptionPane.showMessageDialog(msgPanel,"ziad Deposited Successfully ");      
                                            
    }//GEN-LAST:event_DepositeBtnActionPerformed

    private void CheckBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBtnActionPerformed
      try {
             data_output_stream.writeUTF("co");
             JOptionPane.showMessageDialog(msgPanel,"Ziad Checked Balance ");
         } catch (IOException ex) {
             Logger.getLogger(ziad.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_CheckBtnActionPerformed

    private void ExitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitBtnActionPerformed
      try {
         String  exit="Eo";
             data_output_stream.writeUTF(exit);
         } catch (IOException ex) {
             Logger.getLogger(ziad.class.getName()).log(Level.SEVERE, null, ex);
         }
        dispose(); 
    }//GEN-LAST:event_ExitBtnActionPerformed

    private void TransferBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransferBtnActionPerformed
                      String msg1 = JOptionPane.showInputDialog("2 to abdelrhman\\n 3 to youssef\\n 4 to hassan");
        String msg2 = JOptionPane.showInputDialog("Amount to transfer");
         try {
             data_output_stream.writeUTF("tz"+msg1+msg2);
         } catch (IOException ex) {
             Logger.getLogger(youssef.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_TransferBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])throws IOException {
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
            java.util.logging.Logger.getLogger(ziad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ziad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ziad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ziad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ziad().setVisible(true);
            }
        });
        s = new Socket("localhost", 1111);
        data_output_stream = new DataOutputStream(s.getOutputStream());
        data_output_stream1 = new DataOutputStream(s.getOutputStream());
        data_input_stream = new DataInputStream(s.getInputStream()); 
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
          String Server_Id=JOptionPane.showInputDialog("Enter client ID");
        String Server_Password=JOptionPane.showInputDialog("Enter client Password");    
        if(Server_Id.equals("ziad")&&Server_Password.equals("1"))
            {
            JOptionPane.showMessageDialog(msgPanel, "You Successfully Logged In");
        }
        else
        {
            JOptionPane.showMessageDialog(msgPanel, "Server ID or Password in Incoreect");
        }
    }
    
    private static javax.swing.JPanel msgPanel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CheckBtn;
    private javax.swing.JButton DepositeBtn;
    private javax.swing.JButton ExitBtn;
    private javax.swing.JButton TransferBtn;
    private javax.swing.JButton WithdrawBtn;
    // End of variables declaration//GEN-END:variables
}
