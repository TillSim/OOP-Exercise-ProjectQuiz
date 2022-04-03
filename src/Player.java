import java.util.Scanner;

public class Player {
    
    private int id;
    private String name;
    private Score score;


    public Player(int id){

        this.id = id;
        this.name = setName();
        score = new Score();

    }


    public int getID(){
        return id;
    }

    public String getName(){
        return name;
    }

    private String setName(){
        
        System.out.println("Please enter a name.(Maximum: 10 characters)\nPlayer-" + id + ": ");

        try(Scanner consoleInput = new Scanner(System.in)){
            String input = consoleInput.nextLine();
            if(input.length()<=10){
                return input;
            }else{
                System.out.println("Please try again.");
                return setName();
            }
		}
    }
    //  The "setName"-method uses a Scanner to read in the desired "Player"-name as a String. (Maximum: 10 characters)

    
    public Score getScore(){
        return score;
    }

    
    
}
