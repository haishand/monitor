package po;

public class Device {
    private Integer code;

    private Integer deviceId;

    private Integer nodeId;

    private Boolean multiFlag;

    private String deviceName;

    private Integer deviceType;

    private String param1Name;

    private String param2Name;

    private Integer saveInterval;

    private Float lowAlarmLimit1;

    private Float hiAlarmLimit1;

    private Float lowAlarmLimit2;

    private Float hiAlarmLimit2;

    private Integer onlineStatus;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Boolean getMultiFlag() {
        return multiFlag;
    }

    public void setMultiFlag(Boolean multiFlag) {
        this.multiFlag = multiFlag;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public String getParam1Name() {
        return param1Name;
    }

    public void setParam1Name(String param1Name) {
        this.param1Name = param1Name == null ? null : param1Name.trim();
    }

    public String getParam2Name() {
        return param2Name;
    }

    public void setParam2Name(String param2Name) {
        this.param2Name = param2Name == null ? null : param2Name.trim();
    }

    public Integer getSaveInterval() {
        return saveInterval;
    }

    public void setSaveInterval(Integer saveInterval) {
        this.saveInterval = saveInterval;
    }

    public Float getLowAlarmLimit1() {
        return lowAlarmLimit1;
    }

    public void setLowAlarmLimit1(Float lowAlarmLimit1) {
        this.lowAlarmLimit1 = lowAlarmLimit1;
    }

    public Float getHiAlarmLimit1() {
        return hiAlarmLimit1;
    }

    public void setHiAlarmLimit1(Float hiAlarmLimit1) {
        this.hiAlarmLimit1 = hiAlarmLimit1;
    }

    public Float getLowAlarmLimit2() {
        return lowAlarmLimit2;
    }

    public void setLowAlarmLimit2(Float lowAlarmLimit2) {
        this.lowAlarmLimit2 = lowAlarmLimit2;
    }

    public Float getHiAlarmLimit2() {
        return hiAlarmLimit2;
    }

    public void setHiAlarmLimit2(Float hiAlarmLimit2) {
        this.hiAlarmLimit2 = hiAlarmLimit2;
    }

    public Integer getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(Integer onlineStatus) {
        this.onlineStatus = onlineStatus;
    }
}