package unit10_code;

public class STatic 
{
	public static int min(int a,int b)
	{
		return (a<b)?a:b;
	}
}
//static是静态，被static标记的方法直接用类名调用，不用对象调用，如Math.min(),min是Math中静态方法
//带有静态方法通常不初始化，可以用abstract建立抽象类，也可以将构造函数私有化（private）
//用main来启动或测试其他类，从main（）创建实例
//静态方法不能调用非静态变量，实例变量
//因为不知道是哪个对象的实例变量
//静态方法也不能调用非静态方法，如：
//public class Duck
//{
//	private int size;
//	public static void main(String[] args)
//	{
//		System.out.println(getsize());
//		System.out.println(size);
//	}
//	public void setsize(int s)
//	{
//		size=s;
//	}
//	public void getsize()
//	{
//		return size;
//	}
//}
//会报错