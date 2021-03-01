import java.lang.StringBuilder;

public class Compressor {
	public static String compress(String inputUncompressed){
		StringBuilder result = new StringBuilder(256);
		int indexStart = 0;
		int indexEnd = 0;
		char compare = 'a';
		while(indexStart < inputUncompressed.length()){
			compare = inputUncompressed.charAt(indexStart);
			while(inputUncompressed.charAt(indexEnd) == compare){
				indexEnd++;
				if(indexEnd >= inputUncompressed.length()){
					break;
				}
			}
			result.append(compare);
			result.append(indexEnd - indexStart);
			indexStart = indexEnd;
		}
		return result.toString();
	}
	public static String uncompress(String inputCompressed){
		StringBuilder result = new StringBuilder(256);
		int indexStart = 0;
		int indexEnd = 0;
		int charcount = 0;
		char multiply = 'a';
		while(indexStart < inputCompressed.length()){
			multiply = inputCompressed.charAt(indexStart);
			indexStart++;
			indexEnd = indexStart;
			while(indexEnd < inputCompressed.length()){
				if(!Character.isDigit(inputCompressed.charAt(indexEnd))) {
					break;
				}
				indexEnd++;

			}
			charcount = 0;
			while(indexStart < indexEnd){
				charcount *= 10;
				charcount += (inputCompressed.charAt(indexStart)-'0');
				indexStart++;
			}
			for(int i = 0; i < charcount; i++){
				result.append(multiply);
			}

		}
		return result.toString();
	}
}
