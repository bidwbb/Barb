public interface GameInterface{
    
    public boolean checkConstraints();

    public void setConstraint(int coordX, int coordY,int sizeX, int sizeY);

    public GenericButton[][] getGameGrid();
    
    public void setGameGrid(GenericButton[][] toSet);

    public boolean tempConstraints();

    public boolean label(int i, int j, GenericButton[][]spots, GameInterface game, String[] possibleValues);
}