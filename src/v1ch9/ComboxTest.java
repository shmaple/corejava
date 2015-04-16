package v1ch9;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class ComboxTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComboxFrame frame=new ComboxFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
class ComboxFrame extends JFrame
{
	private JLabel label;
	private int DEFAULT_SIZE=12;
	private JComboBox<String> jcombox;
	public ComboxFrame()
	{
		this.setTitle("ComboxTest");
		label=new JLabel("The quick brown fox jumps over the lazy dog.");
		label.setFont(new Font("Serif",Font.PLAIN,DEFAULT_SIZE));
		this.add(label,BorderLayout.CENTER);
		jcombox=new JComboBox<String>();
		jcombox.setEditable(true);
		jcombox.addItem("Serif");
		jcombox.addItem("SansSerif");
		jcombox.addItem("Monospaced");
		jcombox.addItem("Dialog");
		jcombox.addItem("DialogInput");
		jcombox.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				label.setFont(new Font((String) jcombox.getSelectedItem(),Font.PLAIN,DEFAULT_SIZE));
			}
			
		});
		JPanel comboPanel=new JPanel();
		comboPanel.add(jcombox);
		this.add(comboPanel,BorderLayout.SOUTH);
		pack();
	}
}