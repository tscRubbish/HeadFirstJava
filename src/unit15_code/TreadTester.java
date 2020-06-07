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
			Thread.sleep(2000);//延迟2s
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
		Runnable threadJob=new MyRunnable();//Runnable是线程的任务
		Thread myThread=new Thread(threadJob);	//Thread对象是线程执行对象，Runnable中的run会赋予Tread任务
		myThread.start();
		System.out.println("back in main");
	}
//线程的执行会在2种状态反复交换执行，而且在不同机器上会有不同结果
}
