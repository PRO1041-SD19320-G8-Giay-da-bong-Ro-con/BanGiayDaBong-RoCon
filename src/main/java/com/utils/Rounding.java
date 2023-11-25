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
public class Rounding {

    static DecimalFormat df = new DecimalFormat("###,###");

    public static String round(Object number) {
        long str = Math.round((double)number);
        return df.format(str).replace(',', '.');
    }
}
