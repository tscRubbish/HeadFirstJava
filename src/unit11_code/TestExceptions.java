package unit11_code;

class ScaryException extends Exception
{
	public ScaryException()
	{
		super();
	}
}
public class TestExceptions 
{
	public static void main(String[] args) 
	{
		//Scanner in=new Scanner(System.in);
		String test="yes";
		try 
		{
			System.out.println("start try");
			dorisky(test);
			System.out.println("ecd a try");
		}catch(ScaryException se)
		{
			System.out.println("scary exception");
			se.printStackTrace();
		}finally
		{
			System.out.println("finally");
		}
	}
	static void dorisky(String test) throws ScaryException
	{
		System.out.println("start risky");
		if ("yes".equals(test))
		{
			throw new ScaryException();
		}
		System.out.println("end risky");
		return;
	}
}
