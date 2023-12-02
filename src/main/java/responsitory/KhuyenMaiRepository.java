/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitory;

import db.JDBCHelper;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import model.KhuyenMai;
import java.sql.ResultSet;
import java.sql.Date;

/**
 *
 * @author FPT SHOP
 */
public class KhuyenMaiRepository {

    public List<KhuyenMai> getAll() {
        List<KhuyenMai> lst = new ArrayList<>();
        String sql = """
                     SELECT * FROM KHUYEN_MAI
                     """;
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                lst.add(new KhuyenMai(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getFloat(5), rs.getDate(6), rs.getDate(7)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
    public List<KhuyenMai> locData() {
        List<KhuyenMai> lst = new ArrayList<>();
        String sql = """
                     SELECT * FROM KHUYEN_MAI
                     WHERE GETDATE() BETWEEN ThoiGianBatDau AND ThoiGianKetThuc;
                     """;
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                lst.add(new KhuyenMai(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getFloat(5), rs.getDate(6), rs.getDate(7)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public KhuyenMai getOne(String ma) {
        List<KhuyenMai> lst = new ArrayList<>();
        String sql = """
                     SELECT * FROM KHUYEN_MAI WHERE MANV = ?;
                     """;
        ResultSet rs = JDBCHelper.excuteQuery(sql, ma);
        try {
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getFloat(5), rs.getDate(6), rs.getDate(7));
                return km;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean add(KhuyenMai km) {
        int check = 0;
        String sql = """
                     INSERT INTO [dbo].[KHUYEN_MAI]
                                ([MaKM]
                                ,[Ten]
                                ,[NoiDung]
                                ,[LoaiKM]
                                ,[GiamGia]
                                ,[ThoiGianBatDau]
                                ,[ThoiGianKetThuc])
                          VALUES (?,?,?,?,?,?,?)
                     """;
        check = JDBCHelper.excuteUpdate(sql, km.getMaKM(), km.getTenKM(), km.getNoiDung(), km.isLoaiKM(), km.getGiamGia(), km.getNgayBatDau(), km.getNgayKetThuc());
        return check > 0;
    }

    public Boolean update(KhuyenMai km) {
        int check = 0;
        String sql = """
                     UPDATE [dbo].[KHUYEN_MAI]
                             SET 
                                [Ten] = ?
                                ,[NoiDung] = ?
                                ,[LoaiKM] = ?
                                ,[GiamGia] = ?
                                ,[ThoiGianBatDau] = ?
                                ,[ThoiGianKetThuc] = ?
                           WHERE [MaKM] = ?
                     """;
        check = JDBCHelper.excuteUpdate(sql, km.getTenKM(), km.getNoiDung(), km.isLoaiKM(), km.getGiamGia(), km.getNgayBatDau(), km.getNgayKetThuc(), km.getMaKM());
        return check > 0;
    }

    public Boolean delete(String ma) {
        int check = 0;
        String sql = """
                   DELETE FROM [dbo].[KHUYEN_MAI] 
                     WHERE [MaKM] = ?
                     """;
        check = JDBCHelper.excuteUpdate(sql, ma);
        return check > 0;
    }

}
