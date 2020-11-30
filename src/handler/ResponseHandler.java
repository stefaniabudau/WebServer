package handler;

import provider.Content;
import provider.ContentProvider;
import provider.HTMLProvider;
import provider.ImageProvider;
import webserver.Request;
import webserver.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    private static Map<String, ContentProvider> contentProviders =
            new HashMap<String, ContentProvider>(){{
                put("text", new HTMLProvider());
                put("image", new ImageProvider());
                }
            };


    public static Response getResponse(Request request) throws IOException {
        String message, contentType;
        byte[] content;
        Content receivedContent;

        String uri = request.getURI();

        contentType = getContentType(uri);
        receivedContent = provideContent(uri, contentType);
        content = receivedContent.getContent();

        if(receivedContent.isOk())
            message = "200 OK";
        else
            message = "404 Not found";

        return new Response(
                message,
                contentType,
                content
        );
    }

    private static Content provideContent(String uri, String contentType) throws IOException {
        String type = contentType.split("/")[0];
        ContentProvider provider = contentProviders.get(type);
        return provider.provide(uri);
    }

    private static String getContentType(String resource) throws IOException {
        Path path = Paths.get(resource);
        return Files.probeContentType(path);
    }
}
