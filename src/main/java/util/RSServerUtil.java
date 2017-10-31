package util;

import com.jnrsmcu.sdk.netdevice.RSServer;
import core.Main;

import java.awt.*;
import java.io.IOException;

public class RSServerUtil {
    private static RSServer rsServer;
    static {
        rsServer = RSServer.Initiate(
                Integer.parseInt(
                        PropertiesUtil.getInstance().getValue(PropertiesUtil.ParamType.PORT.getName()
                        )));
//        rsServer.addDataListener(MyDataListener);
    }

    public RSServerUtil() {
    }

    public static void start() {
        try {
            rsServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void stop() {
        // TODO
    }

    public static void timming(int deviceId) {

    }
}
