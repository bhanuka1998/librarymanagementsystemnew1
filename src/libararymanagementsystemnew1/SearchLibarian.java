/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libararymanagementsystemnew1;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class SearchLibarian extends javax.swing.JFrame {
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    DefaultTableModel d;
    
    public SearchLibarian() {
        initComponents();
        ImageIcon  icon = new ImageIcon("C:/Users/-e-/Downloads/lbmNew1/src/libararymanagementsystemnew1/resources/Bookhubicon5.png");
        this.setIconImage(icon.getImage());
        conn = SQLCON.connect();
        jTable1Load();
    }
    
    private void jTable1Load(){
        int c;
        try {
            pst = conn.prepareStatement("select lib_name, lib_nic, lib_dob, lib_address, lib_email,  lib_password from librarian_registration;");
            rs = pst.executeQuery();
           
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            d = (DefaultTableModel)jTable1.getModel();
            d.setRowCount(0);
           
//** While loop for load the data
            while(rs.next())
            {
              Vector v2 = new Vector();
              for(int i=1; i<=c; i++)
              {
              v2.add(rs.getString("lib_name"));
              v2.add(rs.getString("lib_nic"));
              v2.add(rs.getString("lib_dob"));
              v2.add(rs.getString("lib_address"));
              v2.add(rs.getString("lib_email"));
              v2.add(rs.getString("lib_password"));
                                     
              }
             d.addRow(v2);
            }
             
        } catch (SQLException ex) {
            Logger.getLogger(SearchMember.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        lblNIC = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnShow = new javax.swing.JButton();
        txtPassword2 = new javax.swing.JTextField();
        lblPassword2 = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jEditDate = new com.toedter.calendar.JDateChooser();
        lblDOB = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtNIC = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtSearch = new javax.swing.JTextField();
        lblNIC1 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Book Hub");
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNIC.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblNIC.setText("Enter Librarian NIC");
        jPanel1.add(lblNIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 94, 208, 40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "NIC", "DOB", "Address", "Email", "Password"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(732, 94, 508, 570));

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnShow.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnShow.setText("Show");
        btnShow.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });
        jPanel2.add(btnShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 750, 169, 45));

        txtPassword2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtPassword2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 560, 316, 40));

        lblPassword2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblPassword2.setText("Re-Enter Password");
        jPanel2.add(lblPassword2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 560, 208, 40));

        btnEdit.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnEdit.setText("Update");
        btnEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel2.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 750, 169, 45));

        btnClear.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnClear.setText("Clear");
        btnClear.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel2.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 750, 169, 45));

        jEditDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jEditDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 316, 40));

        lblDOB.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblDOB.setText("Enter Librarian Date of Birth");
        jPanel2.add(lblDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 242, 40));

        lblPassword.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblPassword.setText("Enter Password");
        jPanel2.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, 208, 40));

        txtPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 480, 316, 40));

        txtName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 316, 40));

        lblName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblName.setText("Enter Librarian Name");
        jPanel2.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 208, 40));

        lblAddress.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblAddress.setText("Enter Librarian Address");
        jPanel2.add(lblAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 208, 40));

        txtAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, 316, 40));

        txtNIC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtNIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 316, 40));

        lblEmail.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblEmail.setText("Enter Librarian Email");
        jPanel2.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 208, 40));

        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 410, 316, 40));

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });
        jPanel2.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 1040, 40));

        lblNIC1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNIC1.setText("Search Librarian");
        jPanel2.add(lblNIC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 20, -1, -1));

        btnCancel.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 750, 169, 45));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 870));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(-5, 0, 1250, 970);

        setSize(new java.awt.Dimension(1245, 866));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        int c;
        String libNIC = txtSearch.getText();
        try {
            pst = conn.prepareStatement("select * from librarian_registration where lib_nic ='"+libNIC+"'");
            rs = pst.executeQuery();
           
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            d = (DefaultTableModel)jTable1.getModel();
            d.setRowCount(0);
           
//** While loop for load the data
            while(rs.next())
            {
              Vector v2 = new Vector();
              for(int i=1; i<=c; i++)
              {
              v2.add(rs.getString("lib_name"));
              v2.add(rs.getString("lib_nic"));
              v2.add(rs.getString("lib_dob"));
              v2.add(rs.getString("lib_address"));
              v2.add(rs.getString("lib_email"));
              v2.add(rs.getString("lib_password"));
                                     
              }
             d.addRow(v2);
            }
             
        } catch (SQLException ex) {
            Logger.getLogger(SearchMember.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnShowActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        String libname = txtName.getText();
        String librariannic = txtNIC.getText();
        String librariandob = jEditDate.getDateFormatString();
        String librarianaddress = txtAddress.getText();
        String librarianemail = txtEmail.getText();
        String librarianpassword = txtPassword.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("YYY-MM-DD");
        
        EmailValidator emailValidator = new EmailValidator();
        
        IdentyCardValidator identiyCardValidator = new IdentyCardValidator();
        
        //Sending Email creating the message body
            final String FromEmail = "bookhubworld69@gmail.com";
            final String FromEmailPassword = "cb007874";
            String Subjects = "Book Hub Library Management System";
           
           
           
            Properties properties = new Properties();
           
            properties.put("mail.smtp.starttls.enable","true");
            properties.put("mail.smtp.auth","true");
            properties.put("mail.smtp.host","smtp.gmail.com");
            properties.put("mail.smtp.port","587");
           
            Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator()
            {
                @Override
                protected PasswordAuthentication getPasswordAuthentication()
                {
                    return new PasswordAuthentication(FromEmail,FromEmailPassword);
                }
               
            });
        //_______________________________________
        
        
        if (libname.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Fill Required fields");
        }
        else if (!identiyCardValidator.validate(librariannic.trim()))
        {
            JOptionPane.showMessageDialog(null, "Input a valid ID number");
        }
        else if (librariandob.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Fill Required fields");
        }
        else if (librarianaddress.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Fill Required fields");
        }
        else if (!emailValidator.validate(librarianemail.trim()))
        {
            JOptionPane.showMessageDialog(null, "Input Correct Email Format");
        }
        else if(librarianpassword.equals("")){
            JOptionPane.showMessageDialog(null, "Fill Reuired Fields");
        }
        else
        {
            try
            {
                String memberDOB = sdf.format(jEditDate.getDate());                
                String sql = "update librarian_registration set lib_name = ?, lib_nic = ?, lib_dob = ?, lib_address = ?, lib_email = ?, lib_password = ? where lib_nic = '"+librariannic+"'";
                pst = conn.prepareStatement(sql);
                pst.setString(1, txtName.getText());
                pst.setString(2, txtNIC.getText());
                pst.setString(3, memberDOB);
                pst.setString(4, txtAddress.getText());
                pst.setString(5, txtEmail.getText());
                pst.setString(6, txtPassword.getText());
                pst.execute();
                JOptionPane.showMessageDialog(null, "Successfully updated.");
                
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(FromEmail));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(librarianemail));
                message.setSubject(Subjects);
                //message.setText();
                message.setText( "Hi " + libname + "! "+"Your details have been successfully updated.");
                Transport.send(message);
                
                jTable1Load();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String libNIC = txtSearch.getText();

       if (libNIC.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Input valid details");
        }
        /*if (libNIC.equals(""))
        {
            try
            {
                Statement st = conn.createStatement();

                String sql = "select * from librarian_registration where lib_nic ='"+libNIC+"'";
                ResultSet rs = st.executeQuery(sql);

                while (rs.next())
                {
                    //JOptionPane.showMessageDialog(null, "Invalid NIC");
                    String libnic = rs.getString("lib_nic");
                    txtNIC.setText(libnic);
                    String libname = rs.getString("lib_name");
                    txtName.setText(libname);
                    SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
                    String libDOB = rs.getString("lib_dob");
                    java.util.Date libdob = sdf.parse(libDOB);
                    jEditDate.setDate((java.util.Date)libdob);
                    String libaddress = rs.getString("lib_address");
                    txtAddress.setText(libaddress);
                    String libemail = rs.getString("lib_email");
                    txtEmail.setText(libemail);
                    String libpassword = rs.getString("lib_password");
                    txtPassword.setText(libpassword);
                }

            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }*/
        else{
            try
            {
                Statement st = conn.createStatement();

                String sql = "select * from librarian_registration where lib_name ='"+libNIC+"' or lib_nic = '"+libNIC+"'";
                ResultSet rs = st.executeQuery(sql);

                while (rs.next())
                {
                    //JOptionPane.showMessageDialog(null, "Invalid NIC");
                    String libnic = rs.getString("lib_nic");
                    txtNIC.setText(libnic);
                    String libname = rs.getString("lib_name");
                    txtName.setText(libname);
                    SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
                    String libDOB = rs.getString("lib_dob");
                    java.util.Date libdob = sdf.parse(libDOB);
                    jEditDate.setDate((java.util.Date)libdob);
                    String libaddress = rs.getString("lib_address");
                    txtAddress.setText(libaddress);
                    String libemail = rs.getString("lib_email");
                    txtEmail.setText(libemail);
                    String libpassword = rs.getString("lib_password");
                    txtPassword.setText(libpassword);
                }

            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped

    }//GEN-LAST:event_txtSearchKeyTyped

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtAddress.setText(null);
        //txtDOB.setText(null);
        txtEmail.setText(null);
        //txtID.setText(null);
        txtNIC.setText(null);
        txtName.setText(null);
        jEditDate.setDate(null);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(SearchLibarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchLibarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchLibarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchLibarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchLibarian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnShow;
    private com.toedter.calendar.JDateChooser jEditDate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblDOB;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNIC;
    private javax.swing.JLabel lblNIC1;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPassword2;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNIC;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPassword2;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
