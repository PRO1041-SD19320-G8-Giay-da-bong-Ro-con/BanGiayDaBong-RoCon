/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import com.entity.HoaDon;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ChiTietSanPham;
import model.DonHang;
import model.MauSac;
import model.SanPham;
import model.Size;
import model.ThuongHieu;
import responsitory.BanHang_Respo;
import services.BanHang_Ser;
import services.SanPham_Ser;

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
    SanPham_Ser ql1 = new SanPham_Ser();
    BanHang_Respo sv=new BanHang_Respo();
    List<HoaDon> lstHD=new ArrayList<>();
    Date dt=new Date();
    /**
     * Creates new form HoaDon_JDiaLog
     */
    public BanHang_DiaLog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
//        if (lstDonHang.size() != 0) {
//            this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
//            JOptionPane.showMessageDialog(this, "Bạn cần xử lý đơn hàng trước khi kết thúc chương trình");
//            return;
//        }
    }

    private void init() {
        setLocationRelativeTo(null);
        lstSP = ql.getAllSanPham();
        loadTableSP(lstSP);
        if (cboHinhThucThanhToan.getSelectedIndex() == 0) {
            txtTienMatKhachTra.setEnabled(true);
            txtTienKhachChuyenKhoan.setEnabled(false);

        }
        Double tongTien = Double.parseDouble(lblTongTien.getText());
        Double tongTienKhachThanhToan = Double.parseDouble(lblTongTienDaThanhToan.getText());
        btnCapNhatHoaDon.setEnabled(false);

        btnTaoHoaDon.setEnabled(false);
        btnXoaKhoiDonHang.setEnabled(false);

        loadCboGia();
        loadCboMauSac();
        loadCboThuongHieu();
        loadCboSize();
        loadHoaDon(ql.getHoaDonCho(false));
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
        if (lstDonHang.size() == 0) {
            JOptionPane.showMessageDialog(this, "Đơn hàng trống");
            return;
        }
        Double tongTien = 0.0;
        for (int i = 0; i < tblDonHang.getRowCount(); i++) {
            Double giaTien = Double.parseDouble(tblDonHang.getValueAt(i, 3).toString());
            tongTien += giaTien;
            lblTongTien.setText(tongTien + "");
            lblTongTienThanhToan.setText(tongTien - Double.parseDouble(lblGiamGia.getText()) + "");
        }
        if (lstDonHang.size() == 0) {           
            btnTaoHoaDon.setEnabled(false);
            btnXoaKhoiDonHang.setEnabled(false);
        }
        if (lstDonHang.size() != 0) {
            btnTaoHoaDon.setEnabled(true);
            btnXoaKhoiDonHang.setEnabled(true);
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
        Double tongTien = 0.0;
        if (lstDonHang.size() == 0) {
            lblTongTien.setText(0.0 + "");
            lblTongTienThanhToan.setText(0.0 + "");
            lblGiamGia.setText(0.0 + "");
            btnTaoHoaDon.setEnabled(false);
            btnXoaKhoiDonHang.setEnabled(false);
        }
        for (int i = 0; i < tblDonHang.getRowCount(); i++) {
            Double giaTien = Double.parseDouble(tblDonHang.getValueAt(i, 3).toString());
            tongTien += giaTien;
            lblTongTien.setText(tongTien + "");
            lblTongTienThanhToan.setText(tongTien - Double.parseDouble(lblGiamGia.getText()) + "");
        }
        if (lstDonHang.size() != 0) {
            btnTaoHoaDon.setEnabled(true);
            btnXoaKhoiDonHang.setEnabled(true);
        }
    }

    private void loadCboGia() {
        DefaultComboBoxModel cboModel = new DefaultComboBoxModel();
        cboModel = (DefaultComboBoxModel) cboGia.getModel();
        lstSP = ql.getAllSanPham();
        Collections.sort(lstSP, Comparator.comparing(SanPham::getGia));
        Set<Double> uniqueGia = new TreeSet<>();
        for (ChiTietSanPham sp1 : lstSP) {
            uniqueGia.add(sp1.getGia());
        }
        for (Double sp : uniqueGia) {
            cboModel.addElement(sp);
        }

    }

    private void loadCboThuongHieu() {
        DefaultComboBoxModel cboModel = new DefaultComboBoxModel();
        cboModel = (DefaultComboBoxModel) cboThuongHieu.getModel();
        for (ThuongHieu th : ql1.getThuongHieu()) {
            cboModel.addElement(th);
        }
    }

    private void loadCboMauSac() {
        DefaultComboBoxModel cboModel = new DefaultComboBoxModel();
        cboModel = (DefaultComboBoxModel) cboMauSac.getModel();
        for (MauSac ms : ql.getMauSac()) {
            cboModel.addElement(ms);
        }
    }

    private void loadCboSize() {
        DefaultComboBoxModel cboModel = new DefaultComboBoxModel();
        cboModel = (DefaultComboBoxModel) cboSize.getModel();
        for (Size sz : ql.getSize()) {
            cboModel.addElement(sz);
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
        lstDonHang.clear();
        tblModelDH.setRowCount(0);
        tblModelDH = (DefaultTableModel) tblDonHang.getModel();
    }
    
    private void loadHoaDon(List<model.HoaDon> hd){
        tblModelDH=(DefaultTableModel)tableCho.getModel();
        tblModelDH.setRowCount(0);
        for(model.HoaDon x:hd){
            tblModelDH.addRow(new Object[]{
            x.getMaHD(),
            x.getThoiGianBan(),
            x.getTaiKhoan(),
            x.getMaKH()
            });
        }
    }
    
    private void showDetail(int index){
        model.HoaDon hd = ql.getHoaDonCho(false).get(index);
        txtMaHD.setText(hd.getMaHD());
        txtMaNV.setText(ql.getmaTheotenNV(hd.getTaiKhoan()));
        txtTenKH.setText(hd.getMaKH());
       
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
        cboThuongHieu = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        cboMauSac = new javax.swing.JComboBox<>();
        cboGia = new javax.swing.JComboBox<>();
        cboSize = new javax.swing.JComboBox<>();
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
        cboHinhThucThanhToan = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtTienKhachChuyenKhoan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTienMatKhachTra = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblTienThua = new javax.swing.JLabel();
        lblTongTienDaThanhToan = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        btnCapNhatHoaDon = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        btnXuatHoaDon = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jPanelHoaDonCho = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableCho = new javax.swing.JTable();

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

        cboThuongHieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thương Hiệu" }));
        cboThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboThuongHieuActionPerformed(evt);
            }
        });

        jLabel15.setText("Bộ lọc");

        cboMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Màu Sắc" }));
        cboMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMauSacActionPerformed(evt);
            }
        });

        cboGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giá" }));
        cboGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGiaActionPerformed(evt);
            }
        });

        cboSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Size" }));
        cboSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSizeActionPerformed(evt);
            }
        });

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
                        .addComponent(cboThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboGia, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboSize, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 38, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jScrollPane2)
        );
        jPanelSanPhamLayout.setVerticalGroup(
            jPanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        cboHinhThucThanhToan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền mặt", "Chuyển khoản", "Kết hợp" }));
        cboHinhThucThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboHinhThucThanhToanActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THANH TOÁN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel7.setText("Tiền khách chuyển khoản");

        txtTienKhachChuyenKhoan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTienKhachChuyenKhoanKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachChuyenKhoanKeyReleased(evt);
            }
        });

        jLabel8.setText("Tiền mặt khách trả");

        jLabel9.setText("Tổng tiền khách đã thanh toán");

        jLabel10.setText("Tiền thừa");

        lblTienThua.setText("0.0");

        lblTongTienDaThanhToan.setText("0.0");

        jLabel17.setText("VND");

        jLabel18.setText("VND");

        jLabel19.setText("VND");

        jLabel20.setText("VND");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 35, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTienKhachChuyenKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTienMatKhachTra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTongTienDaThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .addComponent(lblTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel19))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTienKhachChuyenKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTienMatKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblTongTienDaThanhToan)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblTienThua)
                    .addComponent(jLabel20))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã thanh toán", "Chưa thanh toán", "Hủy" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel12.setText("Trạng thái");

        btnCapNhatHoaDon.setText("Cập nhật hóa đơn");
        btnCapNhatHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatHoaDonActionPerformed(evt);
            }
        });

        jButton6.setText("Làm mới");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel13.setText("Hình thức thanh toán");

        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnXuatHoaDon.setText("Xuất hóa đơn");
        btnXuatHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatHoaDonActionPerformed(evt);
            }
        });

        jLabel11.setText("VND");

        jLabel14.setText("VND");

        jLabel16.setText("VND");

        jLabel21.setText("Mã NV");

        jLabel22.setText("Mã HD");

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
                        .addComponent(jLabel22)
                        .addGap(123, 123, 123)
                        .addComponent(txtMaHD))
                    .addGroup(jPanelQLHDLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(123, 123, 123)
                        .addComponent(txtMaNV))
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
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelQLHDLayout.createSequentialGroup()
                                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel16))
                                .addGap(64, 64, 64))))
                    .addGroup(jPanelQLHDLayout.createSequentialGroup()
                        .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCapNhatHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXuatHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(32, 32, 32)
                        .addComponent(jButton6))
                    .addGroup(jPanelQLHDLayout.createSequentialGroup()
                        .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13)
                            .addGroup(jPanelQLHDLayout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(cboHinhThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelQLHDLayout.createSequentialGroup()
                                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelQLHDLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblTongTienThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelQLHDLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(114, 114, 114)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelQLHDLayout.setVerticalGroup(
            jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelQLHDLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblTongTien)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblGiamGia)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblTongTienThanhToan)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(jPanelQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboHinhThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(btnCapNhatHoaDon)
                            .addComponent(jButton6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXuatHoaDon))
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelHoaDonCho.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HÓA ĐƠN CHỜ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tableCho.setModel(new javax.swing.table.DefaultTableModel(
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
        tableCho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableChoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableCho);

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelHoaDonCho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanelQLHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private model.HoaDon readform(){
        model.HoaDon hd=new model.HoaDon();
        hd.setMaHD(txtMaHD.getText());
        hd.setThoiGianBan(dt);
        hd.setTrangThai(false);
        hd.setMaKH(ql.getMatheoten(txtTenKH.getText()));
        hd.setTaiKhoan(txtMaNV.getText());
        hd.setHinhThucThanhToan(cboHinhThucThanhToan.getSelectedItem()+"");
        return hd;
    }
    
    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
//        if(ql.getHoaDonTheoMa(txtMaHD.getText())){
//            JOptionPane.showMessageDialog(this, "Trùng mã hóa đơn");
//            return;
//        }
//        taoHoaDon();

        model.HoaDon hd=readform();
        if(sv.addHoaDon(hd)!=0){
            loadHoaDon(ql.getHoaDonCho(false));
        }
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void btnXoaKhoiDonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKhoiDonHangActionPerformed
        xoaKhoiDonHang();
    }//GEN-LAST:event_btnXoaKhoiDonHangActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void btnCapNhatHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCapNhatHoaDonActionPerformed

    private void cboThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboThuongHieuActionPerformed
        if (cboThuongHieu.getSelectedIndex() == 0) {
            lstSP = ql.getAllSanPham();
            loadTableSP(lstSP);
            return;
        }
        cboGia.setSelectedIndex(0);
        cboSize.setSelectedIndex(0);
        cboMauSac.setSelectedIndex(0);
        ThuongHieu th = (ThuongHieu) cboThuongHieu.getSelectedItem();
        lstSP = ql.getSanPhamTheoThuongHieu(th.getMaThuongHieu());
        loadTableSP(lstSP);
    }//GEN-LAST:event_cboThuongHieuActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        Double tienck=Double.parseDouble(txtTienKhachChuyenKhoan.getText());
        Double tienmat=Double.parseDouble(txtTienMatKhachTra.getText());
        Double tongtien=tienck+tienmat;
        lblTongTienDaThanhToan.setText(tongtien+"");
        
        
    }//GEN-LAST:event_btnThanhToanActionPerformed

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

    private void cboHinhThucThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboHinhThucThanhToanActionPerformed
        if (cboHinhThucThanhToan.getSelectedIndex() == 0) {
            txtTienMatKhachTra.setEnabled(true);
            txtTienKhachChuyenKhoan.setText("0");
            txtTienKhachChuyenKhoan.setEnabled(false);

        }
        if (cboHinhThucThanhToan.getSelectedIndex() == 1) {
            txtTienKhachChuyenKhoan.setEnabled(true);
            txtTienMatKhachTra.setText("0");
            txtTienMatKhachTra.setEnabled(false);

        }
        if (cboHinhThucThanhToan.getSelectedIndex() == 2) {
            txtTienKhachChuyenKhoan.setEnabled(true);
            txtTienMatKhachTra.setEnabled(true);
        }
    }//GEN-LAST:event_cboHinhThucThanhToanActionPerformed

    private void txtTienKhachChuyenKhoanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachChuyenKhoanKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            Double tienCK = Double.parseDouble(txtTienKhachChuyenKhoan.getText());
            lblTongTienDaThanhToan.setText(tienCK + "");

        } else {
            return;
        }
    }//GEN-LAST:event_txtTienKhachChuyenKhoanKeyPressed

    private void cboGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGiaActionPerformed
        if (cboGia.getSelectedIndex() == 0) {
            lstSP = ql.getAllSanPham();
            loadTableSP(lstSP);
            return;
        }
        cboThuongHieu.setSelectedIndex(0);
        cboSize.setSelectedIndex(0);
        cboMauSac.setSelectedIndex(0);
        Double gia = Double.parseDouble(cboGia.getSelectedItem().toString());
        lstSP = ql.getSanPhamTheoGia(gia);

        loadTableSP(lstSP);
    }//GEN-LAST:event_cboGiaActionPerformed

    private void cboMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMauSacActionPerformed
        if (cboMauSac.getSelectedIndex() == 0) {
            lstSP = ql.getAllSanPham();
            loadTableSP(lstSP);
            return;
        }
        cboThuongHieu.setSelectedIndex(0);
        cboSize.setSelectedIndex(0);
        cboGia.setSelectedIndex(0);
        MauSac ms = (MauSac) cboMauSac.getSelectedItem();
        lstSP = ql.getSanPhamTheoMau(ms.getMaMauSac());

        loadTableSP(lstSP);
    }//GEN-LAST:event_cboMauSacActionPerformed

    private void cboSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSizeActionPerformed
        if (cboSize.getSelectedIndex() == 0) {
            lstSP = ql.getAllSanPham();
            loadTableSP(lstSP);
            return;
        }
        cboThuongHieu.setSelectedIndex(0);
        cboMauSac.setSelectedIndex(0);
        cboGia.setSelectedIndex(0);
        Size sz = (Size) cboSize.getSelectedItem();
        lstSP = ql.getSanPhamTheoSize(sz.getMaSize());

        loadTableSP(lstSP);
    }//GEN-LAST:event_cboSizeActionPerformed

    private void txtTienKhachChuyenKhoanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachChuyenKhoanKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienKhachChuyenKhoanKeyReleased

    private void tableChoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableChoMouseClicked
        index=tableCho.getSelectedRow();
        showDetail(index);
    }//GEN-LAST:event_tableChoMouseClicked

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
    private javax.swing.JButton btnCapNhatHoaDon;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemVaoDonHang;
    private javax.swing.JButton btnXoaKhoiDonHang;
    private javax.swing.JButton btnXuatHoaDon;
    private javax.swing.JComboBox<String> cboGia;
    private javax.swing.JComboBox<String> cboHinhThucThanhToan;
    private javax.swing.JComboBox<String> cboMauSac;
    private javax.swing.JComboBox<String> cboSize;
    private javax.swing.JComboBox<String> cboThuongHieu;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
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
    private javax.swing.JLabel lblGiamGia;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lblTongTienDaThanhToan;
    private javax.swing.JLabel lblTongTienThanhToan;
    private javax.swing.JTable tableCho;
    private javax.swing.JTable tblDonHang;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTienKhachChuyenKhoan;
    private javax.swing.JTextField txtTienMatKhachTra;
    // End of variables declaration//GEN-END:variables
}
