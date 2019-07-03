package Serve;

import java.io.*;

import java.net.*;

public class Server extends Thread{

	ObjectInputStream ois ;
	ObjectOutputStream oos ;
	ServerSocket ss ;
	public void close() throws IOException{
		ss.close();
		System.out.println("close ok");
	}
	public void run() {
		
		int port=18888;
		try {
			ss = new ServerSocket(port);
			while(true){
				Socket s = ss.accept();
				oos = new ObjectOutputStream(s.getOutputStream());
				ois = new ObjectInputStream(s.getInputStream());
				response();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public void response() throws IOException{
		
		System.out.println(ois.readUTF());
		oos.writeUTF("»¶Ó­");
		oos.flush();
	}
}
