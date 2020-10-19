package webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class WebServerUtils {

    public String[] getRequest(Socket socket, InputStreamReader reader) throws IOException {
        String inputLine;
        String[] request= new String[100];
        int index = 0;

        BufferedReader in = new BufferedReader(reader);

        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            request[index] = inputLine;
            index ++;

            if (inputLine.trim().equals(""))
                break;
        }
        return request;
    }


    public String[] buildResponse(){
        return null;
    }

    public void sendResponse(Socket socket, OutputStream out) throws IOException {

        out.write(("HTTP/1.1 200 OK\r\n").getBytes());
        out.write(("ContentType: " + "text/html\r\n").getBytes());
        out.write("\r\n".getBytes());
        out.write("It works".getBytes());
        out.write("\r\n\r\n".getBytes());
        out.flush();
    }

    public void closeConenction(){}
}


