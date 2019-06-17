/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class Available extends javax.swing.JFrame {
static String airline;
static String stop;
static String departure;
static String arrive;
static String price;
//public  double price;
    public  String from;
    public  String to;
    //public String departDate;
    //public  String returnDate;
    //public  int travellers;
    public  String class1;
    /**
     * Creates new form available
     */
    public Available() {
        initComponents();
        bookFlight.setVisible(false);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        mtodtable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        bookFlight = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mtodtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Airlines", "Stops", "Departs", "Arrives", "price"
            }
        ));
        mtodtable.setShowVerticalLines(false);
        mtodtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mtodtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(mtodtable);

        jButton1.setText("< Click to Check >");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        bookFlight.setText("Book Flight");
        bookFlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookFlightActionPerformed(evt);
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
                        .addComponent(jButton1)
                        .addContainerGap(860, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 825, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bookFlight, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bookFlight, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
           this.to=Choosejourney.to1;
            this.from=Choosejourney.from1;
            this.class1=Choosejourney.class1;
            
        
        Connection con=ConnectionClass.connect();
        String string="select * from mtodce where location= '"+ to +"' and destination= '"+from+"' and class= '"+class1+"'";
        PreparedStatement stmt=con.prepareStatement(string);
        ResultSet rs=stmt.executeQuery();
        DefaultTableModel dtm=(DefaultTableModel) mtodtable.getModel();
        while(rs.next())
        {
            dtm.addRow(new Object[]{rs.getString("airline"),rs.getString("stops"),rs.getString("arrives"),rs.getString("departs"),rs.getString("price")});
        }
     bookFlight.setVisible(true);
      
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void mtodtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mtodtableMouseClicked
        
    }//GEN-LAST:event_mtodtableMouseClicked

    private void bookFlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookFlightActionPerformed
        DefaultTableModel model=(DefaultTableModel)mtodtable.getModel();
        int selectedrowindex=mtodtable.getSelectedRow();
        int sci=mtodtable.getSelectedColumn();
        int ra=mtodtable.getSelectedRow();
      if(ra==-1)
      {
      JOptionPane.showMessageDialog(null, "select the flight first");
      }
      else
      {
     //   model.getValueAt(selectedrowindex, sci);
         airline=(model.getValueAt(selectedrowindex,0)).toString();
                  stop=(model.getValueAt(selectedrowindex,1)).toString();
                           departure=(model.getValueAt(selectedrowindex,2)).toString();
                                    arrive=(model.getValueAt(selectedrowindex,3)).toString();
                                             price=(model.getValueAt(selectedrowindex,4)).toString();
                                       Booking bk=new Booking();
                                             bk.setVisible(true);
                                             Available av=new Available();
                                             av.setVisible(false);
                                             dispose();
      }
    }//GEN-LAST:event_bookFlightActionPerformed

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
            java.util.logging.Logger.getLogger(Available.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Available.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Available.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Available.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Available().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bookFlight;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable mtodtable;
    // End of variables declaration//GEN-END:variables
}
