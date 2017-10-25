package br.com.slotshop.server.util;

public class StringUtil {

    public static String onlyNumbers(String str) {
        if (str != null) {
            return str.replaceAll("[^0123456789]", "");
        } else {
            return "";
        }
    }

}
