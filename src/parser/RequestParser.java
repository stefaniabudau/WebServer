package parser;

import exception.request.*;
import validator.RequestValidator;


public class RequestParser {

    private String[] requestLines;
    private String[] requestLineComponents;

    public RequestParser(String request){
       this.requestLines = request.split("\r\n");
       this.requestLineComponents = this.requestLines[0].split(" ");
    }


    public String getMethod() throws InvalidRequestResourceException {
        String method = this.requestLineComponents[0];

//        if(!RequestValidator.validateMethod(method))
//            throw new InvalidRequestResourceException();

        return method;
    }


    public String getResource() throws InvalidRequestResourceException {
        String resource = this.requestLineComponents[1];

//        if(!RequestValidator.validateResource(resource))
//            throw new InvalidRequestResourceException();

        return resource;
    }


    public String getHTTPVersion() throws InvalidRequestHTTPVersionException {
        String HTTPVersion = this.requestLineComponents[2];

//        if(!RequestValidator.validateHTTPVersion(HTTPVersion))
//            throw new InvalidRequestHTTPVersionException();

        return HTTPVersion;
    }


    public String getHost() throws InvalidRequestHostException {
        String host = this.requestLines[1].split(":")[1];
        host = host.trim();

//        if(!RequestValidator.validateHost(host))
//            throw new InvalidRequestHostException();

        return host;
    }
}
