package handler;

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

    public static Response getResponse(Request request, Integer state) throws IOException, InvalidRootDirException {
        Response response;
        String uri = request.getURI();

        if(state == 0){
            return new Response(
                    "503",
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
            response = new Response(
                    "200 OK",
                    getContentType(uri),
                    provideContent(uri, getContentType(uri))
            );
        }

        return response;
    }

    private static byte[] provideContent(String uri, String contentType) throws IOException, InvalidRootDirException {
        ContentProvider provider;

        if(contentType.contains("html"))
            provider = new HTMLProvider();
        else if (contentType.contains("css"))
            provider = new CSSProvider();
        else if (contentType.contains("image"))
            provider = new ImageProvider();
        else
            return new HTMLProvider().provide404();

        return provider.provide(uri);
    }

    private static String getContentType(String resource) throws IOException {
        Path path = Paths.get(resource);
        return Files.probeContentType(path);
    }
}
