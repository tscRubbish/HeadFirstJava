package unit9_code;

class Duck
{
	private int size;
	public Duck()//不需要传递参数的构造函数，与下面的Duck()为重载关系
	{
		System.out.println("Quack");
		size=27;
		System.out.println("Size is 27");
	}
	//最好有不带参数的构造函数，便于使用默认值
	public Duck(int ducksize)//构造函数无返回值，会在堆开一块内存(可以带参数)
	{
		System.out.println("Quack");
		
		if (ducksize==0) size=27;
		else
			size=ducksize;
		//如果没有指定size则默认值
		System.out.println("Size is "+size);
	}
	//作用：1.初始化，2.可以通过输入创建对象，3.父类构造函数
	//构造函数不会被继承
	//如果有一个以上的构造函数，参数一定要不一样
	public void setSize(int newsize)
	{
		size=newsize;
	}
}
public class useADuck 
{

	public static void main(String[] args) 
	{
		Duck d=new Duck(42);//这是平时初始化，但其实Duck()是一个构造函数，可以自己编写
		d.setSize(42);
		Duck d2=new Duck(0);
		Duck d3=new Duck();
	}

}
