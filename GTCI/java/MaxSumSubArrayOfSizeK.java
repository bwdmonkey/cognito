class MaxSumSubArrayOfSizeK {
  public static int findMaxSumSubArray(int k, int[] arr) {
    int i = 0; // window start
    int maxSum = 0; // result - max sum

    int curSum = 0;
    for (int j = 0; j < arr.length; j++) {
      curSum += arr[j];
      if (j - i + 1 > k)
        curSum -= arr[i++];
      maxSum = Math.max(curSum, maxSum);
    }
    return maxSum;
  }
}
