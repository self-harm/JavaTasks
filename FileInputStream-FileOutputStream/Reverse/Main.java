import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String read = reader.readLine();
        String write = reader.readLine();

        try(FileInputStream inputStream = new FileInputStream(read);
            FileOutputStream outputStream = new FileOutputStream(write);){

            ArrayList<Integer> list = new ArrayList<>();
            while (inputStream.available()>0) {
                list.add(inputStream.read());
            }
            Collections.reverse(list);  //using Collections;
            for(Integer a: list){      //for each Integer a from the array:
                outputStream.write(a);
            }
        }
    }
}