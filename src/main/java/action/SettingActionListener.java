package action;

import gui.dialog.SettingDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        SettingDialog dialog = new SettingDialog();

        dialog.pack();

        // MUST be put after setSize
        dialog.setLocationRelativeTo(null);

        dialog.setVisible(true);
    }
}
