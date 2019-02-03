import java.util.*;
class LongestRepeatingSubstring {

	public String reverseString(String text){
		StringBuilder reversedString = new StringBuilder();
		int lengthofText = text.length();
		for(int index = lengthofText-1 ; index >=0 ; index--) {
			reversedString.append(text.charAt(index));
		}
		return reversedString.toString();
	}

	public String longestCommonPrefix(String text1, String text2) {
		int commonlength = Math.min(text1.length(), text2.length());
		for (int i=0; i<commonlength; i++) {
			if(text1.charAt(i) != text2.charAt(i)) {
				return text1.substring(0,i);
			}
		}
		return text1.substring(0,commonlength);
	}

	public List<String> getSuffixes(String text){
		int lengthofText = text.length();
		List<String> suffixesList = new ArrayList<>();
		for (int index = 0; index < lengthofText ; index++) {
			suffixesList.add(text.substring(index,lengthofText));
		}
		return suffixesList;
	}

	public String longestCommonSubstring(String text) {
		int lengthofText = text.length();
		List<String> suffixes = getSuffixes(text);
		Collections.sort(suffixes);
		String longestSubstring = "";
		for (int i=0; i<lengthofText-1; i++) {
			String tempstring = longestCommonPrefix(suffixes.get(i),suffixes.get(i+1));
			if(tempstring.length() > longestSubstring.length()) {
				longestSubstring = tempstring;
			}
		}
		return longestSubstring;
	}

	public List<String> getPrefixes(String text){
		int lengthofText = text.length();
		List<String> prefixesList = new ArrayList<>();
		for (int index = 0; index < lengthofText +1 ; index++) {
			prefixesList.add(text.substring(0,index));
		}
		return prefixesList;
	}

	public static void main(String[] args){
		LongestRepeatingSubstring lrs = new LongestRepeatingSubstring();
		/*
			for (String s : lrs.getSuffixes("uday")){
				System.out.println(s);
			}
			for (String s : lrs.getPrefixes("uday")){
				System.out.println(s);
			}
			System.out.println(lrs.longestCommonPrefix("uday","udayrajsawhney"));
		*/
		System.out.println(lrs.longestCommonSubstring("geeksforgeeks"));
	}
}