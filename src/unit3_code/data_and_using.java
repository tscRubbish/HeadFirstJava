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
		c=a;a=b;b=c;//对象间可以赋值，但赋的值是地址”遥控器“
		//假如a=b，此时改变a也会改变b，因为a指向b对象的地址
		a.bark();b.bark();
		c=null;
		Dog[] pets=new Dog[3];
		pets[0]=new Dog();
		//一旦类型被声明就只能装入对应类型的元素
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
