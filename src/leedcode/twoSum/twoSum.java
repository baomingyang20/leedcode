package leedcode.twoSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class twoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 2, 4 };
		System.out.println(Arrays.toString(twoSum(nums,6)));
	}

	public static int[] twoSum(int[] nums, int target) {
		//结果集
		int result[] = new int[2];
		HashMap<Integer, ArrayList<Integer>> h = new HashMap<>(nums.length);
		//将不同的键值存入HashMap，其中键值相同但索引不同的只保存两个，两个的索引存在ArrayList中
		for (int i = 0; i < nums.length; i++) {
			ArrayList<Integer> c = new ArrayList<>();
			if (!h.containsKey(nums[i])) {
				c.add(i);
				h.put(nums[i], c);
			} else {
				if (h.get(nums[i]).size() == 1) {
					h.get(nums[i]).add(i);
				}
			}
		}
		//判断是否和为target，键值不同的两数不能相同，键值相同的将对应ArrayList内元素存入结果集
		for (int i = 0; i < nums.length; i++) {
			int e = target - nums[i];
			if (h.containsKey(e)) {
				if (h.get(e).size() == 1 && e != nums[i]) {
					result[0] = i;
					result[1] = h.get(e).get(0);
					break;
				}
				if (h.get(e).size() == 2) {
					result[0] = i;
					result[1] = h.get(e).get(1);
					break;
				}
			}
		}
		return result;
	}
}
