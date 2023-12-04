/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.ui;

import com.dao.HoaDonDAO;
import com.entity.HoaDon;
import com.main.Main;
import com.utils.FormatDate;
import com.utils.TextUtil;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thai
 */
public class PanelHoaDon extends javax.swing.JPanel {

    /**
     * Creates new form PanelHoaDon
     */
    DefaultTableModel model;
    HoaDonDAO daoHD = new HoaDonDAO();

    public PanelHoaDon() {
        initComponents();
        model = (DefaultTableModel) tblHoaDon.getModel();
        try {
            showHoaDon(daoHD.selectAll());
        } catch (SQLException ex) {
            Logger.getLogger(PanelHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i = 2000 ; i <= Calendar.getInstance().get(Calendar.YEAR) ; i++){
            cbNam.addItem(i+"");
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

        jPanelHoaDon = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        btnXemChiTiet = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbNgay = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbThang = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbNam = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbTinhTrang = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        jPanelHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "HÓA ĐƠN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MA HD", "Ngày tạo", "Nhân viên", "Mã khách hàng", "Tổng tiền", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.setRowHeight(30);
        jScrollPane1.setViewportView(tblHoaDon);

        btnXemChiTiet.setBackground(new java.awt.Color(255, 204, 0));
        btnXemChiTiet.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXemChiTiet.setText("Xem chi tiết hóa đơn");
        btnXemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemChiTietActionPerformed(evt);
            }
        });

        jLabel6.setText("Bộ lọc");

        jLabel1.setText("Ngày");

        cbNgay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "none", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        cbNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNgayActionPerformed(evt);
            }
        });

        jLabel3.setText("Tháng");

        cbThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "none", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbThangActionPerformed(evt);
            }
        });

        jLabel4.setText("Năm");

        cbNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "none", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000" }));
        cbNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNamActionPerformed(evt);
            }
        });

        jLabel5.setText("Tình trạng");

        cbTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "none", "Đã thanh toán", "Chưa thanh toán" }));
        cbTinhTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTinhTrangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))))
                            .addComponent(cbTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cbNgay)
                    .addComponent(cbThang)
                    .addComponent(cbNam))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelHoaDonLayout = new javax.swing.GroupLayout(jPanelHoaDon);
        jPanelHoaDon.setLayout(jPanelHoaDonLayout);
        jPanelHoaDonLayout.setHorizontalGroup(
            jPanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHoaDonLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnXemChiTiet))
            .addGroup(jPanelHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelHoaDonLayout.setVerticalGroup(
            jPanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHoaDonLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXemChiTiet))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("QUẢN LÝ HÓA ĐƠN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnXemChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemChiTietActionPerformed
        xemChiTiet();
    }//GEN-LAST:event_btnXemChiTietActionPerformed

    private void cbNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNgayActionPerformed
        locHoaDon();
    }//GEN-LAST:event_cbNgayActionPerformed

    private void cbThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbThangActionPerformed
        locHoaDon();
    }//GEN-LAST:event_cbThangActionPerformed

    private void cbNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNamActionPerformed
        locHoaDon();
    }//GEN-LAST:event_cbNamActionPerformed

    private void cbTinhTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTinhTrangActionPerformed
        locHoaDon();
    }//GEN-LAST:event_cbTinhTrangActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXemChiTiet;
    private javax.swing.JComboBox<String> cbNam;
    private javax.swing.JComboBox<String> cbNgay;
    private javax.swing.JComboBox<String> cbThang;
    private javax.swing.JComboBox<String> cbTinhTrang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelHoaDon;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHoaDon;
    // End of variables declaration//GEN-END:variables

    private void showHoaDon(List<HoaDon> list) {
        try {
            model.setRowCount(0);
            for (HoaDon hd : list) {
                model.addRow(new Object[]{hd.getMaHD(), FormatDate.toString(hd.getThoiGianBan()), hd.getTaiKhoan(), hd.getMaKH(), TextUtil.round(hd.getTongTienCuoi()), hd.getTrangThai()});
            }
        } catch (Exception e) {
            Logger.getLogger(PanelHoaDon.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void xemChiTiet() {
        try {
            int row = tblHoaDon.getSelectedRow();
            if (row != -1) {
                String maHD = tblHoaDon.getValueAt(row, 0).toString();
                PanelChiTietHoaDon.hoaDon = daoHD.selectByID(maHD);
                Main.changeForm(new PanelChiTietHoaDon(this));
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void locHoaDon() {
        try {
            String ngay = cbNgay.getSelectedItem().toString();
            String thang = cbThang.getSelectedItem().toString();
            String nam = cbNam.getSelectedItem().toString();
            String trangThai = cbTinhTrang.getSelectedItem().toString();
            if (checkNone(ngay, thang, nam, trangThai)) {
                showHoaDon(daoHD.selectAll());
            } else {
                String loc = " where";
                if (!ngay.equals("none")) {
                    loc += " day(ThoiGianBan) = " + ngay + " .";
                }
                if (!thang.equals("none")) {
                    loc += " month(ThoiGianBan) = " + thang + " .";
                }
                if (!nam.equals("none")) {
                    loc += " year(ThoiGianBan) = " + nam + " .";
                }
                if (!trangThai.equals("none")) {
                    loc += " TrangThai = " + (trangThai.equals("Đã thanh toán") ? "1" : "0");
                }
                if (loc.endsWith(".")) {
                    loc = loc.substring(0, loc.length() - 1);
                }
                loc = loc.replace(".", "and");
                showHoaDon(daoHD.selectAll(loc));
            }
        } catch (Exception e) {
            System.out.println("Lỗi lọc");
        }
    }

    private boolean checkNone(String... args) {
        for (String txt : args) {
            if (!txt.equals("none")) {
                return false;
            }
        }
        return true;
    }
}
