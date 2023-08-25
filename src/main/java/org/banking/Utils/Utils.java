package org.banking.Utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {
    static NumberFormat formatingValue = new DecimalFormat("R$ #,##0.00");

    public static String dubleToString(Double value) {
        return formatingValue.format(value);
    }

    /// public static void Clear() {
        // System.out.print("\033[H\033[2J");
        // System.out.flush();
    // }
}