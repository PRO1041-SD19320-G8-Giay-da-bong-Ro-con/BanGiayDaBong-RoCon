/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.utils.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.entity.LoaiGiay;

/**
 *
 * @author Thai
 */
public class LoaiGiayDAO  implements DAOInterface<LoaiGiay, String> {

    String SELECT_NAME_BY_ID_SQL = "Select ten from LOAI_GIAY where maLoai = ?";
    String SELECT_ALL_SQL = "select * from LOAI_GIAY";
    String SELECT_BY_ID_SQL = "select * from LOAI_GIAY where maLoai = ?";

    @Override
    public int insert(LoaiGiay entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(LoaiGiay entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(String key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<LoaiGiay> selectAll() throws SQLException {
        return selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public LoaiGiay selectByID(String key) throws SQLException {
        List<LoaiGiay> list = selectBySQL(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<LoaiGiay> selectBySQL(String sql, Object... args) throws SQLException {
        List<LoaiGiay> list = new ArrayList<>();
        ResultSet rs = JDBCHelper.query(sql, args);
        while (rs.next()) {
            LoaiGiay entity = new LoaiGiay();
            entity.setMaLoai(rs.getString("maLoai"));
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

}
