import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();
        String b = reader.readLine();

        FileWriter writer = new FileWriter(b);
        FileReader readerOne = new FileReader(s);

        ArrayList<Integer> list = new ArrayList<>(); //create ArrayList;

        while(readerOne.ready()){
            list.add(readerOne.read());
        }

        for(int i=1;i<list.size();i=i+2){  //step +2
            writer.write(list.get(i));
        }

        reader.close();
        writer.close();
        readerOne.close();

    }
}