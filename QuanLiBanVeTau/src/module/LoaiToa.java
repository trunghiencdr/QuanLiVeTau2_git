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
public class LoaiToa {
    private String maLoaiToa, tenLoaiToa;
    private int giaChoNgoi;
    public LoaiToa() {
    }

    public LoaiToa(String maLoaiToa, String tenLoaiToa, int giaChoNgoi) {
        this.maLoaiToa = maLoaiToa;
        this.tenLoaiToa = tenLoaiToa;
        this.giaChoNgoi = giaChoNgoi;
    }

    public String getMaLoaiToa() {
        return maLoaiToa;
    }

    public void setMaLoaiToa(String maLoaiToa) {
        this.maLoaiToa = maLoaiToa;
    }

    public String getTenLoaiToa() {
        return tenLoaiToa;
    }

    public void setTenLoaiToa(String tenLoaiToa) {
        this.tenLoaiToa = tenLoaiToa;
    }
    
}
