import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        Charset win = Charset.forName("Windows-1251");
        Charset utf = Charset.forName("UTF-8");
        byte[] buffer = new byte[1000];

        FileInputStream inputStream = new FileInputStream(args[0]);  
        inputStream.read(buffer); //читаем в баффер из первого файла;

        String s = new String(buffer, win);
        buffer = s.getBytes(utf);  //меняем кодировку

        FileOutputStream outputStream = new FileOutputStream(args[1]);
        outputStream.write(buffer);  //читаем из баффера во второй файл;
    }
}
