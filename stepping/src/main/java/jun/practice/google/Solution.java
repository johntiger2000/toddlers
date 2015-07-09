package jun.practice.google;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("ab");
		dict.add("i");
		dict.add("in");
		dict.add("ins");
		dict.add("fins");
		dict.add("finas");
		dict.add("finds");
		dict.add("indsz");
		dict.add("findsz");
		dict.add("agerahrah");
		Solution s = new Solution();
		//String ss = s.findLongestBottomUp(dict);
		String ss = s.findLongestTopDown(dict);
		System.out.println(ss);
	}
	
	private String ret = "";
	
	public String findLongestBottomUp(Set<String> dict) {
		find(dict, "");
		return ret;
	}
	
	private void find(Set<String> dict, String word) {
		for (char c = 'a'; c <= 'z'; ++c) {
			int n = word.length();
			for (int i = 0; i <= n; ++i) {
				String temp = word.substring(0, i) + c + word.substring(i, n);
				if (dict.contains(temp)) {
					if (temp.length() > ret.length()) {
						ret = temp;
					}
					find(dict, temp);
				}
			}
		}
	}
	
	public String findLongestTopDown(Set<String> dict) {
		while (dict.size() > 0) {
			String word = getLongest(dict);
			if (findDown(dict, word)) {
				return word;
			}
		}
		return "";
	}
	
	private String getLongest(Set<String> dict) {
		String ret = "";
		for (String word : dict) {
			if (word.length() > ret.length()) {
				ret = word;
			}
		}
		return ret;
	}
	
	private boolean findDown(Set<String> dict, String word) {
		if (word.length() == 1) {
			return true;
		}
		int n = word.length();
		for (int i = 0; i < n; ++i) {
			String temp = word.substring(0, i) + word.substring(i+1, n);
			if (dict.contains(temp)) {
				if (findDown(dict, temp)) {
					return true;
				}
			}
		}
		dict.remove(word);
		return false;
	}
	
}
