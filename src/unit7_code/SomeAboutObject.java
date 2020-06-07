package unit7_code;
import java.util.*;
public class SomeAboutObject 
{

	public static void main(String[] args) 
	{
		ArrayList<Object> myDogArrayList=new ArrayList<Object>();
		Dog aDog=new Dog();
		myDogArrayList.add(aDog);
		Object o=myDogArrayList.get(0);//任何从Array<Object>取出的东西都被当作Object的引用，不管原来是什么
		if (o instanceof Dog)//instanceof运算符检查，如果转化错误则会中止程序
		{
			Dog d=(Dog) o;//将object转化为Dog
			d.bark();
		}
	}

}
