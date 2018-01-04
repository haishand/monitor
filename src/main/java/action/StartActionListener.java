package action;

import core.Main;
import util.RSServerUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        RSServerUtil.start();
    }
}
