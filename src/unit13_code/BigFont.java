package unit13_code;
import javax.swing.*;
import java.awt.*;
public class BigFont 
{

	public static void main(String[] args) 
	{
		JFrame frame=new JFrame();
		JButton button=new JButton("Click This!");
		Font bigFont=new Font("serif",Font.BOLD,28);//将字体变大
		button.setFont(bigFont);
		frame.getContentPane().add(BorderLayout.NORTH,button);
		//字体变大后，按钮高度增加
		frame.setSize(500,500);
		frame.setVisible(true);
	}

}
