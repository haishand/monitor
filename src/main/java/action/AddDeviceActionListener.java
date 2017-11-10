package action;

import gui.dialog.DeviceDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDeviceActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        DeviceDialog dialog = new DeviceDialog();
        dialog.pack();
        dialog.setVisible(true);
    }
}
