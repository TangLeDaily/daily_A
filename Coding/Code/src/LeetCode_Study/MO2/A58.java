package LeetCode_Study.MO2;

import java.util.TreeSet;

public class A58 {
    class MyCalendar {
        TreeSet<int[]> ts;
        public MyCalendar() {
            ts = new TreeSet<int[]>((a,b)->a[0]-b[0]);
        }

        public boolean book(int start, int end) {
            if (ts.isEmpty()){
                ts.add(new int[]{start,end});
                return true;
            }
            int temp[] = {end,0};
            int after[] = ts.ceiling(temp);
            // int[] prev = ((after == null) ? ts.last() : ts.lower(after));
            if (after == ts.first() || ts.lower(temp)[1] <= start) {
                ts.add(new int[]{start, end});
                return true;
            }
            return false;
        }
    }
}
