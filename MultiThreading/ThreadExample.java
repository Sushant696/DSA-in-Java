package MultiThreading;

class DownloadImage {

    synchronized void downloadImage(String name, int size) {
        for (int i = 0; i < size; i++) {
            System.out.println("Downloading Image " + name + i + ".jpg");
        }
    }
}

class MyThread extends Thread {

    DownloadImage dref;

    MyThread(DownloadImage dref) {
        this.dref = dref;
    }

    public void run() {
        dref.downloadImage("dog", 10);
    }
}

class YourThread extends Thread {

    DownloadImage dref;

    YourThread(DownloadImage dref) {
        this.dref = dref;
    }

    public void run() {
        dref.downloadImage("cat", 10);
    }
}

class ThreadExample implements Runnable {

    public void run() {
        // Runnable implementation
    }

    public static void main(String[] args) {
        System.out.println("Application started running: ");

        // Avoid excessive printing
        for (int i = 0; i < 10; i++) {
            System.out.println("Download image dog" + i + ".jpg");
        }

        DownloadImage dref = new DownloadImage();
        MyThread t1 = new MyThread(dref);
        YourThread t2 = new YourThread(dref);

        t1.start();
        t2.start();

        System.out.println("Application stopped");
    }
}
