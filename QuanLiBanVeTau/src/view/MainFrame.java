/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.DanhMucBean;
import controller.ChuyenManHinhController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import module.TaiKhoan;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
//    TaiKhoan taiKhoan;
//
//    public TaiKhoan getTaiKhoan() {
//        return taiKhoan;
//    }
//      String tenTaiKhoan;
    public MainFrame(TaiKhoan tk) {
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        this.setUndecorated(true);
        initComponents();
        setLocationRelativeTo(this);
        this.setVisible(true);
        setTitle("Quản lí bán vé tàu");

        ChuyenManHinhController controller = new ChuyenManHinhController(jpnView);
        controller.setTaiKhoan(tk);
        controller.setView(jpnDatVe, jlbDatVe);

        List<DanhMucBean> list = new ArrayList<>();
        list.add(new DanhMucBean("DatVe", jpnDatVe, jlbDatVe));
        list.add(new DanhMucBean("QuanLiLoTrinh", jpnQuanLiLoTrinh, jlbQuanLiLoTrinh));
        list.add(new DanhMucBean("QuanLiTau", jpnQuanLiTau, jlbQuanLiTau));
        list.add(new DanhMucBean("QuanLiTuyen", jpnQuanLiTuyen, jlbQuanLiTuyen));
        list.add(new DanhMucBean("ThongKe", jpnThongKe, jlbThongKe));
        list.add(new DanhMucBean("CaiDatTaiKhoan", jpnCaiDatTaiKhoan, jlbCaiDatTaiKhoan));

        controller.setEvents(list);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnRoot = new javax.swing.JPanel();
        jpnMenu = new javax.swing.JPanel();
        jpnTenPhanMem = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpnDatVe = new javax.swing.JPanel();
        jlbDatVe = new javax.swing.JLabel();
        jpnQuanLiLoTrinh = new javax.swing.JPanel();
        jlbQuanLiLoTrinh = new javax.swing.JLabel();
        jpnThongKe = new javax.swing.JPanel();
        jlbThongKe = new javax.swing.JLabel();
        jpnQuanLiTuyen = new javax.swing.JPanel();
        jlbQuanLiTuyen = new javax.swing.JLabel();
        jpnQuanLiTau = new javax.swing.JPanel();
        jlbQuanLiTau = new javax.swing.JLabel();
        jpnCaiDatTaiKhoan = new javax.swing.JPanel();
        jlbCaiDatTaiKhoan = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jpnView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnRoot.setBackground(new java.awt.Color(102, 102, 102));

        jpnMenu.setBackground(new java.awt.Color(0, 0, 0));

        jpnTenPhanMem.setBackground(new java.awt.Color(51, 204, 255));

        jLabel1.setBackground(new java.awt.Color(51, 204, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/baseline_subway_black_18dp.png"))); // NOI18N
        jLabel1.setText("QUẢN LÝ BÁN VÉ TÀU");

        javax.swing.GroupLayout jpnTenPhanMemLayout = new javax.swing.GroupLayout(jpnTenPhanMem);
        jpnTenPhanMem.setLayout(jpnTenPhanMemLayout);
        jpnTenPhanMemLayout.setHorizontalGroup(
            jpnTenPhanMemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTenPhanMemLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jpnTenPhanMemLayout.setVerticalGroup(
            jpnTenPhanMemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTenPhanMemLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jpnDatVe.setBackground(new java.awt.Color(0, 0, 0));

        jlbDatVe.setBackground(new java.awt.Color(0, 0, 0));
        jlbDatVe.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlbDatVe.setForeground(new java.awt.Color(255, 255, 255));
        jlbDatVe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/baseline_shopping_cart_white_18dp.png"))); // NOI18N
        jlbDatVe.setText("Đặt vé");

        javax.swing.GroupLayout jpnDatVeLayout = new javax.swing.GroupLayout(jpnDatVe);
        jpnDatVe.setLayout(jpnDatVeLayout);
        jpnDatVeLayout.setHorizontalGroup(
            jpnDatVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnDatVeLayout.createSequentialGroup()
                .addGap(0, 29, Short.MAX_VALUE)
                .addComponent(jlbDatVe, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnDatVeLayout.setVerticalGroup(
            jpnDatVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbDatVe, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jpnQuanLiLoTrinh.setBackground(new java.awt.Color(0, 0, 0));

        jlbQuanLiLoTrinh.setBackground(new java.awt.Color(0, 0, 0));
        jlbQuanLiLoTrinh.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlbQuanLiLoTrinh.setForeground(new java.awt.Color(255, 255, 255));
        jlbQuanLiLoTrinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/baseline_wysiwyg_white_18dp.png"))); // NOI18N
        jlbQuanLiLoTrinh.setText("Quản lí lộ trình");

        javax.swing.GroupLayout jpnQuanLiLoTrinhLayout = new javax.swing.GroupLayout(jpnQuanLiLoTrinh);
        jpnQuanLiLoTrinh.setLayout(jpnQuanLiLoTrinhLayout);
        jpnQuanLiLoTrinhLayout.setHorizontalGroup(
            jpnQuanLiLoTrinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnQuanLiLoTrinhLayout.createSequentialGroup()
                .addGap(0, 29, Short.MAX_VALUE)
                .addComponent(jlbQuanLiLoTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnQuanLiLoTrinhLayout.setVerticalGroup(
            jpnQuanLiLoTrinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbQuanLiLoTrinh, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jpnThongKe.setBackground(new java.awt.Color(0, 0, 0));

        jlbThongKe.setBackground(new java.awt.Color(0, 0, 0));
        jlbThongKe.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlbThongKe.setForeground(new java.awt.Color(255, 255, 255));
        jlbThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/baseline_leaderboard_white_18dp.png"))); // NOI18N
        jlbThongKe.setText("Thống kê");

        javax.swing.GroupLayout jpnThongKeLayout = new javax.swing.GroupLayout(jpnThongKe);
        jpnThongKe.setLayout(jpnThongKeLayout);
        jpnThongKeLayout.setHorizontalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnThongKeLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnThongKeLayout.setVerticalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbThongKe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jpnQuanLiTuyen.setBackground(new java.awt.Color(0, 0, 0));

        jlbQuanLiTuyen.setBackground(new java.awt.Color(0, 0, 0));
        jlbQuanLiTuyen.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlbQuanLiTuyen.setForeground(new java.awt.Color(255, 255, 255));
        jlbQuanLiTuyen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/baseline_alt_route_white_18dp.png"))); // NOI18N
        jlbQuanLiTuyen.setText("Quản lí tuyến");

        javax.swing.GroupLayout jpnQuanLiTuyenLayout = new javax.swing.GroupLayout(jpnQuanLiTuyen);
        jpnQuanLiTuyen.setLayout(jpnQuanLiTuyenLayout);
        jpnQuanLiTuyenLayout.setHorizontalGroup(
            jpnQuanLiTuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnQuanLiTuyenLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbQuanLiTuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnQuanLiTuyenLayout.setVerticalGroup(
            jpnQuanLiTuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbQuanLiTuyen, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jpnQuanLiTau.setBackground(new java.awt.Color(0, 0, 0));

        jlbQuanLiTau.setBackground(new java.awt.Color(0, 0, 0));
        jlbQuanLiTau.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlbQuanLiTau.setForeground(new java.awt.Color(255, 255, 255));
        jlbQuanLiTau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/baseline_directions_subway_filled_white_18dp.png"))); // NOI18N
        jlbQuanLiTau.setText("Quản lí tàu");

        javax.swing.GroupLayout jpnQuanLiTauLayout = new javax.swing.GroupLayout(jpnQuanLiTau);
        jpnQuanLiTau.setLayout(jpnQuanLiTauLayout);
        jpnQuanLiTauLayout.setHorizontalGroup(
            jpnQuanLiTauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnQuanLiTauLayout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addComponent(jlbQuanLiTau, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnQuanLiTauLayout.setVerticalGroup(
            jpnQuanLiTauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbQuanLiTau, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jpnCaiDatTaiKhoan.setBackground(new java.awt.Color(0, 0, 0));

        jlbCaiDatTaiKhoan.setBackground(new java.awt.Color(0, 0, 0));
        jlbCaiDatTaiKhoan.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlbCaiDatTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        jlbCaiDatTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gear.png"))); // NOI18N
        jlbCaiDatTaiKhoan.setText("Cài đặt tài khoản");

        javax.swing.GroupLayout jpnCaiDatTaiKhoanLayout = new javax.swing.GroupLayout(jpnCaiDatTaiKhoan);
        jpnCaiDatTaiKhoan.setLayout(jpnCaiDatTaiKhoanLayout);
        jpnCaiDatTaiKhoanLayout.setHorizontalGroup(
            jpnCaiDatTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnCaiDatTaiKhoanLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbCaiDatTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnCaiDatTaiKhoanLayout.setVerticalGroup(
            jpnCaiDatTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbCaiDatTaiKhoan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jSeparator1.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenu.setLayout(jpnMenuLayout);
        jpnMenuLayout.setHorizontalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpnTenPhanMem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpnCaiDatTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnQuanLiTuyen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnQuanLiTau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnQuanLiLoTrinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnDatVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addComponent(jpnTenPhanMem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnMenuLayout.createSequentialGroup()
                        .addComponent(jpnDatVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jpnQuanLiLoTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jpnQuanLiTau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jpnQuanLiTuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jpnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jpnCaiDatTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 154, Short.MAX_VALUE))
                    .addComponent(jSeparator1)))
        );

        jpnView.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MainFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jlbCaiDatTaiKhoan;
    private javax.swing.JLabel jlbDatVe;
    private javax.swing.JLabel jlbQuanLiLoTrinh;
    private javax.swing.JLabel jlbQuanLiTau;
    private javax.swing.JLabel jlbQuanLiTuyen;
    private javax.swing.JLabel jlbThongKe;
    private javax.swing.JPanel jpnCaiDatTaiKhoan;
    private javax.swing.JPanel jpnDatVe;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JPanel jpnQuanLiLoTrinh;
    private javax.swing.JPanel jpnQuanLiTau;
    private javax.swing.JPanel jpnQuanLiTuyen;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JPanel jpnTenPhanMem;
    private javax.swing.JPanel jpnThongKe;
    private javax.swing.JPanel jpnView;
    // End of variables declaration//GEN-END:variables
}
