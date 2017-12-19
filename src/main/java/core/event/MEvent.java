package core.event;

public class MEvent {
    private MType type;
    private Object[] argArray;
    private MCallback callback;

    public MEvent(MType type, Object[] argArray, MCallback callback) {
        this.type = type;
        this.argArray = argArray;
        this.callback = callback;
    }

    public MType getType() {
        return type;
    }

    public Object[] getArgArray() {
        return argArray;
    }

    public MCallback getCallback() {
        return callback;
    }
}
