package util;

import action.MyDataListener;
import com.jnrsmcu.sdk.netdevice.RSServer;
import core.Main;

import java.awt.*;
import java.io.IOException;

public class RSServerUtil {
    private static RSServer rsServer;
    static {
        MyDataListener listener = new MyDataListener();
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
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void stop() {
        try {
            rsServer.stop();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void timming(int deviceId) {

    }
}
