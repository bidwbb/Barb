import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.JButton;

public class GenericButton extends JButton implements ActionListener {
	
    private Color c;
    private String type;
    public GameSpota spot;

	
    public GenericButton(Color c, String t, String initContent) {
	this.c = c;
	this.type = t;
	this.spot = new GameSpota(t,initContent);
	this.addActionListener(this);
	this.addActionListener(spot);	
    }
	   
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.setColor(c);
	g.drawString(this.spot.spotContent,50,50);
		
		
    }
	
    public void actionPerformed(ActionEvent e) {
	this.repaint();
    }
	
}
