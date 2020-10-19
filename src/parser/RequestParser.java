package parser;

import exception.request.*;
import validator.RequestValidator;

import java.util.List;

public class RequestParser {

    private String request;


    public RequestParser(String request){
        this.request = request;
    }


    public String getResource() throws InvalidRequestResourceException {
        if(!RequestValidator.validateResource(null))
            throw new InvalidRequestResourceException();
        return null;
    }


    public String getHTTPVersion() throws InvalidRequestHTTPVersionException {
        if(!RequestValidator.validateHTTPVersion(null))
            throw new InvalidRequestHTTPVersionException();
        return null;
    }


    public String getHost() throws InvalidRequestHostException {
        if(!RequestValidator.validateHost(null))
            throw new InvalidRequestHostException();
        return null;
    }
}
