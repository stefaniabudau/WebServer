package handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

import exception.request.InvalidRequestException;
import parser.RequestParser;


public class RequestHandler {

    private HashMap<String, String> requestDetails;
    private BufferedReader in;

    public RequestHandler(BufferedReader in) throws IOException {
        this.requestDetails = new HashMap<>();
        this.in = in;
    }

    public HashMap handleRequests() throws IOException, InvalidRequestException {
        String request = this.getRequest();
        this.createNewRequest(request);
        return this.requestDetails;
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
        this.requestDetails.put("method", parser.getMethod());
        this.requestDetails.put("uri", parser.getResource());
        this.requestDetails.put("host", parser.getHost());
        this.requestDetails.put("HTTP version", parser.getHTTPVersion());
    }
}
