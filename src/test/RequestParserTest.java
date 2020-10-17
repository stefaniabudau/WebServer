package test;

import exception.request.InvalidRequestHTTPVersionException;
import exception.request.InvalidRequestHostException;
import exception.request.InvalidRequestResourceException;
import org.junit.Test;
import parser.RequestParser;

public class RequestParserTest {

    @Test
    public void testResourceOk() throws InvalidRequestResourceException {
        RequestParser parser = new RequestParser("content");
        parser.getResource();
    }


    @Test(expected = InvalidRequestResourceException.class)
    public void testResourceBad() throws InvalidRequestResourceException {
        RequestParser parser = new RequestParser("content");
        parser.getResource();
    }


    @Test
    public void testHTTPVersionOk() throws InvalidRequestHTTPVersionException {
        RequestParser parser = new RequestParser("content");
        parser.getHTTPVersion();
    }


    @Test(expected = InvalidRequestHTTPVersionException.class)
    public void testHTTPVersionBad() throws InvalidRequestHTTPVersionException {
        RequestParser parser = new RequestParser("content");
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
