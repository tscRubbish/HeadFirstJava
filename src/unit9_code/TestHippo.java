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
		super();//�������е��ø��๹�캯����û�л��Զ�����
		System.out.println("constructing a Hippo");
	}
}
//���๹����һ����ִ�и���Ĺ��캯��
public class TestHippo 
{

	public static void main(String[] args) 
	{
		System.out.println("starting....");
		Hippo h=new Hippo();
	}

}
