package LeetCode_Study.MO2;

public class A05 {
    class Solution {
        public int maxProduct(String[] words) {
            int res = 0;
            int len = words.length;
            int []tab = new int[len];
            for (int i=0;i<len;i++){
                String word = words[i];
                for (int j=0;j<word.length();j++){
                    tab[i] |= (1<<(word.charAt(j)-'a'));
                }
            }
            for (int i=0;i<len;i++){
                for (int j=i+1;j<len;j++){
                    if ((tab[i]&tab[j])==0){
                        res = Math.max(res,words[i].length()*words[j].length());
                    }
                }
            }
            return res;
        }
    }
}
