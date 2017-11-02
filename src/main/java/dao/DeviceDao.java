package dao;

import domain.Device;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import util.MyBatisUtil;

import java.util.List;

public class DeviceDao {
    private SqlSessionFactory sqlSessionFactory = null;

    public DeviceDao(SqlSessionFactory factory) {
        this.sqlSessionFactory = factory;
    }

    public List<Device> select() {
        List<Device> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        list = session.selectList("com.domain.Device.select");
        session.close();

        return list;
    }

    public int insert(Device dev) {
        int id = -1;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            id = session.insert("com.domain.Device.insert", dev);
        }finally {
            session.commit();;
            session.close();
        }
        return id;
    }

    public static void main(String[] args) {
        DeviceDao devDao = new DeviceDao(MyBatisUtil.getSqlSessionFactory());
        Device dev = new Device(0, 1, 1, "test1", 10,
                "有功", "无", 10,
                10, 100, 10, 100,
                1);

        devDao.insert(dev);
        List<Device> devices = devDao.select();
        for(Device d : devices) {
            System.out.println(d.toString());
        }
    }
}
