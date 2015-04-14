package v1ch7;

import java.awt.*;
import java.awt.geom.*;

import javax.swing.*;

public class DrawTest {

	public static void main(String[] args) {
		DrawFrame frame=new DrawFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

class DrawFrame extends JFrame
{
	private static final int DEFAULT_WIDTH =400;
	private static final int DEFAULT_HEIGHT = 400;

	public DrawFrame()
	{
		this.setTitle("DrawTest");
		this.setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		//this.setBackground(Color.YELLOW);
		DrawComponent component=new DrawComponent();
		this.add(component);
	}
}

class DrawComponent extends JComponent
{
	public void paintComponent(Graphics g)
	{
		
		Graphics2D g2=(Graphics2D) g;
		double leftX=100;
		double topY=100;
		double width=200;
		double height=150;
		//this.setBackground(Color.YELLOW);
		Rectangle2D rect=new Rectangle2D.Double(leftX, topY, width, height);
		g2.draw(rect);
		
		Ellipse2D ellipse=new Ellipse2D.Double();
		ellipse.setFrame(rect);
		//g2.draw(ellipse);
		g2.setColor(Color.BLUE);
		g2.fill(ellipse);
		g2.setColor(Color.red);
		g2.draw(new Line2D.Double(leftX, topY, leftX+width, topY+height));
		g2.setColor(Color.green);
		double centerX=rect.getCenterX();
		double centerY=rect.getCenterY();
		double radius=150;
		
		Ellipse2D circle=new Ellipse2D.Double();
		circle.setFrameFromCenter(centerX, centerY, centerX+radius, centerY+radius);
		g2.draw(circle);
		
	}
}
