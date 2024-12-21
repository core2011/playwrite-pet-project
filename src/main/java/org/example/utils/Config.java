package org.example.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private Properties properties;

    public Config() throws IOException {
        properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("application.properties");
        properties.load(fileInputStream);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}
