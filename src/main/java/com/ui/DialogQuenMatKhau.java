/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.ui;

import com.dao.TaiKhoanDAO;
import com.entity.TaiKhoan;
import com.utils.SendEmail;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.text.PasswordView;

/**
 *
 * @author DELL
 */
public class DialogQuenMatKhau extends javax.swing.JDialog {

    /**
     * Creates new form quenmatkhauJDialog
     */
    CardLayout card = new CardLayout();
    TaiKhoanDAO daoTK = new TaiKhoanDAO();
    private TaiKhoan taiKhoan = null;
    SendEmail send = new SendEmail();
    private String maXacNhan = "";

    public DialogQuenMatKhau(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        panelQuenMatKhau.setLayout(card);

        btnXacNhanTaiKhoan.registerKeyboardAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xacNhanTaiKhoan();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelQuenMatKhau = new javax.swing.JPanel();
        panelNhapTaiKhoan = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnXacNhanTaiKhoan = new javax.swing.JButton();
        btnHuyXacNhanTaiKhoan = new javax.swing.JButton();
        txtTaiKhoan = new javax.swing.JTextField();
        panelNhapMa = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnXacNhanMa = new javax.swing.JButton();
        btnHuyXacNhanMa = new javax.swing.JButton();
        txtXacNhan = new javax.swing.JTextField();
        panelDoiMatKhau = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnXacNhanDoi = new javax.swing.JButton();
        btnHuyDoiMatKhau = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbHienMatKhau = new javax.swing.JCheckBox();
        txtXacNhanMatKhau = new javax.swing.JPasswordField();
        txtMatKhauMoi = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelQuenMatKhau.setLayout(new java.awt.CardLayout());

        panelNhapTaiKhoan.setPreferredSize(new java.awt.Dimension(493, 254));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quên Mật Khẩu");

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Tài khoản");

        btnXacNhanTaiKhoan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXacNhanTaiKhoan.setText("Xác Nhận");
        btnXacNhanTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanTaiKhoanActionPerformed(evt);
            }
        });

        btnHuyXacNhanTaiKhoan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHuyXacNhanTaiKhoan.setText("Hủy");
        btnHuyXacNhanTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyXacNhanTaiKhoanActionPerformed(evt);
            }
        });

        txtTaiKhoan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTaiKhoan.setMargin(new java.awt.Insets(4, 6, 4, 6));
        txtTaiKhoan.setPreferredSize(new java.awt.Dimension(71, 40));

        javax.swing.GroupLayout panelNhapTaiKhoanLayout = new javax.swing.GroupLayout(panelNhapTaiKhoan);
        panelNhapTaiKhoan.setLayout(panelNhapTaiKhoanLayout);
        panelNhapTaiKhoanLayout.setHorizontalGroup(
            panelNhapTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelNhapTaiKhoanLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(panelNhapTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelNhapTaiKhoanLayout.createSequentialGroup()
                        .addComponent(btnXacNhanTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHuyXacNhanTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );
        panelNhapTaiKhoanLayout.setVerticalGroup(
            panelNhapTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNhapTaiKhoanLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(panelNhapTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXacNhanTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyXacNhanTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        panelQuenMatKhau.add(panelNhapTaiKhoan, "card1");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Quên Mật Khẩu");

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel4.setText("Nhập mã xác nhận. Hệ thống đã gửi về email chủ tài khoản");

        btnXacNhanMa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXacNhanMa.setText("Xác Nhận");
        btnXacNhanMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanMaActionPerformed(evt);
            }
        });

        btnHuyXacNhanMa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHuyXacNhanMa.setText("Hủy");
        btnHuyXacNhanMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyXacNhanMaActionPerformed(evt);
            }
        });

        txtXacNhan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtXacNhan.setMargin(new java.awt.Insets(4, 6, 4, 6));
        txtXacNhan.setPreferredSize(new java.awt.Dimension(71, 40));

        javax.swing.GroupLayout panelNhapMaLayout = new javax.swing.GroupLayout(panelNhapMa);
        panelNhapMa.setLayout(panelNhapMaLayout);
        panelNhapMaLayout.setHorizontalGroup(
            panelNhapMaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelNhapMaLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(panelNhapMaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelNhapMaLayout.createSequentialGroup()
                        .addComponent(btnXacNhanMa, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHuyXacNhanMa, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtXacNhan, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50))
        );
        panelNhapMaLayout.setVerticalGroup(
            panelNhapMaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNhapMaLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(panelNhapMaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXacNhanMa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyXacNhanMa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        panelQuenMatKhau.add(panelNhapMa, "card2");

        panelDoiMatKhau.setName(""); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Đổi mật khẩu");

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Mật khẩu mới");
        jLabel6.setPreferredSize(new java.awt.Dimension(74, 12));

        btnXacNhanDoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXacNhanDoi.setText("Xác Nhận");
        btnXacNhanDoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanDoiActionPerformed(evt);
            }
        });

        btnHuyDoiMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHuyDoiMatKhau.setText("Hủy");
        btnHuyDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyDoiMatKhauActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Xác nhận mật khẩu mới");
        jLabel7.setPreferredSize(new java.awt.Dimension(74, 12));

        cbHienMatKhau.setText("Hiện mật khẩu");
        cbHienMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHienMatKhauActionPerformed(evt);
            }
        });

        txtXacNhanMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtMatKhauMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout panelDoiMatKhauLayout = new javax.swing.GroupLayout(panelDoiMatKhau);
        panelDoiMatKhau.setLayout(panelDoiMatKhauLayout);
        panelDoiMatKhauLayout.setHorizontalGroup(
            panelDoiMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelDoiMatKhauLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(panelDoiMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbHienMatKhau)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                    .addGroup(panelDoiMatKhauLayout.createSequentialGroup()
                        .addComponent(btnXacNhanDoi, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(btnHuyDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtXacNhanMatKhau)
                    .addComponent(txtMatKhauMoi))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        panelDoiMatKhauLayout.setVerticalGroup(
            panelDoiMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDoiMatKhauLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtXacNhanMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbHienMatKhau)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDoiMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXacNhanDoi, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        panelQuenMatKhau.add(panelDoiMatKhau, "card3");
        panelDoiMatKhau.getAccessibleContext().setAccessibleName("");
        panelDoiMatKhau.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelQuenMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelQuenMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXacNhanTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanTaiKhoanActionPerformed
        xacNhanTaiKhoan();
    }//GEN-LAST:event_btnXacNhanTaiKhoanActionPerformed

    private void btnHuyXacNhanTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyXacNhanTaiKhoanActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnHuyXacNhanTaiKhoanActionPerformed

    private void btnXacNhanMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanMaActionPerformed
        checkXacNhan();
    }//GEN-LAST:event_btnXacNhanMaActionPerformed

    private void btnHuyXacNhanMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyXacNhanMaActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnHuyXacNhanMaActionPerformed

    private void btnXacNhanDoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanDoiActionPerformed
        doiMatKhau();
    }//GEN-LAST:event_btnXacNhanDoiActionPerformed

    private void btnHuyDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyDoiMatKhauActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnHuyDoiMatKhauActionPerformed

    private void cbHienMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHienMatKhauActionPerformed
        if (cbHienMatKhau.isSelected()) {
            txtMatKhauMoi.setEchoChar((char) 0);
            txtXacNhanMatKhau.setEchoChar((char) 0);
        } else {
            txtMatKhauMoi.setEchoChar('*');
            txtXacNhanMatKhau.setEchoChar('*');
        }
    }//GEN-LAST:event_cbHienMatKhauActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DialogQuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogQuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogQuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogQuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogQuenMatKhau dialog = new DialogQuenMatKhau(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuyDoiMatKhau;
    private javax.swing.JButton btnHuyXacNhanMa;
    private javax.swing.JButton btnHuyXacNhanTaiKhoan;
    private javax.swing.JButton btnXacNhanDoi;
    private javax.swing.JButton btnXacNhanMa;
    private javax.swing.JButton btnXacNhanTaiKhoan;
    private javax.swing.JCheckBox cbHienMatKhau;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel panelDoiMatKhau;
    private javax.swing.JPanel panelNhapMa;
    private javax.swing.JPanel panelNhapTaiKhoan;
    private javax.swing.JPanel panelQuenMatKhau;
    private javax.swing.JPasswordField txtMatKhauMoi;
    private javax.swing.JTextField txtTaiKhoan;
    private javax.swing.JTextField txtXacNhan;
    private javax.swing.JPasswordField txtXacNhanMatKhau;
    // End of variables declaration//GEN-END:variables

    private TaiKhoan timTaiKhoan() {
        try {
            for (TaiKhoan tk : daoTK.selectAll()) {
                if (tk.getTaikhoan().equals(txtTaiKhoan.getText())) {
                    taiKhoan = tk;
                }
            }
            return taiKhoan;
        } catch (Exception ex) {
            Logger.getLogger(DialogQuenMatKhau.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private void xacNhanTaiKhoan() {
        try {
            timTaiKhoan();
            if (taiKhoan != null) {

                maXacNhan = "";
                for (int i = 0; i < 6; i++) {
                    maXacNhan += String.valueOf(new Random().nextInt(10));
                }

                send.sendEmail(this, taiKhoan.getEmail(), maXacNhan);
                System.out.println(maXacNhan);
                card.next(panelQuenMatKhau);
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy tài khoản");
            }
        } catch (Exception e) {
            Logger.getLogger(DialogQuenMatKhau.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void checkXacNhan() {
        if (txtXacNhan.getText().equals(maXacNhan)) {
            card.next(panelQuenMatKhau);
        } else {
            JOptionPane.showMessageDialog(this, "Sai mã");
        }
    }

    private boolean validateMatKhau() {
        JPasswordField[] allPass = {txtMatKhauMoi, txtXacNhanMatKhau};
        for (JPasswordField pass : allPass) {
            String ps = new String(pass.getPassword());
            if (ps.isBlank()) {
                JOptionPane.showMessageDialog(this, "Không được để trống");
                return false;
            }
        }
        for (JPasswordField pass : allPass) {
            String ps = new String(pass.getPassword());
            if (ps.trim().length() < 6) {
                JOptionPane.showMessageDialog(this, "Mật khẩu phải dài hơn 5 kí tự");
                return false;
            }
        }
        if (!Arrays.equals(allPass[0].getPassword(), allPass[1].getPassword())) {
            JOptionPane.showMessageDialog(this, "Mật khẩu mới và mật khẩu xác nhận không trùng nhau");
            return false;
        }
        return true;
    }

    private void doiMatKhau() {
        try {
            if (validateMatKhau()) {
                if (daoTK.update(new String(txtMatKhauMoi.getPassword()), taiKhoan.getTaikhoan()) > 0) {
                    this.dispose();
                    JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Đổi mật khẩu thất bại");
                }
            }
        } catch (Exception e) {
            Logger.getLogger(DialogQuenMatKhau.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Đổi mật khẩu thất bại");
        }
    }
}