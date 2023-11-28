/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.util.List;
import model.KhuyenMai;
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
}
