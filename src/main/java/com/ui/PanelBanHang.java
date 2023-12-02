/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.ui;

import com.dao.ChatLieuDAO;
import com.dao.ChiTietHoaDonDAO;
import com.dao.ChiTietSanPhamDAO;
import com.dao.HoaDonDAO;
import com.dao.KhuyenMaiDAO;
import com.dao.LoaiGiayDAO;
import com.dao.MauSacDAO;
import com.dao.SanPhamDAO;
import com.dao.SizeDAO;
import com.dao.ThuongHieuDAO;
import com.dao.XuatXuDAO;
import com.entity.ChiTietHoaDon;
import com.entity.ChiTietSanPham;
import com.entity.HoaDon;
import com.entity.KhuyenMai;
import com.utils.Auth;
import com.utils.TextUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thai
 */
public class PanelBanHang extends javax.swing.JPanel {

    XuatXuDAO daoXX = new XuatXuDAO();
    LoaiGiayDAO daoLG = new LoaiGiayDAO();
    ChatLieuDAO daoCL = new ChatLieuDAO();
    ThuongHieuDAO daoTH = new ThuongHieuDAO();
    MauSacDAO daoMS = new MauSacDAO();
    SizeDAO daoS = new SizeDAO();
    SanPhamDAO daoSP = new SanPhamDAO();
    ChiTietSanPhamDAO daoCTSP = new ChiTietSanPhamDAO();
    HoaDonDAO daoHD = new HoaDonDAO();
    ChiTietHoaDonDAO daoCTHD = new ChiTietHoaDonDAO();
    KhuyenMaiDAO daoKM = new KhuyenMaiDAO();

    DefaultTableModel modelSP = null;
    DefaultTableModel modelDH = null;

    Double tongTien = null;

    /**
     * Creates new form HoaDon_JDiaLog
     */
    public PanelBanHang() {
        initComponents();
        modelSP = (DefaultTableModel) tblSanPham.getModel();
        modelDH = (DefaultTableModel) tblDonHang.getModel();

        fillCombo();
        showTableThongTinSanPham();
        txtMaNV.setText(Auth.user.getTaikhoan());

        modelDH.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                try {
                    Double gia = 0d;
                    for (int i = 0; i < tblDonHang.getRowCount(); i++) {
                        gia += (double) tblDonHang.getValueAt(i, 3);
                    }
                    lblTongTien.setText(TextUtil.round(gia));
                    KhuyenMai km = daoKM.selectByID((String) cboKhuyenMai.getSelectedItem());
                    String thongTin = "";
                    if (km != null) {
                        if (km.isLoaiKM()) {
                            gia -= ((gia / 100) * km.getGiamGia());
                            thongTin = "-" + km.getGiamGia() + "%";
                        } else {
                            gia -= km.getGiamGia();
                            thongTin = "-" + km.getGiamGia() + "vnđ";
                        }

                    }
                    lblGiamGia.setText(thongTin);
                    tongTien = gia;
                    lblTongTienThanhToan.setText(TextUtil.round(gia));
                } catch (SQLException ex) {
                    Logger.getLogger(PanelBanHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        cboKhuyenMaiItemStateChanged(null);

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanelSanPham = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btnThemVaoDonHang = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jPanelĐonHang = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDonHang = new javax.swing.JTable();
        btnXoaKhoiDonHang = new javax.swing.JButton();
        btnXoaKhoiDonHang1 = new javax.swing.JButton();
        jPanelQLHD = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblTongTienThanhToan = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtTienMatKhachTra = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        lblTienThua = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        cboKhuyenMai = new javax.swing.JComboBox<>();
        btnTaoHoaDon = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lblGiamGia = new javax.swing.JLabel();
        jPanelHoaDonCho = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("BÁN HÀNG");

        jPanelSanPham.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN SẢN PHẨM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã chi tiết", "Mã sản phẩm", "Tên sản phẩm", "Màu", "Size", "Giá", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.setRowHeight(30);
        jScrollPane2.setViewportView(tblSanPham);

        btnThemVaoDonHang.setText("Thêm vào đơn hàng");
        btnThemVaoDonHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemVaoDonHangMouseClicked(evt);
            }
        });
        btnThemVaoDonHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemVaoDonHangActionPerformed(evt);
            }
        });

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanelSanPhamLayout = new javax.swing.GroupLayout(jPanelSanPham);
        jPanelSanPham.setLayout(jPanelSanPhamLayout);
        jPanelSanPhamLayout.setHorizontalGroup(
            jPanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSanPhamLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnThemVaoDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTimKiem))
                .addContainerGap())
        );
        jPanelSanPhamLayout.setVerticalGroup(
            jPanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThemVaoDonHang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelĐonHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ĐƠN HÀNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tblDonHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã chi tiết", "Tên sản phẩm", "Số lượng", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblDonHang);

        btnXoaKhoiDonHang.setText("Xóa khỏi đơn hàng");
        btnXoaKhoiDonHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKhoiDonHangActionPerformed(evt);
            }
        });

        btnXoaKhoiDonHang1.setText("Sửa số lượng");
        btnXoaKhoiDonHang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKhoiDonHang1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelĐonHangLayout = new javax.swing.GroupLayout(jPanelĐonHang);
        jPanelĐonHang.setLayout(jPanelĐonHangLayout);
        jPanelĐonHangLayout.setHorizontalGroup(
            jPanelĐonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelĐonHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelĐonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                    .addGroup(jPanelĐonHangLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnXoaKhoiDonHang1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoaKhoiDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelĐonHangLayout.setVerticalGroup(
            jPanelĐonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelĐonHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelĐonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaKhoiDonHang)
                    .addComponent(btnXoaKhoiDonHang1)))
        );

        jPanelQLHD.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ĐƠN HÀNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel2.setText("Khách hàng");

        jLabel4.setText("Tổng tiền: ");

        lblTongTien.setText("0.0");

        jLabel6.setText("Khuyến mãi");

        jLabel5.setText("Tổng tiền cần thanh toán: ");

        lblTongTienThanhToan.setText("0.0");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THANH TOÁN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel8.setText("Tổng tiiền khách trả");

        txtTienMatKhachTra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienMatKhachTraKeyReleased(evt);
            }
        });

        jLabel10.setText("Tiền thừa");

        lblTienThua.setText("0.0");

        jLabel18.setText("VND");

        jLabel20.setText("VND");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(73, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(38, 38, 38)
                        .addComponent(txtTienMatKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel20)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTienMatKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblTienThua)
                    .addComponent(jLabel20))
                .addGap(17, 17, 17))
        );

        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThanhToanMouseClicked(evt);
            }
        });

        jLabel11.setText("VND");

        jLabel16.setText("VND");

        jLabel21.setText("Mã nhân viên");

        txtMaNV.setEnabled(false);

        jLabel22.setText("Mã hóa đơn");

        txtMaHD.setEnabled(false);

        cboKhuyenMai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboKhuyenMai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboKhuyenMaiItemStateChanged(evt);
            }
        });

        btnTaoHoaDon.setBackground(new java.awt.Color(153, 255, 255));
        btnTaoHoaDon.setText("Tạo hóa đơn");
        btnTaoHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTaoHoaDonMouseClicked(evt);
            }
        });

        jButton1.setText("Chọn khách hàng");

        lblGiamGia.setText("Giảm giá");

        javax.swing.GroupLayout jPanelQLHDLayout = new javax.swing.GroupLayout(jPanelQLHD);
        jPanelQLHD.setLayout(jPanelQLHDLayout);
        jPanelQLHDLayout.setHorizontalGroup(
            jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelQLHDLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTongTienThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelQLHDLayout.createSequentialGroup()
                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelQLHDLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelQLHDLayout.createSequentialGroup()
                                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel4))
                                .addGap(56, 56, 56)
                                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaNV, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelQLHDLayout.createSequentialGroup()
                                        .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                        .addComponent(btnTaoHoaDon))
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanelQLHDLayout.createSequentialGroup()
                                        .addGap(177, 177, 177)
                                        .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(lblGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanelQLHDLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelQLHDLayout.createSequentialGroup()
                                        .addGap(92, 92, 92)
                                        .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelQLHDLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cboKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(143, 143, 143))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelQLHDLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelQLHDLayout.setVerticalGroup(
            jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelQLHDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaoHoaDon))
                .addGap(18, 18, 18)
                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblTongTien)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGiamGia))
                .addGap(18, 18, 18)
                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblTongTienThanhToan)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        jPanelHoaDonCho.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HÓA ĐƠN CHỜ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Ngày tạo", "Người bán", "Tên khách hàng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable2);

        javax.swing.GroupLayout jPanelHoaDonChoLayout = new javax.swing.GroupLayout(jPanelHoaDonCho);
        jPanelHoaDonCho.setLayout(jPanelHoaDonChoLayout);
        jPanelHoaDonChoLayout.setHorizontalGroup(
            jPanelHoaDonChoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHoaDonChoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanelHoaDonChoLayout.setVerticalGroup(
            jPanelHoaDonChoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHoaDonChoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addComponent(jPanelSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelĐonHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelHoaDonCho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelQLHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelĐonHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelHoaDonCho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanelQLHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemVaoDonHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemVaoDonHangMouseClicked
        try {
            addSanPham();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Vui lòng tạo hóa đơn");
        }
    }//GEN-LAST:event_btnThemVaoDonHangMouseClicked

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        search();
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void btnXoaKhoiDonHang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKhoiDonHang1ActionPerformed
        sua();
    }//GEN-LAST:event_btnXoaKhoiDonHang1ActionPerformed

    private void btnTaoHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaoHoaDonMouseClicked
        txtMaHD.setText(taoMa());
        taoHoaDon();
    }//GEN-LAST:event_btnTaoHoaDonMouseClicked

    private void btnXoaKhoiDonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKhoiDonHangActionPerformed
        xoa();
    }//GEN-LAST:event_btnXoaKhoiDonHangActionPerformed

    private void cboKhuyenMaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboKhuyenMaiItemStateChanged
        try {
            Double gia = 0d;
            for (int i = 0; i < tblDonHang.getRowCount(); i++) {
                gia += (double) tblDonHang.getValueAt(i, 3);
            }
            lblTongTien.setText(TextUtil.round(gia));
            KhuyenMai km = daoKM.selectByID((String) cboKhuyenMai.getSelectedItem());
            String thongTin = "";
            if (km != null) {
                if (km.isLoaiKM()) {
                    gia -= ((gia / 100) * km.getGiamGia());
                    thongTin = "-" + km.getGiamGia() + "%";
                } else {
                    gia -= km.getGiamGia();
                    thongTin = "-" + km.getGiamGia() + "vnđ";
                }

            }
            lblGiamGia.setText(thongTin);
            tongTien = gia;
            lblTongTienThanhToan.setText(TextUtil.round(gia));
        } catch (SQLException ex) {
            Logger.getLogger(PanelBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cboKhuyenMaiItemStateChanged

    private void txtTienMatKhachTraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienMatKhachTraKeyReleased
        if (!TextUtil.isNAN(txtTienMatKhachTra.getText())) {
            Integer tienKhach = Integer.valueOf(txtTienMatKhachTra.getText());
            lblTienThua.setText(TextUtil.round((tongTien - tienKhach)));
        }
    }//GEN-LAST:event_txtTienMatKhachTraKeyReleased

    private void btnThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThanhToanMouseClicked
        thanhToan();
    }//GEN-LAST:event_btnThanhToanMouseClicked

    private void btnThemVaoDonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemVaoDonHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemVaoDonHangActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemVaoDonHang;
    private javax.swing.JButton btnXoaKhoiDonHang;
    private javax.swing.JButton btnXoaKhoiDonHang1;
    private javax.swing.JComboBox<String> cboKhuyenMai;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelHoaDonCho;
    private javax.swing.JPanel jPanelQLHD;
    private javax.swing.JPanel jPanelSanPham;
    private javax.swing.JPanel jPanelĐonHang;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblGiamGia;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lblTongTienThanhToan;
    private javax.swing.JTable tblDonHang;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtTienMatKhachTra;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

    private void fillCombo() {
        try {
            List<KhuyenMai> list = daoKM.selectAll();
            cboKhuyenMai.removeAllItems();
            cboKhuyenMai.addItem("none");
            for (KhuyenMai km : list) {
                cboKhuyenMai.addItem(km.getMaKM());
            }
        } catch (Exception e) {
            Logger.getLogger(PanelBanHang.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    private void showTableThongTinSanPham() {
        modelSP.setRowCount(0);
        try {
            String[] cols = {"MaCTSP", "MaSP", "TenSP", "TenMau", "TenSize", "Gia", "SoLuong"};
            for (Object[] ctsp : daoCTSP.getAllSanPhamChiTiet(cols)) {
                modelSP.addRow(ctsp);
            }
        } catch (Exception e) {
        }
    }

    private void addSanPham() {
        try {
            int row = tblSanPham.getSelectedRow();
            if (row != -1) {
                String txt = JOptionPane.showInputDialog(this, "Nhập số lượng");
                if (!TextUtil.isNAN(txt)) {
                    try {
                        String id = tblSanPham.getValueAt(row, 0).toString();
                        int soLuong = Integer.valueOf(txt);
                        String txtSoLuongSP = tblSanPham.getValueAt(row, 6).toString();
                        int soLuongSP = Integer.valueOf(txtSoLuongSP);
                        if (soLuong > 0 && soLuong < soLuongSP + 1) {
                            themVaoDon(id, soLuong);
                        } else {
                            JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 1 và bé hơn " + (soLuongSP + 1));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Phải nhập số");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void search() {
        modelSP.setRowCount(0);
        String[] searchs = txtTimKiem.getText().split(",");
        try {
            String[] cols = {"MaCTSP", "MaSP", "TenSP", "TenMau", "TenSize", "Gia", "SoLuong", "TenThuongHieu", "TenChatLieu", "TenXuatXu", "TenLoai"};
            for (Object[] objs : daoCTSP.getAllSanPhamChiTiet(cols)) {
                List<Boolean> bools = new ArrayList<>();
                for (String search : searchs) {
                    boolean bool = false;
                    for (Object obj : objs) {
                        if (obj.toString().toLowerCase().contains(search.toLowerCase())) {
                            bool = true;
                        }
                    }
                    bools.add(bool);
                }
                if (!bools.contains(false)) {
                    modelSP.addRow(objs);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String taoMa() {
        Random random = new Random();
        String maHD = "";
        for (int i = 0; i < 15; i++) {
            if (random.nextBoolean()) {
                maHD += random.nextInt(10);
            } else {
                int x = random.nextInt(26) + 65;
                maHD += (char) x;
            }
        }
        try {
            if (daoHD.selectByID(maHD) != null) {
                return taoMa();
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maHD;
    }

    private HoaDon getHoaDon() {
        HoaDon hoaDon = new HoaDon();
        hoaDon.setMaHD(txtMaHD.getText());
        hoaDon.setTaiKhoan(txtMaNV.getText());
//        hoaDon.getMaKH()
//        hoaDon.setMaKM();
//        hoaDon.setTrangThai(false);
        return hoaDon;
    }

    private void taoHoaDon() {
        try {
            if (daoHD.insert(getHoaDon()) > 0) {
                JOptionPane.showMessageDialog(this, "Tạo thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Tạo thất bại");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ChiTietHoaDon getChiTietHoaDon(String id, int soLuong) {
        ChiTietHoaDon cthd = new ChiTietHoaDon();
        cthd.setMaCTSP(id);
        cthd.setMaHD(txtMaHD.getText());
        cthd.setSoLuong(soLuong);
        return cthd;
    }

    private void themVaoDon(String id, int soLuong) {
        try {
            if (daoCTHD.insert(getChiTietHoaDon(id, soLuong)) > 0) {
                updateSoLuongSanPham(id, soLuong, "-");
                showTableThongTinSanPham();
                showTableDonHang();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showTableDonHang() {
        modelDH.setRowCount(0);
        for (Object[] cthd : daoCTHD.getAllHoaDon(txtMaHD.getText())) {
            modelDH.addRow(cthd);
        }
    }

    private void updateSoLuongSanPham(String id, int soLuong, String toanTu) {
        try {
            if (daoCTSP.update(getChiTietSanPham(id, soLuong, toanTu)) <= 0) {
                JOptionPane.showMessageDialog(this, "Update số lượng sản phẩm thất bại");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ChiTietSanPham getChiTietSanPham(String id, int soLuong, String toanTu) {
        try {
            ChiTietSanPham ctsp = daoCTSP.selectByID(id);
            if (toanTu.equals("-")) {
                ctsp.setSoLuong(ctsp.getSoLuong() - soLuong);
            } else {
                ctsp.setSoLuong(ctsp.getSoLuong() + soLuong);
            }
            return ctsp;
        } catch (SQLException ex) {
            Logger.getLogger(PanelBanHang.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private void xoa() {
        try {
            int row = tblDonHang.getSelectedRow();
            String maCTSP = tblDonHang.getValueAt(row, 0).toString();
            Integer soLuong = (Integer) tblDonHang.getValueAt(row, 2);

            if (daoCTHD.delete(maCTSP) > 0) {
                updateSoLuongSanPham(maCTSP, soLuong, "+");
                showTableThongTinSanPham();
                showTableDonHang();
                JOptionPane.showMessageDialog(this, "Xóa thành công");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sua() {
        try {
            int row = tblDonHang.getSelectedRow();
            if (row != -1) {
                String txt = JOptionPane.showInputDialog(this, "Nhập số lượng");
                if (!TextUtil.isNAN(txt)) {
                    try {
                        String id = tblDonHang.getValueAt(row, 0).toString();
                        int soLuong = Integer.valueOf(txt);
                        String txtSoLuongDHCu = tblDonHang.getValueAt(row, 2).toString();
                        int soLuongDH = Integer.valueOf(txtSoLuongDHCu);
                        if (soLuong > 0) {
                            if (soLuong > soLuongDH) {
                                updateSoLuongSanPham(id, soLuong - soLuongDH, "+");
                                SuaTrongDon(id, soLuong);
                            } else {
                                updateSoLuongSanPham(id, soLuong - soLuongDH, "-");
                                SuaTrongDon(id, soLuong);
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 1");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Phải nhập số");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void SuaTrongDon(String id, int soLuong) {
        try {
            if (daoCTHD.update(getChiTietHoaDon(id, soLuong)) > 0) {
                showTableThongTinSanPham();
                showTableDonHang();
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void thanhToan() {
        try {
            HoaDon hoaDon = new HoaDon();
            hoaDon.setMaHD(txtMaHD.getText());
            hoaDon.setTaiKhoan(txtMaNV.getText());
//        hoaDon.getMaKH()
            KhuyenMai km = daoKM.selectByID((String) cboKhuyenMai.getSelectedItem());
            if(km!=null){
                hoaDon.setMaKM(km.getMaKM());
            }
//        hoaDon.setTrangThai(false);
            hoaDon.setTrangThai(true);
            if(daoHD.update(hoaDon)>0){
                JOptionPane.showMessageDialog(this,"Thanh toán thành công");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
