import java.awt.*;


public class Lab8Run {
	
	public static void main(String[] args) {
		
		GameFrame frame = new GameFrame();
		frame.init();
		
		frame.pack();
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(800,800));
		frame.repaint();
		
		// this method must finish and return before GUI handling begins
	}
	
}
