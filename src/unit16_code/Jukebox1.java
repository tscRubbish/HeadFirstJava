package unit16_code;

import java.util.*;
import java.io.*;

public class Jukebox1 
{
	ArrayList<String> songList=new ArrayList<String>();
	public static void main(String[] args) 
	{
		Jukebox1 run=new Jukebox1();
		run.go();
	}
	public void go()
	{
		getSongs();
		Collections.sort(songList);//collection中的排序参数是List，但List是ArrayList得接口，由于多态原理可以直接传递ArrayList
		System.out.println(songList);
	}
	void getSongs()
	{
		try
		{
			File file=new File("songList.txt");
			BufferedReader reader=new BufferedReader(new FileReader(file));
			String line=null;
			while ((line=reader.readLine())!=null)
			{
				addSongs(line);
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	void addSongs(String message)
	{
		String[] takeSongs=message.split("/");
		songList.add(takeSongs[0]);
	}
}
