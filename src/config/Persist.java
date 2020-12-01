package config;

import exception.config.*;
import validator.ConfigFileValidator;


public class Persist {

    private Config config;

    public Persist(Config config){
        this.config = config;
    }

    public int getPortNumber() throws ConfigurationException {
        String port_str = this.config.getSetting("port");
        int port = Integer.parseInt(port_str);
        if(!ConfigFileValidator.validatePortNumber(port)){
            throw new InvalidPortNumberException();
        }
        return port;
    }


    public String getRootDir() throws ConfigurationException {
        String rootDir = this.config.getSetting("root_directory");
        if(!ConfigFileValidator.validateRootDir(rootDir)){
            throw new InvalidRootDirException();
        }
        return rootDir;
    }


    public String getMaintenanceDir() throws ConfigurationException {
        String maintenanceDir = this.config.getSetting("maintenance_directory");
        if(!ConfigFileValidator.validateMaintenanceDir(maintenanceDir)){
            throw new InvalidMaintenanceDirException();
        }
        return maintenanceDir;
    }


    public String getNotFoundPage() throws ConfigurationException {
        String notFoundPage = this.config.getSetting("not_found_page");
        return notFoundPage;
    }


    public String getDefaultPage() throws ConfigurationException {
        String defaultPage = this.config.getSetting("default_page");
        return defaultPage;
    }


    public void setPortNumber(int portNumber) throws ConfigurationException{
        if(!ConfigFileValidator.validatePortNumber(portNumber)){
            throw new InvalidPortNumberException();
        }
        this.config.setSetting("port", String.valueOf(portNumber));
    }


    public void setRootDir(String rootDir) throws ConfigurationException{
        if(!ConfigFileValidator.validateRootDir(rootDir)){
            throw new InvalidRootDirException();
        }
        this.config.setSetting("root_directory", rootDir);
    }


    public void setMaintenanceDir(String maintenanceDir) throws ConfigurationException{
        if(!ConfigFileValidator.validateMaintenanceDir(maintenanceDir)){
            throw new InvalidMaintenanceDirException();
        }
        this.config.setSetting("maintenance_directory", maintenanceDir);
    }


    public void setNotFoundPage(String notFoundPage) throws ConfigurationException{
        if(!ConfigFileValidator.validatePage(notFoundPage)){
            throw new InvalidPageException();
        }
        this.config.setSetting("not_found_page", notFoundPage);
    }


    public void setDefaultPage(String defaultPage) throws ConfigurationException{
        if(!ConfigFileValidator.validatePage(defaultPage)){
            throw new InvalidPageException();
        }
        this.config.setSetting("default_page", defaultPage);
    }
}
