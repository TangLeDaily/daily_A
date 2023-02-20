package LeetCode_ID;

import java.util.TreeSet;

public class M729 {
    public TreeSet<int []> TS ;
    public void MyCalendar() {
        TS = new TreeSet<int []>((a, b) -> a[0] - b[0]);//按照第0位从小到大排序(这样Set的lower和ceiling也是按照第0位查找)
    }

    public boolean book(int start, int end) {
        if (TS.isEmpty()){
            TS.add(new int[]{start, end});
            return true;
        }
        int []temp = new int[]{end, 0};
        int []lower = TS.lower(temp); //比end小一个的已用区间
        if (lower == null || start>=lower[1]) //区间不存在或者start比这个已用区间的end还大（可以插入）
        {
            TS.add(new int[]{start, end});
            return true;
        }
        return false;
    }
}
