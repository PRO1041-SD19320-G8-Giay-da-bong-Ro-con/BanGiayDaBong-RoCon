package com.component;

import com.main.Main;
import com.ui.PanelDanhSachSanPham;
import com.ui.PanelHoaDon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
/**
 *
 * @author Thai
 */
public class Menu extends javax.swing.JPanel {

    /**
     * Creates new form Panel
     */
    Main main;
    JPanel menu;

    public void setMain(Main main) {
        this.main = main;
        this.menu = main.getPanelMenu();
    }

    public Menu() {
        initComponents();
        JLabel[] allLabel = {DangXuat, QLHoaDon, QLKhuyenMai, QLNhanVien, QLSanPham, QLThuocTinh, ThongKe, banHang};
        for (JLabel label : allLabel) {
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    label.setForeground(Color.blue);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    label.setForeground(Color.black);
                }

            });
        }
    }

//    public void setMain(Main main) {
//        this.main = main;
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        banHang = new javax.swing.JLabel();
        QLSanPham = new javax.swing.JLabel();
        QLHoaDon = new javax.swing.JLabel();
        QLKhuyenMai = new javax.swing.JLabel();
        QLThuocTinh = new javax.swing.JLabel();
        DangXuat = new javax.swing.JLabel();
        ThongKe = new javax.swing.JLabel();
        QLNhanVien = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letterx_83737.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        banHang.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        banHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        banHang.setText("Bán hàng");
        banHang.setPreferredSize(new java.awt.Dimension(50, 30));

        QLSanPham.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        QLSanPham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        QLSanPham.setText("Quản lý sản phẩm");
        QLSanPham.setPreferredSize(new java.awt.Dimension(50, 30));
        QLSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                QLSanPhamMouseClicked(evt);
            }
        });

        QLHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        QLHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        QLHoaDon.setText("Quản lý hóa đơn");
        QLHoaDon.setPreferredSize(new java.awt.Dimension(50, 30));
        QLHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                QLHoaDonMouseClicked(evt);
            }
        });

        QLKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        QLKhuyenMai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        QLKhuyenMai.setText("Quản lý khuyến mãi");
        QLKhuyenMai.setPreferredSize(new java.awt.Dimension(50, 30));

        QLThuocTinh.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        QLThuocTinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        QLThuocTinh.setText("Quản lý thuộc tính");
        QLThuocTinh.setPreferredSize(new java.awt.Dimension(50, 30));

        DangXuat.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        DangXuat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DangXuat.setText("Đăng xuất");
        DangXuat.setPreferredSize(new java.awt.Dimension(50, 30));

        ThongKe.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        ThongKe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ThongKe.setText("Thống kê");
        ThongKe.setPreferredSize(new java.awt.Dimension(50, 30));

        QLNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        QLNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        QLNhanVien.setText("Quản lý nhân viên");
        QLNhanVien.setPreferredSize(new java.awt.Dimension(50, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Rô con");
        jLabel10.setPreferredSize(new java.awt.Dimension(50, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addComponent(banHang, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(QLSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(QLHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(QLKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(QLThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(QLNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(banHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(QLSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(QLHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(QLKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(QLThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(ThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(QLNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        closeMenu();
    }//GEN-LAST:event_jLabel1MousePressed

    private void QLSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QLSanPhamMouseClicked
        Main.changeForm(new PanelDanhSachSanPham());
    }//GEN-LAST:event_QLSanPhamMouseClicked

    private void QLHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QLHoaDonMouseClicked
        Main.changeForm(new PanelHoaDon());
    }//GEN-LAST:event_QLHoaDonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DangXuat;
    private javax.swing.JLabel QLHoaDon;
    private javax.swing.JLabel QLKhuyenMai;
    private javax.swing.JLabel QLNhanVien;
    private javax.swing.JLabel QLSanPham;
    private javax.swing.JLabel QLThuocTinh;
    private javax.swing.JLabel ThongKe;
    private javax.swing.JLabel banHang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    // End of variables declaration//GEN-END:variables

    private void closeMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 250; i >= 0; i--) {
                    try {
                        menu.setSize(i, main.getHeight());
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }
}
