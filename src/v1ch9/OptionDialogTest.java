package v1ch9;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.util.Date;

public class OptionDialogTest {

	public static void main(String[] args) {
		OptionDialogFrame frame=new OptionDialogFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
class ButtonPanel extends JPanel	
{
	private ButtonGroup group;

	public ButtonPanel(String title, String...  options)
	{
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),title));
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		group=new ButtonGroup();
		for(String option:options)
		{
			JRadioButton b=new JRadioButton(option);
			b.setActionCommand(option);
			add(b);
			group.add(b);
			b.setSelected(option==options[0]);
		}
	}
	public String getSelection()
	{
		return group.getSelection().getActionCommand();
	}
	
}
class OptionDialogFrame extends JFrame
{
	private ButtonPanel typePanel;
	private ButtonPanel messageTypePanel;
	private ButtonPanel messagePanel;
	private ButtonPanel optionTypePanel;
	private ButtonPanel optionPanel;
	private ButtonPanel inputPanel;
	private String messageString="Message";
	private Icon messageIcon=new ImageIcon("blue-ball.gif");
	private Component messageComponent=new SampleComponent();
	private Object messageObject=new Date();

	public OptionDialogFrame()
	{
		setTitle("OptionDialogTest");
		setSize(500,600);
		JPanel gridPanel=new JPanel();
		gridPanel.setLayout(new GridLayout(2,3));
		
		typePanel=new ButtonPanel("TypePanel","Message","Confirm","Option","Input");
		messageTypePanel=new ButtonPanel("MessageTypePanel","ERROR_MESSAGE","INFORMATION_MESSAGE",
				"WARNING_MESSAGE","QUESTION_MESSAGE","PLAIN_MESSAGE");
		messagePanel=new ButtonPanel("MessagePanel","String","Icon","Component","Other","Object[]");
		optionTypePanel=new ButtonPanel("optionTypePanel","DEFAULT_IPTION","YES_NO_OPTION","YES_NO_CANCEL_OPTION","OK_CANCEL_OPTION");
		optionPanel=new ButtonPanel("OptionPanel","String[]","Icon[]","Object[]");
		inputPanel=new ButtonPanel("InputPanel","Text field","Combo box");
		gridPanel.add(typePanel);
		gridPanel.add(messageTypePanel);
		gridPanel.add(messagePanel);
		gridPanel.add(optionTypePanel);
		gridPanel.add(optionPanel);
		gridPanel.add(inputPanel);
		
		JPanel showPanel=new JPanel();
		JButton showButton=new JButton("Show");
		showButton.addActionListener(new ShowAction());
		showPanel.add(showButton);
		this.add(gridPanel, BorderLayout.CENTER);
		this.add(showPanel, BorderLayout.SOUTH);
	}
	public Object getMessage()
	{
		String s=messagePanel.getSelection();
		if(s.equals("String")) return messageString;
		else if (s.equals("Icon")) return messageIcon;
		else if(s.equals("Component")) return messageComponent;
		else if(s.equals("Object[]")) return new Object[]{messageString,messageIcon,messageComponent,messageObject};
		else if(s.equals("Other")) return messageObject;
		else return null;
	}
	public Object[] getOptions()
	{
		String s=optionPanel.getSelection();
		if(s.equals("String[]")) return new String[]{"Yellow","Blue","Red"};
		else if(s.equals("Icon")) return new Icon[]{new ImageIcon("yellow-ball.gif"),new ImageIcon("blue-ball.gif"),new ImageIcon("red-ball.gif")};
		else if(s.equals("Object[]")) return new Object[]{messageString,messageIcon,messageComponent,messageObject};
		else return null;
	}
	
	public int getType(ButtonPanel panel)
	{
		String s=panel.getSelection();
		try {
			return JOptionPane.class.getField(s).getInt(null);
		} catch (Exception e) {
			return -1;
		}
	}
	private class ShowAction implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(typePanel.getSelection().equals("Confirm")) JOptionPane.showConfirmDialog(OptionDialogFrame.this, getMessage(),"Title",getType(optionTypePanel),getType(messageTypePanel));
			else if(typePanel.getSelection().equals("Input"))
			{
				if(inputPanel.getSelection().equals("Text field")) JOptionPane.showInputDialog(OptionDialogFrame.this,getMessage(),"Title",getType(messageTypePanel));
				else JOptionPane.showInputDialog(OptionDialogFrame.this,getMessage(),"Title",getType(messageTypePanel),null,new String[]{"Yellow","Blue","Red"},"Blue");
			}
			else if(typePanel.getSelection().equals("Message")) JOptionPane.showMessageDialog(OptionDialogFrame.this, getMessage(),"Title",getType(messageTypePanel));
			else if(typePanel.getSelection().equals("Option")) JOptionPane.showOptionDialog(OptionDialogFrame.this, getMessage(), "Title", getType(optionTypePanel),getType(messageTypePanel), null,getOptions(),getOptions()[0]);
		}
		
	}
}
class SampleComponent extends JComponent
{
	public void PaintComponent(Graphics g)
	{
		Graphics2D g2=(Graphics2D)g;
		Rectangle2D rect=new Rectangle2D.Double(0,0,getWidth()-1,getHeight()-1);
		g2.setPaint(Color.YELLOW);
		g2.fill(rect);
		g2.setPaint(Color.blue);
		g2.draw(rect);
	}
	public Dimension getPreferredSize()
	{
		return new Dimension(10,10);
	}
}