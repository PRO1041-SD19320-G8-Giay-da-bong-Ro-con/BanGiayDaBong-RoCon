/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.ui;

import com.dao.SanPhamDAO;
import com.dao.ThuongHieuDAO;
import com.entity.SanPham;
import com.main.Main;
import com.utils.TextUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Thai
 */
public class PanelDanhSachSanPham extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    SanPhamDAO daoSP = new SanPhamDAO();
    ThuongHieuDAO daoTH = new ThuongHieuDAO();

    public PanelDanhSachSanPham() {
        initComponents();
        showTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDanhSachSanPham = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSanPham = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        cbTrangThai = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnChiTiet = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        tableSanPham.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tableSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableSanPham.setRowHeight(30);
        jScrollPane1.setViewportView(tableSanPham);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tìm kiếm", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 15))); // NOI18N

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSearch.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        cbTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang bán", "Ngừng bán", "Tất cả" }));
        cbTrangThai.setBorder(null);
        cbTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTrangThaiActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Trạng thái");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnThem.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnChiTiet.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnChiTiet.setText("Chi tiết");
        btnChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel8.setText("Danh sách sản phẩm");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý sản phẩm");

        javax.swing.GroupLayout panelDanhSachSanPhamLayout = new javax.swing.GroupLayout(panelDanhSachSanPham);
        panelDanhSachSanPham.setLayout(panelDanhSachSanPhamLayout);
        panelDanhSachSanPhamLayout.setHorizontalGroup(
            panelDanhSachSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDanhSachSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDanhSachSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDanhSachSanPhamLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelDanhSachSanPhamLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDanhSachSanPhamLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnChiTiet)
                .addGap(355, 355, 355))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelDanhSachSanPhamLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnChiTiet, btnThem});

        panelDanhSachSanPhamLayout.setVerticalGroup(
            panelDanhSachSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDanhSachSanPhamLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDanhSachSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnChiTiet)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelDanhSachSanPhamLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnChiTiet, btnThem});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDanhSachSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDanhSachSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        showTable();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        Main.changeForm(new PanelThemSanPham());
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietActionPerformed
        xemChiTiet();
    }//GEN-LAST:event_btnChiTietActionPerformed

    private void cbTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTrangThaiActionPerformed
        showTable();
    }//GEN-LAST:event_cbTrangThaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChiTiet;
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cbTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelDanhSachSanPham;
    private javax.swing.JTable tableSanPham;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void showTable() {
        try {
            DefaultTableModel model = (DefaultTableModel) tableSanPham.getModel();
            ArrayList<String> header = new ArrayList<>();
            header.addAll(Arrays.asList(new String[]{"Mã", "Tên món", "Giá", "Thương hiệu"}));
            int[] size = {100, 400, 130, 130};
            boolean trangThai = ((String) cbTrangThai.getSelectedItem()).equalsIgnoreCase("Tất cả");
            if (trangThai) {
                header.add("Trạng thái");
                size = new int[]{100, 320, 130, 130,80};
            }
            Object[] str = header.toArray();

            model.setColumnIdentifiers(str);
            model.setRowCount(0);
            TableColumnModel column = tableSanPham.getColumnModel();
            for (int i = 0; i < model.getColumnCount(); i++) {
                column.getColumn(i).setPreferredWidth(size[i]);
            }

            String key = txtSearch.getText();
            for (SanPham sp : daoSP.selectAll(checkTinhTrang())) {
                if (sp.getMaSP().toUpperCase().contains(key.toUpperCase()) || sp.getTenSP().toUpperCase().contains(key.toUpperCase())) {
                    model.addRow(new Object[]{sp.getMaSP(), sp.getTenSP(), TextUtil.round(sp.getGia()), daoTH.getTen(sp.getMaThuongHieu()),sp.getTrangThai()});
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelDanhSachSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void xemChiTiet() {
        try {
            int row = tableSanPham.getSelectedRow();
            if (row != -1) {
                SanPham sp = daoSP.selectByID(tableSanPham.getValueAt(row, 0).toString());
                PanelChiTietSanPham.sanPham = sp;
                Main.changeForm(new PanelChiTietSanPham());
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelDanhSachSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String checkTinhTrang() {
        String trangThai = (String) cbTrangThai.getSelectedItem();
        String sql = "";
        switch (trangThai) {
            case "Đang bán":
                sql = "Where TrangThai = 1";
                break;
            case "Ngừng bán":
                sql = "Where TrangThai = 0";
                break;
        }
        return sql;
    }
}
