package webserver;

import exception.config.InvalidRootDirException;
import exception.request.InvalidRequestException;
import handler.RequestHandler;
import handler.ResponseHandler;

import java.net.*;
import java.io.*;

public class WebServer extends Thread {
	protected Socket clientSocket;
	protected int state;

	private WebServer(Socket clientSoc) {
		clientSocket = clientSoc;
		start();
	}

	public static void runWebServer(int port) throws IOException {
		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket(port);
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
			System.err.println("Could not listen on port: " + port);
			System.exit(1);
		} finally {
			try {
				serverSocket.close();
			} catch (IOException e) {
				System.err.println("Could not close port: " + port);
				System.exit(1);
			}
		}
	}


	public void run() {
		System.out.println("New Communication Thread Started");

		try {
			Channel communicationChannel = new Channel(this.clientSocket);

			Request request = RequestHandler.getRequest(communicationChannel);
			Response response = ResponseHandler.getResponse(request, WebServerState.getWebServerState());

			this.sendResponse(communicationChannel, response);
			communicationChannel.close();

		} catch (IOException e) {
			System.err.println("Problem with Communication Server");
			e.printStackTrace();
			System.exit(1);
		}
		catch (InvalidRequestException e){
			e.printStackTrace();
		}
		catch (InvalidRootDirException e){
			e.printStackTrace();
		}
	}


	public void sendResponse(Channel channel, Response response) throws IOException {
		OutputStream out = channel.getWebServerEnd();
		out.write(("HTTP/1.1"+ response.getMessage() + "\r\n").getBytes());
		out.write(("ContentType: " + response.getContentType() + "\r\n").getBytes());
		out.write("\r\n".getBytes());
		out.write(response.getContent());
		out.write("\r\n\r\n".getBytes());
		out.flush();
	}
}