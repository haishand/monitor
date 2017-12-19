package core.event;

import core.event.MCallback;
import mapper.DeviceDataMapper;
import org.apache.ibatis.session.SqlSession;
import org.aspectj.lang.annotation.Before;
import po.DeviceData;
import util.MyBatisHelper;

public class UpdateDeviceDataCallback implements MCallback {

    @Override
    public void handleEvent(MEvent event) {
        SqlSession sqlSession = MyBatisHelper.getSqlSessionFactory().openSession();
        DeviceDataMapper dataMapper = sqlSession.getMapper(DeviceDataMapper.class);
        Object[] args = event.getArgArray();
        DeviceData data = (DeviceData)args[1];
        dataMapper.updateByPrimaryKey(data);
        sqlSession.commit();
    }

}
