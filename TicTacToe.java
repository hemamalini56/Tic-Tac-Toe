import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{
	
	Random random=new Random();
	JFrame frame=new JFrame();
	JPanel title_panel=new JPanel();
	JPanel button_panel=new JPanel();
	JLabel textField=new JLabel();
	JButton[] button=new JButton[9];
	boolean player1_turn=true;
	boolean isEmpty=true;
	
	TicTacToe(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textField.setBackground(new Color(25,25,25));
		textField.setForeground(new Color(255,255,255));
		textField.setFont(new Font("Book Antiqua",Font.BOLD,70));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("Tic-Tac-Toe");
		textField.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(150,150,150));
		
		for(int i=0;i<9;i++) {
			button[i]=new JButton();
			button_panel.add(button[i]);
			button[i].setFont(new Font("vm boli",Font.BOLD,75));
			button[i].setFocusable(false);
			button[i].addActionListener(this);
		}
		
		title_panel.add(textField);
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		
		firstTurn();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<9;i++) {
			if(e.getSource()==button[i]) {
				
				if(player1_turn) {
					if(button[i].getText()=="") {
						button[i].setForeground(new Color(255,0,0));
						button[i].setText("O");
						player1_turn=false;
						check();
						textField.setText("X turn");
						check();
					}
				}
				else {
					if(button[i].getText()=="") {
						button[i].setForeground(new Color(0,0,255));
						button[i].setText("X");
						player1_turn=true;
						textField.setText("O turn");
						check();
					}
				}
				
			}
		}
		
		
	}
	
	public void firstTurn() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(random.nextInt()==2) {
			player1_turn=true;
			textField.setText("O turn");
		}
		else {
			player1_turn=false;
			textField.setText("X turn");
		}
	}
	
	public void check() {
		if((button[0].getText()=="X")&&
		(button[1].getText()=="X")&&
		(button[2].getText()=="X")) {
			xwins(0,1,2);
			return;
		}
		if((button[3].getText()=="X")&&
		(button[4].getText()=="X")&&
		(button[5].getText()=="X")) {
			xwins(3,4,5);
			return;
		}
		if((button[6].getText()=="X")&&
		(button[7].getText()=="X")&&
		(button[8].getText()=="X")) {
			xwins(6,7,8);
			return;
		}
		if((button[0].getText()=="X")&&
		(button[3].getText()=="X")&&
		(button[6].getText()=="X")) {
			xwins(0,3,6);
			return;
		}
		if((button[1].getText()=="X")&&
		(button[4].getText()=="X")&&
		(button[7].getText()=="X")) {
			xwins(1,4,7);
			return;
		}
		if((button[2].getText()=="X")&&
		(button[5].getText()=="X")&&
		(button[8].getText()=="X")) {
			xwins(2,5,8);
			return;
		}
		if((button[0].getText()=="X")&&
		(button[4].getText()=="X")&&
		(button[8].getText()=="X")) {
			xwins(0,4,8);
			return;
		}
		if((button[2].getText()=="X")&&
		(button[4].getText()=="X")&&
		(button[6].getText()=="X")) {
			xwins(2,4,6);
			return;
		}
		
		//o wins conditions
		if((button[0].getText()=="O")&&
		(button[1].getText()=="O")&&
		(button[2].getText()=="O")) {
			owins(0,1,2);
			return;
		}
		if((button[3].getText()=="O")&&
		(button[4].getText()=="O")&&
		(button[5].getText()=="O")) {
			owins(3,4,5);
			return;
		}
		if((button[6].getText()=="O")&&
		(button[7].getText()=="O")&&
		(button[8].getText()=="O")) {
			owins(6,7,8);
			return;
		}
		if((button[0].getText()=="O")&&
		(button[3].getText()=="O")&&
		(button[6].getText()=="O")) {
			owins(0,3,6);
			return;
		}
		if((button[1].getText()=="O")&&
		(button[4].getText()=="O")&&
		(button[7].getText()=="O")) {
			owins(1,4,7);
			return;
		}
		if((button[2].getText()=="O")&&
		(button[5].getText()=="O")&&
		(button[8].getText()=="O")) {
			owins(2,5,8);
			return;
		}
		if((button[0].getText()=="O")&&
		(button[4].getText()=="O")&&
		(button[8].getText()=="O")) {
			owins(0,4,8);
			return;
		}
		if((button[2].getText()=="O")&&
		(button[4].getText()=="O")&&
		(button[6].getText()=="O")) {
			owins(2,4,6);
			return;
		}
		
		if(((button[1].getText()=="X")||(button[1].getText()=="O"))&&
		((button[2].getText()=="X")||(button[2].getText()=="O"))&&
		((button[3].getText()=="X")||(button[3].getText()=="O"))&&
		((button[4].getText()=="X")||(button[4].getText()=="O"))&&
		((button[5].getText()=="X")||(button[5].getText()=="O"))&&
		((button[6].getText()=="X")||(button[6].getText()=="O"))&&
		((button[7].getText()=="X")||(button[7].getText()=="O"))&&
		((button[8].getText()=="X")||(button[8].getText()=="O"))&&
		((button[0].getText()=="X")||(button[0].getText()=="O"))){
			textField.setText("IT'S DRAW");
			for(int i=0;i<9;i++)
				button[i].setEnabled(false);
			return;
		}	
		
	}
	
	public void xwins(int a, int b, int c) {
		button[a].setBackground(Color.GREEN);
		button[b].setBackground(Color.GREEN);
		button[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			button[i].setEnabled(false);
		}
		textField.setText("X WINS");
		return;
	}
	
	public void owins(int a, int b, int c) {
		button[a].setBackground(Color.GREEN);
		button[b].setBackground(Color.GREEN);
		button[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			button[i].setEnabled(false);
		}
		textField.setText("O WINS");
		return;
	}

}