

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JumbleFrame extends JFrame {
	String lang="English";// start off without a language
	
	// all the languages that have been loaded up.  Maybe only need
	// one LanguageMap at a time, but can change that later
	Set<LanguageMap> languageMaps = new HashSet<LanguageMap>();
	
	
	
	public JumbleFrame() {
		super("Let's solve the Jumble!");// title the bar
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ALWAYS DO THIS
		addMenuBar();// just wanted to show you how to make a menu bar
		addSplashPanel();// start screen you can add your trademark images
		pack();// make sure the frame is just big enough to show all components
		
	}

	private void addSplashPanel() {
		// Things are typically added to the content pane
		// Opening Screen could include animations, etc.  
		// it is a type of JPanel
		this.getContentPane().add(new OpeningScreen());
	}

	private void addMenuBar() {
		// built-in Object that behaves like typical menu bar.  This behavior
		// could change based on the OS of the machine it is running on.
		JMenuBar jmb = new JMenuBar();
		this.setJMenuBar(jmb);
		// this File menu is just like most applications have 
		JMenu fileMenu = new JMenu("File");
		jmb.add(fileMenu);
		// Menu Items are added to Menus which are on the MenuBar
		// You can add menu items to menu items...
		JMenuItem newPuzzle = new JMenuItem("New Jumble");
		// when the user selects the newPuzzle Menu Item, it tells 
		// everyone in its ActionListenerList to do their actionPerformed event
		// We know they all have actionPerformed, because they implement ActionListener
		// We know they implement ActionListener because they couldn't have been added to
		// the list unless they did...
		newPuzzle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// when someone clicks on the newPuzzle MenuItem this method is called
				if(lang==null) {// check to see if they have already loaded up a language
					JOptionPane.showMessageDialog(null, 
							"Select a language first!");
					return;
				}
				// here might be a good time to change the device
				// keyboard to match the language :)
				loadJumblePanel();
				
			}
			
		});
		fileMenu.add(newPuzzle);// adds to the File Menu
		
		// a menu for choosing the language of the puzzle
		JMenu languageMenu = new JMenu("Language");
		jmb.add(languageMenu);
		
		// menu for English
		JMenu englishMenu = new JMenu("English");
		
		// this adds a menu to a menu. Only do this if you want submenus
		languageMenu.add(englishMenu); 
		
		// now I'll make a menu item for a type of English
		JMenuItem kingsEnglishMenuItem = new JMenuItem("King's English");
		kingsEnglishMenuItem.addActionListener(new ActionListener() {
			// When user selects this menu Item (or any...) languageSelected is called
			@Override
			public void actionPerformed(ActionEvent arg0) {
				languageSelected("English");
			}
			
		});
		englishMenu.add(kingsEnglishMenuItem);
		
		// Made one for kings english, lets make one for Aussie
		JMenuItem aussieMenuItem = new JMenuItem("Australian!");
		aussieMenuItem.addActionListener(new ActionListener() {
			// When user selects this menu Item (or any...) languageSelected is called
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Crikey mate!  Haven't finished that yet... \nToo many shrimp on the barbie!"+
									"\nTry again next version!");
			}
			
		});
		englishMenu.add(aussieMenuItem);
		
		// Obviously, you can add many languages this way.  Because these
		// JMenuItems have no ActionListeners associated with them, nothing
		// happens when you select them
		languageMenu.add(new JMenuItem("Spanish"));
		languageMenu.add(new JMenuItem("Farsi"));
	}

	protected void loadJumblePanel() {
		// Here is where you would load up the JumblePanel/JumbleView
		Dimension d=this.getContentPane().getComponent(0).getPreferredSize();
		this.getContentPane().removeAll();
		
		//LanguageMap map = getCurrentLanguage();
		LanguageMap map = new LanguageMap("English", null);
		JumblePanel jp = new JumblePanel(map);
		jp.setPreferredSize(d);
		jp.loadDictionary();
		this.getContentPane().add(jp);
		pack();
		validate();
		Font font = new Font("Comic Sans MS", Font.PLAIN, 50);
		JTextField textBox = new JTextField(20);
		textBox.setSize(400, 100);
		textBox.setLocation(0, 0);
		textBox.setFont(font);
		textBox.setText("Input word here");
		
		JTextField textBox2 = new JTextField(20);
		textBox2.setSize(400, 100);
		textBox2.setLocation(0, 225);
		textBox2.setFont(font);
		textBox2.setText("Input word here");
		
		JTextField textBox3 = new JTextField(20);
		textBox3.setSize(400, 100);
		textBox3.setLocation(0, 450);
		textBox3.setFont(font);
		textBox3.setText("Input word here");
		
		JTextField textBox4 = new JTextField(20);
		textBox4.setSize(400, 100);
		textBox4.setLocation(0, 675);
		textBox4.setFont(font);
		textBox4.setText("Input word here");
		
		jp.add(textBox);
		jp.add(textBox2);
		jp.add(textBox3);
		jp.add(textBox4);
		
		JTextField answerBox = new JTextField();
		answerBox.setSize(1000, 200);
		answerBox.setLocation(500, 0);
		answerBox.setFont(font);
		answerBox.setText("Answer will appear here");

		JTextField answerBox2 = new JTextField();
		answerBox2.setSize(1000, 200);
		answerBox2.setLocation(500, 225);
		answerBox2.setFont(font);
		answerBox2.setText("Answer will appear here");

		JTextField answerBox3 = new JTextField();
		answerBox3.setSize(1000, 200);
		answerBox3.setLocation(500, 450);
		answerBox3.setFont(font);
		answerBox3.setText("Answer will appear here");
		
		JTextField answerBox4 = new JTextField();
		answerBox4.setSize(1000, 200);
		answerBox4.setLocation(500, 675);
		answerBox4.setFont(font);
		answerBox4.setText("Answer will appear here");
		
		jp.add(answerBox);
		jp.add(answerBox2);
		jp.add(answerBox3);
		jp.add(answerBox4);
		
		
		JButton button = new JButton();
		button.setFont(font);
		button.setText("Solve");
		button.setSize(400, 100);
		button.setLocation(0, 850);
		jp.add(button);
		
	      button.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	  String one = jp.solve(alphabetize(textBox.getText()));
	        	  String two = jp.solve(alphabetize(textBox2.getText()));
	        	  String three = jp.solve(alphabetize(textBox3.getText()));
	        	  String four = jp.solve(alphabetize(textBox4.getText()));
	        	  
	        	  System.out.println(one + "one");
	        	  System.out.println(two + "two");
	        	  System.out.println(three + "three");
	        	  System.out.println(four + "four");
	        	  
	        	  answerBox.setText(one);
	        	  answerBox2.setText(two);
	        	  answerBox3.setText(three);
	        	  answerBox4.setText(four);
	        	  
	          }          
	       });
		
		
		repaint();
		
		
	}

	public String alphabetize(String a){
		char[] chars = a.toCharArray();
		Arrays.sort(chars);
		String alphabetized = new String(chars);
		alphabetized.toLowerCase();
		return alphabetized;
	}
	
	private LanguageMap getCurrentLanguage() {
		// TODO Auto-generated method stub
		return null;
	}

	protected void languageSelected(String string) {
		this.lang=string;
		// check to see if any LanguageMaps have this language
		for(LanguageMap lm:this.languageMaps) {
			if(lm.getLanguage().equals(string))
				return;// this language has already been loaded
		}
		// new language, so construct a new LanguageMap and add it 
		// to the languageMaps ...  This involves reading from a file,
		// so you don't want to repeat this and you don't want to load
		// up languages that may not be needed
		
		
	}
}
