import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class QuestionPool {
    
    public ArrayList<Question> questions = new ArrayList<>();
    //  The ArrayList "questions" holds the "Question"-objects.

    public QuestionPool(File questionSetFile){
        
        try (BufferedReader reader = new BufferedReader(new FileReader(questionSetFile))) {            
            String set;

            while((set = reader.readLine()) != null){
                questions.add(new Question(set.split(";")));
            }
            
            reader.close();          
                       
        }catch (IOException e) {
            e.printStackTrace();
        }         
        
    }
    /*  
        The "QuestionPool"-constructor uses BufferReader and FileReader to read in the question-sets from a text-file.
        Each line of the textfile is cached in the String "set" and then split into an Array, which is used to construct a "Question"-object.
        "Question"-objects get added to the "questions"-ArrayList until the end of the file is reached.
    */
   
}
