/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carshowroom;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author shamaz
 */
public class JFrameSalesInnvoice extends javax.swing.JFrame {

    /**
     * Creates new form JFrameSalesInnvoice
     */
    public JFrameSalesInnvoice() {
        initComponents();
        showSalesInvoice();
    }
    
     
    public ArrayList<SalesInvoice> getSalesInvoiceList()
   {
       ArrayList<SalesInvoice>SalesInvoicelist = new ArrayList<SalesInvoice>();
      try
        {
            ClassDBConnectivity databaseConnectivity = new ClassDBConnectivity();
            Connection connection = databaseConnectivity.getDatabaseConnectivity();
//            Statement statement = connection.createStatement();
//            
            String query11= "select * from SalesInvoice_T";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query11);
           SalesInvoice saleinvoice;
           while(rs.next())
           {
               saleinvoice= new SalesInvoice(rs.getString("InvoiceID"), rs.getInt("InvoiceNumber"),rs.getString("InvoiceDate"),rs.getString("CarID"),rs.getString("CustomerID"),rs.getString("SalespersonID"));
               SalesInvoicelist.add(saleinvoice);
           }
            
        }
       catch(Exception e)
        {
            System.out.println(""+e);
            JOptionPane.showMessageDialog(null, e);
                   
        }
       
      return SalesInvoicelist;
   }
    
    public void showSalesInvoice()
    {
        ArrayList<SalesInvoice>  listintableSalesInvoice = getSalesInvoiceList();
        DefaultTableModel modelsalesinvoice = (DefaultTableModel)jTableShowAllRecordOfSalesInvoice.getModel();
        
        Object[] row = new Object[6];
       for(int i = 0; i < listintableSalesInvoice.size(); i++)
       {
           row[0] = listintableSalesInvoice.get(i).getInvoiceid();
           row[1] = listintableSalesInvoice.get(i).getInvoiceno();
           row[2] = listintableSalesInvoice.get(i).getInvoicedate();
           row[3] = listintableSalesInvoice.get(i).getCarid();
           row[4] = listintableSalesInvoice.get(i).getCustomerid();
           row[5] = listintableSalesInvoice.get(i).getSalespersonid();
           
           
           
           modelsalesinvoice.addRow(row);
       }
    }
    
    public void executeSQLQuery(String querySalesInvoice,String message)
    {
              try
        {
            ClassDBConnectivity databaseConnectivity = new ClassDBConnectivity();
            Connection connection = databaseConnectivity.getDatabaseConnectivity();
       //     Statement statement = connection.createStatement();
//         
           Statement st;
            try
            {
               st = connection.createStatement();
               if(st.executeUpdate(querySalesInvoice) == 1)
               {
                   
                 DefaultTableModel modelsalesinvoice = (DefaultTableModel)jTableShowAllRecordOfSalesInvoice.getModel();
                 modelsalesinvoice.setRowCount(0);
                 showSalesInvoice();
                 
                 JOptionPane.showMessageDialog(null, "Data "+message+" Successfully");
               }
               else 
               {
                   JOptionPane.showMessageDialog(null, "Data not "+message+ " " );
                   
               }
               
            }
             catch(Exception e)
        {
            System.out.println(""+e);
            JOptionPane.showMessageDialog(null,"Primary Key Mismatch.Please Choose Unique Primary Key");
                   
        }
           
            
            
        }
       catch(Exception e)
        {
            System.out.println(""+e);
            JOptionPane.showMessageDialog(null, e);
                   
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
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldInvoiceID = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldInvoiceNo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldInvoiceDate = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldCarIDsalesInvoice = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldSalesInvoiceCustomerID = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldsalesInvoiceSalesPersonID = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableShowAllRecordOfSalesInvoice = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Car Dealing Management System");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Andalus", 1, 36)); // NOI18N
        jLabel1.setText("Sales INVOICE");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(450, 20, 250, 30);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carshowroom/LOG.png"))); // NOI18N
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(0, 0, 90, 59);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carshowroom/home.jpg"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(1010, 0, 100, 59);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Invoice ID");

        jTextFieldInvoiceID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Invoice No");

        jTextFieldInvoiceNo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldInvoiceNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldInvoiceNoKeyPressed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Invoice Date");

        jTextFieldInvoiceDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Car ID");

        jTextFieldCarIDsalesInvoice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Customer ID");

        jTextFieldSalesInvoiceCustomerID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Sales Person ID");

        jTextFieldsalesInvoiceSalesPersonID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jTextFieldInvoiceNo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jTextFieldInvoiceDate, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextFieldInvoiceID, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldSalesInvoiceCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldsalesInvoiceSalesPersonID, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCarIDsalesInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldInvoiceID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldCarIDsalesInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldInvoiceNo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldSalesInvoiceCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jTextFieldInvoiceDate, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(jTextFieldsalesInvoiceSalesPersonID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(126, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carshowroom/insert.png"))); // NOI18N
        jButton3.setText("Insert");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carshowroom/delete.jpg"))); // NOI18N
        jButton9.setText("Delete");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carshowroom/update.png"))); // NOI18N
        jButton10.setText("Update");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carshowroom/clear.png"))); // NOI18N
        jButton5.setText("Clear");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton9)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTableShowAllRecordOfSalesInvoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice ID", "Invoice No", "Invoice Date", "Car ID", "Customer ID", "Sales Person ID"
            }
        ));
        jTableShowAllRecordOfSalesInvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableShowAllRecordOfSalesInvoiceMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTableShowAllRecordOfSalesInvoice);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("View All Record Of Sales Invoice");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
//        setVisible(false);
//        new JFrameLogIn().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        setVisible(false);
        new JFrameMain().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String querySalesInvoice = "insert into SalesInvoice_T(InvoiceID,InvoiceNumber,InvoiceDate,CarID,CustomerID,SalespersonID) values('"+jTextFieldInvoiceID.getText()+"','"+jTextFieldInvoiceNo.getText()+"','"+jTextFieldInvoiceDate.getText()+"','"+jTextFieldCarIDsalesInvoice.getText()+"','"+jTextFieldSalesInvoiceCustomerID.getText()+"','"+jTextFieldsalesInvoiceSalesPersonID.getText()+"') ";
        executeSQLQuery(querySalesInvoice,"Inserted");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        String querySalesInvoice = "update SalesInvoice_T set InvoiceNumber='"+jTextFieldInvoiceNo.getText()+"',InvoiceDate='"+jTextFieldInvoiceDate.getText()+"',CarID='"+jTextFieldCarIDsalesInvoice.getText()+"',CustomerID='"+jTextFieldSalesInvoiceCustomerID.getText()+"',SalespersonID='"+jTextFieldsalesInvoiceSalesPersonID.getText()+"' where InvoiceID='"+jTextFieldInvoiceID.getText()+"'" ;
        executeSQLQuery(querySalesInvoice,"Updated");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        
         String querySalesInvoice = "DELETE FROM SalesInvoice_T WHERE InvoiceID = '"+jTextFieldInvoiceID.getText()+"'" ;
         executeSQLQuery(querySalesInvoice,"Deleted");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTableShowAllRecordOfSalesInvoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableShowAllRecordOfSalesInvoiceMouseClicked
         int i = jTableShowAllRecordOfSalesInvoice.getSelectedRow();
        TableModel modelsalesinvoice = jTableShowAllRecordOfSalesInvoice.getModel();
        
        jTextFieldInvoiceID.setText(modelsalesinvoice.getValueAt(i,0).toString());
        jTextFieldInvoiceNo.setText(modelsalesinvoice.getValueAt(i,1).toString());
        jTextFieldInvoiceDate.setText(modelsalesinvoice.getValueAt(i,2).toString());
        jTextFieldCarIDsalesInvoice.setText(modelsalesinvoice.getValueAt(i,3).toString());
        jTextFieldSalesInvoiceCustomerID.setText(modelsalesinvoice.getValueAt(i,4).toString());
        jTextFieldsalesInvoiceSalesPersonID.setText(modelsalesinvoice.getValueAt(i,5).toString());
        
    }//GEN-LAST:event_jTableShowAllRecordOfSalesInvoiceMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        jTextFieldCarIDsalesInvoice.setText("");
        jTextFieldInvoiceDate.setText("");
        jTextFieldInvoiceID.setText("");
        jTextFieldInvoiceNo.setText("");
        jTextFieldSalesInvoiceCustomerID.setText("");
        jTextFieldsalesInvoiceSalesPersonID.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextFieldInvoiceNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldInvoiceNoKeyPressed
 if((evt.getKeyCode() < 48 || evt.getKeyCode() > 57))
        {
            javax.swing.JOptionPane.showMessageDialog(null,"Alphabet or Special Characters are not allowed");
            jTextFieldInvoiceNo.setText("");
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldInvoiceNoKeyPressed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
 int option;
     if( SwingUtilities.isLeftMouseButton(evt) )
        {   
            option = javax.swing.JOptionPane.showConfirmDialog(null,"Are you sure you want to Logout?");
            if (option==0)
            {
                setVisible(false);
             new JFrameLogIn().setVisible(true);
             
            }
            else if (option==1)
            {
                setVisible(false);
                setVisible(true);
            }
            else if (option==2)
            {
                setVisible(false);
                setVisible(true);
            }
        }            // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseClicked

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
            java.util.logging.Logger.getLogger(JFrameSalesInnvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameSalesInnvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameSalesInnvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameSalesInnvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameSalesInnvoice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTableShowAllRecordOfSalesInvoice;
    private javax.swing.JTextField jTextFieldCarIDsalesInvoice;
    private javax.swing.JTextField jTextFieldInvoiceDate;
    private javax.swing.JTextField jTextFieldInvoiceID;
    private javax.swing.JTextField jTextFieldInvoiceNo;
    private javax.swing.JTextField jTextFieldSalesInvoiceCustomerID;
    private javax.swing.JTextField jTextFieldsalesInvoiceSalesPersonID;
    // End of variables declaration//GEN-END:variables
}
