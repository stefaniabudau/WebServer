package validator;

import parser.RequestParser;

import java.util.List;

public class RequestValidator {

    public static boolean validate(RequestParser requestParser){
        return false;
    }


    public static boolean validateRequestLine(String requestLine){
        return false;
    }


    public static boolean validateHeaders(List<String> headers){
        return false;
    }


    public static boolean validateResource(String resource){
        return false;
    }


    public static boolean validateMethod(String resource){
        return false;
    }


    public static boolean validateHTTPVersion(String version){
        return false;
    }


    public static boolean validateHost(String host) {
        return false;
    }
}
