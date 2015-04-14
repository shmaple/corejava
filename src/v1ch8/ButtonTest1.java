package v1ch8;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class ButtonTest1 {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				ButtonFrame1 frame=new ButtonFrame1();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});

	}

}
class ButtonFrame1 extends JFrame
{
	private JPanel buttonPanel;
	private JPanel bp;

	public ButtonFrame1()
	{
		this.setTitle("Button Test1");
		this.setSize(600, 400);
	
		
		//创建面板
		buttonPanel=new JPanel();
		
		//添加按钮至面板
		buttonPanel.add(this.makeButton("Yellow",Color.yellow));
		buttonPanel.add(makeButton("blue",Color.blue));
		buttonPanel.add(makeButton("Green",Color.GREEN));
		//添加面板到窗体
		//this.add(bp);
		this.add(buttonPanel);

		
		//定按钮与事件的对应关系

	}
	private JButton makeButton(String name,final Color bgColor)
	{
		JButton myButton=new JButton(name);
		//this.add(myButton);
		myButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				buttonPanel.setBackground(bgColor);
				
			}
			
		});
		return myButton;
	}

}