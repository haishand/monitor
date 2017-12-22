package gui;

import action.*;

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

        menuItem = new JMenuItem("日志");
        menuItem.addActionListener(new SettingActionListener());
        menu.add(menuItem);
        addIcon(menuItem, "m_log");

        // device menu
        menu = new JMenu("设备");
        menuBar.add(menu);
        menuItem = new JMenuItem("添加");
        menu.add(menuItem);
        menuItem.addActionListener(new AddDeviceActionListener());
        addIcon(menuItem, "m_add");

        menuItem = new JMenuItem("修改");
        menu.add(menuItem);
        menuItem.addActionListener(new ModifyDeviceActionListener());
        addIcon(menuItem, "m_modify");

        menuItem = new JMenuItem("删除");
        menu.add(menuItem);
        menuItem.addActionListener(new DelDeviceActionListener());
        addIcon(menuItem, "m_delete");

        menuItem = new JMenuItem("扫描");
        menu.add(menuItem);
        addIcon(menuItem, "m_scan");

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
