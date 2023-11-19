package bmartin127.advanced-peripherals-remastered.common.utl;

import static bmartin127.advanced-peripherals-remastered.Advancedperipherals.MODID;

public class StringUtil {
    public static String pocket(String name) {
        return String.format("pocket.%s.%s", MODID, name);
    }
}
