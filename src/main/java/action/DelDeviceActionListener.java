package action;

import core.Main;
import gui.DeviceTable;
import mapper.DeviceMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import po.Device;
import po.DeviceExample;
import util.MyBatisHelper;
import util.RSServerUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class DelDeviceActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Vector<Object> row = DeviceTable.getInstance().getSelectedRow();
        if (row == null) {
            JOptionPane.showMessageDialog(null, "请先选择一条记录", "提示", 1);
        } else {
            int confirm = JOptionPane.showConfirmDialog(null, "确认删除所选记录?", "提示", 0);
            if (confirm == 0) {
                int devId = Integer.parseInt(row.get(0).toString());

                SqlSessionFactory sqlSessionFactory = MyBatisHelper.getSqlSessionFactory();
                SqlSession session = sqlSessionFactory.openSession();

                try {
                    DeviceMapper mapper = session.getMapper(DeviceMapper.class);
                    DeviceExample example = new DeviceExample();
                    example.createCriteria().andDeviceIdEqualTo(devId);
                    mapper.deleteByExample(example);
                    session.commit();
                }catch(Exception ex) {
                    ex.printStackTrace();

                } finally {
                    session.close();
                }
            }
        }

    }

}

/*
            "设备Id",
            "节点Id",
            "设备名",
            "设备类型",
            "参数1名字",
            "参数2名字",
            "参数1报警下限",
            "参数1报警上限",
            "参数2报警下限",
            "参数2报警上限",
            "设备状态"
*/