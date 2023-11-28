/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitory;

import db.JDBCHelper;
import java.util.ArrayList;
import java.util.List;
import model.KhuyenMai;
import java.sql.ResultSet;
import java.sql.Date;

/**
 *
 * @author FPT SHOP
 */
public class KhuyenMaiRepository {

    public List<KhuyenMai> getAll() {
        List<KhuyenMai> lst = new ArrayList<>();
        String sql = """
                     SELECT * FROM KHUYEN_MAI
                     """;
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                lst.add(new KhuyenMai(rs.getString(1), rs.getString(2), rs.getString(3),rs.getBoolean(4), rs.getFloat(5), rs.getDate(6),rs.getDate(7)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
}
