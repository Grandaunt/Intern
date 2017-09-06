package com.example.win.newintern3.NewEntity;


public class Tsystemaction implements java.io.Serializable {
    public Tsystemaction(String actionId, String actionMan, String actionName, String actionTime, String requestIP, String requestType, String actionMethod) {
        this.actionId = actionId;
        this.actionMan = actionMan;
        this.actionName = actionName;
        this.actionTime = actionTime;
        this.requestIP = requestIP;
        this.requestType = requestType;
        this.actionMethod = actionMethod;
    }

    public Tsystemaction() {

    }

    private String actionId;

    private String actionMan;

    private String actionName;

    private String actionTime;

    private String requestIP;

    private String requestType;
    
    public String getActionMethod() {
		return actionMethod;
	}

	public void setActionMethod(String actionMethod) {
		this.actionMethod = actionMethod;
	}

    private String actionMethod;

    public String getActionId() {
        return actionId;
    }

    public Tsystemaction setActionId(String actionId) {
        this.actionId = actionId;
        return this;
    }

    public String getActionMan() {
        return actionMan;
    }

    public Tsystemaction setActionMan(String actionMan) {
        this.actionMan = actionMan;
        return this;
    }

    public String getActionName() {
        return actionName;
    }

    public Tsystemaction setActionName(String actionName) {
        this.actionName = actionName;
        return this;
    }

    public String getActionTime() {
        return actionTime;
    }

    public Tsystemaction setActionTime(String actionTime) {
        this.actionTime = actionTime;
        return this;
    }

    public String getRequestIP() {
        return requestIP;
    }
    

    public Tsystemaction setRequestIP(String requestIP) {
        this.requestIP = requestIP;
        return this;
    }

    public String getRequestType() {
        return requestType;
    }
    

    public Tsystemaction setRequestType(String requestType) {
        this.requestType = requestType;
        return this;
    }

    @Override
    public String toString() {
        return "Tsystemaction{" +
                "actionId='" + actionId + '\'' +
                ", actionMan='" + actionMan + '\'' +
                ", actionName='" + actionName + '\'' +
                ", actionTime='" + actionTime + '\'' +
                ", requestIP='" + requestIP + '\'' +
                ", requestType='" + requestType + '\'' +
                ", actionMethod='" + actionMethod + '\'' +
                '}';
    }
//	public String toString() {
//        StringBuffer sb = new StringBuffer();
//        sb.append(this.getClass().getName());
//        sb.append("; actionId=" + (actionId == null ? "null" : actionId.toString()));
//        sb.append("; actionMan=" + (actionMan == null ? "null" : actionMan.toString()));
//        sb.append("; actionName=" + (actionName == null ? "null" : actionName.toString()));
//        sb.append("; actionTime=" + (actionTime == null ? "null" : actionTime.toString()));
//        sb.append("; requestIP=" + (requestIP == null ? "null" : requestIP.toString()));
//        sb.append("; requestType=" + (requestType == null ? "null" : requestType.toString()));
//
//        return sb.toString();
//    }
}