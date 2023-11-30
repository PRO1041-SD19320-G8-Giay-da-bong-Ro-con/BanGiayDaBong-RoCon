/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitory;

import com.utils.DBConnect;
import db.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ChiTietSanPham;
import model.HoaDon;
import model.MauSac;
import model.SanPham;
import model.Size;

/**
 *
 * @author Admin
 */
public class BanHang_Respo {

    public List<ChiTietSanPham> getAllSanPham() {
        List<ChiTietSanPham> lst = new ArrayList<>();
        ResultSet rs = null;
        String sql = """
                    SELECT CHI_TIET_SAN_PHAM.MaCTSP, CHI_TIET_SAN_PHAM.MaSP, SAN_PHAM.TenSP, THUONG_HIEU.Ten, LOAI_GIAY.Ten AS Expr1, XUAT_XU.Ten AS Expr2, CHAT_LIEU.Ten AS Expr3, SAN_PHAM.Gia, SIZE.Ten AS Expr4, MAU_SAC.Ten AS Expr5, CHI_TIET_SAN_PHAM.SoLuong
                    FROM     MAU_SAC INNER JOIN
                                      CHI_TIET_SAN_PHAM ON MAU_SAC.MaMau = CHI_TIET_SAN_PHAM.MaMau INNER JOIN
                                      SAN_PHAM ON CHI_TIET_SAN_PHAM.MaSP = SAN_PHAM.MaSP INNER JOIN
                                      LOAI_GIAY ON SAN_PHAM.MaLoai = LOAI_GIAY.MaLoai INNER JOIN
                                      CHAT_LIEU ON SAN_PHAM.MaChatLieu = CHAT_LIEU.MaChatLieu INNER JOIN
                                      SIZE ON CHI_TIET_SAN_PHAM.MaSize = SIZE.MaSize INNER JOIN
                                      THUONG_HIEU ON SAN_PHAM.MaThuongHieu = THUONG_HIEU.MaThuongHieu INNER JOIN
                                      XUAT_XU ON SAN_PHAM.MaXuatXu = XUAT_XU.MaXuatXu
                     """;
        try {

            rs = JDBCHelper.excuteQuery(sql);
            while (rs.next()) {

                lst.add(new ChiTietSanPham(rs.getString(1), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDouble(8)));

            }

            return lst;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    public int updateSoLuongSP(ChiTietSanPham ctsp, int soLuong) {
        String sql = """
                    UPDATE [dbo].[CHI_TIET_SAN_PHAM]
                        SET 
                         SoLuong = ?
                         WHERE [MaCTSP] = ?
                     """;
        return db.JDBCHelper.excuteUpdate(sql,
                soLuong,
                ctsp.getMaCTSP()
        );

    }

    public int taoHoaDon(HoaDon hd) {
        String sql = """
                     INSERT INTO [dbo].[HOA_DON]
                                ([MaHD]
                                ,[TaiKhoan]
                                ,[MaKH]
                                ,[MaKM]
                                ,[ThoiGianBan]
                                ,[HinhThucThanhToan]
                                ,[TrangThai])
                          VALUES
                                (?,?,?,?,?,?,?)
                     """;
        return db.JDBCHelper.excuteUpdate(sql,
                hd.getMaHD(),
                hd.getTaiKhoan(),
                hd.getMaKH(),
                hd.getMaKM(),
                hd.getThoiGianBan(),
                hd.getHinhThucThanhToan(),
                hd.isTrangThai());
    }

    public int addHoaDon(HoaDon hd) {
        String sql = """
                     INSERT INTO [dbo].[HOA_DON]
                                ([MaHD]
                                ,[TaiKhoan]
                                ,[MaKH]
                                ,[MaKM]
                                ,[ThoiGianBan]
                                ,[HinhThucThanhToan]
                                ,[TrangThai])
                          VALUES
                                (?,?,?,?,?,?,?)
                     """;
        return db.JDBCHelper.excuteUpdate(sql,
                hd.getMaHD(),
                hd.getTaiKhoan(),
                hd.getMaKH(),
                hd.getMaKM(),
                hd.getThoiGianBan(),
                hd.getHinhThucThanhToan(),
                hd.isTrangThai());
    }

    public List<ChiTietSanPham> getSanPhamTheoGia(Double gia) {
        List<ChiTietSanPham> lst = new ArrayList<>();
        ResultSet rs = null;
        String sql = """
                    SELECT CHI_TIET_SAN_PHAM.MaCTSP, CHI_TIET_SAN_PHAM.MaSP, SAN_PHAM.TenSP, THUONG_HIEU.Ten, LOAI_GIAY.Ten AS Expr1, XUAT_XU.Ten AS Expr2, CHAT_LIEU.Ten AS Expr3, SAN_PHAM.Gia, SIZE.Ten AS Expr4, MAU_SAC.Ten AS Expr5, CHI_TIET_SAN_PHAM.SoLuong
                    FROM     MAU_SAC INNER JOIN
                                      CHI_TIET_SAN_PHAM ON MAU_SAC.MaMau = CHI_TIET_SAN_PHAM.MaMau INNER JOIN
                                      SAN_PHAM ON CHI_TIET_SAN_PHAM.MaSP = SAN_PHAM.MaSP INNER JOIN
                                      LOAI_GIAY ON SAN_PHAM.MaLoai = LOAI_GIAY.MaLoai INNER JOIN
                                      CHAT_LIEU ON SAN_PHAM.MaChatLieu = CHAT_LIEU.MaChatLieu INNER JOIN
                                      SIZE ON CHI_TIET_SAN_PHAM.MaSize = SIZE.MaSize INNER JOIN
                                      THUONG_HIEU ON SAN_PHAM.MaThuongHieu = THUONG_HIEU.MaThuongHieu INNER JOIN
                                      XUAT_XU ON SAN_PHAM.MaXuatXu = XUAT_XU.MaXuatXu
                                      where SAN_PHAM.Gia = ?
                     """;
        try {

            rs = JDBCHelper.excuteQuery(sql, gia);
            while (rs.next()) {

                lst.add(new ChiTietSanPham(rs.getString(1), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDouble(8)));

            }

            return lst;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    public List<ChiTietSanPham> getSanPhamTheoMau(String mau) {
        List<ChiTietSanPham> lst = new ArrayList<>();
        ResultSet rs = null;
        String sql = """
                    SELECT CHI_TIET_SAN_PHAM.MaCTSP, CHI_TIET_SAN_PHAM.MaSP, SAN_PHAM.TenSP, THUONG_HIEU.Ten, LOAI_GIAY.Ten AS Expr1, XUAT_XU.Ten AS Expr2, CHAT_LIEU.Ten AS Expr3, SAN_PHAM.Gia, SIZE.Ten AS Expr4, MAU_SAC.Ten AS Expr5, CHI_TIET_SAN_PHAM.SoLuong
                    FROM     MAU_SAC INNER JOIN
                                      CHI_TIET_SAN_PHAM ON MAU_SAC.MaMau = CHI_TIET_SAN_PHAM.MaMau INNER JOIN
                                      SAN_PHAM ON CHI_TIET_SAN_PHAM.MaSP = SAN_PHAM.MaSP INNER JOIN
                                      LOAI_GIAY ON SAN_PHAM.MaLoai = LOAI_GIAY.MaLoai INNER JOIN
                                      CHAT_LIEU ON SAN_PHAM.MaChatLieu = CHAT_LIEU.MaChatLieu INNER JOIN
                                      SIZE ON CHI_TIET_SAN_PHAM.MaSize = SIZE.MaSize INNER JOIN
                                      THUONG_HIEU ON SAN_PHAM.MaThuongHieu = THUONG_HIEU.MaThuongHieu INNER JOIN
                                      XUAT_XU ON SAN_PHAM.MaXuatXu = XUAT_XU.MaXuatXu
                                      where MAU_SAC.MaMau = ?
                     """;
        try {

            rs = JDBCHelper.excuteQuery(sql, mau);
            while (rs.next()) {

                lst.add(new ChiTietSanPham(rs.getString(1), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDouble(8)));

            }

            return lst;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    public List<MauSac> getMauSac() {
        List<MauSac> lst = new ArrayList<>();
        ResultSet rs = null;
        String sql = """
                    select * from MAU_SAC
                     """;
        rs = JDBCHelper.excuteQuery(sql
        );
        try {
            while (rs.next()) {

                lst.add(new MauSac(rs.getString(1), rs.getString(2)));
            }
            return lst;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public List<Size> getSize() {
        List<Size> lst = new ArrayList<>();
        ResultSet rs = null;
        String sql = """
                    select * from SIZE
                     """;
        rs = JDBCHelper.excuteQuery(sql
        );
        try {
            while (rs.next()) {

                lst.add(new Size(rs.getString(1), rs.getString(2)));
            }
            return lst;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public List<ChiTietSanPham> getSanPhamTheoThuongHieu(String ma) {
        List<ChiTietSanPham> lst = new ArrayList<>();
        ResultSet rs = null;
        String sql = """
                    SELECT CHI_TIET_SAN_PHAM.MaCTSP, CHI_TIET_SAN_PHAM.MaSP, SAN_PHAM.TenSP, THUONG_HIEU.Ten, LOAI_GIAY.Ten AS Expr1, XUAT_XU.Ten AS Expr2, CHAT_LIEU.Ten AS Expr3, SAN_PHAM.Gia, SIZE.Ten AS Expr4, MAU_SAC.Ten AS Expr5, CHI_TIET_SAN_PHAM.SoLuong
                    FROM     MAU_SAC INNER JOIN
                                      CHI_TIET_SAN_PHAM ON MAU_SAC.MaMau = CHI_TIET_SAN_PHAM.MaMau INNER JOIN
                                      SAN_PHAM ON CHI_TIET_SAN_PHAM.MaSP = SAN_PHAM.MaSP INNER JOIN
                                      LOAI_GIAY ON SAN_PHAM.MaLoai = LOAI_GIAY.MaLoai INNER JOIN
                                      CHAT_LIEU ON SAN_PHAM.MaChatLieu = CHAT_LIEU.MaChatLieu INNER JOIN
                                      SIZE ON CHI_TIET_SAN_PHAM.MaSize = SIZE.MaSize INNER JOIN
                                      THUONG_HIEU ON SAN_PHAM.MaThuongHieu = THUONG_HIEU.MaThuongHieu INNER JOIN
                                      XUAT_XU ON SAN_PHAM.MaXuatXu = XUAT_XU.MaXuatXu
                                      where THUONG_HIEU.MaThuongHieu = ?
                     """;
        try {

            rs = JDBCHelper.excuteQuery(sql, ma);
            while (rs.next()) {

                lst.add(new ChiTietSanPham(rs.getString(1), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDouble(8)));

            }

            return lst;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    public List<ChiTietSanPham> getSanPhamTheoSize(String ma) {
        List<ChiTietSanPham> lst = new ArrayList<>();
        ResultSet rs = null;
        String sql = """
                    SELECT CHI_TIET_SAN_PHAM.MaCTSP, CHI_TIET_SAN_PHAM.MaSP, SAN_PHAM.TenSP, THUONG_HIEU.Ten, LOAI_GIAY.Ten AS Expr1, XUAT_XU.Ten AS Expr2, CHAT_LIEU.Ten AS Expr3, SAN_PHAM.Gia, SIZE.Ten AS Expr4, MAU_SAC.Ten AS Expr5, CHI_TIET_SAN_PHAM.SoLuong
                    FROM     MAU_SAC INNER JOIN
                                      CHI_TIET_SAN_PHAM ON MAU_SAC.MaMau = CHI_TIET_SAN_PHAM.MaMau INNER JOIN
                                      SAN_PHAM ON CHI_TIET_SAN_PHAM.MaSP = SAN_PHAM.MaSP INNER JOIN
                                      LOAI_GIAY ON SAN_PHAM.MaLoai = LOAI_GIAY.MaLoai INNER JOIN
                                      CHAT_LIEU ON SAN_PHAM.MaChatLieu = CHAT_LIEU.MaChatLieu INNER JOIN
                                      SIZE ON CHI_TIET_SAN_PHAM.MaSize = SIZE.MaSize INNER JOIN
                                      THUONG_HIEU ON SAN_PHAM.MaThuongHieu = THUONG_HIEU.MaThuongHieu INNER JOIN
                                      XUAT_XU ON SAN_PHAM.MaXuatXu = XUAT_XU.MaXuatXu
                                      where SIZE.MaSize = ?
                     """;
        try {

            rs = JDBCHelper.excuteQuery(sql, ma);
            while (rs.next()) {

                lst.add(new ChiTietSanPham(rs.getString(1), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDouble(8)));

            }

            return lst;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean getHoaDonTheoMa(String ma) {
        ResultSet rs = null;
        String sql = """
                    select * from HOA_DON where MaHD =?
                     """;
        try {

            rs = JDBCHelper.excuteQuery(sql, ma);
            while (rs.next()) {

                return false;
            }

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }

    }

    public List<HoaDon> getHoaDonCho(boolean trangthai) {
        List<HoaDon> list = new ArrayList<>();
        ResultSet rs = null;
        String sql = "select mahd,thoigianban,tai_khoan.ten,khach_hang.tenkh from hoa_don join tai_khoan on hoa_don.taikhoan=tai_khoan.taikhoan join khach_hang on hoa_don.makh=khach_hang.makh where trangthai=?";
        try {
            rs = JDBCHelper.excuteQuery(sql, trangthai);
            while (rs.next()) {
                list.add(new HoaDon(rs.getString(1), rs.getDate(2), rs.getString(3), rs.getString(4)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public String getMatheoten(String tenkh) {
        ResultSet rs = null;
        String ma = null;
        String sql = "select makh from khachhang where tenkh=? ";
        try {
            rs = JDBCHelper.excuteQuery(sql, tenkh);
            while (rs.next()) {
                ma = rs.getString(1);
            }
            return ma;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        
        public String getmaTheotenNV(String tennv) {
        ResultSet rs = null;
        String manv = null;
        String sql = "select taikhoan from tai_khoan where MaNV=? ";
        try {
            rs = JDBCHelper.excuteQuery(sql, tennv);
            while (rs.next()) {
                manv = rs.getString(1);
            }
            return manv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
