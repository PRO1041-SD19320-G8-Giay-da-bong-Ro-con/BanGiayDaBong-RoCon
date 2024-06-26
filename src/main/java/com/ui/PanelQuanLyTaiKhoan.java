/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.ui;

import com.dao.TaiKhoanDAO;
import com.entity.TaiKhoan;
import com.main.Main;
import com.utils.Auth;
import com.utils.FormatDate;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class PanelQuanLyTaiKhoan extends javax.swing.JPanel {

    /**
     * Creates new form panelQuanLyTaiKhoan
     */
    TaiKhoanDAO DAO = new TaiKhoanDAO();

    public PanelQuanLyTaiKhoan() {
        initComponents();

        showdata();
    }

    boolean checkdata() {

        if (txt_hovaten.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "tên không được để trống !!!");
            return false;
        }
        if (txt_hovaten.getText().length() < 5 || txt_hovaten.getText().length() > 20) {
            JOptionPane.showMessageDialog(this, "Tên phải từ 5 đến 20 ký tự");
            return false;
        }
        if (!txt_hovaten.getText().matches("[A-Za-z ]+")) {
            JOptionPane.showMessageDialog(this, "tên không được chứa số và chứa ký đặc biệt");
            return false;
        }

        if (txt_sdt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "SDT không được để trống !!");
            return false;
        }

        if (!txt_sdt.getText().matches("^0[0-9]{9}$")) {
            JOptionPane.showMessageDialog(this, "SDT phải có 10 chữ số và số đầu tiên phải là số 0");
            return false;
        }
        if (txt_email.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email không được để trống !!");
            return false;
        }
        if (txt_email.getText().length() < 10 || txt_email.getText().length() > 50) {
            JOptionPane.showMessageDialog(this, "Email phải từ 10 đến 50 ký tự");
            return false;
        }
        if (!txt_email.getText().matches("\\w+@\\w+(\\.\\w+){1,5}")) {
            JOptionPane.showMessageDialog(this, "Sai định dạng email");
            return false;
        }

        return true;
    }

    void showdata() {

        TaiKhoan tk = Auth.user;
        txt_taikhoan.setText(tk.getTaikhoan());
        txt_cccd.setText(tk.getCCCD());
        txt_hovaten.setText(tk.getTen());
        txt_chucvu.setText(tk.chucvuhienthi() + "");
        txt_ngaysinh.setText(FormatDate.toString(tk.getNgaysinh()));
        txt_email.setText(tk.getEmail());
        txt_sdt.setText(tk.getSdt());
    }

    TaiKhoan readfrom() {

        String tkhoan = txt_taikhoan.getText();
        String cccd = txt_cccd.getText();
        String ten = txt_hovaten.getText();
        String chucvu = txt_chucvu.getText();
        Date ngaySinh = FormatDate.toDate(txt_ngaysinh.getText());
        String sdt = txt_sdt.getText();
        String email = txt_email.getText();
        return new TaiKhoan(tkhoan, Auth.user.getMatkhau(), ten, ngaySinh, sdt, email, cccd, Auth.isManager());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_taikhoan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_hovaten = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_ngaysinh = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_sdt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_cccd = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_chucvu = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        tbn_doimatkhau = new javax.swing.JButton();
        btn_suathongtin = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thông Tin Tài Khoản");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setText("Tài khoản ");

        txt_taikhoan.setEditable(false);
        txt_taikhoan.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txt_taikhoan.setMargin(new java.awt.Insets(1, 10, 1, 10));
        txt_taikhoan.setPreferredSize(new java.awt.Dimension(64, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setText("Họ và tên");

        txt_hovaten.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txt_hovaten.setMargin(new java.awt.Insets(1, 10, 1, 10));
        txt_hovaten.setPreferredSize(new java.awt.Dimension(64, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setText("Ngày sinh");

        txt_ngaysinh.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txt_ngaysinh.setMargin(new java.awt.Insets(1, 10, 1, 10));
        txt_ngaysinh.setPreferredSize(new java.awt.Dimension(64, 50));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setText("SĐT");

        txt_sdt.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txt_sdt.setMargin(new java.awt.Insets(1, 10, 1, 10));
        txt_sdt.setPreferredSize(new java.awt.Dimension(64, 50));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel6.setText("Email");

        txt_email.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txt_email.setMargin(new java.awt.Insets(1, 10, 1, 10));
        txt_email.setPreferredSize(new java.awt.Dimension(64, 50));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel7.setText("CCCD");

        txt_cccd.setEditable(false);
        txt_cccd.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txt_cccd.setMargin(new java.awt.Insets(1, 10, 1, 10));
        txt_cccd.setPreferredSize(new java.awt.Dimension(64, 50));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel8.setText("Chức vụ");

        txt_chucvu.setEditable(false);
        txt_chucvu.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txt_chucvu.setMargin(new java.awt.Insets(1, 10, 1, 10));
        txt_chucvu.setPreferredSize(new java.awt.Dimension(64, 50));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tbn_doimatkhau.setBackground(new java.awt.Color(255, 204, 0));
        tbn_doimatkhau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tbn_doimatkhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dmk.png"))); // NOI18N
        tbn_doimatkhau.setText("Đổi mật khẩu");
        tbn_doimatkhau.setPreferredSize(new java.awt.Dimension(120, 30));
        tbn_doimatkhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbn_doimatkhauActionPerformed(evt);
            }
        });

        btn_suathongtin.setBackground(new java.awt.Color(255, 204, 0));
        btn_suathongtin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_suathongtin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/fix.png"))); // NOI18N
        btn_suathongtin.setText("Sửa thông tin");
        btn_suathongtin.setPreferredSize(new java.awt.Dimension(120, 30));
        btn_suathongtin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suathongtinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(tbn_doimatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(btn_suathongtin, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbn_doimatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_suathongtin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_suathongtin, tbn_doimatkhau});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_taikhoan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                    .addComponent(txt_hovaten, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_ngaysinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_sdt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_cccd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_email, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                            .addComponent(txt_chucvu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(2, 2, 2)))
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(223, 223, 223))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_cccd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_taikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_hovaten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel6, jLabel7, jLabel8, txt_cccd, txt_chucvu, txt_email, txt_hovaten, txt_ngaysinh, txt_sdt, txt_taikhoan});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_suathongtinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suathongtinActionPerformed
        if (checkdata()) {
            try {
                // TODO add your handling code here:
                TaiKhoan tk = this.readfrom();
                if (DAO.update(tk) > 0) {
                    Auth.user = DAO.selectByID(txt_taikhoan.getText());
                    showdata();
                    JOptionPane.showMessageDialog(this, "update thành Công");
                } else {
                    JOptionPane.showMessageDialog(this, "thất bại");
                }
            } catch (SQLException ex) {
                Logger.getLogger(PanelQuanLyTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_suathongtinActionPerformed

    private void tbn_doimatkhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbn_doimatkhauActionPerformed
        Main.changeForm(new PanelDoiMatKhau());
    }//GEN-LAST:event_tbn_doimatkhauActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_suathongtin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton tbn_doimatkhau;
    private javax.swing.JTextField txt_cccd;
    private javax.swing.JTextField txt_chucvu;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_hovaten;
    private javax.swing.JTextField txt_ngaysinh;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_taikhoan;
    // End of variables declaration//GEN-END:variables
}
