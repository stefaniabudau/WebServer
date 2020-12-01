package test;

import config.Config;
import config.Persist;
import exception.config.*;
import org.junit.Test;

import java.io.IOException;

public class PersistTest {

    @Test
    public void testSetPortNumberOk() throws ConfigurationException, IOException {
        Config config = Config.getConfig("config/test.properties");
        Persist persist = new Persist(config);
        Integer[] ports = {1024, 1025, 2000, 10008, 30000, 45000, 49150, 49151};

        for(Integer port: ports) {
            persist.setPortNumber(port);
        }
    }


    @Test(expected = InvalidPortNumberException.class)
    public void testSetPortNumberBad1() throws ConfigurationException, IOException {
        Config config = Config.getConfig("config/test.properties");
        Persist persist = new Persist(config);
        persist.setPortNumber(0);
    }


    @Test(expected = InvalidPortNumberException.class)
    public void testSetPortNumberBad2() throws ConfigurationException, IOException {
        Config config = Config.getConfig("config/test.properties");
        Persist persist = new Persist(config);
        persist.setPortNumber(1);
    }


    @Test(expected = InvalidPortNumberException.class)
    public void testSetPortNumberBad3() throws ConfigurationException, IOException {
        Config config = Config.getConfig("config/test.properties");
        Persist persist = new Persist(config);
        persist.setPortNumber(55);
    }


    @Test(expected = InvalidPortNumberException.class)
    public void testSetPortNumberBad4() throws ConfigurationException, IOException {
        Config config = Config.getConfig("config/test.properties");
        Persist persist = new Persist(config);
        persist.setPortNumber(800);
    }


    @Test(expected = InvalidPortNumberException.class)
    public void testSetPortNumberBad5() throws ConfigurationException, IOException {
        Config config = Config.getConfig("config/test.properties");
        Persist persist = new Persist(config);
        persist.setPortNumber(50000);
    }


    @Test(expected = InvalidRootDirException.class)
    public void testSetNotExistentRootDir() throws ConfigurationException, IOException {
        Config config = Config.getConfig("config/test.properties");
        Persist persist = new Persist(config);
        String[] paths = {"c:\\folder\\FOLDER", "d:\\folder1\\folder2", "Folder2", "\\folder_1\\folder-2", "folder\\folder", "foLder" };

        for(String path : paths) {
            persist.setRootDir(path);
        }
    }


    @Test(expected = InvalidRootDirException.class)
    public void testNullRootDir() throws ConfigurationException, IOException {
        Config config = Config.getConfig("config/test.properties");
        Persist persist = new Persist(config);
        persist.setRootDir(null);
    }


    @Test(expected = InvalidRootDirException.class)
    public void testInvalidRootDirPath() throws ConfigurationException, IOException {
        Config config = Config.getConfig("config/test.properties");
        Persist persist = new Persist(config);
        persist.setRootDir("fo|lder2");
    }


    @Test(expected = InvalidRootDirException.class)
    public void testInvalidRootDirPath2() throws ConfigurationException, IOException {
        Config config = Config.getConfig("config/test.properties");
        Persist persist = new Persist(config);
        persist.setRootDir("\\folder1\\folder:2");
    }


    @Test(expected = InvalidMaintenanceDirException.class)
    public void testNonExistentMaintenanceDir() throws ConfigurationException, IOException {
        Config config = Config.getConfig("config/test.properties");
        Persist persist = new Persist(config);
        String[] paths = {"c:\\folder\\FOLDER", "d:\\folder1\\folder2", "Folder2", "\\folder_1\\folder-2", "folder\\folder" };

        for(String path : paths) {
            persist.setMaintenanceDir(path);
        }
    }

    @Test(expected = InvalidMaintenanceDirException.class)
    public void testSetNullMaintenanceDir() throws ConfigurationException, IOException {
        Config config = Config.getConfig("config/test.properties");
        Persist persist = new Persist(config);
        persist.setMaintenanceDir(null);
    }

    @Test(expected = InvalidMaintenanceDirException.class)
    public void testSetMaintenanceDir1() throws ConfigurationException, IOException {
        Config config = Config.getConfig("config/test.properties");
        Persist persist = new Persist(config);
        persist.setMaintenanceDir("c:\\folder\\FOLDER.txt");
    }


    @Test(expected = InvalidMaintenanceDirException.class)
    public void testSetMaintenanceDir2() throws ConfigurationException, IOException {
        Config config = Config.getConfig("config/test.properties");
        Persist persist = new Persist(config);
        persist.setMaintenanceDir("folder?folder");
    }


    @Test(expected = InvalidMaintenanceDirException.class)
    public void testSetMaintenanceDir3() throws ConfigurationException, IOException {
        Config config = Config.getConfig("config/test.properties");
        Persist persist = new Persist(config);
        persist.setMaintenanceDir("Folder2.txt");
    }

    @Test(expected = InvalidPageException.class)
    public void testSetNonExistentDefaultPage() throws IOException, ConfigurationException {
        Config config = Config.getConfig("config/test.properties");
        Persist persist = new Persist(config);
        persist.setDefaultPage("c:\\folder\\FOLDER.txt");
    }

    @Test(expected = InvalidPageException.class)
    public void testSetInvalidDefaultPage() throws IOException, ConfigurationException {
        Config config = Config.getConfig("config/test.properties");
        Persist persist = new Persist(config);
        persist.setDefaultPage("res/root/pages/not_found_page.h");
    }

    @Test(expected = InvalidPageException.class)
    public void testSetInvalidDefaultPage2() throws IOException, ConfigurationException {
        Config config = Config.getConfig("config/test.properties");
        Persist persist = new Persist(config);
        persist.setDefaultPage("res/root/pages/not_found_page.css");
    }

    @Test(expected = InvalidPageException.class)
    public void testSetNullDefaultPage() throws IOException, ConfigurationException {
        Config config = Config.getConfig("config/test.properties");
        Persist persist = new Persist(config);
        persist.setDefaultPage(null);
    }

    @Test(expected = InvalidPageException.class)
    public void testSetNonExistentNotFoundPage() throws IOException, ConfigurationException {
        Config config = Config.getConfig("config/test.properties");
        Persist persist = new Persist(config);
        persist.setNotFoundPage("c:\\folder\\FOLDER.txt");
    }

    @Test(expected = InvalidPageException.class)
    public void testSetInvalidNotFoundPage() throws IOException, ConfigurationException {
        Config config = Config.getConfig("config/test.properties");
        Persist persist = new Persist(config);
        persist.setNotFoundPage("res/root/pages/not_found_page.h");
    }

    @Test(expected = InvalidPageException.class)
    public void testSetInvalidNotFoundPage2() throws IOException, ConfigurationException {
        Config config = Config.getConfig("config/test.properties");
        Persist persist = new Persist(config);
        persist.setNotFoundPage("res/root/pages/not_found_page.css");
    }

    @Test(expected = InvalidPageException.class)
    public void testSetNullNotFoundPage() throws IOException, ConfigurationException {
        Config config = Config.getConfig("config/test.properties");
        Persist persist = new Persist(config);
        persist.setNotFoundPage(null);
    }


}
