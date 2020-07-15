package numOfOccurences;

import java.util.Arrays;

public class FindNumberOfOccurences {

    public boolean IsNull(int[] arr) {
        return arr == null || arr.length == 0;
    }

    public long findNumberOfOccurences(int[] arr, int n) {
        if (this.IsNull(arr))
            return 0;

        long counter = 0;
        for (int num : arr) {
            if (num == n)
                counter++;
        }
        return counter;
    }

    public long findNumberOfOccurencesInASortedArray(int[] arr, int n) {
        if (this.IsNull(arr))
            return 0;

        long counter = 0;
        int leftStart = 0;
        int rightEnd = arr.length - 1;
        int middle = (leftStart + rightEnd) / 2;

        while (leftStart <= rightEnd && leftStart >= 0) {
            middle = (leftStart + rightEnd) / 2;
            if (arr[middle] == n) {
                counter++;
                break;
            } else if (arr[middle] < n) {
                leftStart = middle + 1;
            } else if (arr[middle] > n) {
                rightEnd = middle - 1;
            }
        }
        int index = middle - 1;
        while (index >= 0) {
            if (arr[index] == n) {
                counter++;
                index--;
            } else break;
        }

        index = middle + 1;
        while (index <= arr.length - 1 && index >= 0) {
            if (arr[index] == n) {
                counter++;
                index++;
            } else break;
        }

        return counter;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 1};
        long frequency = new FindNumberOfOccurences().findNumberOfOccurences(arr, 1);
        System.out.println(frequency);
        Arrays.sort(arr);
        frequency = new FindNumberOfOccurences().findNumberOfOccurencesInASortedArray(arr, 1);
        System.out.println(frequency);
    }

}
