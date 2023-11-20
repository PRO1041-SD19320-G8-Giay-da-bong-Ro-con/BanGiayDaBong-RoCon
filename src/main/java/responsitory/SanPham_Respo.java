/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitory;

import db.DBConnect;
import db.JDBCHelper;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ChatLieu;
import model.SanPham;
import model.ThuongHieu;


/**
 *
 * @author Admin
 */
public class SanPham_Respo implements Giay_Interfacce<SanPham> {

    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;

    @Override
    public List<SanPham> getAllData() {
        sql = "select * from SAN_PHAM";
        List<SanPham> lst = new ArrayList<>();
        try {

            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                lst.add(new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(7), rs.getString(6), rs.getDouble(8)));

            }

            return lst;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }
   

    @Override
    public int insert(SanPham n) {
        sql = "insert into SAN_PHAM values(?,?,?,?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, n.getMaSP());
            ps.setObject(2, n.getTenSP());
            ps.setObject(3, n.getHinh());
            ps.setObject(4, n.getMaThuongHieu());
            ps.setObject(5, n.getMaLoai());
            ps.setObject(6, n.getMaChatLieu());
            ps.setObject(7, n.getMaXuatXu());
            ps.setObject(8, n.getGia());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(String ma) {
        
        return 0;
        
    }

    @Override
    public int update(SanPham n, String ma) {
        
        return 0;
        
    }

    public List<SanPham> getSanPhamTheoGia(String gia) {
        sql = "select * from SAN_PHAM where Gia = ?";
        List<SanPham> lst = new ArrayList<>();
        try {

            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, gia);
            rs = ps.executeQuery();
            while (rs.next()) {

                lst.add(new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(7), rs.getString(6), rs.getDouble(8)));

            }

            return lst;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    public Boolean add(SanPham sp) {
        int check = 0;
        String sql = """
                     INSERT [dbo].[SAN_PHAM]
                                           ([MaSP]
                                           ,[TenSP]
                                           ,[Hinh]
                                           ,[MaThuongHieu]
                                            ,[MaLoai]
                                            ,[MaChatLieu]
                                            ,[MaXuatXu]
                                             ,[Gia])
                                             VALUES (?,?,?,?,?,?,?,?)
                     """;
        check = JDBCHelper.excuteUpdate(sql, sp.getMaSP(),
                sp.getTenSP(),
                sp.getHinh(),
                sp.getMaThuongHieu(),
                sp.getMaLoai(),
                sp.getMaChatLieu(),
                sp.getMaXuatXu(),
                sp.getGia()
        );
        return check > 0;
    }
    public Boolean update(SanPham sp) {
        int check = 0;
        String sql = """
                    UPDATE [dbo].[SAN_PHAM]
                        SET 
                         [TenSP] = ?
                         ,[Hinh] = ?
                         ,[MaThuongHieu] = ?
                         ,[MaLoai] = ?
                         ,[MaChatLieu] = ?
                         ,[MaXuatXu] = ?
                         ,[Gia] = ?
                         WHERE [MaSP] = ?
                     """;
        check = JDBCHelper.excuteUpdate(sql, 
                sp.getTenSP(),
                sp.getHinh(),
                sp.getMaThuongHieu(),
                sp.getMaLoai(),
                sp.getMaChatLieu(),
                sp.getMaXuatXu(),
                sp.getGia(),
                sp.getMaSP()
        );
        return check > 0;
    }

    public List<SanPham> getSanPhamTheoThuongHieu(String ma) {
        List<SanPham> lst = new ArrayList<>();
        ResultSet rs = null;
        String sql = """
                    select * from SAN_PHAM where MaThuongHieu = ?
                     """;
        rs = JDBCHelper.excuteQuery(sql,
                ma
        );
        try {
            while (rs.next()) {

                lst.add(new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(7), rs.getString(6), rs.getDouble(8)));

            }
            return lst;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public List<SanPham> getSanPhamTheoThuocTinh(SanPham sp) {
        List<SanPham> lst = new ArrayList<>();
        ResultSet rs = null;
        String sql = """
                    select MaSP, TenSP, MaThuongHieu, MaLoai, MaXuatXu, MaChatLieu, Gia from SAN_PHAM where MaThuongHieu = ? and MaLoai = ? and  MaXuatXu = ? and MaChatLieu = ? and Gia = ?
                     """;
        rs = JDBCHelper.excuteQuery(sql,
                sp.getMaThuongHieu(),
                sp.getMaLoai(),
                sp.getMaXuatXu(),
                sp.getMaChatLieu(),
                sp.getGia()
        );
        try {
            while (rs.next()) {

                lst.add(new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDouble(7)));

            }
            return lst;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public List<ChatLieu> getChatLieu() {
        List<ChatLieu> lst = new ArrayList<>();
        ResultSet rs = null;
        String sql = """
                    select * from CHAT_LIEU
                     """;
        rs = JDBCHelper.excuteQuery(sql
        );
        try {
            while (rs.next()) {

                lst.add(new ChatLieu(rs.getString(1),rs.getString(2)));
            }
            return lst;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }
    
    public List<ThuongHieu> getThuongHieu() {
        List<ThuongHieu> lst = new ArrayList<>();
        ResultSet rs = null;
        String sql = """
                    select * from THUONG_HIEU
                     """;
        rs = JDBCHelper.excuteQuery(sql
        );
        try {
            while (rs.next()) {

                lst.add(new ThuongHieu(rs.getString(1),rs.getString(2)));
            }
            return lst;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

}
