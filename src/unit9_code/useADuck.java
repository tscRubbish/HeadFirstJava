package unit9_code;

class Duck
{
	private int size;
	public Duck()//����Ҫ���ݲ����Ĺ��캯�����������Duck()Ϊ���ع�ϵ
	{
		System.out.println("Quack");
		size=27;
		System.out.println("Size is 27");
	}
	//����в��������Ĺ��캯��������ʹ��Ĭ��ֵ
	public Duck(int ducksize)//���캯���޷���ֵ�����ڶѿ�һ���ڴ�(���Դ�����)
	{
		System.out.println("Quack");
		
		if (ducksize==0) size=27;
		else
			size=ducksize;
		//���û��ָ��size��Ĭ��ֵ
		System.out.println("Size is "+size);
	}
	//���ã�1.��ʼ����2.����ͨ�����봴������3.���๹�캯��
	//���캯�����ᱻ�̳�
	//�����һ�����ϵĹ��캯��������һ��Ҫ��һ��
	public void setSize(int newsize)
	{
		size=newsize;
	}
}
public class useADuck 
{

	public static void main(String[] args) 
	{
		Duck d=new Duck(42);//����ƽʱ��ʼ��������ʵDuck()��һ�����캯���������Լ���д
		d.setSize(42);
		Duck d2=new Duck(0);
		Duck d3=new Duck();
	}

}
