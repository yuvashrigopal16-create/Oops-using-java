import java.util.Random;

class SharedData {
    int number;
    int count = 0;

    synchronized void generateNumber() {
        Random r = new Random();

        while (true) {
            number = r.nextInt(10) + 1;
            count++;

            System.out.println("Thread 1: Generated Number = " + number);
            notifyAll();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    synchronized void calculateSquare() {
        int last = 0;

        while (true) {
            try {
                while (count == last || number % 2 != 0)
                    wait();

                System.out.println("Thread 2: Square of " + number +
                                   " = " + (number * number));

                last = count;

            } catch (InterruptedException e) {
                return;
            }
        }
    }

    synchronized void calculateCube() {
        int last = 0;

        while (true) {
            try {
                while (count == last || number % 2 == 0)
                    wait();

                System.out.println("Thread 3: Cube of " + number +
                                   " = " + (number * number * number));

                last = count;

            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

public class MultiThreadNumberProcessing {
    public static void main(String[] args) {

        SharedData data = new SharedData();

        Thread t1 = new Thread(() -> data.generateNumber());
        Thread t2 = new Thread(() -> data.calculateSquare());
        Thread t3 = new Thread(() -> data.calculateCube());

        t1.start();
        t2.start();
        t3.start();
    }
}
