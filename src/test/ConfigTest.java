package test;

import config.Config;
import exception.config.InvalidConfigurationFileException;
import exception.config.SaveConfigurationFailureException;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConfigTest {


    /**
     * TO DO: Implement a more efficient test, avoid hardcoding
     * **/
    @Test
    public void testSetSetting(){
        Config config = new Config("valid config");

        assertTrue(config.setSetting("Port number", "10008"));
        assertTrue(config.setSetting("Root dir", "/rootdir"));
        assertTrue(config.setSetting("Maintenance Dir", "/mdir"));
    }


    @Test
    public void testLoadConfigurationOk() throws InvalidConfigurationFileException {
        Config config = new Config("valid config");
        String[] paths = {"good.txt", "good_file.txt", "good-file.txt", "GOOD.txt", "c:\\folder\\file.txt",
                "\\folder1\\file2.txt", "File2.txt", "folder\\filE.txt", };

        for(String path : paths ){
            config.loadConfiguration();
        }
    }


    @Test(expected = InvalidConfigurationFileException.class)
    public void testLoadConfigurationBad1() throws InvalidConfigurationFileException {
        Config config = new Config("valid config");
        config.loadConfiguration();
    }


    @Test(expected = InvalidConfigurationFileException.class)
    public void testLoadConfigurationBad2() throws InvalidConfigurationFileException {
        Config config = new Config("valid config");
        config.loadConfiguration();
    }


    @Test(expected = InvalidConfigurationFileException.class)
    public void testLoadConfigurationBad3() throws InvalidConfigurationFileException {
        Config config = new Config("valid config");
        config.loadConfiguration();
    }


    @Test(expected = InvalidConfigurationFileException.class)
    public void testLoadConfigurationBad4() throws InvalidConfigurationFileException {
        Config config = new Config("valid config");
        config.loadConfiguration();
    }


    @Test(expected = SaveConfigurationFailureException.class)
    public void testSaveConfigurationBad() throws SaveConfigurationFailureException {
        Config config = new Config("valid config");
        config.saveConfiguration();
    }
}
