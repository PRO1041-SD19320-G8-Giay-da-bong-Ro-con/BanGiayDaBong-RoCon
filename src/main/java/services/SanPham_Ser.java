/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.util.ArrayList;
import java.util.List;
import model.SanPham;
import responsitory.SanPham_Respo;

/**
 *
 * @author Admin
 */
public class SanPham_Ser {

    SanPham_Respo sanPhamRepo = new SanPham_Respo();

    public List<SanPham> getAllData() {
        return sanPhamRepo.getAllData();
    }

    public List<SanPham> getSanPhamTheoGia(String gia) {
        return sanPhamRepo.getSanPhamTheoGia(gia);
    }

    public String addSP(SanPham sp) {
        return (sp != null && sanPhamRepo.add(sp) ? "Thêm thành công" : "Thêm thất bại");
    }

    public String updateSp(SanPham sp) {
        if (sp != null) {
            sanPhamRepo.update(sp);
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    public List<SanPham> timSP(String ma) {
        List<SanPham> lsts = new ArrayList<>();
        for (SanPham sp : sanPhamRepo.getAllData()) {
            if (sp.getTenSP().equalsIgnoreCase(ma)) {
                lsts.add(sp);
            }
        }
        return lsts;
    }

}
