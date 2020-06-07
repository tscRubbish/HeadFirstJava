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
			ServerSocket serverSock=new ServerSocket(4242);//ServerSocket������ͻ��˶�4242�˿�
			
			while (true)
			{
				Socket sock=serverSock.accept();//��һ���µ�socket���ӽ��ܿͻ�����
				//���������ͣ�����ȴ�Ҫ��ﵽ
				//����ԭ�ӿڿ��Եȴ��µ�����
				PrintWriter writer=new PrintWriter(sock.getOutputStream());//��������socket�Ĵ�����PrintWriter����
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
