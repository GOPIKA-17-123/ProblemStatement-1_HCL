package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    Properties prop;
    public ConfigReader() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            prop.load(fis);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getBrowser() {
        return prop.getProperty("browser");
    }
    public String getBaseUrl() {
        return prop.getProperty("baseUrl");
    }
    public String getValidEmail() {
        return prop.getProperty("validEmail");
    }
    public String getValidPassword() {
        return prop.getProperty("validPassword");
    }
    public String getInvalidPassword() {
        return prop.getProperty("invalidPassword");
    }
    public String getEmail(){
        return prop.getProperty("email");
    }
    public String getPassword(){
        return prop.getProperty("password");
    }
}