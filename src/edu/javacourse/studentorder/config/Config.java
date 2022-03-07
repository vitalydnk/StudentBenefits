package edu.javacourse.studentorder.config;

import com.sun.source.tree.BreakTree;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    public static final String DB_URL = "db.url";
    public static final String DB_LOGIN = "db.login";
    public static final String DB_PASSWORD = "db.password";
    public static final String DB_LIMIT = "db.limit";
//    public static final String GET_STREET = "get_street";

    private static Properties properties = new Properties();

    public synchronized static String getProperty(String name){
        if (properties.isEmpty()){
            try (InputStream is = Config.class.getClassLoader().
                    getResourceAsStream("dao.properties")){
                properties.load (is);
            } catch (IOException ex){
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        }
        return properties.getProperty(name);
    }

}
