import java.io.*;
import java.util.ArrayList;

/*
Выделяем числа
*/

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String output = reader.readLine();

        StringBuilder text = new StringBuilder();

        try (BufferedReader inputFileReader = new BufferedReader(new FileReader(input))){
            char currentChar;
            while(inputFileReader.ready()) {
                currentChar = (char) inputFileReader.read(); //doesn't expand to int because of the (char);
                text.append(currentChar);
            }
        }

        String one = text.toString();

        try(BufferedWriter outputFileWriter = new BufferedWriter(new FileWriter(output))) {
            for (String a : one.split(" ")) {
                if (a.matches("\\d+")) {
                    outputFileWriter.write(a + " ");
                }
            }
        }
        reader.close();
    }
}
