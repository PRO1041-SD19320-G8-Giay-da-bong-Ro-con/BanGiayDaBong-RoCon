/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import com.utils.DBConnect;
import java.sql.*;


/**
 *
 * @author Admin
 */
public class JDBCHelper {

    public static ResultSet excuteQuery(String sql, Object... args) {
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        try {
            cn = DBConnect.getConnection();
            pstm = cn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pstm.setObject(i + 1, args[i]);
            }
            rs = pstm.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static Integer excuteUpdate(String sql, Object... args) {
        Connection cn = null;
        int row = 0;
        PreparedStatement pstm = null;
        try {
            cn = DBConnect.getConnection();
            pstm = cn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pstm.setObject(i + 1, args[i]);
            }
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }
     
  
    
}
