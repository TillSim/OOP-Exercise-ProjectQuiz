public class Question {

    private String question, optionA, optionB, optionC, optionD;

    private char correctOption;

    private boolean isDrawn;
    //  isDrawn is used to flag "Question"-objects as 'already played' so that players don't get questions twice in one game.


    public Question(String[] questionElements){

        question = questionElements[0];
        optionA = questionElements[1];
        optionB = questionElements[2];
        optionC = questionElements[3];
        optionD = questionElements[4];
        correctOption = questionElements[5].charAt(0);

    }
    //  The "Question"-constructor uses an "questionElements"-array that holds all attributes.
    
    public void print(){
        System.out.println(question + "\nA: " + optionA + "\nB: " + optionB + "\nC: " + optionC + "\nD: " + optionD);
    }

    public boolean isDrawn(){
        return isDrawn;        
    }

    public void setDrawn(){
        isDrawn = true;
    }   

}