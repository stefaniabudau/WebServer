package test;

import config.Config;
import exception.config.*;
import org.junit.Test;
import org.junit.Assert;

import java.io.IOException;


public class ConfigTest {

    @Test
    public void testLoadConfig() throws IOException, InvalidConfigurationFileException {
        Config.getConfig("config/test.properties");
    }

    @Test
    public void testLoadConfigSingleton() throws IOException, InvalidConfigurationFileException {
        Config config1 = Config.getConfig("config/test.properties");
        Config config2 = Config.getConfig("config/config.properties");
        Assert.assertTrue(config1.equals(config2));
    }

    @Test
    public void testSaveConfiguration() throws IOException, InvalidConfigurationFileException {
        Config config = Config.getConfig("config/test.properties");
        config.saveConfiguration();
    }

    @Test(expected = NullSettingException.class)
    public void testGetInvalidKeySetting() throws IOException, ConfigurationException {
        Config config = Config.getConfig("config/test.properties");
        config.getSetting("invalid key");
    }

    @Test(expected = InvalidSettingException.class)
    public void testGetNullSetting() throws IOException, ConfigurationException {
        Config config = Config.getConfig("config/test.properties");
        config.getSetting(null);
    }

    @Test(expected = InvalidSettingException.class)
    public void testSetNullKeySetting() throws IOException, ConfigurationException {
        Config config = Config.getConfig("config/test.properties");
        config.setSetting(null, "some value");
    }

    @Test(expected = InvalidSettingException.class)
    public void testSetNullValueSetting() throws IOException, ConfigurationException {
        Config config = Config.getConfig("config/test.properties");
        config.setSetting("key", null);
    }

    @Test(expected = InvalidSettingException.class)
    public void testSetNullSetting() throws IOException, ConfigurationException {
        Config config = Config.getConfig("config/test.properties");
        config.setSetting(null, null);
    }

    @Test(expected = InvalidSettingException.class)
    public void testSetInvalidKeySetting() throws ConfigurationException, IOException {
        Config config = Config.getConfig("config/test.properties");
        config.setSetting("key", "val");
    }

    @Test
    public void testSetValidKeySetting() throws ConfigurationException, IOException {
        Config config = Config.getConfig("config/test.properties");
        config.setSetting("port", "12345");
    }
}
