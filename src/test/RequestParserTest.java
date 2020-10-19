package test;

import exception.request.InvalidRequestHTTPVersionException;
import exception.request.InvalidRequestHostException;
import exception.request.InvalidRequestResourceException;
import org.junit.Test;
import parser.RequestParser;

public class RequestParserTest {

    @Test
    public void testResourceOk() throws InvalidRequestResourceException {
        String[] requests = {
                "GET / HTTP/1.1\n" +
                        "Host: localhost:8080\n" +
                        "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:74.0) Gecko/20100101 Firefox/74.0\n" +
                        "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\n" +
                        "Accept-Language: en-US,en;q=0.5\n" +
                        "Accept-Encoding: gzip, deflate",

                "GET /proj/proj.html HTTP/1.1\n" +
                        "Host: localhost:8080\n" +
                        "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:74.0) Gecko/20100101 Firefox/74.0\n" +
                        "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\n" +
                        "Accept-Language: en-US,en;q=0.5\n" +
                        "Accept-Encoding: gzip, deflate",

                "GET / HTTP/1.1 Host: localhost:8080\n" +
                        "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:74.0) Gecko/20100101 Firefox/74.0\n" +
                        "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\n" +
                        "Accept-Language: en-US,en;q=0.5\n" +
                        "Accept-Encoding: gzip, deflate ",

                "GET / HTTP/1.1\n" +
                        "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:74.0) Gecko/20100101 Firefox/74.0\n" +
                        "Host: localhost:8080\n" +
                        "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\n" +
                        "Accept-Language: en-US,en;q=0.5\n" +
                        "Accept-Encoding: gzip, deflate",

                "GET / HTTP/1.1 User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:74.0) Gecko/20100101 Firefox/74.0\n" +
                        "Host: localhost:8080\n" +
                        "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\n" +
                        "Accept-Language: en-US,en;q=0.5\n" +
                        "Accept-Encoding: gzip, deflate"
        };

        for(String request: requests) {
            RequestParser parser = new RequestParser(request);
            parser.getResource();
        }
    }


    @Test(expected = InvalidRequestResourceException.class)
    public void testResourceNoResource() throws InvalidRequestResourceException {

        String request = "GET HTTP/1.1\n" +
                "Host: localhost:8080\n" +
                "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:74.0) Gecko/20100101 Firefox/74.0\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\n" +
                "Accept-Language: en-US,en;q=0.5\n" +
                "Accept-Encoding: gzip, deflate";

        RequestParser parser = new RequestParser(request);
        parser.getResource();
    }


    @Test(expected = InvalidRequestResourceException.class)
    public void testResourceBadResource() throws InvalidRequestResourceException {

        String request = "GET x HTTP/1.1\n" +
                "Host: localhost:8080\n" +
                "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:74.0) Gecko/20100101 Firefox/74.0\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\n" +
                "Accept-Language: en-US,en;q=0.5\n" +
                "Accept-Encoding: gzip, deflate";

        RequestParser parser = new RequestParser(request);
        parser.getResource();
    }


    @Test(expected = InvalidRequestResourceException.class)
    public void testResourceBadResource2() throws InvalidRequestResourceException {

        String request = "GET page.txt HTTP/1.1\n" +
                "Host: localhost:8080\n" +
                "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:74.0) Gecko/20100101 Firefox/74.0\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\n" +
                "Accept-Language: en-US,en;q=0.5\n" +
                "Accept-Encoding: gzip, deflate";

        RequestParser parser = new RequestParser(request);
        parser.getResource();
    }


    @Test
    public void testHTTPVersionOk() throws InvalidRequestHTTPVersionException {
        String[] requests = {"GET page.txt HTTP/1.1", "GET page.txt HTTP/0.9",
                "GET page.txt HTTP/1.0", "GET page.txt HTTP/2.0"};

        for(String request: requests) {
            RequestParser parser = new RequestParser(request);
            parser.getHTTPVersion();
        }
    }


    @Test(expected = InvalidRequestHTTPVersionException.class)
    public void testHTTPVersionBad1() throws InvalidRequestHTTPVersionException {
        String request = "GET /page.txt HTTP/2.5";

        RequestParser parser = new RequestParser(request);
        parser.getHTTPVersion();
    }


    @Test(expected = InvalidRequestHTTPVersionException.class)
    public void testHTTPVersionBad2() throws InvalidRequestHTTPVersionException {
        String request = "GET /page.txt HTTP";

        RequestParser parser = new RequestParser(request);
        parser.getHTTPVersion();
    }


    @Test(expected = InvalidRequestHTTPVersionException.class)
    public void testHTTPVersionBad3() throws InvalidRequestHTTPVersionException {
        String request = "GET /page.txt HTTP/";

        RequestParser parser = new RequestParser(request);
        parser.getHTTPVersion();
    }


    @Test(expected = InvalidRequestHTTPVersionException.class)
    public void testHTTPVersionBad4() throws InvalidRequestHTTPVersionException {
        String request = "GET /page.txt HTTP/0.0";

        RequestParser parser = new RequestParser(request);
        parser.getHTTPVersion();
    }


    @Test(expected = InvalidRequestHTTPVersionException.class)
    public void testHTTPVersionBad5() throws InvalidRequestHTTPVersionException {
        String request = "GET /page.txt";

        RequestParser parser = new RequestParser(request);
        parser.getHTTPVersion();
    }


    @Test
    public void testHostOk() throws InvalidRequestHostException {
        RequestParser parser = new RequestParser("content");
        parser.getHost();
    }


    @Test(expected = InvalidRequestHostException.class)
    public void testHostBad() throws InvalidRequestHostException {
        RequestParser parser = new RequestParser("content");
        parser.getHost();
    }







}
