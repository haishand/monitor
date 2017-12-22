package core.defs;

public enum DeviceStatus {
    OFF_LINE("离线", 0),
    ON_LINE("在线", 1);

    String desc;
    int value;
    DeviceStatus(String desc, int value) {
        this.desc = desc;
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public int getValue() {
        return value;
    }

    public static int descToValue(String s) {
        int v = OFF_LINE.getValue();

        if(s.equalsIgnoreCase(ON_LINE.getDesc())) {
            v = ON_LINE.getValue();
        }

        return v;
    }

    public static String valueToDesc(Integer v) {
        String desc = OFF_LINE.getDesc();

        switch(v) {
            case 0:
                desc = OFF_LINE.getDesc();
                break;
            case 1:
                desc = ON_LINE.getDesc();
                break;
            default:
        }
        return desc;
    }
}
