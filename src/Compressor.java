import java.lang.StringBuilder;
import java.io.*;

public class Compressor {
	public static String compress(String inputUncompressed){
		StringBuilder result = new StringBuilder(1024);
		int indexStart = 0;
		int indexEnd = 0;
		char compare = 'a';
		while(indexStart < inputUncompressed.length()){
			compare = inputUncompressed.charAt(indexStart);
			while(inputUncompressed.charAt(indexEnd) == compare){
				indexEnd++;
				if(indexEnd >= inputUncompressed.length() || indexEnd - indexStart > 14){
					break;
				}
			}
			result.append(compare);
			result.append(Integer.toHexString(indexEnd - indexStart));
			indexStart = indexEnd;
		}
		return result.toString();
	}
	public static String uncompress(String inputCompressed){
		StringBuilder result = new StringBuilder(1024);
		int charindex = 0;
		int count = 0;
		while(charindex < inputCompressed.length()){
			count = Character.digit(inputCompressed.charAt(charindex+1),16);
			for(int i=1; i<=count;i++){
				result.append(inputCompressed.charAt(charindex));
			}
			charindex+=2;
		}
		return result.toString();
	}
}
