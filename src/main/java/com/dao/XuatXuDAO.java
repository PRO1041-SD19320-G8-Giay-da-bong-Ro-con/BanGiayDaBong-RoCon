/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.entity.ChatLieu;
import com.entity.XuatXu;
import com.utils.DBConnect;
import com.utils.JDBCHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    String SELECT_BY_NAME_SQL = "select * from Xuat_Xu where ten = ?";
    String TEN_TO_MA = "Select MaXuatXu from Xuat_Xu where ten = ?";

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
    public XuatXu selectByTEN(String key) throws SQLException {
        List<XuatXu> list = selectBySQL(SELECT_BY_NAME_SQL, key);
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
    
    public String getMa(String ten){
        try {
            return JDBCHelper.value(TEN_TO_MA, ten).toString();
        } catch (SQLException ex) {
            throw new Error();
        }
    }
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    public List<XuatXu> getALL(){
        sql="select * from Xuat_Xu";
        List<XuatXu> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps= con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                XuatXu th = new XuatXu(rs.getString(1), rs.getString(2));
                list.add(th);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public int add(XuatXu th){
        sql="insert into Xuat_Xu (MaXuatXu,Ten) values(?,?)";
        try {
           con = DBConnect.getConnection();
            ps= con.prepareStatement(sql);
            ps.setObject(1, th.getMa());
            ps.setObject(2, th.getTen());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int updatee(XuatXu th,String ma){
        sql="update Xuat_Xu set MaXuatXu= ?,Ten=? where MaXuatXu =?";
        try {
           con = DBConnect.getConnection();
            ps= con.prepareStatement(sql);
            ps.setObject(1, th.getMa());
            ps.setObject(2, th.getTen());
            ps.setObject(3, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
