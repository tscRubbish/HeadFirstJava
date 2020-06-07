package unit12_code;
import javax.swing.*;
import java.awt.event.*;

public class SimpleGui1B implements ActionListener 
{
	JButton button;
	public static void main(String[] args) 
	{
		SimpleGui1B gui=new SimpleGui1B();
		gui.go();
	}
	public void go()
	{
		JFrame frame=new JFrame();
		button=new JButton("click me");
		
		button.addActionListener(this);//向按钮注册
		
		frame.getContentPane().add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent event)//
	{
		button.setText("I've been clicked!");
	}
	//按钮会以ActionEvent对象作为参数调用此方法
	//ActionListener是一个抽象类，里面的actionPerformed方法必须要覆盖（不信把这个方法注释掉）
}
//Event对象携带事件信息，调用接口上方法的把它传进去