package com.ef.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Ariel Morel
 */
public class DateConvertUtil {
    private static final Logger log = LoggerFactory.getLogger(DateConvertUtil.class);
    private final static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd.HH:mm:ss");
    private final static SimpleDateFormat otherFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    public static  Date convertDate(String dateString){
        if(dateString!=null){
            try {
                return format.parse(dateString);
            } catch (ParseException e) {
                log.error("Date " + dateString + " is not valid according to " +
                        format.toPattern() + " pattern.");
            }
        }
        return null;
    }

    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    public static Date addHours(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }


    /**
     * @param dateString yyyy-MM-dd HH:mm:ss.SSS
     * @return Date or null if a format is invalid
     */
    public static Date inputFormatConvert(String dateString){
        if(dateString!=null){
            try {
                return otherFormat.parse(dateString);
            } catch (ParseException e) {
                log.error("Date " + dateString + " is not valid according to " +
                        otherFormat.toPattern() + " pattern.");
            }
        }
        return null;
    }
}
