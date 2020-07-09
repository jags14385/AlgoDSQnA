package productOfArrayExceptSelf;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int productSoFar = 1;
        int[] resultArray = new int[nums.length];

        //get product of elements all indexes from 0 till currentIndex-1
        for (int i = 0; i < nums.length; i++) {
            resultArray[i] = productSoFar;
            productSoFar *= nums[i];
        }

        productSoFar = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            resultArray[i] *= productSoFar;
            productSoFar *= nums[i];
        }
        return resultArray;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1,2,3,4};
        // Using The Greedy Approach
        int[] arr = new int[]{1, -2, 0, 1};
        int[] result = new ProductOfArrayExceptSelf().productExceptSelf(arr);
        System.out.println(Arrays.toString(result));
    }

}


