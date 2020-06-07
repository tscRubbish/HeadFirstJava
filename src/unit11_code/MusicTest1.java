package unit11_code;
import javax.sound.midi.*;
import static java.lang.System.out;
public class MusicTest1 
{
	public void play()
	{
		try{
			Sequencer sequencer=MidiSystem.getSequencer();//风险方法，编译器会阻止运行
			System.out.println("we got a sequencer");
		}catch (MidiUnavailableException ex)
		{
			System.out.println("Bummer");
			ex.printStackTrace();
		}finally //表示无论有无异常都执行部分，如果try或catch有return指令，会先执行finally在return
		{
			out.println("Test");
		}
		//try快会告诉编译器知道调用方法有风险，并以准备处理，编译器就会允许执行风险方法
	}
	public static void main(String[] args) 
	{
		MusicTest1 mt=new MusicTest1();
		mt.play();
	}
//异常是一种Exception类型的对象，不是runtimeException的子类的异常统称检查异常（IOE，Interrupted）
	//异常也是多态的
}
