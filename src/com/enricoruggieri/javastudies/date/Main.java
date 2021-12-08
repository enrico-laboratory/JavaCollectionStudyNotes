package com.enricoruggieri.javastudies.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static String formatDate(String sourceDate) throws ParseException {
        var pattern = "yyyy-MM-dd";
        var simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse(sourceDate);
        var newPattern = "EEE MM yyyy";
        var formatter = new SimpleDateFormat(newPattern);
        return formatter.format(date);
    }

    public static void main(String[] args) throws ParseException {

        System.out.println(formatDate("2021-08-09"));

    }
}
