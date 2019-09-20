package com.ef.services;

import com.ef.entities.LogModel;
import com.ef.entities.ParamModel;

import java.util.List;

/**
 * @author Ariel Morel
 */
interface LogService {


    /**
     * @param paramModel
     * @return List<LogModel>
     */
    List<LogModel> findByRequestThresHold(ParamModel paramModel);

    /**
     * save a list of LogModel
     * @param list
     */
    void saveLog(List<LogModel> list);

    /**
     * truncate the table from database
     */
    void cleanDataBase();
}
