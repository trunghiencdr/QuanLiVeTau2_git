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
public class Ve {
    private String maVe, tenTaiKhoan;
    private int choNgoi;
    private Date thoiGianLenTau, thoiGianDen;
    private String trangThaiVe, trangThaiThanhToan;
    private float gia;
    private String maLoaiVe, maToa;

    public Ve() {
    }

    public Ve(String maVe, String tenTaiKhoan, int choNgoi, Date thoiGianLenTau, Date thoiGianDen, 
            String trangThaiVe, String trangThaiThanhToan, float gia, String maLoaiVe, String maToa) {
        this.maVe = maVe;
        this.tenTaiKhoan = tenTaiKhoan;
        this.choNgoi = choNgoi;
        this.thoiGianLenTau = thoiGianLenTau;
        this.thoiGianDen = thoiGianDen;
        this.trangThaiVe = trangThaiVe;
        this.trangThaiThanhToan = trangThaiThanhToan;
        this.gia = gia;
        this.maLoaiVe = maLoaiVe;
        this.maToa = maToa;
    }

    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public int getChoNgoi() {
        return choNgoi;
    }

    public void setChoNgoi(int choNgoi) {
        this.choNgoi = choNgoi;
    }

    public Date getThoiGianLenTau() {
        return thoiGianLenTau;
    }

    public void setThoiGianLenTau(Date thoiGianLenTau) {
        this.thoiGianLenTau = thoiGianLenTau;
    }

    public Date getThoiGianDen() {
        return thoiGianDen;
    }

    public void setThoiGianDen(Date thoiGianDen) {
        this.thoiGianDen = thoiGianDen;
    }

    public String getTrangThaiVe() {
        return trangThaiVe;
    }

    public void setTrangThaiVe(String trangThaiVe) {
        this.trangThaiVe = trangThaiVe;
    }

    public String getTrangThaiThanhToan() {
        return trangThaiThanhToan;
    }

    public void setTrangThaiThanhToan(String trangThaiThanhToan) {
        this.trangThaiThanhToan = trangThaiThanhToan;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public String getMaLoaiVe() {
        return maLoaiVe;
    }

    public void setMaLoaiVe(String maLoaiVe) {
        this.maLoaiVe = maLoaiVe;
    }

    public String getMaToa() {
        return maToa;
    }

    public void setMaToa(String maToa) {
        this.maToa = maToa;
    }
    
}
