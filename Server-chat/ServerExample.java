import java.net.*;
import java.io.*;
public class ServerExample {

	public static void main(String[] args) throws Exception {
	ServerSocket ss=new ServerSocket(4000);
	Socket s=ss.accept();
	DataInputStream dis=new DataInputStream(s.getInputStream());
	DataOutputStream dos=new DataOutputStream(s.getOutputStream());
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	String str=""; String str1="";
	while(!str.equals("stop")) {
		str=dis.readUTF();
		System.out.println("Client Says :" + " " + str);
		str1=br.readLine();
		dos.writeUTF(str1);
		dos.flush();
	}
	br.close();
	dos.close();
	dis.close();
	s.close();
	ss.close();
	}

}
