/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledao;

import connectSQL.LopKetNoi;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TuyenDao {

    public String getDSTramDiQua(String maTuyen) {
        String tam = "";
        try {
            ResultSet rs = LopKetNoi.select("select tenTram from TuyenDiQuaTram where maTuyen=? order by STT ASC", maTuyen);
            while (rs.next()) {
                tam += rs.getString(1) + "-";
            }
        } catch (Exception e) {
        }
        return tam.substring(0, tam.length());// loai bo ki tu - cuoi cung
    }

     public String getDSKhoangCach(String maTuyen) {
        String tam = "";
        try {
            ResultSet rs = LopKetNoi.select("select khoangCach from TuyenDiQuaTram where maTuyen=? order by STT ASC", maTuyen);
            while (rs.next()) {
                tam += rs.getString(1) + "-";
            }
        } catch (Exception e) {
        }
        return tam.substring(0, tam.length());// loai bo ki tu - cuoi cung
    }
     
    public void loadDSTuyenVaoBang(ResultSet rs, DefaultTableModel model) {
        model.setRowCount(0);
        try {
            while (rs.next()) {
                String maTuyen = rs.getString(1);
                String DSTramDiQua = getDSTramDiQua(maTuyen);
                String DSKhoangCach = getDSKhoangCach(maTuyen);
                String tenTuyen = rs.getString(2);
                model.addRow(new Object[]{maTuyen, tenTuyen, DSTramDiQua, DSKhoangCach});
            }
        } catch (Exception e) {
        }
    }
}
