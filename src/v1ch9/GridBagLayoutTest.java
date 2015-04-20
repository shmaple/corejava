package v1ch9;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GridBagLayoutTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				FontFrame frame=new FontFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
			
		});
	}

}
class FontFrame extends JFrame
{
	private JComboBox face;
	private JComboBox size;
	private JCheckBox bold;
	private JCheckBox italic;
	private JTextArea sample;
	public FontFrame()
	{
		setTitle("GridBagLayoutTest");
		setSize(300,200);
		GridBagLayout layout=new GridBagLayout();
		this.setLayout(layout);
		//GridBagLayout layout=new GridBagLayout();
		ActionListener listener=new FontAction();
		JLabel faceLabel=new JLabel("Face:");
		face=new JComboBox(new String[]{"Serif","SansSerif","Monospaced","Dialog","DialogInput"});
		face.addActionListener(listener);
		JLabel sizeLabel=new JLabel("Size:");
		size=new JComboBox(new String[]{"8","10","12","15","18","24","36","48"});
		size.addActionListener(listener);
		
		bold=new JCheckBox("Bold");
		bold.addActionListener(listener);
		
		italic=new JCheckBox("Italic");
		italic.addActionListener(listener);
		
		sample=new JTextArea();
		sample.setText("The quick brown fox jumps over the lazy dog");
		sample.setEditable(false);
		sample.setLineWrap(true);
		sample.setBorder(BorderFactory.createEtchedBorder());
		
		this.add(faceLabel,new GBC(0,0).setAnchor(GBC.EAST));
		//允许水平拉升
		this.add(face,new GBC(1,0).setFill(GBC.HORIZONTAL).setWeight(100,0).setInsets(1));
		this.add(sizeLabel,new GBC(0,1).setAnchor(GBC.EAST));
		this.add(size,new GBC(1,1).setFill(GBC.HORIZONTAL).setWeight(100, 0).setInsets(1));
		this.add(bold,new GBC(0,2,2,1).setAnchor(GBC.CENTER).setWeight(100, 100));
		this.add(italic,new GBC(0,3,2,1).setAnchor(GBC.CENTER).setWeight(0, 0).setInsets(101));
		this.add(sample,new GBC(2,0,1,4).setFill(GBC.BOTH).setWeight(100, 100));
		
		
	}

	private class FontAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String fontFace=(String)face.getSelectedItem();
			int fontStyle=(bold.isSelected()?Font.BOLD:0)+(italic.isSelected()?Font.ITALIC:0);
			int fontSize=Integer.parseInt((String)size.getSelectedItem());
			Font font=new Font(fontFace,fontStyle,fontSize);
			sample.setFont(font);
			sample.repaint();
		}

	}
}