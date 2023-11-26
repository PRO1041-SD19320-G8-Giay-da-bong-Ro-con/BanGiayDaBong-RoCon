/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ChiTietSanPham;
import model.DonHang;
import model.SanPham;
import services.BanHang_Ser;

/**
 *
 * @author Admin
 */
public class BanHang_DiaLog extends javax.swing.JDialog {

    BanHang_Ser ql = new BanHang_Ser();
    DefaultTableModel tblModelSP = new DefaultTableModel();
    DefaultTableModel tblModelDH = new DefaultTableModel();
    List<ChiTietSanPham> lstSP = new ArrayList<>();
    List<ChiTietSanPham> lstDonHang = new ArrayList<>();
    int index = -1;
    DecimalFormat dfm = new DecimalFormat("#,###");

    /**
     * Creates new form HoaDon_JDiaLog
     */
    public BanHang_DiaLog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
        
    }

    private void init() {
        if(lstDonHang.size()!=0){
            this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
            JOptionPane.showMessageDialog(this, "Bạn cần xử lý đơn hàng trước khi đóng chương trình");
            return;
        }
        setLocationRelativeTo(null);
        lstSP = ql.getAllSanPham();
        loadTableSP(lstSP);
        

    }

    private void loadTableSP(List<ChiTietSanPham> lst) {
        tblModelSP.setRowCount(0);
        tblModelSP = (DefaultTableModel) tblSanPham.getModel();

        for (ChiTietSanPham sp : lst) {

            tblModelSP.addRow(new Object[]{
                sp.getMaSP(),
                sp.getTenSP(),
                sp.getMaSize(),
                sp.getMaMau(),
                sp.getMaChatLieu(),
                sp.getMaThuongHieu(),
                sp.getGia(),
                sp.getSoLuong()
            });
        }

    }

    private int soLuong;
    private int hangTrongKho;

    private void loadTableDonHang() {

        index = tblSanPham.getSelectedRow();
        Double gia;
        hangTrongKho = Integer.parseInt(tblSanPham.getValueAt(index, 7).toString());
        ChiTietSanPham ctsp1 = lstSP.get(index);

        for (ChiTietSanPham dh1 : lstDonHang) {
            if (dh1.getMaCTSP().equals(ctsp1.getMaCTSP())) {
                int soLuongCu = dh1.getSoLuong();
                int conf = JOptionPane.showConfirmDialog(this, "Sản phẩm đã có trong đơn hàng\nBạn muốn thay đổi số lượng sản phẩm không?");
                if (conf == JOptionPane.YES_OPTION) {
                    try {

                        int thayDoiSoLuong = Integer.parseInt(JOptionPane.showInputDialog(this, "Nhập số lượng sản phẩm:"));
                        if (thayDoiSoLuong < 0) {
                            JOptionPane.showMessageDialog(this, "Số lượng sản phẩm phải lớn hơn 0");
                            return;
                        }
                        if (thayDoiSoLuong > hangTrongKho) {
                            JOptionPane.showMessageDialog(this, "Số lượng hàng trong kho không đủ");
                            return;
                        }
                        lstDonHang.remove(ctsp1);
                        ctsp1.setSoLuong(thayDoiSoLuong);
                        tblModelDH.setRowCount(0);
                        tblModelDH = (DefaultTableModel) tblDonHang.getModel();
//            DonHang dh = new DonHang(maCTSP, tenSp, soLuong, gia, thanhTien);
                        lstDonHang.add(ctsp1);
                        for (ChiTietSanPham dh : lstDonHang) {
                            tblModelDH.addRow(new Object[]{
                                dh.getTenSP(),
                                dh.getSoLuong(),
                                dh.getGia(),
                                dh.getGia() * dh.getSoLuong()
                            });
                        }
                        if (ql.updateSoLuongSP(ctsp1, hangTrongKho + soLuongCu - thayDoiSoLuong) != 0) {
                            JOptionPane.showMessageDialog(this, "Đã cập nhật vào đơn hàng");
                        }
                        lstSP = ql.getAllSanPham();
                        loadTableSP(lstSP);
                        return;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng số lượng");
                        return;
                    }
                } else {
                    return;
                }
            }
        }
        try {

            soLuong = Integer.parseInt(JOptionPane.showInputDialog(this, "Nhập số lượng sản phẩm:"));

            gia = Double.parseDouble(tblSanPham.getValueAt(index, 6).toString());
            String tenSp = String.valueOf(tblSanPham.getValueAt(index, 1));
            String maCTSP = ctsp1.getMaCTSP();
            Double thanhTien = gia * soLuong;

            if (soLuong > hangTrongKho) {
                JOptionPane.showMessageDialog(this, "Số lượng hàng trong kho không đủ");
                return;
            }

            if (soLuong < 0) {
                JOptionPane.showMessageDialog(this, "Số lượng sản phẩm phải lớn hơn 0");
                return;
            }

            ctsp1.setSoLuong(soLuong);
            tblModelDH.setRowCount(0);
            tblModelDH = (DefaultTableModel) tblDonHang.getModel();
//            DonHang dh = new DonHang(maCTSP, tenSp, soLuong, gia, thanhTien);
            lstDonHang.add(ctsp1);
            for (ChiTietSanPham dh1 : lstDonHang) {
                tblModelDH.addRow(new Object[]{
                    dh1.getTenSP(),
                    dh1.getSoLuong(),
                    dh1.getGia(),
                    dh1.getGia() * dh1.getSoLuong()
                });
            }

            if (ql.updateSoLuongSP(ctsp1, hangTrongKho - soLuong) != 0) {
                JOptionPane.showMessageDialog(this, "Đã thêm vào đơn hàng");
            }
            lstSP = ql.getAllSanPham();
            loadTableSP(lstSP);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng số lượng");
            return;
        }
    }

    private void xoaKhoiDonHang() {
        int row = tblDonHang.getSelectedRow();
        hangTrongKho = Integer.parseInt(tblSanPham.getValueAt(index, 7).toString());
        if (lstDonHang.size() == 0) {
            JOptionPane.showMessageDialog(this, "Đơn hàng trống");
            return;
        }
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm trong đơn hàng để xóa.");
            return;
        }

        int hoi = JOptionPane.showConfirmDialog(this, "Xác nhận xóa sản phẩm này khỏi đơn hàng");
        if (hoi == JOptionPane.YES_OPTION) {

            ChiTietSanPham dh = lstDonHang.get(row);
            String maCTSP = dh.getMaCTSP();
            int sl = Integer.parseInt(tblDonHang.getValueAt(row, 1).toString());

            // Cập nhật số lượng trong kho
            for (ChiTietSanPham ctsp : lstSP) {
                if (ctsp.getMaCTSP().equals(dh.getMaCTSP())) {
                    if (ql.updateSoLuongSP(dh, hangTrongKho + sl) != 0) {
                        JOptionPane.showMessageDialog(this, "Đã xóa sản phẩm khỏi đơn hàng");

                        // Cập nhật lại danh sách sản phẩm và bảng sản phẩm
                    }
                }
            }
            // Xóa sản phẩm khỏi danh sách đơn hàng
            lstSP = ql.getAllSanPham();
            loadTableSP(lstSP);
            lstDonHang.remove(row);
            tblModelDH.setRowCount(0);
            tblModelDH = (DefaultTableModel) tblDonHang.getModel();
            // Cập nhật bảng đơn hàng
            for (ChiTietSanPham dh1 : lstDonHang) {
                tblModelDH.addRow(new Object[]{
                    dh1.getTenSP(),
                    dh1.getSoLuong(),
                    dh1.getGia(),
                    dh1.getGia() * dh1.getSoLuong()
                });
            }

        }
    }

    private void clearForm() {
        txtTenKH.setText("");
        txtSDT.setText("");
        lblTongTien.setText("0.0");
        lblGiamGia.setText("0.0");
        lblTongTienThanhToan.setText("0.0");
        txtTienKhachChuyenKhoan.setText("");
        txtTienMatKhachTra.setText("");
        lblTongTienDaThanhToan.setText("0.0");
        lblTienThua.setText("0.0");
    }

    private void taoHoaDon() {

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
        jPanelSanPham = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btnThemVaoDonHang = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        jPanelĐonHang = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDonHang = new javax.swing.JTable();
        btnTaoHoaDon = new javax.swing.JButton();
        btnXoaKhoiDonHang = new javax.swing.JButton();
        jPanelQLHD = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblGiamGia = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblTongTienThanhToan = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtTienKhachChuyenKhoan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTienMatKhachTra = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblTienThua = new javax.swing.JLabel();
        lblTongTienDaThanhToan = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btnXuatHoaDon = new javax.swing.JButton();
        jPanelHoaDonCho = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BÁN HÀNG");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("BÁN HÀNG");

        jPanelSanPham.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN SẢN PHẨM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MA SP", "TEN SP", "Size", "Màu", "Chất liệu", "Thương hiệu", "Giá", "SL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblSanPham);
        if (tblSanPham.getColumnModel().getColumnCount() > 0) {
            tblSanPham.getColumnModel().getColumn(0).setMinWidth(50);
            tblSanPham.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblSanPham.getColumnModel().getColumn(0).setMaxWidth(50);
            tblSanPham.getColumnModel().getColumn(2).setMinWidth(50);
            tblSanPham.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblSanPham.getColumnModel().getColumn(2).setMaxWidth(50);
            tblSanPham.getColumnModel().getColumn(7).setMinWidth(40);
            tblSanPham.getColumnModel().getColumn(7).setPreferredWidth(40);
            tblSanPham.getColumnModel().getColumn(7).setMaxWidth(40);
        }

        btnThemVaoDonHang.setText("Thêm vào đơn hàng");
        btnThemVaoDonHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemVaoDonHangActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thương Hiệu", " " }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel15.setText("Bộ lọc");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Màu Sắc", " " }));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giá", " " }));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Size", " ", " " }));

        javax.swing.GroupLayout jPanelSanPhamLayout = new javax.swing.GroupLayout(jPanelSanPham);
        jPanelSanPham.setLayout(jPanelSanPhamLayout);
        jPanelSanPhamLayout.setHorizontalGroup(
            jPanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSanPhamLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnThemVaoDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelSanPhamLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(39, 39, 39)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 38, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jScrollPane2)
        );
        jPanelSanPhamLayout.setVerticalGroup(
            jPanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                "TEN SP", "SL", "GIÁ", "THÀNH TIỀN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblDonHang);

        btnTaoHoaDon.setText("Tạo hóa đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        btnXoaKhoiDonHang.setText("Xóa khỏi đơn hàng");
        btnXoaKhoiDonHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKhoiDonHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelĐonHangLayout = new javax.swing.GroupLayout(jPanelĐonHang);
        jPanelĐonHang.setLayout(jPanelĐonHangLayout);
        jPanelĐonHangLayout.setHorizontalGroup(
            jPanelĐonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelĐonHangLayout.createSequentialGroup()
                .addGroup(jPanelĐonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                    .addGroup(jPanelĐonHangLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXoaKhoiDonHang)
                        .addGap(18, 18, 18)
                        .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelĐonHangLayout.setVerticalGroup(
            jPanelĐonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelĐonHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelĐonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoaKhoiDonHang)))
        );

        jPanelQLHD.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ĐƠN HÀNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel2.setText("Tên KH");

        jLabel3.setText("SĐT");

        jLabel4.setText("Tổng tiền: ");

        lblTongTien.setText("0.0");

        jLabel6.setText("Giảm giá: ");

        lblGiamGia.setText("0.0");

        jLabel5.setText("Tổng tiền cần thanh toán: ");

        lblTongTienThanhToan.setText("0.0");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền mặt", "Chuyển khoản", "Kết hợp" }));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THANH TOÁN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel7.setText("Tiền khách chuyển khoản");

        jLabel8.setText("Tiền mặt khách trả");

        jLabel9.setText("Tổng tiền khách đã thanh toán");

        jLabel10.setText("Tiền thừa");

        lblTienThua.setText("0.0");

        lblTongTienDaThanhToan.setText("0.0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTienMatKhachTra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTienKhachChuyenKhoan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTongTienDaThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTienKhachChuyenKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTienMatKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblTongTienDaThanhToan))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblTienThua))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã thanh toán", "Chưa thanh toán", "Hủy" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel12.setText("Trạng thái");

        jButton1.setText("Cập nhật hóa đơn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton6.setText("Làm mới");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel13.setText("Hình thức thanh toán");

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Thanh toán");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnXuatHoaDon.setText("Xuất hóa đơn");
        btnXuatHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelQLHDLayout = new javax.swing.GroupLayout(jPanelQLHD);
        jPanelQLHD.setLayout(jPanelQLHDLayout);
        jPanelQLHDLayout.setHorizontalGroup(
            jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelQLHDLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(32, 32, 32)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(jPanelQLHDLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelQLHDLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(105, 105, 105)
                        .addComponent(lblGiamGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelQLHDLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(23, 23, 23)
                        .addComponent(lblTongTienThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelQLHDLayout.createSequentialGroup()
                        .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(105, 105, 105)
                        .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenKH)
                            .addComponent(txtSDT)
                            .addGroup(jPanelQLHDLayout.createSequentialGroup()
                                .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanelQLHDLayout.createSequentialGroup()
                        .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(jPanelQLHDLayout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 28, Short.MAX_VALUE))
                    .addGroup(jPanelQLHDLayout.createSequentialGroup()
                        .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXuatHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(32, 32, 32)
                        .addComponent(jButton6)))
                .addContainerGap())
        );
        jPanelQLHDLayout.setVerticalGroup(
            jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelQLHDLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblTongTien))
                .addGap(39, 39, 39)
                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblGiamGia))
                .addGap(38, 38, 38)
                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblTongTienThanhToan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelQLHDLayout.createSequentialGroup()
                        .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXuatHoaDon))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelHoaDonCho.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HÓA ĐƠN CHỜ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MA HD", "NGAY TAO", "TEN NV", "TEN KH"
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHoaDonChoLayout.createSequentialGroup()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanelHoaDonChoLayout.setVerticalGroup(
            jPanelHoaDonChoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHoaDonChoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addComponent(jPanelSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanelĐonHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanelHoaDonCho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void btnXoaKhoiDonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKhoiDonHangActionPerformed

        xoaKhoiDonHang();
    }//GEN-LAST:event_btnXoaKhoiDonHangActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnXuatHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXuatHoaDonActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        clearForm();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnThemVaoDonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemVaoDonHangActionPerformed
        if (tblSanPham.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm");
            return;
        }

        loadTableDonHang();
    }//GEN-LAST:event_btnThemVaoDonHangActionPerformed

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
            java.util.logging.Logger.getLogger(BanHang_DiaLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BanHang_DiaLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BanHang_DiaLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BanHang_DiaLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BanHang_DiaLog dialog = new BanHang_DiaLog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThemVaoDonHang;
    private javax.swing.JButton btnXoaKhoiDonHang;
    private javax.swing.JButton btnXuatHoaDon;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JLabel lblTongTienDaThanhToan;
    private javax.swing.JLabel lblTongTienThanhToan;
    private javax.swing.JTable tblDonHang;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTienKhachChuyenKhoan;
    private javax.swing.JTextField txtTienMatKhachTra;
    // End of variables declaration//GEN-END:variables
}
