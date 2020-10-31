mport java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/*
Сортировка байт
*/


public class Main {

        public static void main(String[] args) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String read = reader.readLine();
            FileInputStream inputStream = new FileInputStream(read);
            Map<Integer, Integer> map = new TreeMap<>(); //we are using TreeMap because it's extremely convenient in that case - it's an increading sequence;
            ArrayList<Integer> list = new ArrayList<>();

            while (inputStream.available() > 0) //while unread byte available
            {
                int data = inputStream.read();
                list.add(data);
            }
            inputStream.close();

            for (int a = 0; a < list.size(); a++) {
                map.put(list.get(a), a);  //Treemap add keys in desirable sequence(increasing sequence);
            }

            for (Map.Entry<Integer, Integer> mya : map.entrySet()) {
                int key = mya.getKey();
                System.out.print(key + " ");
            }
        }
    }
