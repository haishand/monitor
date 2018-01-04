package util;

import action.rsserver.RSDataListener;
import com.jnrsmcu.sdk.netdevice.RSServer;
import org.apache.log4j.Logger;

import java.io.IOException;

public class RSServerUtil {
    private static RSServer rsServer;
    private static boolean isRunning = false;
    private static Logger logger = Logger.getLogger(RSServerUtil.class);

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
            logger.debug("RSServer started");
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
            logger.debug("RSServer stopped");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void timming(int deviceId) {

    }
}
