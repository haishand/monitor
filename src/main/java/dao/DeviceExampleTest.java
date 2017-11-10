package dao;

import mapper.DeviceDataMapper;
import mapper.DeviceMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import po.DeviceData;
import po.DeviceDataExample;
import po.DeviceExample;
import util.MyBatisHelper;

import java.io.IOException;
import java.util.Date;

public class DeviceExampleTest {
    public static void main(String[] args) throws IOException {
        DeviceExample example = new DeviceExample();
        example.createCriteria().andDeviceIdEqualTo(2);
        SqlSessionFactory sqlSessionFactory = MyBatisHelper.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        DeviceMapper deviceMapper = session.getMapper(DeviceMapper.class);
        long res = deviceMapper.countByExample(example);

        DeviceDataMapper dataMapper = session.getMapper(DeviceDataMapper.class);
        DeviceData data = new DeviceData();
        data.setCode(2);
        data.setParam1(25.0f);
        data.setParam2(20.0f);
        data.setRecordtime(new Date());

        try {
            dataMapper.updateByPrimaryKey(data);
            session.commit();
        } finally {
            session.close();
        }
    }
}
