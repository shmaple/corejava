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
	
		
		//�������
		buttonPanel=new JPanel();
		
		//��Ӱ�ť�����
		buttonPanel.add(this.makeButton("Yellow",Color.yellow));
		buttonPanel.add(makeButton("blue",Color.blue));
		buttonPanel.add(makeButton("Green",Color.GREEN));
		//�����嵽����
		//this.add(bp);
		this.add(buttonPanel);

		
		//����ť���¼��Ķ�Ӧ��ϵ

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