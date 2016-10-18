package com.eeyes.designtemplate.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Lei Guo on 2015/8/14.
 */
public class DateUtil {






    private static SimpleDateFormat sf = null;
    /*时间戳转换成字符窜*/
     public static String getDateToString(long time) {
        Date d = new Date(time*1000);
        sf = new SimpleDateFormat("yyyy年MM月dd日");
        return sf.format(d);
        }


    public static Date stringToDate(String str) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // all done
        try {
            Date dd = format.parse(str);
            return dd;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;


    }


}
