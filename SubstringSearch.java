import java.util.*;

class SubstringSearch {

	public int Search(String text, String pattern) {
		int lengthofText = text.length();
		int lengthofPattern = pattern.length();
		for (int i=0; i<= lengthofText-lengthofPattern; i++) {
			int j;
			for (j=0; j<lengthofPattern; j++) {
				if(pattern.charAt(j) != text.charAt(i+j)) {
					break;
				}
			}
			if(j == lengthofPattern){
				return i;
			}
		}
		return lengthofText;
	}

	public static void main(String[] args){
		SubstringSearch ss = new SubstringSearch();
		System.out.println(ss.Search("uday","ay"));
	}
}