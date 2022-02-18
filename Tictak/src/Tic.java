import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Tic implements ActionListener{
	Random rand = new Random();
	JFrame frame= new JFrame();
	
	JPanel title = new JPanel();
	JPanel button_panel = new JPanel();
	
	JLabel text = new JLabel();
	
	JButton[] buttons = new JButton[9];
	boolean player1_turn;
	
	Tic()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,600);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		text.setBackground(new Color(25,25,25));
		text.setForeground(new Color(255,255,0));
		text.setFont(new Font("Ink Free",Font.BOLD,75));
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setText("Tic-Tac-Toe");
		text.setOpaque(true);
		
		title.setLayout(new BorderLayout());
		title.setBounds(0, 0, 800, 100);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(150,150,150));
		
		for (int i=0;i<9;i++)
		{
			buttons[i]= new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
			
		}
		title.add(text);
		frame.add(title,BorderLayout.NORTH);
		frame.add(button_panel);
		
		first();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<9;i++)
		{
			if(e.getSource()==buttons[i])
			{
				if(player1_turn)
				{
					if(buttons[i].getText()=="")
					{
						buttons[i].setForeground(new Color(255,255,0));
						buttons[i].setText("X");
						player1_turn =false;
						text.setText("O turn");
						check();
					}
				}
				else
				{
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("O");
						player1_turn =true;
						text.setText("X turn");
						check();
					}
				}
			}
		}
		
	}
	
	public void first()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rand.nextInt(2)==0)
		{
			player1_turn =true;
			text.setText("X turn");
		}
		else
		{
			player1_turn = false;
			text.setText("O turn");
		}
		
	}
	
	public void check()
	{
		//check X wins
		if((buttons[0].getText()=="X") && 
				(buttons[1].getText()=="X")&&
				(buttons[2].getText()=="X")) 
		{
			xwins(0, 1, 2);
		}
		if((buttons[3].getText()=="X") && 
				(buttons[4].getText()=="X")&&
				(buttons[5].getText()=="X")) 
		{
			xwins(3, 4, 5);
		}
		if((buttons[6].getText()=="X") && 
				(buttons[7].getText()=="X")&&
				(buttons[8].getText()=="X")) 
		{
			xwins(6,7,8);
		}
		if((buttons[0].getText()=="X") && 
				(buttons[3].getText()=="X")&&
				(buttons[6].getText()=="X")) 
		{
			xwins(0,3,6);
		}
		if((buttons[1].getText()=="X") && 
				(buttons[4].getText()=="X")&&
				(buttons[7].getText()=="X")) 
		{
			xwins(1, 4, 7);
		}
		
		if((buttons[2].getText()=="X") && 
				(buttons[5].getText()=="X")&&
				(buttons[8].getText()=="X")) 
		{
			xwins(2, 5, 8);
		}
		
		if((buttons[0].getText()=="X") && 
				(buttons[4].getText()=="X")&&
				(buttons[8].getText()=="X")) 
		{
			xwins(0, 4, 8);
		}
		if((buttons[2].getText()=="X") && 
				(buttons[4].getText()=="X")&&
				(buttons[6].getText()=="X")) 
		{
			xwins(2, 4, 6);
		}
		
		//check O wins
		if((buttons[0].getText()=="O") && 
				(buttons[1].getText()=="O")&&
				(buttons[2].getText()=="O")) 
		{
			owins(0, 1, 2);
		}
		if((buttons[3].getText()=="O") && 
				(buttons[4].getText()=="O")&&
				(buttons[5].getText()=="O")) 
		{
			owins(3, 4, 5);
		}
		if((buttons[6].getText()=="O") && 
				(buttons[7].getText()=="O")&&
				(buttons[8].getText()=="O")) 
		{
			owins(6,7,8);
		}
		if((buttons[0].getText()=="O") && 
				(buttons[3].getText()=="O")&&
				(buttons[6].getText()=="O")) 
		{
			owins(0,3,6);
		}
		if((buttons[1].getText()=="O") && 
				(buttons[4].getText()=="O")&&
				(buttons[7].getText()=="O")) 
		{
			owins(1, 4, 7);
		}
		
		if((buttons[2].getText()=="O") && 
				(buttons[5].getText()=="O")&&
				(buttons[8].getText()=="O")) 
		{
			owins(2, 5, 8);
		}
		
		if((buttons[0].getText()=="O") && 
				(buttons[4].getText()=="O")&&
				(buttons[8].getText()=="O")) 
		{
			owins(0, 4, 8);
		}
		if((buttons[2].getText()=="O") && 
				(buttons[4].getText()=="O")&&
				(buttons[6].getText()=="O")) 
		{
			owins(2, 4, 6);
		}
	}
	
	public void xwins(int a,int b,int c)
	{
		buttons[a].setBackground(Color.black);
		buttons[b].setBackground(Color.black);
		buttons[c].setBackground(Color.black);
		for(int i=0;i<9;i++)
		{
			buttons[i].setEnabled(false);
		}
		text.setText("X wins");
	}

	public void owins(int a,int b,int c)
	{
		buttons[a].setBackground(Color.red);
		buttons[b].setBackground(Color.red);
		buttons[c].setBackground(Color.red);
		for(int i=0;i<9;i++)
		{
			buttons[i].setEnabled(false);
		}
		text.setText("O wins");
		
	}
	
	

}
