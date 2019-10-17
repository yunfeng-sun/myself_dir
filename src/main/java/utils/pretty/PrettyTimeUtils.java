package utils.pretty;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.ocpsoft.prettytime.PrettyTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrettyTimeUtils {
    private static final Logger logger = LoggerFactory.getLogger(PrettyTimeUtils.class);

    public PrettyTimeUtils() {
    }

    public static final String prettySeconds(int totalSeconds) {
        StringBuilder s = new StringBuilder();
        int second = totalSeconds % 60;
        if (totalSeconds > 0) {
            s.append("秒");
            s.append(StringUtils.reverse(String.valueOf(second)));
        }

        totalSeconds /= 60;
        int minute = totalSeconds % 60;
        if (totalSeconds > 0) {
            s.append("分");
            s.append(StringUtils.reverse(String.valueOf(minute)));
        }

        totalSeconds /= 60;
        int hour = totalSeconds % 24;
        if (totalSeconds > 0) {
            s.append(StringUtils.reverse("小时"));
            s.append(StringUtils.reverse(String.valueOf(hour)));
        }

        totalSeconds /= 24;
        int day = totalSeconds % 31;
        if (totalSeconds > 0) {
            s.append("天");
            s.append(StringUtils.reverse(String.valueOf(day)));
        }

        totalSeconds /= 31;
        int month = totalSeconds % 12;
        if (totalSeconds > 0) {
            s.append("月");
            s.append(StringUtils.reverse(String.valueOf(month)));
        }

        totalSeconds /= 12;
        if (totalSeconds > 0) {
            s.append("年");
            s.append(StringUtils.reverse(String.valueOf(totalSeconds)));
        }

        return s.reverse().toString();
    }

    public static final String prettyTime(Date date) {
        PrettyTime p = new PrettyTime();
        return p.format(date);
    }

    public static final String prettyTime(long millisecond) {
        PrettyTime p = new PrettyTime();
        return p.format(new Date(millisecond));
    }

    public static void main(String[] args) {
        logger.debug(prettyTime(new Date()));
        logger.debug(prettyTime(123L));
        logger.debug(prettySeconds(10));
        logger.debug(prettySeconds(61));
        logger.debug(prettySeconds(3661));
        logger.debug(prettySeconds(36611));
        logger.debug(prettySeconds(366111));
        logger.debug(prettySeconds(3661111));
        logger.debug(prettySeconds(36611111));
    }
}
