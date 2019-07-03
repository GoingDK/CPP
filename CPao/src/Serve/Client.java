package Serve;


import java.io.*;
import java.net.*;

public class Client {

	ObjectOutputStream oos ;
	ObjectInputStream ois ;
	public Client() throws UnknownHostException, IOException{
		String ip="193.112.10.155";
		int port=18888;
		Socket s = new Socket(ip,port);
		oos = new ObjectOutputStream(s.getOutputStream());
		ois = new ObjectInputStream(s.getInputStream());
		send("Œ“œ≤ª∂—ßœ∞");
		
	}
	public String send(String info) throws IOException{
		oos.writeUTF(info);
		oos.flush();
		
		return ois.readUTF();
	}
	public static void main(String[] args) {
		try {
			new Client();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
