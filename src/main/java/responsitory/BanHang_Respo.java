/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitory;

import com.utils.DBConnect;
import com.utils.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.SanPham;

/**
 *
 * @author Admin
 */
public class BanHang_Respo {
    
    public List<SanPham> getAllSanPham() {
        List<SanPham> lst = new ArrayList<>();
        ResultSet rs = null;
        String sql = """
                    SELECT SAN_PHAM.MaSP, SAN_PHAM.TenSP, THUONG_HIEU.Ten, LOAI_GIAY.Ten AS Expr1, XUAT_XU.Ten AS Expr2, CHAT_LIEU.Ten AS Expr3, SAN_PHAM.Gia, SIZE.Ten AS Expr4, MAU_SAC.Ten AS Expr5, CHI_TIET_SAN_PHAM.SoLuong
                    FROM     MAU_SAC INNER JOIN
                                      CHI_TIET_SAN_PHAM ON MAU_SAC.MaMau = CHI_TIET_SAN_PHAM.MaMau INNER JOIN
                                      SAN_PHAM ON CHI_TIET_SAN_PHAM.MaSP = SAN_PHAM.MaSP INNER JOIN
                                      LOAI_GIAY ON SAN_PHAM.MaLoai = LOAI_GIAY.MaLoai INNER JOIN
                                      CHAT_LIEU ON SAN_PHAM.MaChatLieu = CHAT_LIEU.MaChatLieu INNER JOIN
                                      SIZE ON CHI_TIET_SAN_PHAM.MaSize = SIZE.MaSize INNER JOIN
                                      THUONG_HIEU ON SAN_PHAM.MaThuongHieu = THUONG_HIEU.MaThuongHieu INNER JOIN
                                      XUAT_XU ON SAN_PHAM.MaXuatXu = XUAT_XU.MaXuatXu
                     """;
        try {

            
            
            rs = JDBCHelper.query(sql);
            while (rs.next()) {

                lst.add(new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDouble(7),rs.getString(8),rs.getString(9),rs.getInt(10)));

            }

            return lst;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }
    
}
