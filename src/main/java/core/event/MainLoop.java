package core.event;

import core.Main;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class MainLoop implements Runnable {
    private boolean isRunning = true;
    private BlockingQueue<MEvent> mainQueue = new LinkedBlockingDeque<MEvent>();

    @Override
    public void run() {

        while(isRunning) {
            try {
                MEvent m = mainQueue.take();
                processMEvent(m);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void processMEvent(MEvent m) {
        switch(m.getType()) {
            case ID_DB_RECORD:
                break;
            case ID_ALARM_TIMER:
                break;
            case ID_UPDATE_DATA:
                // update device list
                Main.getMainWindow().updateData();

                // update alarm list

                // repaint ui
                Main.getMainWindow().repaint();

                break;
            default:

        }
    }

    public void stop() {
        isRunning = false;
    }

    public BlockingQueue<MEvent> getMainQueue() {
        return mainQueue;
    }
}
