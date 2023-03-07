package LeetCode_Study.MO2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A35 {
    class Solution {
        public int findMinDifference(List<String> timePoints) {
            int min=Integer.MAX_VALUE;
            List<Integer> timeS = new ArrayList<>();
            for (String str:timePoints){
                timeS.add(getMinutes(str));
            }
            Collections.sort(timeS);
            int totime = timeS.get(0);
            for (int i=1;i<timeS.size();i++){
                min = Math.min(min, timeS.get(i)-timeS.get(i-1));
            }
            min = Math.min(min, totime + 1440 - timeS.get(timeS.size()-1));
            return min;
        }

        public int getMinutes(String t) {
            return 60 * (10*(t.charAt(0)-'0')+(t.charAt(1)-'0'))+10*(t.charAt(3)-'0')+(t.charAt(4)-'0');
        }
    }
}
