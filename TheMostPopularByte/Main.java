import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String read = reader.readLine();
        FileInputStream inputStream = new FileInputStream(read);
        ArrayList<Integer> list = new ArrayList<>();

        while(inputStream.available() > 0) //while unread byte available, adding from a file bytes to the list
        {
            int data = inputStream.read();
            list.add(data);
        }
        inputStream.close();

        Map<Integer,Integer> map = new HashMap<>();  //add to the map keys(a) and count equal values;
        int count = 1;
        for(int a: list){
            if(map.containsKey(a)){
                int x = map.get(a) + 1;
                map.put(a, x);
            }else {
                count = 1;
                map.put(a, count);
            }
        }

        int maxCount = 0; //find the byte which is the most popular/ищем масксильное повторяющийся ключ(макс value и его значение по a-ключу)
        for(Map.Entry<Integer,Integer> mya: map.entrySet()){
            int value =mya.getValue();
            int key = mya.getKey();
            if(value > maxCount)
                maxCount = value;
        }

        for(Map.Entry<Integer,Integer> mya:map.entrySet()){
            int key = mya.getKey();
            int value = mya.getValue();
            if(value == maxCount)
                System.out.print(key + " ");
        }
    }
}

