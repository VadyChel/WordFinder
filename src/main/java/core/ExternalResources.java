package core;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExternalResources {
    public BufferedReader getText(String url) throws IOException {
        URL urlObject = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
        connection.setRequestMethod("GET");

        return new BufferedReader(new InputStreamReader(connection.getInputStream()));
    }

    public BufferedReader getFile(String path) throws IOException{
        return new BufferedReader(new FileReader(new File(path)));
    }
}
