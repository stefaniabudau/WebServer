package webserver;

import exception.request.InvalidRequestException;

import java.net.*;
import java.io.*;

public class WebServer extends Thread {
	protected Socket clientSocket;
	private WebServerUtils utils = new WebServerUtils();


	private WebServer(Socket clientSoc) {
		clientSocket = clientSoc;
		start();
	}


	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket(10008);
			System.out.println("Connection Socket Created");
			try {
				while (true) {
					System.out.println("Waiting for Connection");
					new WebServer(serverSocket.accept());
				}
			} catch (IOException e) {
				System.err.println("Accept failed.");
				System.exit(1);
			}
		} catch (IOException e) {
			System.err.println("Could not listen on port: 10008.");
			System.exit(1);
		} finally {
			try {
				serverSocket.close();
			} catch (IOException e) {
				System.err.println("Could not close port: 10008.");
				System.exit(1);
			}
		}
	}


	public void run() {
		System.out.println("New Communication Thread Started");

		try {
			Channel communicationChannel = new Channel(this.clientSocket);
			communicationChannel.create();

			Request request = new Request(communicationChannel.getClientEnd());
			Response response = new Response(communicationChannel.getWebServerEnd(), request);

			communicationChannel.close();
			this.clientSocket.close();

		} catch (IOException | InvalidRequestException e) {
			System.err.println("Problem with Communication Server");
			System.exit(1);
		}
	}
}