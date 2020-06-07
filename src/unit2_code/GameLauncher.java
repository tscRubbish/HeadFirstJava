package unit2_code;

import java.util.Scanner;

class GuessGame
{
	Player p1;
	Player p2;
	Player p3;
	public void startGame()
	{
		p1=new Player();
		p2=new Player();
		p3=new Player();
		System.out.println("Play 1 's name is:");
		Scanner in=new Scanner(System.in);
		p1.name=in.next();
		System.out.println("Play 2 's name is:");
		p2.name=in.next();
		System.out.println("Play 3 's name is:");
		p3.name=in.next();
		int guessp1=0;
		int guessp2=0;
		int guessp3=0;
		boolean p1right=false;
		boolean p2right=false;
		boolean p3right=false;
		int targetnumber=(int)(Math.random()*10);
		System.out.println("target number=" + targetnumber);
		while (true)
		{
			p1.guess();
			p2.guess();
			p3.guess();
		
			System.out.println("Player 1 guess:"+p1.number);
			System.out.println("Player 2 guess:"+p2.number);
			System.out.println("Player 3 guess:"+p3.number);
			if (p1.number==targetnumber) p1right=true;
			if (p2.number==targetnumber) p2right=true;
			if (p3.number==targetnumber) p3right=true;
			if (p1right||p2right||p3right)
			{
				System.out.println("We have a winner");
				if (p1right) System.out.println(p1.name+" is winner");
				if (p2right) System.out.println(p2.name+" is winner");
				if (p3right) System.out.println(p3.name+" is winner");
				break;
			}
			else System.out.println("try again");
		}
	}
}
class Player
{
	int number=0;
	String name;
	void guess()
	{
		number=(int)(Math.random()*10);
		System.out.println("is guessing :"+ number);
	}
}
public class GameLauncher 
{

	public static void main(String[] args) 
	{
		GuessGame game=new GuessGame();
		game.startGame();
	}

}
