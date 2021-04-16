/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledao;

import DungChung.StringDungChung;
import com.toedter.calendar.JDateChooser;
import connectSQL.LopKetNoi;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.JTextField;
import module.ThoiGianHoatDong;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ThoiGianHoatDongDao {

    public boolean kiemTraMaTrung(String ma) {
        try {
            ResultSet rs = LopKetNoi.select("select maThoiGianHoatDong from KhoangThoiGianHoatDong "
                    + "where maThoiGianHoatDong = ?", ma);
            if (rs.next()) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Kiem tra Ma trung bi loi");
        }
        return true;
    }

    public void loadDSThoiGianVaoBang(ResultSet rs, DefaultTableModel model) {
        model.setRowCount(0);
        try {
            while (rs.next()) {
                String maThoiGian = rs.getString(1);
                String tenThoiGian = rs.getString(2);
                String ngayBatDau = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate(3));
                String ngayKetThuc = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate(4));
                model.addRow(new Object[]{maThoiGian, tenThoiGian, ngayBatDau, ngayKetThuc});
            }
        } catch (Exception e) {
        }
    }

    public boolean kiemTraNgayBatDauVaKetThuc(Date ngayBD, Date ngayKT) {
        // chia 2 trường hợp: 1 là nếu ngaybd và kt nằm trước 1 thằng trong bảng
        // th2 là nếu ngaybd và kt nằm sau 1 thằng 
        try {
            ResultSet rs = LopKetNoi.select("select ngayBatDau, ngayKetThuc from KhoangThoiGianHoatDong order by ngayBatDau "
                    + "ASC");
            //th1
            while (rs.next()) {
                Date ngayBDSql = rs.getDate(1);
                Date ngayKTSql = rs.getDate(2);

                // kiem tra xem nó có cắt nhau không
                // th1 là 1 trước một sau
                if (ngayBD.compareTo(ngayBDSql) >= 0 && ngayBD.compareTo(ngayKTSql) <= 0) {
                    return false;
                }
                if (ngayKT.compareTo(ngayBDSql) >= 0 && ngayKT.compareTo(ngayKTSql) <= 0) {
                    return false;
                }

            }
        } catch (Exception e) {
            System.out.println("Loi");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean themThoiGianVaoDB(ThoiGianHoatDong TGHD) {// thêm khi ngày bắt đầu của mới lớn hơn ngày kết thúc của cũ
        // kiem tra thoi gian hoat dong da ton tai chua
//        Date ngayBD = StringDungChung.StringSangDate(TGHD.getNgayBatDau(), "dd/MM/yyyy");
//        Date ngayKT = StringDungChung.StringSangDate(TGHD.getNgayKetThuc(), "dd/MM/yyyy");
//        boolean kiemTra = kiemTraNgayBatDauVaKetThuc(TGHD.getNgayBatDau(), TGHD.getNgayKetThuc());
boolean kiemTra = true;
        if (kiemTra) {
            try {
                LopKetNoi.update("insert into KhoangThoiGianHoatDong values(?,?,?,?)", TGHD.getMaThoiGianHoatDong(),
                        TGHD.getTenThoiGianHoatDong(), TGHD.getNgayBatDau(), TGHD.getNgayKetThuc());
            } catch (Exception e) {
                System.out.println("Them thoi gian that bai");
                return false;
            }

        } else {
            return false;
        }
        return true;
    }

    public boolean suaThoiGianTrongDB(ThoiGianHoatDong TGHD) {// lười kiểm tra thời gian bd và kt có trùng cái cũ không
        try {
            LopKetNoi.update("update KhoangThoiGianHoatDong set tenThoiGianHoatDong = ?,  ngayBatDau = ?, "
                    + "ngayKetThuc = ? where maThoiGianHoatDong =?", TGHD.getTenThoiGianHoatDong(),
                    TGHD.getNgayBatDau(), TGHD.getNgayKetThuc(), TGHD.getMaThoiGianHoatDong());
        } catch (Exception e) {
        }
        if (themThoiGianVaoDB(TGHD)) {
            return true;
        } else {
            return false;
        }
    }
//

    public boolean xoaThoiGianTrongDB(String maThoiGian) {
        try {
            LopKetNoi.update("delete from KhoangThoiGianHoatDong where maThoiGianHoatDong = ?", maThoiGian);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void themThoiGianVaoBang(ThoiGianHoatDong TGHD, JTable jtb) {
        DefaultTableModel model = (DefaultTableModel) jtb.getModel();
        String ngayBD = StringDungChung.DateSangString(TGHD.getNgayBatDau(), "dd/MM/yyyy");
        String ngayKT = StringDungChung.DateSangString(TGHD.getNgayKetThuc(), "dd/MM/yyyy");
        
        model.addRow(new Object[]{TGHD.getMaThoiGianHoatDong(), TGHD.getTenThoiGianHoatDong(),
            ngayBD, ngayKT});
        int hangCuoi = jtb.getRowCount();
        jtb.scrollRectToVisible(jtb.getCellRect(hangCuoi - 1, 0, true));
        jtb.clearSelection();
        jtb.setRowSelectionInterval(hangCuoi - 1, hangCuoi - 1);
    }
//

    public void suaThoiGianTrongBang(ThoiGianHoatDong TGHD, int hang, JTable jtb) {
        
        String ngayBD = StringDungChung.DateSangString(TGHD.getNgayBatDau(), "dd/MM/yyyy");
        String ngayKT = StringDungChung.DateSangString(TGHD.getNgayKetThuc(), "dd/MM/yyyy");
        jtb.setValueAt(TGHD.getTenThoiGianHoatDong(), hang, 1);
        jtb.setValueAt(ngayBD, hang, 2);
        jtb.setValueAt(ngayKT, hang, 3);
    }

    public void xoaThoiGianKhoiBang(int hang, DefaultTableModel model) {
        model.removeRow(hang);
    }

    public void getTuyenTuBang(int hang, JTable jtb, JTextField maThoiGian, JTextField tenThoiGian,
            JDateChooser ngayBatDau, JDateChooser ngayKetThuc) {
        Date ngayBD = StringDungChung.StringSangDate(jtb.getValueAt(hang, 2) + "", "dd/MM/yyyy");
        Date ngayKT = StringDungChung.StringSangDate(jtb.getValueAt(hang, 3) + "", "dd/MM/yyyy");
        maThoiGian.setText(jtb.getValueAt(hang, 0) + "");
        tenThoiGian.setText(jtb.getValueAt(hang, 1) + "");
        ngayBatDau.setDate(ngayBD);
        ngayKetThuc.setDate(ngayKT);
    }
}
