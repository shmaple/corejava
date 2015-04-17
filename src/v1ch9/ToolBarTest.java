package v1ch9;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class ToolBarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				ToolBarFrame frame=new ToolBarFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
			
		});
	}

}
class ToolBarFrame extends JFrame
{
	private JPanel panel;

	public ToolBarFrame()
	{
		this.setTitle("ToolBarTest");
		panel=new JPanel();
		add(panel,BorderLayout.CENTER);
		
		Action blueAction=new ColorAction("blue",new ImageIcon("red-ball.gif"),Color.blue);
		Action yellowAction=new ColorAction("blue",new ImageIcon("blue-ball.gif"),Color.yellow);
		Action redAction=new ColorAction("red",new ImageIcon("red-ball.gif"),Color.red);
		Action exitAction=new AbstractAction("Exit",new ImageIcon("exit.gif"))
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		};
		exitAction.putValue(Action.SHORT_DESCRIPTION, "Exit");
		
		JToolBar bar=new JToolBar("Change Background");
		
		bar.add(blueAction);
		bar.add(yellowAction);
		bar.add(redAction);
		bar.addSeparator();
		bar.add(exitAction);
		add(bar,BorderLayout.NORTH);
		
		JMenu menu=new JMenu("Color");
		menu.add(yellowAction);
		menu.add(blueAction);
		menu.add(redAction);
		JMenuBar menubar=new JMenuBar();
		menubar.add(menu);
		this.setJMenuBar(menubar);
		
	}
	class ColorAction extends AbstractAction
	{
		public ColorAction(String name, Icon ico,Color c)
		{
			putValue(Action.NAME,name);
			this.putValue(Action.SMALL_ICON, ico);
			this.putValue(Action.SHORT_DESCRIPTION, name+" background");
			this.putValue("Color", c);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Color c=(Color)getValue("Color");
			panel.setBackground(c);
			
		}
	}
}
