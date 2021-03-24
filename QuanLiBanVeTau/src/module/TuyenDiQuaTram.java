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
public class TuyenDiQuaTram {

    private String maTuyen, tenTram;
    private int STT;
    private int thoiGianDen, thoiGianDi;

    public TuyenDiQuaTram() {
    }

    public TuyenDiQuaTram(String maTuyen, String tenTram, int STT, int thoiGianDen, int thoiGianDi) {
        this.maTuyen = maTuyen;
        this.tenTram = tenTram;
        this.STT = STT;
        this.thoiGianDen = thoiGianDen;
        this.thoiGianDi = thoiGianDi;
    }

    public String getMaTuyen() {
        return maTuyen;
    }

    public void setMaTuyen(String maTuyen) {
        this.maTuyen = maTuyen;
    }

    public String getTenTram() {
        return tenTram;
    }

    public void setTenTram(String tenTram) {
        this.tenTram = tenTram;
    }

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public int getThoiGianDen() {
        return thoiGianDen;
    }

    public void setThoiGianDen(int thoiGianDen) {
        this.thoiGianDen = thoiGianDen;
    }

    public int getThoiGianDi() {
        return thoiGianDi;
    }

    public void setThoiGianDi(int thoiGianDi) {
        this.thoiGianDi = thoiGianDi;
    }

}
