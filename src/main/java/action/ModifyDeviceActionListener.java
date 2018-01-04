package action;

import gui.DeviceTable;
import gui.dialog.DeviceDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class ModifyDeviceActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        int row = DeviceTable.getInstance().getTable().getSelectedRow();
        if (row > -1) {
            DeviceDialog dialog = new DeviceDialog();
            dialog.fillDevPaneData(DeviceTable.getInstance().getSelectedRow());

            // show dialog
            dialog.setModal(true);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        }

    }
}
