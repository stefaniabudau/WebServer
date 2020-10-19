package test;

import org.junit.Test;

import exception.webserverstate.WebServerAlreadyInactiveException;
import exception.webserverstate.WebServerAlreadyRunningException;
import exception.webserverstate.WebServerMaintenanceTransitionFailException;
import exception.webserverstate.WebServerStateException;
import webserver.WebServerState;

public class WebServerStateTest {

    @Test(expected = WebServerAlreadyRunningException.class)
    public void testStartRunningWebServer() throws WebServerStateException{
        WebServerState state = new WebServerState();
        state.startWebServer();
    }


    @Test
    public void testStartInMaintenanceWebServer() throws WebServerStateException{
        WebServerState state = new WebServerState();
        state.maintenanceWebServer();
        state.startWebServer();
    }


    @Test
    public void testStopInMaintenanceWebServer() throws WebServerStateException{
        WebServerState state = new WebServerState();
        state.maintenanceWebServer();
        state.stopWebServer();
    }


    @Test(expected = WebServerMaintenanceTransitionFailException.class)
    public void testMaintenanceStoppedWebServer() throws WebServerStateException{
        WebServerState state = new WebServerState();
        state.stopWebServer();
        state.maintenanceWebServer();
    }


    @Test(expected = WebServerAlreadyInactiveException.class)
    public void testStopStoppedWebServer() throws WebServerStateException{
        WebServerState state = new WebServerState();
        state.stopWebServer();
        state.stopWebServer();
    }
}
