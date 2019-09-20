package com.ef.util;

import com.ef.entities.ParamModel;
import org.springframework.boot.ApplicationArguments;

import java.util.Date;
import java.util.List;

/**
 * @author Ariel Morel
 */
public class ParserParamUtil {

    public static ParamModel  parserParams(ApplicationArguments args){
        ParamModel pm=new ParamModel();

        //startDate param
        String startDate = getSingleValueExist(args.getOptionValues("startDate"));
        Date date = DateConvertUtil.convertDate(startDate);
        if(date!=null){
            pm.setStartDate(date);
        }

        //duration param
        String duration = getSingleValueExist(args.getOptionValues("duration"));
        if(duration!=null){
            pm.setDuration(duration);
        }

        //threshold param
        String threshold = getSingleValueExist(args.getOptionValues("threshold"));
        if(threshold!=null &&  isNumeric(threshold)){
            pm.setThreshold(Long.parseLong(threshold));
        }
        //accesslog param
        String accesslog = getSingleValueExist(args.getOptionValues("accesslog"));
        if(accesslog!=null){
            pm.setAccesslog(accesslog);
        }

        return pm;
    }


    private static String getSingleValueExist(List<String> list){
        if(list!=null && list.size()>0){
            return list.get(0);
        }
        return null;
    }

    /**
     * validate if a string is numeric
     * @param strNum
     * @return boolean value
     */
    private static boolean isNumeric(String strNum) {
        try {
            Long.parseLong(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

}
