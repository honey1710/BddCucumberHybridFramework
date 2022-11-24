package com.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configReader{


    private Properties properties;

    public String readConfig(String key){
        properties=new Properties();
        try {
            FileInputStream fis=new FileInputStream("src\\resources\\config\\config.properties");
            properties.load(fis);
            return properties.getProperty(key);
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
