package validator;

import parser.RequestParser;

import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;


public class RequestValidator {

    public static boolean validate(RequestParser requestParser){
        return false;
    }


    public static boolean validateRequestLine(String[] requestLine){
        if(requestLine.length != 3) return false;
        return true;
    }


    public static boolean validateResource(String resource){
        if(resource.equals("/")) return true;

        if(!resource.startsWith("/")) return false;

        try {
            Paths.get(resource);
        } catch (InvalidPathException | NullPointerException ex) {
            return false;
        }
        return true;
    }


    public static boolean validateMethod(String method){
        if(method.equals("GET")) return true;
        return false;
    }


    public static boolean validateHTTPVersion(String version){
        String[] httpVersions = {"HTTP/1.1", "HTTP/0.9", "HTTP/1.0", "HTTP/2.0"};
        boolean isValid = Arrays.stream(httpVersions).anyMatch(v -> v.equals(version));
        return isValid;
    }

}
