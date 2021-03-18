/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.quanlituyen;

import connectSQL.LopKetNoi;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import module.Tuyen;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class JPanelDanhSachTuyen extends javax.swing.JPanel {

    private Connection connection;
    private ArrayList<Tuyen> DS;
    DefaultTableModel tbmBangTuyen;
    int count = 0;

    /**
     * Creates new form JPanelDanhSachTuyen
     */
    public JPanelDanhSachTuyen() {
        initComponents();
        connection = new LopKetNoi().getConnection();
        tbmBangTuyen = (DefaultTableModel) jtbTuyen.getModel();
        loadDuLieuTuyenLenBang();
        loadDSTramVaoCBB();
    }

    private void loadDSTramVaoCBB() {
        try {
            PreparedStatement ps = connection.prepareStatement("select tenTram from Tram");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cbbGoiYTram.addItem(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadDuLieuTuyenLenBang() {
        try {
            PreparedStatement ps = connection.prepareStatement("select * from tuyen");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StringBuilder stringBuilder = new StringBuilder();
                String maTuyen = rs.getString(1);
                PreparedStatement ps1 = connection.prepareStatement("select tenTram from TuyenDiQuaTram where maTuyen = ? order by STT  ASC");
                ps1.setString(1, maTuyen);
                ResultSet rs1 = ps1.executeQuery();
                while (rs1.next()) {
                    stringBuilder.append(rs1.getString(1) + "-");
                }
                if (stringBuilder.length() != 0) {
                    stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
                }
                tbmBangTuyen.addRow(new Object[]{maTuyen, rs.getString(2), stringBuilder.toString()});
            }
        } catch (Exception e) {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbTuyen = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jtfMaTuyen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfTenTuyen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaCacTramDiQua = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtfTimKiem = new javax.swing.JTextField();
        cbbTiemKiem = new javax.swing.JComboBox<>();
        cbbSapXep = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbbGoiYTram = new javax.swing.JComboBox<>();

        jLabel1.setText("Thông tin chi tiết");

        jtbTuyen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã tuyến", "Tên tuyến", "Danh sách trạm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtbTuyen);

        jLabel2.setText("Mã tuyến:");

        jtfMaTuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMaTuyenActionPerformed(evt);
            }
        });

        jLabel4.setText("Tên tuyến:");

        jtfTenTuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTenTuyenActionPerformed(evt);
            }
        });

        jLabel3.setText("Các trạm đi qua:");

        jtaCacTramDiQua.setColumns(20);
        jtaCacTramDiQua.setRows(5);
        jtaCacTramDiQua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtaCacTramDiQuaKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jtaCacTramDiQua);

        jLabel5.setText("Chức năng");

        btnThem.setText("THÊM");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("SỬA");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("XÓA");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/baseline_report_gmailerrorred_black_18dp.png"))); // NOI18N

        jLabel8.setText("Tìm kiếm:");

        cbbTiemKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbSapXep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Sắp xếp:");

        jLabel10.setText("Gồm cả trạm BĐ và KT theo dạng trạm-trạm-trạm");

        jLabel11.setText("Gợi ý trạm");

        cbbGoiYTram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbGoiYTramActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(63, 63, 63)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jtfMaTuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(103, 103, 103)
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jtfTenTuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel11)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cbbGoiYTram, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(336, 336, 336))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbTiemKiem, 0, 151, Short.MAX_VALUE)
                            .addComponent(jtfTimKiem))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnThem)
                        .addGap(39, 39, 39)
                        .addComponent(btnSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa)
                        .addGap(9, 9, 9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfMaTuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jtfTenTuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cbbGoiYTram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(4, 4, 4)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(cbbTiemKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThem)
                        .addComponent(btnSua)
                        .addComponent(btnXoa)
                        .addComponent(jLabel8)
                        .addComponent(jtfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtfMaTuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMaTuyenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMaTuyenActionPerformed

    private void jtfTenTuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTenTuyenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTenTuyenActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        String cacTramDiQua[] = null;
        if (jtfMaTuyen.equals("")) {
            JOptionPane.showMessageDialog(this, "Mã không được trống!");
            jtfMaTuyen.requestFocus();
            return;
        }
        if (jtfTenTuyen.equals("")) {
            JOptionPane.showMessageDialog(this, "Tên không được trống");
            return;
        }
        if (jtaCacTramDiQua.equals("")) {
            JOptionPane.showMessageDialog(this, "Trạm đi qua không được trống");
            jtaCacTramDiQua.requestFocus();
            return;
        } else {
            cacTramDiQua = jtaCacTramDiQua.getText().split("\\s*-\\s*");
            if (cacTramDiQua.length < 2) {
                JOptionPane.showMessageDialog(this, "Trạm đi qua phải ít nhất 2 trạm");
                jtaCacTramDiQua.requestFocus();
                return;
            }
        }
        
        try {
            PreparedStatement ps = connection.prepareStatement("insert into tuyen values(?,?)");
            ps.setString(1, jtfMaTuyen.getText().toUpperCase());
            ps.setString(2, jtfTenTuyen.getText().toUpperCase());
            ps.executeUpdate();
            /// cap nhat bang cac tram di qua trong tuyen
            int i=1;
            for(String s:cacTramDiQua){
                PreparedStatement ps1 = connection.prepareStatement("insert into tuyenDiQuaTram values(?,?,?)");
                ps1.setString(1, jtfMaTuyen.getText().toUpperCase());
                ps1.setString(2, s.toUpperCase());
                ps1.setInt(3, i);
                i++;
                ps1.executeUpdate();
            }
            JOptionPane.showMessageDialog(this, "Thêm tuyến thành công!");
            tbmBangTuyen.addRow(new Object[]{jtfMaTuyen.getText().toUpperCase(), jtfTenTuyen.getText().toUpperCase(),
            jtaCacTramDiQua.getText().toUpperCase()});
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Mã tuyến đã có trong danh sách! Vui lòng chọn mã khác");
        }


    }//GEN-LAST:event_btnThemActionPerformed

    private void cbbGoiYTramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbGoiYTramActionPerformed
        // TODO add your handling code here:
        if (count <= 0) {
            count++;
            return;
        } else {
            jtaCacTramDiQua.append(cbbGoiYTram.getSelectedItem().toString());
            jtaCacTramDiQua.requestFocus();
        }
    }//GEN-LAST:event_cbbGoiYTramActionPerformed

    private void jtaCacTramDiQuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtaCacTramDiQuaKeyReleased
        // TODO add your handling code here:
        String tramDiQua = jtaCacTramDiQua.getText().toString();
        if(tramDiQua.equals("")){
            count=-1;
            cbbGoiYTram.removeAllItems();
            loadDSTramVaoCBB();
        }
        if (evt.getKeyChar() == '-') {
            String[] tam = tramDiQua.split("\\s*-\\s*");
            if (tam.length != 0) {
                String tramVuaChon = tam[tam.length - 1];
                count = -1;
                cbbGoiYTram.removeAllItems();
                try {
                    PreparedStatement ps = connection.prepareStatement("select tenTramBD, tenTramKT from khoangCachTram where "
                            + "tenTramBD = ?  or tenTramKT = ?");
                    ps.setString(1, tramVuaChon);
                    ps.setString(2, tramVuaChon);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        String tramBD = rs.getString(1);
                        String tramKT = rs.getString(2);
                        if (tramVuaChon.equals(tramBD)) {
                            cbbGoiYTram.addItem(tramKT);
                        } else if (tramVuaChon.equals(tramKT)) {
                            cbbGoiYTram.addItem(tramBD);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_jtaCacTramDiQuaKeyReleased

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if(jtaCacTramDiQua.equals("")){
            JOptionPane.showMessageDialog(this, "sua that bai tram khong dc trong");
        }
    }//GEN-LAST:event_btnSuaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbGoiYTram;
    private javax.swing.JComboBox<String> cbbSapXep;
    private javax.swing.JComboBox<String> cbbTiemKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jtaCacTramDiQua;
    private javax.swing.JTable jtbTuyen;
    private javax.swing.JTextField jtfMaTuyen;
    private javax.swing.JTextField jtfTenTuyen;
    private javax.swing.JTextField jtfTimKiem;
    // End of variables declaration//GEN-END:variables
}
