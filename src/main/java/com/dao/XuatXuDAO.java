/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.entity.XuatXu;
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
public class XuatXuDAO  implements DAOInterface<XuatXu, String> {

    String SELECT_NAME_BY_ID_SQL = "Select ten from Xuat_Xu where MaXuatXu = ?";
    String SELECT_ALL_SQL = "select * from Xuat_Xu";
    String SELECT_BY_ID_SQL = "select * from Xuat_Xu where MaXuatXu = ?";

    @Override
    public int insert(XuatXu entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(XuatXu entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(String key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<XuatXu> selectAll() throws SQLException {
        return selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public XuatXu selectByID(String key) throws SQLException {
        List<XuatXu> list = selectBySQL(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<XuatXu> selectBySQL(String sql, Object... args) throws SQLException {
        List<XuatXu> list = new ArrayList<>();
        ResultSet rs = JDBCHelper.query(sql, args);
        while (rs.next()) {
            XuatXu entity = new XuatXu();
            entity.setMaXuatXu(rs.getString("MaXuatXu"));
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