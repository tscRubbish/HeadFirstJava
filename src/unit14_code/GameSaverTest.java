package unit14_code;

import java.io.*;

public class GameSaverTest 
{
	public static void main(String[] args) 
	{
		GameCharacter one=new GameCharacter(50,"Elf",new String[]{"bow","sword","dust"});
		GameCharacter two=new GameCharacter(200,"Troll",new String[]{"bare hands","big ax"});
		GameCharacter three=new GameCharacter(120,"Magician",new String[]{"spells","invisiblity"});
		
		try
		{
			FileOutputStream fs=new FileOutputStream("Game.ser");//这里是Output
			ObjectOutputStream os=new ObjectOutputStream(fs);
			os.writeObject(one);
			one.cnt--;
			os.writeObject(two);
			os.writeObject(three);
			os.close();
		}catch(Exception ex){ex.printStackTrace();}
		one=null;
		two=null;
		three=null;//是其无法访问
		
		try
		{
			FileInputStream Fs=new FileInputStream("Game.ser");//这里是Input
			ObjectInputStream is=new ObjectInputStream(Fs);
			GameCharacter oneRestore=(GameCharacter)is.readObject();
			GameCharacter twoRestore=(GameCharacter)is.readObject();
			GameCharacter threeRestore=(GameCharacter)is.readObject();
			System.out.println("one'type is"+oneRestore.getType());
			System.out.println("two'type is"+twoRestore.getType());
			System.out.println("three'type is"+threeRestore.getType());
			System.out.println(oneRestore.cnt);//静态变量是一类一个，不会是存储时的值，而是在类中原本的值
			is.close();
		}catch(Exception ex) {ex.printStackTrace();}
	}

}
