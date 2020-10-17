package config;

import exception.InvalidMaintenanceDirException;
import exception.InvalidPortNumberException;
import exception.InvalidRootDirException;
import validator.MaintenanceDirValidator;
import validator.PortNumberValidator;
import validator.RootDirValidator;


public class Persist {

    public int getPortNumber(){
        return 0;
    }


    public String getRootDir(){
        return null;
    }


    public String getMaintenanceDir() {
        return null;
    }


    public void setPortNumber(int portNumber) throws InvalidPortNumberException {
        if(!PortNumberValidator.validate(portNumber)){
            throw  new InvalidPortNumberException();
        }
    }


    public void setRootDir(String rootDir) throws InvalidRootDirException {
        if(!RootDirValidator.validate(rootDir)){
            throw  new InvalidRootDirException();
        }
    }


    public void setMaintenanceDir(String maintenanceDir) throws InvalidMaintenanceDirException {
        if(!MaintenanceDirValidator.validate(maintenanceDir)){
            throw new InvalidMaintenanceDirException();
        }
    }
}
