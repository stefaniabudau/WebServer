package webserver;

import exception.request.InvalidRequestException;
import handler.RequestHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Objects;

public class Request {
    private String method;
    private String URI;
    private String HTTPVersion;
    private String host;

    public Request(String method, String URI, String host, String HTTPVersion) {
        this.method = method;
        this.URI = URI;
        this.HTTPVersion = HTTPVersion;
        this.host = host;
    }

    public String getMethod() {
        return method;
    }

    public String getURI() {
        return URI;
    }

    public String getHost() {
        return host;
    }

    public String getHTTPVersion() {
        return HTTPVersion;
    }

    @Override
    public String toString() {
        return "Request{" +
                "method='" + method + '\'' +
                ", URI='" + URI + '\'' +
                ", HTTPVersion='" + HTTPVersion + '\'' +
                ", host='" + host + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(method, request.method) &&
                Objects.equals(URI, request.URI) &&
                Objects.equals(HTTPVersion, request.HTTPVersion) &&
                Objects.equals(host, request.host);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, URI, HTTPVersion, host);
    }
}
