/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledao;

import connectSQL.LopKetNoi;
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
    
    /**
     *
     * @param DS
     * @param dau
     * @return
     */
    public String chuyenArrayListStringSangString(ArrayList<String> DS, String dau) {
        String tam = "";
        for (String s : DS) {
            tam += s + dau;
        }
        return tam.substring(0, tam.length() - 1);
    }
    
    /**
     *
     * @param DS
     * @param dau
     * @return
     */
    public String chuyenArrayListIntSangString(ArrayList<Integer> DS, String dau) {
        String tam = "";
        for (Integer s : DS) {
            tam += Integer.toString(s) + dau;
        }
        return tam.substring(0, tam.length() - 1);
    }

    /**
     *
     * @param maTuyen
     * @return
     */
    public ArrayList<String> getDSTramDiQua(String maTuyen) {
        ArrayList<String> DS = new ArrayList<>();
        try {
            ResultSet rs = LopKetNoi.select("select tenTram from TuyenDiQuaTram where maTuyen=? order by thoiGianDen ASC", maTuyen);
            while (rs.next()) {
                DS.add(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("get ds tram di qua that bai");
        }
        return DS;
    }
    
    /**
     *
     * @param maTuyen
     * @return
     */
    public ArrayList<Integer> getDSThoiGian(String maTuyen) {
        ArrayList<Integer> DS = new ArrayList<>();
        int i = 0;
        try {
            ResultSet rs = LopKetNoi.select("select thoiGianDen from TuyenDiQuaTram where maTuyen=? order by thoiGianDen ASC", maTuyen);
            while (rs.next()) {
                if (i == 0) {
                    rs.getInt(1);
                    i++;
                } else {
                    DS.add(rs.getInt(1));
                }
            }
        } catch (Exception e) {
            System.out.println("get ds thoi gian that bai");
        }
        return DS;
    }
    
    /**
     *
     * @param rs
     * @param model
     */
    public void loadDSTuyenVaoBang(ResultSet rs, DefaultTableModel model) {
        model.setRowCount(0);
        try {
            while (rs.next()) {
                String maTuyen = rs.getString(1);
                String tenTuyen = rs.getString(2);
                String tramDiQua = chuyenArrayListStringSangString(getDSTramDiQua(maTuyen), "-");
                String thoiGian = chuyenArrayListIntSangString(getDSThoiGian(maTuyen),"-");
                model.addRow(new Object[]{maTuyen, tenTuyen, tramDiQua, thoiGian});
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("load ds tuyen vao bang that bai");
        }
    }
    
    /**
     *
     * @param tuyen
     */
    public void themTuyenDiQuaTram(Tuyen tuyen) {
        int thoiGian = 0;
        for (int i = 0; i < tuyen.getDSTramDiQua().size(); i++) {
            if (i == 0) {
                thoiGian = 0;
            } else {
                thoiGian = tuyen.getDSThoiGian().get(i - 1);
            }
            try {
                LopKetNoi.update("insert into tuyendiquatram values(?,?,?)", tuyen.getMaTuyen(),
                    tuyen.getDSTramDiQua().get(i), thoiGian);
            } catch (Exception e) {
                System.out.println("Thêm tuyen di qua tram that bai");
            }

            
        }
    }
    
    /**
     *
     * @param tuyen
     */
    public void capNhatLaiTuyenDiQuaTram(Tuyen tuyen) {
        try {
            LopKetNoi.update("delete from tuyendiquatram where matuyen = ?", tuyen.getMaTuyen());
            themTuyenDiQuaTram(tuyen);
        } catch (Exception e) {
            System.out.println("cap nhat tuyen di qua tram that bai");
        }
    }
    
    /**
     *
     * @param tuyen
     */
    public void themTuyenVaoDB(Tuyen tuyen) {
        try {
            LopKetNoi.update("insert into tuyen values(?,?)", tuyen.getMaTuyen(), tuyen.getTenTuyen());
            themTuyenDiQuaTram(tuyen);
        } catch (Exception e) {
            System.out.println("them tuyen that bai");
        }
    }
    
    /**
     *
     * @param tuyen
     */
    public void suaTuyenTrongDB(Tuyen tuyen) {
        try {
            LopKetNoi.update("update tuyen set TenTuyen = ? where MaTuyen = ?", tuyen.getTenTuyen(), tuyen.getMaTuyen());
            capNhatLaiTuyenDiQuaTram(tuyen);
        } catch (Exception e) {
            System.out.println("sua tuyen that bai");
        }
    }
    
    /**
     *
     * @param maTuyen
     * @return
     */
    public boolean xoaTuyenTrongDB(String maTuyen) {
        try {
            LopKetNoi.update("delete from tuyen where maTuyen = ?", maTuyen);
            return true;
        } catch (Exception e) {
            System.out.println("xoa tuyen that bai");
            return false;
        }
    }
    
    /**
     *
     * @param tuyen
     * @param jtb
     */
    public void themTuyenVaoBang(Tuyen tuyen, JTable jtb) {
        DefaultTableModel model = (DefaultTableModel) jtb.getModel();
        model.addRow(new Object[]{tuyen.getMaTuyen(), tuyen.getTenTuyen(),
            tuyen.DSTramDiQuaSangChuoi(), tuyen.DSKhoangCachSangChuoi()});
        int hangCuoi = jtb.getRowCount();
        jtb.scrollRectToVisible(jtb.getCellRect(hangCuoi - 1, 0, true));
        jtb.clearSelection();
        jtb.setRowSelectionInterval(hangCuoi - 1, hangCuoi - 1);
    }
    
    /**
     *
     * @param tuyen
     * @param hang
     * @param jtb
     */
    public void suaTuyenTrongBang(Tuyen tuyen, int hang, JTable jtb) {
        jtb.setValueAt(tuyen.getTenTuyen(), hang, 1);
        jtb.setValueAt(tuyen.DSTramDiQuaSangChuoi(), hang, 2);
        jtb.setValueAt(tuyen.DSKhoangCachSangChuoi(), hang, 3);
    }
    
    /**
     *
     * @param hang
     * @param model
     */
    public void xoaTramKhoiBang(int hang, DefaultTableModel model) {
        model.removeRow(hang);
    }
    
    /**
     *
     * @param hang
     * @param jtb
     * @param maTuyen
     * @param tenTuyen
     * @param tramDiQua
     * @param khoangCach
     */
    public void getTuyenTuBang(int hang, JTable jtb, JTextField maTuyen, JTextField tenTuyen,
            JTextArea tramDiQua, JTextArea khoangCach) {
        maTuyen.setText(jtb.getValueAt(hang, 0) + "");
        tenTuyen.setText(jtb.getValueAt(hang, 1) + "");
        tramDiQua.setText(jtb.getValueAt(hang, 2) + "");
        khoangCach.setText(jtb.getValueAt(hang, 3) + "");
    }
}
