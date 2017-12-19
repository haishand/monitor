package gui.dialog;

import core.Main;
import util.PropertiesUtil;

import javax.swing.*;
import java.awt.event.*;

public class SettingDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTabbedPane tabbedPane1;
    private JTextField txtIp;
    private JTextField txtPort;
    private JSpinner spDataCheckTimer;
    private JSpinner spAlarmCheckTimer;

    public SettingDialog() {
        super(Main.getMainWindow(), true);

        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);


        // load config data
        populateData();
    }

    private void populateData() {
        // TODO: yajuan change here to load data on the gui
        String ip = PropertiesUtil.getInstance().getValue("IP");
        String port = PropertiesUtil.getInstance().getValue("PORT");
        txtIp.setText(ip);
        txtPort.setText(port);
    }

    private void onOK() {
        String ip = txtIp.getText().trim();
        String port = txtPort.getText().trim();
        String dataTimer = String.valueOf(spDataCheckTimer.getValue());
        String alarmTimer = String.valueOf(spAlarmCheckTimer.getValue());

        PropertiesUtil.getInstance().store("IP", ip);
        PropertiesUtil.getInstance().store("PORT", port);
        PropertiesUtil.getInstance().store("ALARM_CHECK_TIMER", dataTimer);
        PropertiesUtil.getInstance().store("DATA_CHECK_TIMER", alarmTimer);

        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        SettingDialog dialog = new SettingDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
