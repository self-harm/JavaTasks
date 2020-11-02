import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/*
Английские буквы
*/

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        ArrayList<Integer> list = new ArrayList<>();
        try(FileReader fileReader = new FileReader(args[0])){
            while(fileReader.ready()){
                list.add(fileReader.read());
            }
        }

        int count=0;

        for(Integer a: list){
            if(a >=65 && a <=90){  //table Ascii;
                count++;
            }
            if(a >=97 && a <=122){
                count++;
            }
        }

        System.out.println(count);
    }
}
