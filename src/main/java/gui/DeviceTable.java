package gui;

import gui.dialog.DeviceDialog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Vector;

/**
 * @author haishand
 */
public class DeviceTable extends JPanel{
    private static DeviceTable instance;
    private JTable table;

    public static DeviceTable getInstance() {
        if(instance == null) {
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
            "保存间隔",
            "参数1报警下限",
            "参数1报警上限",
            "参数2报警下限",
            "参数2报警上限",
            "报警状态",
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
                if(e.getButton() == MouseEvent.BUTTON2) {
                    // right-click to modify
                    int row = table.getSelectedRow();
                    if(row > -1) {
                        DeviceDialog dialog = new DeviceDialog();
                        dialog.fillDevPaneData(DeviceTable.this.getSelectedRow());

                        // show dialog
                        dialog.setModal(true);
                        dialog.pack();
                        dialog.setLocationRelativeTo(null);
                        dialog.setVisible(true);
                    }

                }else if(e.getClickCount() == 2) {
                    // double-click to view

                    int row = table.getSelectedRow();
                    if(row > -1) {
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

    private Vector<Object> getSelectedRow() {
        if(this.table.getSelectedRow() == -1) {
            return null;
        }
        DefaultTableModel model = (DefaultTableModel)this.table.getModel();
        return (Vector)model.getDataVector().get(this.table.getSelectedRow());
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
}
