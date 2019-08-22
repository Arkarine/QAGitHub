public class Main {
    public static void main(String[] args) {

        AnotherThread thr1 = new AnotherThread();
        thr1.start();

        AnotherThread thr2 = new AnotherThread();
        thr2.start();
    }
}
