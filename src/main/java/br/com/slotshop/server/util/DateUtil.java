package br.com.slotshop.server.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String formatDateWithMonthText(Date date) {

/*        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd M yyyy");*/
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE ' dia 'dd ' de ' MMMM ' de ' yyyy ' as ' HH:MM:ss");
        return simpleDateFormat.format(date);


    }

}
