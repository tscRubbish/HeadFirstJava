package unit7_code;
import java.util.*;
public class SomeAboutObject 
{

	public static void main(String[] args) 
	{
		ArrayList<Object> myDogArrayList=new ArrayList<Object>();
		Dog aDog=new Dog();
		myDogArrayList.add(aDog);
		Object o=myDogArrayList.get(0);//�κδ�Array<Object>ȡ���Ķ�����������Object�����ã�����ԭ����ʲô
		if (o instanceof Dog)//instanceof�������飬���ת�����������ֹ����
		{
			Dog d=(Dog) o;//��objectת��ΪDog
			d.bark();
		}
	}

}
