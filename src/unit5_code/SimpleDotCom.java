package unit5_code;

public class SimpleDotCom
{
	private int[] loc;//��װ��ֻ��ͨ��public��������������class����

	public void setLocation(int[] location)
	{
		loc=location;
	}
	public String check(String Strguess)
	{
		String result="miss";
		int guess=Integer.parseInt(Strguess);//��Stringת��Ϊ����
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
//����һ��class��public classʹ����������ͬpackage�Ĵ����е���