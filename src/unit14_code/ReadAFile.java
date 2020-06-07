package unit14_code;

import java.io.*;

public class ReadAFile 
{

	public static void main(String[] args) 
	{
		try
		{
			File myFile=new File("MyText.txt");//file��������ļ�·��������ͬfile���󴴽��������ɾ��Ŀ¼
			FileReader fileReader=new FileReader(myFile);//FileReader�����ӵ��ı��ļ��Ĵ���
			
			BufferedReader reader=new BufferedReader(fileReader);//��FileReader��BufferedReader���ӣ���ø���Ч��
			
			String line=null;
			while ((line=reader.readLine())!=null)
			{
				System.out.println(line);
			}
			reader.close();
		}catch(IOException ex)
		{
			ex.printStackTrace();
		}

	}

}
