package br.com.slotshop.server.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String format(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(date);
    }

    public static String formatDateWithMonthText(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd ' de ' MMMM ' de ' yyyy ' as ' HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    public static java.sql.Date formatToDate(String stringDate) throws Exception {
        if (stringDate == null || stringDate.equals(""))
            return null;
        java.sql.Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = new java.sql.Date( ((java.util.Date)formatter.parse(stringDate)).getTime() );
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }

}
