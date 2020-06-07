package unit12_code;

import javax.swing.*;
import java.awt.*;
import static java.lang.Math.*;

public class MyDrawPanel extends JPanel
{
	public void paintComponent(Graphics g)//图形类
	{
		Graphics2D g2d=(Graphics2D) g;//升级版
		int red=(int)(random()*255);
		int green=(int)(random()*255);
		int blue=(int)(random()*255);
		Color startColor=new Color(red,green,blue);
		
		red=(int)(random()*255);
		green=(int)(random()*255);
		blue=(int)(random()*255);
		Color endColor=new Color(red,green,blue);
		
		GradientPaint gradient=new GradientPaint(70,70,startColor,150,150,endColor);
		//生成渐变色
		g2d.setPaint(gradient);
		g2d.fillOval(70, 70, 150, 150);//画圆
	}
}
