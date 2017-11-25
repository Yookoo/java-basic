package command2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;

public class Client {

	private Socket socket;

	public static void main(String[] args) throws UnknownHostException, IOException {
		Client client = new Client();
		client.startSocket();
		client.visitServer();
		client.shutdownClient();
	}
	
	private void startSocket() throws UnknownHostException, IOException{
		socket = new Socket("localhost",8888); 
	}
	
	public void visitServer() throws IOException{
		
		System.out.println("----请输入您要访问的url地址,退出请输入（exit）:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in,Charset.forName("UTF-8")));

		String url = null;
		if( (url = reader.readLine()) != null){
			OutputStream outputStream =  socket.getOutputStream();
			//将字节输出流包装为数据输出流;
			DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
			
			dataOutputStream.writeUTF(url);
			dataOutputStream.flush();
			InputStream inputStream = socket.getInputStream();
			DataInputStream dataInputStream = new DataInputStream(inputStream);
			String response = dataInputStream.readUTF();
			System.out.println(response);
			dataInputStream.close();
			inputStream.close();
			dataOutputStream.close();
			outputStream.close();
		}
		reader.close();
	}
	
	private void shutdownClient() throws IOException{
		socket.close();
	}
	
}
