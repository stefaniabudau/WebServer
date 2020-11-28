package config;

import exception.config.InvalidConfigurationFileException;
import exception.config.SaveConfigurationFailureException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private String config;
    private Properties properties;

    public Config(String config){
        this.config = config;
        this.properties = new Properties();
    }

    public void loadConfiguration() throws InvalidConfigurationFileException {
        try {
            FileReader reader = new FileReader(this.config);
            this.properties.load(reader);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        if(!ConfigFileValidator.validate()){
//            throw new InvalidConfigurationFileException();
//        }
    }

    public void saveConfiguration() throws SaveConfigurationFailureException, IOException {
        FileWriter writer = new FileWriter(this.config);
        properties.store(writer, "");
//        throw new SaveConfigurationFailureException();
    }

    public String getSetting(String key){
        return this.properties.getProperty(key);
    }

    public boolean setSetting(String key, String name){
        properties.setProperty(key, name);
        return true;
    }
}
