package omgraf.mt.ex0001;

// Управление главным потоком исполнения
class CurrentThreadDemo {
    public static void main(String args[]) {
        Thread t = Thread.currentThread();
        System.out.println("Текущий поток исполнения: " + t);

        // изменить имя потока исполнения
        t.setName("My Thread");

        System.out.println("После изменения имени потока: " + t);
        try {
            for (int n = 5; n > 0; n--) {
                System.out.println(n);
                Thread.sleep(1000);
            }
        } catch (InterruptedException е) {
            System.out.println("Главный поток исполнения прерван");
        }
    }
}
