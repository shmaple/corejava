package v1ch9;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;
import java.util.Dictionary;
import java.util.Hashtable;

public class SliderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SliderFrame frame=new SliderFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
class SliderFrame extends JFrame
{
	private JPanel sliderPanel;
	private ChangeListener listener;
	private JTextField textField;
	public SliderFrame()
	{
		this.setTitle("SliderTest");
		sliderPanel=new JPanel();
		sliderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		listener=new ChangeListener()
		{
		

			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source=(JSlider)e.getSource();	
				textField.setText(""+source.getValue());
			}
		};
		JSlider slider=new JSlider();
		addSlider(slider,"Plain");
		
		slider=new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		
		addSlider(slider, "Ticks");
		
		slider=new JSlider();
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider,"Snap to ticks");
		
		slider=new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setPaintTrack(false);
		addSlider(slider,"no track");
		
		slider=new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setInverted(true);
		addSlider(slider,"Inverted");
		
		slider=new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider,"Labels");
		
		slider=new JSlider();
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		
		Dictionary<Integer,Component> labelTable=new Hashtable<Integer,Component>();
		labelTable.put(0, new JLabel("A"));
		labelTable.put(20, new JLabel("B"));
		labelTable.put(40, new JLabel("C"));
		labelTable.put(60, new JLabel("D"));
		labelTable.put(80, new JLabel("E"));
		labelTable.put(100, new JLabel("F"));
		slider.setLabelTable(labelTable);
		addSlider(slider,"Custom labels");
		
		textField=new JTextField();
		add(sliderPanel,BorderLayout.CENTER);
		add(textField,BorderLayout.SOUTH);
		pack();
		
		
	}
		public void addSlider(JSlider s,String description)
		{
			s.addChangeListener(listener);
			JPanel panel=new JPanel();
			panel.add(s);
			panel.add(new JLabel(description));
			sliderPanel.add(panel);
		}
	
	
}