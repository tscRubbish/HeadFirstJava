package unit14_code;

import java.io.*;
//将数据数列化
public class Box implements Serializable//不需要覆盖方法，只是声明可以被初始化
//父类实现序列化，子类自动实现
{
	private int width;
	private int height;
	transient String Name;//transient（瞬时）序列化时跳过此变量
	public void setwidth(int w)
	{
		width=w;
	}
	public void setheight(int h)
	{
		height=h;
	}
	public static void main(String[] args) 
	{
		Box myBox=new Box();
		myBox.setwidth(50);
		myBox.setheight(20);
		try
		{
			FileOutputStream fs=new FileOutputStream("foo.ser");//Stream是链接用串流，用来表示源，目的地，文件
			ObjectOutputStream os=new ObjectOutputStream(fs);
			os.writeObject(myBox);
			os.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
