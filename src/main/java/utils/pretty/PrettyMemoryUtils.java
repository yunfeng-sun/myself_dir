package utils.pretty;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrettyMemoryUtils {
    private static final Logger logger = LoggerFactory.getLogger(PrettyMemoryUtils.class);
    private static final int UNIT = 1024;

    public PrettyMemoryUtils() {
    }

    public static String prettyByteSize(long byteSize) {
        double size = 1.0D * (double)byteSize;
        String type = "B";
        if ((int)Math.floor(size / 1024.0D) <= 0) {
            type = "B";
            return format(size, type);
        } else {
            size /= 1024.0D;
            if ((int)Math.floor(size / 1024.0D) <= 0) {
                type = "KB";
                return format(size, type);
            } else {
                size /= 1024.0D;
                if ((int)Math.floor(size / 1024.0D) <= 0) {
                    type = "MB";
                    return format(size, type);
                } else {
                    size /= 1024.0D;
                    if ((int)Math.floor(size / 1024.0D) <= 0) {
                        type = "GB";
                        return format(size, type);
                    } else {
                        size /= 1024.0D;
                        if ((int)Math.floor(size / 1024.0D) <= 0) {
                            type = "TB";
                            return format(size, type);
                        } else {
                            size /= 1024.0D;
                            if ((int)Math.floor(size / 1024.0D) <= 0) {
                                type = "PB";
                                return format(size, type);
                            } else {
                                return ">PB";
                            }
                        }
                    }
                }
            }
        }
    }

    private static String format(double size, String type) {
//        int precision = false;
        byte precision;
        if (size * 1000.0D % 10.0D > 0.0D) {
            precision = 3;
        } else if (size * 100.0D % 10.0D > 0.0D) {
            precision = 2;
        } else if (size * 10.0D % 10.0D > 0.0D) {
            precision = 1;
        } else {
            precision = 0;
        }

        String formatStr = "%." + precision + "f";
        if ("KB".equals(type)) {
            return String.format(formatStr, size) + "KB";
        } else if ("MB".equals(type)) {
            return String.format(formatStr, size) + "MB";
        } else if ("GB".equals(type)) {
            return String.format(formatStr, size) + "GB";
        } else if ("TB".equals(type)) {
            return String.format(formatStr, size) + "TB";
        } else {
            return "PB".equals(type) ? String.format(formatStr, size) + "PB" : String.format(formatStr, size) + "B";
        }
    }

    public static void main(String[] args) {
        logger.debug(prettyByteSize(1023L));
        logger.debug(prettyByteSize(1024L));
        logger.debug(prettyByteSize(1048576L));
        logger.debug(prettyByteSize(1047552L));
        logger.debug(prettyByteSize(1070599167L));
        logger.debug(prettyByteSize(1073741824L));
        logger.debug(prettyByteSize(1099511627776L));
        logger.debug(prettyByteSize(1125899906842624L));
        logger.debug(prettyByteSize(1152921504606846976L));
    }
}
