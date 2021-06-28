package algorithms;


import algorithms.Commands.DefaultIO;
import algorithms.Server.ClientHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class AnomalyDetectionHandler implements ClientHandler{


	SocketIO sio;


	// ----------------------------------------------------------------------------------------------------------------- //


	public void runCLI(SocketIO aClient) {

		CLI cli = new CLI(aClient);
		cli.start();
	}


	// ----------------------------------------------------------------------------------------------------------------- //
	
	public void communicate(Socket s)
	{
		try {

			SocketIO aClient = new SocketIO(s.getInputStream(), s.getOutputStream());
			runCLI(aClient);
			aClient.write("bye");
			aClient.close();
		}
		catch (IOException e) {

			return;
		}
	}

	// ----------------------------------------------------------------------------------------------------------------- //


	public class SocketIO implements DefaultIO{

		Scanner in;
		PrintWriter out;
		public SocketIO(InputStream inFromClient,OutputStream outToClient)
		{
			this.in = new Scanner(inFromClient);
			this.out=new PrintWriter(outToClient);
		}

		@Override
		public String readText() {
			return in.nextLine();
		}

		@Override
		public void write(String text) {
			out.print(text);
			out.flush();
		}

		@Override
		public float readVal() { return in.nextFloat();}

		@Override
		public void write(float val) {
			out.print(val);
			out.flush();
		}

		public void close() {
			in.close();
			out.close();
		}
	}

}
