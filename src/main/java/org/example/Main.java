package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

    }
    //两个栈实现队列


    //第一个只出现一次的字符位置
    public static void FirstNotRepeatingChar(){
        String str = "abaccbd";
        int[] cnts = new int[128];
        for(int i = 0; i < str.length(); i++){
            cnts[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++){
            if(cnts[str.charAt(i)] == 1){
                System.out.println(i);
            }
        }
    }
    //顺时针打印矩阵
    public static ArrayList<Integer> printMatrix(){
        int[][] matrx = new int[4][4];
        int count = 1;

        // Assign the consecutive integer values to the matrix
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrx[i][j] = count++;
            }
        }
        
        ArrayList<Integer> ret = new ArrayList<>();
        int r1 = 0, r2 = matrx.length-1, c1 = 0, c2 = matrx[0].length - 1;
        while (r1 <= r2 && c1 <=c2){
            //up
            for(int i = c1; i <= c2; i++){
                ret.add(matrx[r1][i]);
            }
            //right
            for (int i = r1 + 1; i <= r2; i++){
                ret.add(matrx[i][c2]);
            }
            //down
            if(r1 != r2){
                for (int i = c2-1;i >= c1;i--){
                    ret.add(matrx[r2][i]);
                }
            }

            //left
            if (c1 != c2){
                for (int i = r2 -1; i >r1; i--){
                    ret.add(matrx[i][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }

        return ret;
    }

    //替换空格
    public static String replaceSpace(StringBuffer stringBuffer){
        int P1 = stringBuffer.length() - 1;
        for(int i =0; i <= P1;i++){
            if(stringBuffer.charAt(i) == ' '){
                stringBuffer.append("  ");
            }
        }
        int P2 = stringBuffer.length() -1;
        while ((P1>=0 && P2 >P1)){
            char c = stringBuffer.charAt(P1--);
            if(c == ' '){
                stringBuffer.setCharAt(P2--,'0');
                stringBuffer.setCharAt(P2--,'2');
                stringBuffer.setCharAt(P2--,'%');
            }else {
                stringBuffer.setCharAt(P2--,c);
            }
        }
        return stringBuffer.toString();
    }
    //二维数组中的查找
    public static boolean Find(int target){
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        if(matrix == null || matrix.length ==0 ||matrix[0].length == 0){
            return false;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int r = 0, c = cols-1;
        while (r <= rows -1 && c >=0){
            if(target == matrix[r][c]){
                return true;
            }else if(target >matrix[r][c]){
                r++;
            }else {
                c--;
            }
        }
        return false;
    }


    //数组中重复的数字
    public static int duplicate(int[] nums){
        for(int i=0;i<nums.length;i++){
            while (nums[i]!=i){
                if(nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                swap(nums,i,nums[i]);
            }
        }
        return 0;
    }

    public static void swap(int[] nums,int i,int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] =t;
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
        for (int i = 1;i<target;i++) {
            for(int j = 0; j<i ;j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target -1];


    }
    public static int JumpFloorII(int target) {
        return (int) Math.pow(2, target - 1);
    }


}