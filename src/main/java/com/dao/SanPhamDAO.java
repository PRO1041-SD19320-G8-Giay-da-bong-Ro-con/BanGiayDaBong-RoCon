/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.entity.SanPham;
import com.entity.ThuongHieu;
import com.utils.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thai
 */
public class SanPhamDAO implements DAOInterface<SanPham, String> {

    String INSERT_SQL = "INSERT INTO SAN_PHAM (MaSP,TenSP,Hinh,MaThuongHieu,MaLoai,MaChatLieu,MaXuatXu,Gia,TrangThai) VALUES(?,?,?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE SAN_PHAM SET TenSP = ?, Hinh = ?, MaThuongHieu = ?, MaLoai = ?, MaChatLieu = ?,MaXuatXu = ?, Gia = ? WHERE MaSP = ?";
    String SELECT_ALL_SQL = "select * from San_Pham ";
    String SELECT_BY_ID_SQL = "select * from San_Pham where masp = ?";
    String UPDATE_TRANG_THAI = "Update San_Pham Set TrangThai = ? where MaSP = ?";

    @Override
    public int insert(SanPham entity) throws SQLException {
        return JDBCHelper.update(INSERT_SQL, entity.getMaSP(), entity.getTenSP(), entity.getHinh(), entity.getMaThuongHieu(), entity.getMaLoai(), entity.getMaChatLieu(), entity.getMaXuatXu(), entity.getGia(), "1");
    }

    @Override
    public int update(SanPham entity) throws SQLException {
        return JDBCHelper.update(UPDATE_SQL, entity.getTenSP(), entity.getHinh(), entity.getMaThuongHieu(), entity.getMaLoai(), entity.getMaChatLieu(), entity.getMaXuatXu(), entity.getGia(),entity.getMaSP());
    }

    @Override
    public int delete(String key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SanPham> selectAll() throws SQLException {
        return selectBySQL(SELECT_ALL_SQL);
    }

    public List<SanPham> selectAll(String... sql) throws SQLException {
        return selectBySQL(SELECT_ALL_SQL + sql[0]);
    }

    @Override
    public SanPham selectByID(String key) throws SQLException {
        List<SanPham> list = selectBySQL(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<SanPham> selectBySQL(String sql, Object... args) throws SQLException {
        List<SanPham> list = new ArrayList<>();
        ResultSet rs = JDBCHelper.query(sql, args);
        while (rs.next()) {
            SanPham entity = new SanPham();
            entity.setMaSP(rs.getString("MaSP"));
            entity.setTenSP(rs.getString("TenSP"));
            entity.setHinh(rs.getString("Hinh"));
            entity.setMaThuongHieu(rs.getString("MaThuongHieu"));
            entity.setMaXuatXu(rs.getString("MaXuatXu"));
            entity.setMaChatLieu(rs.getString("MaChatLieu"));
            entity.setMaLoai(rs.getString("MaLoai"));
            entity.setGia(rs.getDouble("Gia"));
            entity.setTrangThai(rs.getBoolean("TrangThai"));
            list.add(entity);
        }

        rs.getStatement().getConnection().close();
        return list;

    }

    public ThuongHieu getThuongHieu(String id) {
        try {
            return new ThuongHieuDAO().selectByID(id);
        } catch (SQLException ex) {
            throw new Error();
        }
    }

    public SanPham setTrangThai(SanPham sp) {
        try {
            JDBCHelper.update(UPDATE_TRANG_THAI, sp.isTrangThai() ? "0" : "1", sp.getMaSP());
            return selectByID(sp.getMaSP());
        } catch (SQLException ex) {
            throw new Error("\nLỗi setTrangThai() SanPhamDAO.class\n" + ex);
        }
    }

}
