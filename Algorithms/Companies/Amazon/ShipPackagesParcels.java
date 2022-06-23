package Companies.Amazon;

import java.util.Arrays;

public class ShipPackagesParcels {
    public static long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        k -= nums.length;
        
        long ans = 0, startNum = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > startNum) {
                long count = nums[i] - startNum >= k ? k : nums[i] - startNum;
                ans += (startNum + startNum + count - 1) * count / 2; 
                k -= count;
            }
            //注意这里，需要加一个
            startNum = nums[i] + 1;
        }

        if (k > 0) {
            ans += (long) (startNum + startNum + k - 1) * k / 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,6,10,11};
        int k = 9;
        System.out.println(minimalKSum(nums, k));
    }
}


/*
Question 2
Amazon ships millions of packages regularly. There are a number of parcels that need to be shipped. Compute the minimum possible sum of
transportation costs incurred in the shipment of additional parcels in the following scenario.
• A fully loaded truck carries & parcels.
• It is most efficient for the truck to be fully
loaded.
• There are a number of parcels already online
truck as listed in parcels!.
• There are parcels with a unique id that ranges
from 1 through infinity.
The parcel id is also the cost to ship that parcel.

Given the parcel IDs which are already added in the shipment, find the minimum possible cost of shipping the items added to complete the load.
Example
parcels = [2, 3, 6,10,11]

k= 9
Parcel ids range from 1 through infinity. After reviewing the current manifest, the remaining parcels to choose from are [1, 4, 5, 7, 8, 9, 12, 13,
...]. There are 5 parcels already on the truck, and it can carry « = 9 parcels when fully loaded. Choose 4 more packages to include: [1, 4, 5, 7]. Their shipping cost is 1 + 4 + 5 + 7 = 17, which is minimal. Return 17.

Function Description

Complete the function getMinimumCost in the editor below.
getMinimum Cost has the following parameters:
int parcels[n]: the parcels already in the shipment
int k: the truck's capacity

Returns
long_int the minimum additional transportation cost incurred  
 */