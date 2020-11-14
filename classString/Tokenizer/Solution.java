import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static String[] getTokens(String query, String delimiter) {
        List<String> list = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        while (tokenizer.hasMoreTokens()){
            list.add(tokenizer.nextToken());
        }

        String[] result = new String[list.size()];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }
        
        return result;
    }
}
