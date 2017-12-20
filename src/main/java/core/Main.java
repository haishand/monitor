package core;

import com.jnrsmcu.sdk.netdevice.RSServer;
import core.event.MEvent;
import core.event.MType;
import core.event.MainLoop;
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
        JFrame frame = new JFrame("智能制造感知数据采集平台");
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

        updateDeviceData();
    }

    private static void startTimers() {
        mainLoop.getMainQueue().add(new MEvent(MType.ID_ALARM_CHECK_TIMER_START, null, null));
    }

/*    private static void loadData() {
        mainLoop.getMainQueue().add(new MEvent(MType.ID_UPDATE_DATA, null, null));
    }*/

    public static void updateDeviceData() {
        new SwingWorker() {

            @Override
            protected Vector<Vector<Object>> doInBackground() throws Exception {
                SqlSessionFactory sqlSessionFactory = MyBatisHelper.getSqlSessionFactory();
                SqlSession session = sqlSessionFactory.openSession();
                Vector<Vector<Object>> rows = null;
                try {
                    DeviceMapper deviceMapper = session.getMapper(DeviceMapper.class);
                    List<Device> devList = deviceMapper.selectByExample(null);
                    rows = new Vector<Vector<Object>>();
                    for (Device dev : devList) {
                        Vector<Object> row = new Vector<Object>();
                        row.add(dev.getDeviceId());
                        row.add(dev.getNodeId());
                        row.add(dev.getDeviceName());
                        row.add(dev.getParam1Name());
                        row.add(dev.getParam2Name());
                        row.add(dev.getSaveInterval());
                        row.add(dev.getLowAlarmLimit1());
                        row.add(dev.getHiAlarmLimit1());
                        row.add(dev.getLowAlarmLimit2());
                        row.add(dev.getHiAlarmLimit2());
                        row.add(dev.getOnlineStatus());
                        rows.add(row);
                    }
                } finally {
                    session.close();
                }

                return rows;
            }

            @Override
            protected void done() {
                Vector<Vector<Object>> rows = null;
                try {
                    rows = (Vector) get();
                    if (rows != null) {
                        DeviceTable.setModel(rows);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

            }
        }.execute();
    }

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

    public static void updateAlarmData() {
        new SwingWorker() {

            @Override
            protected Vector<Vector<Object>> doInBackground() throws Exception {
                SqlSessionFactory sqlSessionFactory = MyBatisHelper.getSqlSessionFactory();
                SqlSession session = sqlSessionFactory.openSession();
                Vector<Vector<Object>> rows = null;

                try {
                    AlarmDataMapper mapper = session.getMapper(AlarmDataMapper.class);
                    List<AlarmData> alarmDataList = mapper.selectByExample(null);
                    rows = new Vector<Vector<Object>>();
                    for (AlarmData data : alarmDataList) {
                        Vector<Object> row = new Vector<Object>();
                        row.add(data.getCode());
                        row.add(data.getType());
                        row.add(data.getValue());
                        row.add(data.getRecordtime());
                        row.add(data.getStatus());

                        rows.add(row);
                    }
                } finally {
                    session.close();
                }
                return rows;
            }

            @Override
            protected void done() {
                Vector<Vector<Object>> rows = null;
                try {
                    rows = (Vector) get();
                    if (rows != null) {
                        AlarmTable.setModel(rows);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

            }
        }.execute();
    }
}
