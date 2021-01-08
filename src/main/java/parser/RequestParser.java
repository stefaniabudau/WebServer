package parser;

import exception.request.*;
import validator.RequestValidator;


public class RequestParser {

    private String[] requestLines;
    private String[] requestLineComponents;

    public RequestParser(String request) throws InvalidRequestLineException {
       this.requestLines = request.split("\r\n");
       this.requestLineComponents = this.splitRequestLine(this.requestLines[0]);
    }


    public String[] splitRequestLine(String requestLine) throws InvalidRequestLineException {
        String[] requestLineComponents =  requestLine.split(" ");

        if(!RequestValidator.validateRequestLine(requestLineComponents))
            throw new InvalidRequestLineException();

        return requestLineComponents;
    }

    public String getMethod() throws InvalidRequestMethodException {
        String method = this.requestLineComponents[0];
        method = method.trim();

        if(!RequestValidator.validateMethod(method))
            throw new InvalidRequestMethodException();

        return method;
    }


    public String getResource() throws InvalidRequestResourceException {
        String resource = this.requestLineComponents[1];

        if(!RequestValidator.validateResource(resource))
            throw new InvalidRequestResourceException();

        return resource;
    }


    public String getHTTPVersion() throws InvalidRequestHTTPVersionException {
        String HTTPVersion = this.requestLineComponents[2];
        HTTPVersion = HTTPVersion.trim();

        if(!RequestValidator.validateHTTPVersion(HTTPVersion))
            throw new InvalidRequestHTTPVersionException();

        return HTTPVersion;
    }


    public String getHost() throws InvalidRequestHostException {
        String host = this.requestLines[1].split(":")[1];
        host = host.trim();

        return host;
    }
}
