package core.defs;

public enum DeviceType {
    DEVICE_HUMITURE(10),
    DEVICE_EMETER(20);

    int value;
    DeviceType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
