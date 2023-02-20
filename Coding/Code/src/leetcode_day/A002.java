package leetcode_day;

public class A002 {
    static class Solution {
        public String validIPAddress(String queryIP) {
            int len =queryIP.length();
            if(len==0) return "Neither";
            if (queryIP.charAt(0)=='.' || queryIP.charAt(0)==':' || queryIP.charAt(len-1)=='.' || queryIP.charAt(len-1)==':'){
                return "Neither";
            }
            if(isIPV6(queryIP)){
                return "IPv6";
            }
            else if(isIPv4(queryIP)){
                return "IPv4";
            }
            else return "Neither";
        }
        public boolean isIPv4(String IP){
            int length=0;
            for(String strNow : IP.split("\\.")){
                //System.out.println(strNow);
                length++;
                if (strNow.length()==1){
                    if (strNow.charAt(0)>='0' && strNow.charAt(0)<='9'){
                        continue;
                    }
                    else return false;
                }
                else if(strNow.length()==2){
                    if (strNow.charAt(0)=='0') return false;
                    if (V4ASCII(strNow.charAt(0)) && V4ASCII(strNow.charAt(1))) continue;
                    else return false;
                }
                else if(strNow.length()==3){
                    if (V4ASCII(strNow.charAt(0)) && V4ASCII(strNow.charAt(1)) && V4ASCII(strNow.charAt(2))){
                        if (strNow.charAt(0)=='0') return false;
                        if (strNow.charAt(0)>'2') return false;
                        if (strNow.charAt(0)=='2'){
                            if(strNow.charAt(1)>'5') return false;
                            if(strNow.charAt(1)=='5'){
                                if(strNow.charAt(2)>'5') return false;
                            }
                        }
                    }
                    else return false;
                }
                else  return false;
            }
            if(length==4) return true;
            else return false;
        }
        public boolean isIPV6(String IP){
            int length=0;
            for (String strNow : IP.split(":")){
                length++;
                // System.out.println(strNow);
                if(strNow.length()<=4 && strNow.length()>=1){
                    for(int i=0;i<strNow.length();i++){
                        if (!V6ASCII(strNow.charAt(i))) {
                            return false;
                        }
                    }
                }
                else return false;
            }
            // System.out.println(length);
            if(length==8) return true;
            else return false;
        }
        public boolean V6ASCII(char c){
            // System.out.println(c);
            if((c>='0' && c<='9') || (c>='a' && c<='f') || (c>='A' && c<='F')){
                // System.out.println("is true");
                return true;
            }
            else return false;
        }
        public boolean V4ASCII(char c){
            if(c>='0' && c<='9') return true;
            else return false;
        }
    }
    public static void main(String[] args) {
        String IP="2001:db8:85a3:0::8a2E:0370:7334";
        String IP41="172.16.254.1";
        // Solution solo = null;
        System.out.println(new Solution().validIPAddress(IP));
    }


}
