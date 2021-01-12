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
