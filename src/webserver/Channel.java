package webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Channel {

    private Socket socket;
    private BufferedReader in;
    private OutputStream out;

    public Channel(Socket socket) throws IOException {
        this.socket = socket;
        this.in = new BufferedReader(
                new InputStreamReader(this.socket.getInputStream()));
        this.out = this.socket.getOutputStream();
    }

    public BufferedReader getClientEnd(){
        return this.in;
    }

    public OutputStream getWebServerEnd(){
        return this.out;
    }

    public void close() throws IOException {
        this.in.close();
        this.out.close();
        this.socket.close();

    }
}
