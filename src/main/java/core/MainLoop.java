package core;

import gui.MonitorTable;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class MainLoop implements Runnable {
    private boolean isRunning = true;
    BlockingQueue<Message> mainQueue = new LinkedBlockingDeque<Message>();

    @Override
    public void run() {

        while(isRunning) {
            try {
                Message m = mainQueue.take();
                switch(m.getType()) {
                    case ID_ALARM_TIMER:
                        break;
                    case ID_UPDATE_UI:
                        // update device list

                        // update alarm list

                        // repaint ui
                        Main.getMainWindow().repaint();

                        break;
                    default:

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
