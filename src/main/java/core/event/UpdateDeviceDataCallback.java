package core.event;

import core.event.MCallback;
import mapper.DeviceDataMapper;
import org.apache.ibatis.session.SqlSession;
import org.aspectj.lang.annotation.Before;
import po.Device;
import po.DeviceData;
import po.DeviceDataExample;
import util.MyBatisHelper;

import java.util.List;

public class UpdateDeviceDataCallback implements MCallback {

    @Override
    public void handleEvent(MEvent event) {

        SqlSession session = MyBatisHelper.getSqlSessionFactory().openSession();
        try {
            DeviceDataMapper mapper = session.getMapper(DeviceDataMapper.class);
            Object[] args = event.getArgArray();
            DeviceData data = (DeviceData) args[1];
            DeviceDataExample example = new DeviceDataExample();
            example.createCriteria().andCodeEqualTo(data.getCode());
            long count = mapper.countByExample(example);
            if(count != 0) {
                mapper.updateByPrimaryKeySelective(data);
            }else {
                mapper.insertSelective(data);
            }
            session.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

}
