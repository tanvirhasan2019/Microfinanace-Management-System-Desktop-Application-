/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microfinancemanagement;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Base64;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Atel Dot Net
 */
public class MemberInfo extends javax.swing.JFrame {
    
    private BufferedImage chosen_picture;
    private String filename=null;
    private byte[]personimage=null;
    public Connection connection;
    private String Member;
    public int Memberid;
    
    ByteArrayOutputStream baos = null;
    ByteArrayInputStream bais = null;

    public MemberInfo() {
         initComponents();
        
        
    }

    public void Member(int id)
    {
        this.Member=Member;
        this.Memberid=id;
        MemberidLabel.setText("Member Id: "+Memberid);
        
        System.out.println(Memberid);
        
          try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=MicroFinanceManagement;selectMethod=cursor", "sa", "123456");


            Statement statement = connection.createStatement();
            String sql="SELECT * FROM AdmissionForm WHERE MemberId="+Memberid;
            //System.out.println(sql);
            ResultSet resultSet = statement
                    .executeQuery(sql);
            
          //  String sql="SELECT * FROM AdmissionForm WHERE MemberId=?";
            
           
            while (resultSet.next()) {
        
                MemberName.setText(resultSet.getString("MemberName"));
                MobileNo.setText(resultSet.getString("MobileNo"));
                MotherName.setText(resultSet.getString("MotherName"));
                NationalId.setText(resultSet.getString("NationalId"));
                Occupation.setText(resultSet.getString("Occupation"));
                PermanentAddress.setText(resultSet.getString("PermanentAddress"));
                Presentaddress.setText(resultSet.getString("Presentaddress"));
                Religious.setText(resultSet.getString("Religious"));
                Nationality.setText(resultSet.getString("Nationality"));
                FatherorHusbandName.setText(resultSet.getString("FatherorHusbandName"));
               Gender.setSelectedItem("Gender");
               InputStream in = resultSet.getBinaryStream("MemberImage");
               Image image = ImageIO.read(in);
               Image newimg = image.getScaledInstance(270, 220,  java.awt.Image.SCALE_SMOOTH);
               ImageIcon icon=new ImageIcon(newimg);

                memberimagelabel.setIcon(icon);
                memberimagelabel.revalidate();
                memberimagelabel.revalidate();
                

                  
            }
            System.out.println("ResulsetCmplete");
            connection.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
  
       
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        MemberidLabel = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        MemberName = new javax.swing.JTextField();
        labelGender = new javax.swing.JLabel();
        Gender = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        FatherorHusbandName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        MotherName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Presentaddress = new javax.swing.JTextField();
        PermanentAddress = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        UpdateButton = new javax.swing.JButton();
        memberimagelabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Occupation = new javax.swing.JTextField();
        MobileNo = new javax.swing.JTextField();
        Nationality = new javax.swing.JTextField();
        Religious = new javax.swing.JTextField();
        NationalId = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        InsertImageButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(610, 290, 0, 230);

        jPanel2.setBackground(new java.awt.Color(153, 0, 153));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        MemberidLabel.setFont(new java.awt.Font("Footlight MT Light", 1, 48)); // NOI18N
        MemberidLabel.setForeground(new java.awt.Color(255, 255, 255));
        MemberidLabel.setText("Member Id :");
        jPanel2.add(MemberidLabel);
        MemberidLabel.setBounds(70, 190, 560, 70);

        jLabel12.setFont(new java.awt.Font("Footlight MT Light", 3, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("MEMBER NAME :");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(60, 290, 160, 40);

        MemberName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        MemberName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MemberName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MemberNameActionPerformed(evt);
            }
        });
        jPanel2.add(MemberName);
        MemberName.setBounds(330, 290, 340, 40);

        labelGender.setFont(new java.awt.Font("Footlight MT Light", 3, 18)); // NOI18N
        labelGender.setForeground(new java.awt.Color(255, 255, 255));
        labelGender.setText("GENDER :");
        jPanel2.add(labelGender);
        labelGender.setBounds(60, 360, 150, 40);

        Gender.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MALE", "FEMALE", "OTHERS" }));
        Gender.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenderActionPerformed(evt);
            }
        });
        jPanel2.add(Gender);
        Gender.setBounds(330, 350, 340, 40);

        jLabel4.setFont(new java.awt.Font("Footlight MT Light", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("FATHER /HUSBAND  NAME :");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(60, 410, 260, 50);

        FatherorHusbandName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        FatherorHusbandName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        FatherorHusbandName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FatherorHusbandNameActionPerformed(evt);
            }
        });
        jPanel2.add(FatherorHusbandName);
        FatherorHusbandName.setBounds(330, 410, 340, 40);

        jLabel5.setFont(new java.awt.Font("Footlight MT Light", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("MOTHER  NAME :");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(60, 470, 190, 50);

        MotherName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        MotherName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(MotherName);
        MotherName.setBounds(330, 470, 340, 40);

        jLabel6.setFont(new java.awt.Font("Footlight MT Light", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("PRESENT ADDRESS :");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(60, 530, 190, 50);

        Presentaddress.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Presentaddress.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Presentaddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PresentaddressActionPerformed(evt);
            }
        });
        jPanel2.add(Presentaddress);
        Presentaddress.setBounds(330, 530, 340, 40);

        PermanentAddress.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        PermanentAddress.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PermanentAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PermanentAddressActionPerformed(evt);
            }
        });
        jPanel2.add(PermanentAddress);
        PermanentAddress.setBounds(330, 590, 340, 40);

        jLabel7.setFont(new java.awt.Font("Footlight MT Light", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("PERMANENT ADDRESS :");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(60, 590, 230, 40);

        UpdateButton.setBackground(new java.awt.Color(0, 51, 204));
        UpdateButton.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        UpdateButton.setForeground(new java.awt.Color(255, 255, 255));
        UpdateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/microfinancemanagement/update_64.png"))); // NOI18N
        UpdateButton.setText("UPDATE");
        UpdateButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });
        jPanel2.add(UpdateButton);
        UpdateButton.setBounds(710, 590, 200, 80);

        memberimagelabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        memberimagelabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atel Dot Net\\Desktop\\MIcrofinance\\login1.jpg")); // NOI18N
        memberimagelabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel2.add(memberimagelabel);
        memberimagelabel.setBounds(660, 0, 270, 220);

        jLabel9.setFont(new java.awt.Font("Footlight MT Light", 3, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("MOBILE NO :");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(810, 350, 120, 40);

        jLabel11.setFont(new java.awt.Font("Footlight MT Light", 3, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("RELIGIOUS :");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(810, 470, 140, 40);

        jLabel3.setFont(new java.awt.Font("Footlight MT Light", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NATIONALITY :");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(810, 530, 140, 50);

        Occupation.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Occupation.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Occupation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OccupationActionPerformed(evt);
            }
        });
        jPanel2.add(Occupation);
        Occupation.setBounds(970, 280, 340, 40);

        MobileNo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        MobileNo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MobileNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MobileNoActionPerformed(evt);
            }
        });
        jPanel2.add(MobileNo);
        MobileNo.setBounds(970, 340, 340, 40);

        Nationality.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Nationality.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Nationality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NationalityActionPerformed(evt);
            }
        });
        jPanel2.add(Nationality);
        Nationality.setBounds(970, 530, 340, 40);

        Religious.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Religious.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Religious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReligiousActionPerformed(evt);
            }
        });
        jPanel2.add(Religious);
        Religious.setBounds(970, 470, 340, 40);

        NationalId.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        NationalId.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NationalId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NationalIdActionPerformed(evt);
            }
        });
        jPanel2.add(NationalId);
        NationalId.setBounds(970, 400, 340, 40);

        jLabel10.setFont(new java.awt.Font("Footlight MT Light", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("NATIONAL ID:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(810, 400, 140, 50);

        InsertImageButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        InsertImageButton.setText("INSERT IMAGE");
        InsertImageButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        InsertImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertImageButtonActionPerformed(evt);
            }
        });
        jPanel2.add(InsertImageButton);
        InsertImageButton.setBounds(710, 220, 170, 40);

        jLabel2.setFont(new java.awt.Font("Footlight MT Light", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("OCCUPATION :");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(800, 290, 150, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 1370, 730);

        setSize(new java.awt.Dimension(1388, 769));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MemberNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MemberNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MemberNameActionPerformed

    private void PermanentAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PermanentAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PermanentAddressActionPerformed

    private void OccupationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OccupationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OccupationActionPerformed

    private void MobileNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MobileNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MobileNoActionPerformed

    private void NationalIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NationalIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NationalIdActionPerformed

    private void ReligiousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReligiousActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReligiousActionPerformed

    private void NationalityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NationalityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NationalityActionPerformed

    private void InsertImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertImageButtonActionPerformed
        // TODO add your handling code here:
  JFileChooser chooser=new JFileChooser();
       chooser.showOpenDialog(null);
       File f=chooser.getSelectedFile();
       filename=f.getAbsolutePath();
       ImageIcon imageicon=new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(memberimagelabel.getWidth(), memberimagelabel.getHeight(), 100));
       memberimagelabel.setIcon(imageicon);
       try
       {
           File image=new File(filename);
           FileInputStream fis=new FileInputStream(image);
           
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum; (readNum = fis.read(buf)) != -1;) 
            {
              bos.write(buf, 0, readNum);
             // System.out.println("read " + readNum + " bytes,");
            }
            
            personimage = bos.toByteArray();
           
       }catch(Exception e)
       {
           
       }
       

      
    }//GEN-LAST:event_InsertImageButtonActionPerformed

    private void PresentaddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PresentaddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PresentaddressActionPerformed

    private void FatherorHusbandNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FatherorHusbandNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FatherorHusbandNameActionPerformed

    private void GenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GenderActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        // TODO add your handling code here:
         try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=MicroFinanceManagement;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);

           
           // PreparedStatement pst1 = con.prepareStatement(sql1);
            String sql = "Update AdmissionForm set MemberName=?, MobileNo=?, MotherName=?, NationalId=?, Occupation=?,Permanentaddress=?, Presentaddress=?,Religious=?,Nationality=?,FatherorHusbandName=? ,Gender=?, MemberImage=? WHERE MemberId='"+Memberid+"'";
            PreparedStatement pst = con.prepareStatement(sql);
          //  PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, MemberName.getText().toString());
            pst.setString(2, MobileNo.getText().toString());
            pst.setString(3, MotherName.getText().toString());
            pst.setString(4, NationalId.getText().toString()); 
            pst.setString(5, Occupation.getText().toString());
            pst.setString(6, PermanentAddress.getText().toString());
            pst.setString(7, Presentaddress.getText().toString());
            pst.setString(8, Religious.getText().toString()); 
            pst.setString(9, Nationality.getText().toString());
            pst.setString(10, FatherorHusbandName.getText().toString());
            pst.setString(11, Gender.getSelectedItem().toString());
            
            
         Icon icons = memberimagelabel.getIcon();
        BufferedImage bi = new BufferedImage(icons.getIconWidth(), icons.getIconHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();
        icons.paintIcon(null, g, 0, 0);
        g.setColor(Color.WHITE);
        g.drawString(memberimagelabel.getText(), 10, 20);
        g.dispose();

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(bi, "jpg", os);
        InputStream fis = new ByteArrayInputStream(os.toByteArray());
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        for (int readNum; (readNum = fis.read(buf)) != -1;) {
            bos.write(buf, 0, readNum);
            System.out.println("read " + readNum + " bytes,");
            }
         byte[] bytes = bos.toByteArray();
         personimage = bytes;
            
            
         pst.setBytes(12, personimage);

            
          
          //  ResultSet rs = pst.executeQuery();
            pst.executeUpdate();

            
           
            JOptionPane.showMessageDialog(null, "Successfully Updated");

               
            con.close();

    
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }  

        
    }//GEN-LAST:event_UpdateButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MemberInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MemberInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MemberInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MemberInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MemberInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FatherorHusbandName;
    private javax.swing.JComboBox<String> Gender;
    private javax.swing.JButton InsertImageButton;
    private javax.swing.JTextField MemberName;
    private javax.swing.JLabel MemberidLabel;
    private javax.swing.JTextField MobileNo;
    private javax.swing.JTextField MotherName;
    private javax.swing.JTextField NationalId;
    private javax.swing.JTextField Nationality;
    private javax.swing.JTextField Occupation;
    private javax.swing.JTextField PermanentAddress;
    private javax.swing.JTextField Presentaddress;
    private javax.swing.JTextField Religious;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelGender;
    private javax.swing.JLabel memberimagelabel;
    // End of variables declaration//GEN-END:variables
}
