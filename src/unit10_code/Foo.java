package unit10_code;

public class Foo 
{
	static int x=12;
	public void go()
	{
		System.out.println(x);
	}
}
//补充：每个数据类型都有包装用的类，
//Boolean,Character,Byte,Short,Integer,Long,Float,Double大多数都是首字母大写
//int i=288;Integer iwrap=new Integer(i)把i装入Integer类
//int unwrapped=iwrap.intValue();提取Integer类中的值
//ArrayList只能对类进行操作