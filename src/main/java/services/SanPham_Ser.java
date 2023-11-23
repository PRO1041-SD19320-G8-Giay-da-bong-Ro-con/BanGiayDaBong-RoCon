/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.util.ArrayList;
import java.util.List;
import model.ChatLieu;
import model.LoaiGiay;
import model.SanPham;
import model.ThuongHieu;
import model.XuatXu;
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
    

    public List<SanPham> getSanPhamTheoThuongHieu(String ma) {
        return sanPhamRepo.getSanPhamTheoThuongHieu(ma);
    }
    
    public List<SanPham> getSanPhamTheoThuocTinh(SanPham sp) {
        return sanPhamRepo.getSanPhamTheoThuocTinh(sp);
    }
    
    public List<ChatLieu> getChatLieu() {
        return sanPhamRepo.getChatLieu();
    }
    
    public List<ThuongHieu> getThuongHieu() {
        return sanPhamRepo.getThuongHieu();
    }
    
    public List<XuatXu> getXuatXu(){
        return sanPhamRepo.getXuatXu();
    }
    
    public List<LoaiGiay> getLoai() {
        return sanPhamRepo.getLoai();
    }
    
}
