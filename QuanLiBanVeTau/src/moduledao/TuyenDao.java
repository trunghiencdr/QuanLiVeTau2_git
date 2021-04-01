/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledao;

import connectSQL.LopKetNoi;
import java.awt.TextArea;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import module.Tuyen;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TuyenDao {
    
    public String chuyenArrayListStringSangString(ArrayList<String> DS, String dau) {
        String tam = "";
        for (String s : DS) {
            tam += s + dau;
        }
        return tam.substring(0, tam.length() - 1);
    }
    
    public String chuyenArrayListStringFloatString(ArrayList<Float> DS, String dau) {
        String tam = "";
        for (Float s : DS) {
            tam += Float.toString(s) + dau;
        }
        return tam.substring(0, tam.length() - 1);
    }

    public ArrayList<String> getDSTramDiQua(String maTuyen) {
        ArrayList<String> DS = new ArrayList<>();
        try {
            ResultSet rs = LopKetNoi.select("select tenTram from TuyenDiQuaTram where maTuyen=? order by STT ASC", maTuyen);
            while (rs.next()) {
                DS.add(rs.getString(1));
            }
        } catch (Exception e) {
        }
        return DS;
    }
    
    public ArrayList<Float> getDSKhoangCach(String maTuyen) {
        ArrayList<Float> DS = new ArrayList<>();
        int i = 0;
        try {
            ResultSet rs = LopKetNoi.select("select khoangCach from TuyenDiQuaTram where maTuyen=? order by STT ASC", maTuyen);
            while (rs.next()) {
                if (i == 0) {
                    rs.getFloat(1);
                    i++;
                } else {
                    DS.add(rs.getFloat(1));
                }
            }
        } catch (Exception e) {
        }
        return DS;
    }
    
    public void loadDSTuyenVaoBang(ResultSet rs, DefaultTableModel model) {
        model.setRowCount(0);
        try {
            while (rs.next()) {
                String maTuyen = rs.getString(1);
                String DSTramDiQua = chuyenArrayListStringSangString(getDSTramDiQua(maTuyen), "-");
                String DSKhoangCach = chuyenArrayListStringFloatString(getDSKhoangCach(maTuyen),"-");
                String tenTuyen = rs.getString(2);
                model.addRow(new Object[]{maTuyen, tenTuyen, DSTramDiQua, DSKhoangCach});
            }
        } catch (Exception e) {
        }
    }
    
    public void themTuyenDiQuaTram(Tuyen tuyen) {
        float khoangCach = 0f;
        for (int i = 0; i < tuyen.getDSTramDiQua().size(); i++) {
            if (i == 0) {
                khoangCach = 0;
            } else {
                khoangCach = tuyen.getDSKhoangCach().get(i - 1);
            }
            LopKetNoi.update("insert into tuyendiquatram values(?,?,?,?)", tuyen.getMaTuyen(),
                    tuyen.getDSTramDiQua().get(i), i, khoangCach);
        }
    }
    
    public void capNhatLaiTuyenDiQuaTram(Tuyen tuyen) {
        try {
            LopKetNoi.update("delete from tuyendiquatram where matuyen = ?", tuyen.getMaTuyen());
            themTuyenDiQuaTram(tuyen);
        } catch (Exception e) {
        }
    }
    
    public void themTuyenVaoDB(Tuyen tuyen) {
        try {
            LopKetNoi.update("insert into tuyen values(?,?)", tuyen.getMaTuyen(), tuyen.getTenTuyen());
            themTuyenDiQuaTram(tuyen);
        } catch (Exception e) {
        }
    }
    
    public void suaTuyenTrongDB(Tuyen tuyen) {
        try {
            LopKetNoi.update("update tuyen set TenTuyen = ? where MaTuyen = ?", tuyen.getTenTuyen(), tuyen.getMaTuyen());
            capNhatLaiTuyenDiQuaTram(tuyen);
        } catch (Exception e) {
        }
    }
    
    public boolean xoaTuyenTrongDB(String maTuyen) {
        try {
            LopKetNoi.update("delete from tuyen where maTuyen = ?", maTuyen);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public void themTuyenVaoBang(Tuyen tuyen, JTable jtb) {
        DefaultTableModel model = (DefaultTableModel) jtb.getModel();
        model.addRow(new Object[]{tuyen.getMaTuyen(), tuyen.getTenTuyen(),
            tuyen.DSTramDiQuaSangChuoi(), tuyen.DSKhoangCachSangChuoi()});
        int hangCuoi = jtb.getRowCount();
        jtb.scrollRectToVisible(jtb.getCellRect(hangCuoi - 1, 0, true));
        jtb.clearSelection();
        jtb.setRowSelectionInterval(hangCuoi - 1, hangCuoi - 1);
    }
    
    public void suaTuyenTrongBang(Tuyen tuyen, int hang, JTable jtb) {
        jtb.setValueAt(tuyen.getTenTuyen(), hang, 1);
        jtb.setValueAt(tuyen.DSTramDiQuaSangChuoi(), hang, 2);
        jtb.setValueAt(tuyen.DSKhoangCachSangChuoi(), hang, 3);
    }
    
    public void xoaTramKhoiBang(int hang, DefaultTableModel model) {
        model.removeRow(hang);
    }
    
    public void getTuyenTuBang(int hang, JTable jtb, JTextField maTuyen, JTextField tenTuyen,
            JTextArea tramDiQua, JTextArea khoangCach) {
        maTuyen.setText(jtb.getValueAt(hang, 0) + "");
        tenTuyen.setText(jtb.getValueAt(hang, 1) + "");
        tramDiQua.setText(jtb.getValueAt(hang, 2) + "");
        khoangCach.setText(jtb.getValueAt(hang, 3) + "");
    }
}
