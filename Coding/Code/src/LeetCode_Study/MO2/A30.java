package LeetCode_Study.MO2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class A30 {

    class RandomizedSet {
        List<Integer> nums;
        HashMap<Integer, Integer> hmp;
        Random rand;
        /** Initialize your data structure here. */
        public RandomizedSet() {
            nums = new ArrayList<>();
            hmp = new HashMap<>();
            rand =new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (hmp.containsKey(val)){
                return false;
            }
            nums.add(val);
            hmp.put(val, nums.size()-1);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!hmp.containsKey(val)){
                return false;
            }
            int index = hmp.get(val);
            int lastnum = nums.get(nums.size()-1);
            nums.set(index, lastnum);
            nums.remove(nums.size()-1);
            hmp.put(lastnum, index);
            hmp.remove(val);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int randomIndex = rand.nextInt(nums.size());
            return nums.get(randomIndex);
        }
    }


}
