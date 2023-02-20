package other;



public class main {
    public String getFormatLogString(String content, int colour) {
        // 36:绿色
        int type = 0;
        boolean hasType = type != 1 && type != 3 && type != 4;
        if (hasType) {
            return String.format("\033[%dm%s\033[0m", colour, content);
        } else {
            return String.format("\033[%d;%dm%s\033[0m", colour, type, content);
        }
    }
    public static double rand(){
        // get [0,1) random
        return Math.random();
    }
    public static int rand_range(int num){
        // get [1, num] int_random
        return (int)(rand()*num)+1;
    }
    public static void main(String[] args) {
        int color=3;
        int lei=10;
        int zhulei=1;
        int zhu=555;
        int fu=150;
        int c = 0;
        int sum[] = new int[7];
        for(int i=0; i<10000; i++){
            color = rand_range(6);
            zhulei = rand_range(5);
            zhu = 300 + rand_range(300);
            fu = 100 + rand_range(200);
            int dalei = rand_range(3);
            if(dalei==1){
                lei = 9 + rand_range(3);
            }
            else if (dalei==2){
                lei = 19+rand_range(9);
            }
            else{
                lei = 29 +rand_range(3);
            }

            c = new test().int_zhuanga(color,lei,zhulei,zhu,fu);
            // c = (int)(rand()*7)+1;
            sum[c-1]++;
        }
//        for(int i =0;i<7;i++){
//            System.out.println(i+1 +" Numbers: "+sum[i]);
//        }

    }
}