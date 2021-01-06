package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;

/* 
Что внутри папки?
*/

/*Напиши программу, которая будет считать подробную информацию о папке и выводить ее на консоль.

Первым делом считай путь к папке с консоли.
Если введенный путь не является директорией - выведи "[полный путь] - не папка" и заверши работу.
Затем посчитай и выведи следующую информацию:

Всего папок - [количество папок в директории и поддиректориях]
Всего файлов - [количество файлов в директории и поддиректориях]
Общий размер - [общее количество байт, которое хранится в директории]

Используй только классы и методы из пакета java.nio.

Квадратные скобки [ ] выводить на экран не нужно.*/

public class Solution {

    public static void main(String[] args) throws IOException {

        /*считаваем с консоли файл*/
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        /*если указанный путь - не директория*/
        if(Files.isRegularFile(Paths.get(fileName))){
            System.out.println(fileName + " - не папка");
        }
        /*если указанный путь - директория*/
        else if(Files.isDirectory(Paths.get(fileName))){
          /*
          работает только для одной директории(without subdirectories)
          int numberOfFiles = new File(fileName).list().length;*/

            /*using Java 8 NIO and Streams API*/
            long numberOfFiles = Files.walk(Paths.get(fileName))
                    .parallel()
                    .filter(p -> !p.toFile().isDirectory())
                    .count();

            long numberOfDirectories = Files.walk(Paths.get(fileName))
                    .parallel()
                    .filter(p -> p.toFile().isDirectory())
                    .count();

            long size = Files.walk(Paths.get(fileName))
                    .mapToLong(p -> p.toFile().length())
                    .sum();

            System.out.println("Всего папок - " + numberOfDirectories);
            System.out.println("Всего файлов - " + numberOfFiles);
            System.out.println("Общий размер - " + size);
        }

    }
}
