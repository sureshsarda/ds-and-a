package other.xmlparsing;

public class OddEvenThreads {

    public static void main(String[] args) {
        Thread even = new Thread(new IntegerEmitter(0, 2));
        Thread odd = new Thread(new IntegerEmitter(1, 2));

        even.start();
        odd.start();
    }
}


class IntegerEmitter implements Runnable {

    private final int jump;
    private int current;

    public IntegerEmitter(int startAt, int jump) {
        this.jump = jump;
        this.current = startAt;
    }

    @Override
    public void run() {
        while (current < 20) {
            System.out.println(current);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            current += jump;
        }
    }
}
