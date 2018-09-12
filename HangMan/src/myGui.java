import java.awt.*;

import com.sun.java.swing.*;

import java.awt.event.*;

import javax.swing.*;

public class myGui extends JFrame implements ActionListener{
	private JLabel lIn;
	private JLabel lOut;
	private JTextField tIn;
	private String guess;
	private char g;
	private boolean gameOver = false;
	KeyListener k;
	
	public myGui(){
		
		
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				dispose();
			}
		});
		setLayout(new FlowLayout(20));
		
		lIn = new JLabel("Enter in a single letter");
		add(lIn);
		
		tIn = new JTextField(5);
		add(tIn);
		tIn.addActionListener(this);
		
		JButton butt = new JButton("Guess Word");
		butt.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				lIn.setText("Enter in the word");
				tIn.setText("");
				
				revalidate();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
				
				
		});

		add(butt);
		
		lOut = new JLabel("Remember: Just one character!");
		add(lOut);
		lOut.setText("");
		
		this.setTitle("Hangman Guesser Tool");
		setSize(350,120);
		setLocationRelativeTo(null);
		setVisible(true);
		//Only read in the first letter displayed
		
	}
	
//	private void guessLetter(){
//		lIn.setText("Enter in a single letter");
//		tIn.setText("");
//		revalidate();
//	}
	
	public boolean guessWord(){
		lIn.setText("Enter in the word");
		tIn.setText("");
		revalidate();
		return true;
	}
//	KeyListener keys = new KeyListener(){
//		@Override
//		public void keyPressed(KeyEvent e) {
//			//If its not the enter key, and not the first key pressed, then
//			if(e.getKeyCode()!=10 && tIn.getText().length() > guess.length()){
//				tIn.equals(guess);
//			}
//			else if(tIn.getText().length()==0 && e.getKeyCode()==10){
//				return;
//			}
//			else
//				guess.equals(tIn.getText());
//		}
//
//		@Override
//		public void keyReleased(KeyEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void keyTyped(KeyEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//	};
	
	public void displayFalse(int guesses){
		lOut.setText("Wrong! You have "+guesses+" guesses left!");
		revalidate();
	}
	public void displayTrue(){
		lOut.setText("Good job, you got it!");
		revalidate();
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		char co = tIn.getText().charAt(0);
		if(tIn.getText().equals("") || !Character.isLetter(co)){
			lOut.setText("You must enter a letter!");
			tIn.setText("");
			revalidate();
		}
		else{
			lOut.setText("");
			guess = tIn.getText();
			guess = guess.toUpperCase();
			g = guess.charAt(0);
			tIn.setText("");
			revalidate();
			System.out.println(g);
		}
	}
}
