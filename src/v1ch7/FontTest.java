package v1ch7;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.util.Date;

import javax.swing.*;
public class FontTest {
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				FontFrame frame=new FontFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		}
				);
	}

}
class FontFrame extends JFrame
{
	//private static final int DEFAULT = 300;
	private static final int DEFAULT_HEIGHT = 200;
	private static final int DEFAULT_WIDTH = 300;
	
	public FontFrame()
	{
		this.setTitle("font test");
		this.setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		FontComponent component=new FontComponent();
		this.add(component);
	//	pack();
	}
}
class FontComponent extends JComponent
{
	public void paintComponent(Graphics g)
	{
		Graphics2D g2=(Graphics2D)g;
		Date tt=new Date();
		
		String message="Hello, World!"+tt.toString();
		Font f=new Font("Serif",Font.BOLD,36);
		g2.setFont(f);
		
		//获取包裹字符串的矩形。
		FontRenderContext context=g2.getFontRenderContext();
		Rectangle2D bounds=f.getStringBounds(message, context);
		
		double x=(getWidth()-bounds.getWidth())/2;
		double y=(this.getHeight()-bounds.getHeight())/2;
		
		double ascent=-bounds.getY();
		double baseY=y+ascent;
		
		g2.drawString(message, (int)x, (int)baseY);
		g2.setPaint(Color.LIGHT_GRAY);
		g2.draw(new Line2D.Double(x, baseY, x+bounds.getWidth(), baseY));
		
		Rectangle2D rect=new Rectangle2D.Double(x, y, bounds.getWidth(), bounds.getHeight());
		g2.draw(rect);
		
	}
	// public Dimension getPreferredSize() { return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT); }
}