/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.ui;

import com.main.Main;
import com.utils.FormatDate;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.KhachHang;
import services.KhachHangService;

/**
 *
 * @author FPT SHOP
 */
public class PanelQLKhachHang extends javax.swing.JPanel {

    private List<KhachHang> lstKH = new ArrayList<>();
    private DefaultTableModel model = new DefaultTableModel();
    private KhachHangService ser = new KhachHangService();
    int id;

    public PanelQLKhachHang() {
        initComponents();
        init();
    }

    void init() {
        lstKH = ser.getAll();
        model = (DefaultTableModel) tblKH.getModel();
        showData(lstKH);
        if (lstKH.size() > 0) {
            id = 0;
            showForm();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txtMa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDiaCHi = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        btnThem1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKH = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtMa.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Mã KH");

        txtTen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtSDT.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });

        jLabel4.setText("SĐT");

        txtNgaySinh.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("Ngày Sinh");

        jLabel6.setText("Địa Chỉ");

        txtDiaCHi.setColumns(20);
        txtDiaCHi.setRows(5);
        jScrollPane1.setViewportView(txtDiaCHi);

        jLabel7.setText("Tên KH");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140)
                        .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(314, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(286, 286, 286)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(197, Short.MAX_VALUE)))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnThem.setBackground(new java.awt.Color(255, 204, 0));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setText("Thêm ");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnThoat.setBackground(new java.awt.Color(255, 204, 51));
        btnThoat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThoat.setText("Lịch Sử Mua Hàng");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        btnThem1.setBackground(new java.awt.Color(255, 204, 0));
        btnThem1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem1.setText("Sửa");
        btnThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(379, 379, 379))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThem1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        tblKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Tên KH", "SĐT", "Địa Chỉ", "Ngày Sinh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKH.setRowHeight(30);
        tblKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKHMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblKH);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Quản Lý Khách Hàng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(296, 296, 296))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        int hoi = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thêm khách hàng ");
        if (hoi == JOptionPane.YES_OPTION) {
            for (KhachHang kh : lstKH) {
                if (kh.getMaKH().equalsIgnoreCase(txtMa.getText()) || kh.getSdt().equalsIgnoreCase(txtSDT.getText())) {
                    JOptionPane.showMessageDialog(this, "Mã khách hàng hoặc SDT đã tồn tại");
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, ser.addKH(readForm()));
            lstKH = ser.getAll();
            showData(lstKH);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        Main.changeForm(new PanelLichSuMuaHang());
    }//GEN-LAST:event_btnThoatActionPerformed

    private void tblKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKHMouseClicked
        id = tblKH.getSelectedRow();
        showForm();
    }//GEN-LAST:event_tblKHMouseClicked

    private void btnThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem1ActionPerformed
        int hoi = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn sửa thêm khách hàng ");
        if (hoi == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, ser.updateKH(readForm()));
            lstKH = ser.getAll();
            showData(lstKH);
        }
    }//GEN-LAST:event_btnThem1ActionPerformed
    private void showData(List<KhachHang> lstKH) {
        model.setRowCount(0);
        for (KhachHang khachHang : lstKH) {
            model.addRow(new Object[]{
                khachHang.getMaKH(),
                khachHang.getTenKH(),
                khachHang.getSdt(),
                khachHang.getDiaChi(),
                FormatDate.toString(khachHang.getNgaySinh())
            });
        }
    }

    private void showForm() {
        KhachHang kh = lstKH.get(id);
        txtDiaCHi.setText(kh.getDiaChi());
        txtNgaySinh.setText(FormatDate.toString(kh.getNgaySinh()));
        txtMa.setText((kh.getMaKH()));
        txtTen.setText(kh.getTenKH());
        txtSDT.setText(kh.getSdt());
        tblKH.setRowSelectionInterval(id, id);
    }
    String checkSDT = "[0-9]{10}";

    private KhachHang readForm() {
        String maKH = txtMa.getText();
        String tenKH = txtTen.getText();
        String diaChi = txtDiaCHi.getText();
        String sdt = txtSDT.getText();
        String ngaySinh = txtNgaySinh.getText();

        if (maKH.isEmpty() || tenKH.isEmpty() || diaChi.isEmpty() || sdt.isEmpty() || ngaySinh.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hãy nhập dữ liệu đầy đủ ");
            return null;
        }
        try {
            FormatDate.toDate(ngaySinh);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, " Sai định dạng ngày sinh");
            return null;
        }
        Matcher mt = Pattern.compile(checkSDT).matcher(sdt);
        if (!mt.matches()) {
            JOptionPane.showMessageDialog(this, "SDT phải có 10 chữ số và phải là một số");
            return null;
        }

        return new KhachHang(maKH, tenKH, sdt, diaChi, FormatDate.toDate(ngaySinh));

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThem1;
    private javax.swing.JButton btnThoat;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblKH;
    private javax.swing.JTextArea txtDiaCHi;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables

}
