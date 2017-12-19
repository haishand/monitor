package core.handler;

import core.defs.AlarmStatus;
import core.defs.AlarmType;
import core.defs.DeviceType;
import mapper.AlarmDataMapper;
import mapper.DeviceDataMapper;
import mapper.DeviceMapper;
import org.apache.ibatis.session.SqlSession;
import po.AlarmData;
import po.Device;
import po.DeviceData;
import util.MyBatisHelper;

import java.util.List;

public class DataChecker implements Runnable {
    @Override
    public void run() {
        // check records
        SqlSession sqlSession = MyBatisHelper.getSqlSessionFactory().openSession();
        DeviceDataMapper dataMapper = sqlSession.getMapper(DeviceDataMapper.class);
        List<DeviceData> list = dataMapper.selectByExample(null);
        for(DeviceData data : list) {
            int code = data.getCode();
            float param1 = data.getParam1();
            float param2 = data.getParam2();

            DeviceMapper mapper = sqlSession.getMapper(DeviceMapper.class);
            Device dev = mapper.selectByPrimaryKey(code);
            if(dev.getDeviceType() == DeviceType.DEVICE_HUMITURE.getValue()) {
                // 温湿度设备
                float lowAlarmLimit1 = dev.getLowAlarmLimit1();
                float lowAlarmLimit2 = dev.getLowAlarmLimit2();
                float hiAlarmLimit1 = dev.getHiAlarmLimit1();
                float hiAlarmLimit2 = dev.getHiAlarmLimit2();

                // check param1
                if((param1 < lowAlarmLimit1)||(param1 > hiAlarmLimit1)) {
                    AlarmData alarm1 = new AlarmData();
                    alarm1.setValue(param1);

                    if(param1<lowAlarmLimit1) {
                        alarm1.setType(AlarmType.TEMP_BELOW_LOWER_BOUND.getMessage());
                    }
                    else {
                        alarm1.setType(AlarmType.TEMP_ABOVE_UPPER_BOUND.getMessage());
                    }
                    alarm1.setRecordtime(data.getRecordtime());
                    alarm1.setCode(code);
                    alarm1.setStatus(AlarmStatus.UNTREATED.getCode());

                    AlarmDataMapper almMapper = sqlSession
                            .getMapper(AlarmDataMapper.class);
                    almMapper.insert(alarm1);
                }


                // check param2
                if((param2 < lowAlarmLimit2)||(param2 > hiAlarmLimit2)) {
                    AlarmData alarm2 = new AlarmData();
                    alarm2.setValue(param2);

                    if(param2<lowAlarmLimit2) {
                        alarm2.setType(AlarmType.HUM_BELOW_LOWER_BOUND.getMessage());
                    }
                    else {
                        alarm2.setType(AlarmType.HUM_ABOVE_UPPER_BOUND.getMessage());
                    }
                    alarm2.setRecordtime(data.getRecordtime());
                    alarm2.setCode(code);
                    alarm2.setStatus(AlarmStatus.UNTREATED.getCode());

                    AlarmDataMapper almMapper = sqlSession
                            .getMapper(AlarmDataMapper.class);
                    almMapper.insert(alarm2);
                }

            }else if(dev.getDeviceType() == DeviceType.DEVICE_EMETER.getValue()){
                // 电流设备
                // TODO
            }

        }
    }

    public static void main(String[] args) {
    }
}
