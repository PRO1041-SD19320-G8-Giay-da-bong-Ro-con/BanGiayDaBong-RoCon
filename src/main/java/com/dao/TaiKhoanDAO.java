/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;
import java.sql.*;
import com.entity.TaiKhoan;
import com.ui.DialogDangNhap;
import com.utils.DBConnect;
import com.utils.JDBCHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Thai
 */
public class TaiKhoanDAO implements DAOInterface<TaiKhoan, String> {

    String UPDATE_ThongTin_SQL = "UPDATE Tai_khoan SET ten = ? , ngaysinh = ?, sdt = ?, email = ? WHERE TaiKhoan = ?";
    String UPDATE_TaiKhoan_SQL = "UPDATE Tai_khoan SET matKhau = ? WHERE TaiKhoan = ?";
    String SELECT_ALL_SQL = "select * from Tai_khoan";
    String SELECT_BY_ID_SQL = "select * from Tai_khoan where taiKhoan = ?";
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    
    @Override
    public int insert(TaiKhoan entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(TaiKhoan entity) throws SQLException {
        return JDBCHelper.update(UPDATE_ThongTin_SQL, entity.getTen(), entity.getNgaysinh(), entity.getSdt(), entity.getEmail(), entity.getTaikhoan());
    }
    public int update(String matKhau, String taiKhoan) throws SQLException {
        return JDBCHelper.update(UPDATE_TaiKhoan_SQL, matKhau, taiKhoan);
    }

    @Override
    public int delete(String key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<TaiKhoan> selectAll() throws SQLException {
        return selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public TaiKhoan selectByID(String key) throws SQLException {
        List<TaiKhoan> list = selectBySQL(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<TaiKhoan> selectBySQL(String sql, Object... args) throws SQLException {
        List<TaiKhoan> list = new ArrayList<>();
        ResultSet rs = JDBCHelper.query(sql, args);
        while (rs.next()) {
            TaiKhoan entity = new TaiKhoan();
            entity.setTaikhoan(rs.getString("taiKhoan"));
            entity.setMatkhau(rs.getString("matkhau"));
            entity.setTen(rs.getString("ten"));
            entity.setNgaysinh(rs.getDate("ngaysinh"));
            entity.setSdt(rs.getString("sdt"));
            entity.setEmail(rs.getString("email"));
            entity.setCCCD(rs.getString("CCCD"));
            entity.setChucvu(rs.getBoolean("chucVu"));

            list.add(entity);
        }
        rs.getStatement().getConnection().close();
        return list;
    }
    public static boolean checkLogin(String username, String password) {
        int row = 0;
        try {
            Connection con = DBConnect.getConnection();
            Statement stm = con.createStatement();
            String sql = "select TaiKhoan,MatKhau,Ten,NgaySinh,SDT,Email,CCCD,ChucVu from TAI_KHOAN where TaiKhoan = '"+username+"' and MatKhau='"+ password+"'";
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                row = 1;
                String tk = rs.getString(1);
                String mk = rs.getString(2);
                String ten = rs.getString(3);
                Date ngaysinh = rs.getDate(4);
                String sdt = rs.getString(5);
                String email = rs.getString(6);
                String cccd = rs.getString(7);
                boolean chucvu = rs.getBoolean(8);
                DialogDangNhap.taikhoan = new TaiKhoan(tk, mk, ten, ngaysinh, sdt, email, cccd, chucvu);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return (row>0);
    }
    public int updatemk(TaiKhoan tk, String taikhoan){
       String sql="update TAI_KHOAN set MatKhau=? where TaiKhoan=?";
        try {
           Connection con = DBConnect.getConnection();
            PreparedStatement  ps = con.prepareStatement(sql);          
            ps.setObject(1, tk.getMatkhau());                      
            ps.setObject(2, taikhoan);
            return  ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int updatee(TaiKhoan tk, String taikhoan){
       String sql="update TAI_KHOAN set TaiKhoan=?,Ten=?,NgaySinh=?,SDT=?,Email=?,CCCD=?,ChucVu=? where TaiKhoan=?";
        try {
           Connection con = DBConnect.getConnection();
            PreparedStatement  ps = con.prepareStatement(sql);          
            ps.setObject(1, tk.getTaikhoan());
            ps.setObject(2, tk.getTen());
            ps.setObject(3, tk.getNgaysinh());
            ps.setObject(4, tk.getSdt());
            ps.setObject(5, tk.getEmail());
            ps.setObject(6, tk.getCCCD());
            ps.setObject(7, tk.isChucvu());
            ps.setObject(8, taikhoan);
            return  ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public List<TaiKhoan> getall(){
        sql="select TaiKhoan,MatKhau,Ten,NgaySinh,SDT,Email,CCCD,ChucVu from TAI_KHOAN";
        List<TaiKhoan> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs =ps.executeQuery();
            while (rs.next()) {                
                TaiKhoan tk = new TaiKhoan(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getBoolean(8));
                list.add(tk);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public int add(TaiKhoan tk){
        sql="insert into TAI_KHOAN (TaiKhoan,MatKhau,Ten,NgaySinh,SDT,Email,CCCD,ChucVu) values(?,?,?,?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps= con.prepareStatement(sql);
            ps.setObject(1, tk.getTaikhoan());
            ps.setObject(2, tk.getMatkhau());
            ps.setObject(3, tk.getTen());
            ps.setObject(4, tk.getNgaysinh());
            ps.setObject(5, tk.getSdt());
            ps.setObject(6, tk.getEmail());
            ps.setObject(7, tk.getCCCD());
            ps.setObject(8, tk.isChucvu());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int xoa(String taikhoan){
        sql="delete from TAI_KHOAN where TaiKhoan =?";
        try {
           con = DBConnect.getConnection();
            ps= con.prepareStatement(sql);
            ps.setObject(1, taikhoan);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
