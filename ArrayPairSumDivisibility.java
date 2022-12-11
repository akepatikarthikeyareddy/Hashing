/*
Problem: Given An Array Of Integers And A Number K, Write A Function That Returns True If Given Array Can Be Divided Into Pairs Such That Sum Of Every Pair Is Divisible By K.

Input : Arr = [9, 5, 7, 3], k = 6
Output: True
Explanation: {(9, 3), (5, 7)} Is A Possible Solution. 9 + 3 = 12 Is Divisible By 6
And 7 + 5 = 12 Is Also Divisible By 6.
*/

import java.util.Scanner;
import java.util.HashMap;
class ArrayPairSumDivisibility{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int arrSize = input.nextInt();
        int target = input.nextInt();
        int nums[] = new int[arrSize];
        for(int i = 0; i < arrSize; i++){
            nums[i] = input.nextInt();
        }
        input.close();
        if(canPair(nums, target)){
            System.out.print("Array Can Be Divided Into Pairs");
        }
        else{
            System.out.print("Array Can't Be Divided Into Pairs");
        }
    }
    public static boolean canPair(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int rem = nums[i]%k;
            if(map.containsKey(rem))
                map.put(rem, map.get(rem)+1);
            else
                map.put(rem, 1);
        }
        for(int i: map.keySet()){
            if(i == 0){
                if(map.get(i)%2 != 0)
                    return false;
            }
            else if(2*i == k){
                if(map.get(i)%2 != 0)
                    return false;
            }
            else{
                if(map.get(i) != map.get(k-i))
                    return false;
            }
        }
        return true;
    }
}

/*
Time Complexity : O(N)
Space Complexity: O(N)
*/