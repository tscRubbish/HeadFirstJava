package unit3_code;

class Dog
{
	String name;
	void bark()
	{
		System.out.println(name+" is barking");
	}
}
public class data_and_using 
{

	public static void main(String[] args) 
	{
		Dog a=new Dog();
		Dog b=new Dog();
		Dog c=new Dog();
		a.name="1";b.name="2";
		c=a;a=b;b=c;//�������Ը�ֵ��������ֵ�ǵ�ַ��ң������
		//����a=b����ʱ�ı�aҲ��ı�b����Ϊaָ��b����ĵ�ַ
		a.bark();b.bark();
		c=null;
		Dog[] pets=new Dog[3];
		pets[0]=new Dog();
		//һ�����ͱ�������ֻ��װ���Ӧ���͵�Ԫ��
		pets[1]=a;pets[2]=b;
		pets[0].name="kirito";
		int x=0;
		while (x<pets.length)
		{
			pets[x].bark();
			x=x+1;
		}
	}

}
