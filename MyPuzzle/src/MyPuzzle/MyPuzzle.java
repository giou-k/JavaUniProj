package MyPuzzle;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyPuzzle extends java.applet.Applet{

	Button[] play_buttons = new Button[9];
	String[] label_buttons = {"1","2","3","4","5","6","7","8","9"};
	boolean[] button_has_label = {false,false,false,false,false,false,false,false};
	int moves=0;
	JPanel panel_new_game = new JPanel();
	JPanel grid = new JPanel();
	JPanel panel_moves = new JPanel();
	JLabel new_game_label;
	JTextField new_game_text;
	Button new_game_button;
	public void init(){
		setLayout (new GridLayout(3,0));
		panel_new_game.setLayout(new FlowLayout());
		new_game_button = new Button("New Game");
		new_game_button.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent ae){
			moves = 0;
			new_game_text.setText(Integer.toString(moves));
			for(int t = 0; t<8; t++)
				button_has_label[t] = false;
				for(int i = 0; i<8; i++){
					labelVer2:
					for( ; ; ){
						int k = (int)(Math.random()*8);
						if(button_has_label[k] == true){
							continue labelVer2;
						}
						else{
							play_buttons[i].setLabel(label_buttons[k]);
							button_has_label[k] = true;
							break;
						}
					}
				}
				boolean telos = false;
				for(int i = 0; i < 9; i++){
					for(int j = 0; j < 9; j++){
						if(i!= j && play_buttons[i].getLabel()== play_buttons[j].getLabel()){
							play_buttons[i].setLabel(" ");
							telos = true;
							break;
						}
						if (telos == true)
						return;
					}
				}
			}
		});

		panel_new_game.add(new_game_button);
		grid.setLayout(new GridLayout(3,3));
		panel_moves.setLayout(new FlowLayout());
		new_game_label = new JLabel("Moves");
		new_game_text = new JTextField(3);
		panel_moves.add(new_game_label);
		panel_moves.add(new_game_text);
		add(panel_new_game);
		add(grid);
		add(panel_moves);
		for(int i = 0; i < 9; i++)
		{
			play_buttons[i] = new Button();
			grid.add(play_buttons[i]);
		}
		for(int i = 0; i < 8; i++)
		{
			labelVer:
			for( ; ;)
			{
				int k = (int)(Math.random()*8);
				if(button_has_label[k])
				{
					continue labelVer;
				}
				else
				{
					play_buttons[i].setLabel(label_buttons[k]);
					button_has_label[k] = true;
					break;
				}
			}
		}

		moves = 0;
		new_game_text.setText(Integer.toString(moves));
		for(int i = 0; i < 9; i++)
		{
			play_buttons[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					if((ae.getSource()).equals(play_buttons[0]))
					{
						move_button(0,1);
						move_button(0,3);
					}
					if((ae.getSource()).equals(play_buttons[1]))
					{
						move_button(1,0);
						move_button(1,4);
						move_button(1,2);
					}
					if((ae.getSource()).equals(play_buttons[2]))
					{
						move_button(2,1);
						move_button(2,5);
					}
					if((ae.getSource()).equals(play_buttons[3]))
					{
						move_button(3,0);
						move_button(3,4);
						move_button(3,6);
					}
					if((ae.getSource()).equals(play_buttons[4]))
					{
						move_button(4,1);
						move_button(4,3);
						move_button(4,5);
						move_button(4,7);
					}
					if((ae.getSource()).equals(play_buttons[5]))
					{
						move_button(5,2);
						move_button(5,4);
						move_button(5,8);
					}
					if((ae.getSource()).equals(play_buttons[6]))
					{
						move_button(6,3);
						move_button(6,7);
					}
					if((ae.getSource()).equals(play_buttons[7]))
					{
						move_button(7,4);
						move_button(7,6);
						move_button(7,8);
					}
					if((ae.getSource()).equals(play_buttons[8])){
						move_button(8,7);
						move_button(8,5);
					}
				}
			});
		}
		setSize(300,300);
		setVisible(true);
	}
	
	public void start(){}

	public void move_button(int x, int y)
	{
		if((play_buttons[y].getLabel()).equals(" "))
		{
			play_buttons[y].setLabel(play_buttons[x].getLabel());
			play_buttons[x].setLabel("");
			moves++;
			new_game_text.setText(Integer.toString(moves));
			check();
		}
	}

	public void check()
	{
		int k;
		boolean end = true;
		for(int i=0; i<8; i++)
		{
		if(play_buttons[i].getLabel().equals(" "))
		return;
		k = Integer.parseInt(play_buttons[i].getLabel());
		if(k!=i+1)
		end = false;
		}
		if(end == true)
		JOptionPane.showMessageDialog(null,"Well Done!!");
	}
	public static void main(String [] args){
		MyPuzzle f1=new MyPuzzle();
	}

}