package test.mock;

import config.Persist;
import exception.config.ConfigurationException;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class PersistMock {

    @Test
    public void testGetPortNumber() throws ConfigurationException {
        Persist mockerPersist = mock(Persist.class);

        when(mockerPersist.getPortNumber()).thenReturn(8134);
        Assert.assertEquals(mockerPersist.getPortNumber(), 8134);
    }

    @Test
    public void testGetRootDirectory() throws ConfigurationException {
        Persist mockerPersist = mock(Persist.class);
        String rootDir = "htdocs";

        when(mockerPersist.getRootDir()).thenReturn(rootDir);
        Assert.assertEquals(mockerPersist.getRootDir(), rootDir);
    }

    @Test
    public void testGetMaintenanceDir() throws ConfigurationException {
        Persist mockerPersist = mock(Persist.class);
        String maintenanceDir = "maintenance";

        when(mockerPersist.getMaintenanceDir()).thenReturn(maintenanceDir);
        Assert.assertEquals(mockerPersist.getMaintenanceDir(), maintenanceDir);
    }

    @Test
    public void testSetPortNumber() throws ConfigurationException {
        Persist mockerPersist = mock(Persist.class);

        mockerPersist.setPortNumber(8140);
        verify(mockerPersist).setPortNumber(8140);
    }

    @Test
    public void testSetRootDir() throws ConfigurationException {
        Persist mockerPersist = mock(Persist.class);

        mockerPersist.setRootDir("htdocs");
        verify(mockerPersist).setRootDir("htdocs");
    }

    @Test
    public void testSetMaintenanceDir() throws Exception {
        Persist mockerPersist = mock(Persist.class);

        mockerPersist.setMaintenanceDir("maintenance");
        verify(mockerPersist).setMaintenanceDir("maintenance");
    }
}

