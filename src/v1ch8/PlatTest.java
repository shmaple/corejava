package v1ch8;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PlatTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				PlafFrame frame=new PlafFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});

	}

}
class PlafFrame extends JFrame
{
	private JPanel buttonPanel;

	public PlafFrame()
	{
		this.setTitle("PlafFrame");
		this.setSize(300, 200);
		buttonPanel=new JPanel();
		UIManager.LookAndFeelInfo[] infos=UIManager.getInstalledLookAndFeels();
		for(UIManager.LookAndFeelInfo info:infos)
		{
			makeButton(info.getName(),info.getClassName());
		}
		this.add(buttonPanel);
	}

	private void makeButton(String name, final 	String plafName	) {
		JButton button=new JButton(name);
		buttonPanel.add(button);
		
		button.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							UIManager.setLookAndFeel(plafName);
							SwingUtilities.updateComponentTreeUI(PlafFrame.this);
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (UnsupportedLookAndFeelException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				});
	}
}