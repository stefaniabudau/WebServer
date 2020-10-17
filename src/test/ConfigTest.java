package test;

import config.Config;
import exception.config.InvalidConfigurationFileException;
import exception.config.SaveConfigurationFailureException;
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
        String[] paths = {"good.txt", "good_file.txt", "good-file.txt", "GOOD.txt", "c:\\folder\\file.txt",
                "\\folder1\\file2.txt", "File2.txt", "folder\\filE.txt", };

        for(String path : paths ){
            config.loadConfiguration(path);
        }
    }


    @Test(expected = InvalidConfigurationFileException.class)
    public void testLoadConfigurationBad() throws InvalidConfigurationFileException {
        Config config = new Config("valid config");
        String[] paths = {"c:/te:t", "c:/te?t", "c/te*t", "not|good.txt", "not:good.txt", null, "1",
                "not-good", "not-good.doc", "not-good.png", "a"};

        for(String path : paths ) {
            config.loadConfiguration(path);
        }
    }


    @Test(expected = SaveConfigurationFailureException.class)
    public void testSaveConfigurationBad() throws SaveConfigurationFailureException {
        Config config = new Config("valid config");
        config.saveConfiguration();
    }
}
