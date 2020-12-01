package handler;

import java.io.BufferedReader;
import java.io.IOException;

import exception.request.InvalidRequestException;
import parser.RequestParser;
import webserver.Channel;
import webserver.Request;


public class RequestHandler {

    public static Request getRequest(Channel channel) throws IOException, InvalidRequestException {
        String request = readRequest(channel.getClientEnd());
        RequestParser parser = new RequestParser(request);

        return new Request(
                parser.getMethod(),
                parser.getResource(),
                parser.getHost(),
                parser.getHTTPVersion());
    }

    private static String readRequest(BufferedReader in) throws IOException {
        String inputLine;
        StringBuilder request = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
//            System.out.println(inputLine);
            request.append(inputLine + "\r\n");

            if (inputLine.trim().equals(""))
                break;
        }
        return request.toString();
    }
}
