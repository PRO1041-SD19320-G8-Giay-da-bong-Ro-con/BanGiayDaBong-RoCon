/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.entity.KhuyenMai;
import com.utils.JDBCHelper;
import com.utils.TextUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thai
 */
public class KhuyenMaiDAO implements DAOInterface<KhuyenMai, String> {

    String SELECT_ALL_SQL = "select * from KHUYEN_MAI";
    String SELECT_BY_ID_SQL = "select * from KHUYEN_MAI where MaKM = ?";

    @Override
    public int insert(KhuyenMai entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(KhuyenMai entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(String key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<KhuyenMai> selectAll() throws SQLException {
        return selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public KhuyenMai selectByID(String key) throws SQLException {
        List<KhuyenMai> list = selectBySQL(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<KhuyenMai> selectBySQL(String sql, Object... args) throws SQLException {
        List<KhuyenMai> list = new ArrayList<>();
        ResultSet rs = JDBCHelper.query(sql, args);
        while (rs.next()) {
            KhuyenMai entity = new KhuyenMai();
            entity.setMaKM(rs.getString("maKM"));
            entity.setTen(rs.getString("Ten"));
            entity.setNoiDung(rs.getString("NoiDung"));
            entity.setLoaiKM(rs.getBoolean("LoaiKM"));
            entity.setGiamGia(rs.getDouble("GiamGia"));
            entity.setThoiGianBatDau(rs.getDate("ThoiGianBatDau"));
            entity.setThoiGianKetThuc(rs.getDate("ThoiGianKetThuc"));
            list.add(entity);
        }

        rs.getStatement().getConnection().close();
        return list;
    }
    
    public String getDetailKhuyenMai(String maKM) {
        try {
            KhuyenMai km = selectByID(maKM);
            String detail = maKM + " (-";
            if (km.isLoaiKM()) {
                detail += km.getGiamGia() + "%";
            } else {
                detail +=TextUtil.round(km.getGiamGia());
            }

            detail += ")";
            return detail;
        } catch (Exception e) {
            return "Không áp dụng";
        }
    }

}
