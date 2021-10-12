package org.chainik.utils;

public class Strings {
    public static boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }

    //TODO learn
    public static String repeat(char value, int n) {
        return new String(new char[n]).replace("\0", String.valueOf(value));
    }

    public static String zeros(int n) {
        return repeat('0', n);
    }

}
