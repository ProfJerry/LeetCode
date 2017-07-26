package hash_table;

import java.util.Hashtable;

/**
 * 1. Two Sum 
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 * @author rizh
 *
 */
public class TwoSum {

	public static int[] solution(int[] nums, int target){
		int[] result = new int[2];
		
		if(nums == null || nums.length < 2){
			return result;
		}
		
		Hashtable<Integer, Integer> hashTable = new Hashtable();
		for(int i = 0;i<nums.length;i++){
			if(hashTable.containsKey(target - nums[i])){
				result[0] = hashTable.get(target - nums[i]);
				result[1] = i;
				return result;
			}else{
				hashTable.put(nums[i], i);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args){
		int[] nums = {2, 2, 7, 11, 15};
		int target = 4;
		int[] result = solution(nums, target);
		for(int i:result){
			System.out.print(i + " ");
		}
	}
}
