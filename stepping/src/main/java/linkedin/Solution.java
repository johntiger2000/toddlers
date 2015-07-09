package linkedin;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 */

class Solution {
	public static void main(String[] args) {
		printFactors(4);
	}
	/**
	 * Given two words as Strings, determine if they are isomorphic. Two words are called isomorphic
	 * if the letters in one word can be remapped to get the second word. Remapping a letter means replacing all
	 * occurrences of it with another letter while the ordering of the letters remains unchanged. No two letters
	 * may map to the same letter, but a letter may map to itself.
	 *
	 * Example:
	 *   given "foo", "app"; returns true
	 *     we can map 'f' -> 'a' and 'o' -> 'p'
	 *
	 *   given "foo", "boa"; returns false
	 *     we can map 'f' -> 'b', 'o' -> 'o', we can't map 'o' -> 'a'
	 *
	 *   given "bar", "foo"; returns false
	 *     we can't map both 'a' and 'r' to 'o'
	 *
	 *   given "turtle", "tletur"; returns true
	 *     we can map 't' -> 't', 'u' -> 'l', 'r' -> 'e', 'l' -> 'u', 'e' ->'r'
	 *
	 *   given "ab", "ca"; returns true
	 *     we can map 'a' -> 'c', 'b' -> 'a'
	 */
	public static boolean isIsomorphic(String firstWord, String secondWord) {
	  // implementation...
	  if (firstWord == null || secondWord == null || firstWord.length() != secondWord.length()) {
	      return false;
	  }
	  Map<Character, Character> map = new HashMap<Character, Character>();
	  Map<Character, Character> reverse = new HashMap<Character, Character>();
	  for (int i = 0; i < firstWord.length(); ++i) {
	      char firstChar = firstWord.charAt(i);
	      char secondChar = secondWord.charAt(i);
	      if (map.containsKey(firstChar)) {
	          if (map.get(firstChar) != secondChar) {
	              return false;
	          }
	      } else if (reverse.containsKey(secondChar)) {
	          if (reverse.get(secondChar) != firstChar) {
	              return false;
	          }
	      } else {
	          map.put(firstChar, secondChar);
	          reverse.put(secondChar, firstChar);
	      }
	  }
	  return true;
	}


	/* printFactors(12)

	"12*1"
	"6*2"
	"4*3"
	"3*2*2"

	 */
	public static void printFactors(int n) {
	    Set<List<Integer>> ret = new HashSet<List<Integer>>();
	    List<Integer> temp = new ArrayList<Integer>();
	    factors(n, temp, ret);
	    //print(ret);
	    System.out.println(ret);
	}

	public static void factors(int n, List<Integer> temp, Set<List<Integer>> ret) {
	    if (n == 1) {
	        List<Integer> list = new ArrayList<Integer>();
	        list.addAll(temp);
	        while (list.size() <= 1) {
	        	list.add(1);
	        }
	        Collections.sort(list);
	        ret.add(list);
	        return;
	    }
	    
	    for (int i = 2; i <= n; ++i) {
	        if (n % i == 0) {
	            temp.add(i);
	            factors(n / i, temp, ret);
	            temp.remove(temp.size()-1);
	        }
	    }
	}
	            
	            
	            
}

