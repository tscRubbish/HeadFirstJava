package unit7_code;

abstract public class Animal //�����࣬�޷�����ʼ�������˱��̳��⣬û����;��û��ֵ
{
	public void sleep(){}
	public void roam(){}
	public abstract void eat();
	//����ķ�����ʵ�壬��ֱ���ԷֺŽ���
	//����һ�����󷽷�����Ҳ�������
}
class Dog extends Animal implements pet//�ӿڣ�petҲ��Ϊ��һ�����࣬��������interface����
{
	public void beFriendly(){}
	public void play(){}
	//��Ϊinterface�ķ����ǳ���ģ��ʱ��븲��
	public void eat(){} 
	public void bark()
	{
		System.out.println("Dog is barking");
		super.sleep();//super���ø��෽��
	}
}
class Cat extends Animal
{
	public void eat(){}
}