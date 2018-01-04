package core.defs;

public enum DeviceType {
    UNKNOWN_DEVICE("未知设备", 0),
    HUMITURE_DEVICE("温湿度", 10),
    EMETER_DEVICE("电能表", 20);

    DeviceType(String desc, int value) {
        this.desc = desc;
        this.value = value;
    }

    String desc;
    int value;

    public String getDesc() {
        return desc;
    }

    public int getValue() {
        return value;
    }

    public static DeviceType descToValue(String s) {
        DeviceType type = UNKNOWN_DEVICE;

        if(s.equalsIgnoreCase(HUMITURE_DEVICE.getDesc())) {
            type = HUMITURE_DEVICE;
        }else if(s.equalsIgnoreCase(EMETER_DEVICE.getDesc())) {
            type = EMETER_DEVICE;
        }

        return type;
    }

    public static Object valueToDesc(Integer v) {
        String desc = UNKNOWN_DEVICE.getDesc();

        switch(v) {
            case 0:
                desc = UNKNOWN_DEVICE.getDesc();
                break;
            case 10:
                desc = HUMITURE_DEVICE.getDesc();
                break;
            case 20:
                desc = EMETER_DEVICE.getDesc();
                break;
            default:

        }
        return desc;
    }
}
