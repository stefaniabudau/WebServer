package gui;

import config.Persist;
import config.Settings;
import exception.config.ConfigurationException;
import exception.webserverstate.WebServerStateException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Pane;
import webserver.WebServer;
import webserver.WebServerState;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerGUI implements Initializable {

    private Thread webserver;

    @FXML
    public Pane startControl, stopControl;
    public CheckBox checkMaintenance;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Settings.init();
        WebServerState.init();
        webserver = null;

        stopControl.setVisible(true);
        startControl.setVisible(false);
    }

    public void onStopButtonClick(javafx.event.ActionEvent actionEvent) throws WebServerStateException {
        stopControl.setVisible(true);
        startControl.setVisible(false);

        WebServerState.stopWebServer();
    }

    public void onStartButtonClick(javafx.event.ActionEvent actionEvent) throws WebServerStateException {
        stopControl.setVisible(false);
        startControl.setVisible(true);

        if(WebServerState.getWebServerState() == 0)
        {
            try {
                webserver = getWebServer(Settings.persist.getPortNumber());
                webserver.start();
            } catch (ConfigurationException e) {
                e.printStackTrace();
            }
        }
        WebServerState.startWebServer();
    }

    public void onMaintenanceClick() throws WebServerStateException {
        stopControl.setVisible(false);
        startControl.setVisible(true);

        if(checkMaintenance.isSelected())
            WebServerState.maintenanceWebServer();
        else
            WebServerState.startWebServer();
    }

    private static Thread getWebServer(int port){
        return new Thread(new Runnable() {
            private boolean running = true;

            @Override
            public void run() {
                try {
                    WebServer.runWebServer(Settings.persist.getPortNumber());
                } catch (ConfigurationException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
