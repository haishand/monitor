package action;

import util.RSServerUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        RSServerUtil.stop();
    }
}
