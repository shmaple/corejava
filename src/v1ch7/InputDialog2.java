package v1ch7;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class InputDialog2 extends JFrame implements ActionListener{
    JButton theButton;
    String input;
    
    public InputDialog2(){
        super("InputDialog2");
        theButton=new JButton("click me");
        JPanel pane=new JPanel();
        input="";
        pane.add(theButton);
        theButton.addActionListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(pane);
        setLocation(400,300);
        setSize(300,200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==theButton)
            input=JOptionPane.showInputDialog(this,"Please input something");
        repaint();
    }
    
    public void paintComponent(Graphics g){
        g.drawString(input,50,100);
    }
    
    public static void main(String[] args) {
        InputDialog2 id=new InputDialog2();
    }
}
