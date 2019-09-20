package com.ef.entities;

import java.util.Date;

/**
 * @author Ariel Morel
 */
public class ParamModel {
    private Date startDate;
    private String duration;
    private Long  threshold;
    private String accesslog;

    public ParamModel() {
    }
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Long getThreshold() {
        return threshold;
    }

    public void setThreshold(Long threshold) {
        this.threshold = threshold;
    }

    public String getAccesslog() {
        return accesslog;
    }

    public void setAccesslog(String accesslog) {
        this.accesslog = accesslog;
    }

    @Override
    public String toString() {
        return "ParamModel{" +
                "startDate=" + startDate +
                ", duration='" + duration + '\'' +
                ", threshold=" + threshold +
                '}';
    }
}
