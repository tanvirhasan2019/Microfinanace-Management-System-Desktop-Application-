

package microfinancemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Atel Dot Net
 */
public class HomePage extends javax.swing.JFrame {
    public Connection connection;
  //  ArrayList stars=new ArrayList();
    DefaultListModel defaultListModel=new DefaultListModel();
    private String Member;
    private int Memberid;
    boolean idExist=false;
    String Admin;
    
    
    /** Creates new form HomePage */
    public HomePage() {
        initComponents();
        this.bindData();
        
        Show_Table_Data();
    }
    
   public void setAdminName(String Admin)
   {
        this.Admin=Admin;
   }
   
 private ArrayList getStars()
{
    ArrayList stars=new ArrayList();
    
    try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=MicroFinanceManagement;selectMethod=cursor", "sa", "123456");


            Statement statement = connection.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("SELECT MemberName, MemberId FROM AdmissionForm");
            
            
            while (resultSet.next()) {
                
                Member=resultSet.getString("MemberName");
                Memberid=resultSet.getInt("MemberId");
                stars.add(Memberid+"   "+Member);

                  
            }
            
           connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    
   
return stars;
}
 
 
 
 private void bindData(){

getStars().stream().forEach((star) -> {
defaultListModel.addElement(star);
});

jList1.setModel(defaultListModel);
jList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
}
   private void searchFilter(String searchTerm)
{
DefaultListModel filteredItems=new DefaultListModel();
ArrayList stars=getStars();
stars.stream().forEach((star) -> {
String starName=star.toString().toLowerCase();
if (starName.contains(searchTerm.toLowerCase())) {
filteredItems.addElement(star);
}
});
defaultListModel=filteredItems;
jList1.setModel(defaultListModel);
}

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Deposit = new javax.swing.JButton();
        AdmissionButton = new javax.swing.JButton();
        LoanRequest = new javax.swing.JButton();
        LoanPay = new javax.swing.JButton();
        UpdateMember = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        searchMember = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        RefreshButton = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 102, 0), 4, true));
        jPanel1.setLayout(null);

        Deposit.setBackground(new java.awt.Color(204, 0, 0));
        Deposit.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        Deposit.setForeground(new java.awt.Color(255, 255, 255));
        Deposit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/microfinancemanagement/H1_D.png"))); // NOI18N
        Deposit.setText("    DEPOSIT");
        Deposit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 102, 0), 4, true));
        Deposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepositActionPerformed(evt);
            }
        });
        jPanel1.add(Deposit);
        Deposit.setBounds(20, 150, 260, 120);

        AdmissionButton.setBackground(new java.awt.Color(204, 0, 0));
        AdmissionButton.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        AdmissionButton.setForeground(new java.awt.Color(255, 255, 255));
        AdmissionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/microfinancemanagement/h_add1.png"))); // NOI18N
        AdmissionButton.setText("ADMISSION FORM");
        AdmissionButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 102, 0), 4, true));
        AdmissionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdmissionButtonActionPerformed(evt);
            }
        });
        jPanel1.add(AdmissionButton);
        AdmissionButton.setBounds(20, 20, 260, 120);

        LoanRequest.setBackground(new java.awt.Color(204, 0, 0));
        LoanRequest.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        LoanRequest.setForeground(new java.awt.Color(255, 255, 255));
        LoanRequest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/microfinancemanagement/H1_LOAN.png"))); // NOI18N
        LoanRequest.setText("  LOAN REQUEST");
        LoanRequest.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 102, 0), 4, true));
        LoanRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoanRequestActionPerformed(evt);
            }
        });
        jPanel1.add(LoanRequest);
        LoanRequest.setBounds(20, 280, 260, 120);

        LoanPay.setBackground(new java.awt.Color(204, 0, 0));
        LoanPay.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        LoanPay.setForeground(new java.awt.Color(255, 255, 255));
        LoanPay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/microfinancemanagement/h1_payemnt.png"))); // NOI18N
        LoanPay.setText("      PAYEMENT");
        LoanPay.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 102, 0), 4, true));
        LoanPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoanPayActionPerformed(evt);
            }
        });
        jPanel1.add(LoanPay);
        LoanPay.setBounds(20, 410, 260, 120);

        UpdateMember.setBackground(new java.awt.Color(204, 0, 0));
        UpdateMember.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        UpdateMember.setForeground(new java.awt.Color(255, 255, 255));
        UpdateMember.setIcon(new javax.swing.ImageIcon(getClass().getResource("/microfinancemanagement/h1_setting.png"))); // NOI18N
        UpdateMember.setText("   SETTING");
        UpdateMember.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 102, 0), 4, true));
        UpdateMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateMemberActionPerformed(evt);
            }
        });
        jPanel1.add(UpdateMember);
        UpdateMember.setBounds(20, 540, 260, 120);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 0, 300, 690);

        jPanel3.setBackground(new java.awt.Color(0, 153, 204));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 102, 0), 3, true));
        jPanel3.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        jLabel1.setText("MICROFINANCE MANAGEMENT SYSTEM");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(120, 0, 870, 70);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(310, 0, 1050, 70);

        jPanel5.setBackground(new java.awt.Color(0, 153, 204));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 102, 0), 3, true));
        jPanel5.setLayout(null);

        searchMember.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        searchMember.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        searchMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchMemberActionPerformed(evt);
            }
        });
        searchMember.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchMemberKeyReleased(evt);
            }
        });
        jPanel5.add(searchMember);
        searchMember.setBounds(30, 50, 380, 50);

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SEARCH MEMBER ");
        jPanel5.add(jLabel2);
        jLabel2.setBounds(130, 10, 250, 40);

        jList1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 102, 0), 4, true));
        jList1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel5.add(jScrollPane1);
        jScrollPane1.setBounds(30, 100, 380, 490);

        getContentPane().add(jPanel5);
        jPanel5.setBounds(930, 80, 430, 610);

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 3, 24)); // NOI18N
        jLabel3.setText("PAYEMENT RESIDUE TODAY");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(480, 90, 360, 60);

        jTable1.setBackground(new java.awt.Color(204, 204, 255));
        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MEMBER ID", "MEMBER NAME", "LOAN", "DEPOSIT", "PHONE NUMBER"
            }
        ));
        jTable1.setRowHeight(30);
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(330, 160, 590, 530);

        RefreshButton.setBackground(new java.awt.Color(0, 153, 204));
        RefreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/microfinancemanagement/refresh-page-option.png"))); // NOI18N
        RefreshButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshButtonActionPerformed(evt);
            }
        });
        getContentPane().add(RefreshButton);
        RefreshButton.setBounds(330, 90, 110, 60);

        setSize(new java.awt.Dimension(1378, 765));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void UpdateMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateMemberActionPerformed
        // TODO add your handling code here:
     /*   String Mname = JOptionPane.showInputDialog("PLEASE ENTER MEMBER ID ");
        MemberIDExist(Mname);
        
        if(idExist==true)
        {
            idExist=false;
            MemberInfo obj=new MemberInfo();
            int MemberInfoId=Integer.parseInt(Mname);
            obj.Member(MemberInfoId);
            obj.setVisible(true);
        }
     //   System.out.println(Mname);  */
     
     Setting obj=new Setting();
     obj.setVisible(true);
       
    }//GEN-LAST:event_UpdateMemberActionPerformed

    private void AdmissionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdmissionButtonActionPerformed
        // TODO add your handling code here:
        AdmissionForm obj=new AdmissionForm();
        obj.setVisible(true);
    }//GEN-LAST:event_AdmissionButtonActionPerformed

    private void LoanPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoanPayActionPerformed
        // TODO add your handling code here:
     /*   String Mname = JOptionPane.showInputDialog("PLEASE ENTER MEMBER ID ");
        MemberIDExist(Mname);
        
        if(idExist==true)
        {
            idExist=false;
            LoanPay obj=new LoanPay();
            int MemberInfoId=Integer.parseInt(Mname);
            obj.Member(MemberInfoId);
            obj.setVisible(true);
        }
        */
      LoanPay obj=new LoanPay();
      obj.setVisible(true);

    }//GEN-LAST:event_LoanPayActionPerformed

    private void searchMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchMemberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchMemberActionPerformed

    private void searchMemberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchMemberKeyReleased
        // TODO add your handling code here:
         searchFilter(searchMember.getText());
    }//GEN-LAST:event_searchMemberKeyReleased

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        // TODO add your handling code here:
        String selct=jList1.getSelectedValue().toString();
       // System.out.println(selct);
       
       //char s1[]=new char[10];
       //char s2[]=new char[30];
       
        Vector<Character> s1 = new Vector<Character>(); 
        Vector<Character> s2 = new Vector<Character>(); 
        // Use add() method to add elements into the Vector 
       // vec_tor.add(10); 

       int i=0;
       char wt;
       
       for(i=0; i<selct.length(); i++)
       {
            wt=selct.charAt(i);
            // char c='a';
            if(Character.isWhitespace(wt)==false)
            {
                  s1.add(selct.charAt(i));                
            } 
            else if(Character.isWhitespace(wt)==true)
            {
               // s1[i]=selct.charAt(i);
                i=i+3;
                break;
                
            } 
           // s1[i]=selct.charAt(i);
       }
       
       int l=0;
       for(int k=i+0; k<selct.length(); k++)
       {
           s2.add(selct.charAt(k));
           l++;
       }
     /*  for(int m=0; m<30; m++)
       {
           System.out.println(s1[m]+"  "+s2[m]);
       }
       */
     
   //  Character[] array1 = s1.toArray(new Character[s1.size()]);
    // Character[] array2 = s2.toArray(new Character[s2.size()]);
    int size1=s1.size();
    int size2=s2.size();
    
    char ss1[]=new char[size1];
    char ss2[]=new char[size2];
    
    
    for(i=0; i<size1; i++)
    {
        ss1[i]=s1.get(i);
    }
    
    for(i=0; i<size2; i++)
    {
        ss2[i]=s2.get(i);
    }
     
      //System.out.println("hellow");
      String st1=new String(ss1);
   //  String bt=st1;
      String st2=new String(ss2);
    
      //System.out.println(st1);
      //System.out.println(st2);
      
     // System.out.println(st1.length());
     // System.out.println(st2.length());

       Integer result1 = Integer.valueOf(st1);
     //  System.out.println(result1);
      
      //  JOptionPane.showMessageDialog(rootPane,jList1.getSelectedValue(), "Selected Member", JOptionPane.INFORMATION_MESSAGE);
    
         MemberInfo obj=new MemberInfo();
         obj.Member(result1);
         obj.setVisible(true);
      
        
    }//GEN-LAST:event_jList1MouseClicked

    private void LoanRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoanRequestActionPerformed
        // TODO add your handling code here:
        
        String Mname = JOptionPane.showInputDialog("PLEASE ENTER MEMBER ID ");
        MemberIDExist(Mname);
        
        if(idExist==true)
        {
            idExist=false;
            LoanRequest obj=new LoanRequest();
            int LName=Integer.parseInt(Mname);
            obj.Member(LName);
            obj.setAdminName(Admin);
            obj.setVisible(true);
        }
       
        
    }//GEN-LAST:event_LoanRequestActionPerformed

    private void DepositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepositActionPerformed
        // TODO add your handling code here:
        Deposit obj=new Deposit();
        obj.setAdminName(Admin);
        obj.setVisible(true);
    }//GEN-LAST:event_DepositActionPerformed

    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshButtonActionPerformed
        // TODO add your handling code here:
        Show_Table_Data();
    }//GEN-LAST:event_RefreshButtonActionPerformed

    public void MemberIDExist(String id)
    {
        int id1=Integer.parseInt(id);
       
         try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=MicroFinanceManagement;selectMethod=cursor", "sa", "123456");


            Statement statement = connection.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("SELECT MemberId FROM AdmissionForm WHERE MemberId="+id1);
            
            
            while (resultSet.next()) {
                
               idExist=true;
            }
            
         
            if(idExist==false)
            {
                JOptionPane.showMessageDialog(null, "PLEASE ENTER VALID MEMBER ID");
            }
            
           connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void Show_Table_Data()
    {
        
        
 /*      String sql="SELECT AdmissionForm.MemberName, AdmissionForm.MobileNo, AdmissionForm.MemberId FROM AdmissionForm\n" +
"WHERE AdmissionForm.MemberId IN (SELECT INSTALLMENT1.MemberId FROM INSTALLMENT1 WHERE INSTALLMENT1.Status='UNCLEAR'\n" +
" AND INSTALLMENT1.MemberId_ApplyDate NOT IN(SELECT INSTALLMENT.MemberId_ApplyDate FROM INSTALLMENT WHERE INSTALLMENT.Paydate==CAST( GETDATE() AS date )))";
       
  */     
       
String sql2="SELECT AdmissionForm.MemberName, AdmissionForm.MobileNo, AdmissionForm.MemberId FROM AdmissionForm WHERE AdmissionForm.MemberId IN (SELECT INSTALLMENT1.MemberId FROM INSTALLMENT1 WHERE INSTALLMENT1.Status= 'UNCLEAR'  AND INSTALLMENT1.MemberId_ApplyDate NOT IN(SELECT INSTALLMENT.MemberId_ApplyDate FROM INSTALLMENT WHERE INSTALLMENT.Paydate=CAST( GETDATE() AS date )))";
       try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             Connection connection = DriverManager.getConnection(
                     "jdbc:sqlserver://localhost:1433;databaseName=MicroFinanceManagement;selectMethod=cursor", "sa", "123456");


            Statement statement = connection.createStatement();
          //  String sql="SELECT Amount,PayementDay,EntryBy  FROM DEPOSIT WHERE MemberId="+id;
            
            ResultSet resultSet = statement
                    .executeQuery(sql2);
            
            
           String[] columnNames = {"NO","MEMBER ID", "MEMBER NAME","MOBILE NO"};
           DefaultTableModel model = new DefaultTableModel();
           model.setColumnIdentifiers(columnNames);
           
           jTable1.setModel(model);
            
           
            int i=1;
            
            while (resultSet.next()) {
               
               int ID=resultSet.getInt("MemberId");
               String Name =resultSet.getString("MemberName");
               String Phone =resultSet.getString("MobileNo");

              // float Amount= resultSet.getFloat("Amount");
          
               model.addRow(new Object[]{i, ID, Name, Phone});
               i++;
               
            
            }
          
            
            connection.close();
                
        } catch (Exception e) {
            e.printStackTrace();
        }
         
    
        
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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdmissionButton;
    private javax.swing.JButton Deposit;
    private javax.swing.JButton LoanPay;
    private javax.swing.JButton LoanRequest;
    private javax.swing.JButton RefreshButton;
    private javax.swing.JButton UpdateMember;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField searchMember;
    // End of variables declaration//GEN-END:variables

}
