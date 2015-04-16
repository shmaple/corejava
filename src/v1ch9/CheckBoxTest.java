package v1ch9;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class CheckBoxTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckBoxFrame1 frame=new CheckBoxFrame1();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
class CheckBoxFrame extends JFrame
{
	private JLabel label=new JLabel("The quick brown fox jumps over the lazy dog.");
	private JCheckBox bold;
	private JCheckBox italic;
	public CheckBoxFrame()
	{
		setTitle("CheckBoxTest");
		setSize(300,200);
		label.setFont(new Font("Serif", Font.BOLD, 12));
		this.add(label,BorderLayout.CENTER);
		
		JPanel boxPanel=new JPanel();
		bold=new JCheckBox("Bold");
		boxPanel.add(bold);
		italic=new JCheckBox("Italic");
		boxPanel.add(italic);
		
		
	
	ActionListener checkListener =new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			int mode=0;
			if(bold.isSelected()) mode+=Font.BOLD;
			if(italic.isSelected()) mode+=Font.ITALIC;
			label.setFont(new Font("Serif",mode,12));
			
			
		}
		
	};
	bold.addActionListener(checkListener);
	italic.addActionListener(checkListener);
	add(boxPanel,BorderLayout.SOUTH);
	pack();
}
	}



/**
 * A frame with a sample text label and check boxes for selecting font attributes.
 */
 class CheckBoxFrame1 extends JFrame
{
   private JLabel label;
   private JCheckBox bold;
   private JCheckBox italic;
   private static final int FONTSIZE = 12;

   public CheckBoxFrame1()
   {      
      // add the sample text label

      label = new JLabel("The quick ");
      label.setFont(new Font("Serif", Font.BOLD, FONTSIZE));
      add(label, BorderLayout.CENTER);

      // this listener sets the font attribute of
      // the label to the check box state

      ActionListener listener = new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               int mode = 0;
               if (bold.isSelected()) mode += Font.BOLD;
               if (italic.isSelected()) mode += Font.ITALIC;
               label.setFont(new Font("Serif", mode, FONTSIZE));
            }
         };

      // add the check boxes

      JPanel buttonPanel = new JPanel();

      bold = new JCheckBox("Bold");
      bold.addActionListener(listener);
      bold.setSelected(true);
      buttonPanel.add(bold);

      italic = new JCheckBox("Italic");
      italic.addActionListener(listener);
      buttonPanel.add(italic);

      add(buttonPanel, BorderLayout.SOUTH);
      pack();
   }
}
