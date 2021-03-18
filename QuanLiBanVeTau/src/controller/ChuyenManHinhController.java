/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.DanhMucBean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseListener;

import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.JPanelDatVe;
import view.JPanelQuanLiLoTrinh;
import view.JPanelQuanLiTau;
import view.JPanelQuanLiTuyen;
import view.JPanelThongKe;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ChuyenManHinhController {

    private JPanel view; // khi bam vao label minh se hien thi panel len cai jpn view nay

    List<DanhMucBean> list = null;

    public ChuyenManHinhController() {
    }

    public ChuyenManHinhController(JPanel view) {
        this.view = view;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem) { // set vua vao se vao danh muc bean dau tien la dat ve
        jpnItem.setBackground(new Color(96, 100, 191));
        jlbItem.setBackground(new Color(96, 100, 191));

        view.removeAll();
        view.setLayout(new BorderLayout());
        view.add(new JPanelDatVe());
        view.validate();
        view.repaint();
    }

    public void setEvents(List<DanhMucBean> list) { // bat su kien click vao menu
        this.list = list;
        for (DanhMucBean i : list) {
            i.getJpn().addMouseListener(new LabelEvent(i.getKind(), i.getJpn(), i.getJlb()));
            
        }
    }

    class LabelEvent implements MouseListener {

        private JPanel node;

        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {

        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
            switch (kind) {
                case "DatVe":
                    node = new JPanelDatVe();
                    break;
                case "QuanLiLoTrinh":
                    node = new JPanelQuanLiLoTrinh();
                    break;
                case "QuanLiTau":
                    node = new JPanelQuanLiTau();
                    break;
                case "QuanLiTuyen":
                    node = new JPanelQuanLiTuyen();
                    break;
                case "ThongKe":
                    node = new JPanelThongKe();
                    break;
            }

            view.removeAll();
            view.setLayout(new BorderLayout());
            view.add(node);
            view.validate();
            view.repaint();
            setChangeBackground();
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {

        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {

        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {

        }

        private void setChangeBackground() {
            for (DanhMucBean iBean : list) {
                if (kind.equalsIgnoreCase(iBean.getKind())) {
                    iBean.getJpn().setBackground(new Color(96, 100, 191));
                    iBean.getJlb().setBackground(new Color(96, 100, 191));
                } else {
                    iBean.getJpn().setBackground(new Color(0, 204, 51));
                    iBean.getJlb().setBackground(new Color(0, 204, 51));
                }
            }
        }

    }
}
