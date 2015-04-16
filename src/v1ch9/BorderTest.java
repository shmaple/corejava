package v1ch9;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class BorderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BorderFrame frame=new BorderFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
class BorderFrame extends JFrame
{
	private JPanel demoPanel;
	private JPanel buttonPanel;
	private ButtonGroup group;

	public BorderFrame()
	{
		setTitle("BorderTest");
		demoPanel=new JPanel();
		buttonPanel=new JPanel();
		group=new ButtonGroup();
		addRadioButton("Lower bevel",BorderFactory.createLoweredBevelBorder());
		addRadioButton("Raise bevel",BorderFactory.createRaisedBevelBorder());
		addRadioButton("Etched",BorderFactory.createEtchedBorder());
		addRadioButton("Line",BorderFactory.createLineBorder(Color.blue));
		addRadioButton("Matte",BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLUE));
		addRadioButton("Empty",BorderFactory.createEmptyBorder());
		Border etched=BorderFactory.createEtchedBorder();
		Border titled=BorderFactory.createTitledBorder(etched, "Border Types");
		buttonPanel.setBorder(titled);
		this.setLayout(new GridLayout(2,1));
		add(buttonPanel);
		add(demoPanel);
		pack();
		
	}
	public void addRadioButton(String name, final Border b)
	{
		JRadioButton button=new JRadioButton(name);
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				demoPanel.setBorder(b);
				
			}});
		group.add(button);
		buttonPanel.add(button);
	}
}