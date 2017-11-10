package util;

import action.rsserver.RSDataListener;
import com.jnrsmcu.sdk.netdevice.RSServer;

import java.io.IOException;

public class RSServerUtil {
    private static RSServer rsServer;
    private static boolean isRunning = false;

    static {
        RSDataListener listener = new RSDataListener();
        rsServer = RSServer.Initiate(
                Integer.parseInt(
                        PropertiesUtil.getInstance().getValue(PropertiesUtil.ParamType.PORT.getName()
                        )));
        rsServer.addDataListener(listener);
    }

    public RSServerUtil() {
    }

    public static void start() {
        try {
            rsServer.start();
            isRunning = true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void stop() {
        try {
            rsServer.stop();
            isRunning = false;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void timming(int deviceId) {

    }
}
