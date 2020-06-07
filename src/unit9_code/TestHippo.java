package unit9_code;
class Animal
{
	public Animal()
	{
		System.out.println("constructing a Animal");
	}
}
class Hippo extends Animal
{
	public Hippo()
	{
		super();//在子类中调用父类构造函数，没有会自动生成
		System.out.println("constructing a Hippo");
	}
}
//子类构造是一定会执行父类的构造函数
public class TestHippo 
{

	public static void main(String[] args) 
	{
		System.out.println("starting....");
		Hippo h=new Hippo();
	}

}
