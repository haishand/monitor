package gui;

import core.defs.DeviceStatus;
import core.defs.DeviceType;
import gui.dialog.DeviceDialog;
import mapper.DeviceMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import po.Device;
import util.MyBatisHelper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutionException;

/**
 * @author haishand
 */
public class DeviceTable extends JPanel {
    private static DeviceTable instance;
    private JTable table;

    public static DeviceTable getInstance() {
        if (instance == null) {
            instance = new DeviceTable();
        }
        return instance;
    }

    public static String[] COLUMN_NAMES = {
            "设备Id",
            "节点Id",
            "设备名",
            "设备类型",
            "参数1名字",
            "参数2名字",
            "参数1报警下限",
            "参数1报警上限",
            "参数2报警下限",
            "参数2报警上限",
            "设备状态"
    };

    private DeviceTable() {
        super(new BorderLayout());

        Object[][] data = {};
        table = new JTable(data, COLUMN_NAMES);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
        table.setSelectionMode(0);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, "Center");

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    // double-click to view
                    int row = table.getSelectedRow();
                    if (row > -1) {
                        DeviceDialog dialog = new DeviceDialog();
                        dialog.fillDevPaneData(DeviceTable.this.getSelectedRow());
                        dialog.freezeDevPaneData();

                        // show dialog
                        dialog.setModal(true);
                        dialog.pack();
                        dialog.setLocationRelativeTo(null);
                        dialog.setVisible(true);
                    }
                }

            }
        });

    }

    public JTable getTable() {
        return table;
    }

    public Vector<Object> getSelectedRow() {
        if (this.table.getSelectedRow() == -1) {
            return null;
        }
        DefaultTableModel model = (DefaultTableModel) this.table.getModel();
        return (Vector) model.getDataVector().get(this.table.getSelectedRow());
    }

    public static void setModel(Vector<Vector<Object>> rows) {
        DeviceTable mtable = DeviceTable.getInstance();
        DefaultTableModel tm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tm.setDataVector(rows, new Vector(Arrays.asList(COLUMN_NAMES)));
        mtable.table.setModel(tm);
    }

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
                        row.add(DeviceType.valueToDesc(dev.getDeviceType()));
                        row.add(dev.getParam1Name());
                        row.add(dev.getParam2Name());
                        row.add(dev.getLowAlarmLimit1());
                        row.add(dev.getHiAlarmLimit1());
                        row.add(dev.getLowAlarmLimit2());
                        row.add(dev.getHiAlarmLimit2());
                        row.add(DeviceStatus.valueToDesc(dev.getOnlineStatus()));
                        rows.add(row);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
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
}
