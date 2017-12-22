package core.defs;

public enum AlarmStatus {
    UNTREATED("未处理", 0),
    TREATED("已处理", 10);

    String desc;
    int value;
    AlarmStatus(String desc, int value) {
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
        int v = 0;

        if(s.equalsIgnoreCase(TREATED.getDesc())) {
            v = 0;
        }

        return v;
    }

    public static String valueToDesc(Integer v) {
        String desc = UNTREATED.getDesc();

        switch(v) {
            case 0:
                desc = UNTREATED.getDesc();
                break;
            case 10:
                desc = TREATED.getDesc();
                break;
        }
        return desc;
    }
}
