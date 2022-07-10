package PopularTopic.TwoSum;

import java.util.Arrays;

public class P923_3sumWithMultiplicity {
    //o(n^2)
    public int threeSumMulti(int[] arr, int target) {
        int MOD = 1_000_000_007;
        long count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int l = i + 1, r = arr.length - 1;
            while (l < r) {
                int sum = arr[i] + arr[l] + arr[r];
                if (sum > target) {
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    if (arr[l] == arr[r]) {
                        count += (r - l + 1) * (r - l) / 2;
                        break;
                    } else {
                        int leftCount = 1, rightCount = 1;
                        while (l < r && arr[l] == arr[l + 1]) {
                            leftCount++;
                            l++;
                        }
                        while (l < r && arr[r] == arr[r - 1]) {
                            rightCount++;
                            r--;
                        }
                        count += leftCount * rightCount;
                        l++;
                        r--;
                    }
                }
            }
        }
        return (int)(count % MOD);
    }
}
