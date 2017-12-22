package core;

import com.jnrsmcu.sdk.netdevice.RSServer;
import core.defs.DeviceType;
import core.event.MEvent;
import core.event.MType;
import core.event.MainLoop;
import core.handler.GUIUpdater;
import mapper.AlarmDataMapper;
import po.AlarmData;
import po.Device;
import gui.AlarmTable;
import gui.MonitorMenu;
import gui.DeviceTable;
import gui.MonitorToolBar;
import mapper.DeviceMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import util.MyBatisHelper;
import util.PropertiesUtil;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.*;

/**
 * @author haishand
 */
public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    private static JFrame mainWindow = null;
    private static RSServer rsServer = null;
    private static MainLoop mainLoop = null;
    public static JLabel statusBar;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        // initialize app
        init();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });

    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("智能制造感知数据采集平台v0.1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("images/icon.png"));

        JPanel mainPane = new JPanel();
        mainPane.setLayout(new BorderLayout());
        mainPane.add(MonitorToolBar.createToolBar(), BorderLayout.NORTH);

        /*
        JPanel pane = new JPanel();
        pane.setLayout(new BorderLayout());
        pane.add(DeviceTable.getInstance());
        mainPane.add(pane, BorderLayout.CENTER);
        */

        JSplitPane splitPane = new JSplitPane();
        splitPane.setDividerLocation(Toolkit.getDefaultToolkit().getScreenSize().width);
        splitPane.setLeftComponent(DeviceTable.getInstance());
        splitPane.setRightComponent(AlarmTable.getInstance());

        mainPane.add(splitPane, BorderLayout.CENTER);

        statusBar = new JLabel("青岛职业技术学院信息学院版权所有");
        statusBar.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        statusBar.setHorizontalAlignment(SwingConstants.RIGHT);
        mainPane.add(statusBar, BorderLayout.SOUTH);

        frame.setContentPane(mainPane);
        frame.setJMenuBar(MonitorMenu.createMenuBar());

        frame.pack();
        frame.setVisible(true);
        frame.setExtendedState(frame.getExtendedState() | 0x6);

        setMainWindow(frame);

    }

    private static void init() {
        // mainloop
        mainLoop = new MainLoop();
        new Thread(mainLoop).start();

        // init configuration
        initCfg();

        // start timers
        startTimers();

    }

    public static void sendEvent(MEvent event) {
        mainLoop.getMainQueue().offer(event);
    }

    private static void startTimers() {
        sendEvent(new MEvent(MType.ID_START_DATA_CHECK_TIMER, null, null));
        sendEvent(new MEvent(MType.ID_START_ALARM_CHECK_TIMER, null, null));
        sendEvent(new MEvent(MType.ID_START_UPDATE_GUI_TIMER, null, null));
    }

    public static void updateGUI() {
        DeviceTable.updateDeviceData();
        AlarmTable.updateAlarmData();
    }

/*    private static void loadData() {
        mainLoop.getMainQueue().add(new MEvent(MType.ID_UPDATE_GUI, null, null));
    }*/


    private static void initCfg() {
        PropertiesUtil.getInstance().load();

    }

/*    public static void repaint() {
        getMainWindow().repaint();
    }*/


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
