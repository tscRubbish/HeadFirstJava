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
			Sequencer player=MidiSystem.getSequencer();//取得sequencer并打开
			player.open();
			
			Sequence seq=new Sequence(Sequence.PPQ,4);
			
			Track track=seq.createTrack();//取得track
			
			ShortMessage a=new ShortMessage();
			a.setMessage(144,1,44,100);//分别为类型，频道，音符（0~127），音道
			MidiEvent noteOn=new MidiEvent(a,1);
			track.add(noteOn);
			//Message是执行内容，MidiEvent是执行时机
			
			ShortMessage b=new ShortMessage();
			b.setMessage(128,1,44,100);
			MidiEvent noteoff=new MidiEvent(b,1000);//音长
			track.add(noteoff);
			
			player.setSequence(seq);
			
			player.start();
		}catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
