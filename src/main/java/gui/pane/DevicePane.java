package gui.pane;

import javax.swing.*;
import java.util.Vector;

public class DevicePane {
    private JTabbedPane tabbedPane1;
    private JComboBox cbDevType;
    private JTextField txtDevName;
    private JTextField txtDevAddr;
    private JCheckBox checkMulti;
    private JTextField txtParam1Name;
    private JTextField txtParam2Name;
    public JPanel contentPane;
    private JLabel cbSaveFreq;
    private JTextField txtP1HighLimit;
    private JTextField txtP1LowLimit;
    private JTextField txtP2HighLimit;
    private JTextField txtP2LowLimit;
    private JSpinner spNodeId;
    private JSpinner spSaveFreq;
    private JSpinner spWarnFreq;

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
