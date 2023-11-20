/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utils;

import java.sql.*;

/**
 *
 * @author Thai
 */
public class JDBCHelper {

    private static String server = "localhost";
    private static String user = "sa";
    private static String pass = "123";
    private static String port = "1433";
    private static String db = "PRO1041_G8_BanGiayDaBong_RoCon";
    private static String URL = "jdbc:sqlserver://" + server + ":" + port + ";databaseName=" + db + ";encrypt=true;trustServerCertificate=true;";
    private static Connection conn = null;

    static {
        try {
            conn = DriverManager.getConnection(URL, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException {
        conn = DriverManager.getConnection(URL, user, pass);
        PreparedStatement stmt;
        if (sql.trim().startsWith("{")) {
            stmt = conn.prepareCall(sql);
        } else {
            stmt = conn.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            stmt.setObject(i+1, args[i]);
        }
        return stmt;
    }

    public static ResultSet query(String sql, Object... args) throws SQLException {
        PreparedStatement stmt = getStmt(sql, args);
        return stmt.executeQuery();
    }

    public static Object value(String sql, Object... args) throws SQLException {
        ResultSet rs = query(sql, args);
        if (rs.next()) {
            return rs.getObject(1);
        }
        rs.getStatement().getConnection().close();
        return null;
    }

    public static int update(String sql, Object... args) throws SQLException {
        PreparedStatement stmt = getStmt(sql, args);
        try {
            return stmt.executeUpdate();
        } finally {
            stmt.getConnection().close();
        }
    }
}
