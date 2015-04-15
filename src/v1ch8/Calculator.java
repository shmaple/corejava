package v1ch8;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculator {

	public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable(){
				public void run()
				{
					CalculatorFrame frame=new CalculatorFrame();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				}
			});
	}

}
class CalculatorFrame extends JFrame
{
	public CalculatorFrame()
	{
		this.setTitle("Calculator");
		CalculatorPanel panel=new CalculatorPanel();
		add(panel);
		pack();
	}
}
class CalculatorPanel extends JPanel
{
	private double result;
	private boolean start;
	private String lastCommand;
	private JButton display;
	private JPanel panel;

	public CalculatorPanel()
	{
		this.setLayout(new BorderLayout());
		result=0;
		lastCommand="=";
		start=true;
		
		display=new JButton("0");
		display.setEnabled(false);
		add(display,BorderLayout.NORTH);
		
		ActionListener insert=new InsertAction();
		ActionListener command=new CommandAction();
		
		panel=new JPanel();
		panel.setLayout(new GridLayout(4,4));
		
		addButton("7",insert);
		addButton("8",insert);
		addButton("9",insert);
		addButton("/",command);
		
		addButton("4",insert);
		addButton("5",insert);
		addButton("6",insert);
		addButton("*",command);
		
		addButton("1",insert);
		addButton("2",insert);
		addButton("3",insert);
		addButton("-",command);
		
		addButton("0",insert);
		addButton(".",insert);
		addButton("=",command);
		addButton("+",command);
		
		add(panel,BorderLayout.CENTER);
		
	}
	/**
	 * Adds a button to the center panel
	 * @param label the button label
	 * @param listener the button listener
	 */
	private void addButton(String label,ActionListener listener)
	{
		JButton jb=new JButton(label);
		jb.addActionListener(listener);
		panel.add(jb);
	}
	private class InsertAction implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String input=arg0.getActionCommand();
			if(start)
			{
				display.setText("");
				start=false;
			}
			display.setText(display.getText()+input);
		}
		
	}
	private class CommandAction implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String command= e.getActionCommand();
			if(start)
			{
				if(command.equals("-"))
				{
					display.setText(command);
					start=false;
				}
				else lastCommand=command;
			}
			else
			{
				calculate(Double.parseDouble(display.getText()));
				lastCommand=command;
				start=true;
			}
		}
		
	}
	public void calculate(double x)
	{
		if(lastCommand.equals("+")) result+=x;
		else if(lastCommand.equals("-")) result-=x;
		else if(lastCommand.equals("*")) result*=x;
		else if(lastCommand.equals("/")) result/=x;
		else if(lastCommand.equals("=")) result=x;
		display.setText(""+result);
	}
}