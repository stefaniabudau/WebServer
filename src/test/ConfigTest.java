package test;

import config.Config;
import exception.InvalidPortNumberException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConfigTest {

    @Test
    public void testSetSetting(){
        Config config = new Config("valid config");
        assertTrue(config.setSetting("Port number", "10008"));
    }
}
