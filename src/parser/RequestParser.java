package parser;

import exception.request.*;
import validator.RequestValidator;

import java.util.List;

public class RequestParser {

    private String request;
    private String requestLine;
    private List<String> headers;


    public RequestParser(String request){
        this.request = request;
//        this.requestLine = this.getRequestLine();
//        this.headers = this.getHeaders();
    }


    /**
     * TO DO: Take care of request line and handlers
     * **/

    private String getRequestLine() throws InvalidRequestLineException {
        if(!RequestValidator.validateRequestLine(""))
            throw new InvalidRequestLineException();
        return null;
    }


    private List<String> getHeaders() throws InvalidRequestHeadersException {
        if(!RequestValidator.validateHeaders(null))
            throw new InvalidRequestHeadersException();
        return null;
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
