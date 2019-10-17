package config;

import java.text.ParseException;
import java.util.Date;

public interface ConfigMapService {
    void reload();

//    Config get(String var1);

    String getValue(String var1);

    String getValue(String var1, String var2);

    Boolean getBooleanValue(String var1);

    Boolean getBooleanValue(String var1, Boolean var2);

    Integer getIntegerValue(String var1);

    Integer getIntegerValue(String var1, Integer var2);

    Long getLongValue(String var1);

    Long getLongValue(String var1, Long var2);

    Float getFloatValue(String var1);

    Float getFloatValue(String var1, Float var2);

    Double getDoubleValue(String var1);

    Double getDoubleValue(String var1, Double var2);

    Date getDateValue(String var1) throws ParseException;

    Date getDateValue(String var1, Date var2) throws ParseException;

//    void addListener(ConfigChangeListener var1);
//
//    void removeListener(ConfigChangeListener var1);
}
