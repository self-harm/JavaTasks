import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
/*в файле находится два класса(специально сделала так, чтобы не делить код на несколько файлов)*/

class EventSource {
    public interface Observer {
        void update(String event);
    }
  
    private final List<Observer> observers = new ArrayList<>();
  
    private void notifyObservers(String event) {
        observers.forEach(observer -> observer.update(event));
    }
  
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
  
    public void scanSystemIn() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            notifyObservers(line);
        }
    }
}

public class ObserverDemo {
    public static void main(String[] args) {
        System.out.println("Enter Text: ");
        EventSource eventSource = new EventSource();
        
        eventSource.addObserver(event -> {
            System.out.println("Received response: " + event);
        });

        eventSource.scanSystemIn();
    }
}
