/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.util.List;
import javax.swing.text.AsyncBoxView;
import model.ChiTietSanPham;
import model.MauSac;
import model.SanPham;
import model.Size;
import responsitory.BanHang_Respo;

/**
 *
 * @author Admin
 */
public class BanHang_Ser {
    BanHang_Respo banHangrepo = new BanHang_Respo();
    
    public List<ChiTietSanPham> getAllSanPham() {
        return banHangrepo.getAllSanPham();
    }
    
    public int updateSoLuongSP(ChiTietSanPham ctsp,int soLuong){
        return banHangrepo.updateSoLuongSP(ctsp, soLuong);    
    }
    
    public List<ChiTietSanPham> getSanPhamTheoGia(Double gia) {
        return banHangrepo.getSanPhamTheoGia(gia);
    }
    
    public List<MauSac> getMauSac() {
        return banHangrepo.getMauSac();
    }
    
    public List<ChiTietSanPham> getSanPhamTheoMau(String mau) {
        return banHangrepo.getSanPhamTheoMau(mau);
    }
    public List<ChiTietSanPham> getSanPhamTheoThuongHieu(String ma) {
        return banHangrepo.getSanPhamTheoThuongHieu(ma);
    }
    
    public List<Size> getSize() {
        return banHangrepo.getSize();
    }
    
    public List<ChiTietSanPham> getSanPhamTheoSize(String ma) {
        return banHangrepo.getSanPhamTheoSize(ma);
    }
    
}
