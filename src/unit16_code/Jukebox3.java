package unit16_code;

import java.util.*;
import java.io.*;

public class Jukebox3 
{
	ArrayList<Song>songsList=new ArrayList<Song>();
	public static void main(String[] args) 
	{
		Jukebox3 run=new Jukebox3();
		run.go();
	}
	
	class Song implements Comparable<Song>
	{
		String title;
		String artist;
		String rating;
		String bpm;
		public int compareTo(Song s)//Ĭ�ϵ������׼
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
		public String toString()//����ԭ������ʹsong���ͷ��ظ���
		{
			return title+"   "+artist;
		}
	}
	class ArtistCompare implements Comparator<Song>//��дһ�����������׼���࣬�Ը�������
	{
		public int compare(Song one,Song two)
		{
			return one.getArtist().compareTo(two.getArtist());
		}
	}
	class TitleCompare implements Comparator<Song>//��дһ�����������׼���࣬�Ը�������
	{
		public int compare(Song one,Song two)
		{
			return one.getTitle().compareTo(two.getTitle());
		}
	}
	public void go()
	{
		getSongs();
		
		TitleCompare titleCompare=new TitleCompare();
		Collections.sort(songsList,titleCompare);
		System.out.println(songsList);
		
		ArtistCompare artistCompare=new ArtistCompare();
		Collections.sort(songsList,artistCompare);
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
