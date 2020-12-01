package config;

import exception.config.ConfigurationException;
import exception.config.InvalidConfigurationFileException;
import exception.config.InvalidSettingException;
import exception.config.NullSettingException;
import validator.ConfigFileValidator;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Properties;

public class Config {

    private String config;
    private Properties properties;
    private static volatile Config singleton = null;

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
        if(!ConfigFileValidator.validateConfigFile(this.config)){
            throw new InvalidConfigurationFileException();
        }

        FileReader reader = new FileReader(this.config);
        this.properties.load(reader);

        reader.close();
    }

    public void saveConfiguration() throws IOException {
        FileWriter writer = new FileWriter(this.config);
        properties.store(writer, "");
        writer.close();
    }

    public String getSetting(String key) throws ConfigurationException {
        if(key == null) throw new InvalidSettingException();

        String setting = this.properties.getProperty(key);
        if(setting == null) throw new NullSettingException();

        return setting;
    }

    public void setSetting(String key, String name) throws InvalidSettingException {
        if(key == null || name == null) throw new InvalidSettingException();

        ArrayList<String> validKeys = new ArrayList<String>(){{
                add("root_directory");
                add("maintenance_dir");
                add("default_page");
                add("port");
                add("not_found_page");
        }};

        if(!validKeys.contains(key)) throw new InvalidSettingException();
        properties.setProperty(key, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Config config1 = (Config) o;
        return Objects.equals(config, config1.config) &&
                Objects.equals(properties, config1.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(config, properties);
    }
}
