/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitory;

import com.utils.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ChiTietSanPham;

/**
 *
 * @author Admin
 */
public class ThongKe_Repo {
    
    public List<Object[]> getDoanhThu() {
        List<Object[]> lst = new ArrayList<>() ;
        ResultSet rs = null;
        String sql = """
                     Select * from vDoanhThu order by thangNam desc
                     """;
        String col[] = {"thangNam", "Doanh Thu"};
        try {

            rs = JDBCHelper.query(sql);
            while (rs.next()) {
                Object[] values = new Object[col.length];
                for(int i = 0; i<col.length;i++){
                    values[i] = rs.getObject(col[i]);                    
                }
                lst.add(values);
            }
            return lst;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }
    
    public List<Object[]> getAllSanPhamSapHet() {
        List<Object[]> lst = new ArrayList<>() ;
        ResultSet rs = null;
        String sql = """
                     Select * from vHangSapHet
                     """;
        String col[] = {"MaCTSP","MaSP","TenSP","Mau","Size","SoLuong"};
        try {

            rs = JDBCHelper.query(sql);
            while (rs.next()) {
                Object[] values = new Object[col.length];
                for(int i = 0; i<col.length;i++){
                    values[i] = rs.getObject(col[i]);                    
                }
                lst.add(values);
            }
            return lst;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }
    
}
