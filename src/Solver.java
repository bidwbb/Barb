public class Solver{
    public GameInterface game = new SudokuGame();
    public GenericButton[][]spots;
    public String[] possibleValues;
    
    public Solver(GameInterface toSolve, String type){
	if (type.equals("sudoku")) {
	    String[]values = {"1","2","3","4","5","6","7","8","9"};
	    possibleValues = values;
	}
     	if (type.equals("kenken")) {
	    String[]values = {"1","2","3","4"};
	    possibleValues = values;
	}

	if (type.equals("letter")) {
	    String[]values = {"","A","B","C","D"};
	    possibleValues = values;
	}
	game = toSolve;
	spots = game.getGameGrid();
    }
	    
    public boolean label(int i, int j, GenericButton[][]spots, GameInterface game, String[] possibleValues){
	System.out.println("the coords are" + i + "," + j);
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
	
	if ((i==spots.length-1)&&(j==spots.length-1)) return game.checkConstraints();

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
	spots[i][j].spot.spotContent="";
	return false;
    }
}
	    