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
    private float heSo;
    public LoaiToa() {
    }

    public LoaiToa(String maLoaiToa, String tenLoaiToa, float heSo) {
        this.maLoaiToa = maLoaiToa;
        this.tenLoaiToa = tenLoaiToa;
        this.heSo = heSo;
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

    public float getHeSo() {
        return heSo;
    }

    public void setHeSo(float heSo) {
        this.heSo = heSo;
    }
    
}
