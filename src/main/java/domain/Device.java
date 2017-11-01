package domain;

import java.util.Date;

public class Device {
    private int id;
    private int deviceId;
    private int nodeId;
    private String deviceName;
    private int deviceType;

    private String param1Name;
    private String param2Name;
    private int saveInterval;
    private int lowAlarmLimit1;
    private int hiAlarmLimit1;
    private int lowAlarmLimit2;
    private int hiAlarmLimit2;
    private int alarmStatus;
    private int onlineStatus;

    public Device(int id,
                  int deviceId,
                  int nodeId,
                  String deviceName,
                  int deivceType,
                  String param1Name,
                  String param2Name,
                  int saveInterval,
                  int lowAlarmLimit1,
                  int hiAlarmLimit1,
                  int lowAlarmLimit2,
                  int hiAlarmLimit2,
                  int alarmStatus,
                  int onlineStatus) {
        this.id = id;
        this.deviceId = deviceId;
        this.nodeId = nodeId;
        this.deviceName = deviceName;
        this.deviceType = deivceType;
        this.param1Name = param1Name;
        this.param2Name = param2Name;
        this.saveInterval = saveInterval;
        this.lowAlarmLimit1 = lowAlarmLimit1;
        this.hiAlarmLimit1 = hiAlarmLimit1;
        this.lowAlarmLimit2 = lowAlarmLimit2;
        this.hiAlarmLimit2 = hiAlarmLimit2;
        this.alarmStatus = alarmStatus;
        this.onlineStatus = onlineStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getLowAlarmLimit1() {
        return lowAlarmLimit1;
    }

    public void setLowAlarmLimit1(int lowAlarmLimit1) {
        this.lowAlarmLimit1 = lowAlarmLimit1;
    }

    public int getHiAlarmLimit1() {
        return hiAlarmLimit1;
    }

    public void setHiAlarmLimit1(int hiAlarmLimit1) {
        this.hiAlarmLimit1 = hiAlarmLimit1;
    }

    public int getLowAlarmLimit2() {
        return lowAlarmLimit2;
    }

    public void setLowAlarmLimit2(int lowAlarmLimit2) {
        this.lowAlarmLimit2 = lowAlarmLimit2;
    }

    public int getHiAlarmLimit2() {
        return hiAlarmLimit2;
    }

    public void setHiAlarmLimit2(int hiAlarmLimit2) {
        this.hiAlarmLimit2 = hiAlarmLimit2;
    }

    public int getAlarmStatus() {
        return alarmStatus;
    }

    public void setAlarmStatus(int alarmStatus) {
        this.alarmStatus = alarmStatus;
    }

    public int getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(int onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
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
                ", alarmStatus=" + alarmStatus +
                ", onlineStatus=" + onlineStatus +
                '}';
    }
}
