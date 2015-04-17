package v1ch9;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.*;

public class MenuTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run() {
				MenuFrame frame=new MenuFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
			
		});
	}

}
class MenuFrame extends JFrame
{
     private TestAction saveAction;
	private TestAction saveAsAction;
	private JCheckBoxMenuItem readonlyItem;
	private JPopupMenu popup;




	//	private JMenuBar MenuBar;
	public MenuFrame()
	{
		this.setTitle("MenuTest");
		//创建File菜单，并使用监听器创建New 菜单项
		JMenu fileMenu=new JMenu("File");
		fileMenu.add(new TestAction("New"));
		//创建OPEN并增加快捷键
		JMenuItem openItem=fileMenu.add(new TestAction("Open"));
		openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
		fileMenu.addSeparator();
		
		saveAction=new TestAction("Save");
		JMenuItem saveItem=fileMenu.add(saveAction);
		saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
		
		saveAsAction=new TestAction("Save AS");
		JMenuItem savaAsItme=fileMenu.add(saveAsAction);
		
		fileMenu.add(new AbstractAction("Exit"){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		fileMenu.addSeparator();
		//增加 check box和radio button 菜单
		readonlyItem=new JCheckBoxMenuItem("Read-only");
		readonlyItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean saveOk=!readonlyItem.isSelected();
				saveAction.setEnabled(saveOk);
				saveAsAction.setEnabled(saveOk);
			}
			
		});
		ButtonGroup group=new ButtonGroup();
		JRadioButtonMenuItem insertItem=new JRadioButtonMenuItem("Insert");
		insertItem.setSelected(true);
		JRadioButtonMenuItem overtypeItem=new JRadioButtonMenuItem("OverType");
		group.add(insertItem);
		group.add(overtypeItem);
		
		Action cutAction=new TestAction("Cut");
		cutAction.putValue(Action.SMALL_ICON, new ImageIcon("cut.gif"));
		Action copyAction=new TestAction("Copy");
		copyAction.putValue(Action.SMALL_ICON, new ImageIcon("copy.gif"));
		Action pasteAction=new TestAction("Paste");
		pasteAction.putValue(Action.SMALL_ICON, new ImageIcon("paste.gif"));
		
		JMenu editMenu=new JMenu("Edit");
		editMenu.add(cutAction);
		editMenu.add(copyAction);
		editMenu.add(pasteAction);
		
		JMenu optionMenu=new JMenu("Options");
		optionMenu.add(readonlyItem);
		optionMenu.addSeparator();
		optionMenu.add(insertItem);
		optionMenu.add(overtypeItem);
		editMenu.addSeparator();
		editMenu.add(optionMenu);
		
		//add help menu
		JMenu helpMenu=new JMenu("Help");
		helpMenu.setMnemonic('H');
		
		JMenuItem indexItem=new JMenuItem("Index");
		indexItem.setMnemonic('I');
		helpMenu.add(indexItem);
		
		Action aboutAction=new TestAction("About");
		aboutAction.putValue(Action.MNEMONIC_KEY, new Integer('A'));
		helpMenu.add(indexItem);
		JMenuBar menuBar=new JMenuBar();
		this.setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);
		
		popup=new JPopupMenu();
		popup.add(cutAction);
		popup.add(copyAction);
		popup.add(pasteAction);
		
		JPanel panel=new JPanel();
		panel.setComponentPopupMenu(popup);
		add(panel);
		this.add(new JLabel("dsdsds"),BorderLayout.EAST);
		panel.addMouseListener(new MouseAdapter(){
			
		});
		pack();
	}
	
	
	
	
	class TestAction extends AbstractAction
	{
		public TestAction(String name)
		{
			super(name);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println(getValue(Action.NAME)+" selected");
		}
		
	}
}
