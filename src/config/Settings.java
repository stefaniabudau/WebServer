package config;

import exception.config.InvalidConfigurationFileException;

import java.io.IOException;

public class Settings {

    public static Persist persist;

    static {
        try {
            persist = new Persist("config/config.properties");
        } catch (InvalidConfigurationFileException | IOException e) {
            e.printStackTrace();
        }
    }
}
