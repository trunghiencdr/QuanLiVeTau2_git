/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package module;

import java.util.Date;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ThoiGianHoatDong {
    private String maThoiGianHoatDong;
    private String tenThoiGianHoatDong;
    private Date ngayBatDau;
    private Date ngayKetThuc;

    public ThoiGianHoatDong() {
    }

    public ThoiGianHoatDong(String maThoiGianHoatDong, String tenThoiGianHoatDong, Date ngayBatDau, Date ngayKetThuc) {
        this.maThoiGianHoatDong = maThoiGianHoatDong;
        this.tenThoiGianHoatDong = tenThoiGianHoatDong;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getMaThoiGianHoatDong() {
        return maThoiGianHoatDong;
    }

    public void setMaThoiGianHoatDong(String maThoiGianHoatDong) {
        this.maThoiGianHoatDong = maThoiGianHoatDong;
    }

    public String getTenThoiGianHoatDong() {
        return tenThoiGianHoatDong;
    }

    public void setTenThoiGianHoatDong(String tenThoiGianHoatDong) {
        this.tenThoiGianHoatDong = tenThoiGianHoatDong;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
    
}
