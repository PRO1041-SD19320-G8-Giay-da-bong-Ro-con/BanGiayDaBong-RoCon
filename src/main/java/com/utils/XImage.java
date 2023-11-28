/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utils;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author FPT SHOP
 */
public class XImage {

//    public static Image getAppIcon() {
//        URL url = XImage.class.getResource("/main/java/img/logo.png");
//        return new ImageIcon(url).getImage();
//    }

    public static boolean saveImage(File src) {
        File fl = new File("src\\main\\java\\img\\", src.getName());
        if (!fl.getParentFile().exists()) {
            // tạo thu mục 
            fl.getParentFile().mkdirs();
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(fl.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
     public static ImageIcon readImage(String nameFile) {
         File path = new File("src\\main\\java\\img\\",nameFile);
         return new ImageIcon(path.getAbsolutePath());
     }
}
