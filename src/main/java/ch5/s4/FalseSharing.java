package ch5.s4;

public class FalseSharing implements Runnable {
    public final static int NUM_THREADS = 6;
    public final static long ITERATIONS = 500L * 1000L * 1000L;
    private final int arrayIndex;
    //如果能够在一个缓存行里装下，CPU每次会把数组中尽量多的数据装入缓存行。当一个线程更新了数组中的一个元素时，缓存行中的数组数据都会失效，导致线程每次都要重新从内存中获取数据！
    private static VolatileLong[] longs = new VolatileLong[NUM_THREADS];
    static {
        for(int i=0;i<longs.length;i++){
            longs[i] = new VolatileLong();
        }
    }

    public FalseSharing(final int arrayIndex) {
        this.arrayIndex = arrayIndex;
    }

    public static void main(final String[] args) throws InterruptedException {
        final long start = System.currentTimeMillis();
        runTest();
        System.out.println("duration = " + (System.currentTimeMillis() - start));
    }

    private static void runTest() throws InterruptedException {
        Thread[] threads = new Thread[NUM_THREADS];

        for(int i=0;i< threads.length;i++){
            threads[i] = new Thread(new FalseSharing(i));
        }

        for(Thread t: threads){
            t.start();
        }

        for(Thread t:threads){
            t.join();
        }
    }

    @Override
    public void run() {
        long i = ITERATIONS +1;
        while(0!= --i){
            longs[arrayIndex].value = i;
        }
    }

    public final static class VolatileLong {
        public volatile long value = 0L;
        //加上这些变量声明，可以补全一个缓存行（64位），防止每个线程每次都去刷新缓存！如果不补全，每次都会刷新缓存。
//        public long p1, p2, p3, p4, p5, p6, p7;
    }
}
