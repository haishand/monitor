package core;

import com.jnrsmcu.sdk.netdevice.RSServer;
import core.event.MainLoop;
import gui.MonitorMenu;
import gui.MonitorTable;
import gui.MonitorToolBar;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import util.PropertiesUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @author haishand
 */
public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    private static JFrame mainWindow = null;
    private static RSServer rsServer = null;
    private static MainLoop mainLoop = null;

    public static void main(String[] args) {
        init();

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });

        // main mainLoop
        new Thread(mainLoop).start();

    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("监控服务器");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("images/icon.png"));

        MonitorTable newContentPane = MonitorTable.getInstance();
        newContentPane.setOpaque(true);
        newContentPane.add(MonitorToolBar.createToolBar(), "North");
        frame.setContentPane(newContentPane);

        frame.setJMenuBar(MonitorMenu.createMenuBar());

        frame.pack();
        frame.setVisible(true);
        frame.setExtendedState(frame.getExtendedState() | 0x6);

        setMainWindow(frame);

    }

    private static void init() {
        initCfg();
        loadData();
    }

    private static void loadData() {
//        MonitorTable.getInstance().updateData();
    }

    private static void initCfg() {
        PropertiesUtil.getInstance().load();

    }

    public static void repaint() {
        getMainWindow().repaint();
    }


    public static JFrame getMainWindow() {
        return mainWindow;
    }

    public static void setMainWindow(JFrame mainWindow) {
        Main.mainWindow = mainWindow;
    }

    public static MainLoop getMainLoop() {
        return mainLoop;
    }

    public static RSServer getRsServer() {
        return rsServer;
    }

    public static void setRsServer(RSServer rsServer) {
        Main.rsServer = rsServer;
    }
}
