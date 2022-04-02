public class Score {
    
    private int points, strikes;

    public Score(){

        points = 0;
        strikes = 0;

    }


   public void addPoint(){
       points++;
   } 

   public int getPoints(){
       return points;
   }


   public void addStrike(){
       strikes++;
   }

   public int getStrikes(){
       return strikes;
   }
   
}
