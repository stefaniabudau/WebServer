package webserver;

import handler.ResponseHandler;

import java.io.OutputStream;
import java.net.Socket;

public class Response {

    public Response(OutputStream out, Request request){
        ResponseHandler handler = new ResponseHandler(out, request);
    }
}
