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

        String url = "jdbc:sqlserver://;databaseName=QuanLiVeTau";
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
        String url = "jdbc:sqlserver://;databaseName=QuanLiVeTau";
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

}
