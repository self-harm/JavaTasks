import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
                'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
                'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String line = reader.readLine();
            list.add(line.toLowerCase());
        }

        Map<Character, Integer> map = new LinkedHashMap<>();  //заполнили ключи буквами
        for(Character each: alphabet){
            map.put(each, 0);
        }

        StringBuilder sb = new StringBuilder();

        for(String a: list){
            sb.append(a);
        }

        String one = sb.toString();

        List<Character> sp = new ArrayList<>();
        for (int i = 0; i < one.length(); i++) {
            sp.add(one.charAt(i));
        }

        for(int i=0;i<sp.size()-1;i++){
            if(map.containsKey(sp.get(i))){
                int count = map.getOrDefault(sp.get(i), map.get(sp.get(i)));
                map.put(sp.get(i), count+1);
            }
        }

        alphabet.forEach(c -> System.out.println(c + " " + map.get(c)));
    }
}
