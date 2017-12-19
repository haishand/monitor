package core.defs;

public enum AlarmStatus {
    UNTREATED(0),   // 未处理
    TREATED(1); // 已处理

    int code;
    AlarmStatus(int code ) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
