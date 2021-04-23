/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledao;

import DungChung.StringDungChung;
import com.github.lgooddatepicker.components.DatePicker;
import connectSQL.LopKetNoi;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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
    
    static final int thoiGianNghiTuyen = 1; // giờ
    static final int thoiGianDoiTuyen = 3; // ngày
    static final int thoiGianTauTrungTuyen = 1; // trùng tuyến trùng ngày bd và kt thì phải cách nhau 1 giờ

    public static boolean kiemTraMaTrung(String ma) {
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
                String ma = rs.getString("maChuyen");
                String maTau = rs.getString("maTau");
                String maTuyen = rs.getString("maTuyen");
                LocalDateTime thoiGianKH = rs.getTimestamp("thoiGianKhoiHanh").toLocalDateTime();
                LocalDateTime thoiGianDen = getThoiGianKT(maTuyen, thoiGianKH);
//                LocalDate ngayBD = rs.getDate(5).toLocalDate();
                LocalDate ngayBD = thoiGianKH.toLocalDate();
                LocalDate ngayKT = rs.getDate("ngayKetThuc").toLocalDate();
                String trangThai = rs.getString("trangThai");
                model.addRow(new Object[]{ma, maTau, maTuyen, thoiGianKH, thoiGianDen, ngayBD, ngayKT, trangThai});
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
    public static ArrayList<String> getLichTrinhTau(String maTau) {
        ArrayList<String> lichTrinh = new ArrayList<>();
        try {
            ResultSet rs = LopKetNoi.select("select thoiGianKhoiHanh, ngayKetThuc, trangThai"
                    + " from Chuyen where maTau = ?", maTau);
            while (rs.next()) {
                System.out.println("vao lich trinh tau");
                LocalDateTime thoiGianKH = rs.getTimestamp("thoiGianKhoiHanh").toLocalDateTime();
                lichTrinh.add(thoiGianKH + " đến " + getThoiGianKT(maTau, thoiGianKH) + ", từ ngày "
                        + thoiGianKH.toLocalDate() + " đến " + rs.getDate("ngayKetThuc") + " " + rs.getString("trangThai"));
            }
        } catch (Exception e) {
            System.out.println("get lich trinh tau that bai");
        }
        return lichTrinh;
    }
    
    public static LocalDateTime getThoiGianKT(String maTuyen, LocalDateTime thoiGianKH) {
        int tongThoiGian = 0;
        try {
            ResultSet rs = LopKetNoi.select("select thoiGianDen from tuyendiquatram where maTuyen = ?", maTuyen);
            while (rs.next()) {
                tongThoiGian += rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("get thoi gian kt that bai");
        }
        System.out.println(tongThoiGian + thoiGianKH.plusMinutes(tongThoiGian).toString());
        return thoiGianKH.plusMinutes(tongThoiGian);
    }
    
    public static ArrayList<String> getDSTramDiQua(String maTuyen) {
        ArrayList<String> DS = new ArrayList<>();
        try {
            ResultSet rs = LopKetNoi.select("select tenTram from TuyenDiQuaTram where maTuyen=? order by thoiGianDen ASC", maTuyen);
            while (rs.next()) {
                DS.add(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("get ds tram di qua that bai");
        }
        return DS;
    }
    
    private static String getTramBDVaKetThuc(ArrayList<String> DS) {
        return DS.get(0) + "-" + DS.get(DS.size() - 1);
    }
    
    public static ArrayList<String> getDSTramBDVaKetThuc(ResultSet rsMaTuyen) {
        ArrayList<String> DSTramBDKT = new ArrayList<>();
        try {
            while (rsMaTuyen.next()) {
                String maTuyen = rsMaTuyen.getString(1);
                DSTramBDKT.add(getTramBDVaKetThuc(getDSTramDiQua(maTuyen)));
            }
        } catch (Exception e) {
            System.out.println("get ds tram bd va ket thuc that bai");
        }
        return DSTramBDKT;
    }
    
    public static ArrayList<String> getDSMaTau(ResultSet rsMaTau) {
        ArrayList<String> DSMaTau = new ArrayList<>();
        try {
            while (rsMaTau.next()) {
                DSMaTau.add(rsMaTau.getString(1));
                
            }
        } catch (Exception e) {
            System.out.println("get ds ma tau that bai");
        }
        return DSMaTau;
    }

//    public static String getMaThoiGianTuDate(Date ngayBD, Date ngayKT) {
//        String ma = null;
//        try {
//            ResultSet rs = LopKetNoi.select("select maThoiGianHoatDong from KhoangThoiGianHoatDong where ngayBatDau = ? and "
//                    + "ngayKetThuc = ?", ngayBD, ngayKT);
//            if (rs.next()) {
//                ma = rs.getString(1);
//            }
//        } catch (Exception e) {
//            System.out.println("get ma thoi gian that bai");
//        }
//        return ma;
//    }
    public static boolean kiemTraNgayBatDauVaKetThuc(LocalDate ngayBD, LocalDate ngayKT) {
        // chia 2 trường hợp: 1 là nếu ngaybd và kt nằm trước 1 thằng trong bảng
        // th2 là nếu ngaybd và kt nằm sau 1 thằng 
        try {
            ResultSet rs = LopKetNoi.select("select ngayBatDau, ngayKetThuc from chuyen order by ngayBatDau "
                    + "ASC");
            //th1
            while (rs.next()) {
                LocalDate ngayBDSql = rs.getDate(1).toLocalDate();
                LocalDate ngayKTSql = rs.getDate(2).toLocalDate();

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
    
    public static boolean kiemTraDSNgayBDVaKT(String maTau) {
        try {
            ResultSet rs = LopKetNoi.select("select ngayBatDau, ngayKetThuc", maTau);
            while (rs.next()) {
                if (!kiemTraNgayBatDauVaKetThuc(rs.getDate(1).toLocalDate(), rs.getDate(2).toLocalDate())) {
                    return false;
                }
            }
        } catch (Exception e) {
            System.out.println("Kiem tra ds ngay bd va kt that bai");
        }
        return true;
    }
    
//    public static boolean kiemTraThoiGian(LocalTime thoiGianKH, LocalTime thoiGianKT) {
//        try {
//            
//        } catch (Exception e) {
//        }
//    }
    
    public static boolean kiemTraNgayBDVaKetThuc(LocalDate ngayBD1, LocalDate ngayKT1, LocalDate ngayBD2, LocalDate ngayKT2) {
        if (ngayBD1.compareTo(ngayBD2) >= 0 && ngayBD1.compareTo(ngayKT2) <= 0) {
            return false;
        }
        if (ngayKT1.compareTo(ngayBD2) >= 0 && ngayKT1.compareTo(ngayKT2) <= 0) {
            return false;
        }
        return true; // không trùng ngày

    }
    
    public static String kiemTraLichTrinhTau(Chuyen chuyen) {
        String thongBao = "";
        String maTau = chuyen.getMaTau();
        LocalDateTime tgKhoiHanh = chuyen.getThoiGianKH();
        LocalDateTime tgKetThuc = chuyen.getThoiGianDen();
        LocalDate ngayBatDau = tgKhoiHanh.toLocalDate();
        LocalDate ngayKetThuc = chuyen.getNgayKetThuc();
        try {
            ResultSet rsLichTrinhTau = LopKetNoi.select("select maTuyen, thoiGianKhoiHanh, ngayKetThuc, trangThai"
                    + " from Chuyen where maTau = ?", maTau);
            while (rsLichTrinhTau.next()) {// nếu có mã tàu thì kiểm tra ngày bd và kt có trùng không
                System.out.println("Toi day roi vao rslichtrinh");
                String maTuyen = rsLichTrinhTau.getString("maTuyen");
                LocalDateTime tgKhoiHanhSql = rsLichTrinhTau.getTimestamp("thoiGianKhoiHanh").toLocalDateTime();
                LocalDateTime tgDenSql = getThoiGianKT(maTuyen, tgKhoiHanhSql);
                LocalDate ngayBDSql = tgKhoiHanhSql.toLocalDate();
                LocalDate ngayKTSql = rsLichTrinhTau.getDate("ngayKetThuc").toLocalDate();
                String trangThai = rsLichTrinhTau.getString("trangThai");
                if (!kiemTraNgayBDVaKetThuc(ngayBatDau, ngayKetThuc, ngayBDSql, ngayKTSql)) {//nếu trùng ngày thì kiểm tra tuyền
                    // th1 trùng tuyến thì xem nếu lượt đi-về thì + 1 giờ, đi-đi thì cộng thêm thời gian đi + 2.1 giờ
                    // th2 khác tuyến thì + 3 ngày mới được đổi tuyến.
                    System.out.println("trung ngay");
                    if (chuyen.getMaTuyen().equals(maTuyen)) {
                        if (chuyen.getTrangThai().equals(trangThai)) {
                            // nếu đi-đi or về về thì cộng thêm khoảng thời gian và cộng thêm 2.1 giờ
                            LocalDateTime yeuCauTGD = tgDenSql.plusMinutes(ChronoUnit.MINUTES.between(tgKhoiHanhSql,
                                    tgDenSql) + 2 * thoiGianNghiTuyen * 60);
                            LocalDateTime yeuCauTGKH = tgKhoiHanhSql.minusMinutes(ChronoUnit.MINUTES.between(tgKhoiHanhSql,
                                    tgDenSql) + 2 * thoiGianNghiTuyen * 60);
                            if (tgKhoiHanh.compareTo(yeuCauTGD) < 0 && tgKhoiHanh.compareTo(yeuCauTGKH) > 0) {// nếu lớn hơn thời gian yêu cầu thì ok
                                return "Thời gian KH phải lớn hơn hoặc bằng thời gian đến + thời gian đi + 2." + thoiGianNghiTuyen + "giờ";
                            }
                            if (tgKetThuc.compareTo(yeuCauTGKH) > 0 && tgKetThuc.compareTo(yeuCauTGD) < 0) {
                                return "Thời gian kết thúc phải nhỏ hơn hoặc bằng thời gian bd - thời gian đi + 2." + thoiGianNghiTuyen + "giờ";
                            }
                            
                        } else {// nếu khác trạng thái thì chỉ cần cộng thêm giờ nghỉ
                            LocalDateTime yeuCauTGKH = tgKhoiHanhSql.plusMinutes(thoiGianNghiTuyen * 60);
                            LocalDateTime yeuCauTGD = tgDenSql.minusMinutes(thoiGianNghiTuyen * 60);
                            
                            if (tgKhoiHanh.compareTo(yeuCauTGD) < 0 && tgKhoiHanh.compareTo(yeuCauTGKH) > 0) {// nếu nhỏ hơn thì loại ngay
                                return "Thời gian KH phải lớn hơn hoặc bằng thời gian đến + " + thoiGianNghiTuyen + "giờ";
                            }
                            
                            if (tgKetThuc.compareTo(yeuCauTGD) < 0 && tgKetThuc.compareTo(yeuCauTGKH) > 0) {// nếu nhỏ hơn thì loại ngay
                                return "Thời gian ket thuc phải bé hơn hoặc bằng thời gian đến - " + thoiGianNghiTuyen + "giờ";
                            }
                        }
                    } else {// nếu khác mã tuyến ý là muốn đổi tuyến thì phải đợi 3 ngày
                        LocalDateTime yeuCauTGD = tgDenSql.plusDays(thoiGianDoiTuyen);
                        LocalDateTime yeuCauTGKH = tgKhoiHanhSql.minusDays(thoiGianDoiTuyen);
                        if (tgKhoiHanh.compareTo(yeuCauTGD) < 0 && tgKhoiHanh.compareTo(yeuCauTGKH) > 0) {// nếu nhỏ hơn thì loại ngay
                            return "Đổi tuyến thì thời gian khởi hành phải bằng thời gian két thúc + thêm " + thoiGianDoiTuyen + "ngày";
                        }
                        
                        if (tgKetThuc.compareTo(yeuCauTGD) < 0 && tgKetThuc.compareTo(yeuCauTGKH) > 0) {// nếu nhỏ hơn thì loại ngay
                            return "Đổi tuyến thì thời gian kết thúc phải bằng thời gian khởi hành - đi " + thoiGianDoiTuyen + "ngày";
                        }
                    }
                }
            }// ngược lại thì không có tàu thì thêm thoải mái
            // nếu không trùng ngày thì thêm thoải mái nhưng trùng tuyến thì thời gian phải khác nhau
            // tiếp theo kiểm tra thời gian đó có bị trùng với tuyến nào không
            try {
                ResultSet rsLichTrinhTuyen = LopKetNoi.select("select thoiGianKhoiHanh, ngayKetThuc, trangThai"
                        + " from Chuyen where maTuyen = ?", chuyen.getMaTuyen());
                while (rsLichTrinhTuyen.next()) {// nếu có mã tàu thì kiểm tra ngày bd và kt có trùng không
                    LocalDateTime tgKhoiHanhSql = rsLichTrinhTuyen.getTimestamp("thoiGianKhoiHanh").toLocalDateTime();
                    LocalDateTime tgDenSql = getThoiGianKT(chuyen.getMaTuyen(), tgKhoiHanhSql);
                    LocalDate ngayBDSql = tgKhoiHanhSql.toLocalDate();
                    LocalDate ngayKTSql = rsLichTrinhTuyen.getDate("ngayKetThuc").toLocalDate();
                    String trangThai = rsLichTrinhTuyen.getString("trangThai");
                    if (!kiemTraNgayBDVaKetThuc(ngayBatDau, ngayKetThuc, ngayBDSql, ngayKTSql)) {//nếu trùng ngày thì kiểm tra thời gian
                        // nếu cùng đi - đi or về về thì thời gian kh phải cách nhau ra

                        if (chuyen.getTrangThai().equals(trangThai)) {
                            LocalDateTime yeuCauTGKH = tgKhoiHanhSql.minusMinutes(thoiGianTauTrungTuyen * 60);
                            LocalDateTime yeuCauTGKH2 = tgKhoiHanhSql.minusMinutes(thoiGianTauTrungTuyen * 60);
                            
                            if (tgKhoiHanh.compareTo(yeuCauTGKH) < 0 && tgKhoiHanh.compareTo(yeuCauTGKH2) > 0) {// nếu lớn hơn thời gian yêu cầu thì ok
                                return "Thời gian KH phải bằng thời gian kh +- " + thoiGianNghiTuyen + "giờ";
                            }
                            
                        }
                        // nếu khác trạng thái thì chỉ cần cộng thêm thêm thoải

                    }
                    
                }
            } catch (Exception e) {
                System.out.println("Kiểm tra lịch trình tuyến thât bại");
                return "Kiểm tra lịch trình tuyến thât bại";
            }
            // kiểm tra lịch trình tuyến nếu nằm trong ngày giống nhau thì giờ phải cách ra 1h

        } catch (Exception e) {
            System.out.println("kiểm tra lịch trình tàu thất bại");
            return "Kiểm tra lịch trình tau thât bại";
        }
        
        return "true";
    }
    
    public static boolean themChuyenVaoDB(Chuyen chuyen) {// thêm khi ngày bắt đầu của mới lớn hơn ngày kết thúc của cũ
        
            try {
                LopKetNoi.update("insert into Chuyen values(?,?,?,?,?,?)", chuyen.getMa(), chuyen.getMaTau(),
                        chuyen.getMaTuyen(), chuyen.getThoiGianKH(),chuyen.getNgayKetThuc(), chuyen.getTrangThai());
            } catch (Exception e) {
                System.out.println("Them chuyen that bai do loi or do trung khoa");
                return false;
            }
        return true;
    }
//

    public static void suaChuyenTrongDB(Chuyen chuyen) {// lười kiểm tra thời gian bd và kt có trùng cái cũ không
        LopKetNoi.update("update Chuyen set maTau=?, maTuyen=?, thoiGianKhoiHanh=?, ngayKetThuc=?, trangThai=?", 
                chuyen.getMa(), chuyen.getMaTuyen(), chuyen.getThoiGianKH(), chuyen.getThoiGianDen(), 
                chuyen.getNgayKetThuc(), chuyen.getTrangThai());
        
    }
////
//

    public static boolean xoaChuyenTrongDB(String maChuyen) {
        try {
            LopKetNoi.update("delete from Chuyen where maChuyen = ?", maChuyen);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
//

    public static void themChuyenVaoBang(Chuyen chuyen, JTable jtb) {
        DefaultTableModel model = (DefaultTableModel) jtb.getModel();
        model.addRow(new Object[]{chuyen.getMa(), chuyen.getMaTau(), chuyen.getMaTuyen(),
            chuyen.getThoiGianKH(), chuyen.getThoiGianDen(), chuyen.getNgayBatDau(),
            chuyen.getNgayKetThuc(), chuyen.getTrangThai()});
        int hangCuoi = jtb.getRowCount();
        jtb.scrollRectToVisible(jtb.getCellRect(hangCuoi - 1, 0, true));
        jtb.clearSelection();
        jtb.setRowSelectionInterval(hangCuoi - 1, hangCuoi - 1);
    }
////
//

    public static void suaChuyenTrongBang(Chuyen chuyen, int hang, JTable jtb) {
        jtb.setValueAt(chuyen.getMaTau(), hang, 1);
        jtb.setValueAt(chuyen.getMaTuyen(), hang, 2);
        jtb.setValueAt(chuyen.getThoiGianKH(), hang, 3);
        jtb.setValueAt(chuyen.getThoiGianDen(), hang, 4);
        jtb.setValueAt(chuyen.getNgayBatDau(), hang, 5);
        jtb.setValueAt(chuyen.getNgayKetThuc(), hang, 6);
        jtb.setValueAt(chuyen.getTrangThai(), hang, 7);
    }
    
    public static void xoaChuyenKhoiBang(int hang, DefaultTableModel model) {
        model.removeRow(hang);
    }
    
    public static void getChuyenTuBangVaoDAL(int hang, JTable jtb, JTextField jtfMa, JComboBox jcbbTau, JTextField jtfMaTuyen, JComboBox jcbbTramBDKT,
            JComboBox jcbbGio, JComboBox jcbbPhut, DatePicker dpNgayBD, DatePicker dpNgayKT, JComboBox jcbbTrangThai) {
        jtfMa.setText(jtb.getValueAt(hang, 0) + "");
        jcbbTau.setSelectedItem(jtb.getValueAt(hang, 1) + "");
        String maTuyen = jtb.getValueAt(hang, 2) + "";
        jtfMaTuyen.setText(maTuyen);
        String tramBDKT = getTramBDVaKetThuc(getDSTramDiQua(maTuyen));
        jcbbTramBDKT.setSelectedItem(tramBDKT);
        String[] thoiGian = jtb.getValueAt(hang, 3).toString().split(":");
        jcbbGio.setSelectedItem(thoiGian[0]);
        jcbbPhut.setSelectedItem(thoiGian[1]);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ngayBD = LocalDate.parse(jtb.getValueAt(hang, 4).toString(), dtf);
        LocalDate ngayKT = LocalDate.parse(jtb.getValueAt(hang, 5).toString(), dtf);
        dpNgayBD.setDate(ngayBD);
        dpNgayKT.setDate(ngayKT);
        jcbbTrangThai.setSelectedItem(jtb.getValueAt(hang, 6) + "");
    }
}
