package handler;

import provider.ContentProvider;
import webserver.Request;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResponseHandler {

    private Request request;

    public ResponseHandler(Request request){
        this.request = request;
    }

    private byte[] contentProvider() throws IOException {
        String contentType = this.getContentType(this.request.getURI());
        return null;
    }

    private String getContentType(String resource) throws IOException {
        Path path = Paths.get(resource);
        return Files.probeContentType(path);
    }

    public static void main(String[] args) {
        ResponseHandler rh = new ResponseHandler(null);
        try {
            System.out.println(rh.getContentType("index.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
