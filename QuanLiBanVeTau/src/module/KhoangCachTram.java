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
public class KhoangCachTram {
    private String maKhoangCach;
    private String tenTramBD;
    private String tenTramKT;
    private float khoangCach;

    public KhoangCachTram() {
    }

    public KhoangCachTram(String maKhoangCach, String tenTramBD, String tenTramKT, float khoangCach) {
        this.maKhoangCach = maKhoangCach;
        this.tenTramBD = tenTramBD;
        this.tenTramKT = tenTramKT;
        this.khoangCach = khoangCach;
    }

    public String getMaKhoangCach() {
        return maKhoangCach;
    }

    public void setMaKhoangCach(String maKhoangCach) {
        this.maKhoangCach = maKhoangCach;
    }

    public String getTenTramBD() {
        return tenTramBD;
    }

    public void setTenTramBD(String tenTramBD) {
        this.tenTramBD = tenTramBD;
    }

    public String getTenTramKT() {
        return tenTramKT;
    }

    public void setTenTramKT(String tenTramKT) {
        this.tenTramKT = tenTramKT;
    }

    public float getKhoangCach() {
        return khoangCach;
    }

    public void setKhoangCach(float khoangCach) {
        this.khoangCach = khoangCach;
    }
    
}
