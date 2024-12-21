package org.example.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private Properties prop = new Properties();

    public Config() {
        try (FileInputStream input = new FileInputStream("src/main/resources/application.properties")) {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getSiteUrl(String key) {
        return prop.getProperty(key);
    }

}
