/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package module;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TaiKhoan{
    private String tenTaiKhoan, matKhau, CMND, maLoaiTaiKhoan;

    public TaiKhoan() {
    }

    public TaiKhoan(String tenTaiKhoan, String matKhau, String CMND, String maLoaiTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
        this.matKhau = matKhau;
        this.CMND = CMND;
        this.maLoaiTaiKhoan = maLoaiTaiKhoan;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getMaLoaiTaiKhoan() {
        return maLoaiTaiKhoan;
    }

    public void setMaLoaiTaiKhoan(String maLoaiTaiKhoan) {
        this.maLoaiTaiKhoan = maLoaiTaiKhoan;
    }
    
}
