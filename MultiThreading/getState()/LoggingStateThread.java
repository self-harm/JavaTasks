public class LoggingStateThread extends Thread{
    private Thread thread;

    @Override
    public void run() {
        State currentState = thread.getState();
        System.out.println(currentState);

        State newState;
        do {
            if ((newState = thread.getState()) != currentState) {
                currentState = newState;
                System.out.println(currentState);
            }
        }
            while (!currentState.equals(State.TERMINATED));
    }

    public LoggingStateThread(Thread thread){
        this.thread = thread;
        setDaemon(true);
    }
}
