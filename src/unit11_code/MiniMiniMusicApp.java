package unit11_code;
import javax.sound.midi.*;
public class MiniMiniMusicApp 
{

	public static void main(String[] args) 
	{
		MiniMiniMusicApp mini=new MiniMiniMusicApp();
		mini.play();
	}
	public void play()
	{
		try 
		{
			Sequencer player=MidiSystem.getSequencer();//ȡ��sequencer����
			player.open();
			
			Sequence seq=new Sequence(Sequence.PPQ,4);
			
			Track track=seq.createTrack();//ȡ��track
			
			ShortMessage a=new ShortMessage();
			a.setMessage(144,1,44,100);//�ֱ�Ϊ���ͣ�Ƶ����������0~127��������
			MidiEvent noteOn=new MidiEvent(a,1);
			track.add(noteOn);
			//Message��ִ�����ݣ�MidiEvent��ִ��ʱ��
			
			ShortMessage b=new ShortMessage();
			b.setMessage(128,1,44,100);
			MidiEvent noteoff=new MidiEvent(b,1000);//����
			track.add(noteoff);
			
			player.setSequence(seq);
			
			player.start();
		}catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
