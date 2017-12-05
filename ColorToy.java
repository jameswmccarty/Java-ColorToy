//The primary class for the ColorToy program

import javax.swing.JFrame;
import java.awt.*;

public class ColorToy{

    public static void main(String[] args){
	
	JFrame frame = new JFrame("ColorToy explorer");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
		
	MainPanel panel = new MainPanel();
	panel.setPreferredSize(new Dimension(1000, 250));
	frame.getContentPane().add(panel);
	frame.pack();
	frame.setMinimumSize(frame.getPreferredSize());
	frame.setVisible(true);

    }//end of main

}//end of ColorToy

//end of file
