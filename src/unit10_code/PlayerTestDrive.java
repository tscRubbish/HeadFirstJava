package unit10_code;

class Player
{
	static int playerCount=0;
	private String name;
	public Player(String s)
	{
		name=s;
		playerCount++;
	}
}
public class PlayerTestDrive 
{

	public static void main(String[] args) 
	{
		System.out.println(Player.playerCount);
		Player one=new Player("Tiger Woods");
		System.out.println(Player.playerCount);
		//静态变量可通过类名称来调用
	}

}
//静态变量会在类任何静态方法前初始化