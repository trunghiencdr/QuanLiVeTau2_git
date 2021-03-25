/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module;

import connectSQL.LopKetNoi;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class LoaiToaDao {

    public List<LoaiToa> loadDSLoaiToaTuDB(String sql) throws SQLException{
            List<LoaiToa> DS = new ArrayList<>();
            ResultSet rs = LopKetNoi.select(sql);
            while(rs.next()){
                DS.add(new LoaiToa(rs.getString(1), rs.getString(2), rs.getFloat(3)));
            }
            return DS;
    }
    
    public void loadDSVaoBang(List<LoaiToa> DS, DefaultTableModel model){
        model.setRowCount(0);
        for(LoaiToa o : DS){
            model.addRow(new Object[]{o.getMaLoaiToa(), o.getTenLoaiToa(), o.getHeSo()});
        }
    }
    
    public boolean addLoaiToaVaoBangVaDB(LoaiToa o, DefaultTableModel model ){
        if(!LopKetNoi.update("insert into LoaiToa values(?,?,?)", o.getMaLoaiToa(), o.getTenLoaiToa(), o.getHeSo())) return false;
        model.addRow(new Object[]{o.getMaLoaiToa(), o.getTenLoaiToa(), o.getHeSo()});
        return true;
    }
    
}
