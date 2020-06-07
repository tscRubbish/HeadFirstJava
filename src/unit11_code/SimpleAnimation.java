package unit11_code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;

public class SimpleAnimation implements ActionListener
{
	int x=0;
	int y=0;
	JFrame frame;
	MyDrawPanel2 drawPanel; 
	public static void main(String[] args) 
	{
		SimpleAnimation gui=new SimpleAnimation();
		gui.go();
	}
	public void go()
	{
		frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button=new JButton("Start");
		button.addActionListener(this);
		
		drawPanel=new MyDrawPanel2();
		frame.getContentPane().add(BorderLayout.SOUTH,button);
		frame.getContentPane().add(drawPanel);
		
		frame.setSize(2000,2000);
		frame.setVisible(true);
		frame.repaint();
	}
	public void actionPerformed(ActionEvent event)
	{
	new Thread() //线程
	{
		public void run()
		{
			for (int i=0;i<130;i++)
			{
				//System.out.println(i);
				x++;y++;
				//System.out.println(x+" "+y);
				frame.repaint();//多个连续repaint会合成一次，所以用线程(不要相信headfirstjava书上的代码)
				try
				{
					Thread.sleep(50);//设置延迟，防止一瞬间完成动画
				}catch (Exception ex){}
			}
		}
		//System.out.println(cnt);
	}.start();
	}
	class MyDrawPanel2 extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			//cnt++;
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			
			Image image=new ImageIcon("C:\\Users\\hp\\workspace\\headjava\\bin\\unit12_code\\kirito.jpg").getImage();
			//g.setColor(Color.green);
			//g.fillOval(x, y, 40, 40);
			g.drawImage(image,x,y,this);
		}
	}
}
