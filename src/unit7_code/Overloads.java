package unit7_code;

public class Overloads 
{
	String uniqueID;
	public int addNums(int a,int b)
	{
		return a+b;
	}
	public double addNums(double a,double b)
	{
		return a+b;
	}
	//重载同名方法，要求：参数不同
	public void setUniqueID(String theID)
	{
		uniqueID=theID;
	}
	public void setUniqueID(int ssNumber)
	{
		String numString=""+String.valueOf(ssNumber);//String numString=""+ssNumber;
		setUniqueID(numString);
	}
}
