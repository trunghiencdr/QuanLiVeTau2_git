/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.quanlituyen;

import connectSQL.LopKetNoi;
import controller.ChuyenManHinhView;
import java.awt.event.KeyEvent;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import view.JPanelQuanLiTuyen;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import module.Tram;
import moduledao.TramDao;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class JPanelDanhSachTram extends javax.swing.JPanel {

    private TramDao tramDao = new TramDao();
    private LopKetNoi lopKetNoi = new LopKetNoi();
    private DefaultTableModel tbmBangTram;
    private int hangDangChon = -1;

    /**
     * Creates new form JPanelDanhSachTram
     */
    public JPanelDanhSachTram() {
        initComponents();
//        disableJTF();
        jtbDanhSachTram.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbmBangTram = (DefaultTableModel) jtbDanhSachTram.getModel();
        tramDao.loadDSTramVaoBang(LopKetNoi.select("select * from Tram"), tbmBangTram);

    }

    private void enableJTF() {
        jtfTenTram.setEditable(true);
        jtfDiaChi.setEditable(true);
    }

    private void disableJTF() {
        jtfTenTram.setEditable(false);
        jtfDiaChi.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdlThemSuaTram = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jlbTenDialog = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jlbTenTramDialog = new javax.swing.JLabel();
        jtfTenTramDialog = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtfDiaChiDialog = new javax.swing.JTextField();
        btnXacNhanDialog = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jtfDiaChi = new javax.swing.JTextField();
        jtfTenTram = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jtfTimKiem = new javax.swing.JTextField();
        cbbTimKiem = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbbSapXep = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbDanhSachTram = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        jdlThemSuaTram.setMinimumSize(new java.awt.Dimension(420, 350));

        jPanel5.setMinimumSize(new java.awt.Dimension(397, 300));

        jlbTenDialog.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlbTenDialog.setForeground(new java.awt.Color(51, 51, 255));
        jlbTenDialog.setText("TH??M TR???M");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("T??n tr???m:");

        jlbTenTramDialog.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jlbTenTramDialog.setForeground(new java.awt.Color(255, 51, 51));
        jlbTenTramDialog.setText("T??n tr???m kh??ng ???????c tr???ng");

        jtfTenTramDialog.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfTenTramDialog.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfTenTramDialogKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfTenTramDialogKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("?????a ch???:");

        jtfDiaChiDialog.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfDiaChiDialog.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfDiaChiDialogKeyPressed(evt);
            }
        });

        btnXacNhanDialog.setBackground(new java.awt.Color(255, 255, 255));
        btnXacNhanDialog.setText("X??C NH???N");
        btnXacNhanDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanDialogActionPerformed(evt);
            }
        });
        btnXacNhanDialog.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnXacNhanDialogKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbTenDialog)
                .addGap(156, 156, 156))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfTenTramDialog)
                            .addComponent(jtfDiaChiDialog)
                            .addComponent(jlbTenTramDialog, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(btnXacNhanDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbTenDialog)
                .addGap(50, 50, 50)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtfTenTramDialog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbTenTramDialog)
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtfDiaChiDialog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(btnXacNhanDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout jdlThemSuaTramLayout = new javax.swing.GroupLayout(jdlThemSuaTram.getContentPane());
        jdlThemSuaTram.getContentPane().setLayout(jdlThemSuaTramLayout);
        jdlThemSuaTramLayout.setHorizontalGroup(
            jdlThemSuaTramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdlThemSuaTramLayout.setVerticalGroup(
            jdlThemSuaTramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("DANH S??CH TR???M");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/outline_arrow_back_black_24dp_1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jtfDiaChi.setEditable(false);
        jtfDiaChi.setBackground(new java.awt.Color(255, 255, 255));
        jtfDiaChi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jtfTenTram.setEditable(false);
        jtfTenTram.setBackground(new java.awt.Color(255, 255, 255));
        jtfTenTram.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Th??ng tin tr???m");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("T??n tr???m:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("?????a ch???:");

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setText("Ch???c n??ng");

        btnThem.setBackground(new java.awt.Color(255, 255, 255));
        btnThem.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnThem.setText("Th??m");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(255, 255, 255));
        btnSua.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSua.setText("S???a");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 255, 255));
        btnXoa.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnXoa.setText("X??a");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("T??m ki???m:");

        jtfTimKiem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfTimKiemKeyReleased(evt);
            }
        });

        cbbTimKiem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "T??n tr???m", "?????a ch???" }));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("S???p x???p:");

        cbbSapXep.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbbSapXep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "T??n tr???m a-z", "T??n tr???m z-a" }));
        cbbSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSapXepActionPerformed(evt);
            }
        });

        jtbDanhSachTram.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtbDanhSachTram.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "T??n tr???m", "?????a ch???"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbDanhSachTram.setGridColor(new java.awt.Color(255, 255, 255));
        jtbDanhSachTram.setRowHeight(25);
        jtbDanhSachTram.setSelectionBackground(new java.awt.Color(102, 204, 255));
        jtbDanhSachTram.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtbDanhSachTram.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbDanhSachTramMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jtbDanhSachTram);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(235, 235, 235)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton2)
                            .addGap(56, 56, 56)
                            .addComponent(btnThem)
                            .addGap(76, 76, 76)
                            .addComponent(btnSua)
                            .addGap(78, 78, 78)
                            .addComponent(btnXoa))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(2, 2, 2)
                            .addComponent(jtfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(cbbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(188, 188, 188)
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtfTenTram, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtfDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator2)
                        .addComponent(jSeparator1)))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(344, 344, 344))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfTenTram, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jtfDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cbbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new ChuyenManHinhView(this, new JPanelQuanLiTuyen()).change();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbbSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSapXepActionPerformed
        // TODO add your handling code here:
        tbmBangTram.setRowCount(0);
        if (cbbSapXep.getSelectedIndex() == 0)// ten tram a-z
        {
            try {
                tramDao.loadDSTramVaoBang(LopKetNoi.select("select * from tram order by tenTram ASC"), tbmBangTram);
            } catch (Exception e) {
            }
        } else {// ten tram z-a
            try {
                tramDao.loadDSTramVaoBang(LopKetNoi.select("select * from tram order by tenTram DESC"), tbmBangTram);
            } catch (Exception e) {
            }
        }
        hangDangChon = -1;
        setRong();
    }//GEN-LAST:event_cbbSapXepActionPerformed

    private void jtfTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTimKiemKeyReleased
        // TODO add your handling code here:
        if (cbbTimKiem.getSelectedIndex() == 0) {// tim kiem theo ten tr???m
            try {
                // tim kiem theo ma ca tram bd va kt
                String tenTram = jtfTimKiem.getText().trim().toUpperCase();
                tramDao.loadDSTramVaoBang(LopKetNoi.select("select * from tram where tenTram like ?", "%" + tenTram + "%"), tbmBangTram);
            } catch (Exception ex) {
                Logger.getLogger(JPanelDanhSachTram.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            try {
                // tim kiem theo ma ca tram bd va kt
                String diaChi = jtfTimKiem.getText().trim();
                tramDao.loadDSTramVaoBang(LopKetNoi.select("select * from tram where diaChi like ?", "%" + diaChi + "%"), tbmBangTram);
            } catch (Exception ex) {
                Logger.getLogger(JPanelDanhSachTram.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        hangDangChon = -1;
        setRong();
    }//GEN-LAST:event_jtfTimKiemKeyReleased

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (hangDangChon == -1) {
            JOptionPane.showMessageDialog(this, "Vui l??ng ch???n 1 d??ng ????? x??a");
        } else {
            xoaTram();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // kiem tra cac rang buoc
        hienThiDialog("TH??M TR???M");
    }//GEN-LAST:event_btnThemActionPerformed

    private void hienThiDialog(String title) {
        jdlThemSuaTram.setLocationRelativeTo(this);
        jdlThemSuaTram.setVisible(true);
        jdlThemSuaTram.setTitle(title);
        jlbTenDialog.setText(title);
        if (title.equals("TH??M TR???M")) {
            jtfTenTramDialog.setEditable(true);
            jtfDiaChiDialog.setEditable(true);
            jtfTenTramDialog.setText("");
            jtfDiaChiDialog.setText("");
        } else {
            jtfTenTramDialog.setText(jtfTenTram.getText());
            jtfDiaChiDialog.setText(jtfDiaChi.getText());
            jtfTenTramDialog.setEditable(true);
            jtfDiaChiDialog.setEditable(true);
        }
    }
    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        // kiem tra rang buoc
        if (hangDangChon == -1) {
            JOptionPane.showMessageDialog(this, "Vui l??ng ch???n 1 d??ng mu???n s???a");
        } else
            hienThiDialog("S???A TR???M");
    }//GEN-LAST:event_btnSuaActionPerformed

    private void jtbDanhSachTramMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbDanhSachTramMousePressed
        // TODO add your handling code here:
        hangDangChon = jtbDanhSachTram.getSelectedRow();
        tramDao.getTramTuBang(hangDangChon, jtbDanhSachTram, jtfTenTram, jtfDiaChi);
    }//GEN-LAST:event_jtbDanhSachTramMousePressed

    private void setRong() {
        jtfTenTram.setText("");
        jtfDiaChi.setText("");
    }

    private void capNhatSauKhiThem() {
        jtfTenTram.setText(jtfTenTramDialog.getText().trim().toUpperCase());
        jtfDiaChi.setText(jtfDiaChiDialog.getText().trim());
        jtfTenTramDialog.setText("");
        jtfDiaChiDialog.setText("");
        jlbTenTramDialog.setText("T??n tr???m kh??ng ???????c r???ng");
        jtfTenTramDialog.requestFocus();
        hangDangChon = jtbDanhSachTram.getRowCount() - 1;
    }

    private void themTram() {
        if (!jlbTenTramDialog.getText().equals(" ")) { // l?? b??? ?????
            JOptionPane.showMessageDialog(jdlThemSuaTram, "Th??m th???t b???i");
            jtfTenTramDialog.requestFocus();
        } else {
            String tenTram = jtfTenTramDialog.getText().trim().toUpperCase();
            String diaChi = jtfDiaChiDialog.getText().trim();
            //them vao csdl va bang
            Tram tram = new Tram(tenTram, diaChi);
            tramDao.themTramVaoDB(tram);
            tramDao.themTramVaoBang(tram, jtbDanhSachTram);
            JOptionPane.showMessageDialog(jdlThemSuaTram, "Th??m th??nh c??ng");
            //cap nhat lai cac truong
            capNhatSauKhiThem();
        }
    }

    private void suaTram() {
        String tenTram = jtfTenTram.getText();
        String diaChi = jtfDiaChiDialog.getText().trim();
        //============================================================
        Tram tram = new Tram(tenTram, diaChi);
        tramDao.suaTramTrongBang(tram, hangDangChon, jtbDanhSachTram);
        tramDao.suaTramTrongDB(tram);
        //===== cap nhat lai mot so thong tin
        jtfDiaChi.setText(diaChi);
    }

    private void xoaTram() {
        int input = JOptionPane.showConfirmDialog(this, "B???n ch???n ch???n mu???n x??a ch????", "Th??ng b??o", JOptionPane.YES_NO_OPTION);
        if (input == JOptionPane.YES_OPTION) {
            boolean kt = tramDao.xoaTramTrongDB(jtfTenTram.getText());
            if (kt) {
                tramDao.xoaTramKhoiBang(hangDangChon, tbmBangTram);
                hangDangChon = -1;
                jtfTenTram.setText("");
                jtfDiaChi.setText("");
                jtbDanhSachTram.clearSelection();
            }else{
                JOptionPane.showMessageDialog(this, "Kh??ng th??? x??a v?? c?? tuy???n ??i qua tr???m n??y");
            }

            //===================================
        }
    }
    private void btnXacNhanDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanDialogActionPerformed
        // TODO add your handling code here:
        if (jdlThemSuaTram.getTitle().equalsIgnoreCase("Th??m tr???m")) {
            themTram();
        } else {
            suaTram();
            jdlThemSuaTram.dispose();
        }
    }//GEN-LAST:event_btnXacNhanDialogActionPerformed

    private void jtfTenTramDialogKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTenTramDialogKeyReleased
        // TODO add your handling code here:
        String tenTram = jtfTenTramDialog.getText().toUpperCase();
        if (!tenTram.equals("")) {
            jlbTenTramDialog.setText(" ");
            try {
                ResultSet rs = LopKetNoi.select("select * from Tram where tenTram = ?", tenTram);
                if (rs.next()) {
                    jlbTenTramDialog.setText("T??n tr???m b??? tr??ng");
                } else {
                    jlbTenTramDialog.setText(" ");
                }
            } catch (Exception e) {
            }
        } else {
            jlbTenTramDialog.setText("T??n tr???m kh??ng ???????c r???ng");
        }
    }//GEN-LAST:event_jtfTenTramDialogKeyReleased

    private void jtfTenTramDialogKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTenTramDialogKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            jtfDiaChiDialog.requestFocus();
        }
    }//GEN-LAST:event_jtfTenTramDialogKeyPressed

    private void jtfDiaChiDialogKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDiaChiDialogKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_UP) {
            jtfTenTramDialog.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            btnXacNhanDialog.requestFocus();
        }
    }//GEN-LAST:event_jtfDiaChiDialogKeyPressed

    private void btnXacNhanDialogKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnXacNhanDialogKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            themTram();
        }
    }//GEN-LAST:event_btnXacNhanDialogKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXacNhanDialog;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbSapXep;
    private javax.swing.JComboBox<String> cbbTimKiem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JDialog jdlThemSuaTram;
    private javax.swing.JLabel jlbTenDialog;
    private javax.swing.JLabel jlbTenTramDialog;
    private javax.swing.JTable jtbDanhSachTram;
    private javax.swing.JTextField jtfDiaChi;
    private javax.swing.JTextField jtfDiaChiDialog;
    private javax.swing.JTextField jtfTenTram;
    private javax.swing.JTextField jtfTenTramDialog;
    private javax.swing.JTextField jtfTimKiem;
    // End of variables declaration//GEN-END:variables
}
