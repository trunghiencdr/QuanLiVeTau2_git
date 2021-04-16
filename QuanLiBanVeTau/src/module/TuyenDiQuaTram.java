/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module;

import java.sql.Timestamp;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TuyenDiQuaTram {

     private String maTuyen, maTramDi, maTramDen;
    private int STTDi, STTDen;
    private Timestamp gioDenTram, gioXuatTram;  //gioXuatTram lưu thời gian bắt đầu Tuyến con, gioDenTram lưu thời gian đến đích

    public String getMaTuyen() {
        return maTuyen;
    }

    public String getMaTramDi() {
        return maTramDi;
    }

    public String getMaTramDen() {
        return maTramDen;
    }

    public int getSTTDi() {
        return STTDi;
    }

    public int getSTTDen() {
        return STTDen;
    }

    public Timestamp getGioDenTram() {
        return gioDenTram;
    }

    public Timestamp getGioXuatTram() {
        return gioXuatTram;
    }

    public void setMaTuyen(String maTuyen) {
        this.maTuyen = maTuyen;
    }

    public void setMaTramDi(String maTramDi) {
        this.maTramDi = maTramDi;
    }

    public void setMaTramDen(String maTramDen) {
        this.maTramDen = maTramDen;
    }

    public void setSTTDi(int STTDi) {
        this.STTDi = STTDi;
    }

    public void setSTTDen(int STTDen) {
        this.STTDen = STTDen;
    }

    public void setGioDenTram(Timestamp gioDenTram) {
        this.gioDenTram = gioDenTram;
    }

    public void setGioXuatTram(Timestamp gioXuatTram) {
        this.gioXuatTram = gioXuatTram;
    }
    
    
}
