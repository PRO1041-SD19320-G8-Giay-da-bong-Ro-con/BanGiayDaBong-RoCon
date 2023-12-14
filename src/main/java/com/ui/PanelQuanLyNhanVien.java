/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.ui;

import com.dao.TaiKhoanDAO;
import com.entity.SanPham;
import com.entity.TaiKhoan;
import com.main.Main;
import com.utils.Auth;
import com.utils.FormatDate;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.MailDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import com.utils.TextUtil;
/**
 *
 * @author DELL
 */
public class PanelQuanLyNhanVien extends javax.swing.JPanel {

    TaiKhoanDAO DAO = new TaiKhoanDAO();
    DefaultTableModel model = new DefaultTableModel();
    int index = -1;
    SimpleDateFormat format  = new SimpleDateFormat("dd/MM/yyyy");
    
    /**
     * Creates new form PanelQuanLyNhanVien
     */
    public PanelQuanLyNhanVien() {
        initComponents();
        filltable(DAO.getall());
    }

    void filltable(List<TaiKhoan> List) {
        model = (DefaultTableModel) tbl_qlnv.getModel();
        model.setRowCount(0);
        for (TaiKhoan x : List) {
            model.addRow(x.todatarow());
        }
    }

    void showdata(int index) {
        TaiKhoan tk = DAO.getall().get(index);
        txt_taikhoan.setText(tk.getTaikhoan());
        
        txt_hovaten.setText(tk.getTen());
        txt_ngaysinh.setText(FormatDate.toString(tk.getNgaysinh()));
        txt_sdt.setText(tk.getSdt());
        txt_email.setText(tk.getEmail());
        txt_cccd.setText(tk.getCCCD());
        if (tk.isChucvu()) {
            rdo_quanly.setSelected(true);
        } else {
            rdo_nhanvien.setSelected(true);
        }
    }

    TaiKhoan readfrom() {

        String tkhoan = txt_taikhoan.getText();
        
        String cccd = txt_cccd.getText();
        String ten = txt_hovaten.getText();
        Date ngaySinh = FormatDate.toDate(txt_ngaysinh.getText());
        String sdt = txt_sdt.getText();
        String email = txt_email.getText();
        boolean chucvu;
        if (rdo_quanly.isSelected()) {
            chucvu = true;
        } else {
            chucvu = false;
        }
        return new TaiKhoan(tkhoan, ten, ngaySinh, sdt, email, cccd, chucvu);
    }

    boolean checkdata() {
        format.setLenient(false);
        if (txt_taikhoan.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tài Khoản Không được để Trống");
            return false;
        }
        
        if (txt_hovaten.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "tên không được để trống !!!");
            return false;
        }
        if (txt_hovaten.getText().length() < 5 || txt_hovaten.getText().length() > 20) {
            JOptionPane.showMessageDialog(this, "Tên phải từ 5 đến 20 ký tự");
            return false;
        }
        if(!TextUtil.isName(txt_hovaten.getText())){
            JOptionPane.showMessageDialog(this, "tên không được chứa số và chứa ký đặc biệt");
            return false;
        }
        try {
            Date ngaysinh = format.parse(txt_ngaysinh.getText());
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ngày sinh phải đúng from dd/MM/yyyy");
        }
        if (txt_sdt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "SDT không được để trống !!");
            return false;
        }
        if (txt_sdt.getText().length() != 10) {
            JOptionPane.showMessageDialog(this, "SDT phải là 10 số nguyên");
            return false;
        }
        if (!txt_sdt.getText().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "sdt phải là số");
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
        if (!txt_email.getText().matches(".*[@].*")) {
            JOptionPane.showMessageDialog(this, "Email phải chứa @");
            return false;
        }
        if (txt_cccd.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "CCCD không được để trống !!");
            return false;
        }
        if (txt_cccd.getText().length() != 12) {
            JOptionPane.showMessageDialog(this, "CCCD phải là 12 số nguyên");
            return false;
        }
        if (!txt_cccd.getText().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "CCCD phải là số");
            return false;
        }
        if (!rdo_quanly.isSelected() && !rdo_nhanvien.isSelected()) {
            JOptionPane.showMessageDialog(this, "vui lòng chọn chức vụ");
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_qlnv = new javax.swing.JTable();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_taikhoan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_hovaten = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_ngaysinh = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_sdt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_cccd = new javax.swing.JTextField();
        rdo_quanly = new javax.swing.JRadioButton();
        rdo_nhanvien = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        txt_timkiem = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        tbl_qlnv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Tài Khoản", "Họ và Tên", "Ngày Sinh", "Số Điện Thoại", "Email", "CCCD", "Chức Vụ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_qlnv.setRowHeight(30);
        tbl_qlnv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_qlnvMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_qlnv);

        btn_them.setBackground(new java.awt.Color(255, 204, 0));
        btn_them.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add2.png"))); // NOI18N
        btn_them.setText("Thêm ");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setBackground(new java.awt.Color(255, 204, 0));
        btn_sua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sua.png"))); // NOI18N
        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        jLabel2.setText("Tài Khoản :");

        txt_taikhoan.setEditable(false);

        jLabel3.setText("Họ Và Tên");

        jLabel4.setText("Ngày Sinh");

        jLabel5.setText("SĐT");

        jLabel6.setText("Chức Vụ");

        jLabel7.setText("Email");

        jLabel8.setText("CCCD");

        buttonGroup1.add(rdo_quanly);
        rdo_quanly.setText("Quản Lý");

        buttonGroup1.add(rdo_nhanvien);
        rdo_nhanvien.setText("Nhân Viên");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txt_timkiem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_timkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_timkiemKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_timkiemKeyReleased(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/tim1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_hovaten)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_ngaysinh)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_sdt)
                        .addComponent(jLabel7)
                        .addComponent(txt_email)
                        .addComponent(txt_cccd)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(rdo_quanly)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rdo_nhanvien)))
                    .addComponent(txt_taikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_sua)
                .addGap(92, 92, 92)
                .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(178, 178, 178))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_sua, btn_them});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_cccd, txt_email, txt_hovaten, txt_ngaysinh, txt_sdt, txt_taikhoan});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_taikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_hovaten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txt_ngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txt_cccd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdo_quanly)
                            .addComponent(rdo_nhanvien)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, txt_cccd, txt_email, txt_hovaten, txt_ngaysinh, txt_sdt, txt_taikhoan});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_sua, btn_them});

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Quản Lý Nhân Viên");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 835, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        Main.changeForm(new PanelThemNhanVien());
    }//GEN-LAST:event_btn_themActionPerformed

    private void tbl_qlnvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_qlnvMouseClicked
        index = tbl_qlnv.getSelectedRow();
        showdata(index);
    }//GEN-LAST:event_tbl_qlnvMouseClicked

    private void txt_timkiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timkiemKeyPressed

    }//GEN-LAST:event_txt_timkiemKeyPressed

    private void txt_timkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timkiemKeyReleased
        showTable();
    }//GEN-LAST:event_txt_timkiemKeyReleased

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        if (this.checkdata()) {
            TaiKhoan tk = this.readfrom();
            String taikhoan = tbl_qlnv.getValueAt(index, 0).toString();
            if (DAO.updatee(tk, taikhoan) > 0) {
                JOptionPane.showMessageDialog(this, "Sửa Thông Tin Thành Công");
                filltable(DAO.getall());
            } else {
                JOptionPane.showMessageDialog(this, "thất Bại r lượm ơi");
            }
        }
        
    }//GEN-LAST:event_btn_suaActionPerformed
    private void showTable() {

        DefaultTableModel model = (DefaultTableModel) tbl_qlnv.getModel();
        model.setRowCount(0);
        TableColumnModel column = tbl_qlnv.getColumnModel();
        int[] size = {100, 200, 130, 130, 130, 130, 130};
        for (int i = 0; i < model.getColumnCount(); i++) {
            column.getColumn(i).setPreferredWidth(size[i]);
        }

        String key = txt_timkiem.getText();
        try {
            for (TaiKhoan sp : DAO.selectAll()) {
                if (sp.getTaikhoan().toUpperCase().contains(key.toUpperCase()) || sp.getTen().toUpperCase().contains(key.toUpperCase())) {
                    model.addRow(new Object[]{sp.getTaikhoan(), sp.getTen(), sp.getNgaysinh(), sp.getSdt(), sp.getEmail(), sp.getCCCD(), sp.chucvuhienthi()});
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelQuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdo_nhanvien;
    private javax.swing.JRadioButton rdo_quanly;
    private javax.swing.JTable tbl_qlnv;
    private javax.swing.JTextField txt_cccd;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_hovaten;
    private javax.swing.JTextField txt_ngaysinh;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_taikhoan;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
