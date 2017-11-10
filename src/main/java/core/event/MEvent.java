package core.event;

public class MEvent {
    private MType type;
    private Object[] argArray;
    private MCallback handler;

    public MEvent(MType type, Object[] argArray, MCallback handler) {
        this.type = type;
        this.argArray = argArray;
        this.handler = handler;
    }

    public MType getType() {
        return type;
    }

    public Object[] getArgArray() {
        return argArray;
    }

    public MCallback getHandler() {
        return handler;
    }
}
