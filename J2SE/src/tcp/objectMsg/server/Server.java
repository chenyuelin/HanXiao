package tcp.objectMsg.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		
		try {
			ServerSocket ss = new ServerSocket(9528);
			Socket s = ss.accept();
			
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			new Thread(new ServerListen(ois)).start();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			Message msg = new Message();
			while((line = reader.readLine()) != null) {
				msg.setMsg(line);
				msg.setMsgType(0);
				oos.writeObject(msg);
				oos.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class ServerListen implements Runnable {
	ObjectInputStream ois = null;
	Message msg = null;
	
	public ServerListen(ObjectInputStream ois) {
		super();
		this.ois = ois;
	}

	@Override
	public void run() {
		try {
			while((msg = (Message)ois.readObject()) != null) {
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
