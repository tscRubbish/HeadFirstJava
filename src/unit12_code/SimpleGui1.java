package unit12_code;
import javax.swing.*;
import java.awt.*;
public class SimpleGui1 
{
	public static void main(String[] args) 
	{
		JFrame frame=new JFrame();//创建JFrame，这是一个屏幕上的对象
		JButton button=new JButton("click me");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗口关闭时，程序停止
		
		frame.getContentPane().add(button);//把button加到frame的pane上

		frame.setSize(300,300);
		
		frame.setVisible(true);
	}
}
