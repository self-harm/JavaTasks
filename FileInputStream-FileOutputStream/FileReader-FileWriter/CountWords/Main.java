import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.*;

/*
Считаем слово
*/

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        StringBuilder text = new StringBuilder();

        try(FileReader fileReader = new FileReader(s)){
            char currentChar;
            while(fileReader.ready()) {
                currentChar = (char) fileReader.read(); //doesn't expand to int because of the (char);
                text.append(currentChar); 
            }
        }

        int count=0;

        String replacedString = text.toString().replaceAll("\\p{P}", " ").replaceAll("\\s", " ");

        for(String a: replacedString.split(" ")){
            if(a.matches("world")){
                count++;
            }
        }

        reader.close();
        System.out.println(count);

    }
}
