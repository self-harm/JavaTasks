import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args){

            Map<String, String> mya = new HashMap<>();
            mya.put("name", "Kseniia");
            mya.put("age", "13");
            mya.put("sex", null);
            System.out.println(getQuery(mya));
    }

    public static String getQuery(Map<String, String> params)  {
        StringBuilder sb = new StringBuilder();
        for(String entry: params.keySet()){
            String value = params.get(entry);
            if(value == null){continue;}
            if(sb.length()!=0){
                sb.append(" and ");
            }
               sb.append(entry + " = '" + value + "'");
        }

        return sb.toString();
    }
}
