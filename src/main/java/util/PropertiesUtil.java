package util;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

public class PropertiesUtil {
    private static PropertiesUtil instance = null;
    private static String PROPERTIES_FILE_NAME = "monitor.cfg";
    public static enum ParamType {
        IP("IP"),
        PORT("PORT");

        private String name;

        ParamType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    };

    private Properties props = new Properties();
    private HashMap<String, String> params = new HashMap<String, String>();

    private PropertiesUtil() {

    }

    public static PropertiesUtil getInstance() {
        if(instance == null) {
            instance = new PropertiesUtil();
        }
        return instance;
    }

    public void load() {
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(PROPERTIES_FILE_NAME));
            props.load(in);
            Enumeration en = props.propertyNames();
            while(en.hasMoreElements()) {
                String key = (String) en.nextElement();
                String value = props.getProperty(key);
                params.put(key, value);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void store(String key, String val) {
        try {
            OutputStream os = new FileOutputStream(PROPERTIES_FILE_NAME);
            props.setProperty(key, val);
            props.store(os, "update key: " + key);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getValue(String key) {
        return params.get(key);
    }

    public static void main(String[] args) {
        PropertiesUtil.getInstance().load();
        System.out.println(PropertiesUtil.getInstance().getValue(ParamType.PORT.getName()));
    }
}
