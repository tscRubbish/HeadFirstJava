package unit15_code;

class MyRunnable implements Runnable
{
	public void run()
	{
		go();
	}
	public void go()
	{
		try
		{
			Thread.sleep(2000);//�ӳ�2s
		}catch(InterruptedException ex)
		{
			ex.printStackTrace();
		}
		doMore();
	}
	public void doMore()
	{
		System.out.println("top'o the stack");
	}
}
public class TreadTester 
{
	public static void main(String[] args)
	{
		Runnable threadJob=new MyRunnable();//Runnable���̵߳�����
		Thread myThread=new Thread(threadJob);	//Thread�������߳�ִ�ж���Runnable�е�run�ḳ��Tread����
		myThread.start();
		System.out.println("back in main");
	}
//�̵߳�ִ�л���2��״̬��������ִ�У������ڲ�ͬ�����ϻ��в�ͬ���
}
