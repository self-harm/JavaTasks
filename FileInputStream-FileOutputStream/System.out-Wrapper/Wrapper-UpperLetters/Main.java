import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Ридер обертка
*/

public class Main {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream out = System.out; 

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);


        testString.printSomething();

        String result = outputStream.toString().toUpperCase();

        System.setOut(out);

        System.out.println(result);
    }


    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
