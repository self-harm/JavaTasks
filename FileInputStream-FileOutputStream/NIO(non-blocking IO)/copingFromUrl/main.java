package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Загрузчик файлов
*/

public class Main {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        /*create download path with url name*/
        String fileName = urlString.split("/")[urlString.split("/").length-1];
        Path downloadPath = downloadDirectory.resolve(fileName);

        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();

        /*copy into temporary file*/
        Path tempFile = Files.createTempFile(null, null);
        Files.copy(inputStream, tempFile);

        /*move from temporary file to contemporary*/
        Files.move(tempFile,downloadPath);
        return downloadPath;
    }
}
