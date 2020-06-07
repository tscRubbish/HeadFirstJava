package unit15_code;

import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleChatClient 
{
	JTextArea incoming;
	JTextArea outgoing;
	BufferedReader reader;
	PrintWriter writer;
	Socket sock;
	public static void main(String[] args) 
	{
		SimpleChatClient gui=new SimpleChatClient();
		gui.go();
	}
	public void go()
	{
		JFrame frame=new JFrame("Simple Chat Client");
		JPanel mainPanel=new JPanel();
		Font bigFont=new Font("sanserif",Font.BOLD,24);
		incoming=new JTextArea(10,30);
		incoming.setLineWrap(true);
		incoming.setWrapStyleWord(true);
		incoming.setEditable(false);
		//incoming.setFont(bigFont);//导入字体
		
		JScrollPane qScroller=new JScrollPane(incoming);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		outgoing=new JTextArea(10,30);
		outgoing.setLineWrap(true);
		outgoing.setWrapStyleWord(true);
		outgoing.setEditable(true);
		//outgoing.setFont(bigFont);
		JScrollPane aScroller=new JScrollPane(outgoing);
		aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton sendButton=new JButton("Send");
		sendButton.addActionListener(new SendButtonListener());
		mainPanel.add(qScroller);
		mainPanel.add(aScroller);
		mainPanel.add(sendButton);
		setUpNetworking();
		
		Thread readerThread=new Thread(new IncomingReader());
		readerThread.start();
		
		frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
		frame.setSize(400,500);
		frame.setVisible(true);
	}
	private void setUpNetworking()
	{
		try
		{
			sock=new Socket("127.0.0.1",5000);
			InputStreamReader streamReader=new InputStreamReader(sock.getInputStream());
			reader=new BufferedReader(streamReader);
			writer=new PrintWriter(sock.getOutputStream());
			System.out.println("networking established");
		}catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
	public class SendButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
				writer.println(outgoing.getText());
				writer.flush();//清空缓存区，缓存区在隔壁
			}catch (Exception ex)
			{
				ex.printStackTrace();
			}
			outgoing.setText("");
			outgoing.requestFocus();
		}
	}
	public class IncomingReader implements Runnable
	{
		public void run()
		{
			String message=null;
			try
			{
				while ((message=reader.readLine())!=null)
				{
					System.out.println("read "+message);
					incoming.append(message+"\n");
				}
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
