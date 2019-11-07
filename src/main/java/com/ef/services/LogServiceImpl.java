package com.ef.services;

import com.ef.entities.LogModel;
import com.ef.entities.ParamModel;
import com.ef.repositories.LogRepository;
import com.ef.util.DateConvertUtil;
import com.ef.util.DurationEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Ariel Morel
 */
@Service
public class LogServiceImpl implements ILogService {
    @Autowired
    private LogRepository logRepository;

    @Override
    public List<LogModel> findByRequestThresHold(ParamModel paramModel) {
        Date endDate=null;
        if(paramModel.getDuration().equalsIgnoreCase(DurationEnum.DAILY.toString())) {
            endDate=DateConvertUtil.addDays(paramModel.getStartDate(),1);
        }else if(paramModel.getDuration().equalsIgnoreCase(DurationEnum.HOURLY.toString())){
            endDate=DateConvertUtil.addHours(paramModel.getStartDate(),1);
        }
        if(endDate!=null) {
            return logRepository.findByRequestThresHold(paramModel.getStartDate(), endDate, paramModel.getThreshold());
        }
        return null;
    }

    @Override
    public void saveLog(List<LogModel> list) {
        try {
            if(list!=null && !list.isEmpty()) {
                logRepository.saveAll(list);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void cleanDataBase(){
        logRepository.truncateTable();
    }



}
