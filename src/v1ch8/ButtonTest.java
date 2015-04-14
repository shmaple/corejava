package v1ch8;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class ButtonTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				ButtonFrame frame=new ButtonFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});

	}

}
class ButtonFrame extends JFrame
{
	private JPanel buttonPanel;
	private JPanel bp;

	public ButtonFrame()
	{
		this.setTitle("Button Test");
		this.setSize(600, 400);
		//super.setLayout(null);
		//������ť
		JButton yb=new JButton("<html><i>Yellow</i></html>");
		JButton bb=new JButton("Blue");
		JButton rb=new JButton("Red");
		
		//�������
		buttonPanel=new JPanel();
		buttonPanel.setPreferredSize(new Dimension(250,150));
	//	buttonPanel.setBorder(new Border());
		bp =new JPanel();
		bp.setPreferredSize(new Dimension(250,150));
		//��Ӱ�ť�����
		buttonPanel.add(yb);
		buttonPanel.add(bb);
		buttonPanel.add(rb);
		//�����嵽����
		//this.add(bp);
		this.add(buttonPanel);
		
		
		//�����¼�������
		ColorAction yellowAction=new ColorAction(Color.YELLOW);
		ColorAction blueAction=new ColorAction(Color.blue);
		ColorAction redAction=new ColorAction(Color.red);
		
		//����ť���¼��Ķ�Ӧ��ϵ
		yb.addActionListener(yellowAction);
		bb.addActionListener(blueAction);
		rb.addActionListener(redAction);
	}
	private class ColorAction implements ActionListener
	{
		private Color backgroundColor;
		public ColorAction(Color c)
		{
			backgroundColor=c;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			buttonPanel.setBackground(backgroundColor);
		}
		
	}
}