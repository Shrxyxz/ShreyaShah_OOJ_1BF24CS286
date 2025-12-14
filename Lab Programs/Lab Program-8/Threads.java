class MessageThread extends Thread {
    private String message;
    private int interval;

    MessageThread(String message, int interval) {
        this.message = message;
        this.interval = interval;
    }

    public void run() {
        try {
            while (!isInterrupted()) {
                System.out.println(message);
                Thread.sleep(interval);
            }
        } catch (InterruptedException e) {
            System.out.println(message + " thread stopped.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MessageThread t1 = new MessageThread("BMS College of Engineering", 10000);
        MessageThread t2 = new MessageThread("CSE", 2000);

        t1.start();
        t2.start();

        try {
            Thread.sleep(30000); // run for 30 seconds
        } catch (InterruptedException e) {}

        t1.interrupt();
        t2.interrupt();
    }
}
