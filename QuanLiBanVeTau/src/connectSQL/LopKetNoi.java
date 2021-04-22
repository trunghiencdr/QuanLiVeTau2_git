/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectSQL;

import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import module.*;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class LopKetNoi {

    private static Connection connection;

    public LopKetNoi() {

        String url = "jdbc:sqlserver://;databaseName=QuanLiVeTau2";
        String user = "sa";
        String pass = "123";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LopKetNoi.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Connection getConnection() {
        return this.connection;
    }

    public ResultSet selectQuery(String sql) {
        ResultSet rs = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<LoaiTaiKhoan> getDSLoaiTK() {
        ArrayList<LoaiTaiKhoan> listLoaiTK = new ArrayList<LoaiTaiKhoan>();
        String sql = "select * from LoaiTaiKhoan";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (true) {
                if (rs.next()) {
                    LoaiTaiKhoan s = new LoaiTaiKhoan();
                    s.setMaLoaiTaiKhoan(rs.getString("MaLoaiTaiKhoan"));
                    s.setTenLoaiTaiKhoan(rs.getString("TenLoaiTaiKhoan"));
                    listLoaiTK.add(s);
                } else {
                    break;
                }
            }

        } catch (Exception e) {
        }
        return listLoaiTK;
    }

    public TaiKhoan getTTTK(String TKCanTim) {
        String sql = "select * from TaiKhoan where TenTaiKhoan=?";
        TaiKhoan tk = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, TKCanTim);
            ResultSet rs = ps.executeQuery();
            while (true) {
                if (rs.next()) {
                    tk = new TaiKhoan();
                    tk.setTenTaiKhoan(rs.getString("TenTaiKhoan"));
                    tk.setMatKhau(rs.getString("MatKhau"));
                    tk.setMaLoaiTaiKhoan(rs.getString("MaLoaiTaiKhoan"));
                    tk.setCMND(rs.getString("CMND"));
                } else {
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return tk;
    }

    public TaiKhoan dangNhap(String TKCanTim, String MKCanTim) {   //Lấy thông tin tài khoản sẵn dùng để check xem tài khoản có trong CSDL không?
        String sql = "select * from TaiKhoan where TenTaiKhoan=? and MatKhau=?";
        TaiKhoan tk = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, TKCanTim);
            ps.setString(2, MKCanTim);
            ResultSet rs = ps.executeQuery();
            while (true) {
                if (rs.next()) {
                    tk = new TaiKhoan();
                    tk.setTenTaiKhoan(rs.getString("TenTaiKhoan"));
                    tk.setMatKhau(rs.getString("MatKhau"));
                    tk.setMaLoaiTaiKhoan(rs.getString("MaLoaiTaiKhoan"));
                    tk.setCMND(rs.getString("CMND"));
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tk;
    }

    public boolean addNguoiDung(NguoiDung s) {
        String sql = "insert into NguoiDung(CMND,SDT,Ten,Email,TenTaiKhoan) values(?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, s.getCMND());
            ps.setString(2, s.getSDT());
            ps.setString(3, s.getTen());
            ps.setString(4, s.getEmail());
            ps.setString(5, s.getTenTaiKhoan());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public NguoiDung getThongTinNguoiDung(String CMND) {
        String sql = "select * from NguoiDung where CMND=?";
        NguoiDung nguoiDung = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, CMND);
            ResultSet rs = ps.executeQuery();
            while (true) {
                if (rs.next()) {
                    nguoiDung = new NguoiDung();
                    nguoiDung.setCMND(rs.getString("CMND"));
                    nguoiDung.setSDT(rs.getString("SDT"));
                    nguoiDung.setTen(rs.getString("Ten"));
                    nguoiDung.setEmail(rs.getString("Email"));
                    nguoiDung.setTenTaiKhoan(rs.getString("TenTaiKhoan"));
                } else {
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return nguoiDung;
    }

    public boolean addTaiKhoan(TaiKhoan s) {
        String sql = "insert into TaiKhoan(TenTaiKhoan,MatKhau,MaLoaiTaiKhoan,CMND) values(?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, s.getTenTaiKhoan());
            ps.setString(2, s.getMatKhau());
            ps.setString(3, s.getMaLoaiTaiKhoan());
            ps.setString(4, s.getCMND());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void ketNoi() {
        String url = "jdbc:sqlserver://;databaseName=QuanLiVeTau2";
        String user = "sa";
        String pass = "123";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LopKetNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ResultSet select(String sql, Object... args) {
        ketNoi();
        ResultSet rs = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
        } catch (SQLException e) {
        }
        return rs;
    }

    public static boolean update(String sql, Object... args) {
        ketNoi();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("xoa khong thanh cong");
            return false; // khóa bị trùng khi thêm , còn sửa và xóa thì chắc là không lỗi đâu
        }
        return true;
    }

    public boolean updateMatKhau(TaiKhoan s) //y nghia: update mat khau cua tai khoan nay!
    {
        String sql = "update TaiKhoan set MatKhau=? where TenTaiKhoan=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, s.getMatKhau());
            ps.setString(2, s.getTenTaiKhoan());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateNguoiDung(NguoiDung s) {
        String sql = "update NguoiDung set SDT=?, Ten=?, Email=? where CMND=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, s.getSDT());
            ps.setString(2, s.getTen());
            ps.setString(3, s.getEmail());
            ps.setString(4, s.getCMND());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<Tram> getDSTram() {
        ArrayList<Tram> listTram = new ArrayList<Tram>();
        String sql = "select * from Tram";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (true) {
                if (rs.next()) {
                    Tram s = new Tram();
                    s.setMaTram(rs.getString("MaTram"));
                    s.setTenTram(rs.getString("TenTram"));
                    listTram.add(s);
                } else {
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTram;
    }
    public ArrayList<TuyenDiQuaTram> getTuyenPhuHop(String maTramDi, String maTramDen) {     //Hàm lấy danh sách mã tuyến phù hợp với yêu cầu trạm đi và trạm đến
        ArrayList<TuyenDiQuaTram> listTuyen = new ArrayList<TuyenDiQuaTram>();
        String sql = "select table1.MaTuyen, table1.MaTram as MaTramDi, table1.STT as STTDi, table2.MaTram as MaTramDen, table2.STT as STTDen from TuyenDiQuaTram as table1\n" +
        "join TuyenDiQuaTram as table2\n" +
        "on  table1.MaTuyen=table2.MaTuyen and table1.MaTram=? and table2.MaTram=? and table1.STT<table2.STT;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maTramDi);
            ps.setString(2, maTramDen);
            ResultSet rs = ps.executeQuery();
            while (true) {
                if (rs.next()) {
                    TuyenDiQuaTram s=new TuyenDiQuaTram();
                    s.setMaTuyen(rs.getString("MaTuyen"));
                    s.setMaTramDi(rs.getString("MaTramDi"));
                    s.setMaTramDen(rs.getString("MaTramDen"));
                    s.setSTTDi(rs.getInt("STTDi"));
                    s.setSTTDen(rs.getInt("STTDen"));
                    listTuyen.add(s);
                } else {
                    break;
                }
            }

        } catch (Exception e) {
        }
        return listTuyen;
    }
    public ArrayList<TauChayTuyen> getTauTheoMaTuyen(String maTuyen,String ngayDi) {     //Hàm lấy danh sách tàu theo mã tuyến
        ArrayList<TauChayTuyen> listTau = new ArrayList<TauChayTuyen>();
        String sql = "select * from TauChayTuyen where MaTuyen=? and ThoiGianDen > ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maTuyen);
            ps.setString(2, ngayDi);
            ResultSet rs = ps.executeQuery();
            while (true) {
                if (rs.next()) {
                    TauChayTuyen s=new TauChayTuyen();
                    s.setMaTau(rs.getString("MaTau"));
                    s.setThoiGianKhoiHanh(rs.getTimestamp("ThoiGianKhoiHanh"));
                    listTau.add(s);
                } else {
                    break;
                }
            }

        } catch (Exception e) {
        }
        return listTau;
    }
    public TauChayTuyen getTauPhuHop(String maTuyen, int STTDi, int STTDen,String maTau,Timestamp thoiGianTauXuatPhat, String ngayCanTim) {     //Hàm lấy danh sách tàu theo mã tuyến
        TauChayTuyen thongTinTauPhuHop=null;
        String sql = "select * from [dbo].[tinhTauTuyenThoiGianTheoYeuCau](?,?,?,?,?,?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maTuyen);
            ps.setInt(2, STTDi);
            ps.setInt(3, STTDen);
            ps.setString(4, maTau);
            ps.setTimestamp(5, thoiGianTauXuatPhat);
            ps.setString(6, ngayCanTim);
            ResultSet rs = ps.executeQuery();
            while (true) {
                if (rs.next()) {
                    thongTinTauPhuHop = new TauChayTuyen();
                    thongTinTauPhuHop.setMaTau(rs.getString("MaTau"));
                    thongTinTauPhuHop.setMaTuyen(rs.getString("MaTuyen"));
                    thongTinTauPhuHop.setThoiGianKhoiHanh(rs.getTimestamp("ThoiGianTauXuatPhat"));//Thời gian tàu đi từ trạm mà khách chọn
                    thongTinTauPhuHop.setThoiGianDen(rs.getTimestamp("ThoiGianTauDenDich"));//Thời gian tàu đến đích mà khách chọn
                } else {
                    break;
                }
            }

        } catch (Exception e) {
        }
        return thongTinTauPhuHop;
    }
    public ArrayList<Toa> getToaTheoMaTau(String maTau) {     //Hàm lấy danh sách Toa theo mã Tàu
        ArrayList<Toa> listToa = new ArrayList<Toa>();
        String sql = "select * from Toa\n" +
"where MaToa in (select MaToa from ToaThuocTau where MaTau=?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maTau);
            ResultSet rs = ps.executeQuery();
            while (true) {
                if (rs.next()) {
                    Toa s=new Toa();
                    s.setMaToa(rs.getString("MaToa"));
                    s.setMaLoaiToa(rs.getString("MaLoaiToa"));
                    listToa.add(s);
                } else {
                    break;
                }
            }

        } catch (Exception e) {
        }
        return listToa;
    }
    public boolean addVe(String tenTaiKhoan,int choNgoi,Timestamp thoiGianLenTau, Timestamp thoiGianDen,float gia, String maLoaiVe, String maToa,String maTau) {
        String sql = "insert into Ve(TenTaiKhoan, ChoNgoi, ThoiGianLenTau, ThoiGianDen, Gia, MaLoaiVe, MaToa, MaTau) values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, tenTaiKhoan);
            ps.setInt(2, choNgoi);
            ps.setTimestamp(3, thoiGianLenTau);
            ps.setTimestamp(4, thoiGianDen);
            ps.setFloat(5, gia);
            ps.setString(6, maLoaiVe);
            ps.setString(7, maToa);
            ps.setString(8, maTau);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            if (e.getMessage().equals("Arithmetic overflow error converting IDENTITY to data type int."))
            {
                String sql2 = "DBCC CHECKIDENT (Ve, RESEED, 0)";//reset lại mã vé
                try {
                    PreparedStatement ps2 = connection.prepareStatement(sql2);
                    ps2.executeUpdate();
                    addVe(tenTaiKhoan,choNgoi,thoiGianLenTau, thoiGianDen,gia, maLoaiVe, maToa, maTau);
                }
                catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }
}
