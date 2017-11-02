package action;

import core.Main;
import util.RSServerUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj instanceof JButton) {
            ((JButton) obj).setEnabled(!((JButton) obj).isEnabled());
            System.out.println("ddd");
        }else if(obj instanceof JMenuItem) {
        }
        RSServerUtil.start();
    }
}
