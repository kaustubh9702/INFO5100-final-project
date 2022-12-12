/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gvidia.gvidia.ui.supplier;

import com.gvidia.gvidia.ui.systemadminworkarea.*;
import com.gvidia.gvidia.business.EcoSystem;
import com.gvidia.gvidia.business.enterprises.retailer.personnel.customer.Customer;
import com.gvidia.gvidia.business.deliveryman.DeliveryMan;
import com.gvidia.gvidia.business.enterprise.employee.Employee;
import com.gvidia.gvidia.business.enterprises.supplier.SupplierEnterprise;
import com.gvidia.gvidia.business.enterprises.supplier.organisations.ExecutiveOrganisation;
import com.gvidia.gvidia.business.enterprises.supplier.organisations.UnionOrganisation;
import com.gvidia.gvidia.business.useraccount.UserAccount;

import javax.swing.JPanel;

import com.gvidia.gvidia.ui.Colors;
import com.gvidia.gvidia.ui.base.Controller;//import com.gvidia.gvidia.ui.panels.LoginPanel;
import com.gvidia.gvidia.ui.panels.IconButton;
import com.gvidia.gvidia.ui.panels.LoginPanel;
import com.gvidia.gvidia.ui.panels.personnelPanels.UserAccountPanel;
import com.gvidia.gvidia.ui.panels.tables.ActionInterface;
import com.gvidia.gvidia.ui.panels.tables.DisplayTable;
import com.gvidia.gvidia.ui.panels.tables.ElementButton;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Krishica
 */
public class SupplierManagementPanel extends javax.swing.JPanel {

    /**
     * Creates new form SystemAdminWorkAreaJPanel
     */
    Controller mController;
    EcoSystem mEcosystem;
    SupplierEnterprise mSupplier;
    Colors color;
    public SupplierManagementPanel(Controller cont,Employee emp) {
        
        mEcosystem = cont.getmEcoSystem();
        this.mSupplier = mEcosystem.getmSupplier();
        color = mSupplier.getThemeColor();
        initComponents();
        this.mController=cont;
        
        loadPanels();
        resetColor(new IconButton[]{iconButton3, iconButton1, iconButton2});
        iconButton1MousePressed(null);
        iconButton3.setVisible(false);
    }
    
    

    public void changeWorkContainerPanel(JPanel panel) {
        jSplitPane1.setRightComponent(panel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        side_pane = new javax.swing.JPanel();
        logout_btn = new javax.swing.JPanel();
        ind_logout = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        imageAvatar1 = new com.gvidia.gvidia.ui.panels.ImageAvatar();
        iconButton3 = new IconButton("analytics.png", "Analytics");
        iconButton1 = new IconButton("suit_32px.png", "Executives");
        iconButton2 = new IconButton("union_32px.png", "Union");
        workContainerPanel = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(new java.awt.BorderLayout());

        jSplitPane1.setDividerLocation(150);
        jSplitPane1.setDividerSize(0);
        jSplitPane1.setLastDividerLocation(150);
        jSplitPane1.setMaximumSize(new java.awt.Dimension(800, 600));
        jSplitPane1.setMinimumSize(new java.awt.Dimension(800, 600));
        jSplitPane1.setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel1.setMaximumSize(new java.awt.Dimension(150, 800));
        jPanel1.setMinimumSize(new java.awt.Dimension(150, 800));
        jPanel1.setPreferredSize(new java.awt.Dimension(150, 800));
        jPanel1.setRequestFocusEnabled(false);

        side_pane.setBackground(color.PRIMARY_DARK());
        side_pane.setMaximumSize(new java.awt.Dimension(150, 800));
        side_pane.setMinimumSize(new java.awt.Dimension(150, 800));
        side_pane.setPreferredSize(new java.awt.Dimension(150, 800));
        side_pane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logout_btn.setBackground(color.PRIMARY_DARK());
        logout_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logout_btnMousePressed(evt);
            }
        });

        ind_logout.setOpaque(false);
        ind_logout.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_logoutLayout = new javax.swing.GroupLayout(ind_logout);
        ind_logout.setLayout(ind_logoutLayout);
        ind_logoutLayout.setHorizontalGroup(
            ind_logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_logoutLayout.setVerticalGroup(
            ind_logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Logout");

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nisha\\Documents\\Studies\\Fall 2021\\INFO5100\\Assignment 5\\JuberEats\\src\\main\\resources\\images\\logout.png")); // NOI18N
        jLabel3.setLabelFor(logout_btn);
        jLabel3.setText("jLabel1");

        javax.swing.GroupLayout logout_btnLayout = new javax.swing.GroupLayout(logout_btn);
        logout_btn.setLayout(logout_btnLayout);
        logout_btnLayout.setHorizontalGroup(
            logout_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logout_btnLayout.createSequentialGroup()
                .addComponent(ind_logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(44, 44, 44))
        );
        logout_btnLayout.setVerticalGroup(
            logout_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logout_btnLayout.createSequentialGroup()
                .addComponent(ind_logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(logout_btnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(logout_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(logout_btnLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        side_pane.add(logout_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, -1, -1));

        imageAvatar1.setBackground(color.PRIMARY_DARK());
        imageAvatar1.setMaximumSize(new java.awt.Dimension(100, 100));
        imageAvatar1.setMinimumSize(new java.awt.Dimension(100, 100));
        side_pane.add(imageAvatar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 120));

        iconButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                iconButton3MousePressed(evt);
            }
        });
        side_pane.add(iconButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, -1, -1));

        iconButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                iconButton1MousePressed(evt);
            }
        });
        side_pane.add(iconButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, -1, -1));

        iconButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                iconButton2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                iconButton2MouseReleased(evt);
            }
        });
        side_pane.add(iconButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(side_pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(side_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 197, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        workContainerPanel.setBackground(color.BACKGROUND);
        workContainerPanel.setMaximumSize(new java.awt.Dimension(650, 600));
        workContainerPanel.setMinimumSize(new java.awt.Dimension(650, 600));

        javax.swing.GroupLayout workContainerPanelLayout = new javax.swing.GroupLayout(workContainerPanel);
        workContainerPanel.setLayout(workContainerPanelLayout);
        workContainerPanelLayout.setHorizontalGroup(
            workContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        workContainerPanelLayout.setVerticalGroup(
            workContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(workContainerPanel);

        add(jSplitPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void logout_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_btnMousePressed
        // TODO add your handling code here:

        mController.getmMainFrame().changePanel(new LoginPanel(mController));


    }//GEN-LAST:event_logout_btnMousePressed

    private void iconButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconButton1MousePressed
        // TODO add your handling code here:
        loadPanels();
        setActive(iconButton1);
        resetColor(new IconButton[]{iconButton3, iconButton2});
        changeWorkContainerPanel(ExecutivesTable);
    }//GEN-LAST:event_iconButton1MousePressed

    private void iconButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconButton2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_iconButton2MouseReleased

    private void iconButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconButton2MousePressed
        // TODO add your handling code here:
        loadPanels();
               setActive(iconButton2);
        resetColor(new IconButton[]{iconButton3, iconButton1});
        changeWorkContainerPanel(UnionTable);
    }//GEN-LAST:event_iconButton2MousePressed

    private void iconButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconButton3MousePressed
        // TODO add your handling code here:
        loadPanels();
        setActive(iconButton3);
        resetColor(new IconButton[]{iconButton1, iconButton2});
        //changeWorkContainerPanel();
        
        
    }//GEN-LAST:event_iconButton3MousePressed

    private void setActive(IconButton active) {
        active.setColors(color.BACKGROUND, color.PRIMARY_DARK());
    }

    private void resetColor(IconButton[] reset) {
        for(int i=0;i<reset.length;i++){
           reset[i].setColors(color.PRIMARY_DARK(), color.BACKGROUND);
        } 
        

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.gvidia.gvidia.ui.panels.IconButton iconButton1;
    private com.gvidia.gvidia.ui.panels.IconButton iconButton2;
    private com.gvidia.gvidia.ui.panels.IconButton iconButton3;
    private com.gvidia.gvidia.ui.panels.ImageAvatar imageAvatar1;
    private javax.swing.JPanel ind_logout;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel logout_btn;
    private javax.swing.JPanel side_pane;
    private javax.swing.JPanel workContainerPanel;
    // End of variables declaration//GEN-END:variables

    public DisplayTable ExecutivesTable;
    public DisplayTable UnionTable;
    public DisplayTable RestaurantTable;




    public void loadPanels(){


        ExecutivesTable =  new DisplayTable<UserAccount>(
            mEcosystem.getUserAccountDirectory().fliter(ExecutiveOrganisation.class.toString()),
                "Executives",
                 Arrays.asList(new ElementButton<UserAccount>("Create", "create.png", new ActionInterface<UserAccount>() {
                    @Override
                    public void action(UserAccount t) {
                            changeWorkContainerPanel(new UserAccountPanel(null,mSupplier,mSupplier.getExecutiveOrganisation(), true));                
                    }
                }),
                new ElementButton<UserAccount>("Edit", "edit.png", new ActionInterface<UserAccount>() {
                    @Override
                    public void action(UserAccount t) {
                        changeWorkContainerPanel(new UserAccountPanel(t,mSupplier,mSupplier.getExecutiveOrganisation(), false));
                    }
                }),
                new ElementButton<UserAccount>("Delete", "delete.png", new ActionInterface<UserAccount>() {
                    @Override
                    public void action(UserAccount c) {
                        
                    }
                })
              ),
                mSupplier.getThemeColor()
        );
        UnionTable =  new DisplayTable<UserAccount>(
            mEcosystem.getUserAccountDirectory().fliter(UnionOrganisation.class.toString()),
                "Customers",
                 Arrays.asList(new ElementButton<UserAccount>("Create", "create.png", new ActionInterface<UserAccount>() {
                    @Override
                    public void action(UserAccount t) {
                        
                        changeWorkContainerPanel(new UserAccountPanel(t,mSupplier,mSupplier.getUnionOrganisation(), false));
                   
                    }
                }),
                new ElementButton<UserAccount>("Edit", "edit.png", new ActionInterface<UserAccount>() {
                    @Override
                    public void action(UserAccount t) {
                        if(isNullThenShout(t)) return;
                        changeWorkContainerPanel(new UserAccountPanel(t,mSupplier,mSupplier.getUnionOrganisation(), false));
                    }

            
                }),
                new ElementButton<UserAccount>("Delete", "delete.png", new ActionInterface<UserAccount>() {
                    @Override
                    public void action(UserAccount t) {
                        if(isNullThenShout(t)) return;
                        
                    }
                })
              ),
                mSupplier.getThemeColor()
        );

        

//        RestaurantTable = new DisplayTable<Restaurant>(
//            mEcosystem.getRestaurantDirectory().getList(),
//                "Restaurants",
//            Arrays.asList(new ElementButton<Restaurant>("Create", "create.png", new ActionInterface<Restaurant>() {
//            @Override
//            public void action(Restaurant t) {
//                    changeWorkContainerPanel(new RestarauntInfoPanel(null,true));
//            }
//                }),
//                new ElementButton<Restaurant>("Edit", "edit.png", new ActionInterface<Restaurant>() {
//            @Override
//            public void action(Restaurant t) {
//                    changeWorkContainerPanel(new RestarauntInfoPanel(t,false));
//            }
//                }),
//                new ElementButton<>("Delete", "delete.png", new ActionInterface<Restaurant>() {
//            @Override
//            public void action(Restaurant r) {
//                     r.delete();
//                    mEcosystem.getRestaurantDirectory().delete(r.getmID());
//                    RestaurantTable.setUptable();
//
//            }
//                })
//            )
//        );




    }
    private boolean isNullThenShout(Object t) {
        if(t == null) {
            JOptionPane.showMessageDialog(jSplitPane1, "Select an Item");
            return true;
        } else return false;
    }


}
