/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.ui;

import com.dao.ChatLieuDAO;
import com.dao.ChiTietSanPhamDAO;
import com.dao.LoaiGiayDAO;
import com.dao.MauSacDAO;
import com.dao.SizeDAO;
import com.dao.ThuongHieuDAO;
import com.dao.XuatXuDAO;
import com.entity.ChiTietSanPham;
import com.entity.SanPham;
import com.main.Main;
import com.utils.Rounding;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JRadioButton;
import com.entity.MauSac;
import com.entity.Size;
import com.utils.XImage;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Thai
 */
public class PanelChiTietSanPham extends javax.swing.JPanel {

    /**
     * Creates new form PanelChiTietSanPham
     */
    XuatXuDAO daoXX = new XuatXuDAO();
    LoaiGiayDAO daoLG = new LoaiGiayDAO();
    ChatLieuDAO daoCL = new ChatLieuDAO();
    ThuongHieuDAO daoTH = new ThuongHieuDAO();
    MauSacDAO daoMS = new MauSacDAO();
    SizeDAO daoS = new SizeDAO();
    ChiTietSanPhamDAO daoCTSP = new ChiTietSanPhamDAO();
//    JRadioButton rdoMau;
    JRadioButton rdoSize;

    public static SanPham sanPham = new SanPham();

    public PanelChiTietSanPham() {
        initComponents();
        showForm();
        FlowLayout flow = new FlowLayout(FlowLayout.LEADING, 20, 15);
        panelMau.setLayout(flow);
        panelSize.setLayout(flow);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grSize = new javax.swing.ButtonGroup();
        grMau = new javax.swing.ButtonGroup();
        panelChiTietSanPham = new javax.swing.JPanel();
        btnThoatChiTiet = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblMaSP = new javax.swing.JLabel();
        lblTen = new javax.swing.JLabel();
        lblGia = new javax.swing.JLabel();
        lblSoLuong = new javax.swing.JLabel();
        lblThuongHIeu = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblLoai = new javax.swing.JLabel();
        lblXuatXu = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblChatLieu = new javax.swing.JLabel();
        panelMau = new javax.swing.JPanel();
        panelSize = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblHinhAnh = new javax.swing.JLabel();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();

        btnThoatChiTiet.setText("Thoát");
        btnThoatChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatChiTietActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Mã sản phẩm:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Tên sản phẩm:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Giá:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Số lượng:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Thương hiệu");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Chi tiết sản phẩm");

        lblMaSP.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblMaSP.setText("null");

        lblTen.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTen.setText("null");

        lblGia.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblGia.setText("null");

        lblSoLuong.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lblSoLuong.setText("null");

        lblThuongHIeu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblThuongHIeu.setText("null");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Loại giày");

        lblLoai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblLoai.setText("null");

        lblXuatXu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblXuatXu.setText("null");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Xuất xứ");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Chất liệu");

        lblChatLieu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblChatLieu.setText("null");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Màu: ");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Size:");

        lblHinhAnh.setBackground(new java.awt.Color(255, 255, 255));
        lblHinhAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHinhAnh.setText("none");
        lblHinhAnh.setToolTipText("");
        lblHinhAnh.setOpaque(true);

        btnSua.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnSua.setText("Sửa sản phẩm");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnXoa.setText("Xóa sản phẩm");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelChiTietSanPhamLayout = new javax.swing.GroupLayout(panelChiTietSanPham);
        panelChiTietSanPham.setLayout(panelChiTietSanPhamLayout);
        panelChiTietSanPhamLayout.setHorizontalGroup(
            panelChiTietSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelChiTietSanPhamLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelChiTietSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelChiTietSanPhamLayout.createSequentialGroup()
                        .addComponent(btnThoatChiTiet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(72, 72, 72))
                    .addGroup(panelChiTietSanPhamLayout.createSequentialGroup()
                        .addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelChiTietSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelChiTietSanPhamLayout.createSequentialGroup()
                                .addGroup(panelChiTietSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelChiTietSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMaSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panelChiTietSanPhamLayout.createSequentialGroup()
                                        .addGroup(panelChiTietSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lblThuongHIeu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblLoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, Short.MAX_VALUE)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(panelMau, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6))))
                            .addGroup(panelChiTietSanPhamLayout.createSequentialGroup()
                                .addGroup(panelChiTietSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelChiTietSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelChiTietSanPhamLayout.createSequentialGroup()
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblGia, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelChiTietSanPhamLayout.createSequentialGroup()
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelChiTietSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panelChiTietSanPhamLayout.createSequentialGroup()
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelChiTietSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelChiTietSanPhamLayout.createSequentialGroup()
                                        .addComponent(btnSua)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnXoa)
                                        .addGap(28, 28, 28))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelChiTietSanPhamLayout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(panelSize, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())))))))
        );
        panelChiTietSanPhamLayout.setVerticalGroup(
            panelChiTietSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelChiTietSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelChiTietSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThoatChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelChiTietSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelChiTietSanPhamLayout.createSequentialGroup()
                        .addGroup(panelChiTietSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMaSP)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(panelChiTietSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTen)
                            .addComponent(jLabel2))
                        .addGroup(panelChiTietSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelChiTietSanPhamLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panelChiTietSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(lblLoai)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(panelChiTietSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(lblThuongHIeu))
                                .addGap(18, 18, 18)
                                .addGroup(panelChiTietSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(lblChatLieu))
                                .addGap(18, 18, 18)
                                .addGroup(panelChiTietSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(lblXuatXu))
                                .addGap(18, 18, 18)
                                .addGroup(panelChiTietSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblGia)
                                    .addComponent(jLabel3))
                                .addGap(22, 22, 22)
                                .addGroup(panelChiTietSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblSoLuong)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelChiTietSanPhamLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(panelMau, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelChiTietSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelChiTietSanPhamLayout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(jLabel11))
                                    .addGroup(panelChiTietSanPhamLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(panelSize, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(panelChiTietSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua)
                    .addComponent(btnXoa))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelChiTietSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelChiTietSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatChiTietActionPerformed
        Main.changeForm(new PanelDanhSachSanPham());
    }//GEN-LAST:event_btnThoatChiTietActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThoatChiTiet;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup grMau;
    private javax.swing.ButtonGroup grSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblChatLieu;
    private javax.swing.JLabel lblGia;
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JLabel lblLoai;
    private javax.swing.JLabel lblMaSP;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblTen;
    private javax.swing.JLabel lblThuongHIeu;
    private javax.swing.JLabel lblXuatXu;
    private javax.swing.JPanel panelChiTietSanPham;
    private javax.swing.JPanel panelMau;
    private javax.swing.JPanel panelSize;
    // End of variables declaration//GEN-END:variables

    private void showForm() {
        lblMaSP.setText(sanPham.getMaSP());
        lblTen.setText(sanPham.getTenSP());
        lblGia.setText(Rounding.round(sanPham.getGia()) + " VNĐ");
        lblXuatXu.setText(daoXX.getTen(sanPham.getMaXuatXu()));
        lblChatLieu.setText(daoCL.getTen(sanPham.getMaChatLieu()));
        lblThuongHIeu.setText(daoTH.getTen(sanPham.getMaThuongHieu()));
        lblLoai.setText(daoLG.getTen(sanPham.getMaLoai()));
        showAnh();
        try {
            for (MauSac ms : daoMS.getDistinctMauByMaSP(sanPham.getMaSP())) {
                JRadioButton rdoMau = new JRadioButton(ms.getTen(), true);
                grMau.add(rdoMau);
                panelMau.add(rdoMau);

                rdoMau.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showSoLuong();
                    }
                });
            }
            for (Size size : daoS.getDistinctMauByMaSP(sanPham.getMaSP())) {
                JRadioButton rdoSize = new JRadioButton(size.getTen(), true);
                grSize.add(rdoSize);
                panelSize.add(rdoSize);

                rdoSize.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showSoLuong();
                    }
                });
            }

            showSoLuong();

        } catch (Exception ex) {
            Logger.getLogger(PanelChiTietSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showSoLuong() {
        JRadioButton rdoMau = null;
        for (Component com : panelMau.getComponents()) {
            if (((JRadioButton) com).isSelected()) {
                rdoMau = (JRadioButton) com;
            }
        }
        JRadioButton rdoSize = null;
        for (Component com : panelSize.getComponents()) {
            if (((JRadioButton) com).isSelected()) {
                rdoSize = (JRadioButton) com;
            }
        }
        int soLuong = daoCTSP.getSoLuong(sanPham.getMaSP(), daoMS.getMa(rdoMau.getText()), daoS.getMa(rdoSize.getText()));

        if (soLuong <= 0) {
            lblSoLuong.setForeground(Color.red);
        } else {
            lblSoLuong.setForeground(new Color(0, 204, 0));
        }
        lblSoLuong.setText(soLuong + "");
    }

    private void showAnh() {
        try {
            lblHinhAnh.setIcon(XImage.resize(new ImageIcon(getClass().getResource("/img/" + sanPham.getHinh()).getPath()), lblHinhAnh));
        } catch (Exception e) {
//            lblHinhAnh.setIcon(null);
            System.out.println(e);
        }
    }
}
