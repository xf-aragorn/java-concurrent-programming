package ch2;

public class SimpleWN {
    final static Object object = new Object();

    public static class T1 extends Thread {


        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + "T1");
                try {
                    System.out.println(System.currentTimeMillis() + "T1 wait for object");
                    object.wait();// 这里会同步释放监视器锁，使其它线程可以获取到当前对象的监控器锁。
                                  // 当其它线程调用object.notify()后，当前线程被唤醒，但是仍然不能恢复执行，因为必须要等其它线程释放锁且当前线程重新获取到锁才会执行（这个过程是jvm实现的）
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + "T1 end");
            }
        }
    }

    public static class T2 extends Thread {


        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + "T2");
                object.notify();//它并不会释放监视器锁，必须等到同步块执行完才会释放
                System.out.println(System.currentTimeMillis() + "T2 end");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();
        t2.start();
    }
}
