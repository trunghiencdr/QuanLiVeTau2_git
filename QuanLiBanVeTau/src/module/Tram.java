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
public class Tram {
    private String maTram, tenTram, diaChi;

    public Tram() {
    }

    public Tram(String tenTram, String diaChi) {
        this.tenTram = tenTram;
        this.diaChi = diaChi;
    }
    
    public Tram(String maTram, String tenTram, String diaChi) {
        this.maTram = maTram;
        this.tenTram = tenTram;
        this.diaChi = diaChi;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMaTram() {
        return maTram;
    }

    public void setMaTram(String maTram) {
        this.maTram = maTram;
    }

    public String getTenTram() {
        return tenTram;
    }

    public void setTenTram(String tenTram) {
        this.tenTram = tenTram;
    }
}
