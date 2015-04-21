package v1ch9;
import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.io.*;

import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileFilter;

public class FileChooserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImageViewerFrame frame=new ImageViewerFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
class ImageViewerFrame extends JFrame
{
	private JLabel label;
	private JFileChooser chooser;

	public ImageViewerFrame()
	{
		this.setTitle("FileChooserTest");
		JMenuBar menuBar=new JMenuBar();
		this.setJMenuBar(menuBar);
		JMenu menu=new JMenu("File");
		menuBar.add(menu);
		JMenuItem openItem=new JMenuItem("open");
		menu.add(openItem);
		openItem.addActionListener(new FileOpenListener());
		
		JMenuItem exitItem=new JMenuItem("EXIT");
		menu.add(exitItem);
		exitItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		
		label=new JLabel();
		this.add(label);
		chooser=new JFileChooser();
		
		FileNameExtensionFilter filter=new FileNameExtensionFilter("Image Files", "jpg","jpeg","gif");
		chooser.setFileFilter(filter);
		chooser.setAccessory(new ImagePreviewer(chooser));
		chooser.setFileView(new FileIconView(filter,new ImageIcon("palette.gif")));
		pack();
		
	}
	private class FileOpenListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			chooser.setCurrentDirectory(new File("."));
			int result=chooser.showOpenDialog(ImageViewerFrame.this);
			
			if(result==JFileChooser.APPROVE_OPTION)
			{
				String name=chooser.getSelectedFile().getPath();
				label.setIcon(new ImageIcon(name));
			}
		}
		
	}
}
class FileIconView extends FileView
{
	
	private FileFilter filter;
	private Icon icon;
	public FileIconView(FileFilter aFilter,Icon aIcon)
	{
		filter=aFilter;
		icon=aIcon;
	}
	public Icon getIcon(File f)
	{
		if(!f.isDirectory()&&filter.accept(f)) return icon;
		else return null;
	}
}
class ImagePreviewer extends JLabel
{
	public ImagePreviewer(JFileChooser chooser)
	{
		this.setPreferredSize(new Dimension(200,200));
		this.setBorder(BorderFactory.createLineBorder(Color.blue));
		chooser.addPropertyChangeListener(new PropertyChangeListener(){

			@Override
			public void propertyChange(PropertyChangeEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getPropertyName()==JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)
				{
					File f=(File)arg0.getNewValue();
					if(f==null)
					{
						setIcon(null);
						return;
					}
					ImageIcon icon=new ImageIcon(f.getPath());
					if(icon.getIconWidth()>getWidth()) icon=new ImageIcon(icon.getImage().getScaledInstance(getWidth(), -1, Image.SCALE_DEFAULT));
					setIcon(icon);
				}
				
			}
			
		});
	}
}