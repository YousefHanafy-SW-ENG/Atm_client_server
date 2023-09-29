import java.io.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

/**
 *
 * @author youssef
 */
public class Server extends javax.swing.JFrame {
    private static ServerSocket ss;
    private static Socket s;
    private static BufferedReader br ;
    private static DataInputStream data_input_stream;
    private static DataOutputStream data_output_stream;
    private static String Msg="";
    static int Youssef_Balance=10000;
    static int Ziad_Balance=10000;
    static int Hassan_Balance=100000;
    static int Abdelrhman_Balance=10000;
    static int withdraw=0;
   static int deposite=0;
   static int transaction=0;
   static int Exchange=0;
   static int Amount=0;

      
    static void get(String login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Server() {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Simplified Arabic Fixed", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SERVER ");

        TextArea.setColumns(20);
        TextArea.setRows(5);
        jScrollPane1.setViewportView(TextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) throws IOException {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server().setVisible(true);
            }
        });
        TextArea = new JTextArea();
        ss = new ServerSocket(1111);
        br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
       
        String Server_Id=JOptionPane.showInputDialog("Enter username  (admin)");
        String Server_Password=JOptionPane.showInputDialog("Enter Server Password     (1)");    
        if(Server_Id.equals("admin")&&Server_Password.equals("1"))
        {
            JOptionPane.showMessageDialog(msgPanel, "Welcome Admin");
        s = ss.accept();
        data_input_stream = new DataInputStream(s.getInputStream());
        data_output_stream = new DataOutputStream(s.getOutputStream());
        while(true) {
    
             String sentencefromclient; 
             sentencefromclient=data_input_stream.readUTF();
             String one;
             // -----------------------------Youssef-----------------------------------
             if(sentencefromclient.charAt(0)=='w'&&sentencefromclient.charAt(1)=='m'){
                one=sentencefromclient.replace('w', '0');
                one=one.replace('m', '0');
                withdraw=Integer.parseInt(one);  
                //-------------------Youssef withdraw-----------------------------------
                 if(withdraw<10000)
        {
              if (withdraw <= Youssef_Balance)
            {
                Youssef_Balance=Youssef_Balance-withdraw;
                Msg=Msg+"Youssef Has withdraw "+withdraw+"\n"+"new balance is " +Youssef_Balance+"\n";
            }
              else
              {
                Msg=Msg+"Insufficient balance"+"\n";
              }
        }
                  else
                 {
                     Msg=Msg+"you cant withdraw more than 10000 EGP Try Again!!"+"\n";
                 }      
             }
             //-------------------Youssef deposite-----------------------------------
             else if(sentencefromclient.charAt(0)=='d'&&sentencefromclient.charAt(1)=='m')
             {                
                 one=sentencefromclient.replace('d', '0');
                 one=one.replace('m', '0');
                 deposite=Integer.parseInt(one);
                 Youssef_Balance=Youssef_Balance+deposite;
                 Msg=Msg+"Youssef Has deposited "+deposite+"\n"+"new balance is " +Youssef_Balance+"\n";  
                 
             } 
             //-------------------Youssef checkbalance-----------------------------------
             else if(sentencefromclient.charAt(0)=='c'&&sentencefromclient.charAt(1)=='m')
             {
                 Msg=Msg+"Youssef Balance ="+Youssef_Balance+"\n"; 
             }

             //-------------------Youssef transfer-----------------------------------
             else if(sentencefromclient.charAt(0)=='t'&&sentencefromclient.charAt(1)=='y')
             {  
                 one=sentencefromclient.substring(2); 
//                 25000
//                 2 abdelrhman
                 if(one.charAt(0)=='2')
                 {
                   one=one.substring(1); 
//                   5000
                   transaction=Integer.parseInt(one);
                   if(transaction<Youssef_Balance)
                   {
                   Abdelrhman_Balance=Abdelrhman_Balance+transaction;
                   Youssef_Balance=Youssef_Balance-transaction;
                   Msg=Msg+"Youssef Has Transfer "+transaction+" to abdelrhman \nabdelrhman balance is "+Abdelrhman_Balance+"\n Youssef balance is "+Youssef_Balance +"\n"; 
                   }
                 }
//               3 to   Hassan
                 else if (one.charAt(0)=='3')
                 {
                   one=one.substring(1);  
                   transaction=Integer.parseInt(one);
                   if(transaction<Youssef_Balance)
                   {
                   Hassan_Balance=Hassan_Balance+transaction;
                   Youssef_Balance=Youssef_Balance-transaction;
                   Msg=Msg+"Youssef Has Transfer "+transaction+" to Hassan "+"\n"+"and now Hassan balance is "+Hassan_Balance+"\n"+" And Youssef balance is "+Youssef_Balance+"\n"; 
                   }
                 }
//                 4 to ziad
                  else if (one.charAt(0)=='4')
                 {
                          one=one.substring(1);  
                   transaction=Integer.parseInt(one);
                   if(transaction<Youssef_Balance)
                   {
                   Ziad_Balance=Ziad_Balance+transaction;
                   Youssef_Balance=Youssef_Balance-transaction;
                   Msg=Msg+"Youssef Has Transfer "+transaction+" to Ziad "+"\n"+"and now Ziad balance is "+Ziad_Balance+"\n"+" And Youssef balance is "+Youssef_Balance+"\n"; 
                   }
                 }
             }
                 
             
             else if(sentencefromclient.charAt(0)=='E'&&sentencefromclient.charAt(1)=='m')
             {
                 Msg=Msg+"Youssef Exit From Server"+"\n"; 
             }
             //-------------------Ziad withdraw-----------------------------------
             else if(sentencefromclient.charAt(0)=='w'&&sentencefromclient.charAt(1)=='o'){
                one=sentencefromclient.replace('w', '0');
                one=one.replace('o', '0');
                withdraw=Integer.parseInt(one);  
                 if(withdraw<10000)
        {
              if (withdraw <= Ziad_Balance)
            {
                Ziad_Balance=Ziad_Balance-withdraw;
                Msg=Msg+"Ziad Has withdraw "+withdraw+"\n"+"new balance is " +Ziad_Balance+"\n";
            }
              else
              {
                Msg=Msg+"Insufficient balance"+"\n";
              }
        }
                  else
                 {
                     Msg=Msg+"you cant withdraw more than 10000 EGP Try Again!!"+"\n";
                 }      
             }
               //-------------------Ziad deposite-----------------------------------
             else if(sentencefromclient.charAt(0)=='d'&&sentencefromclient.charAt(1)=='o')
             {                
                 one=sentencefromclient.replace('d', '0');
                 one=one.replace('o', '0');
                 deposite=Integer.parseInt(one);
                 Ziad_Balance=Ziad_Balance+deposite;
                 Msg=Msg+"Ziad Has deposited "+deposite+"\n"+"new balance is " +Ziad_Balance+"\n";  
                 
             } 
               //-------------------Ziad checkbalance-----------------------------------
             else if(sentencefromclient.charAt(0)=='c'&&sentencefromclient.charAt(1)=='o')
             {
                 Msg=Msg+"Ziad Has Cheack his Balance ="+Ziad_Balance+"\n"; 
             }
              
               //-------------------Ziad transfer-----------------------------------
     else if(sentencefromclient.charAt(0)=='t'&&sentencefromclient.charAt(1)=='z')
             {  
                 one=sentencefromclient.substring(2); 
//                 25000
//                 2 abdelrhman
                 if(one.charAt(0)=='2')
                 {
                   one=one.substring(1); 
//                   5000
                   transaction=Integer.parseInt(one);
                   if(transaction<Ziad_Balance)
                   {
                   Abdelrhman_Balance=Abdelrhman_Balance+transaction;
                   Ziad_Balance=Ziad_Balance-transaction;
                   Msg=Msg+"Ziad Has Transfer "+transaction+" to abdelrhman \nabdelrhman balance is "+Abdelrhman_Balance+"\n Ziad balance is "+Ziad_Balance +"\n"; 
                   }
                 }
//               3 to   youssef       
                 else if (one.charAt(0)=='3')
                 {
                   one=one.substring(1);  
                   transaction=Integer.parseInt(one);
                   if(transaction<Hassan_Balance)
                   {
                   Youssef_Balance=Youssef_Balance+transaction;
                   Ziad_Balance=Ziad_Balance-transaction;
                   Msg=Msg+"ziad Has Transfer "+transaction+" to Youssef \nZiad balance is "+Ziad_Balance+"\nYoussef balance is "+Youssef_Balance+"\n"; 
                   }
                 }
//                 4 to hassan
                  else if (one.charAt(0)=='4')
                 {
                          one=one.substring(1);  
                   transaction=Integer.parseInt(one);
                   if(transaction<Hassan_Balance)
                   {
                   Hassan_Balance=Hassan_Balance+transaction;
                   Ziad_Balance=Ziad_Balance-transaction;
                   Msg=Msg+"Ziad Has Transfer "+transaction+" to hassan \nZiad balance is "+Ziad_Balance+"\n"+" And Hassan balance is "+Hassan_Balance+"\n"; }
                 }
             }
             
             
             else if(sentencefromclient.charAt(0)=='E'&&sentencefromclient.charAt(1)=='o')
             {
                 Msg=Msg+"Ziad Exit From Server"+"\n"; 
             }
             // Hassan
               //-------------------hassan withdraw-----------------------------------
             else if(sentencefromclient.charAt(0)=='w'&&sentencefromclient.charAt(1)=='h'){
                one=sentencefromclient.replace('w', '0');
                one=one.replace('h', '0');
                withdraw=Integer.parseInt(one);  
                 if(withdraw<10000)
        {
              if (withdraw <= Hassan_Balance)
            {
                Hassan_Balance=Hassan_Balance-withdraw;
                Msg=Msg+"Hassan Has withdraw "+withdraw+"\n"+"new balance is " +Hassan_Balance+"\n";
            }
              else
              {
                Msg=Msg+"Insufficient balance"+"\n";
              }
        }
                  else
                 {
                     Msg=Msg+"Hassan cant withdraw more than 10000 EGP Try Again!!"+"\n";
                 }      
             }
               //-------------------hassan deposite-----------------------------------
             else if(sentencefromclient.charAt(0)=='d'&&sentencefromclient.charAt(1)=='h')
             {                
                 one=sentencefromclient.replace('d', '0');
                 one=one.replace('h', '0');
                 deposite=Integer.parseInt(one);
                 Hassan_Balance=Hassan_Balance+deposite;
                 Msg=Msg+"Hassan Has deposited "+deposite+"\n"+"new balance is " +Hassan_Balance+"\n";  
                 
             } 
               //-------------------hassan checkbalance-----------------------------------
             else if(sentencefromclient.charAt(0)=='c'&&sentencefromclient.charAt(1)=='h')
             {
                 Msg=Msg+"Hassan Has Cheack his Balance ="+Hassan_Balance+"\n"; 
             }

                          else if(sentencefromclient.charAt(0)=='t'&&sentencefromclient.charAt(1)=='h')
             {  
                 one=sentencefromclient.substring(2); 
//                 //-------------------hassan transfer-----------------------------------
//                 2 abdelrhman
                 if(one.charAt(0)=='2')
                 {
                   one=one.substring(1); 
//                   5000
                   transaction=Integer.parseInt(one);
                   if(transaction<Hassan_Balance)
                   {
                   Abdelrhman_Balance=Abdelrhman_Balance+transaction;
                   Hassan_Balance=Youssef_Balance-transaction;
                   Msg=Msg+"Hassan Has Transfer "+transaction+" to abdelrhman \nabdelrhman balance is "+Abdelrhman_Balance+"\n Hassan balance is "+Hassan_Balance +"\n"; 
                   }
                 }
//               3 to   youssef         
                 else if (one.charAt(0)=='3')
                 {
                   one=one.substring(1);  
                   transaction=Integer.parseInt(one);
                   if(transaction<Hassan_Balance)
                   {
                   Youssef_Balance=Youssef_Balance+transaction;
                   Hassan_Balance=Hassan_Balance-transaction;
                   Msg=Msg+"Hassan Has Transfer "+transaction+" to Youssef "+"\n"+"and now Hassan balance is "+Hassan_Balance+"\n"+" And Youssef balance is "+Youssef_Balance+"\n"; 
                   }
                 }
//                 4 to ziad
                  else if (one.charAt(0)=='4')
                 {
                          one=one.substring(1);  
                   transaction=Integer.parseInt(one);
                   if(transaction<Hassan_Balance)
                   {
                   Ziad_Balance=Ziad_Balance+transaction;
                   Hassan_Balance=Hassan_Balance-transaction;
                   Msg=Msg+"Hassan Has Transfer "+transaction+" to ziad "+"\n"+"and now Ziad balance is "+Ziad_Balance+"\n"+" And Hassan balance is "+Hassan_Balance+"\n"; }
                 }
             }
             
             else if(sentencefromclient.charAt(0)=='E'&&sentencefromclient.charAt(1)=='h')
             {
                 Msg=Msg+"Hassan Exit From Server"+"\n"; 
             }
             // Abdelrhman
             else if(sentencefromclient.charAt(0)=='w'&&sentencefromclient.charAt(1)=='a'){
                one=sentencefromclient.replace('w', '0');
                one=one.replace('a', '0');
                withdraw=Integer.parseInt(one);  
                 if(withdraw<10000)
        {
              if (withdraw <= Abdelrhman_Balance)
            {
                Abdelrhman_Balance=Abdelrhman_Balance-withdraw;
                Msg=Msg+"Abdelrhman Has withdraw "+withdraw+"\n"+"new balance is " +Abdelrhman_Balance+"\n";
            }
              else
              {
                Msg=Msg+"Insufficient balance"+"\n";
              }
        }
                  else
                 {
                     Msg=Msg+"Abdelrhman cant withdraw more than 10000 EGP Try Again!!"+"\n";
                 }      
             }
             else if(sentencefromclient.charAt(0)=='d'&&sentencefromclient.charAt(1)=='a')
             {                
                 one=sentencefromclient.replace('d', '0');
                 one=one.replace('a', '0');
                 deposite=Integer.parseInt(one);
                 Abdelrhman_Balance=Abdelrhman_Balance+deposite;
                 Msg=Msg+"Abdelrhman Has deposited "+deposite+"\n"+"Abdelrhman balance is " +Abdelrhman_Balance+"\n";  
                 
             } 
             else if(sentencefromclient.charAt(0)=='c'&&sentencefromclient.charAt(1)=='a')
             {
                 Msg=Msg+"Abdelrhman Has Cheack his Balance ="+Abdelrhman_Balance+"\n"; 
             }

             
             else if(sentencefromclient.charAt(0)=='t'&&sentencefromclient.charAt(1)=='a')
             {  
                 one=sentencefromclient.substring(2); 
//                 25000
//                 2 ziad
                 if(one.charAt(0)=='2')
                 {
                   one=one.substring(1); 
//                   5000
                   transaction=Integer.parseInt(one);
                   if(transaction<Abdelrhman_Balance)
                   {
                   Ziad_Balance=Ziad_Balance+transaction;
                   Abdelrhman_Balance =Abdelrhman_Balance-transaction;
                   Msg=Msg+"abdelrhman Has Transfer "+transaction+" to ziad \nabdelrhman balance is "+Abdelrhman_Balance+"\n ziad balance is "+Ziad_Balance +"\n"; 
                   }
                 }
//               3 to   youssef        
                 else if (one.charAt(0)=='3')
                 {
                   one=one.substring(1);  
                   transaction=Integer.parseInt(one);
                   if(transaction<Hassan_Balance)
                   {
                   Youssef_Balance=Youssef_Balance+transaction;
                   Abdelrhman_Balance=Abdelrhman_Balance-transaction;
                   Msg=Msg+"abdelrhman Has Transfer "+transaction+" to Youssef \nabdelrhamna balance is "+Abdelrhman_Balance+"\nYoussef balance is "+Youssef_Balance+"\n"; 
                   }
                 }
//                 4 to hassan
                  else if (one.charAt(0)=='4')
                 {
                          one=one.substring(1);  
                   transaction=Integer.parseInt(one);
                   if(transaction<Hassan_Balance)
                   {
                   Abdelrhman_Balance=Abdelrhman_Balance+transaction;
                   Hassan_Balance=Hassan_Balance-transaction;
                   Msg=Msg+"abdelrhman Has Transfer "+transaction+" to hassan \nZiad balance is "+Abdelrhman_Balance+"\n"+" And Hassan balance is "+Hassan_Balance+"\n"; }
                 }
             }
             else if(sentencefromclient.charAt(0)=='E'&&sentencefromclient.charAt(1)=='m')
             {
                 Msg=Msg+"Abdelrhman Exit From Server"+"\n"; 
             }
             TextArea.setText(Msg);
           
        }
        
        
        }
        else{
             JOptionPane.showMessageDialog(msgPanel, "Server ID or Password in Incoreect");
        }
        }
        
    }
    
       
    private static javax.swing.JPanel msgPanel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextArea TextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
