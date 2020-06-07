package unit15_code;

public class RunThreads implements Runnable
{
	public static void main(String[] args) 
	{
		RunThreads runner=new RunThreads();
		Thread a=new Thread(runner);
		Thread b=new Thread(runner);
		a.setName("A Thread");//给线程取名
		b.setName("B Thread");
		a.start();
		b.start();
	}
	public void run()
	{
		for (int i=0;i<25;i++)
		{
			String threadName=Thread.currentThread().getName();
			System.out.println(threadName);
			
		}
	}
}
