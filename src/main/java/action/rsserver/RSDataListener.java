package action.rsserver;

import com.jnrsmcu.sdk.netdevice.*;
import core.Main;
import core.defs.DeviceType;
import core.defs.ErrorMsg;
import core.event.MEvent;
import core.event.MType;
import core.event.UpdateDeviceDataCallback;
import mapper.DeviceDataMapper;
import po.DeviceData;
import mapper.DeviceMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import po.Device;
import po.DeviceExample;
import util.MyBatisHelper;

import java.util.Date;
import java.util.List;

public class RSDataListener implements IDataListener {
    private static Logger logger = Logger.getLogger(RSDataListener.class);

    @Override
    public void receiveRealtimeData(RealTimeData realTimeData) {
        int devId = realTimeData.getDeviceId();

        // query type from DB
        SqlSessionFactory sqlSessionFactory = MyBatisHelper.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DeviceMapper deviceMapper = sqlSession.getMapper(DeviceMapper.class);
        DeviceExample eg = new DeviceExample();
        eg.createCriteria().andDeviceIdEqualTo(devId);
        List<Device> devices = deviceMapper.selectByExample(eg);
        sqlSession.close();

        // update device status

        // update data record
        if (!devices.isEmpty()) {
            Device dev = devices.get(0);
            int type = dev.getDeviceType();
            for (NodeData nd : realTimeData.getNodeList()) {
                float param1 = nd.getTem();
                float param2 = nd.getHum();

                // skip 2 empty records
                if (param1 == 0 && param2 == 0) {
                    continue;
                }

                switch (type) {
                    case 10:
                        handleTDevice(devId, nd);
                        break;
                    case 20:
                        handleEDevice(devId, nd);
                        break;
                    default:
                        logger.error(String.format(ErrorMsg.UNKNOWN_DEVICE_TYPE, type));
                }
            }
        }
    }

    // handle temperature device
    private void handleTDevice(int devId, NodeData nd) {
        int nodeId = nd.getNodeId();
        float param1 = nd.getTem();
        float param2 = nd.getHum();

        // open sql session
        SqlSessionFactory sqlSessionFactory = MyBatisHelper.getSqlSessionFactory();
        final SqlSession sqlSession = sqlSessionFactory.openSession();

        //
        DeviceMapper deviceMapper = sqlSession.getMapper(DeviceMapper.class);
        DeviceExample eg = new DeviceExample();
        eg.createCriteria().andDeviceIdEqualTo(devId);
        List<Device> devices = deviceMapper.selectByExample(eg);
        int code = -1;
        if(!devices.isEmpty()) {
            Device dev = devices.get(0);
            code = dev.getCode();

            Date time = nd.getRecordTime();
            DeviceData data = new DeviceData();
            data.setCode(code);
            data.setParam1(param1);
            data.setParam2(param2);
            data.setRecordtime(time);

            Object[] args = {DeviceType.DEVICE_HUMITURE, data};

            Main.getMainLoop().getMainQueue().offer(new MEvent(
                    MType.ID_UPDATE_DATA,
                    args,
                    new UpdateDeviceDataCallback()));

        }
        sqlSession.close();

    }

    // handle electricity device
    private void handleEDevice(int devId, NodeData nd) {
        int nodeId = nd.getNodeId();
        float param1 = nd.getTem();
        float param2 = nd.getHum();

        // open sql session
        SqlSessionFactory sqlSessionFactory = MyBatisHelper.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //
        DeviceMapper deviceMapper = sqlSession.getMapper(DeviceMapper.class);
        DeviceExample eg = new DeviceExample();
        eg.createCriteria().andDeviceIdEqualTo(devId).andNodeIdEqualTo(nodeId);
        List<Device> devices = deviceMapper.selectByExample(eg);
        int code = -1;
        if(!devices.isEmpty()) {
            Device dev = devices.get(0);
            code = dev.getCode();

            Date time = nd.getRecordTime();
            DeviceData data = new DeviceData();
            data.setCode(code);
            data.setParam1(param1);
            data.setParam2(param2);
            data.setRecordtime(time);

            Object[] args = {DeviceType.DEVICE_HUMITURE, data};

            Main.getMainLoop().getMainQueue().offer(new MEvent(
                    MType.ID_UPDATE_DATA,
                    args,
                    new UpdateDeviceDataCallback()));
        }
        sqlSession.close();
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
