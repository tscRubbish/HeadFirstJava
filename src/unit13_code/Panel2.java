package unit13_code;
import javax.swing.*;
import java.awt.*;
public class Panel2 
{

	public static void main(String[] args) 
	{
		Panel2 gui=new Panel2();
		gui.go();
	}
	public void go()
	{
		JFrame frame=new JFrame();
		JPanel panel=new JPanel();
		panel.setBackground(Color.darkGray);
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));//ת����BoxLayout����2�������ֱ�Ϊ����������ʹ�õ���
		
		JButton button=new JButton("Shock me");
		JButton button2=new JButton("Bliss");
		panel.add(button);
		panel.add(button2);
		frame.getContentPane().add(BorderLayout.EAST,panel);
		frame.setSize(500,500);
		frame.setVisible(true);
	}
}
