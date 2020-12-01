//package test;
//
//import config.Persist;
//import exception.config.ConfigurationException;
//import exception.config.InvalidMaintenanceDirException;
//import exception.config.InvalidPortNumberException;
//import exception.config.InvalidRootDirException;
//import org.junit.Test;
//
//import java.io.IOException;
//
//public class PersistTest {
//
//    @Test
//    public void testSetPortNumberOk() throws ConfigurationException, IOException {
//        Persist persist = new Persist("resources/index.html");
//        Integer[] ports = {1024, 1025, 2000, 10008, 30000, 45000, 49150, 49151};
//
//        for(Integer port: ports) {
//            persist.setPortNumber(port);
//        }
//    }
//
//
//    @Test(expected = InvalidPortNumberException.class)
//    public void testSetPortNumberBad1() throws ConfigurationException, IOException {
//        Persist persist = new Persist("resources/index.html");
//        persist.setPortNumber(0);
//    }
//
//
//    @Test(expected = InvalidPortNumberException.class)
//    public void testSetPortNumberBad2() throws ConfigurationException, IOException {
//        Persist persist = new Persist("resources/index.html");
//        persist.setPortNumber(1);
//    }
//
//
//    @Test(expected = InvalidPortNumberException.class)
//    public void testSetPortNumberBad3() throws ConfigurationException, IOException {
//        Persist persist = new Persist("resources/index.html");
//        persist.setPortNumber(55);
//    }
//
//
//    @Test(expected = InvalidPortNumberException.class)
//    public void testSetPortNumberBad4() throws ConfigurationException, IOException {
//        Persist persist = new Persist("resources/index.html");
//        persist.setPortNumber(800);
//    }
//
//
//    @Test(expected = InvalidPortNumberException.class)
//    public void testSetPortNumberBad5() throws ConfigurationException, IOException {
//        Persist persist = new Persist("resources/index.html");
//        persist.setPortNumber(50000);
//    }
//
//
//    @Test
//    public void testValidSetRootDir() throws ConfigurationException, IOException {
//        Persist persist = new Persist("resources/index.html");
//        String[] paths = {"c:\\folder\\FOLDER", "d:\\folder1\\folder2", "Folder2", "\\folder_1\\folder-2", "folder\\folder", "foLder" };
//
//        for(String path : paths) {
//            persist.setRootDir(path);
//        }
//    }
//
//
//    @Test(expected = InvalidRootDirException.class)
//    public void testInvalidRootDir1() throws ConfigurationException, IOException {
//        Persist persist = new Persist("resources/index.html");
//        persist.setRootDir("c:\\folder\\FOLDER.txt");
//    }
//
//
//    @Test(expected = InvalidRootDirException.class)
//    public void testInvalidRootDir2() throws ConfigurationException, IOException {
//        Persist persist = new Persist("resources/index.html");
//        persist.setRootDir("fo|lder2");
//    }
//
//
//    @Test(expected = InvalidRootDirException.class)
//    public void testInvalidRootDir3() throws ConfigurationException, IOException {
//        Persist persist = new Persist("resources/index.html");
//        persist.setRootDir("\\folder1\\folder:2");
//    }
//
//
//    @Test
//    public void testValidMaintenanceDir() throws ConfigurationException, IOException {
//        Persist persist = new Persist("resources/index.html");
//        String[] paths = {"c:\\folder\\FOLDER", "d:\\folder1\\folder2", "Folder2", "\\folder_1\\folder-2", "folder\\folder" };
//
//        for(String path : paths) {
//            persist.setMaintenanceDir(path);
//        }
//    }
//
//
//    @Test(expected = InvalidMaintenanceDirException.class)
//    public void testSetMaintenanceDir1() throws ConfigurationException, IOException {
//        Persist persist = new Persist("resources/index.html");
//        persist.setMaintenanceDir("c:\\folder\\FOLDER.txt");
//    }
//
//
//    @Test(expected = InvalidMaintenanceDirException.class)
//    public void testSetMaintenanceDir2() throws ConfigurationException, IOException {
//        Persist persist = new Persist("resources/index.html");
//        persist.setMaintenanceDir("folder?folder");
//    }
//
//
//    @Test(expected = InvalidMaintenanceDirException.class)
//    public void testSetMaintenanceDir3() throws ConfigurationException, IOException {
//        Persist persist = new Persist("resources/index.html");
//        persist.setMaintenanceDir("Folder2.txt");
//    }
//
//
//}
