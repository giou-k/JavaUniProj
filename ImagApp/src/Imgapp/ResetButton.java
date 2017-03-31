package Imgapp;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class ResetButton implements ActionListener{

	private JLabel t1;
	public int width1,height1;
	private Dimension d;
	private ImageIcon im1;
	private JTextField p1;
	private JTextField p2;

	public ResetButton( JLabel f, ImageIcon k,int i,int j,JTextField T1,JTextField T2){
		t1=f;
		im1=k;
		width1=i;
		height1=j;
		p1=T1;
		p2=T2;
	}

	public void actionPerformed(ActionEvent a){
		String label=a.getActionCommand();
		int setwidth;
		int setheight;
		String Text1,Text2;
		if (label.equals("AlignLeft"))
			t1.setHorizontalAlignment(SwingConstants.LEFT);
		else if (label.equals("AlignCentre"))
			t1.setHorizontalAlignment(SwingConstants.CENTER);
		else if (label.equals("AlignRight"))
			t1.setHorizontalAlignment(SwingConstants.RIGHT);
		else if (label.equals("resize")){
			setwidth=Integer.parseInt(p1.getText());
			setheight=Integer.parseInt(p2.getText());
			Image img = im1.getImage();
			BufferedImage bi = new BufferedImage(setwidth,setheight,BufferedImage.TYPE_INT_ARGB);
			Graphics g = bi.createGraphics();
			g.drawImage(img, 0, 0, setwidth, setheight, null);
			ImageIcon newIcon = new ImageIcon(bi);
			t1.setIcon(newIcon);
		}
		else if (label.equals("Reset")){
			Image img = im1.getImage();
			BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null),BufferedImage.TYPE_INT_ARGB);
			Graphics g = bi.createGraphics();
			g.drawImage(img, 0, 0, width1, height1, null);
			ImageIcon newIcon = new ImageIcon(bi);
			t1.setIcon(newIcon);
			p1.setText(""+width1);
			p2.setText(""+height1);
		}
	}
}