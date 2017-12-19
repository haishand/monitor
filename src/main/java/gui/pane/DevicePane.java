package gui.pane;

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

}
