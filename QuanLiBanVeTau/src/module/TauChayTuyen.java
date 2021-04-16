/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module;

import java.sql.Timestamp;

/**
 *
 * @author Tuong
 */
public class TauChayTuyen {
    private String maTau, maTuyen;
    private Timestamp thoiGianKhoiHanh, thoiGianDen;

    public String getMaTau() {
        return maTau;
    }

    public String getMaTuyen() {
        return maTuyen;
    }

    public Timestamp getThoiGianKhoiHanh() {
        return thoiGianKhoiHanh;
    }

    public Timestamp getThoiGianDen() {
        return thoiGianDen;
    }

    public void setMaTau(String maTau) {
        this.maTau = maTau;
    }

    public void setMaTuyen(String maTuyen) {
        this.maTuyen = maTuyen;
    }

    public void setThoiGianKhoiHanh(Timestamp thoiGianKhoiHanh) {
        this.thoiGianKhoiHanh = thoiGianKhoiHanh;
    }

    public void setThoiGianDen(Timestamp thoiGianDen) {
        this.thoiGianDen = thoiGianDen;
    }
    
}
