package action.rsserver;

import com.jnrsmcu.sdk.netdevice.*;
import org.apache.log4j.Logger;

import java.util.Date;

public class RSDataListener implements IDataListener {
    private static Logger logger = Logger.getLogger(RSDataListener.class);

    @Override
    public void receiveRealtimeData(RealTimeData realTimeData) {
        for(NodeData nd : realTimeData.getNodeList()) {
            int id = realTimeData.getDeviceId();
            float param1 = nd.getTem();
            float param2 = nd.getHum();
            Date time = nd.getRecordTime();
            String status = realTimeData.getRelayStatus();

            // skip 2 empty device record
            if (param1 == 0 && param2 == 0) {
                continue;
            }

            logger.info("device id:" + id + "," +
                    "param1:" + param1 + "," +
                    "param2:" + param2 + "," +
                    "status:" + status);
/*            Device dev = new Device(id, status, param1, param2, time);
            Object[] argArray = {dev};
            MEvent e = new MEvent(MType.ID_DEIVCE_DATA, argArray, null);

            Main.getMainLoop().getMainQueue().offer(e);
*/

        }

    }

    @Override
    public void receiveLoginData(LoginData loginData) {

    }

    @Override
    public void receiveStoreData(StoreData storeData) {

    }

    @Override
    public void receiveTelecontrolAck(TelecontrolAck telecontrolAck) {

    }

    @Override
    public void receiveTimmingAck(TimmingAck timmingAck) {
        // TODO
        // TODO: update device status
    }
}
