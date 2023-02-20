package LeetCode_Study.MO2;

public class A02 {
    class Solution {
        public String addBinary(String a, String b) {
            StringBuilder sb = new StringBuilder();
            int len =Math.max(a.length(),b.length());
            int jin = 0;
            for (int i=0;i<len;i++){
                int ac = a.length()>i?a.charAt(a.length()-i-1)-'0':0;
                int bc = b.length()>i?b.charAt(b.length()-i-1)-'0':0;
                sb.append(((jin+ac+bc)%2));
                jin = (jin+ac+bc)/2;
            }
            if (jin!=0) sb.append("1");
            return sb.reverse().toString();
        }

        public String addBinary2(String a, String b) {
            StringBuilder sb = new StringBuilder();
            int len =Math.max(a.length(),b.length());
            int jin = 0;
            for (int i=0;i<len;i++){
                int ac = a.length()>i?a.charAt(a.length()-i-1)-'0':0;
                int bc = b.length()>i?b.charAt(b.length()-i-1)-'0':0;
                sb.append(ac^bc^jin);
                if (ac==1 && bc==1){
                    jin = 1;
                }else {
                    jin = (ac^bc)&jin;
                }
            }
            if (jin!=0) sb.append("1");
            return sb.reverse().toString();
        }
    }
}
