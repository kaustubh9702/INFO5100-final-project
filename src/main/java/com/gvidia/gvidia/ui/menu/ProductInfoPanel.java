///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.gvidia.gvidia.ui.menu;
//
//import com.gvidia.gvidia.business.EcoSystem;
//import com.gvidia.gvidia.business.restaraunt.Restaurant;
//import com.gvidia.gvidia.business.order.Product;
//import com.gvidia.gvidia.business.utils.ImageUtil;
//import com.gvidia.gvidia.business.utils.Validators;
//
//import java.io.File;
//import javax.swing.JFileChooser;
//import javax.swing.JOptionPane;
//import javax.swing.filechooser.FileNameExtensionFilter;
//import com.gvidia.gvidia.ui.Colors;
//
/**
 *
 * @author Krishica
 */
//public class ProductInfoPanel extends javax.swing.JPanel {
//
//    /**
//     * Creates new form CustomerInfoPanel
//     */
//
//    Product product = null;
//    boolean toCreate = false;
//    String selectedImagePath;
//    Restaurant mRestaurant;
//    EcoSystem system;
//
//    public ProductInfoPanel(Restaurant res,Product p, boolean b) {
//       initComponents();
//       toCreate = b;
//       product = p;
//       mRestaurant = res;
//       system = EcoSystem.getInstance(true);
//       if(p != null && !b) {
//           setValues(p);
//       }
//
//    }
//
//
//
//    /**
//     * This method is called from within the constructor to initialize the form.
//     * WARNING: Do NOT modify this code. The content of this method is always
//     * regenerated by the Form Editor.
//     */
//    @SuppressWarnings("unchecked")
//    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
//    private void initComponents() {
//
//        jLabel1 = new javax.swing.JLabel();
//        jLabel5 = new javax.swing.JLabel();
//        nameTxtField = new javax.swing.JTextField();
//        jLabel2 = new javax.swing.JLabel();
//        priceTxtField = new javax.swing.JTextField();
//        jLabel10 = new javax.swing.JLabel();
//        imageLabel = new javax.swing.JLabel();
//
//        setBackground(Colors.PRIMARY);
//        setMaximumSize(new java.awt.Dimension(650, 600));
//        setMinimumSize(new java.awt.Dimension(650, 600));
//
//        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
//        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
//        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//        jLabel1.setText("Edit/Create a MenuItem");
//
//        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
//        jLabel5.setText("Name");
//
//        nameTxtField.setBackground(Colors.PRIMARY);
//        nameTxtField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
//        nameTxtField.setForeground(new java.awt.Color(255, 255, 255));
//        nameTxtField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
//
//        jLabel2.setBackground(Colors.PRIMARY);
//        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
//        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//        jLabel2.setText("Save");
//        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
//        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mousePressed(java.awt.event.MouseEvent evt) {
//                jLabel2MousePressed(evt);
//            }
//        });
//
//        priceTxtField.setBackground(Colors.PRIMARY);
//        priceTxtField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
//        priceTxtField.setForeground(new java.awt.Color(255, 255, 255));
//        priceTxtField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
//
//        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
//        jLabel10.setText("Price");
//
//        imageLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
//        imageLabel.setForeground(new java.awt.Color(255, 255, 255));
//        imageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//        imageLabel.setText("Pick a Photo");
//        imageLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
//        imageLabel.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mousePressed(java.awt.event.MouseEvent evt) {
//                imageLabelMousePressed(evt);
//            }
//        });
//
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
//        this.setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//                .addContainerGap(171, Short.MAX_VALUE)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
//                    .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(priceTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(nameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addGap(169, 169, 169))
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addContainerGap()
//                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addGap(1, 1, 1)
//                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                .addComponent(nameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(priceTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addGap(28, 28, 28)
//                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addContainerGap(152, Short.MAX_VALUE))
//        );
//    }// </editor-fold>//GEN-END:initComponents
//
//    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
//        // TODO add your handling code here:
//
//        String name = nameTxtField.getText();
//        String price = priceTxtField.getText();
//        if(!Validators.isAlpha(name)) {
//            JOptionPane.showMessageDialog(this, "Name is not valid");
//            return;
//        }
//        if(!Validators.isNum(price)) {
//            JOptionPane.showMessageDialog(this, "Price is not valid");
//            return;
//        }
//        if(selectedImagePath == null) {
//             JOptionPane.showMessageDialog(this, "Select a  ");
//            return;
//        }
//
//        if(toCreate) {
//            product =  mRestaurant.getmMenuDirectory().add(name, Double.valueOf(price),selectedImagePath);
//            JOptionPane.showMessageDialog(this, "Product created");
//            toCreate = false;
//        } else {
//           product.setName(name);
//           product.setPrice(Double.valueOf(price));
//           product.setmImage(selectedImagePath);
//           JOptionPane.showMessageDialog(this, "Product Updated");
//        }
//
//
//
//
//
//
//    }//GEN-LAST:event_jLabel2MousePressed
//
//    private void imageLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageLabelMousePressed
//        // TODO add your handling code here:
//        JFileChooser browseImageFile = new JFileChooser();
//        //Filter image extensions
//        FileNameExtensionFilter fnef = new FileNameExtensionFilter("png", "jpg", "jpeg");
//        browseImageFile.addChoosableFileFilter(fnef);
//        int showOpenDialogue = browseImageFile.showOpenDialog(null);
//
//        if (showOpenDialogue == JFileChooser.APPROVE_OPTION) {
//            File selectedImageFile = browseImageFile.getSelectedFile();
//            selectedImagePath = selectedImageFile.getAbsolutePath();
//            JOptionPane.showMessageDialog(null, selectedImagePath);
//            //Display image on jlable
//            imageLabel.setIcon(ImageUtil.getImageIcon(imageLabel.getWidth(), imageLabel.getHeight(), selectedImagePath));
//        }
//
//
//
//    }//GEN-LAST:event_imageLabelMousePressed
//
//
//    // Variables declaration - do not modify//GEN-BEGIN:variables
//    private javax.swing.JLabel imageLabel;
//    private javax.swing.JLabel jLabel1;
//    private javax.swing.JLabel jLabel10;
//    private javax.swing.JLabel jLabel2;
//    private javax.swing.JLabel jLabel5;
//    private javax.swing.JTextField nameTxtField;
//    private javax.swing.JTextField priceTxtField;
//    // End of variables declaration//GEN-END:variables
//
//    private void setValues(Product p) {
//
//
//        nameTxtField.setText(p.getName());
//        priceTxtField.setText(p.getPrice() + "");
//        selectedImagePath = p.getSelectedImage();
//        imageLabel.setIcon(ImageUtil.getImageIcon(imageLabel.getWidth(), imageLabel.getHeight(), selectedImagePath));
//
//
//    }
//
//
//
//}
