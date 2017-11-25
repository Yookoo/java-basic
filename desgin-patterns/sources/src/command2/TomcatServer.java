package command2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import singleton.Config;

public class TomcatServer {

	public volatile Boolean on = true;
	private ServerSocket serverSocket;
	private static Properties properties = new Properties();
	
	private static Map<String,Class<? extends Servlet>> urlAndClassMaps =new  HashMap<String,Class<? extends Servlet>>();
	//服务器启动时只加载Servlet的字节码文件只有真正调用时才会实例化Servlet;	
	static{
		try {
			properties.load(Servlet.class.getClassLoader().getResourceAsStream("urlServletMaping.properties"));
			Enumeration<?> urlNames = properties.propertyNames();
			while (urlNames.hasMoreElements()) {
				String url = (String) urlNames.nextElement();
				String servletName = properties.getProperty(url);
				@SuppressWarnings("unchecked")
				Class<? extends Servlet> clazz = (Class<? extends Servlet>) Class.forName(servletName);
				urlAndClassMaps.put(url,clazz);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		final TomcatServer server = new TomcatServer();
		server.startService();
		new Thread(new Runnable() {
			@Override
			public void run() {
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")));
				try {
					do{
						System.out.println("----如果想关闭服务器，请输入exit:");
					}while(!reader.readLine().equals("exit"));
					closeServer();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			private void closeServer() throws UnknownHostException, IOException{
				server.setOff();
				Socket socket = new Socket("localhost", 8888);
				DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
				dout.writeUTF("exit");
				socket.close();
			}
			
		}).start();
		server.service();
		
	}

	//获取targetUrl;
	@SuppressWarnings("unchecked")
	public void service() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		while(on){
			//侦听
			Socket socket = serverSocket.accept();
			InputStream inputStream = socket.getInputStream();
			DataInputStream dataInputStream = new DataInputStream(inputStream);
			
			//通过Socket.getInputStream()获取字节流并包装成字符流(效率高);
			
			String targetUrl = dataInputStream.readUTF();
				
			Servlet servlet = checkedUrl(targetUrl);
			if(servlet != null){
				String str = servlet.service();
				OutputStream outputStream = socket.getOutputStream();
				DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
				dataOutputStream.writeUTF(str);
				dataOutputStream.flush();
				dataOutputStream.close();
				outputStream.close();
			}
			inputStream.close();
			dataInputStream.close();
		}
		serverSocket.close();
		
	}
	
	
	private Servlet checkedUrl(String targetUrl) throws InstantiationException, IllegalAccessException{
		Class<? extends Servlet> targetServletClass = urlAndClassMaps.get(targetUrl);
		if(targetServletClass==null){
			throw new RuntimeException("---访问的url地址不存在,请重新输入！---");
		}else{
			return targetServletClass.newInstance();
		}
	}
	
	private void startService() throws IOException{
		//创建
		serverSocket = new ServerSocket(8888);
	}
	
	public void setOff() {
		on = false;
	}
}
