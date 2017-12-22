package core.handler;

import core.Main;
import core.event.MEvent;
import core.event.MType;

public class GUIUpdater implements Runnable {
    @Override
    public void run() {
        Main.sendEvent(new MEvent(MType.ID_UPDATE_GUI, null, null));
    }
}
