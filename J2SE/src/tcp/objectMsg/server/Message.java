package tcp.objectMsg.server;

import java.io.Serializable;

public class Message implements Serializable {
	
	private int msgType;
	private String msg;
	
	public int getMsgType() {
		return msgType;
	}
	public void setMsgType(int msgType) {
		this.msgType = msgType;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}

