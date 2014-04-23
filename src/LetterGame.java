import java.util.Vector;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LetterGame implements GameInterface,ActionListener{
    public Vector<ConstraintInterface> constraints = new Vector<ConstraintInterface>();
    public GenericButton[][] gameGrid = new GenericButton[8][8];
     public String[] possibleValues = new String [] {"","A","B","C","D"};
    
    public boolean checkConstraints(){
	for (int x=0;x<this.constraints.size();x++){
	    if (!(constraints.elementAt(x).fitsConstraint())){
		return false;
	    }
	}
	return true;
    }
    
    public void setConstraint(int coordX, int coordY,int sizeX, int sizeY){
	ConstraintInterface toAdd = new GenericConstraint(gameGrid, coordX, coordY, sizeX, sizeY);
	constraints.add(toAdd);
    }

    public boolean tempConstraints(){
	for (int x=0;x<this.constraints.size();x++){
	    if (!(constraints.elementAt(x).mightConstraint())){
		return false;
	    }
	}
	return true;
    }

    public void setLetter(int coordX, int coordY,int sizeX, int sizeY, int space, String letter){
	ConstraintInterface toAdd = new LetterConstraint(gameGrid, coordX, coordY, sizeX, sizeY, space, letter);
	constraints.add(toAdd);
    }
    
    public GenericButton[][] getGameGrid(){
	return this.gameGrid;
    }

    public void setGameGrid(GenericButton[][] toSet){
	this.gameGrid=toSet;
    }

    public LetterGame(){
	Color c = Color.BLACK;
	this.gameGrid[0][0]=new GenericButton(c, "lettergame"," ");
	this.gameGrid[0][1]=new GenericButton(c, "lettergame","A2");
	this.gameGrid[0][2]=new GenericButton(c, "lettergame","C2");
	this.gameGrid[0][3]=new GenericButton(c, "lettergame"," ");
	this.gameGrid[0][4]=new GenericButton(c, "lettergame","A1");
	this.gameGrid[0][5]=new GenericButton(c, "lettergame","C2");
	this.gameGrid[0][6]=new GenericButton(c, "lettergame"," ");
	this.gameGrid[0][7]=new GenericButton(c, "lettergame"," ");
	this.gameGrid[1][0]=new GenericButton(c, "lettergame","C1");
	this.gameGrid[1][1]=new GenericButton(c, "lettergame","");
	this.gameGrid[1][2]=new GenericButton(c, "lettergame","");
	this.gameGrid[1][3]=new GenericButton(c, "lettergame","");
	this.gameGrid[1][4]=new GenericButton(c, "lettergame","");
	this.gameGrid[1][5]=new GenericButton(c, "lettergame","");
	this.gameGrid[1][6]=new GenericButton(c, "lettergame","");
	this.gameGrid[1][7]=new GenericButton(c, "lettergame"," ");
	this.gameGrid[2][0]=new GenericButton(c, "lettergame","D2");
	this.gameGrid[2][1]=new GenericButton(c, "lettergame","");
	this.gameGrid[2][2]=new GenericButton(c, "lettergame","");
	this.gameGrid[2][3]=new GenericButton(c, "lettergame","");
	this.gameGrid[2][4]=new GenericButton(c, "lettergame","");
	this.gameGrid[2][5]=new GenericButton(c, "lettergame","");
	this.gameGrid[2][6]=new GenericButton(c, "lettergame","");
	this.gameGrid[2][7]=new GenericButton(c, "lettergame","B2");
	this.gameGrid[3][0]=new GenericButton(c, "lettergame"," ");
	this.gameGrid[3][1]=new GenericButton(c, "lettergame","");
	this.gameGrid[3][2]=new GenericButton(c, "lettergame","");
	this.gameGrid[3][3]=new GenericButton(c, "lettergame","");
	this.gameGrid[3][4]=new GenericButton(c, "lettergame","");
	this.gameGrid[3][5]=new GenericButton(c, "lettergame","");
	this.gameGrid[3][6]=new GenericButton(c, "lettergame","");
	this.gameGrid[3][7]=new GenericButton(c, "lettergame","D1");
	this.gameGrid[4][0]=new GenericButton(c, "lettergame","A2");
	this.gameGrid[4][1]=new GenericButton(c, "lettergame","");
	this.gameGrid[4][2]=new GenericButton(c, "lettergame","");
	this.gameGrid[4][3]=new GenericButton(c, "lettergame","");
	this.gameGrid[4][4]=new GenericButton(c, "lettergame","");
	this.gameGrid[4][5]=new GenericButton(c, "lettergame","");
	this.gameGrid[4][6]=new GenericButton(c, "lettergame","");
	this.gameGrid[4][7]=new GenericButton(c, "lettergame"," ");
	this.gameGrid[5][0]=new GenericButton(c, "lettergame","C1");
	this.gameGrid[5][1]=new GenericButton(c, "lettergame","");
	this.gameGrid[5][2]=new GenericButton(c, "lettergame","");
	this.gameGrid[5][3]=new GenericButton(c, "lettergame","");
	this.gameGrid[5][4]=new GenericButton(c, "lettergame","");
	this.gameGrid[5][5]=new GenericButton(c, "lettergame","");
	this.gameGrid[5][6]=new GenericButton(c, "lettergame","");
	this.gameGrid[5][7]=new GenericButton(c, "lettergame"," ");
	this.gameGrid[6][0]=new GenericButton(c, "lettergame","B1");
	this.gameGrid[6][1]=new GenericButton(c, "lettergame","");
	this.gameGrid[6][2]=new GenericButton(c, "lettergame","");
	this.gameGrid[6][3]=new GenericButton(c, "lettergame","");
	this.gameGrid[6][4]=new GenericButton(c, "lettergame","");
	this.gameGrid[6][5]=new GenericButton(c, "lettergame","");
	this.gameGrid[6][6]=new GenericButton(c, "lettergame","");
	this.gameGrid[6][7]=new GenericButton(c, "lettergame"," ");
	this.gameGrid[7][0]=new GenericButton(c, "lettergame"," ");
	this.gameGrid[7][1]=new GenericButton(c, "lettergame"," ");
	this.gameGrid[7][2]=new GenericButton(c, "lettergame"," ");
	this.gameGrid[7][3]=new GenericButton(c, "lettergame","A1");
	this.gameGrid[7][4]=new GenericButton(c, "lettergame"," ");
	this.gameGrid[7][5]=new GenericButton(c, "lettergame","A1");
	this.gameGrid[7][6]=new GenericButton(c, "lettergame","D1");
	this.gameGrid[7][7]=new GenericButton(c, "lettergame"," ");
      
	for (int i=1;i<7;i++){
	    this.setConstraint(0,i,1,6);
	}
	for (int i=1; i<7;i++){
	    this.setConstraint(i,0,6,1);
	}
	
	this.setLetter(1,1,6,1,1,"C");
	this.setLetter(2,1,6,1,2,"D");
	this.setLetter(2,1,6,1,3,"B");
	this.setLetter(3,1,6,1,4,"D");
	this.setLetter(4,1,6,1,2,"A");
	this.setLetter(5,1,6,1,1,"C");
	this.setLetter(6,1,6,1,1,"B");

	this.setLetter(1,1,1,6,2,"A");
	this.setLetter(1,2,1,6,2,"C");
	this.setLetter(1,3,1,6,4,"A");
	this.setLetter(1,4,1,6,1,"A");
	this.setLetter(1,5,1,6,4,"A");
	this.setLetter(1,5,1,6,2,"C");
	this.setLetter(1,6,1,6,4,"D");
	
	
    }

    public void actionPerformed(ActionEvent e){
	this.label(0,0,this.gameGrid,this,possibleValues);
	for (int i = 0; i < this.gameGrid.length;i++)
	    for (int j = 0; j < this.gameGrid.length;j++)
		this.gameGrid[i][j].repaint();
    }

    public boolean label(int i, int j, GenericButton[][]spots, GameInterface game, String[] possibleValues){
	System.out.println("the coords are" + i + "," + j);
		
	if ((i==spots.length-1)&&(j==spots.length-1)) return game.checkConstraints();
	
	if (!(spots[i][j].spot.changeable)){
	    if (j==spots.length-1){
		if (label(i+1,0, spots, game, possibleValues)){
		    return true;
		}
	    }
	    else if (label(i,j+1, spots, game, possibleValues)){
		return true;
	    }		
	}
	String hold=spots[i][j].spot.spotContent;
       	for(int num=0; num<possibleValues.length; num++){
	    spots[i][j].spot.spotContent=possibleValues[num];
	    boolean check = game.tempConstraints();
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
