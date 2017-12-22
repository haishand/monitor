package gui;

import action.*;
import util.RSServerUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MonitorToolBar {
    private static JButton btnStart, btnStop, btnSetting;

    public static JToolBar createToolBar() {
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);

        JButton button = null;

        btnStart = makeNavigationButton("start", "启动监控服务", "启动");
//        btnStart.addActionListener(new StartActionListener());
        toolBar.add(btnStart);

        btnStop = makeNavigationButton("stop", "停止监控服务", "停止");
//        btnStop.addActionListener(new StopActionListener());
        toolBar.add(btnStop);

        btnStart.setEnabled(true);
        btnStop.setEnabled(false);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RSServerUtil.start();
                btnStart.setEnabled(!btnStart.isEnabled());
                btnStop.setEnabled(!btnStop.isEnabled());
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RSServerUtil.stop();
                btnStart.setEnabled(!btnStart.isEnabled());
                btnStop.setEnabled(!btnStop.isEnabled());
            }
        });

        btnSetting = makeNavigationButton("setting", "设置系统参数", "设置");
        btnSetting.addActionListener(new SettingActionListener());
        toolBar.add(btnSetting);

        button = makeNavigationButton("add", "添加设备", "添加");
        button.addActionListener(new AddDeviceActionListener());
        toolBar.add(button);

        button = makeNavigationButton("scan", "扫描设备", "扫描");
        button.addActionListener(new ScanDeviceActionListener());
        toolBar.add(button);

        button = makeNavigationButton("delete", "删除设备", "删除");
        button.addActionListener(new DelDeviceActionListener());
        toolBar.add(button);

        button = makeNavigationButton("log", "系统日志", "日志");
        button.addActionListener(new LogActionListener());
        toolBar.add(button);


        return toolBar;
    }

    protected static JButton makeNavigationButton(String imageName, String toolTipText, String altText)
    {
        String imgLocation = "images/" + imageName + ".png";

        JButton button = new JButton();
        button.setToolTipText(toolTipText);

        File file = new File(imgLocation);
        if (file.exists())
        {
            button.setIcon(new ImageIcon(imgLocation, altText));
        }
        else
        {
            button.setText(altText);
            System.err.println("Resource not found: " + imgLocation);
        }
        return button;
    }
}
