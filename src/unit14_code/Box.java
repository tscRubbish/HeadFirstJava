package unit14_code;

import java.io.*;
//���������л�
public class Box implements Serializable//����Ҫ���Ƿ�����ֻ���������Ա���ʼ��
//����ʵ�����л��������Զ�ʵ��
{
	private int width;
	private int height;
	transient String Name;//transient��˲ʱ�����л�ʱ�����˱���
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
			FileOutputStream fs=new FileOutputStream("foo.ser");//Stream�������ô�����������ʾԴ��Ŀ�ĵأ��ļ�
			ObjectOutputStream os=new ObjectOutputStream(fs);
			os.writeObject(myBox);
			os.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
