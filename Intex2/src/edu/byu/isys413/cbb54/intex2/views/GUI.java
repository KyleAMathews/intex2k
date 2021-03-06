/*
 * GUI.java
 *
 * Created on February 27, 2007, 8:26 AM
 */

package edu.byu.isys413.cbb54.intex2.views;

import javax.swing.*;
/**
 *
 * @author  Cameron
 */
public class GUI extends javax.swing.JFrame {
    
    /** Creates new form GUI */
    public GUI() {
        initComponents();
        
        // Set the look and feel to the system's default
        try {
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {
          System.out.println("Error setting native LAF: " + e);
        }
    }
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Customer = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        customerCreateNew = new javax.swing.JButton();
        customerEdit = new javax.swing.JButton();
        Interests = new javax.swing.JPanel();

        getContentPane().setLayout(new java.awt.FlowLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        Customer.setLayout(new java.awt.BorderLayout());

        customerCreateNew.setText("Create New");
        customerCreateNew.setMargin(new java.awt.Insets(4, 14, 4, 14));
        customerCreateNew.setMaximumSize(new java.awt.Dimension(90, 45));
        customerCreateNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerCreateNewActionPerformed(evt);
            }
        });

        jPanel1.add(customerCreateNew);

        customerEdit.setText("Edit Existing");
        customerEdit.setMargin(new java.awt.Insets(4, 14, 4, 14));
        customerEdit.setMaximumSize(new java.awt.Dimension(90, 45));
        customerEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerEditActionPerformed(evt);
            }
        });

        jPanel1.add(customerEdit);

        Customer.add(jPanel1, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Customer", Customer);

        javax.swing.GroupLayout InterestsLayout = new javax.swing.GroupLayout(Interests);
        Interests.setLayout(InterestsLayout);
        InterestsLayout.setHorizontalGroup(
            InterestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );
        InterestsLayout.setVerticalGroup(
            InterestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );
        jTabbedPane1.addTab("Interests", Interests);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.getAccessibleContext().setAccessibleName("Customer");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void customerCreateNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerCreateNewActionPerformed
        new customerCreate().setVisible(true);
    }//GEN-LAST:event_customerCreateNewActionPerformed

    private void customerEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerEditActionPerformed
        new customerEdit().setVisible(true);
    }//GEN-LAST:event_customerEditActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Customer;
    private javax.swing.JPanel Interests;
    private javax.swing.JButton customerCreateNew;
    private javax.swing.JButton customerEdit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
    
}
