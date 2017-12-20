package core.event;

import core.Main;
import core.handler.AlarmChecker;
import core.handler.DataChecker;
import core.handler.DeviceStatusChecker;
import util.PropertiesUtil;

import java.util.concurrent.*;

/**
 * @author haishand
 */
public class MainLoop implements Runnable {
    private boolean isRunning = true;
    private BlockingQueue<MEvent> mainQueue = new LinkedBlockingDeque<MEvent>();
    private static ScheduledExecutorService scheduledThreadPool = new ScheduledThreadPoolExecutor(10);

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
            case ID_DEVICE_DATA:
                m.getCallback().handleEvent(m);
                break;

            case ID_ALARM_CHECK_TIMER_START:
                int timer1 = Integer.parseInt(PropertiesUtil.getInstance().getValue("ALARM_CHECK_TIMER"));
                scheduledThreadPool.scheduleAtFixedRate(new AlarmChecker(), 0, timer1, TimeUnit.MINUTES);
                break;

            case ID_DATA_CHECK_TIMER_START:
                int timer2 = Integer.parseInt(PropertiesUtil.getInstance().getValue("RECORD_UPDATE_TIMER"));
                scheduledThreadPool.scheduleAtFixedRate(new DataChecker(), 0, timer2, TimeUnit.MINUTES);
                break;

            case ID_UPDATE_DATA:
                // update device list
                // update alarm list
                Main.updateDeviceData();
                Main.updateAlarmData();
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
}
