package com.ef.entities;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * @author Ariel Morel
 */
@Entity(name="log")
@NamedQueries({
        @NamedQuery(name = "findByIp", query = "SELECT l FROM log l where l.ip= :ip"),
       })
public class LogModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date logDate;
    private String ip;
    private String request;
    private String status;
    private String userAgent;

    public LogModel() {
    }

    public LogModel( String ip, long count) {
        this.ip=ip;
    }

    public LogModel(Date logDate, String ip, String request, String status, String userAgent) {
        this.logDate = logDate;
        this.ip = ip;
        this.request = request;
        this.status = status;
        this.userAgent = userAgent;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public String toString() {
        return "LogModel{" +
                "ip='" + ip + '\'' +
                '}';
    }
}
