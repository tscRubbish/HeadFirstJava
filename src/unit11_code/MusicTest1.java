package unit11_code;
import javax.sound.midi.*;
import static java.lang.System.out;
public class MusicTest1 
{
	public void play()
	{
		try{
			Sequencer sequencer=MidiSystem.getSequencer();//���շ���������������ֹ����
			System.out.println("we got a sequencer");
		}catch (MidiUnavailableException ex)
		{
			System.out.println("Bummer");
			ex.printStackTrace();
		}finally //��ʾ���������쳣��ִ�в��֣����try��catch��returnָ�����ִ��finally��return
		{
			out.println("Test");
		}
		//try�����߱�����֪�����÷����з��գ�����׼�������������ͻ�����ִ�з��շ���
	}
	public static void main(String[] args) 
	{
		MusicTest1 mt=new MusicTest1();
		mt.play();
	}
//�쳣��һ��Exception���͵Ķ��󣬲���runtimeException��������쳣ͳ�Ƽ���쳣��IOE��Interrupted��
	//�쳣Ҳ�Ƕ�̬��
}
