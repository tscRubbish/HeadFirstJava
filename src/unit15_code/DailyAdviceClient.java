package unit15_code;
import java.io.*;
import java.net.*;

public class DailyAdviceClient 
{
	public void go()
	{
		try
		{
			Socket s=new Socket("127.0.0.1",4242);//通过socket建立服务器
			//4242是端口号
			//TCP端口号是16位值，指定特定应用程序，能使用户脸上服务器上不同应用程序
			//0~1023是保留被HTTP，FTP，SMTP等已知服务
			InputStreamReader streamReader=new InputStreamReader(s.getInputStream());
			BufferedReader reader=new BufferedReader(streamReader);//先读入缓冲区
			
			String advice=reader.readLine();
			System.out.println("today you should"+advice);
			reader.close();
			s.close();//关闭链接
		}catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		DailyAdviceClient client=new DailyAdviceClient();
		client.go();
	}
}
