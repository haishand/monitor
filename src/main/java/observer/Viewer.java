package observer;

import core.CallBack;

import java.util.Observable;
import java.util.Observer;

public class Viewer implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        CallBack c = (CallBack) arg;
        c.method("test");
    }
}
