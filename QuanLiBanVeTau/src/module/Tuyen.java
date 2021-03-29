/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package module;

import java.util.ArrayList;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Tuyen {
    private String maTuyen, tenTuyen;
    private ArrayList<String> DSTramDiQua;
    private ArrayList<Float>DSKhoangCach;

    public Tuyen() {
    }

    public Tuyen(String maTuyen, String tenTuyen, ArrayList<String> DSTramDiQua, ArrayList<Float> DSKhoangCach) {
        this.maTuyen = maTuyen;
        this.tenTuyen = tenTuyen;
        this.DSTramDiQua = DSTramDiQua;
        this.DSKhoangCach = DSKhoangCach;
    }

    public String getMaTuyen() {
        return maTuyen;
    }

    public void setMaTuyen(String maTuyen) {
        this.maTuyen = maTuyen;
    }

    public String getTenTuyen() {
        return tenTuyen;
    }

    public void setTenTuyen(String tenTuyen) {
        this.tenTuyen = tenTuyen;
    }

    public ArrayList<String> getDSTramDiQua() {
        return DSTramDiQua;
    }

    public void setDSTramDiQua(ArrayList<String> DSTramDiQua) {
        this.DSTramDiQua = DSTramDiQua;
    }
    

    public String DSTramDiQuaSangChuoi(){
        StringBuilder stringBuilder=new StringBuilder();
        DSTramDiQua.forEach(s -> {
            stringBuilder.append(s).append("-");
        });
        return stringBuilder.replace(stringBuilder.length()-1, stringBuilder.length(),"").toString();
    }
    
    public String DSKhoangCachSangChuoi(){
        StringBuilder stringBuilder=new StringBuilder();
        DSTramDiQua.forEach(s -> {
            stringBuilder.append(s).append("-");
        });
        return stringBuilder.replace(stringBuilder.length()-1, stringBuilder.length(),"").toString();
    }

    public ArrayList<Float> getDSKhoangCach() {
        return DSKhoangCach;
    }

    public void setDSKhoangCach(ArrayList<Float> DSKhoangCach) {
        this.DSKhoangCach = DSKhoangCach;
    }
    
}
