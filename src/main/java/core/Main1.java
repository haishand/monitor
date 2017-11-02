package core;

import com.jnrsmcu.sdk.netdevice.RSServer;
import core.event.MainLoop;
import dao.DeviceDao;
import domain.Device;
import gui.MonitorMenu;
import gui.DeviceTable;
import gui.MonitorToolBar;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import util.MyBatisUtil;
import util.PropertiesUtil;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutionException;

/**
 * @author haishand
 */
public class Main1 {
    private static final Logger log = LogManager.getLogger(Main1.class);

    private static JFrame mainWindow = null;
    private static RSServer rsServer = null;
    private static MainLoop mainLoop = null;

    public static void main(String[] args) {
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

        init();

        // main mainLoop
        new Thread(mainLoop).start();

    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("监控服务器");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("images/icon.png"));

        DeviceTable newContentPane = DeviceTable.getInstance();
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
        updateData();
    }

/*    private static void loadData() {
        mainLoop.getMainQueue().add(new MEvent(MType.ID_UPDATE_DATA, null, null));
    }*/

    public static void updateData() {
        new SwingWorker() {

            @Override
            protected Vector<Vector<Object>> doInBackground() throws Exception {
                DeviceDao devDao = new DeviceDao(MyBatisUtil.getSqlSessionFactory());
                List<Device> devList = devDao.select();
                Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
                for(Device dev : devList) {
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

                return rows;
            }

            @Override
            protected void done() {
                Vector<Vector<Object>> rows = null;
                try {
                    rows = (Vector) get();
                    DeviceTable.setModel(rows);
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
        Main1.mainWindow = mainWindow;
    }

    public static MainLoop getMainLoop() {
        return mainLoop;
    }

    public static RSServer getRsServer() {
        return rsServer;
    }

    public static void setRsServer(RSServer rsServer) {
        Main1.rsServer = rsServer;
    }
}
