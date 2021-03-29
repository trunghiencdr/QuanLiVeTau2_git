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
import moduledao.TuyenDao;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class JPanelDanhSachTuyen extends javax.swing.JPanel {

    private TuyenDao tuyenDao;
    private Connection connection;
    private ArrayList<Tuyen> DS;
    private DefaultTableModel tbmBangTuyen;
    private int count = 0;
    private int hangDangChon = -1;

    /**
     * Creates new form JPanelDanhSachTuyen
     */
    public JPanelDanhSachTuyen() {
        initComponents();
        tuyenDao = new TuyenDao();
        connection = new LopKetNoi().getConnection();
        tbmBangTuyen = (DefaultTableModel) jtbTuyen.getModel();
        tuyenDao.loadDSTuyenVaoBang(LopKetNoi.select("select * from Tuyen"), tbmBangTuyen);
//        loadDuLieuTuyenLenBang();
//        loadDSTramVaoCBB();
    }

    private void loadDSTramVaoCBB() {
        try {
            PreparedStatement ps = connection.prepareStatement("select tenTram from Tram");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
//                cbbGoiYTram.addItem(rs.getString(1));
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

        jdlThuocTinhTuyen = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jlbTenDialog = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfMaTuyen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfTenTuyen = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaCacTramDiQua = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtaKhoangCach = new javax.swing.JTextArea();
        btnXacNhan = new javax.swing.JButton();
        jlbMaTuyen = new javax.swing.JLabel();
        jlbCacTramDiQua = new javax.swing.JLabel();
        jlbKhoangCach = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbTuyen = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jtfTimKiem = new javax.swing.JTextField();
        cbbTiemKiem = new javax.swing.JComboBox<>();
        cbbSapXep = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jPanel2.setMinimumSize(new java.awt.Dimension(508, 529));

        jlbTenDialog.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlbTenDialog.setForeground(new java.awt.Color(102, 102, 255));
        jlbTenDialog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbTenDialog.setText("THÊM TUYẾN");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Mã tuyến:");

        jtfMaTuyen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfMaTuyenKeyReleased(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Tên tuyến:");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Các trạm đi qua:");

        jtaCacTramDiQua.setColumns(20);
        jtaCacTramDiQua.setRows(5);
        jScrollPane2.setViewportView(jtaCacTramDiQua);

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Khoảng cách:");

        jtaKhoangCach.setColumns(20);
        jtaKhoangCach.setRows(5);
        jScrollPane3.setViewportView(jtaKhoangCach);

        btnXacNhan.setText("XÁC NHẬN");

        jlbMaTuyen.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jlbMaTuyen.setForeground(new java.awt.Color(255, 51, 51));
        jlbMaTuyen.setText("Không được để trống");

        jlbCacTramDiQua.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jlbCacTramDiQua.setForeground(new java.awt.Color(255, 51, 51));
        jlbCacTramDiQua.setText("Không được để trống");

        jlbKhoangCach.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jlbKhoangCach.setForeground(new java.awt.Color(255, 51, 51));
        jlbKhoangCach.setText("Không được để trống");

        jLabel12.setText("Định dạng: trạm-trạm-trạm");

        jLabel13.setText("Định dạng: km-km");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbTenDialog)
                .addGap(201, 201, 201))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jlbCacTramDiQua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfMaTuyen)
                                .addComponent(jtfTenTuyen)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                .addComponent(jlbMaTuyen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel12)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel7)
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jlbKhoangCach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlbTenDialog)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfMaTuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jlbMaTuyen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfTenTuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbCacTramDiQua)
                .addGap(12, 12, 12)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbKhoangCach)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(btnXacNhan)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout jdlThuocTinhTuyenLayout = new javax.swing.GroupLayout(jdlThuocTinhTuyen.getContentPane());
        jdlThuocTinhTuyen.getContentPane().setLayout(jdlThuocTinhTuyenLayout);
        jdlThuocTinhTuyenLayout.setHorizontalGroup(
            jdlThuocTinhTuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdlThuocTinhTuyenLayout.setVerticalGroup(
            jdlThuocTinhTuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdlThuocTinhTuyenLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTextField3.setText("jTextField3");

        jLabel1.setText("Thông tin chi tiết");

        jtbTuyen.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jtbTuyen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã tuyến", "Tên tuyến", "Danh sách trạm", "Khoảng cách"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbTuyen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbTuyenMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbTuyen);

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
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel8.setText("Tìm kiếm:");

        jLabel9.setText("Sắp xếp:");

        jButton1.setText("Trờ về");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbTiemKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 286, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(349, 349, 349))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1))
                    .addComponent(jButton1))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(cbbTiemKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void batCacTruong(){
        jtfMaTuyen.enable(true);
        jtfTenTuyen.enable(true);
        jtaCacTramDiQua.enable(true);
        jtaKhoangCach.enable(true);
    }
    
     private void tatCacTruong(){
        jtfMaTuyen.enable(false);
        jtfTenTuyen.enable(false);
        jtaCacTramDiQua.enable(false);
        jtaKhoangCach.enable(false);
    }
    private void hienThiDialog(String tenDialog){
        switch(tenDialog){
            case "THÊM TUYẾN":
                batCacTruong();
                break;
            case "SỬA TUYẾN":
                break;
            case "THÔNG TIN TUYẾN":
                break;
        }
        jlbTenDialog.setText(tenDialog);
        jdlThuocTinhTuyen.setLocationRelativeTo(this);
        jdlThuocTinhTuyen.setVisible(true);
    }
    
    private void kiemTraThongTinNhap(String loai){
        loai.toLowerCase();
        switch(loai){
            case "mã tuyến":
                String maTuyen = jtfMaTuyen.getText().trim();
                if(maTuyen.equals("")){
                    jlbMaTuyen.setText("Không được để trống");
                }else{// kiểm tra mã có bị trùng không
                    try {
                         ResultSet rs = LopKetNoi.select("select * from tuyen where maTuyen = ?", maTuyen);
                        if(rs.next()){
                             jlbMaTuyen.setText("Mã bị trùng");
                        }
                    } catch (Exception e) {
                    }
                }
                break;
        }
        
    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        hienThiDialog("THÊM TUYẾN");

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if (hangDangChon < 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn đối tượng! Vui lòng chọn 1 dòng trong bảng");
            return;
        }
        String cacTramDiQua[] = null;
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
            PreparedStatement ps = connection.prepareStatement("update tuyen set TenTuyen = ? where MaTuyen = ?");
            ps.setString(1, jtfTenTuyen.getText().toUpperCase());
            ps.setString(2, jtbTuyen.getValueAt(hangDangChon, 0).toString());
            ps.executeUpdate();
            /// cap nhat bang cac tram di qua trong tuyen
            ps = connection.prepareStatement("delete from TuyenDiQuaTram where MaTuyen = ?");
            ps.setString(1, jtbTuyen.getValueAt(hangDangChon, 0).toString());
            ps.executeUpdate();
            int i = 0;
            for (String s : cacTramDiQua) {
                PreparedStatement ps1 = connection.prepareStatement("insert into tuyenDiQuaTram values(?,?,?)");
                ps1.setString(1, jtbTuyen.getValueAt(hangDangChon, 0).toString());
                ps1.setString(2, s);
                ps1.setInt(3, i);
                i++;
                ps1.executeUpdate();
            }
            jtfMaTuyen.setText(jtbTuyen.getValueAt(hangDangChon, 0).toString().toUpperCase());
            jtbTuyen.setValueAt(jtfTenTuyen.getText().toUpperCase(), hangDangChon, 1);
            jtbTuyen.setValueAt(jtaCacTramDiQua.getText(), hangDangChon, 2);
            JOptionPane.showMessageDialog(this, "Sửa tuyến thành công!");
            tbmBangTuyen.addRow(new Object[]{jtfMaTuyen.getText().toUpperCase(), jtfTenTuyen.getText().toUpperCase(),
                jtaCacTramDiQua.getText().toUpperCase()});
        } catch (Exception e) {
        }


    }//GEN-LAST:event_btnSuaActionPerformed

    private void jtbTuyenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbTuyenMousePressed
        // TODO add your handling code here:
        hangDangChon = jtbTuyen.getSelectedRow();
        jtfMaTuyen.setText(jtbTuyen.getValueAt(hangDangChon, 0) + "");
        jtfTenTuyen.setText(jtbTuyen.getValueAt(hangDangChon, 1) + "");
        jtaCacTramDiQua.setText(jtbTuyen.getValueAt(hangDangChon, 2) + "");
        // load lại cbb
        String[] tam = jtaCacTramDiQua.getText().split("\\s*-\\s*");
        String tramVuaChon = tam[tam.length - 1];
        count = -1;
//        cbbGoiYTram.removeAllItems();
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
//                    cbbGoiYTram.addItem(tramKT);
                } else if (tramVuaChon.equals(tramKT)) {
//                    cbbGoiYTram.addItem(tramBD);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jtbTuyenMousePressed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        if (hangDangChon < 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn đối tượng! Vui lòng chọn 1 hàng trong bảng");
            return;
        }
        try {
            PreparedStatement ps = connection.prepareStatement("delete from TuyenDiQuaTram where MaTuyen = ?");
            ps.setString(1, jtbTuyen.getValueAt(hangDangChon, 0).toString());
            ps.executeUpdate();
            ps = connection.prepareStatement("delete from Tuyen where MaTuyen = ?");
            ps.setString(1, jtbTuyen.getValueAt(hangDangChon, 0).toString());
            ps.executeUpdate();
            tbmBangTuyen.removeRow(hangDangChon);
            jtbTuyen.clearSelection();
            jtfMaTuyen.setText("");
            jtfTenTuyen.setText("");
            jtaCacTramDiQua.setText("");
            count = -1;
//            cbbGoiYTram.removeAllItems();
            loadDSTramVaoCBB();
            
            hangDangChon = -1;
            JOptionPane.showMessageDialog(this, "Xóa thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void jtfMaTuyenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMaTuyenKeyReleased
        // TODO add your handling code here:
        kiemTraThongTinNhap("mã tuyến");
    }//GEN-LAST:event_jtfMaTuyenKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbSapXep;
    private javax.swing.JComboBox<String> cbbTiemKiem;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JDialog jdlThuocTinhTuyen;
    private javax.swing.JLabel jlbCacTramDiQua;
    private javax.swing.JLabel jlbKhoangCach;
    private javax.swing.JLabel jlbMaTuyen;
    private javax.swing.JLabel jlbTenDialog;
    private javax.swing.JTextArea jtaCacTramDiQua;
    private javax.swing.JTextArea jtaKhoangCach;
    private javax.swing.JTable jtbTuyen;
    private javax.swing.JTextField jtfMaTuyen;
    private javax.swing.JTextField jtfTenTuyen;
    private javax.swing.JTextField jtfTimKiem;
    // End of variables declaration//GEN-END:variables
}
