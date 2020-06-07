package unit16_code;

import java.util.*;
import java.io.*;
public class Jukebox2 
{
	ArrayList<Song>songsList=new ArrayList<Song>();
	class Song implements Comparable<Song>//此处涉及泛型得知识，通过查API发现可以sort得参数类型必须是Conparable得子类
	{
		String title;
		String artist;
		String rating;
		String bpm;
		public int compareTo(Song s)//规定排序标准
		{
			return title.compareTo(s.getTitle());
		}
		Song(String t,String a,String r,String b)
		{
			title=t;
			artist=a;
			rating=r;
			bpm=b;
		}
		public String getTitle()
		{
			return title;
		}
		public String getArtist()
		{
			return artist;
		}
		public String getRating()
		{
			return rating;
		}
		public String getBpm()
		{
			return bpm;
		}
		public String toString()//覆盖原方法，使song类型返回歌名
		{
			return title;
		}
	}
	public static void main(String[] args) 
	{
		Jukebox2 run=new Jukebox2();
		run.go();
	}
	public void go()
	{
		getSongs();
		Collections.sort(songsList);
		System.out.println(songsList);
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
		String[] take=message.split("/");
		songsList.add(new Song(take[0],take[1],take[2],take[3]));
	}
}
