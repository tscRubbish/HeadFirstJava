package unit10_code;

public class Duck 
{
	private int size;
	private static int duckCount=0;//��̬�������ڵ�һ��������ʼ���������ж����й���
	//��̬������������ʵ������һ�ݾ�̬����
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
