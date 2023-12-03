/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.ui;

import com.dao.ChatLieuDAO;
import com.dao.DAOInterface;
import com.dao.LoaiGiayDAO;
import com.dao.MauSacDAO;
import com.dao.SizeDAO;
import com.dao.ThuongHieuDAO;
import com.dao.XuatXuDAO;
import com.entity.ChatLieu;
import com.entity.LoaiGiay;
import com.entity.MauSac;
import com.entity.Size;
import com.entity.ThuocTinh;
import com.entity.ThuongHieu;
import com.entity.XuatXu;
import com.utils.Auth;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class PanelQuanLyThuocTinh extends javax.swing.JPanel {

    DefaultTableModel model = null;

    int index = -1;
    int tt = 0;

    ThuongHieuDAO thuonghieuDAO = new ThuongHieuDAO();
    LoaiGiayDAO loaigiayDAO = new LoaiGiayDAO();
    ChatLieuDAO chatlieuDAO = new ChatLieuDAO();
    XuatXuDAO xuatxuDAO = new XuatXuDAO();
    MauSacDAO mausacDAO = new MauSacDAO();
    SizeDAO sizeDAO = new SizeDAO();

    /**
     * Creates new form PanelQuanLyThuocTinh
     */
    public PanelQuanLyThuocTinh() {
        initComponents();
        model = (DefaultTableModel) tbl_thuoctinh.getModel();
        Cbox_thuoctinhItemStateChanged(null);
    }

    private <E extends ThuocTinh> void filltable(DAOInterface dao, E entity) {
        try {
            model.setRowCount(0);
            List<E> list = dao.selectAll();
            for (E e : list) {
                model.addRow(new Object[]{e.getMa(), e.getTen()});
            }
        } catch (Exception e) {
        }
    }

    void showdata1(int index) {
        ThuongHieu th = thuonghieuDAO.getALL().get(index);
        txt_ma.setText(th.getMa());
        txt_ten.setText(th.getTen());
    }

    void showdata2(int index) {
        LoaiGiay lg = loaigiayDAO.getALL().get(index);
        txt_ma.setText(lg.getMa());
        txt_ten.setText(lg.getTen());
    }

    void showdata3(int index) {
        ChatLieu lg = chatlieuDAO.getALL().get(index);
        txt_ma.setText(lg.getMa());
        txt_ten.setText(lg.getTen());
    }

    void showdata4(int index) {
        XuatXu lg = xuatxuDAO.getALL().get(index);
        txt_ma.setText(lg.getMa());
        txt_ten.setText(lg.getTen());
    }

    void showdata5(int index) {
        MauSac lg = mausacDAO.getALL().get(index);
        txt_ma.setText(lg.getMa());
        txt_ten.setText(lg.getTen());
    }

    void showdata6(int index) {
        Size lg = sizeDAO.getALL().get(index);
        txt_ma.setText(lg.getMa());
        txt_ten.setText(lg.getTen());
    }

    ThuongHieu readfrom1() {
        String ma = txt_ma.getText();
        String ten = txt_ten.getText();
        return new ThuongHieu(ma, ten);
    }

    LoaiGiay readfrom2() {
        String ma = txt_ma.getText();
        String ten = txt_ten.getText();
        return new LoaiGiay(ma, ten);
    }

    ChatLieu readfrom3() {
        String ma = txt_ma.getText();
        String ten = txt_ten.getText();
        return new ChatLieu(ma, ten);
    }

    XuatXu readfrom4() {
        String ma = txt_ma.getText();
        String ten = txt_ten.getText();
        return new XuatXu(ma, ten);
    }

    MauSac readfrom5() {
        String ma = txt_ma.getText();
        String ten = txt_ten.getText();
        return new MauSac(ma, ten);
    }

    Size readfrom6() {
        String ma = txt_ma.getText();
        String ten = txt_ten.getText();
        return new Size(ma, ten);
    }

    boolean checkdata() {
        if (txt_ma.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã không được để trống");
            return false;
        }
        if (txt_ten.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên không được để trống");
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_thuoctinh = new javax.swing.JTable();
        Cbox_thuoctinh = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txt_ma = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_ten = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Quản Lý Thuộc Tính");

        tbl_thuoctinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_thuoctinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã", "Tên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_thuoctinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_thuoctinhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_thuoctinh);

        Cbox_thuoctinh.setBackground(new java.awt.Color(204, 204, 255));
        Cbox_thuoctinh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Cbox_thuoctinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thương Hiệu", "Loại Giày", "Chất Liệu", "Xuất Xứ", "Màu Sắc", "Size" }));
        Cbox_thuoctinh.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Cbox_thuoctinhItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cbox_thuoctinh, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(Cbox_thuoctinh, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Mã :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Tên :");

        btn_add.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add-icon.png"))); // NOI18N
        btn_add.setText("Thêm Thuộc Tính");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_sua.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ct3.png"))); // NOI18N
        btn_sua.setText("Sửa Thuộc Tính");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_ma)
                            .addComponent(txt_ten, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
                        .addGap(0, 48, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_sua)
                            .addComponent(btn_add))
                        .addGap(69, 69, 69))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Cbox_thuoctinhItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Cbox_thuoctinhItemStateChanged
        // TODO add your handling code here:
        switch (Cbox_thuoctinh.getSelectedIndex()) {
            case 0 ->
                filltable(thuonghieuDAO, new ThuongHieu());
            case 1 ->
                filltable(loaigiayDAO, new ThuongHieu());
            case 2 ->
                filltable(chatlieuDAO, new ThuongHieu());
            case 3 ->
                filltable(xuatxuDAO, new ThuongHieu());
            case 4 ->
                filltable(mausacDAO, new ThuongHieu());
            default ->
                filltable(sizeDAO, new ThuongHieu());
        }
    }//GEN-LAST:event_Cbox_thuoctinhItemStateChanged

    private void tbl_thuoctinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_thuoctinhMouseClicked
//         TODO add your handling code here:
        index = tbl_thuoctinh.getSelectedRow();
        switch (Cbox_thuoctinh.getSelectedIndex()) {
            case 0 ->
                showdata1(index);
            case 1 ->
                showdata2(index);
            case 2 ->
                showdata3(index);
            case 3 ->
                showdata4(index);
            case 4 ->
                showdata5(index);
            default ->
                showdata6(index);
        }

    }//GEN-LAST:event_tbl_thuoctinhMouseClicked

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed

        if (Auth.isManager()) {
            switch (Cbox_thuoctinh.getSelectedIndex()) {
                case 0 ->
                    add1();
                case 1 ->
                    add2();
                case 2 ->
                    add3();
                case 3 ->
                    add4();
                case 4 ->
                    add5();
                default ->
                    add6();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nhân viên không được sử dụng chức năng này");
        }

    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        if (Auth.isManager()) {
            switch (Cbox_thuoctinh.getSelectedIndex()) {
                case 0 ->
                    update1();
                case 1 ->
                    update2();
                case 2 ->
                    update3();
                case 3 ->
                    update4();
                case 4 ->
                    update5();
                default ->
                    update6();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nhân viên không được sử dụng chức năng này");
        }
    }//GEN-LAST:event_btn_suaActionPerformed
    void add1() {
        if (checkdata()) {
            ThuongHieu th = this.readfrom1();
            try {
                if (thuonghieuDAO.selectByID(th.getMa()) != null) {
                    JOptionPane.showMessageDialog(this, "mã trùng không thêm dc");
                } else if (thuonghieuDAO.selectByTEN(th.getTen()) != null) {
                    JOptionPane.showMessageDialog(this, "trùng tên");
                } else if (thuonghieuDAO.add(th) > 0) {
                    JOptionPane.showMessageDialog(this, "thêm Thành Công");
                    filltable(thuonghieuDAO, new ThuongHieu());
                } else {
                    JOptionPane.showMessageDialog(this, "thất Bại");
                }

            } catch (SQLException ex) {
                Logger.getLogger(PanelQuanLyThuocTinh.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    void add2() {
        if (checkdata()) {
            LoaiGiay th = this.readfrom2();
            try {
                if (loaigiayDAO.selectByID(th.getMa()) != null) {
                    JOptionPane.showMessageDialog(this, "mã trùng không thêm dc");
                } else if (loaigiayDAO.selectByTEN(th.getTen()) != null) {
                    JOptionPane.showMessageDialog(this, "trùng tên");
                } else if (loaigiayDAO.add(th) > 0) {
                    JOptionPane.showMessageDialog(this, "thêm Thành Công");
                    filltable(loaigiayDAO, new ThuongHieu());
                } else {
                    JOptionPane.showMessageDialog(this, "thất Bại");
                }

            } catch (SQLException ex) {
                Logger.getLogger(PanelQuanLyThuocTinh.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    void add3() {
        if (checkdata()) {
            ChatLieu th = this.readfrom3();
            try {
                if (chatlieuDAO.selectByID(th.getMa()) != null) {
                    JOptionPane.showMessageDialog(this, "mã trùng không thêm dc");
                } else if (chatlieuDAO.selectByTEN(th.getTen()) != null) {
                    JOptionPane.showMessageDialog(this, "trùng tên");
                } else if (chatlieuDAO.add(th) > 0) {
                    JOptionPane.showMessageDialog(this, "thêm Thành Công");
                    filltable(chatlieuDAO, new ThuongHieu());
                } else {
                    JOptionPane.showMessageDialog(this, "thất Bại");
                }

            } catch (SQLException ex) {
                Logger.getLogger(PanelQuanLyThuocTinh.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    void add4() {
        if (checkdata()) {
            XuatXu th = this.readfrom4();
            try {
                if (xuatxuDAO.selectByID(th.getMa()) != null) {
                    JOptionPane.showMessageDialog(this, "mã trùng không thêm dc");
                } else if (xuatxuDAO.selectByTEN(th.getTen()) != null) {
                    JOptionPane.showMessageDialog(this, "trùng tên");
                } else if (xuatxuDAO.add(th) > 0) {
                    JOptionPane.showMessageDialog(this, "thêm Thành Công");
                    filltable(xuatxuDAO, new ThuongHieu());
                } else {
                    JOptionPane.showMessageDialog(this, "thất Bại");
                }

            } catch (SQLException ex) {
                Logger.getLogger(PanelQuanLyThuocTinh.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    void add5() {
        if (checkdata()) {
            MauSac th = this.readfrom5();
            try {
                if (mausacDAO.selectByID(th.getMa()) != null) {
                    JOptionPane.showMessageDialog(this, "mã trùng không thêm dc");
                } else if (mausacDAO.selectByTEN(th.getTen()) != null) {
                    JOptionPane.showMessageDialog(this, "trùng tên");
                } else if (mausacDAO.add(th) > 0) {
                    JOptionPane.showMessageDialog(this, "thêm Thành Công");
                    filltable(mausacDAO, new ThuongHieu());
                } else {
                    JOptionPane.showMessageDialog(this, "thất Bại");
                }

            } catch (SQLException ex) {
                Logger.getLogger(PanelQuanLyThuocTinh.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    void add6() {
        if (checkdata()) {
            Size th = this.readfrom6();
            try {
                if (sizeDAO.selectByID(th.getMa()) != null) {
                    JOptionPane.showMessageDialog(this, "mã trùng không thêm dc");
                } else if (sizeDAO.selectByTEN(th.getTen()) != null) {
                    JOptionPane.showMessageDialog(this, "trùng tên");
                } else if (sizeDAO.add(th) > 0) {
                    JOptionPane.showMessageDialog(this, "thêm Thành Công");
                    filltable(sizeDAO, new ThuongHieu());
                } else {
                    JOptionPane.showMessageDialog(this, "thất Bại");
                }

            } catch (SQLException ex) {
                Logger.getLogger(PanelQuanLyThuocTinh.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    void update1() {
        index = tbl_thuoctinh.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "bạn cần chọn dòng để sửa");
        } else {
            if (checkdata()) {
                String ma = tbl_thuoctinh.getValueAt(index, 0).toString();
                ThuongHieu th = this.readfrom1();
                if (thuonghieuDAO.updatee(th, ma) > 0) {
                    JOptionPane.showMessageDialog(this, "Sửa Thành Công");
                    filltable(thuonghieuDAO, new ThuongHieu());
                }
            }
        }
    }

    void update2() {
        index = tbl_thuoctinh.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "bạn cần chọn dòng để sửa");
        } else {
            if (checkdata()) {
                String ma = tbl_thuoctinh.getValueAt(index, 0).toString();
                LoaiGiay th = this.readfrom2();
                if (loaigiayDAO.updatee(th, ma) > 0) {
                    JOptionPane.showMessageDialog(this, "Sửa Thành Công");
                    filltable(loaigiayDAO, new ThuongHieu());
                }
            }
        }
    }

    void update3() {
        index = tbl_thuoctinh.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "bạn cần chọn dòng để sửa");
        } else {
            if (checkdata()) {
                String ma = tbl_thuoctinh.getValueAt(index, 0).toString();
                ChatLieu th = this.readfrom3();
                if (chatlieuDAO.updatee(th, ma) > 0) {
                    JOptionPane.showMessageDialog(this, "Sửa Thành Công");
                    filltable(chatlieuDAO, new ThuongHieu());
                }
            }
        }
    }

    void update4() {
        index = tbl_thuoctinh.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "bạn cần chọn dòng để sửa");
        } else {
            if (checkdata()) {
                String ma = tbl_thuoctinh.getValueAt(index, 0).toString();
                XuatXu th = this.readfrom4();
                if (xuatxuDAO.updatee(th, ma) > 0) {
                    JOptionPane.showMessageDialog(this, "Sửa Thành Công");
                    filltable(xuatxuDAO, new ThuongHieu());
                }
            }
        }
    }

    void update5() {
        index = tbl_thuoctinh.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "bạn cần chọn dòng để sửa");
        } else {
            if (checkdata()) {
                String ma = tbl_thuoctinh.getValueAt(index, 0).toString();
                MauSac th = this.readfrom5();
                if (mausacDAO.updatee(th, ma) > 0) {
                    JOptionPane.showMessageDialog(this, "Sửa Thành Công");
                    filltable(mausacDAO, new ThuongHieu());
                }
            }
        }
    }

    void update6() {
        index = tbl_thuoctinh.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "bạn cần chọn dòng để sửa");
        } else {
            if (checkdata()) {
                String ma = tbl_thuoctinh.getValueAt(index, 0).toString();
                Size th = this.readfrom6();
                if (sizeDAO.updatee(th, ma) > 0) {
                    JOptionPane.showMessageDialog(this, "Sửa Thành Công");
                    filltable(sizeDAO, new ThuongHieu());
                }
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Cbox_thuoctinh;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_sua;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_thuoctinh;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_ten;
    // End of variables declaration//GEN-END:variables
}
