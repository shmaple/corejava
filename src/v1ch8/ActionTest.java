package v1ch8;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.*;


public class ActionTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				ActionFrame frame=new ActionFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});

	}

	}
class ActionFrame extends JFrame
{
	private JPanel buttonPanel;

	public ActionFrame()
	{
		this.setTitle("ActionTest");
		this.setSize(300,200);
		buttonPanel=new JPanel();
		
		//define actions
		Action yellowAction=new ColorAction("Yellow",new ImageIcon("yellow-ball.gif"),Color.yellow);
		Action blueAction=new ColorAction("blue",new ImageIcon("blue-ball.gif"),Color.blue);
		Action redAction=new ColorAction("red",new ImageIcon("red-ball.gif"),Color.red);
		buttonPanel.add(new JButton(yellowAction));
		buttonPanel.add(new JButton(blueAction));
		buttonPanel.add(new JButton(redAction));
		this.add(buttonPanel);
		
		InputMap imap=buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		imap.put(KeyStroke.getKeyStroke("ctrl Y"),"panel.yellow");
		imap.put(KeyStroke.getKeyStroke("ctrl B"),"panel.blue");
		imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");
		
		ActionMap amap=buttonPanel.getActionMap();
		amap.put("panel.yellow", yellowAction);
		amap.put("panel.blue", blueAction);
		amap.put("panel.red", redAction);
	}


public class ColorAction extends AbstractAction
{
	public ColorAction(String name,Icon icon,Color c)
	{
		putValue(Action.NAME,name);
		this.putValue(Action.SMALL_ICON, icon);
		super.putValue(Action.SHORT_DESCRIPTION, "set panel color to "+name.toLowerCase());
		putValue("color",c);
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Color c=(Color)getValue("color");
		buttonPanel.setBackground(c);
	}
	
}
}

