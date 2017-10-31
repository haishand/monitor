package gui;

import action.InfoActionListener;
import action.SettingActionListener;
import action.StartActionListener;
import action.StopActionListener;
import javafx.beans.Observable;

import javax.swing.*;

public class MonitorMenu {
    public static JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // system menu
        JMenu menu = new JMenu("系统");
        menuBar.add(menu);

        JMenuItem menuItem = new JMenuItem("启动");
        menuItem.addActionListener(new StartActionListener());
        menu.add(menuItem);
        addIcon(menuItem, "m_start");

        menuItem = new JMenuItem("停止");
        menuItem.addActionListener(new StopActionListener());
        menu.add(menuItem);
        addIcon(menuItem, "m_stop");

        menuItem = new JMenuItem("设置");
        menuItem.addActionListener(new SettingActionListener());
        menu.add(menuItem);
        addIcon(menuItem, "m_setting");

        // terminal menu

        // help menu
        menu = new JMenu("帮助");
        menuBar.add(menu);

        menuItem = new JMenuItem("关于系统");
        menuItem.addActionListener(new InfoActionListener());
        menu.add(menuItem);
        addIcon(menuItem, "m_info");

        return menuBar;
    }

    private static void addIcon(JMenuItem m, String iconName) {
        m.setIcon(new ImageIcon("images/" + iconName + ".png"));
    }
}
