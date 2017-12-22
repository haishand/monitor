package action;

import gui.dialog.LogDialog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        LogDialog dialog = new LogDialog();
        dialog.setSize(new Dimension(300, 400));

        // MUST be put after setSize
        dialog.setLocationRelativeTo(null);

//        dialog.pack();
        dialog.setVisible(true);
    }
}
