package unit6_code;
import java.io.*;
import java.util.*;
public class GameHelper 
{
	private static final String alphabet="abcdefg";//final指该变量或方法为最终，无法被覆盖
	private int gridLength=7;
	private int gridSize=49;
	private int [] grid=new int[gridSize];
	private int comCount=0;
	
	public String getUserInput(String prompt)
	{
		String inputLine=null;
		System.out.print(prompt+" ");
		try
		{
			BufferedReader is=new BufferedReader((new InputStreamReader(System.in)));
			inputLine=is.readLine();
			if (inputLine.length()==0) return null;
		}catch(IOException e)
		{
			System.out.println("IOException:"+e);
		}
		return inputLine.toLowerCase();//转化成大写
	}
	
	public ArrayList<String> placeDotCom(int comsize)
	{
		ArrayList<String> alphaCells=new ArrayList<String>();
		String [] alphacoords=new String[comsize];
		String temp=null;
		int[] coords=new int[comsize];
		int attempts=0;
		boolean success=false;
		int location=0;
		
		comCount++;
		int incr=1;
		if ((comCount%2)==1)
		{
			incr=gridLength;
		}
		while (!success&attempts++<200)
		{
			location=(int)(Math.random()*gridSize);
			int x=0;
			success=true;
			while (success&&x<comsize)
			{
				if (grid[location]==0)
				{
					coords[x++]=location;
					location+=incr;
					if (location>=gridSize)
						{
							success=false;
							x=0;
						}
				}
				else 
					{
						success=false;
						x=0;
					}
			}
		}
		int x=0;
		int row=0;
		int column=0;
		while (x<comsize)
		{
			grid[coords[x]]=1;
			row=(int)(coords[x]/gridLength);
			column=coords[x]%gridLength;
			temp=String.valueOf(alphabet.charAt(column));//charAt返回特定索引下的值，如不存在则返回-1，valueOf()将括号内元素转化为字符串
			alphaCells.add(temp.concat(Integer.toString(row)));//Integer.toString（）将整数转化为字符串
			x++;
		}
		return alphaCells;
	}
}
