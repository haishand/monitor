package domain;

public class Device {
    private int code;
    private int deviceId;
    private int nodeId;
    private String deviceName;
    private int deviceType;

    private String param1Name;
    private String param2Name;
    private int saveInterval;
    private float lowAlarmLimit1;
    private float hiAlarmLimit1;
    private float lowAlarmLimit2;
    private float hiAlarmLimit2;
    private int onlineStatus;

    public Device(int code,
                  int deviceId,
                  int nodeId,
                  String deviceName,
                  int deviceType,
                  String param1Name,
                  String param2Name,
                  int saveInterval,
                  float lowAlarmLimit1,
                  float hiAlarmLimit1,
                  float lowAlarmLimit2,
                  float hiAlarmLimit2,
                  int onlineStatus) {
        this.code = code;
        this.deviceId = deviceId;
        this.nodeId = nodeId;
        this.deviceName = deviceName;
        this.deviceType = deviceType;
        this.param1Name = param1Name;
        this.param2Name = param2Name;
        this.saveInterval = saveInterval;
        this.lowAlarmLimit1 = lowAlarmLimit1;
        this.hiAlarmLimit1 = hiAlarmLimit1;
        this.lowAlarmLimit2 = lowAlarmLimit2;
        this.hiAlarmLimit2 = hiAlarmLimit2;
        this.onlineStatus = onlineStatus;
    }

    @Override
    public String toString() {
        return "Device{" +
                "code=" + code +
                ", deviceId=" + deviceId +
                ", nodeId=" + nodeId +
                ", deviceName='" + deviceName + '\'' +
                ", deviceType=" + deviceType +
                ", param1Name='" + param1Name + '\'' +
                ", param2Name='" + param2Name + '\'' +
                ", saveInterval=" + saveInterval +
                ", lowAlarmLimit1=" + lowAlarmLimit1 +
                ", hiAlarmLimit1=" + hiAlarmLimit1 +
                ", lowAlarmLimit2=" + lowAlarmLimit2 +
                ", hiAlarmLimit2=" + hiAlarmLimit2 +
                ", onlineStatus=" + onlineStatus +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public String getParam1Name() {
        return param1Name;
    }

    public void setParam1Name(String param1Name) {
        this.param1Name = param1Name;
    }

    public String getParam2Name() {
        return param2Name;
    }

    public void setParam2Name(String param2Name) {
        this.param2Name = param2Name;
    }

    public int getSaveInterval() {
        return saveInterval;
    }

    public void setSaveInterval(int saveInterval) {
        this.saveInterval = saveInterval;
    }

    public float getLowAlarmLimit1() {
        return lowAlarmLimit1;
    }

    public void setLowAlarmLimit1(float lowAlarmLimit1) {
        this.lowAlarmLimit1 = lowAlarmLimit1;
    }

    public float getHiAlarmLimit1() {
        return hiAlarmLimit1;
    }

    public void setHiAlarmLimit1(float hiAlarmLimit1) {
        this.hiAlarmLimit1 = hiAlarmLimit1;
    }

    public float getLowAlarmLimit2() {
        return lowAlarmLimit2;
    }

    public void setLowAlarmLimit2(float lowAlarmLimit2) {
        this.lowAlarmLimit2 = lowAlarmLimit2;
    }

    public float getHiAlarmLimit2() {
        return hiAlarmLimit2;
    }

    public void setHiAlarmLimit2(float hiAlarmLimit2) {
        this.hiAlarmLimit2 = hiAlarmLimit2;
    }

    public int getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(int onlineStatus) {
        this.onlineStatus = onlineStatus;
    }
}
