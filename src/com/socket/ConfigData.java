package com.socket;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConfigData {
    private static ConfigData instance;
    private JSONObject configObject;
    private Role role = null;
    private String name = null;

    static {
        try {
            instance = new ConfigData("./config.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ConfigData (String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        String configFileContent = "";
        while ((line = reader.readLine()) != null) {
            configFileContent += line;
        }
        configObject = new JSONObject(configFileContent);
        role = Role.valueOf(configObject.getString("role"));
        name = configObject.getString("name");
    }

    public static ConfigData getInstance () { return instance; }

    public Role getRole () { return role; }
    public String getName () { return name; }
}