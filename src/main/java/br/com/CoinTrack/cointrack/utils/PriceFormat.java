package br.com.CoinTrack.cointrack.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class PriceFormat {

    public static String priceFormat(BigDecimal price) {
        DecimalFormat pattern = (DecimalFormat) NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        pattern.setMinimumFractionDigits(2);
        pattern.setMaximumFractionDigits(2);
        return pattern.format(price);
    }

}
