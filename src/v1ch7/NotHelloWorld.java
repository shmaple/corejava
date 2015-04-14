package v1ch7;

import java.awt.*;

import javax.swing.*;

public class NotHelloWorld 
{
	public static void main(String[] args) 
	{
		/*
		NotHelloWorldFrame frame=new NotHelloWorldFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		*/
		float f=1.2f;
	//	Toolkit.getDefaultToolkit().getScreenSize().
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				NotHelloWorldFrame frame=new NotHelloWorldFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		}
				);
	}

}
class NotHelloWorldFrame extends JFrame
{
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT =200;

	public NotHelloWorldFrame()
	{
		setTitle("NotHelloWorld");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		NotHelloWorldPanel panel=new NotHelloWorldPanel();
		this.add(panel);
	}
}


class NotHelloWorldPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int MESSAGE_X = 75;
	private static final int MESSAGE_Y = 100;

	public void paintComponent(Graphics g)
	{
		g.drawString("Not a Hello, World program", MESSAGE_X, MESSAGE_Y);
	}
}
