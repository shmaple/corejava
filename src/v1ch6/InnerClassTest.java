package v1ch6;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class InnerClassTest {

	public static void main(String[] args) {
		TalkingClock clock=new TalkingClock(1000,true);
		clock.start();
		JOptionPane.showMessageDialog(null, "Quit programe?");
		System.exit(0);
	}

}
class TalkingClock
{
	private int interval;
	private boolean beep;
	public TalkingClock(int interval,boolean beep)
	{
		this.interval=interval;
		this.beep=beep;
	}
	
	public void start()
	{
		//TimePrinter listener =new TimePrinter();
		//listener.sayHello();
		ActionListener listener=new TimePrinter();
		Timer t=new Timer(interval,listener);
		t.start();
	}
	public class TimePrinter implements ActionListener
	{
		public TimePrinter()
		{
			System.out.println("内部类构造函数");
		}
		public void sayHello()
		{
			System.out.println("Hello world");
		}
		public void actionPerformed(ActionEvent event)
		{
			Date now=new Date();
			System.out.println("At the tone, the time is "+now);
			if(beep) Toolkit.getDefaultToolkit().beep();
		}
	}
}