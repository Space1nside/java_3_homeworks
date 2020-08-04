public class Main {
    private char letter = 'A';
    private static final int AMOUNT_OF_ABC = 5;

    public static void main(String[] args) {
        Main ABC = new Main();
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < AMOUNT_OF_ABC; i++) {
                    ABC.showA();
                }
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < AMOUNT_OF_ABC; i++) {
                    ABC.showB();
                }
            }
        });

        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < AMOUNT_OF_ABC; i++) {
                    ABC.showC();
                }
            }
        });

        a.start();
        b.start();
        c.start();
    }

    public synchronized void showA() {
        try {
            while (letter != 'A') {
                wait();
            }
            System.out.print('A');
            letter = 'B';
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void showB() {
        try {
            while (letter != 'B') {
                wait();
            }
            System.out.print('B');
            letter = 'C';
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void showC() {
        try {
            while (letter != 'C') {
                wait();
            }
            System.out.print('C' + " ");
            letter = 'A';
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

