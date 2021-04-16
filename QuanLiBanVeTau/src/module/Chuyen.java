/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package module;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Chuyen {
    private String ma;
    private String maTuyen;
    private String khoangThoiGian;
    private LocalTime thoiGianKH;
    private LocalTime thoiGianKT;
    private String trangThai;

    public Chuyen() {
    }

    public Chuyen(String ma, String maTuyen, String maThoiGian, LocalTime thoiGianKH, LocalTime thoiGianKT, String trangThai) {
       
        this.ma = ma;
        this.maTuyen = maTuyen;
        this.khoangThoiGian = maThoiGian;
        this.thoiGianKH = thoiGianKH;
        this.thoiGianKT = thoiGianKT;
        this.trangThai = trangThai;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getMaTuyen() {
        return maTuyen;
    }

    public void setMaTuyen(String maTuyen) {
        this.maTuyen = maTuyen;
    }

    public String getKhoangThoiGian() {
        return khoangThoiGian;
    }

    public void setKhoangThoiGian(String maThoiGian) {
        this.khoangThoiGian = maThoiGian;
    }

    public LocalTime getThoiGianKH() {
        return thoiGianKH;
    }

    public void setThoiGianKH(LocalTime thoiGianKH) {
        this.thoiGianKH = thoiGianKH;
    }

    public LocalTime getThoiGianKT() {
        return thoiGianKT;
    }

    public void setThoiGianKT(LocalTime thoiGianKT) {
        this.thoiGianKT = thoiGianKT;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
