/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;


import java.util.ArrayList;
import java.util.List;
import com.entity.KhachHang;
import com.utils.FormatDate;
import model.KhuyenMai;
import model.SanPham;
import responsitory.KhuyenMaiRepository;

/**
 *
 * @author FPT SHOP
 */
public class KhuyenMaiService {

    KhuyenMaiRepository repo = new KhuyenMaiRepository();

    public List<KhuyenMai> getAll() {
        return repo.getAll();
    }
    public List<KhuyenMai> locData() {
        return repo.locData();
    }

    public String addKM(KhuyenMai km) {
        return (km != null && repo.add(km) ? "Thêm khuyến mãi thành công" : "Thêm khuyến mãi thất bại");
    }

    public String updateKM(KhuyenMai km) {
        if (km != null) {
            repo.update(km);
            return "Sửa thành công";
        }
        return "Sửa thất bại";
    }

    public String deleteKM(String ma) {
        return (repo.delete(ma) != null ? "Xóa thành công" : "xóa thất bại");
    }

    public List<KhuyenMai> timSP(String key) {
        List<KhuyenMai> lsts = new ArrayList<>();

        for (KhuyenMai km : repo.getAll()) {
            if (km.getMaKM().toUpperCase().contains(key.toUpperCase()) || km.getTenKM().toUpperCase().contains(key.toUpperCase())) {
                lsts.add(km);
            }
        }
        return lsts;
    }
    public List<KhuyenMai> timSPLoc(String key) {
        List<KhuyenMai> lsts = new ArrayList<>();

        for (KhuyenMai km : repo.locData()) {
            if (km.getMaKM().toUpperCase().contains(key.toUpperCase()) || km.getTenKM().toUpperCase().contains(key.toUpperCase())) {
                lsts.add(km);
            }
        }
        return lsts;
    }
//    public List<KhuyenMai> locSP(String key) {
//        List<KhuyenMai> lsts = new ArrayList<>();
//
//        for (KhuyenMai km : repo.getAll()) {
//            if () {
//                lsts.add(km);
//            }
//        }
//        return lsts;
//    }
   

}
