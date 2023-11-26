/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.entity.HoaDon;
import com.utils.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thai
 */
public class HoaDonDAO implements DAOInterface<HoaDon, String> {

    String SELECT_ALL_SQL = "select * from vHoaDon order by thoiGianBan desc";
    String SELECT_BY_ID_SQL = "select * from vHoaDon where mahd = ?";
    String LOC = "select * from vHoaDon where ";

    @Override
    public int insert(HoaDon entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(HoaDon entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(String key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<HoaDon> selectAll() throws SQLException {
        return selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public HoaDon selectByID(String key) throws SQLException {
        List<HoaDon> list = selectBySQL(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HoaDon> selectBySQL(String sql, Object... args) throws SQLException {
        List<HoaDon> list = new ArrayList<>();
        ResultSet rs = JDBCHelper.query(sql, args);
        while (rs.next()) {
            HoaDon entity = new HoaDon();
            entity.setMaHD(rs.getString("MaHD"));
            entity.setTaiKhoan(rs.getString("TaiKhoan"));
            entity.setMaKH(rs.getString("MaKH"));
            entity.setTongTienGoc(rs.getDouble("TongTienGoc"));
            entity.setMaKM(rs.getString("MaKM"));
            entity.setTongTienCuoi(rs.getDouble("TongTienCuoi"));
            entity.setThoiGianBan(rs.getDate("ThoiGianBan"));
            entity.setHinhThucThanhToan(rs.getString("HinhThucThanhToan"));
            entity.setTrangThai(rs.getBoolean("TrangThai"));
            list.add(entity);
        }
        rs.getStatement().getConnection().close();
        return list;

    }
    
    public List<HoaDon> Loc(String loc) throws SQLException {
        return selectBySQL(LOC+loc+" order by thoiGianBan desc");
    }

}
