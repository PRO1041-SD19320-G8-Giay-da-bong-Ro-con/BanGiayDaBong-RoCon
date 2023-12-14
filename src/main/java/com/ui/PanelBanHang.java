/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.ui;

import com.dao.ChatLieuDAO;
import com.dao.ChiTietHoaDonDAO;
import com.dao.ChiTietSanPhamDAO;
import com.dao.HoaDonDAO;
import com.dao.KhachHangDAO;
import com.dao.KhuyenMaiDAO;
import com.dao.LoaiGiayDAO;
import com.dao.MauSacDAO;
import com.dao.SanPhamDAO;
import com.dao.SizeDAO;
import com.dao.TaiKhoanDAO;
import com.dao.ThuongHieuDAO;
import com.dao.XuatXuDAO;
import com.entity.ChiTietHoaDon;
import com.entity.ChiTietSanPham;
import com.entity.HoaDon;
import com.entity.KhachHang;
import com.entity.KhuyenMai;
import com.entity.TaiKhoan;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceGray;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.DashedBorder;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.utils.Auth;
import com.utils.FormatDate;
import com.utils.TextUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    KhachHangDAO daoKH = new KhachHangDAO();
    TaiKhoanDAO daoTK = new TaiKhoanDAO();
    DefaultTableModel modelSP = null;
    DefaultTableModel modelDH = null;
    DefaultTableModel modelHDC = null;
    Double tongTien = null;

    /**
     * Creates new form HoaDon_JDiaLog
     */
    public PanelBanHang() {
        initComponents();
        modelSP = (DefaultTableModel) tblSanPham.getModel();
        modelDH = (DefaultTableModel) tblDonHang.getModel();
        modelHDC = (DefaultTableModel) tblHoaDonCho.getModel();
        fillCombo();
        showTableThongTinSanPham();
        txtMaNV.setText(Auth.user.getTaikhoan());
        showHoaDonCho();

        modelDH.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                try {
                    Double gia = 0d;
                    gia = daoCTHD.getTongTien(txtMaHD.getText());
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
        btnChonKhachHang = new javax.swing.JButton();
        lblGiamGia = new javax.swing.JLabel();
        lblKhachHang = new javax.swing.JLabel();
        jPanelHoaDonCho = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblHoaDonCho = new javax.swing.JTable();
        btnXoaKhoiDonHang2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("BÁN HÀNG");

        jPanelSanPham.setBackground(new java.awt.Color(255, 255, 255));
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

        btnThemVaoDonHang.setBackground(new java.awt.Color(255, 204, 0));
        btnThemVaoDonHang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThemVaoDonHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add11.png"))); // NOI18N
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
                    .addComponent(txtTimKiem)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSanPhamLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnThemVaoDonHang)))
                .addContainerGap())
        );
        jPanelSanPhamLayout.setVerticalGroup(
            jPanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThemVaoDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelĐonHang.setBackground(new java.awt.Color(204, 204, 204));
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

        btnXoaKhoiDonHang.setBackground(new java.awt.Color(255, 204, 0));
        btnXoaKhoiDonHang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoaKhoiDonHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/xoa123.png"))); // NOI18N
        btnXoaKhoiDonHang.setText("Xóa khỏi đơn hàng");
        btnXoaKhoiDonHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKhoiDonHangActionPerformed(evt);
            }
        });

        btnXoaKhoiDonHang1.setBackground(new java.awt.Color(255, 204, 0));
        btnXoaKhoiDonHang1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoaKhoiDonHang1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/fix.png"))); // NOI18N
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoaKhoiDonHang1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoaKhoiDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
        );
        jPanelĐonHangLayout.setVerticalGroup(
            jPanelĐonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelĐonHangLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelĐonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnXoaKhoiDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaKhoiDonHang1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanelĐonHangLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnXoaKhoiDonHang, btnXoaKhoiDonHang1});

        jPanelQLHD.setBackground(new java.awt.Color(204, 204, 204));
        jPanelQLHD.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ĐƠN HÀNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel2.setText("Khách hàng");

        jLabel4.setText("Tổng tiền: ");

        lblTongTien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongTien.setText("0.0");

        jLabel6.setText("Khuyến mãi");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Tổng tiền cần thanh toán: ");

        lblTongTienThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTongTienThanhToan.setText("0.0");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THANH TOÁN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel8.setText("Tổng tiền khách trả");

        txtTienMatKhachTra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTienMatKhachTra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienMatKhachTraKeyReleased(evt);
            }
        });

        jLabel10.setText("Tiền thừa");

        lblTienThua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTienThua.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTienThua.setText("0.0");

        jLabel18.setText("VND");

        jLabel20.setText("VND");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTienMatKhachTra, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel18))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTienMatKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(17, 17, 17))
        );

        btnThanhToan.setBackground(new java.awt.Color(255, 204, 0));
        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThanhToanMouseClicked(evt);
            }
        });

        jLabel11.setText("VND");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
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
        btnTaoHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add2.png"))); // NOI18N
        btnTaoHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTaoHoaDonMouseClicked(evt);
            }
        });
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        btnChonKhachHang.setBackground(new java.awt.Color(255, 204, 0));
        btnChonKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/click.png"))); // NOI18N
        btnChonKhachHang.setText("Chọn");
        btnChonKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonKhachHangActionPerformed(evt);
            }
        });

        lblGiamGia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblGiamGia.setText("Giảm giá");

        javax.swing.GroupLayout jPanelQLHDLayout = new javax.swing.GroupLayout(jPanelQLHD);
        jPanelQLHD.setLayout(jPanelQLHDLayout);
        jPanelQLHDLayout.setHorizontalGroup(
            jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelQLHDLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelQLHDLayout.createSequentialGroup()
                        .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel4))
                        .addGap(56, 56, 56)
                        .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelQLHDLayout.createSequentialGroup()
                                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboKhuyenMai, 0, 165, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(lblGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelQLHDLayout.createSequentialGroup()
                                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtMaNV, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaHD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                    .addComponent(lblKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelQLHDLayout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(btnChonKhachHang)
                                        .addGap(23, 23, 23))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelQLHDLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36))))))
                    .addGroup(jPanelQLHDLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap())
                    .addGroup(jPanelQLHDLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(lblTongTienThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanelQLHDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelQLHDLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanelQLHDLayout.setVerticalGroup(
            jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelQLHDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnChonKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGiamGia))
                .addGap(18, 18, 18)
                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblTongTienThanhToan)
                    .addComponent(jLabel16))
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149))
        );

        jPanelQLHDLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblKhachHang, txtMaHD, txtMaNV});

        jPanelHoaDonCho.setBackground(new java.awt.Color(204, 255, 255));
        jPanelHoaDonCho.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HÓA ĐƠN CHỜ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tblHoaDonCho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Ngày tạo", "Tổng tiền", "Tên khách hàng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDonCho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonChoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblHoaDonCho);

        btnXoaKhoiDonHang2.setBackground(new java.awt.Color(255, 204, 0));
        btnXoaKhoiDonHang2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoaKhoiDonHang2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/click.png"))); // NOI18N
        btnXoaKhoiDonHang2.setText("Chọn ");
        btnXoaKhoiDonHang2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKhoiDonHang2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelHoaDonChoLayout = new javax.swing.GroupLayout(jPanelHoaDonCho);
        jPanelHoaDonCho.setLayout(jPanelHoaDonChoLayout);
        jPanelHoaDonChoLayout.setHorizontalGroup(
            jPanelHoaDonChoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHoaDonChoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHoaDonChoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHoaDonChoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnXoaKhoiDonHang2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelHoaDonChoLayout.setVerticalGroup(
            jPanelHoaDonChoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHoaDonChoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addGap(4, 4, 4)
                .addComponent(btnXoaKhoiDonHang2))
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
                .addComponent(jPanelQLHD, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelĐonHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelHoaDonCho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelQLHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemVaoDonHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemVaoDonHangMouseClicked
        try {
            addSanPham();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng tạo hóa đơn");
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
        showTableDonHang();
        showHoaDonCho();
    }//GEN-LAST:event_btnTaoHoaDonMouseClicked

    private void btnXoaKhoiDonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKhoiDonHangActionPerformed
        xoa();
    }//GEN-LAST:event_btnXoaKhoiDonHangActionPerformed

    private void cboKhuyenMaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboKhuyenMaiItemStateChanged
        try {
            Double gia = 0d;
            gia = daoCTHD.getTongTien(txtMaHD.getText());
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
            lblTienThua.setText(TextUtil.round((tienKhach - tongTien)));
        }
    }//GEN-LAST:event_txtTienMatKhachTraKeyReleased

    private void xuatHoaDon() {

        try {

            PdfWriter pdfWriter = new PdfWriter(PanelBanHang.class.getResource("/hoaDon/").getPath() + txtMaHD.getText() + ".pdf");
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            pdfDocument.setDefaultPageSize(PageSize.A4);
            Document dcm = new Document(pdfDocument);

            try {
                PdfFont font = PdfFontFactory.createFont("src\\main\\java\\font\\arial.ttf", PdfEncodings.IDENTITY_H);
                dcm.setFont(font);
            } catch (Exception ex) {
                Logger.getLogger(PanelBanHang.class.getName()).log(Level.SEVERE, null, ex);
            }

            String path = "src\\main\\java\\img\\logo.png";
            try {
                ImageData imgData = ImageDataFactory.create(path);
                Image img = new Image(imgData);
                float x = pdfDocument.getDefaultPageSize().getWidth() / 2;
                float y = pdfDocument.getDefaultPageSize().getHeight() / 2;
                img.setFixedPosition(x - 220, y - 110);
                img.setOpacity(0.2f);
                dcm.add(img);
            } catch (MalformedURLException ex) {
                Logger.getLogger(PanelBanHang.class.getName()).log(Level.SEVERE, null, ex);
            }

            float twoCol = 285f;
            float threeCol = 190f;
            float twoCol150 = twoCol + 150f;
            float twoColWidth[] = {twoCol150, twoCol};
            float threeColWidth[] = {threeCol, threeCol, threeCol};
            float fullWidth[] = {threeCol * 3};
            Paragraph onesp = new Paragraph("\n");

            Table table = new Table(twoColWidth);

            Table table1 = new Table(new float[]{twoCol / 2, twoCol / 2});
            table.addCell(new Cell().add(new Paragraph("Invoice")).setFontSize(25f).setBorder(Border.NO_BORDER).setBold());
            table1.addCell(getHeaderTextCell("Mã HD: "));
            table1.addCell(getHeaderTextCellValue(txtMaHD.getText()));
            table1.addCell(getHeaderTextCell("Ngày tạo: "));
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            table1.addCell(getHeaderTextCellValue(sdf.format(new Date())));
            Border bd = new SolidBorder(new DeviceGray(0.7f), 2f);

            Table tb = new Table(fullWidth);
            tb.setBorder(bd);
            table.addCell(new Cell().add(table1).setBorder(Border.NO_BORDER));

            Table twoColTable = new Table(twoColWidth);
            twoColTable.addCell(getBillingAndShippingCell("Thông tin hóa đơn"));
            twoColTable.addCell(getBillingAndShippingCell("Thông tin khách hàng"));
            dcm.add(table);
            dcm.add(onesp);
            dcm.add(tb);
            dcm.add(onesp);
            dcm.add(twoColTable.setMarginBottom(12f));

            Table twoColTable1 = new Table(twoColWidth);
            twoColTable1.addCell(getCell10Left("Cửa hàng", true));
            twoColTable1.addCell(getCell10Left("Họ tên KH", true));
            twoColTable1.addCell(getCell10Left("Bán giày đá bóng RoCon", false));

            try {
                KhachHang kh = daoKH.selectByID(lblKhachHang.getText());
                if (kh == null) {
                    twoColTable1.addCell(getCell10Left("...................................................", false));
                } else {
                    twoColTable1.addCell(getCell10Left(kh.getTenKH(), false));
                }

            } catch (SQLException ex) {
                Logger.getLogger(PanelBanHang.class.getName()).log(Level.SEVERE, null, ex);
            }
            dcm.add(twoColTable1);

            Table twoColTable2 = new Table(twoColWidth);
            twoColTable2.addCell(getCell10Left("Nhân viên", true));
            twoColTable2.addCell(getCell10Left("Địa chỉ", true));
            try {
                TaiKhoan tk = daoTK.selectByID(txtMaNV.getText().trim());
                twoColTable2.addCell(getCell10Left(tk.getTen(), false));
            } catch (SQLException ex) {
                Logger.getLogger(PanelBanHang.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                KhachHang kh = daoKH.selectByID(lblKhachHang.getText());
                if (kh == null) {
                    twoColTable2.addCell(getCell10Left("...................................................", false));
                } else {
                    twoColTable2.addCell(getCell10Left(kh.getDiaChi(), false));
                }
            } catch (SQLException ex) {
                Logger.getLogger(PanelBanHang.class.getName()).log(Level.SEVERE, null, ex);
            }
            dcm.add(twoColTable2);
            float oneColumnWidth[] = {twoCol150};

            Table oneColumnTable = new Table(oneColumnWidth);
            oneColumnTable.addCell(getCell10Left("Số DT", true));
            try {
                TaiKhoan tk = daoTK.selectByID(txtMaNV.getText().trim());
                oneColumnTable.addCell(getCell10Left(tk.getSdt(), false));
            } catch (SQLException ex) {
                Logger.getLogger(PanelBanHang.class.getName()).log(Level.SEVERE, null, ex);
            }
            oneColumnTable.addCell(getCell10Left("Email", true));
            try {
                TaiKhoan tk = daoTK.selectByID(txtMaNV.getText().trim());
                oneColumnTable.addCell(getCell10Left(tk.getEmail(), false));
            } catch (SQLException ex) {
                Logger.getLogger(PanelBanHang.class.getName()).log(Level.SEVERE, null, ex);
            }
            dcm.add(oneColumnTable.setMarginTop(10f));
            dcm.add(onesp);

            Table gachCham = new Table(fullWidth);
            Border bd1 = new DashedBorder(new DeviceGray(0.7f), 0.5f);
            dcm.add(gachCham.setBorder(bd1));
            dcm.add(onesp);
            dcm.add(new Paragraph("Sản phẩm").setBold().setFontSize(15f));
            dcm.add(onesp);
            Table threeColTable = new Table(threeColWidth);
            threeColTable.setBackgroundColor(new DeviceRgb(0, 0, 0), 0.7f);
            threeColTable.addCell(new Cell().add(new Paragraph("Tên SP")).setBold().setFontColor(new DeviceRgb(1.0f, 1.0f, 1.0f)).setBorder(Border.NO_BORDER));
            threeColTable.addCell(new Cell().add(new Paragraph("Số lượng")).setBold().setFontColor(new DeviceRgb(1.0f, 1.0f, 1.0f)).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER));
            threeColTable.addCell(new Cell().add(new Paragraph("Giá (VND)")).setBold().setFontColor(new DeviceRgb(1.0f, 1.0f, 1.0f)).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT).setMarginRight(15f));
            dcm.add(threeColTable);
            dcm.add(onesp);

            Table threeColTable1 = new Table(threeColWidth);
            int row = tblDonHang.getRowCount();
            for (int i = 0; i < row; i++) {
                System.out.println("add đon hàng thành công");
                String tenSP = String.valueOf(tblDonHang.getValueAt(i, 1));
                String soLuongSP = String.valueOf(tblDonHang.getValueAt(i, 2));
                String gia = String.valueOf(tblDonHang.getValueAt(i, 3));
                threeColTable1.addCell(new Cell().add(new Paragraph(tenSP)).setMarginLeft(10f).setBorder(Border.NO_BORDER));
                threeColTable1.addCell(new Cell().add(new Paragraph(soLuongSP)).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                threeColTable1.addCell(new Cell().add(new Paragraph(gia)).setMarginRight(15f).setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER));
            }
            dcm.add(threeColTable1.setMarginBottom(20f));
            float onetwo[] = {threeCol + 125f, threeCol * 2};

            Table gachCham1 = new Table(onetwo);
            gachCham1.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
            gachCham1.addCell(new Cell().add(gachCham).setBorder(Border.NO_BORDER));
            dcm.add(gachCham1);
            dcm.add(onesp);

            Table tongTienGoc = new Table(threeColWidth);
            tongTienGoc.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
            tongTienGoc.addCell(new Cell().add(new Paragraph("Tổng tiền gốc")).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER));
            tongTienGoc.addCell(new Cell().add(new Paragraph(lblTongTien.getText())).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
            dcm.add(tongTienGoc);

            Double hehe = Double.parseDouble(lblTongTien.getText().replaceAll("\\.", ""));
            Double hehe1 = Double.parseDouble(lblTongTienThanhToan.getText().replaceAll("\\.", ""));

            Table giamGiaTable = new Table(threeColWidth);
            giamGiaTable.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
            giamGiaTable.addCell(new Cell().add(new Paragraph("Giảm giá")).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER));
            giamGiaTable.addCell(new Cell().add(new Paragraph(TextUtil.round(hehe - hehe1))).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
            dcm.add(giamGiaTable);

            Table tongTienThanhToan = new Table(threeColWidth);
            tongTienThanhToan.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
            tongTienThanhToan.addCell(new Cell().add(new Paragraph("Tổng tiền thanh toán")).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER));
            tongTienThanhToan.addCell(new Cell().add(new Paragraph(lblTongTienThanhToan.getText())).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
            dcm.add(tongTienThanhToan);
            dcm.add(onesp);

            Table gachCham2 = new Table(onetwo);
            gachCham2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
            gachCham2.addCell(new Cell().add(gachCham).setBorder(Border.NO_BORDER));
            dcm.add(gachCham2);
            dcm.add(onesp);

            if (!txtTienMatKhachTra.getText().trim().isEmpty()) {
                Table tongTienKHTraTable = new Table(threeColWidth);
                tongTienKHTraTable.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
                tongTienKHTraTable.addCell(new Cell().add(new Paragraph("Tổng tiền khách trả")).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER));
                try {
                    tongTienKHTraTable.addCell(new Cell().add(new Paragraph(TextUtil.round(Double.parseDouble(txtTienMatKhachTra.getText())))).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
                } catch (Exception e) {
                    tongTienKHTraTable.addCell(new Cell().add(new Paragraph("NaN")).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
                }
                dcm.add(tongTienKHTraTable);
            }

            Table tienThuaTable = new Table(threeColWidth);
            tienThuaTable.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
            tienThuaTable.addCell(new Cell().add(new Paragraph("Tiền thừa")).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER));
            tienThuaTable.addCell(new Cell().add(new Paragraph(lblTienThua.getText())).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
            dcm.add(tienThuaTable);
            dcm.add(onesp);

            Table gachCham3 = new Table(fullWidth);
            dcm.add(gachCham3.setBorder(bd1));
            dcm.add(onesp);
            Border bd2 = new SolidBorder(new DeviceRgb(0, 0, 0), 2f);
            Table tb1 = new Table(fullWidth);
            tb1.setBorder(bd2);
            dcm.add(tb1);

            dcm.close();
            JOptionPane.showMessageDialog(this, "Xuất hóa đơn thành công");
        } catch (FileNotFoundException ex) {
            return;
        }
    }

    private static Cell getHeaderTextCell(String textValue) {
        return new Cell().add(new Paragraph(textValue)).setBold().setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT);
    }

    private static Cell getHeaderTextCellValue(String textValue) {
        return new Cell().add(new Paragraph(textValue)).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);
    }

    private static Cell getBillingAndShippingCell(String textValue) {
        return new Cell().add(new Paragraph(textValue)).setFontSize(12f).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT).setBold();
    }

    private static Cell getCell10Left(String textValue, Boolean isBold) {
        Cell myCell = new Cell().add(new Paragraph(textValue)).setFontSize(10f).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);
        return isBold ? myCell.setBold() : myCell;
    }

    private void btnThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThanhToanMouseClicked
//
//        if (txtTienMatKhachTra.getText().trim().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Chưa nhập số tiền khách trả");
//            return;
//        }
//        float tienKhachTra = Float.parseFloat(txtTienMatKhachTra.getText());
//        
//        if (tienKhachTra < tongTien) {
//            JOptionPane.showMessageDialog(this, "Nhập số tiền khách trả không đủ ");
//            return;
//        }
//
//        try {
//            Float tttoan = Float.parseFloat(txtTienMatKhachTra.getText().trim());
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Vui lòng nhập tiền thanh toán là 1 số dương");
//            return;
//        }
        int hoi1 = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thanh toán?");
        if (hoi1 != JOptionPane.YES_OPTION) {
            return;
        }

        if (checkTableDonHang()) {
            thanhToan();
            int hoi = JOptionPane.showConfirmDialog(this, "Bạn có muốn xuất hóa đơn không?");
            if (hoi == JOptionPane.YES_OPTION) {
//                if (lblKhachHang.getText() == null || lblKhachHang.getText().isEmpty()) {
//                    JOptionPane.showMessageDialog(this, "Bạn cần bổ sung thông tin khách hàng trước khi xuất hóa đơn");
//                    return;
//                }
                xuatHoaDon();
            }
            btnTaoHoaDonMouseClicked(null);
        } else {
            JOptionPane.showMessageDialog(this, "Không có sản phẩm trong đơn hàng");
        }
    }//GEN-LAST:event_btnThanhToanMouseClicked

    private void btnThemVaoDonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemVaoDonHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemVaoDonHangActionPerformed

    private void btnChonKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonKhachHangActionPerformed
        DialogKhachHang dkh = new DialogKhachHang(null, true);
        dkh.setVisible(true);
        lblKhachHang.setText(dkh.maKH);
    }//GEN-LAST:event_btnChonKhachHangActionPerformed

    private void tblHoaDonChoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonChoMouseClicked

    }//GEN-LAST:event_tblHoaDonChoMouseClicked

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void btnXoaKhoiDonHang2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKhoiDonHang2ActionPerformed
        int row = tblHoaDonCho.getSelectedRow();
        if (row != -1) {
            txtMaHD.setText(tblHoaDonCho.getValueAt(row, 0).toString());
            showTableDonHang();
            showHoaDonCho();
        }
    }//GEN-LAST:event_btnXoaKhoiDonHang2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonKhachHang;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemVaoDonHang;
    private javax.swing.JButton btnXoaKhoiDonHang;
    private javax.swing.JButton btnXoaKhoiDonHang1;
    private javax.swing.JButton btnXoaKhoiDonHang2;
    private javax.swing.JComboBox<String> cboKhuyenMai;
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
    private javax.swing.JLabel lblGiamGia;
    private javax.swing.JLabel lblKhachHang;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lblTongTienThanhToan;
    private javax.swing.JTable tblDonHang;
    private javax.swing.JTable tblHoaDonCho;
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
                if (km.getThoiGianBatDau().before(new Date()) && km.getThoiGianKetThuc().after(new Date())) {
                    cboKhuyenMai.addItem(km.getMaKM());
                }
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
                if (txt != null) {
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
                        JOptionPane.showMessageDialog(this, "Phải nhập số nguyên");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Hãy chọn sản phẩm để thêm vào đơn hàng");
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
                JOptionPane.showMessageDialog(this, "Tạo mã hóa đơn thành công");
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
            JOptionPane.showMessageDialog(this, "Vui lòng tạo hóa đơn");
        }
    }

    private void showTableDonHang() {
        modelDH.setRowCount(0);
        for (Object[] cthd : daoCTHD.getAllHoaDon(txtMaHD.getText())) {
            cthd[3] = TextUtil.round(cthd[3]);
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
                if (txt == null) {
                    return;
                }
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
            KhachHang kh = daoKH.selectByID(lblKhachHang.getText());
            if (kh != null) {
                hoaDon.setMaKH(kh.getMaKH());
            }
            KhuyenMai km = daoKM.selectByID((String) cboKhuyenMai.getSelectedItem());
            if (km != null) {
                hoaDon.setMaKM(km.getMaKM());
            }
            hoaDon.setTrangThai(true);
            if (daoHD.update(hoaDon) > 0) {
                JOptionPane.showMessageDialog(this, "Thanh toán thành công");
                //btnTaoHoaDonMouseClicked(null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean checkTableDonHang() {
        return tblDonHang.getRowCount() > 0;
    }

    private void showHoaDonCho() {
        try {
            modelHDC.setRowCount(0);
            for (HoaDon hd : daoHD.selectHoaDonCho()) {
                String tenKH = "";
                if (hd.getMaKH() != null) {
                    tenKH = daoKH.selectByID(hd.getMaKH()).getTenKH();
                }
                modelHDC.addRow(new Object[]{hd.getMaHD(), FormatDate.toString(hd.getThoiGianBan()), TextUtil.round(hd.getTongTienCuoi()), tenKH});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
