/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.gvidia.gvidia.ui.panels.personnelPanels;

import com.gvidia.gvidia.business.EcoSystem;
import com.gvidia.gvidia.business.enterprise.Enterprise;
import com.gvidia.gvidia.business.enterprise.employee.Employee;
import com.gvidia.gvidia.business.enterprise.employee.EmployeeDirectory;
import com.gvidia.gvidia.business.enterprise.organisation.Organization;
import com.gvidia.gvidia.business.enterprise.role.Role;
import com.gvidia.gvidia.business.useraccount.UserAccount;
import com.gvidia.gvidia.business.utils.Hash;
import com.gvidia.gvidia.business.utils.ImageUtil;
import com.gvidia.gvidia.business.utils.Validators;

import javax.swing.JOptionPane;
import com.gvidia.gvidia.ui.Colors;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
*
* @author Nisha
*/
public class UserAccountPanel extends javax.swing.JPanel {

   public static final String PLACEHOLDER = "C:\\Users\\Nisha\\Documents\\Studies\\Fall 2021\\INFO5100\\ChipConnect\\src\\resources\\images\\placeholder.jpg";
   boolean toCreate;
   UserAccount mUserAccount;
   EcoSystem system;
   Enterprise mEnterprise;
   EmployeeDirectory mEmpDir;
   Role role;
   
   String mSelectedPhoto;
   
   Colors color;
   /**
    * Creates new form DeliveryManPanel
    */
   public UserAccountPanel(UserAccount a,Enterprise ent,Organization org,boolean to) {
       
       color = ent.getThemeColor();
       
       initComponents();
       toCreate = to;
       mUserAccount = a;
       mEnterprise = ent;
       mEmpDir = org.getEmployeeDirectory();
       
       
       
       system = EcoSystem.getInstance();
       if(mUserAccount != null && !toCreate) {
           role = mUserAccount.getRole();
           setValues(mUserAccount);
       } else {role = org.getSupportedRole(org).get(0);setProfile(null);}
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
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nameTxtField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        usernameTxtField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cnfrmPassTxtField = new javax.swing.JPasswordField();
        passwordTxtField = new javax.swing.JPasswordField();
        phoneNumberTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        imageAvatar1 = new com.gvidia.gvidia.ui.panels.ImageAvatar();

        setMaximumSize(new java.awt.Dimension(650, 600));
        setMinimumSize(new java.awt.Dimension(650, 600));
        setPreferredSize(new java.awt.Dimension(650, 600));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(Colors.BACKGROUND);
        jPanel1.setForeground(color.PRIMARY());
        jPanel1.setMaximumSize(new java.awt.Dimension(650, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(650, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(650, 600));

        jLabel1.setBackground(color.BACKGROUND);
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(color.PRIMARY_DARK());
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("User Account");

        jLabel5.setBackground(color.SECONDARY_DARK());
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(color.PRIMARY_DARK());
        jLabel5.setText("Name");

        nameTxtField.setBackground(Colors.BACKGROUND);
        nameTxtField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nameTxtField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, color.PRIMARY_DARK()));
        nameTxtField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        nameTxtField.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel7.setBackground(color.SECONDARY_DARK());
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(color.PRIMARY_DARK());
        jLabel7.setText("Username");

        usernameTxtField.setBackground(Colors.BACKGROUND);
        usernameTxtField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        usernameTxtField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, color.PRIMARY_DARK()));
        usernameTxtField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        usernameTxtField.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel8.setBackground(color.SECONDARY_DARK());
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(color.PRIMARY_DARK());
        jLabel8.setText("Password");

        jLabel9.setBackground(color.SECONDARY_DARK());
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(color.PRIMARY_DARK());
        jLabel9.setText("Confirm Password");

        jLabel2.setBackground(color.PRIMARY()
        );
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(color.PRIMARY_DARK());
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Save");
        jLabel2.setBorder(new javax.swing.border.LineBorder(color.PRIMARY(), 2, true));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });

        cnfrmPassTxtField.setBackground(Colors.BACKGROUND);
        cnfrmPassTxtField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cnfrmPassTxtField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, color.PRIMARY_DARK()));
        cnfrmPassTxtField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        cnfrmPassTxtField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        cnfrmPassTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnfrmPassTxtFieldActionPerformed(evt);
            }
        });

        passwordTxtField.setBackground(Colors.BACKGROUND);
        passwordTxtField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passwordTxtField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, color.PRIMARY_DARK()));
        passwordTxtField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        passwordTxtField.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        phoneNumberTextField.setBackground(Colors.BACKGROUND);
        phoneNumberTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        phoneNumberTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, color.PRIMARY_DARK()));
        phoneNumberTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        phoneNumberTextField.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel10.setBackground(color.SECONDARY_DARK());
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(color.PRIMARY_DARK());
        jLabel10.setText("Phone Number");

        emailTextField.setBackground(Colors.BACKGROUND);
        emailTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        emailTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, color.PRIMARY_DARK()));
        emailTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        emailTextField.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        emailLabel.setBackground(color.SECONDARY_DARK());
        emailLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        emailLabel.setForeground(color.PRIMARY_DARK());
        emailLabel.setText("Email");

        imageAvatar1.setBorderColor(color.PRIMARY_DARK());
        imageAvatar1.setBorderSize(3);
        imageAvatar1.setMaximumSize(new java.awt.Dimension(220, 220));
        imageAvatar1.setMinimumSize(new java.awt.Dimension(220, 220));
        imageAvatar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                imageAvatar1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(passwordTxtField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cnfrmPassTxtField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(phoneNumberTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(usernameTxtField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nameTxtField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(emailLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(phoneNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usernameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imageAvatar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cnfrmPassTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

   private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
       // TODO add your handling code here:

       String name = nameTxtField.getText();
       String userName = usernameTxtField.getText();
       String password  = new String(passwordTxtField.getPassword());
       String confirmPassword = new String(cnfrmPassTxtField.getPassword());
       String phoneNumber = phoneNumberTextField.getText();
       String email = emailTextField.getText();
       if(!Validators.isAlpha(name)) {
           JOptionPane.showMessageDialog(this, "Name is not valid");
           return;
       }

       if(!Validators.isAlphaNum(userName)) {
           JOptionPane.showMessageDialog(this, "UserName is not valid");
           return;
       }
       if(!Validators.isEmail(email)) {
           JOptionPane.showMessageDialog(this, "Email is not valid");
           return;
       }
       
       if(!Validators.isPhoneNumber(phoneNumber)) {
           JOptionPane.showMessageDialog(this, "PhoneNumber is not valid");
           return;
       }
       if(!Validators.isPassword(password)) {
           JOptionPane.showMessageDialog(this, "Password is not valid");
           return;
       }
       if(!Validators.isPassword(confirmPassword)) {
           JOptionPane.showMessageDialog(this, "Confirm Password is not valid");
           return;
       }
       if(!confirmPassword.equals(password)) {
           JOptionPane.showMessageDialog(this, "Passwords are equal");
           return;
       }



       if(toCreate && !system.getUserAccountDirectory().checkIfUsernameIsUnique(userName,email)) {
           JOptionPane.showMessageDialog(this, "Username has been taken");
           return;
       }

       password = Hash.hash(password);

       if(toCreate) {
           Employee emp = mEmpDir.addEmployee(name, phoneNumber, mSelectedPhoto);
           mUserAccount =  system.getUserAccountDirectory().createUserAccount(
                               userName, password,email, emp, role);
           
           JOptionPane.showMessageDialog(this, "Account created");
           toCreate = false;
       } else {
           mUserAccount.getEmployee().setName(name);
           mUserAccount.getEmployee().setmPhoneNumner(phoneNumber);
           mUserAccount.getEmployee().setmProfileLocation(mSelectedPhoto);
           mUserAccount.setUsername(userName);
           mUserAccount.setPassword(password);
           mUserAccount.setEmail(email);
   
           JOptionPane.showMessageDialog(this, "Account Updated");
       }

   }//GEN-LAST:event_jLabel2MousePressed

   private void cnfrmPassTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnfrmPassTxtFieldActionPerformed
       // TODO add your handling code here:
   }//GEN-LAST:event_cnfrmPassTxtFieldActionPerformed

    private void imageAvatar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageAvatar1MousePressed
        // TODO add your handling code here:
        JFileChooser browseImageFile = new JFileChooser();
        //Filter image extensions
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("png", "jpg", "jpeg");
        browseImageFile.addChoosableFileFilter(fnef);
        int showOpenDialogue = browseImageFile.showOpenDialog(null);
 
        if (showOpenDialogue == JFileChooser.APPROVE_OPTION) {
            File selectedImageFile = browseImageFile.getSelectedFile();
            mSelectedPhoto = selectedImageFile.getAbsolutePath();
            //Display image on jlable
            
            setProfile(mSelectedPhoto);
        }
        
        
    }//GEN-LAST:event_imageAvatar1MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField cnfrmPassTxtField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private com.gvidia.gvidia.ui.panels.ImageAvatar imageAvatar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameTxtField;
    private javax.swing.JPasswordField passwordTxtField;
    private javax.swing.JTextField phoneNumberTextField;
    private javax.swing.JTextField usernameTxtField;
    // End of variables declaration//GEN-END:variables

   private void setValues(UserAccount userAccount) {

       nameTxtField.setText(userAccount.getEmployee().getName());
       phoneNumberTextField.setText(userAccount.getEmployee().getmPhoneNumner());
       usernameTxtField.setText(userAccount.getUsername());
       usernameTxtField.setEditable(false);
       emailTextField.setText(userAccount.getEmail());
       emailTextField.setEditable(false);
       
       setProfile(userAccount.getEmployee().getmProfileLocation());
       
//       passwordTxtField.setP(userAccount.getPassword());

   }

    private void setProfile(String loc) {
        if(loc == null || loc.isEmpty() || !new File(loc).exists())
            loc = PLACEHOLDER;
        
        ImageIcon image = ImageUtil.getImageIcon(100, 100, loc);
        imageAvatar1.setImage(image);
        imageAvatar1.repaint();
        mSelectedPhoto = loc;
    }
}
