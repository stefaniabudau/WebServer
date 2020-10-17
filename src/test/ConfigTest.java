package test;

import config.Config;
import exception.InvalidConfigurationFileException;
import exception.SaveConfigurationFailureException;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConfigTest {

    @Test
    public void testSetSetting(){
        Config config = new Config("valid config");
        assertTrue(config.setSetting("Port number", "10008"));
    }


    @Test
    public void testLoadConfigurationOk() throws InvalidConfigurationFileException {
        Config config = new Config("valid config");
        config.loadConfiguration("path to valid config file");
    }


    @Test(expected = InvalidConfigurationFileException.class)
    public void testLoadConfigurationBad() throws InvalidConfigurationFileException {
        Config config = new Config("valid config");
        config.loadConfiguration("path to invalid config file");
    }


    @Test(expected = SaveConfigurationFailureException.class)
    public void testSaveConfigurationBad() throws SaveConfigurationFailureException {
        Config config = new Config("valid config");
        config.saveConfiguration();
    }
}
