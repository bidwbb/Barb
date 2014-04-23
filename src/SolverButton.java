import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;

public class SolverButton extends JButton implements ActionListener {
	
	private Color c = Color.BLACK;
	
	public SolverButton() {

	}
	

	public void paintComponent(Graphics g) {

	    g.drawString("Solve Puzzle",30,20);
		
	}


	
	public void actionPerformed(ActionEvent e) {
	}
	
}
