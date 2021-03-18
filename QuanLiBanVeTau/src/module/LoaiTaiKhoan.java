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
public class LoaiTaiKhoan {
    private String maLoaiTaiKhoan, tenLoaiTaiKhoan;

    public LoaiTaiKhoan() {
    }

    public LoaiTaiKhoan(String maLoaiTaiKhoan, String tenLoaiTaiKhoan) {
        this.maLoaiTaiKhoan = maLoaiTaiKhoan;
        this.tenLoaiTaiKhoan = tenLoaiTaiKhoan;
    }

    public String getMaLoaiTaiKhoan() {
        return maLoaiTaiKhoan;
    }

    public void setMaLoaiTaiKhoan(String maLoaiTaiKhoan) {
        this.maLoaiTaiKhoan = maLoaiTaiKhoan;
    }

    public String getTenLoaiTaiKhoan() {
        return tenLoaiTaiKhoan;
    }

    public void setTenLoaiTaiKhoan(String tenLoaiTaiKhoan) {
        this.tenLoaiTaiKhoan = tenLoaiTaiKhoan;
    }
    
}
