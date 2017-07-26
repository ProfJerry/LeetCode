package hash_table;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * @author rizh
 *
 */
public class LongestSubstring {
	
	public static int solution(String s){
		int result = 0;
		
		if(s == null){
			return result;
		}
		
		HashMap<Character, Integer> hashmap = new HashMap();
		char[] ch = s.toCharArray();
		int length = ch.length;
		if(length == 0){
			return result;
		}
		
		int tmp = 0;
		for(int i=0;i<length;i++){
			if(hashmap.containsKey(ch[i])){
				//如果找到了重复的字符，就从重复字符的下一个字符开始最长子串的计算
				i = hashmap.get(ch[i]);
				//清除hashmap并重新统计
				hashmap.clear();
				result = tmp>result?tmp:result;
				tmp = 0;
			}else{
				tmp ++;
				hashmap.put(ch[i], i);
			}
		}
		
		result = tmp>result?tmp:result;
		
		return result;
	}
	
	public static void main(String[] args){
		String s = "bbbbacebac";
		System.out.println(solution(s));
	}
}
