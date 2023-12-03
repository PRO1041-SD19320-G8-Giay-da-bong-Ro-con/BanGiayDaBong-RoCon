/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.util.List;
import model.ChiTietSanPham;
import responsitory.ThongKe_Repo;

/**
 *
 * @author Admin
 */
public class ThongKe_Ser {
    ThongKe_Repo tkRepo = new ThongKe_Repo();
    
    public List<Object[]> getDoanhThu() {
        return tkRepo.getDoanhThu();
    }
    
    public List<Object[]> getAllSanPhamSapHet() {
        return tkRepo.getAllSanPhamSapHet();
    }
    
}
