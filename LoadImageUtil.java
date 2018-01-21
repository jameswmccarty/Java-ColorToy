import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class LoadImageUtil extends Component {
          
    private BufferedImage input_img;

    public LoadImageUtil(String infile_name) {
       try {
           input_img = ImageIO.read(new File(infile_name));
       } catch (IOException e) {
		   JOptionPane.showMessageDialog(null, 
				"Could not read input file:" + infile_name, 
				"Error", JOptionPane.ERROR_MESSAGE);
       }
    }

    public Dimension getImageSize() {
        if (input_img == null) {
             return new Dimension(0,0);
        } else {
           return new Dimension(input_img.getWidth(null), input_img.getHeight(null));
       }
    }

	public void applyColorPalette(ColorToyPanel ctp) {
		
		if (input_img == null) {
		   JOptionPane.showMessageDialog(null, 
			 "Input file has not been loaded.", 
		     "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		
		double pixel_normal;
		int acc;
		Color f_value, in_color;	

		for(int x=0;x<input_img.getWidth();x++) {
			for(int y=0;y<input_img.getHeight();y++) {
				in_color = new Color(input_img.getRGB(x, y));
				acc = in_color.getRed();
				acc += in_color.getGreen();
				acc += in_color.getBlue();
				pixel_normal = (double) acc / (255.* 3.);
				f_value = ctp.getColorByNormal(pixel_normal);
				input_img.setRGB(x, y, f_value.getRGB());
			}
		}		
	}

	public void writeOutImage(String outfilename) {

		try {
			File outputfile = new File(outfilename);
			ImageIO.write(input_img, "png", outputfile);
		} catch (IOException e) {
		   JOptionPane.showMessageDialog(null, 
		   "Could not write output file.", 
		   "Error", JOptionPane.ERROR_MESSAGE);
		}
	
	}

}

