/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.util.List;
import com.entity.KhachHang;
import responsitory.KhachHangRepository;

/**
 *
 * @author FPT SHOP
 */
public class KhachHangService {

    private KhachHangRepository repo = new KhachHangRepository();

    public List<KhachHang> getAll() {
        return repo.getAll();
    }

    public KhachHang getOne(String ma) {
        return repo.getOne(ma);
    }

    public String addKH(KhachHang kh) {
        return (kh != null && repo.add(kh) ? "Thêm khách hàng thành công" : "Thêm khách hàng thất bại");
    }

    public String updateKH(KhachHang kh) {
        if (kh != null) {
            repo.update(kh);
            return "Sửa thành công";
        }
        return "Sửa thất bại";
    }
}
