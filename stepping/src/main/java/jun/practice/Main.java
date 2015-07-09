package jun.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
	
    public boolean anagram(String s, String t) {
        // write your code here
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            int count = 0;
            if (map.containsKey(ch)) {
                count = map.get(ch);
            }
            map.put(ch, count + 1); 
        }
        for (int i = 0; i < t.length(); ++i) {
            char ch = t.charAt(i);
            if (!map.containsKey(ch) || map.get(ch) == 0) {
                return false;
            }
            map.put(ch, map.get(ch) - 1); 
        }
        return true;
    }
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int prev1 = 2;
        int prev2 = 1;
        int ret = prev1 + prev2;
        for (int i = 3; i <= n; ++i) {
            ret = prev1 + prev2;
            prev2 = prev1;
            prev1 = ret;
        }
        return ret;
    }

    public List<String> wordBreak(String s, Set<String> dict) {
        if (s== null || s.length() == 0) {
            return null;
        }
        List<String> ret[] = new List[s.length()+1];
        ret[0] = new ArrayList<String>();
        ret[0].add("");
        for (int i = 1; i <= s.length(); ++i) {
            ret[i] = new ArrayList<String>();
            for (int j = 0; j < i; ++j) {
                String str = s.substring(j, i);
                if (ret[j].size() > 0 && dict.contains(str)) {
                    for (String exist : ret[j]) {
                        String temp = (exist + " " + str).trim();
                        if (!ret[i].contains(temp)) {
                            ret[i].add(temp);
                        }
                    }
                }
            }
        }
        return ret[s.length()];
    }

}
