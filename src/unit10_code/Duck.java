package unit10_code;

public class Duck 
{
	private int size;
	private static int duckCount=0;//静态变量会在第一次载入后初始化，在所有对象中共用
	//静态变量共享，所有实例共享一份静态变量
	public Duck()
	{
		duckCount++;
	}
	public void setsize(int s)
	{
		size=s;
	}
	public int getsize()
	{
		return size;
	}
}
