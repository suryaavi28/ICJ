package com.utilis;

import java.io.FileInputStream;		
import java.io.IOException;
import java.util.Properties;


public class ReadConfigUtilities {
    private Properties properties;

    

    public void readConfig() {
        properties = new Properties();
        

        try {
        	String configFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties";
            FileInputStream fileInputStream = new FileInputStream(configFilePath);
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
