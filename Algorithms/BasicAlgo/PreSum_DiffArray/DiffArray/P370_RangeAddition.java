package BasicAlgo.PreSum_DiffArray.DiffArray;

public class P370_RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];
        for (int[] update : updates) {
            arr[update[0]] += update[2];
            if (update[1] < length - 1) {
                arr[update[1] + 1] -= update[2];
            }
        }
        for (int i = 1; i < length; i++) {
            arr[i] += arr[i - 1];
        }
        return arr;
    }
}
