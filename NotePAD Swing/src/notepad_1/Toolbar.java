package notepad_1;
import java.awt.BorderLayout; 

import javax.swing.*;


public class Toolbar extends JFrame{
	Toolbar() {
JButton b1 = new JButton("abc");
 JToolBar tt = new JToolBar();
 tt.add(b1);
add(tt,BorderLayout.NORTH);	
	setVisible(true);
	
}
public static void main(String[] args) 
{
     new   Toolbar();	
}
	
	
	
}
