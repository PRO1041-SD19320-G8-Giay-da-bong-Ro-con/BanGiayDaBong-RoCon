/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Thai
 */
public class FormatDate {

    static SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");

    public static String toString(Date date) {
        return formater.format(date);
    }

    public static Date toDate(String date) {
        try {
            return formater.parse(date);
        } catch (ParseException ex) {
            throw new Error("Lỗi format toDate");
        }
    }

    public static boolean isValidDate(String dateText) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        try {
            Date date = sdf.parse(dateText);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
