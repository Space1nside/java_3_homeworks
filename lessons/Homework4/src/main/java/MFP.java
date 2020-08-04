public class MFP {
    final Object print = new Object();
    final Object scan = new Object();

    public void scanFile(String fileName, boolean online) {
        synchronized (scan) {
            if (online) {
                System.out.print("Идёт сканирование файла " + fileName + ", пожалуйста подождите");
                for (int i = 0; i < 6; i++) {
                    System.out.print(".");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println();
                System.out.println("Файл " + fileName + " просканирован.");
            } else {
                synchronized (print) {
                    System.out.print("Идёт сканирование файла " + fileName + ", пожалуйста подождите");
                    for (int i = 0; i < 6; i++) {
                        System.out.print(".");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println();
                    System.out.println("Файл " + fileName + " просканирован.");
                }
            }
        }
    }

    public void printFile(String fileName) {
        System.out.println();
        synchronized (print) {
            System.out.print("Идёт печать файла " + fileName + ", пожалуйста подождите");
            for (int i = 0; i < 6; i++) {
                System.out.print(".");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
            System.out.println("Файл " + fileName + " распечатан.");
        }
    }
}

class MainMFP {
    public static void main(String[] args) {
        MFP mfp = new MFP();
        Thread human1 = new Thread(new Runnable() {
            @Override
            public void run() {
                    mfp.scanFile("Document_1", true);
            }
        });
        human1.start();

        Thread human2 = new Thread(new Runnable() {
            @Override
            public void run() {
                mfp.printFile("Document_2");
            }
        });
        human2.start();

        Thread human3 = new Thread(new Runnable() {
            @Override
            public void run() {
                mfp.scanFile("Document_3", false);
            }
        });
        human3.start();

        Thread human4 = new Thread(new Runnable() {
            @Override
            public void run() {
                mfp.printFile("Document_3");
            }
        });
        human4.start();
    }
}
