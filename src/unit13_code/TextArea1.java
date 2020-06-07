package unit13_code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextArea1 implements ActionListener
{
	JTextArea text;
	public static void main(String[] args) 
	{
		TextArea1 gui=new TextArea1();
		gui.go();
	}
	public void go()
	{
		JFrame frame=new JFrame();
		JPanel panel=new JPanel();
		JButton button=new JButton("click me");
		button.addActionListener(this);
		text=new JTextArea(10,20);
		text.setLineWrap(true);//�����Զ�����
		
		JScrollPane scroller=new JScrollPane(text);//��text�����µ�JScrollPane
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		//�涨ֻ�ô�ֱ����
		
		panel.add(scroller);
		
		frame.getContentPane().add(BorderLayout.CENTER,panel);
		frame.getContentPane().add(BorderLayout.SOUTH,button);
		frame.setSize(350,300);
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent event)
	{
		text.append("button clicked\n");//���ı������
	}
}
