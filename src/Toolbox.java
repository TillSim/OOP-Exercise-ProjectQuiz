public abstract class Toolbox {
    
    public static int generateRNDMnumber(int boundary){

        int min = 0;

		return (int) Math.floor(Math.random() * (boundary - min + 1) + min);
        
    }
}
