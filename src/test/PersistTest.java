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
    public void testSetPortNumberBad() throws InvalidPortNumberException {
        Persist persist = new Persist();
        Integer[] ports = {0, 1, 55, 800, 1000, 1023, 49152, 60000, 65535};

        for(Integer port: ports) {
            persist.setPortNumber(port);
        }
    }


    @Test
    public void testSetRootDirOk() throws InvalidRootDirException {
        Persist persist = new Persist();
        String[] paths = {"c:\\folder\\FOLDER", "d:\\folder1\\folder2", "Folder2", "\\folder_1\\folder-2", "folder\\folder" };

        for(String path : paths) {
            persist.setRootDir(path);
        }
    }


    @Test(expected = InvalidRootDirException.class)
    public void testSetRootDirBad() throws InvalidRootDirException {
        Persist persist = new Persist();
        String[] paths = {"c:\\folder\\FOLDER.txt", "fo|lder2", "Folder2.txt", "\\folder1\\folder:2", "folder?folder", "fol*der" };

        for(String path : paths) {
            persist.setRootDir(path);
        }
    }


    @Test
    public void testSetMaintenanceDirOk() throws InvalidMaintenanceDirException {
        Persist persist = new Persist();
        String[] paths = {"c:\\folder\\FOLDER", "d:\\folder1\\folder2", "Folder2", "\\folder_1\\folder-2", "folder\\folder" };

        for(String path : paths) {
            persist.setMaintenanceDir(path);
        }
    }


    @Test(expected = InvalidMaintenanceDirException.class)
    public void testSetMaintenanceDirBad() throws InvalidMaintenanceDirException {
        Persist persist = new Persist();
        String[] paths = {"c:\\folder\\FOLDER.txt", "fo|lder2", "Folder2.txt", "\\folder1\\folder:2", "folder?folder", "fol*der" };

        for(String path : paths) {
            persist.setMaintenanceDir(path);
        }
    }
}
