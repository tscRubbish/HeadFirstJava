package unit10_code;

public class boxing 
{

	public static void main(String[] args) 
	{
		String s="2";
		int x=Integer.parseInt(s);//将字符串转化为int
		System.out.println(x);
		double d=Double.parseDouble("420.24");//转化为double
		boolean b=new Boolean("true").booleanValue();
		//boolean可以直接向构造函数传递字符串
		d=42.5;
		String doubleString=""+d;//调用重载的+运算符
		String doubleString2=Double.toString(d);//调用Double类的静态函数
		System.out.println(doubleString);
		System.out.println(doubleString2);
	}

}
