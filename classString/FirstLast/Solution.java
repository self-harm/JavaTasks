import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/* 
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        bufferedReader.close();

        while(fileReader.ready()){
            list.addAll(Arrays.asList(fileReader.readLine().split(" ")));
        }
        fileReader.close();  //read from file and then close all streams;


        StringBuilder result = getLine(getWords(list));
        System.out.println(result.toString());
    }

    private static String[] getWords(List<String> list){
        String[] array = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            array[i] = list.get(i);
        }
        return array;
    }

    private static boolean isTheSameChars(String firstWord, String secondWord){  //the method checks first and the last letters of two words;
        if(firstWord.endsWith(" ")){
            firstWord = firstWord.substring(0, firstWord.length() - 1);
        }
        return firstWord.isEmpty() || (secondWord != null &&
                Character.toUpperCase(firstWord.charAt(firstWord.length() - 1)) == Character.toUpperCase(secondWord.charAt(0)));
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<words.length;i++){
        list.add(i);
        if(findSolution(list, words)){
            for(Integer integer: list){
                sb.append(words[integer] + " ");
                }
            return sb;
            }
        list.remove(Integer.valueOf(i));
        }
        return sb;
    }

    private static <T> T getLastElement(List<? extends T> list) {
        return list.get(list.size() - 1);
    }

        private static boolean findSolution(List<Integer> list, String... words){
            if(list.size() == words.length){
                return true;
            }

            for(int i=0;i< words.length;i++){
                if(isValid(list,words[i], words)){
                    list.add(i);
                if (findSolution(list, words)){
                    return true;
                }
                list.remove(Integer.valueOf(i));
                }
            }
            return false;
        }

        private static boolean isValid(List<Integer> list, String word, String... words){
    for(Integer integer: list){
        if(words[integer].equals(word)){
            return false;
        }
    }
    return isTheSameChars(words[getLastElement(list)], word);
        }

}
