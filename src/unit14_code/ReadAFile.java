package unit14_code;

import java.io.*;

public class ReadAFile 
{

	public static void main(String[] args) 
	{
		try
		{
			File myFile=new File("MyText.txt");//file对象代表文件路径，可以同file对象创建，浏览，删除目录
			FileReader fileReader=new FileReader(myFile);//FileReader是连接到文本文件的串流
			
			BufferedReader reader=new BufferedReader(fileReader);//将FileReader与BufferedReader链接，获得更高效率
			
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
