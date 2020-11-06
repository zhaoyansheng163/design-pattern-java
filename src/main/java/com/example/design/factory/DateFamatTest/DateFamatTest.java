package com.example.design.factory.DateFamatTest;

import java.util.Date;
import java.text.DateFormat;

/**
 * 格式化时间类 DateFormat.FULL = 0 DateFormat.DEFAULT = 2 DateFormat.LONG = 1
 * DateFormat.MEDIUM = 2 DateFormat.SHORT = 3
 */

// DateFormat getDateInstance();考虑为什么是能返回自己，虽然DateFormat是抽象类但getDateInstance()中返回的是子类的实例。
public class DateFamatTest {
    public static void main(String[] args) {
        Date d = new Date();
        String s;

        /** Date类的格式: Sat Apr 16 13:17:29 CST 2006 */
        System.out.println(d);

        System.out.println("******************************************");

        /** getDateInstance() */
        /** 输出格式: 2006-4-16 */
        s = DateFormat.getDateInstance().format(d);
        System.out.println(s);

        /** 输出格式: 2006-4-16 */
        s = DateFormat.getDateInstance(DateFormat.DEFAULT).format(d);
        System.out.println(s);

        /** 输出格式: 2006年4月16日 星期六 */
        s = DateFormat.getDateInstance(DateFormat.FULL).format(d);
        System.out.println(s);

        /** 输出格式: 2006-4-16 */
        s = DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
        System.out.println(s);

        /** 输出格式: 06-4-16 */
        s = DateFormat.getDateInstance(DateFormat.SHORT).format(d);
        System.out.println(s);

        /** 输出格式: 2006-01-01 00:00:00 */
        java.text.DateFormat format1 = new java.text.SimpleDateFormat(
                "yyyy-MM-dd hh:mm:ss");
        s = format1.format(new Date());
        System.out.println(s);

        /** 输出格式: 2006-01-01 01:00:00 */
        System.out.println((new java.text.SimpleDateFormat(
                "yyyy-MM-dd hh:mm:ss")).format(new Date()));

        /** 输出格式: 2006-01-01 13:00:00 */
        System.out.println((new java.text.SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss")).format(new Date()));

        /** 输出格式: 20060101000000 ***/
        java.text.DateFormat format2 = new java.text.SimpleDateFormat(
                "yyyyMMddhhmmss");
        s = format2.format(new Date());
        System.out.println(s);
    }
}

//
//attention:注意下，月份是从0开始的，要Calendar.MONTH+1才可以的
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(new Date());
//        System.out.println("System   Date:   " + cal.get(Calendar.MONTH + 1));