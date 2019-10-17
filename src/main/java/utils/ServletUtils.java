package utils;

import org.apache.commons.lang.StringUtils;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

public class ServletUtils {
    protected static final Logger logger = LoggerFactory.getLogger(ServletUtils.class);
    public static Set<String> INVALID_STRINGS = new HashSet<String>();

    public static Long getLongValue(HttpServletRequest request , String name , Long defaultValue){
        String content = getStringValue(request,name,(String)null);
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(content)) {
            try {
                return Long.valueOf(content);
            } catch (Exception var5) {
                logger.warn("Invalid http parameter: [{}], value: [{}]", name, content);
            }
        }

        return defaultValue != null ? defaultValue : null;
    }

    public static String getStringValue(HttpServletRequest request, String name, String defaultValue) {
        String content = request.getParameter(name);
        if(StringUtils.isNotEmpty(content)){
            content = content.trim();
            if(!INVALID_STRINGS.contains(content.toLowerCase())){
                if(SqlInjectDefenseUtil.checkInject(content)){
                    throw new ServiceException("Invalid http parameter: " + name + " , value: [" + content + "]");
                }
                return content;
            }
        }
        return defaultValue !=null ? defaultValue : null;
    }
}
