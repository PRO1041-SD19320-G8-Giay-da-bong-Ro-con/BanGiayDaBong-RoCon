/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utils;

import java.text.DecimalFormat;

/**
 *
 * @author Thai
 */
public class TextUtil {

    static DecimalFormat df = new DecimalFormat("###,###");

    public static String round(Object number) {
        long str = Math.round((double) number);
        return df.format(str).replace(',', '.');
    }

    public static boolean isNAN(String str) {
        return !str.matches("[0-9]+");
    }
    
    public static boolean isName(String str){
        return str.toUpperCase().matches("[A-ZẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴ ]+");
    }
}
