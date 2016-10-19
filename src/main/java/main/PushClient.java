package main;


import config.Config;
import http.Upload;

import java.io.File;
import java.io.IOException;

public class PushClient {

    public static void main(String[] args) {
        try {
            final String path = "file.png";
            final Process process = Runtime.getRuntime().exec("/usr/sbin/screencapture -i " + path);
            process.waitFor();
            final Config config = new Config();
            Upload.uploadTempContent(new File(path), config.getProperties().getProperty("url"), config);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


}
