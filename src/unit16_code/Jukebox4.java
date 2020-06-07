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
		public int compareTo(Song s)//Ĭ�ϵ������׼
		{
			return title.compareTo(s.getTitle());
		}
		public boolean equals(Object aSong)//������ĸ���
		{
			Song s=(Song) aSong;
			return getTitle().equals(s.getTitle());//����������
		}
		public int hashCode()
		{
			return title.hashCode();//�Ը���hash
		}
		//��д���ط���
		//��ͬhashֵ��һ������������
		//û������hashCode����ô�����󲻿�����ͬ
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
	public void go()
	{
		getSongs();
		
		System.out.println(songsList);
		Collections.sort(songsList);
		System.out.println(songsList);
		HashSet<Song> songSet=new HashSet<Song>();
		//hashSet����ȥ��
		songSet.addAll(songsList);//��һ�����ϵ�Ԫ��һ��һ������
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
