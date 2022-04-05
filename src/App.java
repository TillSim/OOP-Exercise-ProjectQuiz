import java.io.File;
import java.util.Scanner;

public abstract class App {
    public static void main(String[] args) throws Exception {  

        Scanner consoleInput = new Scanner(System.in);

        File questionSetFile = new File("testQuestionSet.csv");

        Quiz quiz = new Quiz(consoleInput,questionSetFile);

        quiz.run(consoleInput);

        consoleInput.close();

    }
}
