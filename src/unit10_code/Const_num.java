package unit10_code;

public class Const_num 
{
	public static final double PI=3.1415926535;
	//public表示开放读取
	//static表示不需要实例对象
	//final表示值不变
	static //静态初始化程序
	{
		System.out.println(PI);
//		PI=3.1415926;
		System.out.println(PI);
	}
}
//两种初始化方法：
//1.在定义变量是赋初值
//2.调用静态初始化程序，会在使用该类前执行
