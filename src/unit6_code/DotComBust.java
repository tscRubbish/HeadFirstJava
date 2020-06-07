package unit6_code;
import java.util.*;

import unit6_code.GameHelper;
public class DotComBust 
{
	private GameHelper helper=new GameHelper();
	private ArrayList<dotcom> dotComsList=new ArrayList<dotcom>();
	private int numOfGuess=0;
	private void setUpGame()
	{
		dotcom one=new dotcom();
		one.setname("Pets.com");
		dotcom two=new dotcom();
		two.setname("eToys.com");
		dotcom three=new dotcom();
		three.setname("Go2.com");
		dotComsList.add(one);
		dotComsList.add(two);
		dotComsList.add(three);
		
		System.out.println("Your goal is to sink three dot coms.");
		System.out.println("pets.com,eToys.com,Go2.com");
		System.out.println("Try to sink them in the fewest number of guesses");
		
		for (dotcom dotcomset : dotComsList)
		{
			ArrayList<String> newlocation=helper.placeDotCom(3);
			//for (String ddd:newlocation)
				//System.out.println(ddd);
			dotcomset.setlocation(newlocation);
		}
	}
	private void startPlaying()
	{
		while (!dotComsList.isEmpty())
		{
			String userguess=helper.getUserInput("Enter a guess");
			checkUserGuess(userguess);
		}
		finishGame();
	}
	private void checkUserGuess(String userguess)
	{
		numOfGuess++;
		String result="miss";
		for (dotcom dotcomTest : dotComsList)
		{
			result=dotcomTest.check(userguess);
			if (result.equals("hits")) break;
			if (result.equals("kill"))
			{
				dotComsList.remove(dotcomTest);
				break;
			}
		}
		System.out.println(result);
	}
	private void finishGame()
	{
		System.out.println("All dot coms are dead!");
		System.out.println("numOfGuess = "+numOfGuess);
	}
	public static void main(String[] args) 
	{
		DotComBust game=new DotComBust();
		game.setUpGame();
		game.startPlaying();
	}

}
