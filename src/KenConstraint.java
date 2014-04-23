
public class KenConstraint implements ConstraintInterface{
    private GenericButton[][]grid;
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int total;
    private String operation;
    
    public KenConstraint(GenericButton[][]g,int xco1, int yco1, int xco2, int yco2, int t, String o){
	x1 = xco1;
	y1 = yco1;
	x1 = xco1;
	y1 = yco1;
	grid = g;
	total = t;
	operation = o;
    }
    
    public boolean fitsConstraint(){
	if (operation.equals("+"))
	    if (Integer.parseInt(grid[x1][y1].spot.spotContent)+Integer.parseInt(grid[x2][y2].spot.spotContent)==total) return true;

	if (operation.equals("-"))
	    if ((Integer.parseInt(grid[x1][y1].spot.spotContent)-Integer.parseInt(grid[x2][y2].spot.spotContent)==total) || (Integer.parseInt(grid[x2][y2].spot.spotContent)-Integer.parseInt(grid[x1][y1].spot.spotContent)==total)) return true;

	if (operation.equals("*"))
	    if (Integer.parseInt(grid[x1][y1].spot.spotContent)+Integer.parseInt(grid[x2][y2].spot.spotContent)==total) return true;       

	if (operation.equals("/"))
	    if ((Integer.parseInt(grid[x1][y1].spot.spotContent)/Integer.parseInt(grid[x2][y2].spot.spotContent)==total) || (Integer.parseInt(grid[x2][y2].spot.spotContent)/Integer.parseInt(grid[x1][y1].spot.spotContent)==total)) return true;

     	return false;
    }

    public boolean mightConstraint(){
	if (grid[x1][y1].spot.spotContent.equals("") && grid[x2][y2].spot.spotContent.equals("")) return true;
	else if (grid[x2][y2].spot.spotContent.equals("")){
	    if (operation.equals("*")||operation.equals("+"))
		if (Integer.parseInt(grid[x2][y2].spot.spotContent)>total) return false;
	    if (operation.equals("/"))
		if ((total%Integer.parseInt(grid[x2][y2].spot.spotContent)!=0)&&(Integer.parseInt(grid[x2][y2].spot.spotContent)%total!=0)) return false;
	    if (operation.equals("*"))
		if (total%Integer.parseInt(grid[x2][y2].spot.spotContent)!=0) return false;
	}
	
	else{
	    if (operation.equals("+"))
		if (Integer.parseInt(grid[x1][y1].spot.spotContent)+Integer.parseInt(grid[x2][y2].spot.spotContent)==total) return true;
	    if (operation.equals("-"))
		if ((Integer.parseInt(grid[x1][y1].spot.spotContent)-Integer.parseInt(grid[x2][y2].spot.spotContent)==total) || (Integer.parseInt(grid[x2][y2].spot.spotContent)-Integer.parseInt(grid[x1][y1].spot.spotContent)==total)) return true;

	    if (operation.equals("*"))
		if (Integer.parseInt(grid[x1][y1].spot.spotContent)+Integer.parseInt(grid[x2][y2].spot.spotContent)==total) return true;       

	    if (operation.equals("/"))
		if ((Integer.parseInt(grid[x1][y1].spot.spotContent)/Integer.parseInt(grid[x2][y2].spot.spotContent)==total) || (Integer.parseInt(grid[x2][y2].spot.spotContent)/Integer.parseInt(grid[x1][y1].spot.spotContent)==total)) return true;

	    return false;
	}
	return true;
    }
}
