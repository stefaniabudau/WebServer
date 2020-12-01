package webserver;

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

}
