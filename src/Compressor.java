import java.lang.StringBuilder;
import java.io.*;

public class Compressor {
	public static void compressStream(Reader reader, Writer writer) throws IOException {
		int compare = reader.read();
		int prch = compare;
		int count = 0;
		while(compare > 0){

			while(compare == prch){
				compare = reader.read();
				count++;
				if(count >= 15){
					break;
				}
			}
			writer.write(prch);
			writer.write(Integer.toHexString(count));
			count = 0;
			prch = compare;
		}
	}
	public static void uncompressStream(Reader reader, Writer writer) throws IOException {
		int pchar = 0;
		int cchar = 0;
		int count = 0;
		while(pchar >= 0){
			pchar = reader.read();

			cchar = reader.read();
			count = Character.isDigit(cchar) ? cchar-0x30 : cchar-0x57;
			for(int i = 0; i < count; i++){
				writer.write(pchar);
			}
		}
	}
	public static String compressString(String inputUncompressed) throws IOException {
		StringWriter writer = new StringWriter();
		compressStream(new StringReader(inputUncompressed), writer);
		return writer.toString();
	}
	public static void compressFile(String inputFileName, String outputFileName) throws IOException {
		try {
			FileWriter writer = new FileWriter(new File(outputFileName));
			compressStream(new FileReader(inputFileName), writer);
			writer.close();
		} catch (IOException e){
			e.printStackTrace();
		} finally {
		}
	}
	public static String uncompressString(String inputCompressed) throws IOException {
		StringWriter writer = new StringWriter();
		uncompressStream(new StringReader(inputCompressed), writer);
		return writer.toString();
	}
	public static void uncompressFile(String inputFileName, String outputFileName) throws IOException{
		try {
			FileWriter writer = new FileWriter(new File(outputFileName));
			uncompressStream(new FileReader(inputFileName), writer);
			writer.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
