package com.cdy.common.rbac.entiy;

import java.util.Date;

public class OperateLogInfo extends BaseEntity {
    private Integer id;

    private Integer uid;

    private String uname;

    private String fromIp;

    private String operateFunc;

    private String visitMethod;

    private String methodCostTime;

    private String logType;

    private String uri;

    private String method;

    private String visitMethodErrorInfo;

    private Boolean status;

    private Date loginOutTime;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getFromIp() {
        return fromIp;
    }

    public void setFromIp(String fromIp) {
        this.fromIp = fromIp;
    }

    public String getOperateFunc() {
        return operateFunc;
    }

    public void setOperateFunc(String operateFunc) {
        this.operateFunc = operateFunc;
    }

    public String getVisitMethod() {
        return visitMethod;
    }

    public void setVisitMethod(String visitMethod) {
        this.visitMethod = visitMethod;
    }

    public String getMethodCostTime() {
        return methodCostTime;
    }

    public void setMethodCostTime(String methodCostTime) {
        this.methodCostTime = methodCostTime;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getVisitMethodErrorInfo() {
        return visitMethodErrorInfo;
    }

    public void setVisitMethodErrorInfo(String visitMethodErrorInfo) {
        this.visitMethodErrorInfo = visitMethodErrorInfo;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getLoginOutTime() {
        return loginOutTime;
    }

    public void setLoginOutTime(Date loginOutTime) {
        this.loginOutTime = loginOutTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}