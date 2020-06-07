package unit1_code;

public class PhraseMatic 
{

	public static void main(String[] args) 
	{
		String[] wordListOne={"24/7","muti-Tier","win-win","six-signma","dynamic"};
		String[] wordListTwo={"empowered","sticky","value-added","oriented","centric"};
		String[] wordListThree={"process","tipping-point","solution","portal"};
		int Length1=wordListOne.length;//求字符串数组的长度
		int Length2=wordListTwo.length;
		int Length3=wordListThree.length;
		int rand1=(int)(Math.random()*Length1);
		int rand2=(int)(Math.random()*Length2);
		int rand3=(int)(Math.random()*Length3);
		String phrase=wordListOne[rand1]+" "+wordListTwo[rand2]+" "+wordListThree[rand3];
		System.out.println(phrase);
	}

}
