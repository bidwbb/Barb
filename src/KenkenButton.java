import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.JButton;

public class KenkenButton extends GenericButton implements ActionListener {
	
    // private Color c = Color.BLUE;
    // private String type;
    // public GameSpota spot;
    public String kenConstraint;

	
    public KenkenButton(Color c, String t, String initContent, String constraint) {
	super(c,t,initContent);
	// this.c = c;
	// this.type = t;
	// this.spot = new GameSpota(t,initContent);
	this.kenConstraint = constraint;
	// this.addActionListener(this);
	// this.addActionListener(spot);	
    }
	   
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	// g.setColor(c);
	// g.drawString(this.spot.spotContent,50,50);
	g.drawString(this.kenConstraint,10,20);
				
    }
	
    // public void actionPerformed(ActionEvent e) {
    // 	this.repaint();
    // }
	
}
