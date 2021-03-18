/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ChuyenManHinhView {
    JPanel root;
    JPanel chuyenSang;

    public ChuyenManHinhView(JPanel root, JPanel chuyenSang) {
        this.root = root;
        this.chuyenSang = chuyenSang;
    }
    
    public void change(){
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(chuyenSang);
        root.validate();
        root.repaint();
    }
    

}
