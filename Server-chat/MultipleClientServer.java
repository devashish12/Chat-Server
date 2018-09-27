import java.io.*;
import java.net.*;
public class MultipleClientServer {
public static void main(String args[]) {
	ServerSocket ss=null;
	Socket s=null;
	System.out.println("server is listening");
	try {
		ss=new ServerSocket(3333);
	}catch(Exception e) {System.out.println("Srever error");}
	while(true) {
		try {
			s=ss.accept();
			ServerThread st=new ServerThread(s);
			st.start();
		}catch(Exception e) {System.out.println("listening error");}
	}
}
}
class ServerThread extends Thread{
	DataInputStream dis=null;
	DataOutputStream dos=null;
	BufferedReader rs=null;
	String str=""; String str1="";
	Socket s=null;
	ServerThread(Socket s){
		this.s=s;
	}
public void run() {
	try {
		dis=new DataInputStream(s.getInputStream());
		dos=new DataOutputStream(s.getOutputStream());
		rs=new BufferedReader(new InputStreamReader(System.in));
		while(!str.equals("stop")) {
			str=dis.readUTF();
			System.out.println("Clients Says " + " " +str);
			str1=rs.readLine();
			dos.writeUTF(str1);
			dos.flush();
		}
		if(dis!=null) {
			dis.close();
		}
	}catch(Exception e) {System.out.println("running error");}
}
}

