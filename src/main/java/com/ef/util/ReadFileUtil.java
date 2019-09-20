package com.ef.util;

import com.ef.entities.LogModel;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author Ariel Morel
 */
@Service
public class ReadFileUtil {
    private final static  org.slf4j.Logger log = LoggerFactory.getLogger(ReadFileUtil.class);
    public static List<LogModel> readFile(String path) {
        if(path==null|| path.isEmpty()){
            path="access.log";
        }
        List<LogModel> logList = null;
            try {
            ClassPathResource res = new ClassPathResource(path);
            BufferedReader in = new BufferedReader(new FileReader(res.getFile()));
            logList = new ArrayList<>();
            String str;
            while ((str = in.readLine()) != null) {
                String[] ar = str.split("\\|");
                Date  date = DateConvertUtil.inputFormatConvert(ar[0]);

                LogModel logModel = new LogModel(date, ar[1], ar[2], ar[3], ar[4]);
                logList.add(logModel);
            }
            in.close();
        } catch (IOException io) {
            log.error(io.getMessage(),io);
        }
        return logList;
    }
}
