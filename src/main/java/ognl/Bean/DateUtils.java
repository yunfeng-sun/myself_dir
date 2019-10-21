package ognl.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static double PI = 3.141535323;
    public static String getTime(){

        return  new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }
    public static String echo(String str){

        return  str;
    }
}
