/*Реализуй логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы.
Верни отсортированный массив от минимального расстояния до максимального.
Если удаленность одинаковая у нескольких чисел, то сортируй их в порядке возрастания.

Пример входящего массива:
13, 8, 15, 5, 17
медиана - 13

Отсортированный масив:
13, 15, 17, 8, 5*/

import java.util.Arrays;

/* 
Почитать в инете про медиану выборки
первое решение
*/

public class MediumNumber {

    public static void main(String[] args) {
    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);

        double medium = 0;

        if(array.length%2 != 0){
            medium = array[array.length / 2];
        }
        else if(array.length%2 == 0){
            medium = array[array.length / 2];
           double a = array[(array.length / 2)-1];
            medium = (a + medium) / 2;
        }


        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length;j++){
                int buff = 0;
                if((Math.abs(medium-array[i])<Math.abs(medium-array[j])) ||
                        (medium-array[i])==Math.abs(medium-array[j]) & medium-array[j]<0){
                    int swap = array[i];
                    array[i]=array[j];
                    array[j]=swap;
                    }
                }
            }
        return array;
    }
}


/* 
второе решение
*/
import java.util.Arrays;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/

public class MainSecond {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        final double mediana = getMediana(array);

        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                double v1 = o1.intValue() - mediana;
                double v2 = o2.intValue() - mediana;
                return (int) ((v1 * v1 - v2 * v2) * 100);
            }
        });

        return array;
    }

    private static double getMediana(Integer[] array) {
        Arrays.sort(array);
        double res;
        int length = array.length;

        if (length % 2 == 1) {
            res = array[length / 2];
        } else {
            res = (array[length / 2 - 1] + array[length / 2]) / 2.;
        }
        return res;
    }
}
