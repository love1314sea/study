package leetcode;


import java.util.*;


/*
思路：
1 先排序
2 找到第一个正数的下标：nonnegativeNumIndex
3 从头遍历到nonnegativeNumIndex
  先两个数相加，如果是负数，就从正数中找这个数
              如果是正数，就从负数中找这个数
 */
public class Leetcode {
    //efghgafcde

    public int findFirtNonnegativeNumIndex(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] >= 0)
                return i;
        }
        return nums.length;
    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int firtNonnegativeNumIndex = findFirtNonnegativeNumIndex(nums);
        if (firtNonnegativeNumIndex >= nums.length || firtNonnegativeNumIndex < 0)
            return res;


        for (int i = 0; i <= firtNonnegativeNumIndex; ++i) {//遍历次数
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 1; ++j) {
                if (j > i+1 && nums[j] == nums[j - 1])
                    continue;
                int pos = Math.max(j + 1, firtNonnegativeNumIndex);
                if(nums[i] + nums[j] + nums[pos] > 0)
                    break;
                for (int k = pos; k < nums.length; k++) {
                    if (k > pos && nums[k] == nums[k - 1])
                        continue;
                    if(nums[i] + nums[j] + nums[k] > 0)
                        break;
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        System.out.println(nums[i] + ":" + nums[j] + ":" + nums[k]);
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode leetcode = new Leetcode();
        int[] nums = new int[]{0,0,0,0,0};
        leetcode.threeSum(nums);
    }
}
