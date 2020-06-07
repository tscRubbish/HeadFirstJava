package unit15_code;

import java.io.*;
import java.net.*;
public class DailyAdviceServer 
{
	String[] adviceList= {"Take smallerbites","Go for the tight jeans.No they don't make you look fat",
			"One word:inappropriate","Just for today,be honest.Tell your boss what you really think",
			"You might want to rethink that haircut"};
	public static void main(String[] args) 
	{
		DailyAdviceServer server=new DailyAdviceServer();
		server.go();
	}
	private String getAdvice()
	{
		int random=(int)(Math.random()*adviceList.length);
		return adviceList[random];
	}
	public void go()
	{
		try
		{
			ServerSocket serverSock=new ServerSocket(4242);//ServerSocket会监听客户端对4242端口
			
			while (true)
			{
				Socket sock=serverSock.accept();//做一个新的socket链接接受客户请求
				//这个方法会停下来等待要求达到
				//这样原接口可以等待新的链接
				PrintWriter writer=new PrintWriter(sock.getOutputStream());//建立链接socket的串流的PrintWriter类型
				String advice=getAdvice();
				writer.println(advice);
				writer.close();
				System.out.println(advice);
				serverSock.close();
			}
		}catch(IOException ex)
		{
			//ex.printStackTrace();
		}
	}
}
