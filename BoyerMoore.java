import java.util.*;

class BoyerMoore {

	private String text;
	private String pattern;
	private Map<Character,Integer> mismatchShiftTable;

	public BoyerMoore(String text, String pattern){
		this.text = text;
		this.pattern = pattern;
		this.mismatchShiftTable = new HashMap<>();
	}

	public void precomputeShift() {
		int lengthofPattern = this.pattern.length();
		for (int i=0; i<lengthofPattern; i++) {
			char actualCharacter = this.pattern.charAt(i);
			int maxshift = Math.max(1,lengthofPattern-i-1);
			this.mismatchShiftTable.put(actualCharacter, maxshift);
		}
	}

	public int search() {
		int lengthofPattern = this.pattern.length();
		int lengthofText = this.text.length();
		int numberOfSkips;
		for (int i=0; i<=lengthofText-lengthofPattern; i+=numberOfSkips) {
			numberOfSkips = 0;
			for (int j=lengthofPattern-1; j>=0; j--) {
				if (pattern.charAt(j) != text.charAt(i+j)) {
					if(mismatchShiftTable.get(text.charAt(i+j)) != null) {
						numberOfSkips = mismatchShiftTable.get(text.charAt(i+j));
						break;
					} else {
						numberOfSkips = lengthofPattern;
						break;
					}
				} 
			}
			if (numberOfSkips == 0) {
				return i;
			}
		}
		return lengthofText;
	}

	public static void main(String[] args) {
		BoyerMoore bm = new BoyerMoore("geeksforgeeks","geeks");
		bm.precomputeShift();
		System.out.println(bm.search());
	}
}