package core.event;

import core.Main;
import core.handler.AlarmChecker;
import core.handler.DataChecker;
import core.handler.DeviceStatusChecker;
import core.handler.GUIUpdater;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import util.PropertiesUtil;

import java.util.concurrent.*;

/**
 * @author haishand
 */
public class MainLoop implements Runnable {
    private boolean isRunning = true;
    private BlockingQueue<MEvent> mainQueue = new LinkedBlockingDeque<MEvent>();
    private ScheduledExecutorService scheduledThreadPool = new ScheduledThreadPoolExecutor(10);
    private static final Logger log = LogManager.getLogger(MainLoop.class);

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
            case ID_UPDATE_DEVICE_DATA:
                m.getCallback().handleEvent(m);
                break;

            case ID_START_ALARM_CHECK_TIMER:
                int timer1 = Integer.parseInt(PropertiesUtil.getInstance().getValue("ALARM_CHECK_TIMER"));
                scheduledThreadPool.scheduleAtFixedRate(new AlarmChecker(), 0, timer1, TimeUnit.SECONDS);
                break;

            case ID_START_DATA_CHECK_TIMER:
                int timer2 = Integer.parseInt(PropertiesUtil.getInstance().getValue("DATA_CHECK_TIMER"));
                scheduledThreadPool.scheduleAtFixedRate(new DataChecker(), 0, timer2, TimeUnit.SECONDS);
                break;

            case ID_START_UPDATE_GUI_TIMER:
                int timer = Integer.parseInt(PropertiesUtil.getInstance().getValue("UPDATE_GUI_TIMER"));
                scheduledThreadPool.scheduleAtFixedRate(new GUIUpdater(), 0, timer, TimeUnit.SECONDS);
                break;
            case ID_UPDATE_GUI:
                Main.updateGUI();
                break;
            case ID_CHECK_DEVICE_STATUS:
                // check all devices status every 1 minute
                scheduledThreadPool.schedule(new DeviceStatusChecker(), 1, TimeUnit.MINUTES);
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

    public ScheduledExecutorService getScheduledThreadPool() {
        return scheduledThreadPool;
    }
}
