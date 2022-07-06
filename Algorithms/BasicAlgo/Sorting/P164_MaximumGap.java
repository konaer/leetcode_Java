package BasicAlgo.Sorting;

import java.util.Arrays;

public class P164_MaximumGap {
    //桶排 o(n)
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int minNum = Arrays.stream(nums).min().getAsInt();
        int maxNum = Arrays.stream(nums).max().getAsInt();
        //此处是为了排除 1,1,1,1这种情况
        int gap = Math.max(1, (maxNum - minNum) / (nums.length - 1));
        int size = (maxNum - minNum) / gap + 1;
        int[][] bucket = new int[size][2];
        for (int i = 0; i < size; i++) {
            Arrays.fill(bucket[i], -1);
        }
        for (int i = 0; i < nums.length; i++) {
            int index = (nums[i] - minNum) / gap;
            if (bucket[index][0] == -1) {
                bucket[index][0] = bucket[index][1] = nums[i];
            } else {
                bucket[index][0] = Math.min(bucket[index][0], nums[i]);
                bucket[index][1] = Math.max(bucket[index][1], nums[i]);
            }
        }
        int ans = 0, pre = -1;
        for (int i = 0; i < size; i++) {
            if (bucket[i][0] == -1) {
                continue;
            }
            //这里之所以要使用pre，是因为如果3号桶没元素，那么就是计算2号桶和4号桶了。
            //如果不用pre，这里就没法计算
            if (pre != -1) {
                ans = Math.max(ans, bucket[i][0] - bucket[pre][1]);
            }
            pre = i;
        }
        return ans;
    }
}
