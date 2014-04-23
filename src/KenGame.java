import java.util.Vector;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KenGame implements GameInterface,ActionListener{
    public GenericButton[][] gameGrid = new GenericButton[4][4];
    public Vector<ConstraintInterface> constraints = new Vector<ConstraintInterface>();
    public String[] possibleValues = new String [] {"1","2","3","4"};
    
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

    public void setKen(int coordX1, int coordY1, int coordX2, int coordY2, int total, String operation){
	KenConstraint toAdd = new KenConstraint(gameGrid,  coordX1, coordY1, coordX2, coordY2, total, operation);
    	constraints.add(toAdd);
    }
    
    public GenericButton[][] getGameGrid(){
	return this.gameGrid;
    }

    public void setGameGrid(GenericButton[][] toSet){
	this.gameGrid=toSet;
    }
    
    public KenGame(){
	this.gameGrid[0][0]=new KenkenButton(Color.BLACK,"kenken","","1-");
	this.gameGrid[0][1]=new KenkenButton(Color.BLUE,"kenken","","1-");
	this.gameGrid[0][2]=new KenkenButton(Color.CYAN,"kenken","","2/");
	this.gameGrid[0][3]=new KenkenButton(Color.CYAN,"kenken","","2/");
	this.gameGrid[1][0]=new KenkenButton(Color.BLACK,"kenken","","1-");
	this.gameGrid[1][1]=new KenkenButton(Color.BLUE,"kenken","","1-");
	this.gameGrid[1][2]=new KenkenButton(Color.DARK_GRAY,"kenken","","5+");
	this.gameGrid[1][3]=new KenkenButton(Color.ORANGE,"kenken","","7+");
	this.gameGrid[2][0]=new KenkenButton(Color.GREEN,"kenken","","3-");
	this.gameGrid[2][1]=new KenkenButton(Color.LIGHT_GRAY,"kenken","","2/");
	this.gameGrid[2][2]=new KenkenButton(Color.DARK_GRAY,"kenken","","5+");
	this.gameGrid[2][3]=new KenkenButton(Color.ORANGE,"kenken","","7+");
	this.gameGrid[3][0]=new KenkenButton(Color.GREEN,"kenken","","3-");
	this.gameGrid[3][1]=new KenkenButton(Color.LIGHT_GRAY,"kenken","","2/");
	this.gameGrid[3][2]=new KenkenButton(Color.MAGENTA,"kenken","","6*");
	this.gameGrid[3][3]=new KenkenButton(Color.MAGENTA,"kenken","","6*");
	
	for (int i=0;i<4;i++){
	    this.setConstraint(0,i,1,4);
	}
	for (int i=0; i<4;i++){
	    this.setConstraint(i,0,4,1);
	}
	
	this.setKen(0,0,1,0,1,"-");
	this.setKen(0,1,1,1,1,"-");
	this.setKen(0,2,0,3,2,"/");
	this.setKen(1,2,2,2,5,"+");
	this.setKen(1,3,2,3,7,"+");
	this.setKen(2,0,3,0,3,"-");
	this.setKen(2,1,3,1,2,"/");
	this.setKen(3,2,3,3,6,"*");
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