package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Arrays;
import java.util.Vector;

/**
 * @author haishand
 */
public class MonitorTable extends JPanel{
    private static MonitorTable instance;
    private JTable table;

    public static MonitorTable getInstance() {
        if(instance == null) {
            instance = new MonitorTable();
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

    private MonitorTable() {
        super(new BorderLayout());

        Object[][] data = {};
        table = new JTable(data, COLUMN_NAMES);
        table.setAutoResizeMode(0);
        table.setSelectionMode(0);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, "Center");

    }

    public static void setModel(Vector<Vector<Object>> rows) {
        MonitorTable mtable = MonitorTable.getInstance();
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
