package leetcode_day;

public class A029 {
    public int maxProduct(String[] words) {
        int LEN = words.length;
        int []mask = new int[LEN];
        // create the every word's mask
        for (int i=0;i<LEN;i++){
            int length = words[i].length();
            for (int j=0;j<length;j++){
                mask[i] |= 1<<(words[i].charAt(j) - 'a');
            }
        }
        int mmax = 0;
        for (int i=0;i<LEN;i++){
            for (int j=i+1;j<LEN;j++){
                if ((mask[i] & mask[j]) == 0){
                    // means no similar
                    mmax = Math.max(words[i].length() * words[j].length(), mmax);
                }
            }
        }
        return mmax;
    }
}
