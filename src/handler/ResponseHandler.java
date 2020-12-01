package handler;

import exception.config.ConfigurationException;
import exception.config.InvalidRootDirException;
import provider.CSSProvider;
import provider.ContentProvider;
import provider.HTMLProvider;
import provider.ImageProvider;
import webserver.Request;
import webserver.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResponseHandler {

    public static Response getResponse(Request request, Integer state) throws IOException, ConfigurationException {
        Response response;
        String uri = request.getURI();

        if(state == 0){
            return new Response(
                    "503 Service Unavailable",
                    "text/html",
                    new HTMLProvider().provide404()
            );
        }
        else if(state == 2){
            return new Response(
                    "503 Srvice Unavailable",
                    "text/html",
                    new HTMLProvider().provide404()
            );
        }


        if(uri.equals("/")) {
            response = new Response(
                    "200 OK",
                    "text/html",
                    new HTMLProvider().provideDefault()
            );
        }
        else if(getContentType(uri) == null){
            response = new Response(
                    "404 Not found",
                    "text/html",
                    new HTMLProvider().provide404()
            );
        }
        else{
            byte[] content;
            String message;
            String type;

            type = getContentType(uri);
            ContentProvider provider = getProvider(type);

            if(provider == null) content = new HTMLProvider().provide404();
            else content = provider.provide(uri);

            if (provider.isNotFound()) message="404 Not Found";
            else message="200 OK";

            response = new Response(
                    message,
                    type,
                    content
            );
        }

        return response;
    }

    private static ContentProvider getProvider(String contentType) {
        ContentProvider provider;

//        TODO: Implement in a software engineering manner
        if(contentType.contains("html"))
            provider = new HTMLProvider();
        else if (contentType.contains("css"))
            provider = new CSSProvider();
        else if (contentType.contains("image"))
            provider = new ImageProvider();
        else
            provider = null;

        return provider;
    }

    private static String getContentType(String resource) throws IOException {
        Path path = Paths.get(resource);
        return Files.probeContentType(path);
    }
}
