package LeetCode_Study.JZ_Offer_II;

public class M20 {
    public static void main(String[] args) {
        System.out.println(new M20().countSubstrings("aaa"));
    }

    public int countSubstrings(String s) {
        int len=s.length();
        if (len==1) return 1;
        int res=0;
        for (int i=0;i<len;i++){
            int l=i;
            int r=i;
            int ll=i;
            int rr=i+1;
            while (l>=0 && r<len){
                if (s.charAt(l)==s.charAt(r)){
                    l--;
                    r++;
                    res++;
                }
                else break;
            }
            while (ll>=0 && rr<len){
                if (s.charAt(ll)==s.charAt(rr)){
                    ll--;
                    rr++;
                    res++;
                }
                else break;
            }
        }

        return res;
    }
}
