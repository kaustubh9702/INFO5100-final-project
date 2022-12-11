/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.gvidia.gvidia.ui.manufacturing;

import com.gvidia.gvidia.ui.panels.personnelPanels.*;
import com.gvidia.gvidia.business.EcoSystem;
import com.gvidia.gvidia.business.enterprise.Enterprise;
import com.gvidia.gvidia.business.enterprise.role.Role;
import com.gvidia.gvidia.business.enterprises.manufacturer.ManufacturingEnterprise;
import com.gvidia.gvidia.business.enterprises.manufacturer.wr.ProductPlacementWorkRequest;
import com.gvidia.gvidia.business.enterprises.manufacturer.wr.RawMaterialWorkRequest;
import com.gvidia.gvidia.business.enterprises.retailer.organisations.SalesOrganisation;
import com.gvidia.gvidia.business.enterprises.retailer.personnel.customer.Customer;
import com.gvidia.gvidia.business.enterprises.retailer.personnel.customer.CustomerDirectory;
import com.gvidia.gvidia.business.order.OrderItem;
import com.gvidia.gvidia.business.useraccount.UserAccount;
import com.gvidia.gvidia.business.utils.Hash;
import com.gvidia.gvidia.business.utils.ImageUtil;
import com.gvidia.gvidia.business.utils.Validators;

import javax.swing.JOptionPane;
import com.gvidia.gvidia.ui.Colors;
import java.awt.Color;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import static com.gvidia.gvidia.business.utils.ImageUtil.BASE_IMAGE;

/**
*
* @author Nisha
*/
public class ProductPanel extends javax.swing.JPanel {

   public static final String PLACEHOLDER = BASE_IMAGE+"placeholder_product.png";
   
   
    ProductPlacementWorkRequest mProduct;
   ManufacturingEnterprise mManufacturer;
   boolean canEdit;
   String mSelectedPhoto;
   UserAccount mUserAccount;
   Colors color;
   /**
    * Creates new form DeliveryManPanel
    */
   public ProductPanel(UserAccount acc, ProductPlacementWorkRequest a,ManufacturingEnterprise ent,boolean canEdit) {
       
       color = ent.getThemeColor();
       
       initComponents();
       mProduct = a;
       mManufacturer = ent;
       this.canEdit = canEdit;
       if(mProduct != null ) {
           setValues(mProduct);
       }
       mUserAccount = acc;
       
       setProfile(null);
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
        quantityTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        priceTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        rawMaterialTextField = new javax.swing.JTextField();
        emailLabel1 = new javax.swing.JLabel();
        imageAvatar1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(650, 600));
        setMinimumSize(new java.awt.Dimension(650, 600));
        setPreferredSize(new java.awt.Dimension(650, 600));

        jPanel1.setBackground(Colors.BACKGROUND);
        jPanel1.setForeground(color.PRIMARY());
        jPanel1.setMaximumSize(new java.awt.Dimension(650, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(650, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(650, 600));

        jLabel1.setBackground(color.BACKGROUND);
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(color.PRIMARY_DARK());
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("View Product");

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
        jLabel7.setText("Quantity");

        quantityTextField.setBackground(Colors.BACKGROUND);
        quantityTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        quantityTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, color.PRIMARY_DARK()));
        quantityTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        quantityTextField.setDisabledTextColor(new java.awt.Color(0, 0, 0));

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

        priceTextField.setBackground(Colors.BACKGROUND);
        priceTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        priceTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, color.PRIMARY_DARK()));
        priceTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        priceTextField.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel10.setBackground(color.SECONDARY_DARK());
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(color.PRIMARY_DARK());
        jLabel10.setText("Price");

        rawMaterialTextField.setBackground(Colors.BACKGROUND);
        rawMaterialTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rawMaterialTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, color.PRIMARY_DARK()));
        rawMaterialTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        rawMaterialTextField.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        emailLabel1.setBackground(color.SECONDARY_DARK());
        emailLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        emailLabel1.setForeground(color.PRIMARY_DARK());
        emailLabel1.setText("Raw Material");

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
                .addGap(0, 2, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(imageAvatar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rawMaterialTextField)
                    .addComponent(emailLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                    .addComponent(quantityTextField)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(priceTextField)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameTxtField)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(165, 165, 165))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rawMaterialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        // TODO add your handling code here:

        String name = nameTxtField.getText();
        String quantity = quantityTextField.getText();
        String raw = rawMaterialTextField.getText();
        String price = priceTextField.getText();
        if(!Validators.isAlpha(name)) {
            JOptionPane.showMessageDialog(this, "Name is not valid");
            return;
        }
        if(!Validators.isNum(quantity)) {
            JOptionPane.showMessageDialog(this, "Quantity is not valid");
            return;
        }
        if(!Validators.isNum(raw)) {
            JOptionPane.showMessageDialog(this, "Material Required is not valid");
            return;
        }
        if(!Validators.isNum(price)) {
            JOptionPane.showMessageDialog(this, "Price is not valid");
            return;
        }

        if(mProduct == null) {

            RawMaterialWorkRequest r = mManufacturer.developProduct(mUserAccount, name,
                Double.valueOf(price), mSelectedPhoto, Integer.parseInt(quantity),
                Integer.parseInt(raw));

            mProduct = mManufacturer.getProductDevOrganisation()
            .getProductFromMaterialRequest(r.getmMaterialWorkRequest());
            mProduct.getmProductToPlace().setmSelectedImage(mSelectedPhoto);
            
            JOptionPane.showMessageDialog(this, "Material Requested");
            canEdit = false;
            setValues(mProduct);
        }
    }//GEN-LAST:event_jLabel2MousePressed

    private void imageAvatar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageAvatar1MousePressed
        // TODO add your handling code here:
        if(!canEdit) return;
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
    private javax.swing.JLabel emailLabel1;
    private javax.swing.JLabel imageAvatar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameTxtField;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JTextField quantityTextField;
    private javax.swing.JTextField rawMaterialTextField;
    // End of variables declaration//GEN-END:variables

   private void setValues(ProductPlacementWorkRequest pwr) {
       
       
       
       nameTxtField.setText(pwr.getmProductToPlace().getName());
       priceTextField.setText(pwr.getmProductToPlace().getPrice() + "");
       quantityTextField.setText(pwr.getmQuantity() + "");
       rawMaterialTextField.setText(pwr.getmProductToPlace().getmMaterialRequired() + "");
       quantityTextField.setEditable(false);
       
       setProfile(pwr.getmProductToPlace().getSelectedImage());
       
       
       nameTxtField.setEditable(canEdit);    
       priceTextField.setEditable(canEdit);    
       quantityTextField.setEditable(canEdit);    
       rawMaterialTextField.setEditable(canEdit); 
       jLabel2.setVisible(!canEdit);


   }

    private void setProfile(String loc) {
        if(loc == null || loc.isEmpty() || !new File(loc).exists())
            loc = PLACEHOLDER;
        
        ImageIcon image = ImageUtil.getImageIcon(220, 220, loc);
        imageAvatar1.setIcon(image);
        imageAvatar1.repaint();
        mSelectedPhoto = loc;
    }
}
