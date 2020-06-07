package unit14_code;

import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

public class QuizCardPlayer 
{
	private JFrame frame;
	private JTextArea display;
	private JTextArea answer;
	private JButton nextButton;
	private boolean isShowAnswer;
	private ArrayList<QuizCard>cardList;
	private QuizCard currentCard;
	private int currentCardIndex;
	public static void main(String[] args) 
	{
		QuizCardPlayer gui=new QuizCardPlayer();
		gui.go();
	}
	public void go()
	{
		frame=new JFrame("Quiz Card Player");
		JPanel mainPanel=new JPanel();
		Font bigFont=new Font("sanserif",Font.BOLD,24);
		
		display=new JTextArea(10,20);
		display.setFont(bigFont);
		display.setLineWrap(true);
		display.setEditable(true);
		
		JScrollPane qScroller=new JScrollPane(display);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		nextButton=new JButton("Show question");
		mainPanel.add(qScroller);
		mainPanel.add(nextButton);
		nextButton.addActionListener(new NextCardListener());
		
		JMenuBar menuBar=new JMenuBar();
		JMenu fileMenu=new JMenu("File");
		JMenuItem loadMenuItem=new JMenuItem("Load card set");
		loadMenuItem.addActionListener(new OpenMenuListener());
		fileMenu.add(loadMenuItem);
		menuBar.add(fileMenu);
		frame.setJMenuBar(menuBar);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
		frame.setSize(640,500);
		frame.setVisible(true);
	}
	public class NextCardListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if (isShowAnswer)
			{
				display.setText(currentCard.getAnswer());
				nextButton.setText("Next Card");
				isShowAnswer=false;
			}
			else 
			{
				if (currentCardIndex<cardList.size())
				{
					showNextCard();
				}
				else 
				{
					display.setText("That's no card");
					nextButton.setEnabled(false);
				}
			}
		}
	}
	public class OpenMenuListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			nextButton.setEnabled(true);
			currentCardIndex=0;
			isShowAnswer=false;
			JFileChooser fileOpen=new JFileChooser();
			fileOpen.showOpenDialog(frame);
			loadFile(fileOpen.getSelectedFile());
		}
	}
	private void loadFile(File file)
	{
		cardList=new ArrayList<QuizCard>();
		try
		{
			BufferedReader reader=new BufferedReader(new FileReader(file));
			String line=null;
			while ((line=reader.readLine())!=null)
				makeCard(line);
			reader.close();
		}catch(Exception ex)
		{
			System.out.println("Couldn't read the card file");
			ex.printStackTrace();
		}
	}
	private void makeCard(String line)
	{
		String[] result=line.split("/");//split以“/"为分割符，拆开成String的数组
		QuizCard card=new QuizCard(result[0],result[1]);
		cardList.add(card);
		System.out.println("made a card");
	}
	private void showNextCard()
	{
		currentCard=cardList.get(currentCardIndex);
		currentCardIndex++;
		display.setText(currentCard.getQuestion());
		nextButton.setText("Show Answer");
		isShowAnswer=true;
	}
}
