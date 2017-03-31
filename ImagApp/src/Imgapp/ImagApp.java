package Imgapp;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ImagApp extends JFrame {

	private JButton AlignLeft,AlignCentre,AlignRight,Resize;
	private JLabel width,height;
	public static int Iwidth,IHeight;
	protected ImageIcon apple;
	protected JPanel centre;
	protected JMenuItem reset;
	protected JTextField text1,text2;

	public ImagApp(String title){
		super(title);
		Container contentPane=this.getContentPane();
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		AlignLeft= new JButton ("AlignLeft");
		AlignCentre =new JButton("AlignCentre");
		AlignRight=new JButton("AlignRight");
		JPanel north=new JPanel();
		north.add(AlignLeft);
		north.add(AlignCentre);
		north.add(AlignRight);
		contentPane.add(north,BorderLayout.NORTH);
		ImageIcon apple= createImageIcon("vercrew.jpg");
		Iwidth=apple.getIconWidth();
		IHeight=apple.getIconHeight();
		JLabel c1=new JLabel(null,apple,SwingConstants.CENTER);
		contentPane.add(c1,BorderLayout.CENTER);
		JPanel south=new JPanel();
		GridLayout g1=new GridLayout(3,2);
		south.setLayout(g1);
		JLabel width=new JLabel("width:",SwingConstants.LEFT);
		JTextField text1=new JTextField(""+apple.getIconWidth());
		JLabel height=new JLabel("height:",SwingConstants.LEFT);
		JTextField text2=new JTextField(""+apple.getIconHeight());
		JButton resize=new JButton("resize");
		south.add(width);
		south.add(text1);
		south.add(height);
		south.add(text2);
		south.add(resize);
		contentPane.add(south,BorderLayout.SOUTH);
		JMenuBar menubar= new JMenuBar();
		this.setJMenuBar(menubar);
		JMenu m1=new JMenu("Options");
		menubar.add(m1);
		JMenuItem reset=new JMenuItem("Reset");
		m1.add(reset);
		ResetButton changer=new ResetButton(c1,apple,Iwidth,IHeight,text1,text2);
		reset.addActionListener(changer);
		text1.addActionListener(changer);
		resize.addActionListener(changer);
		AlignLeft.addActionListener(changer);
		AlignCentre.addActionListener(changer);
		AlignRight.addActionListener(changer);
		repaint();
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = ImagApp.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		}
		else {
			System.err.println("Couldn't find file: " + path);
		return null;
		}
	}

	public void actionPerformed(ActionEvent a){
		Object source =a.getSource();
		if (source==reset)
		text1.setText(""+Iwidth);
		repaint();
	}
	
	public static void main(String [] args){
		ImagApp f1=new ImagApp("Image Application");
		f1.pack();
		f1.setVisible(true);
	}
}