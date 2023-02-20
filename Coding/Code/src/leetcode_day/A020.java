package leetcode_day;

import java.util.concurrent.*;

public class A020 {

    public ExecutorService pool = Executors.newFixedThreadPool(3);
    public CountDownLatch this_down = new CountDownLatch(3);
    /** * 动物父类 */

    public static class getJiazai implements Runnable{
        public int i;
        public CountDownLatch cb;


        public getJiazai() {
        }

        public getJiazai(int i, CountDownLatch cb) {
            this.i = i;
            this.cb = cb;
        }

        @Override
        public void run() {
            try{
                for (int j=0;j<5;j++){
                    Thread.sleep(1);
                    System.out.println("THIS is"+j+" the i is "+i);
                    //cb.await();
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        public static void main(String[] args) {
            CountDownLatch CB = new CountDownLatch(3);
            Thread threads = new Thread(new getJiazai(), "Daemon线程");
            new Thread(new getJiazai(1,CB)).start();
            new Thread(new getJiazai(2,CB)).start();
            new Thread(new getJiazai(3,CB)).start();
        }
    }

}
