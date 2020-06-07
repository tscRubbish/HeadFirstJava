package unit10_code;

public class Testbox 
{
	Integer i;
	int j;
	public static void main(String[] args)
	{
		Testbox t=new Testbox();
		t.go();
	}
	public void go()
	{
		//j=i;´íÎóµÄautoboxing
		System.out.println(j);
		System.out.println(i);
	}
}
