import java.io.IOException;
public class Main {
	public static void main(String[] args) throws IOException {
		String uncompressed = "aaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbccccc";
		System.out.println(uncompressed);
		String compressed	= Compressor.compressString(uncompressed);
		System.out.println(compressed);
		System.out.println(Compressor.uncompressString(compressed));
		Compressor.compressFile("test.txt","test2.txt");
		Compressor.uncompressFile("test2.txt","test3.txt");
	}
}
