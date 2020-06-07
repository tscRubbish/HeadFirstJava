package unit15_code;
import java.io.*;
import java.net.*;
import java.util.*;

public class SimpleChatServer 
{
	ArrayList clientOutputStreams;
	public static void main(String[] args) 
	{
		SimpleChatServer ser=new SimpleChatServer();
		ser.go();
	}
	public class ClientHandler implements Runnable
	{
		BufferedReader reader;
		Socket sock;
		public ClientHandler(Socket clientSocket)
		{
			try
			{
				sock=clientSocket;
				InputStreamReader isReader=new InputStreamReader(sock.getInputStream());
				reader=new BufferedReader(isReader);
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		public void run()
		{
			String message=null;
			try
			{
				while ((message=reader.readLine())!=null)
				{
					System.out.println("read "+message);
					tellEveryone(message);
				}
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
	public void go()
	{
		clientOutputStreams=new ArrayList();
		try
		{
			ServerSocket serverSock=new ServerSocket(5000);
			while (true)
			{
				Socket clientSocket=serverSock.accept();
				PrintWriter writer=new PrintWriter(clientSocket.getOutputStream());
				clientOutputStreams.add(writer);//增加一个用户
				Thread t=new Thread(new ClientHandler(clientSocket));
				t.start();
				System.out.println("got a connection");
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public void tellEveryone(String message)
	{
		Iterator it=clientOutputStreams.iterator();//对所有用户输出
		while (it.hasNext())
		{
			try
			{
				PrintWriter writer=(PrintWriter)it.next();
				writer.println(message);
				writer.flush();//缓存区写在隔壁
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
