public class Player {
    
    private int id;
    private String name;
    private Score score;


    public Player(int id, String name){

        this.id = id;
        this.name = name;
        score = new Score();

    }


    public int getID(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int[] getScore(){
        int[] score = new int[2];
        score[0] = this.score.getPoints();
        score[1] = this.score.getStrikes();
        return score;
    }
    
}
