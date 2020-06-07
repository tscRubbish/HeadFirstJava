package unit14_code;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;
public class QuizCardBuilder 
{
	private JFrame frame;
	private JTextArea question;
	private JTextArea answer;
	private ArrayList<QuizCard> cardList;
	public static void main(String[] args) 
	{
		QuizCardBuilder gui=new QuizCardBuilder();
		gui.go();
	}
	public void go()
	{
		frame=new JFrame("Quiz Card Builder");
		JPanel mainPanel=new JPanel();
		Font bigFont=new Font("sanserif",Font.BOLD,24);
		question=new JTextArea(6,20);
		question.setLineWrap(true);//setLineWrap(true)方法为开启自动换行
		question.setWrapStyleWord(true);//setWrapStyleWord：设置在单词过长的时候是否要把长单词移到下一行。
		question.setFont(bigFont);//导入字体
		
		JScrollPane qScroller=new JScrollPane(question);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		answer=new JTextArea(6,20);
		answer.setLineWrap(true);
		answer.setWrapStyleWord(true);
		answer.setFont(bigFont);
		
		JScrollPane aScroller=new JScrollPane(answer);
		aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton nextButton=new JButton("Next Card");
		
		cardList=new ArrayList<QuizCard>();
		JLabel qLabel=new JLabel("Question:");
		JLabel aLabel=new JLabel("Answer:");
		
		mainPanel.add(qLabel);
		mainPanel.add(qScroller);
		mainPanel.add(aLabel);
		mainPanel.add(aScroller);
		mainPanel.add(nextButton);
		nextButton.addActionListener(new NextCardListener());
		
		JMenuBar menuBar=new JMenuBar();//菜单栏
		JMenu fileMenu=new JMenu("File");
		JMenuItem newMenuItem=new JMenuItem("New");//菜单里的选项
		JMenuItem saveMenuItem=new JMenuItem("Save");
		newMenuItem.addActionListener(new NewMenuListener());
		saveMenuItem.addActionListener(new SaveMenuListener());
		
		fileMenu.add(newMenuItem);
		fileMenu.add(saveMenuItem);
		menuBar.add(fileMenu);
		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
		frame.setSize(500,600);
		frame.setVisible(true);
	}
	public class NextCardListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			QuizCard card=new QuizCard(question.getText(),answer.getText());
			cardList.add(card);
			clearCard();
		}
	}
	public class SaveMenuListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			QuizCard card=new QuizCard(question.getText(),answer.getText());
			cardList.add(card);
			
			JFileChooser fileSave=new JFileChooser();
			fileSave.showSaveDialog(frame);
			saveFile(fileSave.getSelectedFile());
		}
	}
	public class NewMenuListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			cardList.clear();
			clearCard();
		}
	}
	private void clearCard()
	{
		question.setText("");
		answer.setText("");
		question.requestFocus();
	}
	private void saveFile(File file)
	{
		try
		{
			BufferedWriter writer=new BufferedWriter(new FileWriter(file));
			//BufferedWriter缓冲区，磁盘操作耗时比内存操作更多，所以先存入缓冲区在一并写入FileWriter效率更高
			//强制写入FileWriter：writer.flush();
			for (QuizCard card:cardList)
			{
				writer.write(card.getQuestion()+"/");
				writer.write(card.getAnswer()+"\n");
			}
			writer.close();
		}catch(IOException ex)
		{
			System.out.println("Could't write the cardList out");
			ex.printStackTrace();
		}
	}
}
