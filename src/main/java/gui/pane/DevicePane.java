package gui.pane;

import mapper.DeviceMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import po.Device;
import util.MyBatisHelper;

import javax.swing.*;
import java.util.Vector;

/**
 * @author haishand
 */
public class DevicePane {
    public static final String[] DEV_TYPES = {"温湿度", "电能"};

    private JTabbedPane tabbedPane1;
    private JComboBox cbDevType;
    private JTextField txtDevName;
    private JTextField txtDevAddr;
    private JCheckBox checkMulti;
    private JTextField txtParam1Name;
    private JTextField txtParam2Name;
    public JPanel contentPane;
    private JTextField txtP1HighLimit;
    private JTextField txtP1LowLimit;
    private JTextField txtP2HighLimit;
    private JTextField txtP2LowLimit;
    private JSpinner spNodeId;
    private JTextField txtDevId;


    public DevicePane() {
    }

    public void populate(Vector<Object> data) {
        this.txtDevName.setText(data.get(0).toString());
    }

    public void freeze() {
        // TODO: Yajuan Zhang, Please set all fileds to disabled.
        // TODO: eg: txtDevName.setEnable(false);
        txtDevName.setEnabled(false);
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("DevicePane");
        frame.setContentPane(new DevicePane().contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void saveToDB() {
        Device device = new Device();

        // TODO: xiang Wang, populate device object with values like below
        // Populate data
        device.setDeviceId(Integer.parseInt(txtDevId.getText().trim()));

        // Insert to DB
        SqlSession session = MyBatisHelper.getSqlSessionFactory().openSession();
        try {
            DeviceMapper mapper = session.getMapper(DeviceMapper.class);
            mapper.insert(device);

            session.commit();
        }finally {
            session.close();
        }

    }
}
