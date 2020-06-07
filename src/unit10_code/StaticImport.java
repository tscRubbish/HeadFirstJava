package unit10_code;
import static java.lang.System.out;
import static java.lang.Math.*;
public class StaticImport 
{

	public static void main(String[] args) 
	{
		out.println("sqrt="+sqrt(2.0));
		out.println("tan="+tan(60));
		//静态的import，可以不用类名称调用，也就是少打一点字
	}

}
