package com.ef;

import com.ef.entities.Comment;
import com.ef.entities.LogModel;
import com.ef.entities.ParamModel;
import com.ef.services.CommentServiceImpl;
import com.ef.services.ICommentService;
import com.ef.services.ILogService;
import com.ef.services.LogServiceImpl;
import com.ef.util.ParserParamUtil;
import com.ef.util.ReadFileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Ariel Morel
 */
@Component
class AppInitialization {
    private static final Logger log = LoggerFactory.getLogger(AppInitialization.class);
    @Autowired
    private ILogService logServiceImpl;
    @Autowired
    private ICommentService commentServiceImpl;

    private final ParamModel paramModel;

    @Autowired
    private AppInitialization(ApplicationArguments args) {
        paramModel = ParserParamUtil.parserParams(args);
    }

    @PostConstruct
    private void init() {
        if(paramModel!=null) {
            List<LogModel> logModels = ReadFileUtil.readFile(paramModel.getAccesslog());
            logServiceImpl.cleanDataBase();
            logServiceImpl.saveLog(logModels);
            List<LogModel> logModelList = logServiceImpl.findByRequestThresHold(paramModel);
            for (LogModel model : logModelList) {
                StringBuilder message = new StringBuilder();
                message.append("IP: ")
                        .append(model.getIp())
                        .append(" blocked by make more than: ")
                        .append(" in ")
                        .append(paramModel.getDuration())
                        .append(" frequency");

                commentServiceImpl.saveComment(new Comment(model.getIp(), message.toString()));
                log.info(message.toString());
            }
        }
    }
}
