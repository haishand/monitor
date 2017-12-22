package gui.pane;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import core.defs.DeviceType;
import mapper.DeviceMapper;
import org.apache.ibatis.session.SqlSession;
import po.Device;
import po.DeviceExample;
import util.MyBatisHelper;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * @author haishand
 */
public class DevicePane {
    public static final String[] DEV_TYPES = {"温湿度", "电能"};

    private JTabbedPane tabbedPane1;
    private JComboBox cbDevType;
    private JTextField txtDevName;
    private JCheckBox checkMulti;
    private JTextField txtParam1Name;
    private JTextField txtParam2Name;
    public JPanel contentPane;
    private JTextField txtHiAlarmLimit1;
    private JTextField txtLowAlarmLimit1;
    private JTextField txtHiAlarmLimit2;
    private JTextField txtLowAlarmLimit2;
    private JSpinner spNodeId;
    private JTextField txtDevId;
    private JTextField txtCode;


    public DevicePane() {
        cbDevType.addItem(DeviceType.HUMITURE_DEVICE.getDesc());
        cbDevType.addItem(DeviceType.EMETER_DEVICE.getDesc());
    }

    public void populate(Vector<Object> data) {
        /*
            "设备号",
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
        this.txtCode.setText(data.get(0).toString());
        this.txtDevId.setText(data.get(1).toString());
        this.spNodeId.setValue(Integer.parseInt(data.get(2).toString()));
        this.txtDevName.setText(data.get(3).toString());
        this.txtParam1Name.setText(data.get(4).toString());
        this.txtParam2Name.setText(data.get(5).toString());
        this.txtLowAlarmLimit1.setText(data.get(6).toString());
        this.txtHiAlarmLimit1.setText(data.get(7).toString());
        this.txtLowAlarmLimit2.setText(data.get(8).toString());
        this.txtHiAlarmLimit2.setText(data.get(9).toString());

    }

    public void freeze() {
        this.txtCode.setEnabled(false);
        this.cbDevType.setEnabled(false);
        this.txtDevId.setEnabled(false);
        this.spNodeId.setEnabled(false);
        this.checkMulti.setEnabled(false);
        this.txtDevName.setEnabled(false);
        this.txtParam1Name.setEnabled(false);
        this.txtParam2Name.setEnabled(false);
        this.txtLowAlarmLimit1.setEnabled(false);
        this.txtHiAlarmLimit1.setEnabled(false);
        this.txtLowAlarmLimit2.setEnabled(false);
        this.txtHiAlarmLimit2.setEnabled(false);
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

        // Populate data
        device.setCode(Integer.parseInt(txtCode.getText()));
        device.setDeviceName(txtDevName.getText().trim());
        device.setDeviceId(Integer.parseInt(txtDevId.getText().trim()));
        device.setDeviceType(DeviceType.descToValue(cbDevType.getSelectedItem().toString()).getValue());
        device.setMultiFlag(checkMulti.isSelected());
        device.setNodeId((Integer) spNodeId.getValue());
        device.setParam1Name(txtParam1Name.getText());
        device.setParam2Name(txtParam2Name.getText());
        device.setLowAlarmLimit1(Float.parseFloat(txtLowAlarmLimit1.getText()));
        device.setHiAlarmLimit1(Float.parseFloat(txtHiAlarmLimit1.getText()));
        device.setLowAlarmLimit2(Float.parseFloat(txtLowAlarmLimit2.getText()));
        device.setHiAlarmLimit2(Float.parseFloat(txtHiAlarmLimit2.getText()));

        // Insert to DB
        SqlSession session = MyBatisHelper.getSqlSessionFactory().openSession();
        try {
            DeviceMapper mapper = session.getMapper(DeviceMapper.class);
            DeviceExample example = new DeviceExample();
            example.createCriteria().andCodeEqualTo(device.getCode());
            long count = mapper.countByExample(example);
            if (count != 0) {
                // modify
                mapper.updateByPrimaryKeySelective(device);
            } else {
                mapper.insert(device);
            }

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        contentPane = new JPanel();
        contentPane.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1 = new JTabbedPane();
        contentPane.add(tabbedPane1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("设备参数", panel1);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(12, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("节点类型");
        panel2.add(label1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel2.add(spacer1, new GridConstraints(11, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("设备名称");
        panel2.add(label2, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        txtDevName = new JTextField();
        panel2.add(txtDevName, new GridConstraints(3, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("节点编号");
        panel2.add(label3, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cbDevType = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        cbDevType.setModel(defaultComboBoxModel1);
        panel2.add(cbDevType, new GridConstraints(1, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        checkMulti = new JCheckBox();
        checkMulti.setText("多个");
        panel2.add(checkMulti, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("模拟量1名称");
        panel2.add(label4, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        txtParam1Name = new JTextField();
        panel2.add(txtParam1Name, new GridConstraints(5, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("模拟量2名称");
        panel2.add(label5, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        txtParam2Name = new JTextField();
        panel2.add(txtParam2Name, new GridConstraints(6, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("模拟量1报警上限");
        panel2.add(label6, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        txtHiAlarmLimit1 = new JTextField();
        panel2.add(txtHiAlarmLimit1, new GridConstraints(7, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("模拟量1报警下限");
        panel2.add(label7, new GridConstraints(8, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        txtLowAlarmLimit1 = new JTextField();
        panel2.add(txtLowAlarmLimit1, new GridConstraints(8, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("模拟量2报警上限");
        panel2.add(label8, new GridConstraints(9, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        txtHiAlarmLimit2 = new JTextField();
        panel2.add(txtHiAlarmLimit2, new GridConstraints(9, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label9 = new JLabel();
        label9.setText("模拟量2报警下限");
        panel2.add(label9, new GridConstraints(10, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        txtLowAlarmLimit2 = new JTextField();
        panel2.add(txtLowAlarmLimit2, new GridConstraints(10, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        spNodeId = new JSpinner();
        panel2.add(spNodeId, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label10 = new JLabel();
        label10.setText("设备地址");
        panel2.add(label10, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        txtDevId = new JTextField();
        panel2.add(txtDevId, new GridConstraints(2, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label11 = new JLabel();
        label11.setText("设备号");
        panel2.add(label11, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        txtCode = new JTextField();
        panel2.add(txtCode, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }
}
