import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

/* 
Алгоритмы-числа
*/

public class Solution {

    private static long S; //all natural numbers from N
    private static int N; // initial number
    private static int[] digitsMultiArray;
    private static int[] testMultiArray;

    private static List<Long> results;
    private static long maxPow;
    private static long minPow;

    private static long[][] pows;


    public static long[] getNumbers(long limit) {
        if (limit <= 1) return new long[0];

        S = limit;
        List<Long> armstrongList = generate(String.valueOf(S).length() + 1);
        long[] result = new long[armstrongList.size()];

        for (int i = 0; i < armstrongList.size(); i++) {
            result[i] = armstrongList.get(i);
        }
        return result;
    }
        private static void generatePows(int N){
            if(N>20) throw new IllegalArgumentException(); //create matrix: 10 rows, 19 columns + 1
            pows = new long[10][N+1];                     //int[][] table = new int[rows][columns];
            for (int i = 0; i < pows.length; i++) {     
                long p = 1;
                for (int j = 0; j < pows[i].length; j++) {
                    pows[i][j] = p;
                    p *= i; //p= p*i;
                }
            }
        }

    private static boolean check(long pow) {
        if (pow >= maxPow) return false;
        if (pow < minPow) return false;

        for (int i = 0; i < 10; i++) {
            testMultiArray[i] = 0;
        }
        while (pow > 0) {
            int i = (int) (pow % 10);
            testMultiArray[i]++;
            if (testMultiArray[i] > digitsMultiArray[i]) return false;
            pow = pow / 10;
        }
        for (int i = 0; i < 10; i++) {
            if (testMultiArray[i] != digitsMultiArray[i]) return false;
        }
        return true;
    }


    private static void search(int digit, int unused, long pow) {
        if (pow >= maxPow) return;
        if (digit == -1) {
            if (check(pow) && pow < S) results.add(pow);
            return;
        }
        if (digit == 0) {
            digitsMultiArray[digit] = unused;
            search(digit - 1, 0, pow + unused * pows[digit][N]);
        } else {
            // Check if we can generate more than minimum
            if (pow + unused * pows[digit][N] < minPow) return;

            long p = pow;
            for (int i = 0; i <= unused; i++) {
                digitsMultiArray[digit] = i;
                search(digit - 1, unused - i, p);
                if (i != unused) {
                    p += pows[digit][N];
                    // Check maximum and break the loop - doesn't help
                    // if (p >= maxPow) break;
                }
            }
        }
    }


    private static List<Long> generate(int maxN) {
        if (maxN >= 21) throw new IllegalArgumentException();

        genPows(maxN);
        results = new ArrayList<>();
        digitsMultiArray = new int[10];
        testMultiArray = new int[10];

        for (N = 1; N < maxN; N++) {
            minPow = (long) Math.pow(10, N - 1);
            maxPow = (long) Math.pow(10, N);

            search(9, N, 0);
        }
        Collections.sort(results);
        return results;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(50)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(10)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

    }
}
