package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationManager {

    private static volatile ConfigurationManager manager;
    private static final Properties prop = new Properties();

    private ConfigurationManager() throws IOException {

        InputStream inputStream = ConfigurationManager.class.getResourceAsStream("..Resources/config.properties");

        if (inputStream == null) {
            throw new IOException("config.properties not found");
        }
        prop.load(inputStream);
    }

    public static ConfigurationManager getInstance() {
        if (manager == null) {
            synchronized (ConfigurationManager.class) {
                if (manager == null) {
                    try {
                        manager = new ConfigurationManager();
                    } catch (IOException e) {
                        e.printStackTrace();
                        throw new RuntimeException("Failed to initialize ConfigurationManager", e);
                    }

                }
            }
        }
        return manager;
    }

    public String getString(String key) {
        return System.getProperty(key, prop.getProperty(key));
    }

}

