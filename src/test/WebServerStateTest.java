package test;

import org.junit.Test;

import exception.webserverstate.WebServerAlreadyInactiveException;
import exception.webserverstate.WebServerAlreadyRunningException;
import exception.webserverstate.WebServerMaintenanceTransitionFailException;
import exception.webserverstate.WebServerStateException;
import webserver.WebServerState;

public class WebServerStateTest {

    @Test
    public void testStartStoppedWebServer() throws WebServerStateException{
        WebServerState.init();
        WebServerState.startWebServer();
    }

    @Test
    public void testStartMaintenanceWebServer() throws WebServerStateException{
        WebServerState.init();
        WebServerState.startWebServer();
        WebServerState.maintenanceWebServer();
        WebServerState.startWebServer();
    }

    @Test
    public void testMaintenanceRunningWebServer() throws WebServerStateException{
        WebServerState.init();
        WebServerState.startWebServer();
        WebServerState.maintenanceWebServer();
    }

    @Test
    public void testStopRunningWebServer() throws WebServerStateException{
        WebServerState.init();
        WebServerState.startWebServer();
        WebServerState.stopWebServer();
    }


    @Test
    public void testStopInMaintenanceWebServer() throws WebServerStateException{
        WebServerState.init();
        WebServerState.startWebServer();
        WebServerState.maintenanceWebServer();
        WebServerState.stopWebServer();
    }


    @Test(expected = WebServerAlreadyInactiveException.class)
    public void testStopStoppedWebServer() throws WebServerStateException{
        WebServerState.init();
        WebServerState.stopWebServer();
    }


    @Test(expected = WebServerMaintenanceTransitionFailException.class)
    public void testMaintenanceStoppedWebServer() throws WebServerStateException{
        WebServerState.init();
        WebServerState.maintenanceWebServer();
    }

    @Test(expected = WebServerAlreadyRunningException.class)
    public void testStartRunningWebServer() throws WebServerAlreadyRunningException {
        WebServerState.init();
        WebServerState.startWebServer();
        WebServerState.startWebServer();
    }
}
