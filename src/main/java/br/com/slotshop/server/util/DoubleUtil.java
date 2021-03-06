package br.com.slotshop.server.util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class DoubleUtil {

    private static Locale locale = new Locale("pt", "BR");

    public static String formatRealWithSimbol(Double valor) {
        NumberFormat formato = NumberFormat.getNumberInstance(locale);
        formato.setMinimumFractionDigits(2);
        formato.setMaximumFractionDigits(2);
        return formato.getCurrency().getSymbol() + "" + formato.format(valor);
    }

}
