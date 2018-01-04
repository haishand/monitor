package core.defs;

public enum AlarmType {
    TEMP_ABOVE_UPPER_BOUND("温度高于上界"),
    TEMP_BELOW_LOWER_BOUND("温度低于下界"),
    HUM_ABOVE_UPPER_BOUND("湿度高于上界"),
    HUM_BELOW_LOWER_BOUND("湿度低于下界");

    String message;
    AlarmType(String msg) {
        this.message = msg;
    }

    public String getMessage() {
        return message;
    }
}
