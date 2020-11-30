package validator;

import parser.RequestParser;


public class RequestValidator {

    public  boolean validate(RequestParser requestParser){
        return false;
    }


    public  boolean validateRequestLine(String requestLine){
        return false;
    }


    public  boolean validateResource(String resource){
        return false;
    }


    public  boolean validateMethod(String resource){
        return false;
    }


    public  boolean validateHTTPVersion(String version){
        return false;
    }


    public  boolean validateHost(String host) {
        return false;
    }
}
