import javax.lang.model.element.NestingKind;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();

       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
       bufferedReader.close();

       while(fileReader.ready()){
           list.addAll(Arrays.asList(fileReader.readLine().split(" ")));
       }
       fileReader.close();

       for(int i=0;i<list.size();i++){ //for each String from ArrayList;
           for(int j=0; j<list.size(); ){
               if(i>= list.size()){
                   break;
               }
               if(list.get(j).equals(new StringBuilder(list.get(i)).reverse().toString()) && j != i){
                   Pair pair = new Pair();
                   pair.first = list.get(j);
                   pair.second = list.get(i);

                   result.add(pair);
                   list.remove(j);
                   list.remove(i);
                   j = 0;
               }
               j++;
           }
       }
    }

    public static class Pair {
        String first;
        String second;

        public Pair(){

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }
}
