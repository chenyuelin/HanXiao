package tcp.objectMsg.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	public static void main(String[] args) {
		Message msg = new Message();
		try {
			Socket socket = new Socket("localhost", 9528);
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			new Thread(new ClientListen(ois)).start(); 
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			while((line = reader.readLine()) != null) {
				msg.setMsg(line);
				msg.setMsgType(1);
				oos.writeObject(msg);
				oos.flush();
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}

class ClientListen implements Runnable {
	
	Message msg = null;
	ObjectInputStream ois = null;
	
	public ClientListen(ObjectInputStream ois) {
		super();
		this.ois = ois;
	}

	@Override
	public void run() {
		try {
			while ((msg = (Message)ois.readObject()) != null) {
				System.out.println(msg.getMsg());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}