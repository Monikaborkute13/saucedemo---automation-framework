package utilities;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    Properties prop;

    public ConfigReader() {
        try {
            InputStream is = getClass()
                    .getClassLoader()
                    .getResourceAsStream("config.properties");

            prop = new Properties();
            prop.load(is);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return prop.getProperty("url");
    }

    public String getUsername() {
        return prop.getProperty("username");
    }

    public String getPassword() {
        return prop.getProperty("password");
    }
}