package config;

import exception.config.*;
import validator.MaintenanceDirValidator;
import validator.PortNumberValidator;
import validator.RootDirValidator;

import java.io.IOException;


public class Persist {

    private Config config;

    public Persist(String configPath) throws InvalidConfigurationFileException {
        this.config = Config.getConfig(configPath);
    }

    public int getPortNumber() throws InvalidPortNumberException {
        String port_str = this.config.getSetting("port");
        int port = Integer.parseInt(port_str);
        if(!PortNumberValidator.validate(port)){
            throw new InvalidPortNumberException();
        }
        return port;
    }


    public String getRootDir() throws InvalidRootDirException {
        String rootDir = this.config.getSetting("root_directory");
        if(!RootDirValidator.validate(rootDir)){
            throw new InvalidRootDirException();
        }
        return rootDir;
    }


    public String getMaintenanceDir() throws InvalidMaintenanceDirException {
        String maintenanceDir = this.config.getSetting("maintenance_directory");
        if(!MaintenanceDirValidator.validate(maintenanceDir)){
            throw new InvalidMaintenanceDirException();
        }
        return maintenanceDir;
    }


    public void setPortNumber(int portNumber) throws ConfigurationException, IOException {
        if(!PortNumberValidator.validate(portNumber)){
            throw new InvalidPortNumberException();
        }
        this.config.setSetting("port", String.valueOf(portNumber));
    }


    public void setRootDir(String rootDir) throws ConfigurationException, IOException {
        if(!RootDirValidator.validate(rootDir)){
            throw new InvalidRootDirException();
        }
        this.config.setSetting("root_directory", rootDir);
    }


    public void setMaintenanceDir(String maintenanceDir) throws ConfigurationException, IOException {
        if(!MaintenanceDirValidator.validate(maintenanceDir)){
            throw new InvalidMaintenanceDirException();
        }
        this.config.setSetting("maintenance_directory", maintenanceDir);
    }

    public void save() throws SaveConfigurationFailureException, IOException {
        this.config.saveConfiguration();
    }
}
