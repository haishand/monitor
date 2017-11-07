package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Arrays;
import java.util.Vector;

public class AlarmTable extends JPanel {
    private static AlarmTable instance;
    private JTable table;

    public static AlarmTable getInstance() {
        if(instance == null) {
            instance = new AlarmTable();
        }
        return instance;
    }

    public static String[] COLUMN_NAMES = {
            "设备名称",
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
}
