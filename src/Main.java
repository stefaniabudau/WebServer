import config.Persist;
import config.Settings;
import exception.config.ConfigurationException;
import exception.webserverstate.WebServerStateException;
import webserver.WebServer;
import webserver.WebServerState;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Settings.init();
        WebServerState.init();

        Persist persist = Settings.persist;
        Scanner in = new Scanner(System.in);

        while(true) {
            try {
                System.out.println("Run on port: ");
                int inputPort = in.nextInt();
                persist.setPortNumber(inputPort);
                break;
            } catch (ConfigurationException e) {
                System.err.println("Invalid port number");
            }
        }

        try {
            System.out.println("Running at http://127.0.0.1:" + persist.getPortNumber() + '\n');
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }


        new Thread(new Runnable() {
            @Override
            public void run() {

                Thread webServerInstance = null;

                while (true) {
                    printServerSettingsMenu();

                    try {
                        switch (in.nextInt()) {
                            case 0: {
                                WebServerState.stopWebServer();
                                break;
                            }
                            case 1:
                            {
                                if(WebServerState.getWebServerState() == 0) {
                                    webServerInstance = getWebServer(persist.getPortNumber());
                                    webServerInstance.start();
                                }

                                WebServerState.startWebServer();
                                break;
                            }
                            case 2:
                                WebServerState.maintenanceWebServer();
                                break;
                            case 3:
                                System.exit(0);
                        }

                    } catch (WebServerStateException | ConfigurationException  e) {
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


    public static Thread getWebServer(int port){
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

