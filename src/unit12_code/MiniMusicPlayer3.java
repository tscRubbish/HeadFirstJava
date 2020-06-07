package unit12_code;

import javax.sound.midi.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class MiniMusicPlayer3 
{
	static JFrame frame=new JFrame("My first Music Vedio");
	static MydrawPanel draw;
	public static void main(String[] args) 
	{
		MiniMusicPlayer3 mini=new MiniMusicPlayer3();
		mini.go();
	}
	public void setUpGui()
	{
		draw=new MydrawPanel();
		frame.setContentPane(draw);
		frame.setBounds(30,30,300,300);//setBounds(int left, int top, int right, int bottom),这个四参数指的是drawable将在被绘制在canvas的哪个矩形区域内。
		frame.setVisible(true);
	}
	public void go()
	{
		setUpGui();
		try
		{
			Sequencer sequencer=MidiSystem.getSequencer();
			sequencer.open();
			
			int[] eventsIWant= {127};
			sequencer.addControllerEventListener(draw,eventsIWant);
			
			Sequence seq=new Sequence(Sequence.PPQ,4);
			Track track=seq.createTrack();
			
			for (int i=5;i<101;i+=4)
			{
				track.add(makeEvent(144,1,i,100,i));
				track.add(makeEvent(176,1,127,0,i));
				track.add(makeEvent(128,1,i,100,i+2));
			}
			
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(220);
			sequencer.start();
		}catch(Exception ex) {}
	}
	public static MidiEvent makeEvent(int comd,int chan,int one,int two,int tick)
	{
		MidiEvent event=null;
		try
		{
			ShortMessage a=new ShortMessage();
			a.setMessage(comd,chan,one,two);
			event=new MidiEvent(a,tick);
		}catch(Exception e){}
		return event;
	}
	class MydrawPanel extends JPanel implements ControllerEventListener
	{
		boolean flag=false;
		public void controlChange(ShortMessage event)
		{
			flag=true;
			repaint();
		}
		public void paintComponent(Graphics g)
		{
			if (flag)
			{
				Graphics2D g2=(Graphics2D) g;
				
				int red=(int)(Math.random()*255);
				int green=(int)(Math.random()*255);
				int blue=(int)(Math.random()*255);
				
				g.setColor(new Color(red,green,blue));
				
				int ht=(int)(Math.random()*120)+10;
				int width=(int)(Math.random()*120)+10;
				int x=(int)(Math.random()*40)+10;
				int y=(int)(Math.random()*40)+10;
				
				g.fillRect(x,y,ht,width);
				flag=false;
			}
		}
	}
}
