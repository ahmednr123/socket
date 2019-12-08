package com.socket;

public class MainClass {
    private static ConfigData configData = ConfigData.getInstance();
    public static void main (String[] args) {
        switch (configData.getRole()) {
            case CLIENT:
                Client client = new Client();
                client.run();
                break;
            case SERVER:
                Server server = new Server();
                server.run();
                break;
        }
    }
}
