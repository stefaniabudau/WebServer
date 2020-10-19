package test;

import config.Persist;
import exception.config.InvalidMaintenanceDirException;
import exception.config.InvalidPortNumberException;
import exception.config.InvalidRootDirException;
import org.junit.Test;

public class PersistTest {

    @Test
    public void testSetPortNumberOk() throws InvalidPortNumberException {
        Persist persist = new Persist();
        Integer[] ports = {1024, 1025, 2000, 10008, 30000, 45000, 49150, 49151};

        for(Integer port: ports) {
            persist.setPortNumber(port);
        }
    }


    @Test(expected = InvalidPortNumberException.class)
    public void testSetPortNumberBad1() throws InvalidPortNumberException {
        Persist persist = new Persist();
        persist.setPortNumber(0);
    }


    @Test(expected = InvalidPortNumberException.class)
    public void testSetPortNumberBad2() throws InvalidPortNumberException {
        Persist persist = new Persist();
        persist.setPortNumber(1);
    }


    @Test(expected = InvalidPortNumberException.class)
    public void testSetPortNumberBad3() throws InvalidPortNumberException {
        Persist persist = new Persist();
        persist.setPortNumber(55);
    }


    @Test(expected = InvalidPortNumberException.class)
    public void testSetPortNumberBad4() throws InvalidPortNumberException {
        Persist persist = new Persist();
        persist.setPortNumber(800);
    }


    @Test(expected = InvalidPortNumberException.class)
    public void testSetPortNumberBad5() throws InvalidPortNumberException {
        Persist persist = new Persist();
        persist.setPortNumber(50000);
    }


    @Test
    public void testValidSetRootDir() throws InvalidRootDirException {
        Persist persist = new Persist();
        String[] paths = {"c:\\folder\\FOLDER", "d:\\folder1\\folder2", "Folder2", "\\folder_1\\folder-2", "folder\\folder", "foLder" };

        for(String path : paths) {
            persist.setRootDir(path);
        }
    }


    @Test(expected = InvalidRootDirException.class)
    public void testInvalidRootDir1() throws InvalidRootDirException {
        Persist persist = new Persist();
        persist.setRootDir("c:\\folder\\FOLDER.txt");
    }


    @Test(expected = InvalidRootDirException.class)
    public void testInvalidRootDir2() throws InvalidRootDirException{
        Persist persist = new Persist();
        persist.setRootDir("fo|lder2");
    }


    @Test(expected = InvalidRootDirException.class)
    public void testInvalidRootDir3() throws InvalidRootDirException{
        Persist persist = new Persist();
        persist.setRootDir("\\folder1\\folder:2");
    }


    @Test
    public void testValidMaintenanceDir() throws InvalidMaintenanceDirException {
        Persist persist = new Persist();
        String[] paths = {"c:\\folder\\FOLDER", "d:\\folder1\\folder2", "Folder2", "\\folder_1\\folder-2", "folder\\folder" };

        for(String path : paths) {
            persist.setMaintenanceDir(path);
        }
    }


    @Test(expected = InvalidMaintenanceDirException.class)
    public void testSetMaintenanceDir1() throws InvalidMaintenanceDirException {
        Persist persist = new Persist();
        persist.setMaintenanceDir("c:\\folder\\FOLDER.txt");
    }


    @Test(expected = InvalidMaintenanceDirException.class)
    public void testSetMaintenanceDir2() throws InvalidMaintenanceDirException {
        Persist persist = new Persist();
        persist.setMaintenanceDir("folder?folder");
    }


    @Test(expected = InvalidMaintenanceDirException.class)
    public void testSetMaintenanceDir3() throws InvalidMaintenanceDirException {
        Persist persist = new Persist();
        persist.setMaintenanceDir("Folder2.txt");
    }
}
