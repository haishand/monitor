package core.defs;

public enum DeviceType {
    DEVICE_HUMITURE(10),
    DEVICE_EMETER(20);

    int type;
    DeviceType(int type) {
        this.type = type;
    }
}
