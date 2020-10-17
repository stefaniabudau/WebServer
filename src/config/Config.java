package config;

import exception.InvalidConfigurationFileException;
import exception.SaveConfigurationFailureException;
import validator.ConfigFileValidator;

public class Config {
    public Config(String config){}

    public void loadConfiguration(String configFile) throws InvalidConfigurationFileException {
        if(!ConfigFileValidator.validate()){
            throw new InvalidConfigurationFileException();
        }
    }

    public void saveConfiguration() throws SaveConfigurationFailureException {
        throw new SaveConfigurationFailureException();
    }

    public String getSetting(String key){
        return null;
    }

    public boolean setSetting(String key, String name){
        return false;
    }


}
