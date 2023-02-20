package leetcode_day;

import java.util.Random;

public class A014 {
    public class Solution {
        Random rd = new Random();
        public double r;
        public double x0;
        public double y0;
        public Solution(double radius, double x_center, double y_center) {
            r = radius;
            x0 = x_center;
            y0 = y_center;
        }

        public double[] randPoint() {
            double x = rd.nextDouble()*2*r-r;
            double y = rd.nextDouble()*2*r-r;
            // 此时是一个正方形区域均匀分布
            if (Math.sqrt(x*x+y*y) <= r) return new double[]{x+x0,y+y0};
            else return randPoint();
        }
    }
}
