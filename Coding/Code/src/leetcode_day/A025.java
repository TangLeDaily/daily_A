package leetcode_day;

public class A025 {
    public static void main(String[] args) {
        System.out.println(new A025().divide(23,5));
    }
    public int divide(int a, int b) {
        if (b==1) return a;
        if (b==-1) return a==Integer.MIN_VALUE?Integer.MAX_VALUE:-a;
        if (a==0) return 0;
        boolean fuhao = (a^b) >= 0;
        a = a<0?a:-a;
        b = b<0?b:-b;
        int out = 0;
        while (a<=b){
            int base = 1;
            int de = b;
            while (a-de <= de){
                base <<= 1;
                de <<= 1;
            }
            out+=base;
            a-=de;
        }
        return fuhao?out:-out;

    }
}
