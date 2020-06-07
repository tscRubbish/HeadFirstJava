package unit15_code;
import java.io.*;
import java.net.*;

public class DailyAdviceClient 
{
	public void go()
	{
		try
		{
			Socket s=new Socket("127.0.0.1",4242);//ͨ��socket����������
			//4242�Ƕ˿ں�
			//TCP�˿ں���16λֵ��ָ���ض�Ӧ�ó�����ʹ�û����Ϸ������ϲ�ͬӦ�ó���
			//0~1023�Ǳ�����HTTP��FTP��SMTP����֪����
			InputStreamReader streamReader=new InputStreamReader(s.getInputStream());
			BufferedReader reader=new BufferedReader(streamReader);//�ȶ��뻺����
			
			String advice=reader.readLine();
			System.out.println("today you should"+advice);
			reader.close();
			s.close();//�ر�����
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
