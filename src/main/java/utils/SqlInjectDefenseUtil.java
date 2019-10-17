package utils;

import org.apache.commons.lang.StringUtils;

import java.util.regex.Pattern;

public class SqlInjectDefenseUtil {
    private static String reg = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|(\\b(select|update|union|and|or|delete|insert|trancate|declare|exec|create|drop|execute)\\s)";
    private static Pattern sqlPattern;

    public SqlInjectDefenseUtil() {
    }

    public static boolean checkInject(String sql) {
        if (sql != null && StringUtils.isNotEmpty(sql)) {
            return sqlPattern.matcher(sql).find();
        } else {
            return false;
        }
    }

    static {
        sqlPattern = Pattern.compile(reg, 2);
    }
}
