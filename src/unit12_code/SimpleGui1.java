package unit12_code;
import javax.swing.*;
import java.awt.*;
public class SimpleGui1 
{
	public static void main(String[] args) 
	{
		JFrame frame=new JFrame();//����JFrame������һ����Ļ�ϵĶ���
		JButton button=new JButton("click me");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ڹر�ʱ������ֹͣ
		
		frame.getContentPane().add(button);//��button�ӵ�frame��pane��

		frame.setSize(300,300);
		
		frame.setVisible(true);
	}
}
