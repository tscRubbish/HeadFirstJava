package unit15_code;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleChatClientA 
{
	PrintWriter writer;
	JTextArea outgoing;
	Socket sock;
	public static void main(String[] args) 
	{
		new SimpleChatClientA().go();
	}
	public void go()
	{
		JFrame frame=new JFrame("Ludicrously Simple Chat Client");
		JPanel mainPanel=new JPanel();
		outgoing=new JTextArea(10,20);
		JButton sendButton=new JButton("send");
		sendButton.addActionListener(new SendButtonListener());
		mainPanel.add(outgoing);
		mainPanel.add(sendButton);
		frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
		setUpNetworking();
		frame.setSize(300,300);
		frame.setVisible(true);
	}
	private void setUpNetworking()
	{
		try
		{
			sock=new Socket("127.0.0.1",5000);
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
				writer.flush();
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
			outgoing.setText("");
			outgoing.requestFocus();
		}
	}
}
