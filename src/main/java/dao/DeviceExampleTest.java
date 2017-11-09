package dao;

import mapper.DeviceMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import po.DeviceExample;
import util.MyBatisHelper;

import java.io.IOException;

public class DeviceExampleTest {
    public static void main(String[] args) throws IOException {
        DeviceExample example = new DeviceExample();
        example.createCriteria().andDeviceidEqualTo(1);
        SqlSessionFactory sqlSessionFactory = MyBatisHelper.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        DeviceMapper deviceMapper = session.getMapper(DeviceMapper.class);
        long res = deviceMapper.countByExample(example);
        System.out.println(res);

    }
}
