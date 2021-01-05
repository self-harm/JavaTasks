package com.javarush.task.task31.task3103;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/* 
Своя реализация
*/

public class main {

    public static byte[] readBytes(String fileName) throws IOException {
       /*Path path = Paths.get(fileName); create path

        return Files.readAllBytes(path);   byte[] fileArray = Files.readAllBytes(path);
                                           return fileArray;
                                           */
        
         return Files.readAllBytes(Paths.get(fileName));
    }

    public static List<String> readLines(String fileName) throws IOException {
       /* Path path = Paths.get(fileName); create path
        List<String> list;
        list = Files.readAllLines(path);
        return list;*/

        return Files.readAllLines(Paths.get(fileName));
    }

    public static void writeBytes(String fileName, byte[] bytes) throws IOException {
        Files.write(Paths.get(fileName), bytes);
    }

    public static void copy(String resourceFileName, String destinationFileName) throws IOException {
        /*Path pathFrom = Paths.get(resourceFileName); откуда копируем
        Path pathTo = Paths.get(destinationFileName); куда копируем

        Files.copy(pathFrom, pathTo);*/

        Files.copy(Paths.get(resourceFileName), Paths.get(destinationFileName));
    }
}
