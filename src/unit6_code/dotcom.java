package unit6_code;

import java.util.ArrayList;
import java.util.*;

public class dotcom 
{
	private ArrayList<String> loc;//java��ArrayList��
	private String name;

	public void setlocation(ArrayList<String> location)
	{
		loc=location;
	}
	public void setname(String s)
	{
		name=s;
	}
	public String check(String userInput)
	{
		String result="miss";
		int index=loc.indexOf(userInput);//���ظ�Ԫ�ص��±�
		if (index>=0) 
		{
			loc.remove(index);//ɾ���±�Ϊindex�Ŀ�
			if (loc.isEmpty())//��Ϊ���򷵻�true
			{
				result="kill";
				System.out.println("oh!you sunk "+name+" :(");
			}
			else 
			{
				result="hit";
			}
		}
		return result;
	}
}
//loc.add()����Ԫ��
//loc.contains()�����������ƥ����Ϊtrue
//loc.size()����Ԫ�ظ���
//loc.get(index)���ض�Ӧλ�õ�ֵ