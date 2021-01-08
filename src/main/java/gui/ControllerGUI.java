package gui;

import config.Persist;
import config.Settings;
import exception.config.ConfigurationException;
import exception.webserverstate.WebServerStateException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import webserver.WebServer;
import webserver.WebServerState;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

public class ControllerGUI implements Initializable {

    private Thread webserver;

    @FXML
    public Pane startControl, stopControl;
    public CheckBox checkMaintenance;
    public TextField portTextField, rootDirTextField, maintenanceDirTextField;
    public Label statusLabel, portLabel, addressLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Settings.init();
        WebServerState.init();
        webserver = null;

        stopControl.setVisible(true);
        startControl.setVisible(false);

        statusLabel.setText("not running");
        addressLabel.setText("not running");
        portLabel.setText("not running");


        try {
            maintenanceDirTextField.setText(Settings.persist.getMaintenanceDir());
            rootDirTextField.setText(Settings.persist.getRootDir());
            portTextField.setText(Settings.persist.getPortNumber() + "");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

    }

    public void onStopButtonClick(javafx.event.ActionEvent actionEvent) throws WebServerStateException {
        stopControl.setVisible(true);
        startControl.setVisible(false);

        maintenanceDirTextField.setDisable(false);
        rootDirTextField.setDisable(false);
        portTextField.setDisable(false);

        statusLabel.setText("not running");
        addressLabel.setText("not running");
        portLabel.setText("not running");

        WebServerState.stopWebServer();
    }

    public void onStartButtonClick(javafx.event.ActionEvent actionEvent) throws WebServerStateException {
        try {
            Settings.persist.setPortNumber(Integer.parseInt(portTextField.getText()));
            Settings.persist.setRootDir(rootDirTextField.getText());
            Settings.persist.setMaintenanceDir(maintenanceDirTextField.getText());
            Settings.config.saveConfiguration();

            stopControl.setVisible(false);
            startControl.setVisible(true);

            maintenanceDirTextField.setDisable(true);
            rootDirTextField.setDisable(true);
            portTextField.setDisable(true);

            statusLabel.setText("running");
            try {
                addressLabel.setText("127.0.0.1:" + Settings.persist.getPortNumber());
                portLabel.setText(Settings.persist.getPortNumber() + "");
            } catch (ConfigurationException e) {
                e.printStackTrace();
            }

            if (WebServerState.getWebServerState() == 0) {
                try {
                    webserver = getWebServer(Settings.persist.getPortNumber());
                    webserver.start();
                } catch (ConfigurationException e) {
                    e.printStackTrace();
                }
            }
            WebServerState.startWebServer();
        } catch (ConfigurationException | IOException e) {
            System.err.println("Invalid web server settings");
            e.printStackTrace();

        }
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
