package config;

import exception.InvalidPortNumberException;
import validator.PortNumberValidator;


public class Persist {

    public int getPortNumber(){

        return 0;
    }

    public String getRootDir(){

        return null;
    }

    public String getMaintenanceDir()
    {

        return null;
    }

    public boolean setPortNumber(int portNumber) throws InvalidPortNumberException {
        if(!PortNumberValidator.validate(portNumber)){
            throw  new InvalidPortNumberException();
        }
        return false;
    }

    public boolean setRootDir(String rootDir){
        return false;

    }

    public boolean setMaintenanceDir(String maintenanceDir){
        return false;
    }
}
