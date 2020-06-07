package unit13_code;

import java.awt.*;
import javax.swing.*;
import javax.sound.midi.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;

public class BeatBox 
{
	JFrame frame;
	ArrayList<JCheckBox> checkboxList;
	JPanel panel;
	Sequencer sequencer;
	Sequence sequence;
	Track track;
	String[] instrumentNames={"Bass Drum","Closed Hi-Hat","Open Hi-Hat","Acoustic Snare","Crash Cymbal",
			"Hand Clap","High Tom","Hi Bongo","Maracas","Whistle","Low Conga","Cowbell","Vibraslap",
			"Low-mid Tom","High Adodo","Open Hi Conga"};
	int[] instruments= {355,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};
	public static void main(String[] args) 
	{
		new BeatBox().buildGUI();
	}
	public void buildGUI()
	{
		frame=new JFrame("Cyber BeatBox");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout layout=new BorderLayout();
		JPanel background=new JPanel(layout);
		background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		checkboxList=new ArrayList<JCheckBox>();
		Box buttonBox=new Box(BoxLayout.Y_AXIS);
		
		JButton start=new JButton("Start");
		start.addActionListener(new MyStartListener());
		buttonBox.add(start);
		
		JButton stop=new JButton("Stop");
		stop.addActionListener(new MyStopListener());
		buttonBox.add(stop);
		
		JButton upTempo=new JButton("Tempo up");
		upTempo.addActionListener(new MyUpTempoListener());
		buttonBox.add(upTempo);
		
		JButton downTempo=new JButton("Tempo down");
		downTempo.addActionListener(new MyDownTempoListener());
		buttonBox.add(downTempo);
		
		JButton serial=new JButton("Serializelt");
		serial.addActionListener(new MySendListener());
		buttonBox.add(serial);
		
		JButton restore=new JButton("Restore");
		restore.addActionListener(new MyReadListener());
		buttonBox.add(restore);
		Box nameBox=new Box(BoxLayout.Y_AXIS);
		for (int i=0;i<16;i++)
		{
			nameBox.add(new Label(instrumentNames[i]));
		}
		
		background.add(BorderLayout.EAST,buttonBox);
		background.add(BorderLayout.WEST,nameBox);
		
		frame.getContentPane().add(background);
		
		GridLayout grid=new GridLayout(16,16);
		grid.setVgap(1);//垂直间距
		grid.setHgap(2);//竖直间距
		
		panel=new JPanel(grid);
		background.add(BorderLayout.CENTER,panel);
		
		for (int i=0;i<256;i++)
		{
			JCheckBox c=new JCheckBox();
			c.setSelected(false);
			checkboxList.add(c);
			panel.add(c);
		}
		setUpMidi();
		frame.setBounds(50,50,300,300);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void setUpMidi()
	{
		try
		{
			sequencer=MidiSystem.getSequencer();
			sequencer.open();
			sequence=new Sequence(Sequence.PPQ,4);
			track=sequence.createTrack();
			sequencer.setTempoInBPM(120);
		}catch(Exception ex)
		{
			//ex.printStackTrace();
		}
	}
	public void buildTrackAndStart()
	{
		int[] trackList=null;
		sequence.deleteTrack(track);
		track=sequence.createTrack();
		
		for (int i=0;i<16;i++) 
		{
			trackList=new int[16];
			int key=instruments[i];
			for (int j=0;j<16;j++)
			{
				JCheckBox jc =(JCheckBox)checkboxList.get(j+16*i);
				if (jc.isSelected())
					trackList[j]=key;
				else trackList[j]=0;
			}
			makeTracks(trackList);
			track.add(makeEvent(176,1,127,0,16));
		}
		track.add(makeEvent(176,1,127,0,16));
		try
		{
			sequencer.setSequence(sequence);
			sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);//指定无限重复
			sequencer.start();
			sequencer.setTempoInBPM(120);
		}catch(Exception ex)
		{
			//ex.printStackTrace();
		}
	}
	public void makeTracks(int[] list)
	{
		for (int i=0;i<16;i++)
		{
			int key=list[i];
			if (key!=0)
			{
				track.add(makeEvent(144,9,key,100,i));
				track.add(makeEvent(128,9,key,100,i+1));
			}
		}
	}
	public class MyStartListener implements ActionListener
	{
		public void actionPerformed(ActionEvent a)
		{
			buildTrackAndStart();
		}
	}
	public class MyStopListener implements ActionListener
	{
		public void actionPerformed(ActionEvent a)
		{
			sequencer.stop();
		}
	}
	public class MyUpTempoListener implements ActionListener
	{
		public void actionPerformed(ActionEvent a)
		{
			float tempoFactor=sequencer.getTempoFactor();
			sequencer.setTempoFactor((float)(tempoFactor*1.03));//这里只能用单精度浮点数float
		}
	}
	public class MyDownTempoListener implements ActionListener
	{
		public void actionPerformed(ActionEvent a)
		{
			float tempoFactor=sequencer.getTempoFactor();
			sequencer.setTempoFactor((float)(tempoFactor*0.97));//这里只能用单精度浮点数float
		}
	}
	public class MySendListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			boolean[] checkboxState=new boolean[256];
			for (int i=0;i<256;i++)
			{
				JCheckBox check=(JCheckBox) checkboxList.get(i);
				if (check.isSelected())//取出JCheckBox是否选中
				{
					checkboxState[i]=true;
				}
			}
			try
			{
				FileOutputStream fos=new FileOutputStream(new File("CheckBox.ser"));
				ObjectOutputStream os=new ObjectOutputStream(fos);
				os.writeObject(checkboxState);
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
	public class MyReadListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			boolean[] checkboxState=null;
			try
			{
				FileInputStream fis=new FileInputStream(new File("CheckBox.ser"));
				ObjectInputStream is=new ObjectInputStream(fis);//序列化读取
				checkboxState=(boolean[]) is.readObject();//转换
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
			for (int i=0;i<256;i++)
			{
				JCheckBox check=(JCheckBox) checkboxList.get(i);
				if (checkboxState[i])
					check.setSelected(true);
				else check.setSelected(false);
			}
			sequencer.stop();
			buildTrackAndStart();
		}
	}
	public MidiEvent makeEvent(int comd,int chan,int one,int two,int tick)
	{
		MidiEvent event=null;
		try
		{
			ShortMessage a=new ShortMessage();
			a.setMessage(comd,chan,one,two);
			event=new MidiEvent(a,tick);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return event;
	}
}
