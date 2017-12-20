package core.handler;

import mapper.DeviceMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import po.Device;
import util.MyBatisHelper;
import util.RSServerUtil;

import java.util.List;

public class DeviceStatusChecker implements Runnable {
    @Override
    public void run() {
        SqlSessionFactory sqlSessionFactory = MyBatisHelper.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();

        try {
            DeviceMapper mapper = session.getMapper(DeviceMapper.class);
            List<Device> devices = mapper.selectByExample(null);

            for (Device dev : devices) {
                RSServerUtil.timming(dev.getDeviceId());
            }
        }finally {
            session.close();
        }

    }
}
