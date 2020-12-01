package test;

import exception.request.*;
import org.junit.Test;
import parser.RequestParser;

public class RequestParserTest {

    @Test
    public void testResourceOk() throws InvalidRequestException {
        String[] requests = {
                "GET / HTTP/1.1\r\n" +
                        "Host: localhost:8080\r\n" +
                        "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:74.0) Gecko/20100101 Firefox/74.0\r\n" +
                        "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\r\n" +
                        "Accept-Language: en-US,en;q=0.5\r\n" +
                        "Accept-Encoding: gzip, deflate",

                "GET /proj/proj.html HTTP/1.1\r\n" +
                        "Host: localhost:8080\r\n" +
                        "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:74.0) Gecko/20100101 Firefox/74.0\r\n" +
                        "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\r\n" +
                        "Accept-Language: en-US,en;q=0.5\r\n" +
                        "Accept-Encoding: gzip, deflate",

                "GET /style.css HTTP/1.1\r\n" +
                        "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:74.0) Gecko/20100101 Firefox/74.0\r\n" +
                        "Host: localhost:8080\r\n" +
                        "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\r\n" +
                        "Accept-Language: en-US,en;q=0.5\r\n" +
                        "Accept-Encoding: gzip, deflate",

        };

        for(String request: requests) {
            RequestParser parser = new RequestParser(request);
            parser.getResource();
        }
    }


    @Test(expected = InvalidRequestException.class)
    public void testResourceNoResource() throws InvalidRequestException {

        String request = "GET HTTP/1.1\r\n" +
                "Host: localhost:8080\r\n" +
                "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:74.0) Gecko/20100101 Firefox/74.0\r\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\r\n" +
                "Accept-Language: en-US,en;q=0.5\r\n" +
                "Accept-Encoding: gzip, deflate";

        RequestParser parser = new RequestParser(request);
        parser.getResource();
    }


    @Test(expected = InvalidRequestException.class)
    public void testResourceBadResource() throws InvalidRequestException {

        String request = "GET x HTTP/1.1\r\n" +
                "Host: localhost:8080\r\n" +
                "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:74.0) Gecko/20100101 Firefox/74.0\r\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\r\n" +
                "Accept-Language: en-US,en;q=0.5\r\n" +
                "Accept-Encoding: gzip, deflate";

        RequestParser parser = new RequestParser(request);
        parser.getResource();
    }


    @Test(expected = InvalidRequestException.class)
    public void testResourceBadResource2() throws InvalidRequestException {

        String request = "GET page.txt HTTP/1.1\r\n" +
                "Host: localhost:8080\r\n" +
                "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:74.0) Gecko/20100101 Firefox/74.0\r\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\r\n" +
                "Accept-Language: en-US,en;q=0.5\r\n" +
                "Accept-Encoding: gzip, deflate";

        RequestParser parser = new RequestParser(request);
        parser.getResource();
    }


    @Test
    public void testHTTPVersionOk() throws InvalidRequestException {
        String[] requests = {"GET page.txt HTTP/1.1", "GET page.txt HTTP/0.9",
                "GET page.txt HTTP/1.0", "GET page.txt HTTP/2.0"};

        for(String request: requests) {
            RequestParser parser = new RequestParser(request);
            parser.getHTTPVersion();
        }
    }


    @Test(expected = InvalidRequestException.class)
    public void testHTTPVersionBad1() throws InvalidRequestException {
        String request = "GET /page.txt HTTP/2.5";

        RequestParser parser = new RequestParser(request);
        parser.getHTTPVersion();
    }


    @Test(expected = InvalidRequestException.class)
    public void testHTTPVersionBad2() throws InvalidRequestException {
        String request = "GET /page.txt HTTP";

        RequestParser parser = new RequestParser(request);
        parser.getHTTPVersion();
    }


    @Test(expected = InvalidRequestException.class)
    public void testHTTPVersionBad3() throws InvalidRequestException {
        String request = "GET /page.txt HTTP/";

        RequestParser parser = new RequestParser(request);
        parser.getHTTPVersion();
    }


    @Test(expected = InvalidRequestException.class)
    public void testHTTPVersionBad4() throws InvalidRequestException {
        String request = "GET /page.txt HTTP/0.0";

        RequestParser parser = new RequestParser(request);
        parser.getHTTPVersion();
    }


    @Test(expected = InvalidRequestException.class)
    public void testHTTPVersionBad5() throws InvalidRequestException {
        String request = "GET /page.txt";

        RequestParser parser = new RequestParser(request);
        parser.getHTTPVersion();
    }
}
