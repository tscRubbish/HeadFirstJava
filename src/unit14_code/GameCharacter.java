package unit14_code;

import java.io.*;

public class GameCharacter implements Serializable//注意此处要申明可序列化
{
	int power;
	String type;
	String[] weapons;
	static int cnt=0;
	public GameCharacter(int p,String t,String[] w)
	{
	 power=p;
	 type=t;
	 weapons=w;
	 cnt++;
	}
	public int getPower()
	{
		return power;
	}
	public String getType()
	{
		return type;
	}
	public String[] getWeapons()
	{
		return weapons;
	}
}
