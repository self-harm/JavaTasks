/*Число S состоит из M цифр, например, S=370 и M (количество цифр) = 3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень.
getNumbers должен возвращать все такие числа в порядке возрастания.

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
Метод main не участвует в тестировании.

Требования:
•	В классе Solution должен присутствовать метод public static long[] getNumbers(long N)
•	В методе getNumbers не должно возникать исключений, при любых входных данных.
•	Все найденные числа должны быть строго меньше N.
•	Метод getNumbers должен возвращать массив чисел удовлетворяющих условию задачи.

Подсказка:
Поиск чисел Армстронга: отчёт

1. Генерирование матрицы степеней
Поскольку при поиске чисел Армстронга очень часто выполняется операция возведения в степень какого-либо однозначного числа, можно уменьшить затраты процессорного времени, предварительно вычислив результаты возведения в степень всех однозначных чисел и сохранив их в двухмерном массиве. Когда в ходе дальнейшего выполнения программы возникает необходимость возвести в степень одно из чисел, сама операция не выполняется; вместо этого готовый результат берётся из созданной ранее матрицы.

2. Генерирование уникальных числовых последовательностей
Чтобы избежать затрат времени на проверку чисел, состоящих из одних и тех же цифр, следует рассматривать только то число, каждая цифра в котором не меньше предыдущей и не больше последующей. Очевидно, что при использовании такого способа отбора будут отсеяны также все числа, содержащие хотя бы один ноль. Для разрешения этой проблемы число можно представить в виде массива, каждый элемент которого содержит одну из цифр исходного числа.
Сначала создаётся массив длиной, соответствующей порядку введённого числа N (то есть верхней границе диапазона поиска); все ячейки массива инициализируются значением 9. Затем проводится уменьшение на 1 значения в [0] элементе массива до тех пор, пока это значение не достигнет 0. Тогда уменьшается значение элемента с индексом [1], а все предыдущие элементы также получают это новое значение. Пример: [0, 9, 9] становится [8, 8, 9]. После этого массив снова декрементируется по описанной выше схеме, начиная с [0] элемента.
Так происходит до тех пор, пока значение последней ячейки не окажется равным нулю, что будет являться сигналом о достижении нижней границы диапазона генерации.
Описанный способ генерации всегда соблюдает условие уникальности полученного «числа», а также сохраняет все лидирующие нули.

3. Проверка уникальной последовательности
Каждое сгенерированное в п.2 «число», представленное в виде массива цифр, проверяется (вычисляется степенная сумма его цифр). Полученный результат «раскладывается» на цифры, для которых опять вычисляется степенная сумма. Если результат будет равен числу до «разложения» на цифры, то это и есть число Армстронга.
Примечание: исходные числовые последовательности с лидирующими нулями следует проверять несколько раз, отбрасывая перед каждой следующей проверкой один ноль от начала последовательности. Например, последовательность { 0, 0, 1, 2, 3 } может соответствовать таким числам: 132, 12300, 2301, 1032 и т. д.

4. Вычисление степенной суммы
При исходном числе N, порядок которого не превышает 18 знаков, достаточно использовать примитивный тип long, поскольку даже максимально возможная степенная сумма в этом случае будет около 2,7*10^18, и, следовательно, не превысит максимально возможного значения для типа long (примерно 9,2*10^18).
Если исходное число N содержит 19 знаков, то при вычислении степенной суммы возможен выход за пределы диапазона значений long, что приведёт к искажению результата (в некоторых случаях результат может быть даже отрицательным). Эту проблему можно разрешить двумя способами. Первый способ – математически точный, но более ресурсоёмкий. Он заключается в использовании класса BigInteger при выполнении вычислений для 19-значных чисел. Второй способ более быстрый, он использует следующее свойство: при прибавлении к Long.MAX_VALUE значения, не превышающего Long.MAX_VALUE, получим отрицательное значение (выход за пределы диапазона long). Таким образом, если в процессе вычисления степенной суммы возникает отрицательное значение, то проверяемое число может быть отброшено как неподходящее.

5. Сохранение найденных чисел Армстронга
Найденные числа помещаются в множество TreeSet, что позволяет исключить нежелательные дубликаты, возникающие в процессе поиска, а также отсортировать числа по возрастанию.

6. Результаты выполнения программы
Код выполнялся на процессоре Intel Core i5-3570 с тактовой частотой 3,7 ГГц.
Тесты проводились для диапазона натуральных чисел с верхней границей Long.MAX_VALUE.

Версия 1 (с частичным использованием BigInteger):
выполнение в 1 поток – 12 с, 12 Мб памяти;
выполнение в 2 потока – 6,5 с, 20 Мб памяти;
выполнение в 4 потока – 5 с, 35 Мб памяти.

Версия 2 (без использования BigInteger):
выполнение в 1 поток – 3 с, 8 Мб памяти;
выполнение в 2 потока – 1,7 с, 13 Мб памяти;
выполнение в 4 потока – 1,2 с, 20 Мб памяти.*/

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

public class NarcissisticNumber {

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
