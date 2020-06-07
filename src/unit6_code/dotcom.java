package unit6_code;

import java.util.ArrayList;
import java.util.*;

public class dotcom 
{
	private ArrayList<String> loc;//java的ArrayList库
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
		int index=loc.indexOf(userInput);//返回该元素的下标
		if (index>=0) 
		{
			loc.remove(index);//删除下标为index的库
			if (loc.isEmpty())//若为空则返回true
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
//loc.add()加入元素
//loc.contains()如果与对象参数匹配则为true
//loc.size()返回元素个数
//loc.get(index)返回对应位置的值