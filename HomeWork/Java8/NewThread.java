  
package io.harmed;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**создание потока при помощи лямбд-выраджений*/

public class NewThread {

    public static void main(String []args) throws ExecutionException, InterruptedException {
        /*using Runnable interface*/
        Runnable task = () -> {
            System.out.println("Hello World! from Runnable");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("This is the end of Runnable");
        };
        new Thread(task).start();

        /*using Callable interface*/
        Callable task1 = () -> {
            return "Hello, World! from Callable";
        };
        FutureTask<String> future = new FutureTask<>(task1);
        new Thread(future).start();
        System.out.println(future.get());
    }
}
