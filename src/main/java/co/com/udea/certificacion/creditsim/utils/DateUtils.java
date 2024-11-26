package co.com.udea.certificacion.creditsim.utils;

import java.util.HashMap;
import java.util.Map;

public class DateUtils {

    private static final Map<String, String> MONTH_MAP = new HashMap<>();

    static {
        MONTH_MAP.put("1", "ENE");
        MONTH_MAP.put("2", "FEB");
        MONTH_MAP.put("3", "MAR");
        MONTH_MAP.put("4", "ABR");
        MONTH_MAP.put("5", "MAY");
        MONTH_MAP.put("6", "JUN");
        MONTH_MAP.put("7", "JUL");
        MONTH_MAP.put("8", "AGO");
        MONTH_MAP.put("9", "SEP");
        MONTH_MAP.put("10", "OCT");
        MONTH_MAP.put("11", "NOV");
        MONTH_MAP.put("12", "DIC");
    }

    public static String convertToAbbreviatedMonthDate(String date) {
        String[] parts = date.split("/");

        String day = parts[0];
        String month = parts[1];
        String year = parts[2];

        String monthAbbr = MONTH_MAP.get(month);

        return day + "/" + monthAbbr + "/" + year;
    }

}
