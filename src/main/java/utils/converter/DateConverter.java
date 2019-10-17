package utils.converter;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.struts2.util.StrutsTypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class DateConverter extends StrutsTypeConverter {
    private static final Logger logger = LoggerFactory.getLogger(DateConverter.class);
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String[] ACCEPT_DATE_FORMATS = new String[]{"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd", "yyyy-MM"};

    public DateConverter() {
    }

    public Object convertFromString(Map context, String[] values, Class toClass) {
        if(logger.isDebugEnabled()){
            logger.debug("converFromString");
            if(values != null){
                logger.debug("convert from : "+ values[0]);
            }
        }

        if (values != null && values[0] != null && !values[0].trim().equals("")) {
            String dateStr = values[0];
            dateStr = dateStr.replace("T", " ");

            try {
                System.out.println(DateUtils.parseDate(dateStr, ACCEPT_DATE_FORMATS) + "convertFromString =====>>>");
                return DateUtils.parseDate(dateStr, ACCEPT_DATE_FORMATS);
            } catch (Exception var6) {
                logger.debug("parse date error:" + var6.getMessage());
                return null;
            }
        } else {
            return null;
        }
    }

    public String convertToString(Map context, Object o) {
        if (o instanceof Date) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            try {
                System.out.println(format.format((Date)o) + "conversion ===>>>");
                return format.format((Date)o);
            } catch (RuntimeException var5) {
                return "";
            }
        } else {
            return "";
        }
    }
}
