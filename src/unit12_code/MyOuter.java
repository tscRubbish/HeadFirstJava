package unit12_code;

public class MyOuter 
{
	private int x;
	MyInner inner=new MyInner();
	public void doStuff()
	{
		inner.go();
	}
	class MyInner//内部类
	{
		void go()
		{
			x=42;//内部类可以访问外部类的实例变量(私有也可以)
		}
	}
}
