import java.util.Vector;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SudokuGame implements GameInterface,ActionListener{
    public GenericButton[][] gameGrid = new GenericButton[9][9];
    public Vector<ConstraintInterface> constraints = new Vector<ConstraintInterface>();
    public String[] possibleValues = new String []{"1","2","3","4","5","6","7","8","9"};



    public boolean checkConstraints(){
	for (int x=0;x<this.constraints.size();x++){
	    if (!(constraints.elementAt(x).fitsConstraint())){
		return false;
	    }
	}
	return true;
    }

    public boolean tempConstraints(){
	for (int x=0;x<this.constraints.size();x++){
	    if (!(constraints.elementAt(x).mightConstraint())){
		return false;
	    }
	}
	return true;
    }
    
    public void setConstraint(int coordX, int coordY,int sizeX, int sizeY){
	GenericConstraint toAdd = new GenericConstraint(gameGrid, coordX, coordY, sizeX, sizeY);
	constraints.add(toAdd);
    }
    
    public GenericButton[][] getGameGrid(){
	return this.gameGrid;
    }

    public void setGameGrid(GenericButton[][] toSet){
	this.gameGrid=toSet;
    }

    public SudokuGame(){
	File f = new File("Sudoku.sudoku");
	Scanner sc = null;
	try{
	    sc = new Scanner(f);
	}
	catch (FileNotFoundException e){
	    e.printStackTrace();
	    System.out.println("File doesn't exist");
	    System.exit(1);
	}
	Color c = Color.BLACK;
	for (int i=0;i<9;i++){
	    for (int j=0;j<9;j++){
		String temp=sc.next();
		if (temp.equals("_")) temp="";
		gameGrid[i][j]=new GenericButton(c, "sudoku", temp);
	    }
	}
	for (int i=0;i<9;i++){
	    this.setConstraint(0,i,9,1);
	}
	for (int i=0; i<9;i++){
	    this.setConstraint(i,0,1,9);
	}

	for (int i=0; i<9;i+=3){
	    for (int j=0; j<9;j+=3){
		 this.setConstraint(i,j,3,3);
	     }
	}
	
    }
    
    public void actionPerformed(ActionEvent e){
	this.label(0,0,this.gameGrid,this,possibleValues);
	for (int i = 0; i < this.gameGrid.length;i++)
	    for (int j = 0; j < this.gameGrid.length;j++)
		this.gameGrid[i][j].repaint();
    }

    public boolean label(int i, int j, GenericButton[][]spots, GameInterface game, String[] possibleValues){
    	boolean wordy = (j<4 && i < 8);
    	if (wordy) System.out.println("the coords are " + i + "," + j);

    	if (i>=spots.length) return game.checkConstraints();

    	if (!(spots[i][j].spot.changeable)){
    		if (wordy) System.out.println("   Fixed at " + spots[i][j].spot.spotContent);
    		if (j==spots.length-1){
    			if (label(i+1,0, spots, game, possibleValues)){
    				if (wordy) System.out.println("  Found solution at " + (i+1) + ",0");
    				return true;
    			}
    			else {
    				if (wordy) System.out.println("  Did not find solution at " + (i+1) + ",0");
    				return false;	
    			}
    		}
    		else if (label(i,j+1, spots, game, possibleValues)){
    			if (wordy) System.out.println("  Found solution at " + i + "," + (j+1));
    			return true;
    		}	
    		else {
    			if (wordy) System.out.println("  Did not find solution at " + i + "," + (j+1));
    			return false;
    		}
    	}

    	String hold=spots[i][j].spot.spotContent;
    	if (wordy) System.out.println("   Open spot at " + i + "," + j + " with contents " + hold);
    	for(int num=0; num<possibleValues.length; num++){
    		spots[i][j].spot.spotContent=possibleValues[num];
    		boolean check = game.tempConstraints();
    		if (wordy) System.out.println("   Tried " + possibleValues[num] + " at " + i + "," + j + ": " + check);
    		if (check){
    			if (j==spots.length-1){
    				if (label(i+1,0, spots, game, possibleValues)){
    					return true;
    				}
    			}
    			else if (label(i,j+1, spots, game, possibleValues)){
    				return true;
    			}
    		}	
    	}
    	spots[i][j].spot.spotContent=hold;
    	return false;
    }
}		
