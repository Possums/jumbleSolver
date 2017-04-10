import java.awt.Color;
import java.awt.Graphics;

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
		
		g.drawRect(0, 50, 500, 100);
		for (int i=1; i<6; i++){
			g.drawRect(100*i, 150, 100, 100);
			if (i == 2 || i==4 || i==5){
				g.drawOval(100*i, 150, 100, 100);
			}
		}
		
		g.drawRect(0, 300, 500, 100);
		for (int i=1; i<6; i++){
			g.drawRect(100*i, 400, 100, 100);
			if (i == 3 || i==4){
				g.drawOval(100*i, 400, 100, 100);
			}
		}
		
	}

}
