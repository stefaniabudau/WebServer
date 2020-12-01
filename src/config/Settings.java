package config;

import exception.config.InvalidConfigurationFileException;

import java.io.IOException;

public class Settings {

    public static Config config;
    public static Persist persist;

    public static void init(){
        try {
            config = Config.getConfig("config/config.properties");
            persist = new Persist(config);

        } catch (InvalidConfigurationFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
