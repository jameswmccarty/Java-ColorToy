

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainPanel extends JPanel {
    
    private ColorToyPanel panel;
    private ControlPanel ctrl;

    public MainPanel() {
		panel = new ColorToyPanel();
		ctrl = new ControlPanel(panel);
		panel.setPreferredSize(new Dimension(1000, 100));
		ctrl.setPreferredSize(new Dimension(1000, 150));		
	
		add(panel);
		add(Box.createVerticalGlue());
		add(ctrl);
		add(Box.createVerticalGlue());
		setPreferredSize(new Dimension(1000, 250));
		setBackground(Color.white);
    }

}
