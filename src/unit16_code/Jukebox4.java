package unit16_code;

import java.util.*;
import java.io.*;

public class Jukebox4 
{
	ArrayList<Song>songsList=new ArrayList<Song>();
	public static void main(String[] args)
	{
		Jukebox4 run=new Jukebox4();
		run.go();
	}
	class Song implements Comparable<Song>
	{
		String title;
		String artist;
		String rating;
		String bpm;
		public int compareTo(Song s)//默认的排序标准
		{
			return title.compareTo(s.getTitle());
		}
		public boolean equals(Object aSong)//所有类的父类
		{
			Song s=(Song) aSong;
			return getTitle().equals(s.getTitle());//按歌名判重
		}
		public int hashCode()
		{
			return title.hashCode();//以歌名hash
		}
		//重写判重方法
		//相同hash值不一定代表对象相等
		//没有重载hashCode，那么两对象不可能相同
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
			return title+"   "+artist;
		}
	}
	public void go()
	{
		getSongs();
		
		System.out.println(songsList);
		Collections.sort(songsList);
		System.out.println(songsList);
		HashSet<Song> songSet=new HashSet<Song>();
		//hashSet可以去重
		songSet.addAll(songsList);//将一个集合的元素一个一个加入
		System.out.println(songSet);
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
