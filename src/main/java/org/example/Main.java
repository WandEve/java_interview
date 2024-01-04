package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("JumpFloor(2) = " + JumpFloor(6));
        jumpFloorII(3);
        JumpFloorII(3);
    }
    //斐波那契  时间复杂度O（1）
    public static int JumpFloor(int n){
        if(n<=2){
            return n;
        }
        int pre2 = 1, pre1 = 2;
        int result = 0;
        for (int i = 3;i<=n;i++){
            result = pre1 + pre2;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }

    //变态跳台阶
    public static int jumpFloorII(int target){
        int[] dp = new int[target];
        Arrays.fill(dp,1);
        for (int i = 1;i<target;i++)
            for(int j = 0; j<i ;j++)
                dp[i] += dp[j];
        return dp[target -1];


    }
    public static int JumpFloorII(int target) {
        return (int) Math.pow(2, target - 1);
    }

    //旋转数组的最小值
    public static int minNumberInRotateArrey(int [] nums){
        if(nums.length == 0)
            return 0;
        int l = 0, h = nums.length-1;
        while (l<h){
            int m = l + (h + l) / 2;
            if(nums[m] <= nums[h])
                h = m;
            else
                l = m + 1;
        }
        return nums[l];
    }



}