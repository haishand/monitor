package core;

import java.util.Vector;

public class Message {
    public enum Type {
        ID_ALARM_TIMER,
        ID_UPDATE_UI,
    }

    private Type type;
    private Vector<Object> params;
    private CallBack handler;

    public Message(Type type, Vector<Object> params, CallBack handler) {
        this.type = type;
        this.params = params;
        this.handler = handler;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Vector<Object> getParams() {
        return params;
    }

    public void setParams(Vector<Object> params) {
        this.params = params;
    }

    public CallBack getHandler() {
        return handler;
    }

    public void setHandler(CallBack handler) {
        this.handler = handler;
    }

}
