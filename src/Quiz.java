import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Quiz {

    private ArrayList<Player> players = new ArrayList<>();
    private int playerAmount, questionAmount;
    private QuestionPool questionPool;


    public Quiz(){

        questionPool = new QuestionPool();
        playerAmount = setPlayerAmount();
        questionAmount = setQuestionAmount();

        for(int i=1 ; i<=playerAmount ; i++){
            players.add(new Player(i));
        }
        
    }
    /*  
        First the constructor generates a new "QuestionPool" and uses the functions "setPlayerAmount" and "setQuestionAmount" to read in the core parameters for the quiz.
        After that the desired number of "Players" is created and added to the "players"-ArrayList.
    */


    public void run(){

        int round = 1;

        while(round <= questionAmount){

            int playerID = 1;

            while(playerID <= playerAmount && players.get(playerID-1).getScore().getStrikes()<3){

                Question activeQuestion = drawRNDMquestion();

                activeQuestion.print();

                if(isCorrectAnswer(activeQuestion)){
                    players.get(playerID-1).getScore().addPoint();
                }else{
                    players.get(playerID-1).getScore().addStrike();
                }

               playerID++;

            }

            round++;
        }
    }
    /*
        The "run"-method controls process of the "Quiz":
            Rounds are iterated until the desired "questionAmount" per "Player" is reached.
            For every round each "Player", who has less than 3 "strikes" draws a random "Question" which is then printed.
            If the chosen answer is correct the "Player" gets 1 "Point" if it's wrong 1 "Strike".
    */


    private int setPlayerAmount(){        
		
		System.out.println("How many players are participating?(Maximum: " + questionPool.questions.size()/3 + " players)\nPlayers: ");

		try(Scanner consoleInput = new Scanner(System.in)){
            try{int input = consoleInput.nextInt();
                if(input >= 1 && input <= questionPool.questions.size()/3){
                    return input;
                }else{
                    System.out.println("Please try again.");
                    return setPlayerAmount();
                }
            }catch(InputMismatchException e){
                System.out.println("Please try again.");
                return setPlayerAmount();
            }
		}

    }
    /*
        The "setPlayerAmount" function prints the maximum number of possible players. (determined by number of "Questions" available in the "questionPool")
        A scanner is used to read in integers between 1 and the number of "Questions" availbe in the "questionPool" devided by 3, so that each "Player" can get at least 3 "Questions" per "Quiz".
        If the user-input is valid the function returns the integer value, else the function calls itself.
    */

    private int setQuestionAmount(){
        System.out.println("How many questions does each player has to answer?(At least 3 per player.Maximum " + questionPool.questions.size()/playerAmount +" questions)\nQuestions: ");

		try(Scanner consoleInput = new Scanner(System.in)){
            try{int input = consoleInput.nextInt();
                if(input >= 3 && input <= questionPool.questions.size()/playerAmount){
                    return input;
                }else{
                    System.out.println("Please try again.");
                    return setPlayerAmount();
                }
		    }catch(InputMismatchException e){
                System.out.println("Please try again.");
    			return setPlayerAmount();
            }
		}
    }
    /*
        The "setPlayerAmount" function prints the maximum and minimum number of possible "Questions" per "Player". (determined by number of "Questions" available in the "questionPool" and the "playerAmount")
        A scanner is used to read in integers between 3 and the number of "Questions" availbe in the "questionPool" devided by the "playerAmount", so that each "Player" can get at least 3 "Questions" per "Quiz".
        If the user-input is valid the function returns the integer value, else the function calls itself.
    */
    

    private Question drawRNDMquestion(){

        int cachedIndex = Toolbox.generateRNDMnumber(questionPool.questions.size());
        
        if(questionPool.questions.get(cachedIndex).isDrawn()){
            return drawRNDMquestion();
        }else{
            questionPool.questions.get(cachedIndex).setDrawn();
            return questionPool.questions.get(cachedIndex);
        } 
        
    }
    /*
        The "drawRNDMquestion" function caches a random index between 1 and the size of "questions"-ArrayList.
        If the corresponding "Question" was not yet drawn, the function returns that "Question", else the function calls itself.
    */

    private boolean isCorrectAnswer(Question question){

        System.out.println("Answer (A|B|C|D): ");

        try(Scanner consoleInput = new Scanner(System.in)){
            try{char input = consoleInput.nextLine().toLowerCase().charAt(0);
                if(input == question.getCorrectOption()){
                    return true;
                }else{
                    return false;
                }
            }catch(InputMismatchException e){
                System.out.println("Please try again.");
                return isCorrectAnswer(question);
            }
		}
    }
    /*
        The "isCorrectAnswer" function prints the promt to enter an answer.
        A scanner is used to read in the first char of a String, the user enters. (to allow for case insesitive evaluation, the String is converted to lower case)
        If the entered answer matches the "correctOption" of the "Question" the function returns true, else the function returns false.
    */

}
