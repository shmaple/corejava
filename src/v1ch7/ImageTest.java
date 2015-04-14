package v1ch7;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ImageTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImageFrame frame=new ImageFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
class ImageFrame extends JFrame
{
	public static final int DEFAULT_WIDTH=300;
	public static final int DEFAULT_HEIGHT=200;
	public ImageFrame()
	{
		this.setTitle("ImageTest");
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		ImageComponent component=new ImageComponent();
		this.add(component);
	}
}
class ImageComponent extends JComponent
{
	

	private Image image;

	public ImageComponent()
	{
		image =  new ImageIcon("blue-ball.gif").getImage();
	}
	
	public void PaintComponent(Graphics g)
	{
		Graphics2D g2=(Graphics2D)g;
		//if(image==null) return;
		int imageWidth=image.getWidth(this);
		int imageHeight=image.getHeight(this);
		g2.drawImage(image, 0, 0, null);
		//g2.drawi
		
		for(int i=0;i*imageWidth<=getWidth();i++)
			for(int j=0;j*imageHeight<=this.getHeight();j++)
			{
				if(i+j>0)
					g.copyArea(0, 0, imageWidth, imageHeight, i*imageWidth, j*imageHeight);
			}
	}
}