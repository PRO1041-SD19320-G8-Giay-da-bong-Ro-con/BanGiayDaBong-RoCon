/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utils;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author FPT SHOP
 */
public class XImage {

    public static ImageIcon resize(ImageIcon imgIcon, JLabel lbl) {
        Image img = imgIcon.getImage();
        return new ImageIcon(img.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH));
    }

    public static ImageIcon readImage(String name) {
        return new ImageIcon(XImage.class.getResource("/img/" + name).getPath());
    }

    public static boolean saveImage(File from) {
        try {
            File to = new File(XImage.class.getResource("/img/").getPath()+from.getName());
            if (to.getParentFile().exists()) {
                to.getParentFile().mkdir();
            }
            Files.copy(from.toPath(), to.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception e) {
            Logger.getLogger(XImage.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    public static Image getAppIcon() {
//        URL url = XImage.class.getResource("/main/java/img/logo.png");
//        return new ImageIcon(url).getImage();
//    }
//
//    public static boolean saveImage(File src) {
//        File fl = new File("src\\main\\java\\img\\", src.getName());
//        if (!fl.getParentFile().exists()) {
//            // tạo thu mục 
//            fl.getParentFile().mkdirs();
//        }
//        try {
//            Path from = Paths.get(src.getAbsolutePath());
//            Path to = Paths.get(fl.getAbsolutePath());
//            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//     public static ImageIcon readImage(String nameFile) {
//         File path = new File("src\\main\\java\\img\\",nameFile);
//         return new ImageIcon(path.getAbsolutePath());
//     }
