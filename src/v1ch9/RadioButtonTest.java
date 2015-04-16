package v1ch9;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
public class RadioButtonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				RadioButtonFrame frame=new RadioButtonFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
			
		});
	}

}
class RadioButtonFrame extends JFrame
{
	private JLabel label;
	private int DEFAULT_SIZE=20;
	private ButtonGroup group;
	private JPanel buttonPanel;
	
	public RadioButtonFrame()
	{
		this.setTitle("RadioButtonTest");
		label=new JLabel("fdja");
		label.setFont(new Font("Serif",Font.PLAIN,DEFAULT_SIZE));
		this.add(label,BorderLayout.CENTER);
		group=new ButtonGroup();
		buttonPanel=new JPanel();
		buttonPanel.setBorder(BorderFactory.createEtchedBorder());
		
		
		this.addRadioButton("Small", 8);
		this.addRadioButton("Medium", 12);
		this.addRadioButton("Large", 18);
		this.addRadioButton("Extra large", 36);
		
		add(buttonPanel,BorderLayout.SOUTH);
		pack();
	}
	public void addRadioButton(String name,final int size)
	{
		 boolean selected=size==DEFAULT_SIZE;
		 JRadioButton jr=new JRadioButton(name,selected);
		 group.add(jr);
		 buttonPanel.add(jr);
		 
		 jr.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				label.setFont(new Font("Serif",Font.PLAIN,size));
			}
			 
		 });
		 
		
	}
}