package unit5_code;

public class SimpleDotCom
{
	private int[] loc;//封装，只有通过public方法才能在其他class调用

	public void setLocation(int[] location)
	{
		loc=location;
	}
	public String check(String Strguess)
	{
		String result="miss";
		int guess=Integer.parseInt(Strguess);//将String转化为整数
		for (int i=0;i<3;i++)
		{
			if (guess==loc[i])
			{
				result="hit";
				loc[i]=-1;
				break;
			}
		}
		System.out.println(result);
		return result;
	}
}
//这是一个class，public class使这个类可以在同package的代码中调用