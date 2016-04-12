package omgraf.mt.ex0008;

// An incorrect implementation of a producer and consumer.
class Q {
    int n;

    synchronized int get() {
        System.out.println("Got: " + n);
        return n;
    }

    synchronized void put(int n) {
        this.n = n;
        System.out.println("Put: " + n);
    }
}

class Producer implements Runnable {
    Q q;

    Producer(Q q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    public void run() {
        /*int i = 0;

        while(true) {
            q.put(i++);
        }*/

        for (int i = 0; i < 20; i++) {
            q.put(i);
        }
    }
}

class Consumer implements Runnable {
    Q q;

    Consumer(Q q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        /*while (true) {
            q.get();
        }*/

        for (int i = 0; i < 20; i++) {
            q.get();
        }
    }
}

class PC {
    public static void main(String args[]) {
        Q q = new Q();
        Producer p = new Producer(q);
        Consumer c = new Consumer(q);

        //System.out.println("Press Control-C to stop.");
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.print(". ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}