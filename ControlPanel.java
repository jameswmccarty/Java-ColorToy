/**
 *The Control Panel sets values for the color function.
 *
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class ControlPanel extends JPanel{
    
    private JLabel func_lbl, ar_lbl, ag_lbl, ab_lbl;
	private JLabel br_lbl, bg_lbl, bb_lbl;
	private JLabel cr_lbl, cg_lbl, cb_lbl;
	private JLabel dr_lbl, dg_lbl, db_lbl;
	private JLabel out_lbl, in_lbl;
    private JButton update; //update all quantities
	private JButton printer; //dump values to stdout
	private JButton randbtn; //randomize starting values
	private JButton apply; //apply color palette to input image
    private JTextField ar_txt = new JTextField(4);
    private JTextField ag_txt = new JTextField(4);
    private JTextField ab_txt = new JTextField(4);
    private JTextField br_txt = new JTextField(4);
    private JTextField bg_txt = new JTextField(4);
    private JTextField bb_txt = new JTextField(4);
    private JTextField cr_txt = new JTextField(4);
    private JTextField cg_txt = new JTextField(4);
    private JTextField cb_txt = new JTextField(4);
    private JTextField dr_txt = new JTextField(4);
    private JTextField dg_txt = new JTextField(4);
    private JTextField db_txt = new JTextField(4);
	private JTextField out_txt = new JTextField(20);
	private JTextField in_txt = new JTextField(20);
	private JCheckBox ignoreBlkBox = new JCheckBox("Ignore Black on application.");
	private JPanel params = new JPanel();
	private JPanel btnarea = new JPanel();

    private ColorToyPanel colortoy;

    public ControlPanel(ColorToyPanel colortoypanel) {
	
		ar_txt.setText("0.50");
		ab_txt.setText("0.50");
		ag_txt.setText("0.50");

		br_txt.setText("0.50");
		bb_txt.setText("0.50");
		bg_txt.setText("0.50");

		cr_txt.setText("1.00");
		cb_txt.setText("1.00");
		cg_txt.setText("0.50");

		dr_txt.setText("0.80");
		db_txt.setText("0.90");
		dg_txt.setText("0.30");

		out_txt.setText("/tmp/ColorToyOut.png");
		in_txt.setText("/tmp/ColorToyInput.png");

		ar_lbl = new JLabel("A-red");
		ab_lbl = new JLabel("A-blue");
		ag_lbl = new JLabel("A-green");
		br_lbl = new JLabel("B-red");
		bb_lbl = new JLabel("B-blue");
		bg_lbl = new JLabel("B-green");
		cr_lbl = new JLabel("C-red");
		cb_lbl = new JLabel("C-blue");
		cg_lbl = new JLabel("C-green");
		dr_lbl = new JLabel("D-red");
		db_lbl = new JLabel("D-blue");
		dg_lbl = new JLabel("D-green");
		out_lbl = new JLabel("Output File Path:  ");
		out_lbl.setHorizontalAlignment(SwingConstants.RIGHT);
		in_lbl = new JLabel("Input File Path:  ");
		in_lbl.setHorizontalAlignment(SwingConstants.RIGHT);

		func_lbl = new JLabel("color(t) = a + b * cos[2pi(c*t+d)]");

       
	update = new JButton("Update Display Bar");
	printer = new JButton("Print to Console");
	randbtn = new JButton("Randomize Values");
	apply = new JButton("Apply to Input File");
	this.colortoy = colortoypanel;

	update.addActionListener(new ButtonListener(update));
	printer.addActionListener(new PrintListener(printer));
	randbtn.addActionListener(new RandomListener(randbtn));
	apply.addActionListener(new ApplyListener(apply));

	add(func_lbl);
	add(Box.createRigidArea(new Dimension(50, 0)));
	params.setLayout(new GridLayout(4, 6));
	params.add(ar_lbl);	
	params.add(ar_txt);
	params.add(ag_lbl);	
	params.add(ag_txt);
	params.add(ab_lbl);	
	params.add(ab_txt);
	params.add(br_lbl);	
	params.add(br_txt);
	params.add(bg_lbl);	
	params.add(bg_txt);
	params.add(bb_lbl);	
	params.add(bb_txt);
	params.add(cr_lbl);	
	params.add(cr_txt);
	params.add(cg_lbl);	
	params.add(cg_txt);
	params.add(cb_lbl);	
	params.add(cb_txt);
	params.add(dr_lbl);	
	params.add(dr_txt);
	params.add(dg_lbl);	
	params.add(dg_txt);
	params.add(db_lbl);	
	params.add(db_txt);
	add(params);
	add(Box.createRigidArea(new Dimension(50, 0)));
	btnarea.setLayout(new GridLayout(5, 2));
	btnarea.add(randbtn);
	btnarea.add(update);
	btnarea.add(printer);
	btnarea.add(apply);
	btnarea.add(in_lbl);
	btnarea.add(in_txt);
	btnarea.add(out_lbl);
	btnarea.add(out_txt);
	btnarea.add(ignoreBlkBox);
	add(btnarea);

    }

    private class RandomListener implements ActionListener{
	
	private JButton button;
	
	public RandomListener (JButton button) {
	    this.button = button;
	}

	public void actionPerformed (ActionEvent event) {
	    
	    try {
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		ar_txt.setText(decimalFormat.format(Math.random()));
		ab_txt.setText(decimalFormat.format(Math.random()));
		ag_txt.setText(decimalFormat.format(Math.random()));

		br_txt.setText(decimalFormat.format(Math.random()));
		bb_txt.setText(decimalFormat.format(Math.random()));
		bg_txt.setText(decimalFormat.format(Math.random()));

		cr_txt.setText(decimalFormat.format(((int)(Math.random() * 5.)) * 0.5));
		cb_txt.setText(decimalFormat.format(((int)(Math.random() * 5.)) * 0.5));
		cg_txt.setText(decimalFormat.format(((int)(Math.random() * 5.)) * 0.5));

		dr_txt.setText(decimalFormat.format(Math.random()));
		db_txt.setText(decimalFormat.format(Math.random()));
		dg_txt.setText(decimalFormat.format(Math.random()));

	    }
	    catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Unknown error creating values.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	}

    private class PrintListener implements ActionListener{
	
	private JButton button;
	
	public PrintListener (JButton button) {
	    this.button = button;
	}

	public void actionPerformed (ActionEvent event) {
	    
	    try {

			colortoy.printValues();     
	    }
	    catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Unknown error printing values.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	}

    private class ApplyListener implements ActionListener{
	
	private JButton button;
	private LoadImageUtil imageloader;
	
	public ApplyListener (JButton button) {
	    this.button = button;
	}

	public void actionPerformed (ActionEvent event) {

		if(out_txt.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Output file path cannot be blank.", "Error", JOptionPane.ERROR_MESSAGE);
			return;		
		}

		if(in_txt.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Input file path cannot be blank.", "Error", JOptionPane.ERROR_MESSAGE);
			return;		
		}					
	    
	    try {
			imageloader = new LoadImageUtil(in_txt.getText());
			imageloader.applyColorPalette(colortoy, ignoreBlkBox.isSelected());
			imageloader.writeOutImage(out_txt.getText());  
	    }
	    catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Could not apply palette to image.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	}

    private class ButtonListener implements ActionListener{
	
	private JButton button;
	
	public ButtonListener (JButton button) {
	    this.button = button;
	}

	public void actionPerformed (ActionEvent event) {
	    
	    try {

			double a_r, a_g, a_b;
			double b_r, b_g, b_b;
			double c_r, c_g, c_b;
			double d_r, d_g, d_b;

			a_r = Double.parseDouble(ar_txt.getText());
			a_g = Double.parseDouble(ag_txt.getText());
			a_b = Double.parseDouble(ab_txt.getText());
			b_r = Double.parseDouble(br_txt.getText());
			b_g = Double.parseDouble(bg_txt.getText());
			b_b = Double.parseDouble(bb_txt.getText());
			c_r = Double.parseDouble(cr_txt.getText());
			c_g = Double.parseDouble(cg_txt.getText());
			c_b = Double.parseDouble(cb_txt.getText());
			d_r = Double.parseDouble(dr_txt.getText());
			d_g = Double.parseDouble(dg_txt.getText());
			d_b = Double.parseDouble(db_txt.getText());

			colortoy.gotUpdate(a_r, a_g, a_b, b_r, b_g, b_b, c_r, c_g, c_b, d_r, d_g, d_b);     
	    }
	    catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Problem in parsing input fields.  Try Again.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	}
  
}
