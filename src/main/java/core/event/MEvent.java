package core.event;

import core.CallBack;

import java.util.Vector;

public class MEvent {
    private MType type;
    private Object[] argArray;
    private CallBack handler;

    public MEvent(MType type, Object[] argArray, CallBack handler) {
        this.type = type;
        this.argArray = argArray;
        this.handler = handler;
    }

    public MType getType() {
        return type;
    }

}
