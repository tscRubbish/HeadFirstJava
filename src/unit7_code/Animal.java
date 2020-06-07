package unit7_code;

abstract public class Animal //抽像类，无法被初始化，除了被继承外，没有用途，没有值
{
	public void sleep(){}
	public void roam(){}
	public abstract void eat();
	//抽象的方法无实体，可直接以分号结束
	//申明一个抽象方法，类也必须抽象
}
class Dog extends Animal implements pet//接口，pet也成为了一个父类，但必须是interface类型
{
	public void beFriendly(){}
	public void play(){}
	//因为interface的方法是抽象的，故必须覆盖
	public void eat(){} 
	public void bark()
	{
		System.out.println("Dog is barking");
		super.sleep();//super调用父类方法
	}
}
class Cat extends Animal
{
	public void eat(){}
}