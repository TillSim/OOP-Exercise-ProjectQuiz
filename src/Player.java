import java.util.Scanner;

public class Player {
    
    private int id;
    private String name;
    private Score score;


    public Player(int id, Scanner consoleInput){

        this.id = id;
        this.name = setName(consoleInput);
        score = new Score();

    }


    public int getID(){
        return id;
    }

    public String getName(){
        return name;
    }

    private String setName(Scanner consoleInput){
        
        System.out.print("Please enter a name.(Maximum: 10 characters)\nPlayer-" + id + ": ");

        
            String input = consoleInput.next();
            if(input.length()<=10){
                return input;
            }else{
                System.out.println("Please try again.");
                return setName(consoleInput);
            }
		
    }
    //  The "setName"-method uses a Scanner to read in the desired "Player"-name as a String. (Maximum: 10 characters)

    
    public Score getScore(){
        return score;
    }

    public void printScore(){

        String output = name;

        if(name.length() < 10){
            for(int i=1 ; i<=(10-name.length()) ; i++){
                output+= " ";
            }
        }

        System.out.println(output + "|   " + score.getPoints() + "    |    " + score.getStrikes());

    }
    
}
