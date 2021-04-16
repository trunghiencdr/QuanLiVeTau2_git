/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledao;

import DungChung.StringDungChung;
import connectSQL.LopKetNoi;
import java.sql.ResultSet;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import module.Chuyen;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ChuyenDao {

    public boolean kiemTraMaTrung(String ma) {
        try {
            ResultSet rs = LopKetNoi.select("select maChuyen from Chuyen "
                    + "where maChuyen = ?", ma);
            if (rs.next()) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Kiem tra Ma trung bi loi");
        }
        return true;
    }

//    public static boolean kiemTraThoiGianTrung(String maTuyen, String maThoiGian, LocalTime tgKhoiHanh,
//            LocalTime tgDen, String trangThai) {// nếu mã tuyến mã thời gian trạng thái trùng thì kiểm tra thời gian 
//        
//        
//    }
    public static String thoiGianSangString(Date ngayBD, Date ngayKT) {
        return StringDungChung.DateSangString(ngayBD, "dd/MM/yyyy") + " đến " + StringDungChung.DateSangString(ngayKT, "dd/MM/yyyy");
    }

    public static void loadDSChuyenVaoBang(ResultSet rs, DefaultTableModel model) {
        model.setRowCount(0);
        try {
            while (rs.next()) {

                String ma = rs.getString(1);
                String maTuyen = rs.getString(2);
                String maThoiGian = rs.getString(3);
                LocalTime thoiGianKH = rs.getTime(4).toLocalTime();
                LocalTime thoiGianDen = rs.getTime(5).toLocalTime();
                String trangThai = rs.getString(6);
                System.out.println(maThoiGian);
                ResultSet rs1 = LopKetNoi.select("select ngayBatDau, ngayKetThuc from KhoangThoiGianHoatDong where "
                        + "maThoiGianHoatDong = ?", maThoiGian);
                System.out.println("Vao resultset");
                String khoangThoiGian = null;
                if (rs1.next()) {
                    khoangThoiGian = thoiGianSangString(rs1.getDate(1), rs1.getDate(2));
                }
                model.addRow(new Object[]{ma, maTuyen, khoangThoiGian, thoiGianKH, thoiGianDen, trangThai});
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("load ds chuyen vao bang that bai");
        }
    }

//    public boolean kiemTraThoiGianKHVaKetThuc(LocalTime tgKhoiHanh, LocalTime tgDen) {// xem co bi chong lap len nhau khong
//        // chia 2 trường hợp: 1 là nếu ngaybd và kt nằm trước 1 thằng trong bảng
//        // th2 là nếu ngaybd và kt nằm sau 1 thằng 
//        try {
//            ResultSet rs = LopKetNoi.select("select ngayBatDau, ngayKetThuc from KhoangThoiGianHoatDong order by ngayBatDau "
//                    + "ASC");
//            //th1
//            while (rs.next()) {
//                Date ngayBDSql = rs.getDate(1);
//                Date ngayKTSql = rs.getDate(2);
//
//                // kiem tra xem nó có cắt nhau không
//                // th1 là 1 trước một sau
//                if (ngayBD.compareTo(ngayBDSql) >= 0 && ngayBD.compareTo(ngayKTSql) <= 0) {
//                    return false;
//                }
//                if (ngayKT.compareTo(ngayBDSql) >= 0 && ngayKT.compareTo(ngayKTSql) <= 0) {
//                    return false;
//                }
//
//            }
//        } catch (Exception e) {
//            System.out.println("Loi");
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }
    public static LocalTime getThoiGianKT(String maTuyen, LocalTime thoiGianKH, float vanToc) {
        float tongKhoangCach = 0;
        try {
            ResultSet rs = LopKetNoi.select("select khoangCach where maTuyen = ? order by STT ASC", maTuyen);
            while (rs.next()) {
                tongKhoangCach += rs.getFloat(1);
            }
        } catch (Exception e) {
            System.out.println("get thoi gian kt that bai");
        }
        float thoiGian = Math.round(tongKhoangCach / vanToc * 10) / 10;
        int phut = (int) (thoiGian * 60);
        return thoiGianKH.plusMinutes(phut);
    }

    private static String getMaThoiGianTuString(String khoangThoiGian) {
        String[] temp = khoangThoiGian.split(" đến ");
        Date ngayBD = StringDungChung.StringSangDate(temp[0], "dd/MM/yyyy");
        Date ngayKT = StringDungChung.StringSangDate(temp[1], "dd/MM/yyyy");
        return getMaThoiGianTuDate(ngayBD, ngayKT);
    }

    private static String getMaThoiGianTuDate(Date ngayBD, Date ngayKT) {
        String ma = null;
        try {
            ResultSet rs = LopKetNoi.select("select maThoiGianHoatDong from KhoangThoiGianHoatDong where ngayBatDau = ? and "
                    + "ngayKetThuc = ?", ngayBD, ngayKT);
            if (rs.next()) {
                ma = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("get ma thoi gian that bai");
        }
        return ma;
    }

    public static boolean themChuyenVaoDB(Chuyen chuyen) {// thêm khi ngày bắt đầu của mới lớn hơn ngày kết thúc của cũ
        // kiem tra thoi gian hoat dong da ton tai chua
//        Date ngayBD = StringDungChung.StringSangDate(TGHD.getNgayBatDau(), "dd/MM/yyyy");
//        Date ngayKT = StringDungChung.StringSangDate(TGHD.getNgayKetThuc(), "dd/MM/yyyy");
        boolean kiemTra = true;
        if (kiemTra) {
            try {
                LopKetNoi.update("insert into Chuyen values(?,?,?,?,?,?)", chuyen.getMa(), chuyen.getMaTuyen(),
                        getMaThoiGianTuString(chuyen.getKhoangThoiGian()), chuyen.getThoiGianKH(), chuyen.getThoiGianKT(), chuyen.getTrangThai());
            } catch (Exception e) {
                System.out.println("Them chuyen that bai do loi or do trung khoa");
                return false;
            }

        } else {
            return false;
        }
        return true;
    }
//

    public static boolean suaChuyenTrongDB(Chuyen chuyen) {// lười kiểm tra thời gian bd và kt có trùng cái cũ không
        xoaChuyenTrongDB(chuyen.getMa());
        if (themChuyenVaoDB(chuyen)) {
            return true;
        } else {
            return false;
        }
    }
////
//

    public static boolean xoaChuyenTrongDB(String maChuyen) {
        try {
            LopKetNoi.update("delete from Chuyen where ma = ?", maChuyen);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
//

    public static void themChuyenVaoBang(Chuyen chuyen, JTable jtb) {
        DefaultTableModel model = (DefaultTableModel) jtb.getModel();
        model.addRow(new Object[]{chuyen.getMa(), chuyen.getMaTuyen(), chuyen.getKhoangThoiGian(),
            chuyen.getThoiGianKH(), chuyen.getThoiGianKT(), chuyen.getTrangThai()});
        int hangCuoi = jtb.getRowCount();
        jtb.scrollRectToVisible(jtb.getCellRect(hangCuoi - 1, 0, true));
        jtb.clearSelection();
        jtb.setRowSelectionInterval(hangCuoi - 1, hangCuoi - 1);
    }
////
//

    public static void suaChuyenTrongBang(Chuyen chuyen, int hang, JTable jtb) {
        jtb.setValueAt(chuyen.getMaTuyen(), hang, 1);
        jtb.setValueAt(chuyen.getKhoangThoiGian(), hang, 2);
        jtb.setValueAt(chuyen.getThoiGianKH(), hang, 3);
        jtb.setValueAt(chuyen.getThoiGianKT(), hang, 4);
        jtb.setValueAt(chuyen.getTrangThai(), hang, 5);
    }

    public static void xoaChuyenKhoiBang(int hang, DefaultTableModel model) {
        model.removeRow(hang);
    }

    public static void getChuyenTuBang(int hang, JTable jtb, JTextField ma, JTextField maTuyen,
            JComboBox khoangThoiGian, JTextField tgKhoiHanh, JTextField tgDen, JComboBox trangThai) {
        ma.setText(jtb.getValueAt(hang, 0) + "");
        maTuyen.setText(jtb.getValueAt(hang, 1) + "");
        khoangThoiGian.setSelectedItem(jtb.getValueAt(hang, 2) + "");
        tgKhoiHanh.setText(jtb.getValueAt(hang, 3) + "");
        tgDen.setText(jtb.getValueAt(hang, 4) + "");
        trangThai.setSelectedItem(jtb.getValueAt(hang, 5));
    }
}
