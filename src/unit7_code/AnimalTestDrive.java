package unit7_code;

public class AnimalTestDrive 
{
	public static void main(String[] args)
	{
		MyAnimalList list=new MyAnimalList();
		Dog a=new Dog();
		Cat b=new Cat();
		list.add(a);
		list.add(b);
		//虽然list的类型使animal，但是因为Dog和Cat是animal的子类，故可以直接传递，并执行子类的方法，这就是多态
	}

}
