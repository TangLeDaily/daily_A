package leetcode_day;

public class A023 {
    public static Integer count = 0;
    public static Integer total = 10;
    public static String flag = "lock";

    public static void main(String[] args) {
//        A023 a = new A023();
//        new Thread(a.new prod()).start();
        String k = "77777";
        int z =8;
        binaryToDecimal(z);
        int a=Integer.parseInt(k,8);
        // int b=Integer.valueOf(k).intValue();
        System.out.println(a);
    }
    public static void binaryToDecimal(int n){
        int t = 0;  //用来记录位数
        int bin = 0; //用来记录最后的二进制数
        int r = 0;  //用来存储余数
        while(n != 0){
            r = n % 2;
            n = n / 2;
            bin += r * Math.pow(10,t);
            t++;
        }
        System.out.println(bin);
    }
//    public class prod implements Runnable{
//
//        @Override
//        public void run() {
//            synchronized (flag){
//                while (count == total){
//                    flag.wait();
//                }
//                count++;
//                flag.notifyAll();
//            }
//        }
//    }
//
//    public class  cuns implements Runnable{
//        @Override
//        public void run(){
//            synchronized (flag){
//                while (count == 0)
//                    flag.wait();
//            }
//            count--;
//            flag.notifyAll();
//
//        }
//    }

}
