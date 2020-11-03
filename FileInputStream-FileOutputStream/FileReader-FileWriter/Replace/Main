import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
*/

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String output = reader.readLine();

        StringBuilder str = new StringBuilder();

        try(BufferedReader inputFileReader = new BufferedReader(new FileReader(input))){
            char currentChar;
            while (inputFileReader.ready()){
                currentChar = (char) inputFileReader.read();
                str.append(currentChar);
            }
        }

        String one = str.toString().replace(".", "!");

        try(BufferedWriter outputFileWriter = new BufferedWriter(new FileWriter(output))){
            outputFileWriter.write(one);
        }

        reader.close();

    }
}
