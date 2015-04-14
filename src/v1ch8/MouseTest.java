package v1ch8;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.geom.*;

import javax.swing.*;

public class MouseTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run()
			{
				MouseFrame frame=new MouseFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}
class MouseFrame extends JFrame
{
	public MouseFrame()
	{
		this.setTitle("MouseFrame");
		this.setSize(300,200);
		MouseComponent component= new MouseComponent();
		this.add(component);
	}
	
}
class MouseComponent extends JComponent
{
	private ArrayList<Rectangle2D> squares;
	private Rectangle2D current;
	private static final int SIDELENGTH=10;

	public MouseComponent()
	{
		squares=new ArrayList<Rectangle2D>();
		current=null;
		addMouseListener(new MouseHandler());
		addMouseMotionListener(new MouseMotionHandler());
		
	}
	public void paintComponent(Graphics g)
	{
		Graphics2D g2=(Graphics2D)g;
		for(Rectangle2D r:squares)
			g2.draw(r);
	}
	
	public Rectangle2D find(Point2D p)
	{
		for(Rectangle2D r:squares)
		{
			if(r.contains(p)) return r;
		}
		return null;
	}
	public void add(Point2D p)
	{
		double x=p.getX();
		double y=p.getY();
		current=new Rectangle2D.Double(x-SIDELENGTH/2, y-SIDELENGTH/2, SIDELENGTH,SIDELENGTH);
		squares.add(current);
		repaint();
	}
	public void remove(Rectangle2D s)
	{
		if(s==null) return;
		if(s==current) current=null;
		squares.remove(s);
		repaint();
	}
	private class MouseHandler extends MouseAdapter
	{
		public void mousePressed(MouseEvent event)
		{
			current=find(event.getPoint());
			if(current==null) add(event.getPoint());
			
		}
	
		public void mouseClicked(MouseEvent event)
		{
			current=find(event.getPoint());
			if(current!=null&&event.getClickCount()>=2) remove(current);
		}
	}
	private class MouseMotionHandler implements MouseMotionListener
	{

		@Override
		public void mouseDragged(MouseEvent arg0) {
			if(current!=null)
			{
				int x=arg0.getX();
				int y=arg0.getY();
				current.setFrame(x-SIDELENGTH/2,y-SIDELENGTH/2,SIDELENGTH,SIDELENGTH);
				repaint();
			}
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			if(find(arg0.getPoint())==null) setCursor(Cursor.getDefaultCursor());
			else setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		}
		
	}
	}