package gui;

import core.Main;
import core.defs.AlarmStatus;
import mapper.AlarmDataMapper;
import mapper.DeviceDataMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import po.AlarmData;
import util.MyBatisHelper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutionException;

public class AlarmTable extends JPanel {
    private static AlarmTable instance;
    private JTable table;
    JPopupMenu popupMenu;

    public static AlarmTable getInstance() {
        if(instance == null) {
            instance = new AlarmTable();
        }
        return instance;
    }

    public static String[] COLUMN_NAMES = {
            "报警ID",
            "设备号",
            "报警类型",
            "报警值",
            "报警时间",
            "处理状态",
    };

    private AlarmTable() {
        super(new BorderLayout());

        Object[][] data = {};
        table = new JTable(data, COLUMN_NAMES);
        table.setAutoResizeMode(0);
        table.setSelectionMode(0);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, "Center");

        createPopupMenu();

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON3) {
                    int idx = table.rowAtPoint(e.getPoint());
                    if(idx == -1) {
                        return;
                    }

                    table.setRowSelectionInterval(idx, idx);
                    popupMenu.show(table, e.getX(), e.getY());
                }
            }
        });

    }

    public JTable getTable() {
        return table;
    }

    public static void setModel(Vector<Vector<Object>> rows) {
        AlarmTable mtable = AlarmTable.getInstance();
        DefaultTableModel tm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tm.setDataVector(rows, new Vector(Arrays.asList(COLUMN_NAMES)));
        mtable.table.setModel(tm);
    }

    public Vector<Object> getSelectedRow() {
        if(this.table.getSelectedRow() == -1) {
            return null;
        }
        DefaultTableModel model = (DefaultTableModel)this.table.getModel();
        return (Vector)model.getDataVector().get(this.table.getSelectedRow());
    }

    private void createPopupMenu() {
        popupMenu = new JPopupMenu();

        JMenuItem delMenuItem = new JMenuItem();
        JMenuItem markMenuItem = new JMenuItem();

        delMenuItem.setText("删除");
        markMenuItem.setText("标记已处理");

        delMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<Object> v = AlarmTable.getInstance().getSelectedRow();
                int alarmId = Integer.parseInt(v.get(0).toString());

                SqlSession session = MyBatisHelper.getSqlSessionFactory().openSession();
                AlarmDataMapper mapper = session.getMapper(AlarmDataMapper.class);
                try {
                    mapper.deleteByPrimaryKey(alarmId);
                    session.commit();
                }catch(Exception ex) {
                    ex.printStackTrace();
                }finally {
                    session.close();
                    Main.updateGUI();
                }

            }
        });

        markMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<Object> v = AlarmTable.getInstance().getSelectedRow();
                int alarmId = Integer.parseInt(v.get(0).toString());

                SqlSession session = MyBatisHelper.getSqlSessionFactory().openSession();
                AlarmDataMapper mapper = session.getMapper(AlarmDataMapper.class);
                try {
                    AlarmData alarm = new AlarmData();
                    alarm.setId(alarmId);
                    alarm.setStatus(AlarmStatus.TREATED.getValue());
                    mapper.updateByPrimaryKeySelective(alarm);
                    session.commit();
                }catch(Exception ex) {
                    ex.printStackTrace();
                }finally {
                    session.close();
                    Main.updateGUI();
                }
            }
        });

        popupMenu.add(delMenuItem);
        popupMenu.add(markMenuItem);
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
                        row.add(data.getId());
                        row.add(data.getCode());
                        row.add(data.getType());
                        row.add(data.getValue());
                        row.add(data.getRecordtime());
                        row.add(AlarmStatus.valueToDesc(data.getStatus()));

                        rows.add(row);
                    }
                } catch(Exception e) {
                    e.printStackTrace();
                } finally{
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
