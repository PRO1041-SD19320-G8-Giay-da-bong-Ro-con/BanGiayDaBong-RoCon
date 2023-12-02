/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.entity.SanPham;
import com.entity.ThuongHieu;
import com.entity.XuatXu;
import com.utils.DBConnect;
import com.utils.JDBCHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Thai
 */
public class ThuongHieuDAO implements DAOInterface<ThuongHieu, String> {

    String SELECT_NAME_BY_ID_SQL = "Select ten from Thuong_hieu where maThuongHieu = ?";
    String SELECT_ALL_SQL = "select * from Thuong_hieu";
    String SELECT_BY_ID_SQL = "select * from Thuong_hieu where maThuongHieu = ?";
    String SELECT_BY_NAME_SQL = "select * from Thuong_hieu where ten = ?";
    String TEN_TO_MA = "Select maThuongHieu from Thuong_hieu where ten = ?";
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    @Override
    public int insert(ThuongHieu entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(ThuongHieu entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(String key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ThuongHieu> selectAll() throws SQLException {
        return selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public ThuongHieu selectByID(String key) throws SQLException {
        List<ThuongHieu> list = selectBySQL(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    public ThuongHieu selectByTEN(String key) throws SQLException {
        List<ThuongHieu> list = selectBySQL(SELECT_BY_NAME_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    @Override
    public List<ThuongHieu> selectBySQL(String sql, Object... args) throws SQLException {
        List<ThuongHieu> list = new ArrayList<>();
        ResultSet rs = JDBCHelper.query(sql, args);
        while (rs.next()) {
            ThuongHieu entity = new ThuongHieu();
            entity.setMaThuongHieu(rs.getString("MaThuongHieu"));
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
    public List<ThuongHieu> getALL(){
        sql="select * from THUONG_HIEU";
        List<ThuongHieu> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps= con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                ThuongHieu th = new ThuongHieu(rs.getString(1), rs.getString(2));
                list.add(th);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public int add(ThuongHieu th){
        sql="insert into THUONG_HIEU (MaThuongHieu,Ten) values(?,?)";
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
    public int updatee(ThuongHieu th,String ma){
        sql="update THUONG_HIEU set MaThuongHieu= ?,Ten=? where MaThuongHieu =?";
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
    public ThuongHieu getma(String ma){
        //truyen tham so la khoa chinh
        ThuongHieu sv = null;
        sql="select MaThuongHieu,Ten from THUONG_HIEU where MaThuongHieu=?";
        try {
           con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);//? số thứ nhất
            rs=ps.executeQuery();
            while(rs.next()){
               sv= new ThuongHieu(rs.getString(1),rs.getString(2));
            }
            return sv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
