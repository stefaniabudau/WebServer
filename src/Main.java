import config.Persist;
import config.Settings;
import exception.config.ConfigurationException;
import exception.config.InvalidPortNumberException;
import exception.webserverstate.WebServerStateException;
import webserver.WebServer;
import webserver.WebServerState;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Settings.init();
        Persist persist = Settings.persist;

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    WebServer.runWebServer(persist.getPortNumber());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ConfigurationException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                Scanner in = new Scanner(System.in);

                while (true) {
                    printServerSettingsMenu();

                    try {
                        switch (in.nextInt()) {
                            case 0:
                                WebServerState.stopWebServer();
                                break;
                            case 1:
                                WebServerState.startWebServer();
                                break;
                            case 2:
                                WebServerState.maintenanceWebServer();
                                break;
                            case 3:
                                System.exit(0);
                        }

                    } catch (WebServerStateException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public static void printServerSettingsMenu(){
        System.out.println("*************** Server settings ***************");
        System.out.println("Current state: " + WebServerState.getWebServerState());
        System.out.println("* Set to state 0 (Stopped)");
        System.out.println("* Set to state 1 (Running)");
        System.out.println("* Set to state 2 (Maintenance)");
        System.out.println("* Exit program: 3");
        System.out.println("Enter your option:");
//        System.out.flush();
    }
}

