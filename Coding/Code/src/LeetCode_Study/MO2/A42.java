package LeetCode_Study.MO2;

import java.util.LinkedList;
import java.util.Queue;

public class A42 {
    class RecentCounter {
        Queue<Integer> qe;
        public RecentCounter() {
            qe = new LinkedList<>();
        }

        public int ping(int t) {
            qe.offer(t);
            while (qe.peek()<t-3000){
                qe.poll();
            }
            return qe.size();
        }
    }
}
