package unit10_code;
import java.util.Calendar;
import java.util.Date;
public class TestFormats 
{

	public static void main(String[] args) 
	{
		String s=String.format("%,d",100000000);//%d是格式符，加逗号是则表示用，分隔
		System.out.println(s);
		//%，d表示以十进制带逗号表示
		//%.2f保留小数点后2位
		//%,.2f整数部分以，分隔，小数部分保留2位
		//format用的是可变参数列表
		
		//Date类型是java上表示时间的类型
		s=String.format("%tc",new Date());
		//%tc是Date类型的标识符
		System.out.println(s);
		s=String.format("%tr",new Date());
		//%tr是Date类型的标识符，但只有时间
		System.out.println(s);
		s=String.format("%tA,%<tB,%<td",new Date());
		//%tc是Date类型的标识符
		//<表示重复使用前面的参数
		System.out.println(s);
		System.out.println("分割线");
		
		//Calendar是个抽象类不能直接初始化，无法直接调用静态方法
		Calendar cal=Calendar.getInstance();//对静态方法的调用
		cal.set(2019,9,31,14,54);//月份从0开始
		System.out.println(cal.getTime());//取出时间
		long day1=cal.getTimeInMillis();//将时间转化为微秒
		day1+=1000*60*60;//向后移一小时
		cal.setTimeInMillis(day1);
		System.out.println("new hour "+cal.get(cal.HOUR_OF_DAY));//cal.HOUR_OF_DAY表示小时
		cal.add(cal.DATE,35);
		System.out.println(cal.getTime());
		cal.roll(cal.DATE,35);//滚动35天月份不动
		System.out.println(cal.getTime());
		
	}

}
