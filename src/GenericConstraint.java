public class GenericConstraint implements ConstraintInterface{
    private GenericButton[][]grid;
    private int x;
    private int y;
    private int xSize;
    private int ySize;
    
    public GenericConstraint(GenericButton[][]g,int xco, int yco, int xS, int yS){
	x=xco;
	y=yco;
	xSize=xS;
	ySize=yS;
	grid=g;
    }
    
    public boolean fitsConstraint(){	
	int[] spotlist=new int[1];
	if (grid[0][0].spot.spotType.equals("sudoku")){
	    int[]templist = new int[] {1,0,0,0,0,0,0,0,0,0};
	    spotlist=templist;
	}
	if (grid[0][0].spot.spotType.equals("kenken")||grid[0][0].spot.spotType.equals("lettergame")){
	    int[] templist = new int[] {1,0,0,0,0};
	    spotlist=templist;
	}
	
	if (grid[0][0].spot.spotType.equals("sudoku")||grid[0][0].spot.spotType.equals("kenken")){
	    for (int row=x; row<x+xSize; row++){
		for (int column=y; column<y+ySize; column++){
		    if (!(grid[row][column].spot.spotContent.equals("")))
			spotlist[Integer.parseInt(grid[row][column].spot.spotContent)]+=1;
		}
	    }
	}

	else {
	    for (int row=x; row<x+xSize; row++){
		for (int column=y; column<y+ySize; column++){
		    if (grid[row][column].spot.spotContent.equals("A")) spotlist[1]+=1;
		    if (grid[row][column].spot.spotContent.equals("B")) spotlist[2]+=1;
		    if (grid[row][column].spot.spotContent.equals("C")) spotlist[3]+=1;
		    if (grid[row][column].spot.spotContent.equals("D")) spotlist[4]+=1;
		}
	    }
	}
	
	for (int i=0;i<spotlist.length;i++){
	    if (spotlist[i]!=1) return false;
	}	
	return true;
    }

    public boolean mightConstraint(){
	for (int i=x; i<x+xSize-1; i++){
	    for (int j=y; j<y+ySize-1; j++){
		if (!(grid[i][j].spot.spotContent=="")){
		    for (int row=x; row<x+xSize-1; row++){
			for (int column=y; column<y+ySize-1; column++){
			    if ((row != i && column != j && grid[row][column].spot.spotContent.equals(grid[i][j].spot.spotContent))&&!(grid[i][j].spot.spotContent.equals("")))return false;		
			}
		    }
		}
	    }
	}
	return true;
    }
}