package validator;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigFileValidator {

    public static boolean validateConfigFile(String path){
        if(!path.endsWith(".properties")) return false;

        try {
            Paths.get(path);
        } catch (InvalidPathException | NullPointerException ex) {
            return false;
        }
        return true;
    }

    public static boolean validateMaintenanceDir(String maintenanceDir){
        try {
            Path path = Paths.get(maintenanceDir);
            if(!Files.isDirectory(path)) return false;

        } catch (InvalidPathException | NullPointerException ex) {
            return false;
        }

        return true;
    }

    public static boolean validatePortNumber(int portNumber){
        if(portNumber >= 1024 & portNumber <= 49151)
            return true;
        return false;
    }

    public static boolean validateRootDir(String rootDir){
        try {
            Path path = Paths.get(rootDir);
            if(!Files.isDirectory(path)) return false;

        } catch (InvalidPathException | NullPointerException ex) {
            return false;
        }

        return true;
    }

    public static boolean validatePage(String filePath){
        try {
            Path path = Paths.get(filePath);
            if(!Files.exists(path)) return false;
            if(!filePath.endsWith(".html")) return false;

        } catch (InvalidPathException | NullPointerException ex) {
            return false;
        }

        return true;
    }

}
