package unit12_code;

public class MyOuter 
{
	private int x;
	MyInner inner=new MyInner();
	public void doStuff()
	{
		inner.go();
	}
	class MyInner//�ڲ���
	{
		void go()
		{
			x=42;//�ڲ�����Է����ⲿ���ʵ������(˽��Ҳ����)
		}
	}
}
