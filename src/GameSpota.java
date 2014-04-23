
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameSpota implements ActionListener{

    public String spotType;
    public String spotContent;
    public int clickCount = 0;
    public String [] spotArray;
    public boolean changeable;

    public GameSpota(String type, String content){
	spotArray = new String[10];
	spotType = type;
	spotContent = content;
	if (spotContent!="") changeable = false;
	else changeable = true;
	spotArray[0]="";

	if (spotType.equals("sudoku")){
	    for (int i=1; i<10; i++){
	    	spotArray[i] = String.valueOf(i);
	    }
	    if (spotContent!="") clickCount=Integer.parseInt(spotContent);
	}
	
	if (spotType.equals("kenken")){
	    for (int i=1; i<5; i++){
	    	spotArray[i] = String.valueOf(i);
	    }
	}

	if (spotType.equals("lettergame")){
	    spotArray[1]="A";
	    spotArray[2]="B";
	    spotArray[3]="C";
	    spotArray[4]="D";
	}
    }

    public void actionPerformed(ActionEvent e) {
	if (changeable){ clickCount++;
	if (this.spotType.equals("sudoku"))
	    spotContent = spotArray[clickCount%10];
	else spotContent = spotArray[clickCount%5];
	}
    }
}

    

	    
	    