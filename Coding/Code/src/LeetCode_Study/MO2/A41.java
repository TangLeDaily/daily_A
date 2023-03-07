package LeetCode_Study.MO2;

import java.util.LinkedList;
import java.util.Queue;

public class A41 {
    class MovingAverage {
        Queue<Integer> qe;
        int size;
        double sum;
        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            qe = new LinkedList<>();
            this.size = size;
            sum = 0;
        }

        public double next(int val) {
            if (qe.size() == size){
                sum -= qe.poll();
            }
            qe.offer(val);
            sum+=val;
            return sum / qe.size();
        }
    }
}
