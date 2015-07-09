package uber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * "  And so, this is a  sentence." -> 
 * "  sentence a, is this so  And."
 * ?!;,.
 */

class Solution {
  public static void main(String[] args) {
	    System.out.println(reverse("¿And ??_% so, this is a    sentence?"));
	    //System.out.println(reverse("And so, this is a  sentence?"));
  }
  
  public static String reverse(String sentence) {
	    if (sentence == null || sentence.equals("")) {
	      return "";
	    }
	    
	    String charWord = "[a-zA-Z_0-9]";
	    String charNonWord = "[^a-zA-Z_0-9]";
	    
	    String[] words = sentence.split(charNonWord+"+");
	    String[] nonWords = sentence.split(charWord+"+");
	    	    
	    StringBuilder sb = new StringBuilder();
	    int i = 0;
	    int j = 0;
	    if (sentence.substring(0, 1).matches(charNonWord)) {
	    	sb.append(nonWords[0]);
	    	j = 1;
	    }
	    for (; i < words.length; ++i, ++j) {
	      sb.append(words[words.length-i-1]);
	      if (j < nonWords.length)
	        sb.append(nonWords[j]);
	    }
	    return sb.toString();
	  }
}
