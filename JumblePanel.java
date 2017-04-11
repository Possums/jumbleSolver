import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

import javax.swing.JPanel;


public class JumblePanel extends JPanel {

	LanguageMap map;
	public JumblePanel(LanguageMap map) {
		this.map = map;	
		this.setBackground(new Color(100,200,150));// just to make sure we can change...
	}

	public void loadDictionary(){
		map.scan();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawRect(0, 0, 400, 100);
		g.drawRect(500, 0, 1000, 200);
		
		g.drawRect(0, 225, 400, 100);
		g.drawRect(500, 225, 1000, 200);
		
		g.drawRect(0, 450, 400, 100);
		g.drawRect(500, 450, 1000, 200);
		
		g.drawRect(0, 675, 400, 100);
		g.drawRect(500, 675, 1000, 200);
		
	}
	
	public String solve(String one){
		return map.getString(one);
	}
	
	public String alphabetize(String a){
		char[] chars = a.toCharArray();
		Arrays.sort(chars);
		String alphabetized = new String(chars);
		alphabetized.toLowerCase();
		return alphabetized;
	}


}
