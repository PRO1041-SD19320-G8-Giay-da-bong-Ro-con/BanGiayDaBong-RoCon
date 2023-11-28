/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.entity.MauSac;
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
public class MauSacDAO implements DAOInterface<MauSac, String> {

    String SELECT_NAME_BY_ID_SQL = "Select ten from Mau_Sac where maMau = ?";
    String SELECT_ALL_SQL = "select * from Mau_Sac";
    String SELECT_BY_ID_SQL = "select * from Mau_Sac where maMau = ?";
    String SELECT_BY_NAME_SQL = "select * from Mau_Sac where Ten = ?";
    String SELECT_ALL_BY_MASP = "select distinct ms.* from MAU_SAC ms join CHI_TIET_SAN_PHAM ctsp on ctsp.MaMau = ms.MaMau where MaSP = ?";

    @Override
    public int insert(MauSac entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(MauSac entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(String key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<MauSac> selectAll() throws SQLException {
        return selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public MauSac selectByID(String key) throws SQLException {
        List<MauSac> list = selectBySQL(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<MauSac> selectBySQL(String sql, Object... args) throws SQLException {
        List<MauSac> list = new ArrayList<>();
        ResultSet rs = JDBCHelper.query(sql, args);
        while (rs.next()) {
            MauSac entity = new MauSac();
            entity.setMaMauSac(rs.getString("maMau"));
            entity.setTen(rs.getString("Ten"));
            list.add(entity);
        }

        rs.getStatement().getConnection().close();
        return list;

    }

    public List<MauSac> getDistinctMauByMaSP(String MaSP) {
        try {
            return selectBySQL(SELECT_ALL_BY_MASP,MaSP);
        } catch (SQLException ex) {
            throw new Error(ex);
        }
    }

    public String getTen(String key) {
        try {
            return selectByID(key).getTen();
        } catch (SQLException ex) {
            throw new Error();
        }
    }

    public String getMa(String key) {
        try {
            List<MauSac> list = selectBySQL(SELECT_BY_NAME_SQL, key);
            if (list.isEmpty()) {
                return null;
            }
            return list.get(0).getMaMauSac();
        } catch (SQLException ex) {
            throw new Error();
        }
    }

}
