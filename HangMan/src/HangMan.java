import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class HangMan {
	String word;
	int randy = 0;
	File f;
	Scanner s;
	public void start() {
		wordCountDev();
		myGui m = new myGui();
		promptForWord();
		startGui();
		while(!won() && !lost()) {
			displayStatus();
			promptForGuessChoice();
			
			guessLetter();// asks the user for a letter
			guessWord();//asks the user if they want to guess the word
			
			wordCorrect();// checks to see if the letter matches or not
			
		}
		
		displayResults();
		boolean again = playAgain();
		if(again)
			start();
		else
			goodBye();
	}
	
	private void wordCountDev() {
		try{
			f = new File("dictionary.txt");
			s = new Scanner(f);
			while(s.hasNextLine()){
				randy++;
				s.next();
			}
				System.out.println(randy);
		}
		catch(FileNotFoundException g){
			System.out.println(g.getMessage());
		}
	}

	private void promptForWord() {
		List<String> optionList = new ArrayList<String>();
		optionList.add("<Select Below>");
		optionList.add("One Player");	
		optionList.add("Two Players");
		Object[] options = optionList.toArray();
		Object value = JOptionPane.showInputDialog(null, "How many players?", "input box", 0, null, options, 0);
		int index = optionList.indexOf(value);
		if(index == 1){
			randomSearch();
		}
		else if(index == 2){
			getWord();
		}
		else
			System.out.println("You need to choose an option.");
	}

	private void randomSearch() {
		Random r = new Random();
		int newb = r.nextInt(randy);
		try {
			s = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for(int l = newb; l > 0; l--){
			word = s.next();
			word = word.toUpperCase();
		}
	}

	private void getWord() {
		JOptionPane j = new JOptionPane();
		word = j.showInputDialog("Enter in a word from the dictionary");
		word = word.toUpperCase();
	}

	private void startGui() {
		Panel p = new Panel();
		p.setLayout(new FlowLayout());
		Button btn = new Button();
		p.add(btn);
		p.setVisible(true);
		
	}
	private boolean lost() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean won() {
		// TODO Auto-generated method stub
		return false;
	}

	

	private void goodBye() {
		// TODO Auto-generated method stub
		
	}

	private boolean playAgain() {
		// TODO Auto-generated method stub
		return false;
	}

	private void displayResults() {
		// TODO Auto-generated method stub
		
	}

	private void wordCorrect() {
		
	}

	private void guessWord() {
		//String s = JOptionPane.showInputDialog("Heaven smiles above me");
		
	}

	private void guessLetter() {
		// TODO Auto-generated method stub
		
	}

	private void promptForGuessChoice() {
		// TODO Auto-generated method stub
		
	}

	private void displayStatus() {
		// TODO Auto-generated method stub
		
	}

}
