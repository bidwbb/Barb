import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame {

    private JPanel panel = new JPanel(new GridLayout(9,9));    
    
    public void init() {

	SudokuGame Sudoku = new SudokuGame();
	
	KenGame Kenken = new KenGame();
	
	LetterGame Letter  = new LetterGame();

	// Exit when window is closed
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	Container ct = getContentPane();
	ct.setPreferredSize(new Dimension(800,800));
	panel.setPreferredSize(new Dimension(600, 600));
	

	ct.setLayout(new FlowLayout());
	
	for (int i=0; i<Sudoku.gameGrid.length;i++){
	    for (int j=0; j<Sudoku.gameGrid.length;j++){
	 	panel.add(Sudoku.gameGrid[i][j]);
	     }
	 }

	//for (int i=0; i<Letter.gameGrid.length;i++){
	 //  for (int j=0; j<Letter.gameGrid.length;j++){
	//	panel.add(Letter.gameGrid[i][j]);
	//   }
	//}
	
	// for (int i=0; i<Kenken.gameGrid.length;i++){
	//     for (int j=0; j<Kenken.gameGrid.length;j++){
	// 	panel.add(Kenken.gameGrid[i][j]);
	//     }
	// }
	
	ct.add(panel);
	
	JButton b = new SolverButton();
	b.setPreferredSize(new Dimension(150,30));
	b.addActionListener(Sudoku);
	ct.add(b);
    }

}
