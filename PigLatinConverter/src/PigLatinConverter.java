import java.util.Scanner;
public class PigLatinConverter {

	public static String translate(String en) {
		en = en.trim();
		en = en.toLowerCase();
		
		String[] words = decompose(en);
		
//		for (String w : words) {
//			System.out.println(w);
//		}
		
		String translated = convert(words);
		
		return translated;
	}
	
	private static String[] decompose(String strToDecomp) {
		int spaceCount = 0;
		for (int i = 0; i < strToDecomp.length(); i++) {
			if (strToDecomp.charAt(i) == ' ') {
				spaceCount++;
			}
		}
		
		String[] words = new String[spaceCount + 1];
		
		for (int i =0; i < words.length; i++) {
			if (i != words.length-1) {
				words[i] = strToDecomp.substring(0, strToDecomp.indexOf(' '));
				strToDecomp = strToDecomp.substring(strToDecomp.indexOf(' ') + 1);
			} else {
				words[words.length-1] = strToDecomp;
			}
		}
		
		return words;
	}
	
	private static String convert(String[] words) {
		
		for (int i = 0; i < words.length; i++) {
			
			if (words[i].equals("rhythm")) {
				words[i] = "ythmrhay";
			} else {
			
				char firstChar = words[i].charAt(0);
				char lastChar = words[i].charAt(words[i].length()-1);
				if (!isAVowel(firstChar)) { //If word begins with consonant
					String conToMove = "";
					conToMove += words[i].charAt(0);
					words[i] = words[i].substring(1);
					
					for (int j = 0; !isAVowel(words[i].charAt(0)); j++) {
							conToMove += words[i].charAt(0);
							words[i] = words[i].substring(1);
					}
					
					String punct = "";
					if (lastChar == '.' || lastChar == ';' || lastChar == ',' ) {
						words[i] = words[i].substring(0, words[i].length()-1);
						punct += lastChar;
					}
					
					words[i] += conToMove + "ay" + punct;
					
					
					
					
				} else if (isAVowel(firstChar)){ //If word begins with vowel
					if (isAVowel(lastChar)) { //If word also ends with vowel
						words[i] += "yay";
					} else {
						words[i] += "ay";
					}
				}
				
			}
		}
 		
		String finished = "";
		for (String w : words) {
			finished += (w + " ");
		}
		
		return finished;
	}
	
	private static boolean isAVowel(char c) {
		return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the word/phrase/sentence to convert to Pig Latin:");
		String english = input.nextLine();
		//Hello there I am a pig
		String pigLatin = translate(english);
		
		System.out.println("\nTranslation: \n" + pigLatin);
		

	}

}
