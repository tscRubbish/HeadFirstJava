package unit5_code;
import java.util.Scanner;
public class SimpleDotComTestDrive 
{
	
	public static void main(String[] args) 
	{
		//Scanner in=new Scanner(System.in);
		GameHelper helper=new GameHelper();//这是一个辅助类
		int numOftry=0,numOfhits=0;
		SimpleDotCom dot=new SimpleDotCom();
		int randomNum=(int)(Math.random()*5);
		int[] locations={randomNum+1,randomNum+2,randomNum+3};
		dot.setLocation(locations);
		boolean isAlive=true;
		while (isAlive==true)
		{
			//String userguess=in.next();
			String userguess=helper.getUserInput("enter:");
			String result=dot.check(userguess);
			String testresult="fail";
			numOftry++;
			if (result.equals("hit"))
			{
				testresult="passed";
				numOfhits++;
				if (numOfhits==3)
				isAlive=false;
			}
		}
		System.out.println(numOftry);
	}

}
