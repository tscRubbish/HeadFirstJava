package unit5_code;
import java.io.*;
public class GameHelper 
{
	public String getUserInput(String prompt)
	{
		String inputLine=null;
		System.out.print(prompt+" ");
		try
		{
			BufferedReader is=new BufferedReader((new InputStreamReader(System.in)));
			inputLine=is.readLine();
			if (inputLine.length()==0) return null;
		}catch(IOException e)//IOException ‰»Î ‰≥ˆ“Ï≥£
		{
			System.out.println("IOException:"+e);
		}
		return inputLine;
	}
}