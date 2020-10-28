import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.io.*;
import java.util.*;
import java.math.BigInteger;

/*
Факториал
*/

public class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int input = Integer.parseInt(reader.readLine()); //read from the keyboard;
            reader.close();  //close the stream;
            System.out.println(factorial(input));

        }

        public static String factorial(int n){  // method 'find a factorial';

            ArrayList<Integer> list = new ArrayList<Integer>();
            BigInteger fact = BigInteger.valueOf(1);

            for(int i = 1; i <= n; i++){
                fact= fact.multiply(BigInteger.valueOf(i));
            }

            if(n == 0){
                fact = BigInteger.valueOf(1);
            }
            else if(n < 0){
                fact = BigInteger.valueOf(0);
            }

            String str1 = fact.toString();

            return str1;
        }
    }
