/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitory;

import db.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.entity.KhachHang;

/**
 *
 * @author FPT SHOP
 */
public class KhachHangRepository {

    public List<KhachHang> getAll() {
        List<KhachHang> lst = new ArrayList<>();
        String sql = """
                     SELECT * FROM KHACH_HANG
                     """;
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                lst.add(new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
    public KhachHang getOne(String ma) {
        List<KhachHang> lst = new ArrayList<>();
        String sql = """
                     SELECT * FROM KHACH_HANG WHERE MAkh = ?;
                     """;
        ResultSet rs = JDBCHelper.excuteQuery(sql, ma);
        try {
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
                return kh;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean add(KhachHang kh) {
        int check = 0;
        String sql = """
                    INSERT INTO [dbo].[KHACH_HANG]
                                ([MaKH]
                                ,[TenKH]
                                ,[SDT]
                                ,[DiaChi]
                                ,[NgaySinh])
                          VALUES (?,?,?,?,?)
                     """;
        check = JDBCHelper.excuteUpdate(sql, kh.getMaKH(), kh.getTenKH(), kh.getSdt(), kh.getDiaChi(), kh.getNgaySinh());
        return check > 0;
    }

    public Boolean update(KhachHang kh) {
        int check = 0;
        String sql = """
                   UPDATE [dbo].[KHACH_HANG]
                             SET 
                                [TenKH] = ?
                                ,[SDT] = ?
                                ,[DiaChi] = ?
                                ,[NgaySinh] = ?
                           WHERE [MaKH] = ?
                     """;
        check = JDBCHelper.excuteUpdate(sql, kh.getTenKH(), kh.getSdt(), kh.getDiaChi(), kh.getNgaySinh(), kh.getMaKH());
        return check > 0;
    }
}
