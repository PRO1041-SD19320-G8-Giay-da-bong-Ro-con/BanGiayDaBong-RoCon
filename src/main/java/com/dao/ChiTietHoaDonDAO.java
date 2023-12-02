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

    String INSERT_SQL = "INSERT INTO Chi_Tiet_HOA_DON (MaHD,MaCTSP,SoLuong) VALUES(?,?,?)";
    String UPDATE_SQL = "UPDATE Chi_Tiet_HOA_DON SET SoLuong = ? WHERE MACTSP = ?";
    String SELECT_ALL_SQL = "select * from HOA_DON";
    String SELECT_BY_ID_SQL = "select * from HOA_DON where mahd = ?";
    String DELETE_SQL = "DELETE FROM Chi_Tiet_HOA_DON WHERE MACTSP = ?";
    String GET_TONG_TIEN = "select tongTien from vGetTongTien where maHD = ?";

    @Override

    public int insert(ChiTietHoaDon entity) throws SQLException {
        return JDBCHelper.update(INSERT_SQL, entity.getMaHD(), entity.getMaCTSP(), entity.getSoLuong());
    }

    @Override
    public int update(ChiTietHoaDon entity) throws SQLException {
        return JDBCHelper.update(UPDATE_SQL, entity.getSoLuong(),entity.getMaCTSP());
    }

    @Override
    public int delete(String key) throws SQLException {
        return JDBCHelper.update(DELETE_SQL, key);
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
            String sql = "select * from vHoaDonChiTiet where maHD = ?";
            String[] cols = {"MaCTSP", "TenSP", "SoLuong", "Gia"};
            ResultSet rs = JDBCHelper.query(sql, maHD);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Object[]> getAllHoaDon(String maHD) {
        try {
            List<Object[]> list = new ArrayList<>();
            String sql = "select * from vHoaDonChiTiet where maHD = '" + maHD + "'";
            String[] cols = {"MaCTSP", "TenSP", "SoLuong", "Gia"};
            ResultSet rs = JDBCHelper.query(sql);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public Double getTongTien(String maHD){
        try {
            return (double)(JDBCHelper.value(GET_TONG_TIEN, maHD));
        } catch (Exception e) {
            return 0d;
        }
    }
}
