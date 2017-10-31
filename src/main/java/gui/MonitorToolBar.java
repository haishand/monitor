package gui;

import action.SettingActionListener;
import action.StartActionListener;
import action.StopActionListener;

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
        btnStart.addActionListener(new StartActionListener());
        toolBar.add(btnStart);

        btnStop = makeNavigationButton("stop", "停止监控服务", "停止");
        btnStop.addActionListener(new StopActionListener());
        toolBar.add(btnStop);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnStart.setEnabled(false);
                btnStop.setEnabled(true);
            }
        });

        btnSetting = makeNavigationButton("setting", "设置系统参数", "设置");
        btnSetting.addActionListener(new SettingActionListener());
        toolBar.add(btnSetting);

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
