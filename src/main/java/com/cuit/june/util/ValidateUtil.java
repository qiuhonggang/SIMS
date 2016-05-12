package com.cuit.june.util;

import java.util.Collection;

/**
 * Created by qhg on 16/4/26.
 */
public class ValidateUtil {
    public static boolean isNull(Collection list) {
        if (list == null || list.isEmpty())
            return true;
        return false;
    }

    public static boolean isNull(String str) {
        if (str == null || "".equals(str.trim()))
            return true;
        return false;
    }

    public static boolean isNull(Object[] values) {
        if (values == null || values.length <= 0)
            return true;
        return false;
    }
}
