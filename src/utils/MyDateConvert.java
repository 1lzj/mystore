package utils;

import org.apache.commons.beanutils.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: 你微笑时很美
 * @Date: 2018/9/19 18:07
 * @Description:日期格式转换器
 */
public class MyDateConvert implements Converter {

    @Override
    public Object convert(Class aClass, Object o) {
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sim.parse(o + "");
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
