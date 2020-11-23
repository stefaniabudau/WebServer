package handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.HashMap;

import exception.request.InvalidRequestException;
import parser.RequestParser;
import webserver.Request;

public class RequestHandler {

    private Request newRequest;
    private BufferedReader in;

    public RequestHandler(Socket clientSocket) throws IOException {
        this.in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
    }

    public Request handleRequests() throws IOException, InvalidRequestException {
        String request = this.getRequest();
        this.createNewRequest(request);
        return this.newRequest;
    }

    public void close() throws IOException {
        this.in.close();
    }

    private String getRequest() throws IOException {
        String inputLine;
        StringBuilder request = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            request.append(inputLine + "\r\n");

            if (inputLine.trim().equals(""))
                break;
        }
        return request.toString();
    }


    private void createNewRequest(String request) throws InvalidRequestException {
        RequestParser parser = new RequestParser(request);
        this.newRequest = new Request(
                parser.getMethod(),
                parser.getResource(),
                parser.getHost(),
                parser.getHTTPVersion());
    }
}
