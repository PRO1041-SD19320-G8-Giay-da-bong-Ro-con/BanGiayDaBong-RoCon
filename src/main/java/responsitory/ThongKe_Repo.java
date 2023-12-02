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
                     {CALL SP_DOANH_THU}
                     """;
        String col[] = {"Thang", "Nam", "DoanhThu"};
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
    
    public List<ChiTietSanPham> getAllSanPhamSapHet() {
        List<ChiTietSanPham> lst = new ArrayList<>();
        ResultSet rs = null;
        String sql = """
                    SELECT CHI_TIET_SAN_PHAM.MaCTSP, CHI_TIET_SAN_PHAM.MaSP, SAN_PHAM.TenSP, THUONG_HIEU.Ten, LOAI_GIAY.Ten AS Expr1, XUAT_XU.Ten AS Expr2, CHAT_LIEU.Ten AS Expr3, SAN_PHAM.Gia, SIZE.Ten AS Expr4, MAU_SAC.Ten AS Expr5, CHI_TIET_SAN_PHAM.SoLuong
                    FROM     MAU_SAC INNER JOIN
                                      CHI_TIET_SAN_PHAM ON MAU_SAC.MaMau = CHI_TIET_SAN_PHAM.MaMau INNER JOIN
                                      SAN_PHAM ON CHI_TIET_SAN_PHAM.MaSP = SAN_PHAM.MaSP INNER JOIN
                                      LOAI_GIAY ON SAN_PHAM.MaLoai = LOAI_GIAY.MaLoai INNER JOIN
                                      CHAT_LIEU ON SAN_PHAM.MaChatLieu = CHAT_LIEU.MaChatLieu INNER JOIN
                                      SIZE ON CHI_TIET_SAN_PHAM.MaSize = SIZE.MaSize INNER JOIN
                                      THUONG_HIEU ON SAN_PHAM.MaThuongHieu = THUONG_HIEU.MaThuongHieu INNER JOIN
                                      XUAT_XU ON SAN_PHAM.MaXuatXu = XUAT_XU.MaXuatXu
                     where CHI_TIET_SAN_PHAM.SoLuong < 5
                     """;
        try {

            rs = db.JDBCHelper.excuteQuery(sql);
            while (rs.next()) {

                lst.add(new ChiTietSanPham(rs.getString(1), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDouble(8)));

            }

            return lst;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }
    
}
