/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.ui;

import com.dao.TaiKhoanDAO;
import com.entity.TaiKhoan;
import com.main.Main;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class PanelDoiMatKhau extends javax.swing.JPanel {
TaiKhoanDAO DAO = new TaiKhoanDAO();
    TaiKhoan tk = new TaiKhoan();
    /**
     * Creates new form Paneldoimatkhau
     */
    public PanelDoiMatKhau() {
        initComponents();
    }
    boolean checkvalue() {
        if (txt_taikhoan.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "tk khong dc de trong");
            return false;
        }
        if (txt_matkhau.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "MK khong dc de trong");
            return false;
        }
        if (txt_matkhau1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "MK mới khong dc de trong");
            return false;
        }
        if (txt_matkhau2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "MK nhập lại không được để trống khong dc de trong");
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

        jPanel1 = new javax.swing.JPanel();
        txt_taikhoan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Btn_Thoat = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Btn_XacNhan = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_matkhau = new javax.swing.JPasswordField();
        txt_matkhau1 = new javax.swing.JPasswordField();
        txt_matkhau2 = new javax.swing.JPasswordField();
        cbHienMatKhau2 = new javax.swing.JCheckBox();
        cbHienMatKhau = new javax.swing.JCheckBox();
        cbHienMatKhau1 = new javax.swing.JCheckBox();

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Mật Khẩu hiện tại ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Mật Khẩu Mới");

        Btn_Thoat.setBackground(new java.awt.Color(0, 255, 0));
        Btn_Thoat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Btn_Thoat.setText("Quay Lại");
        Btn_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ThoatActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Xác Nhận Lại Mật Khẩu Mới");

        Btn_XacNhan.setBackground(new java.awt.Color(255, 204, 0));
        Btn_XacNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Btn_XacNhan.setText("Xác Nhận");
        Btn_XacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_XacNhanActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tài Khoản ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Đổi Mật Khẩu");

        cbHienMatKhau2.setText("Hiện mật khẩu");
        cbHienMatKhau2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHienMatKhau2ActionPerformed(evt);
            }
        });

        cbHienMatKhau.setText("Hiện mật khẩu");
        cbHienMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHienMatKhauActionPerformed(evt);
            }
        });

        cbHienMatKhau1.setText("Hiện mật khẩu");
        cbHienMatKhau1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHienMatKhau1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Btn_Thoat, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addComponent(txt_matkhau2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_matkhau, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_matkhau1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_taikhoan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbHienMatKhau2)
                            .addComponent(cbHienMatKhau1)
                            .addComponent(cbHienMatKhau))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 351, Short.MAX_VALUE)
                        .addComponent(Btn_XacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(176, 176, 176))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(txt_taikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_matkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cbHienMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_matkhau1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbHienMatKhau1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_matkhau2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbHienMatKhau2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Thoat, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_XacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txt_matkhau, txt_matkhau1, txt_matkhau2, txt_taikhoan});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_ThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ThoatActionPerformed
        // TODO add your handling code here:
        Main.changeForm(new PanelQuanLyTaiKhoan());
    }//GEN-LAST:event_Btn_ThoatActionPerformed

    private void Btn_XacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_XacNhanActionPerformed
      if(checkvalue()){
        String manv = txt_taikhoan.getText();
        String matkhau = new String(txt_matkhau.getPassword());
        String matkhaumoi = new String(txt_matkhau1.getPassword());
        String matkhaumoi2 = new String(txt_matkhau2.getPassword());
        if (!TaiKhoanDAO.checkLogin(manv, matkhau)) {
            JOptionPane.showMessageDialog(this, "Sai Tài Khoản Hoặc Mật Khẩu");
        } else if (!matkhaumoi.equals(matkhaumoi2)) {
            JOptionPane.showMessageDialog(this, "Xác nhận lại mật khẩu không đúng");
        }else{
            tk.setMatkhau(matkhaumoi);
            DAO.updatemk(tk, manv);
            JOptionPane.showMessageDialog(this, "Đổi mật Khẩu Thành Công ");
        }
      }
    }//GEN-LAST:event_Btn_XacNhanActionPerformed

    private void cbHienMatKhau2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHienMatKhau2ActionPerformed
        if (cbHienMatKhau2.isSelected()) {
            txt_matkhau2.setEchoChar((char) 0);
        } else {
            txt_matkhau2.setEchoChar('*');
        }
    }//GEN-LAST:event_cbHienMatKhau2ActionPerformed

    private void cbHienMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHienMatKhauActionPerformed
        if (cbHienMatKhau.isSelected()) {
            txt_matkhau.setEchoChar((char) 0);
        } else {
            txt_matkhau.setEchoChar('*');
        }
    }//GEN-LAST:event_cbHienMatKhauActionPerformed

    private void cbHienMatKhau1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHienMatKhau1ActionPerformed
        if (cbHienMatKhau1.isSelected()) {
            txt_matkhau1.setEchoChar((char) 0);
        } else {
            txt_matkhau1.setEchoChar('*');
        }
    }//GEN-LAST:event_cbHienMatKhau1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Thoat;
    private javax.swing.JButton Btn_XacNhan;
    private javax.swing.JCheckBox cbHienMatKhau;
    private javax.swing.JCheckBox cbHienMatKhau1;
    private javax.swing.JCheckBox cbHienMatKhau2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txt_matkhau;
    private javax.swing.JPasswordField txt_matkhau1;
    private javax.swing.JPasswordField txt_matkhau2;
    private javax.swing.JTextField txt_taikhoan;
    // End of variables declaration//GEN-END:variables
}
