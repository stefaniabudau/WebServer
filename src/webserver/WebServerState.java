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

    private static int webServerState;

    public static void init(){
        webServerState = 0;
    }

    public static int getWebServerState(){
        return webServerState;
    }

    public static void startWebServer() throws WebServerAlreadyRunningException {
        if(webServerState == 1)
            throw new WebServerAlreadyRunningException();
        webServerState = 1;
    }


    public static void stopWebServer() throws WebServerAlreadyInactiveException {
        if(webServerState == 0)
            throw new WebServerAlreadyInactiveException();
        webServerState = 0;
    }


    public static void maintenanceWebServer() throws WebServerMaintenanceTransitionFailException {
        if(webServerState != 1)
            throw new WebServerMaintenanceTransitionFailException();
        webServerState = 2;
    }

}
