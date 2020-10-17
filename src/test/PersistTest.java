package test;

import config.Persist;
import exception.InvalidMaintenanceDirException;
import exception.InvalidPortNumberException;
import exception.InvalidRootDirException;
import org.junit.Assert;
import org.junit.Test;

public class PersistTest {

    @Test
    public void testSetPortNumberOk() throws InvalidPortNumberException {
        Persist persist = new Persist();
        persist.setPortNumber(10008);
    }


    @Test(expected = InvalidPortNumberException.class)
    public void testSetPortNumberBad() throws InvalidPortNumberException {
        Persist persist = new Persist();
        persist.setPortNumber(0);
    }


    @Test
    public void testSetRootDirOk() throws InvalidRootDirException {
        Persist persist = new Persist();
        persist.setRootDir("valid root dir");
    }


    @Test(expected = InvalidRootDirException.class)
    public void testSetRootDirBad() throws InvalidRootDirException {
        Persist persist = new Persist();
        persist.setRootDir("invalid root dir");
    }


    @Test
    public void testSetMaintenanceDirOk() throws InvalidMaintenanceDirException {
        Persist persist = new Persist();
        persist.setMaintenanceDir("valid root dir");
    }


    @Test(expected = InvalidMaintenanceDirException.class)
    public void testSetMaintenanceDirBad() throws InvalidMaintenanceDirException {
        Persist persist = new Persist();
        persist.setMaintenanceDir("invalid root dir");
    }




}
