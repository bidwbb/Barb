public class LetterConstraint implements ConstraintInterface{
    private GenericButton[][]grid;
    private int x;
    private int y;
    private int ySize;
    private int xSize;
    private int space;
    private String letter;
    
    public LetterConstraint(GenericButton[][]g,int xco, int yco, int xS, int yS, int s, String l){
	x = xco;
	y = yco;
	xSize=xS;
	ySize=yS;
	space = s;
	letter = l;
	grid = g;
    }
    
    public boolean fitsConstraint(){
	int count = 0;
	boolean constraintMet=false;
	boolean full=false;
	for (int row=x; row<x+xSize; row++){
	    for (int column=y; column<y+ySize; column++){
		if (!(grid[row][column].spot.spotContent.equals(""))) count++;
		if ((count==space)&&grid[row][column].spot.spotContent.equals(letter)) constraintMet=true;
	    }
	}

	int aCount=0;
	int bCount=0;
	int cCount=0;
	int dCount=0;
	for (int row=x; row<x+xSize; row++){
	    for (int column=y; column<y+ySize; column++){
		if ((grid[row][column].spot.spotContent.equals("A"))) aCount++;
		if ((grid[row][column].spot.spotContent.equals("B"))) bCount++;
		if ((grid[row][column].spot.spotContent.equals("C"))) aCount++;
		if ((grid[row][column].spot.spotContent.equals("D"))) aCount++;
	    }
	}
	if (aCount==1 && bCount==1 && cCount==1 && dCount==1) full=true;	 
	if (constraintMet && full) return true;
	return false;
    }

    public boolean mightConstraint(){
	int count = 0;
	for (int row=x; row<x+xSize; row++){
	    for (int column=y; column<y+ySize; column++){
		if (!(grid[row][column].spot.spotContent.equals(""))) count++;
		if ((count>=space)) return false;
	    }
	}
	return true;
    }
}