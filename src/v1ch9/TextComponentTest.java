package v1ch9;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TextComponentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

				TextComponentFrame frame=new TextComponentFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
		

}
}
class TextComponentFrame extends JFrame
{
	public TextComponentFrame()
	{
		setTitle("TextComponentTest");
		setSize(400,500);
		final JTextField textField=new JTextField();
		final JPasswordField passwordField=new JPasswordField();
		JPanel northPanel=new JPanel();
		northPanel.setLayout(new GridLayout(2,2));
		northPanel.add(new JLabel("User name:"), SwingConstants.RIGHT);
		northPanel.add(textField);
		northPanel.add(new JLabel("Password"),SwingConstants.RIGHT);
		add(northPanel,BorderLayout.NORTH);
		
		final JTextArea textArea=new JTextArea(8,40);
		JScrollPane scrollPanel=new JScrollPane(textArea);
		add(scrollPanel,BorderLayout.CENTER);
		JPanel sourthPanel=new JPanel();
		JButton insertButton=new JButton("insert");
		sourthPanel.add(insertButton);
		
		insertButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("User name:"+textField.getText()+" Password: "+new String(passwordField.getPassword())+"\n");
			}
			
		});
		add(sourthPanel,BorderLayout.SOUTH);
	}
}