/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.entity.ChiTietHoaDon;
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
public class ChiTietHoaDonDAO implements DAOInterface<ChiTietHoaDon, String> {

    String SELECT_ALL_SQL = "select * from HOA_DON";
    String SELECT_BY_ID_SQL = "select * from HOA_DON where mahd = ?";

    @Override

    public int insert(ChiTietHoaDon entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(ChiTietHoaDon entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(String key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ChiTietHoaDon> selectAll() throws SQLException {
        return selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public ChiTietHoaDon selectByID(String key) throws SQLException {
        List<ChiTietHoaDon> list = selectBySQL(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<ChiTietHoaDon> selectBySQL(String sql, Object... args) throws SQLException {
        List<ChiTietHoaDon> list = new ArrayList<>();
        ResultSet rs = JDBCHelper.query(sql, args);
        while (rs.next()) {
            ChiTietHoaDon entity = new ChiTietHoaDon();
            entity.setMaHD(rs.getString("MaHD"));
            entity.setMaCTSP(rs.getString("MaCTSP"));
            entity.setSoLuong(rs.getInt("SoLuong"));
            list.add(entity);
        }
        rs.getStatement().getConnection().close();
        return list;

    }

    public List<Object[]> getAllHoaDonChiTiet(String maHD) {
        try {
            List<Object[]> list = new ArrayList<>();
            String sql = "{CALL GetHoaDonChiTiet(?)}";
            String[] cols = {"MaCTSP", "TenSP", "SoLuong", "Gia"};
            ResultSet rs = JDBCHelper.query(sql, maHD);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                System.out.println(vals.toString());
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
