/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.entity.Size;
import com.entity.ThuongHieu;
import com.utils.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thai
 */
public class SizeDAO implements DAOInterface<Size, String> {

    String SELECT_NAME_BY_ID_SQL = "Select ten from Size where maSize = ?";
    String SELECT_ALL_SQL = "select * from Size";
    String SELECT_BY_ID_SQL = "select * from Size where maSize = ?";
    String SELECT_BY_NAME_SQL = "select * from Size where Ten = ?";
    String SELECT_ALL_BY_MASP = "select distinct s.* from SIZE s join CHI_TIET_SAN_PHAM ctsp on ctsp.MaSize = s.MaSize where MaSP = ? order by s.ten asc";

    @Override
    public int insert(Size entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Size entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(String key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Size> selectAll() throws SQLException {
        return selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public Size selectByID(String key) throws SQLException {
        List<Size> list = selectBySQL(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Size> selectBySQL(String sql, Object... args) throws SQLException {
        List<Size> list = new ArrayList<>();
        ResultSet rs = JDBCHelper.query(sql, args);
        while (rs.next()) {
            Size entity = new Size();
            entity.setMaSize(rs.getString("maSize"));
            entity.setTen(rs.getString("Ten"));
            list.add(entity);
        }

        rs.getStatement().getConnection().close();
        return list;

    }
    
    public String getTen(String key){
        try {
            return selectByID(key).getTen();
        } catch (SQLException ex) {
            throw new Error();
        }
    }
    
    public String getMa(String key){
        try {
            List<Size> list = selectBySQL(SELECT_BY_NAME_SQL, key);
            if (list.isEmpty()) {
                return null;
            }
            return list.get(0).getMaSize();
        } catch (SQLException ex) {
            throw new Error();
        }
    }
    
    public List<Size> getDistinctMauByMaSP(String MaSP) {
        try {
            return selectBySQL(SELECT_ALL_BY_MASP,MaSP);
        } catch (SQLException ex) {
            throw new Error(ex);
        }
    }

}
