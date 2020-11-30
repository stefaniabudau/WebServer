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
    private static Config singleton = null;

    private Config(String config) throws InvalidConfigurationFileException, IOException {
        this.config = config;
        this.properties = new Properties();
        this.loadConfiguration();
    }


    public static Config getConfig(String config) throws InvalidConfigurationFileException, IOException {
        if(singleton == null)
            singleton = new Config(config);
        return singleton;
    }


    private void loadConfiguration() throws InvalidConfigurationFileException, IOException {
        FileReader reader = new FileReader(this.config);
        this.properties.load(reader);

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
