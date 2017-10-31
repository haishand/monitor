package gui;

import javax.swing.*;
import java.awt.*;

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
            "监控参数1",
            "监控参数2",
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
}
