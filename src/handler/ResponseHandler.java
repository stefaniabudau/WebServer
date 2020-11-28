package handler;

import provider.ContentProvider;
import provider.HTMLProvider;
import provider.ImageProvider;
import webserver.Request;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    private Request request;
    private OutputStream out;
    private HashMap<String, String> responseDetails;
    private byte[] response;

    private static Map<String, ContentProvider> contentProviders =
            new HashMap<String, ContentProvider>(){{
                put("text", new HTMLProvider());
                put("image", new ImageProvider());
                }
            };

    public ResponseHandler(OutputStream out, Request request){
        this.out = out;
        this.request = request;
        this.responseDetails = new HashMap<>();
    }

//    TODO: implement handleRequest method
    public void handleResponse() throws IOException {

    }

    private String provideContent() throws IOException {
        String uri = this.request.getURI();
        String contentType = this.getContentType(uri);
        ContentProvider provider = contentProviders.get(contentType);
        return provider.provide(uri);
    }

    private String getContentType(String resource) throws IOException {
        Path path = Paths.get(resource);
        return Files.probeContentType(path);
    }

    private byte[] buildResponse(String message, String contentType, String content){
        return  ("HTTP/1.1 " + message + "\r\n" +
                "ContentType: " + contentType + "\r\n" +
                "\r\n" +
                content +
                "\r\n\r\n").getBytes();
    }

    public void send(String response) throws IOException {
        this.out.write(response.getBytes());
    }

}
