package LeetCode_Study.JZ_Offer_II;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class H17 {
    public static void main(String[] args) {
        System.out.println(new H17().minWindow("a", "aa")); // A DOBEC ODEBA NC
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
    }

    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();

    HashMap<String, Integer> stringIntegerHashMap=new HashMap<>();
    
            
    //    public String minWindow(String s, String t) {
//        int tLen = t.length();
//        for (int i = 0; i < tLen; i++) {7
//            char c = t n      .charAt(i);
//            ori.put(c, ori.getOrDefault(c, 0) + 1);
//        }
//        int l = 0, r = -1;
//        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
//        int sLen = s.length();
//        while (r < sLen) {
//            ++r;
//            if (r < sLen && ori.containsKey(s.charAt(r))) {
//                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
//            }
//            while (check() && l <= r) {
//                if (r - l + 1 < len) {
//                    len = r - l + 1;
//                    ansL = l;
//                    ansR = l + len;
//                }
//                if (ori.containsKey(s.charAt(l))) {
//                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
//                }
//                ++l;
//            }
//        }
//        return ansL == -1 ? "" : s.substring(ansL, ansR);
//    }

    public boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        HashMap<String, Integer> tmp=new HashMap<>();
        HashMap<String, Integer> smp=new HashMap<>();
        for (int i =0;i<t.length();i++){
            tmp.put(t.substring(i,i+1),tmp.getOrDefault(t.substring(i,i+1),0)+1);
        }
        int left = 0;
        int rigt = 0;
        int min_len = Integer.MAX_VALUE;
        int min_l=0;
        int min_r=s.length();
        while (rigt<s.length() && left<=rigt){
            System.out.println(left+" / "+rigt);
            if (tmp.containsKey(s.substring(rigt,rigt+1))){

                smp.put(s.substring(rigt,rigt+1),smp.getOrDefault(s.substring(rigt,rigt+1),0)+1);
                System.out.println(tmp);
                System.out.println(smp);
                System.out.println("|| "+left+" / "+rigt);
            }
            while (isOK(smp,tmp)){
                System.out.println("== "+left+" / "+rigt);
                if (rigt-left<min_len){
                    min_l=left;
                    min_r=rigt;
                    min_len = rigt-left;
                }
                if (tmp.containsKey(s.substring(left,left+1))){
                    smp.put(s.substring(left,left+1),smp.getOrDefault(s.substring(left,left+1),0)-1);
                }
                left++;
            }
            rigt++;

        }
        String res="";
        if (min_r>=s.length()) return "";
        for (int j=min_l;j<=min_r;j++){
            res+=s.substring(j,j+1);
        }
        return res;

    }

    public boolean isOK(HashMap<String, Integer> smp, HashMap<String, Integer> tmp){
        Iterator<Map.Entry<String, Integer>> iterator = tmp.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            if (!smp.containsKey(next.getKey())) return false;
            else if (smp.get(next.getKey())<next.getValue()) return false;
        }
        return true;
    }
}
