package webserver;

import exception.webserverstate.WebServerAlreadyInactiveException;
import exception.webserverstate.WebServerAlreadyRunningException;
import exception.webserverstate.WebServerMaintenanceTransitionFailException;

public class WebServerState {

    /**
     * 0 -> stopped
     * 1 -> running
     * 2 -> maintenance
     * **/

    private int webServerState;

    public WebServerState(){
        this.webServerState = 1;
    }

    public int getWebServerState(){
        return this.webServerState;
    }

    public void startWebServer() throws WebServerAlreadyRunningException {
        if(this.webServerState == 1)
            throw new WebServerAlreadyRunningException();
        this.webServerState = 1;
    }


    public void stopWebServer() throws WebServerAlreadyInactiveException {
        if(this.webServerState == 0)
            throw new WebServerAlreadyInactiveException();
        this.webServerState = 0;
    }


    public void maintenanceWebServer() throws WebServerMaintenanceTransitionFailException {
        if(this.webServerState != 1)
            throw new WebServerMaintenanceTransitionFailException();
        this.webServerState = 2;
    }

}
