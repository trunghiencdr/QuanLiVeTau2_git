/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ChuyenManHinhController;
import controller.ChuyenManHinhView;
import java.awt.BorderLayout;
import view.quanlituyen.JPanelDanhSachTram;
import view.quanlituyen.JPanelDanhSachTuyen;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class JPanelQuanLiTuyen extends javax.swing.JPanel {

    /**
     * Creates new form JPanelQuanLiTuyen
     */
    public JPanelQuanLiTuyen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnDanhSachTuyen = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpnDanhSachTram = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 204));

        jpnDanhSachTuyen.setBackground(new java.awt.Color(255, 0, 153));
        jpnDanhSachTuyen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpnDanhSachTuyenMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/baseline_table_rows_black_18dp.png"))); // NOI18N
        jLabel1.setText("Danh sách tuyến");

        javax.swing.GroupLayout jpnDanhSachTuyenLayout = new javax.swing.GroupLayout(jpnDanhSachTuyen);
        jpnDanhSachTuyen.setLayout(jpnDanhSachTuyenLayout);
        jpnDanhSachTuyenLayout.setHorizontalGroup(
            jpnDanhSachTuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnDanhSachTuyenLayout.createSequentialGroup()
                .addGap(0, 17, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnDanhSachTuyenLayout.setVerticalGroup(
            jpnDanhSachTuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
        );

        jpnDanhSachTram.setBackground(new java.awt.Color(255, 0, 255));
        jpnDanhSachTram.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpnDanhSachTramMousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/baseline_table_chart_black_18dp.png"))); // NOI18N
        jLabel2.setText("Danh sách trạm");

        javax.swing.GroupLayout jpnDanhSachTramLayout = new javax.swing.GroupLayout(jpnDanhSachTram);
        jpnDanhSachTram.setLayout(jpnDanhSachTramLayout);
        jpnDanhSachTramLayout.setHorizontalGroup(
            jpnDanhSachTramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnDanhSachTramLayout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnDanhSachTramLayout.setVerticalGroup(
            jpnDanhSachTramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jpnDanhSachTuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpnDanhSachTram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(258, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnDanhSachTram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpnDanhSachTuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(290, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jpnDanhSachTuyenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnDanhSachTuyenMousePressed
        // TODO add your handling code here:
        new ChuyenManHinhView(this, new JPanelDanhSachTuyen()).change();
    }//GEN-LAST:event_jpnDanhSachTuyenMousePressed

    private void jpnDanhSachTramMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnDanhSachTramMousePressed
        // TODO add your handling code here:
        new ChuyenManHinhView(this, new JPanelDanhSachTram()).change();
    }//GEN-LAST:event_jpnDanhSachTramMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jpnDanhSachTram;
    private javax.swing.JPanel jpnDanhSachTuyen;
    // End of variables declaration//GEN-END:variables
}
