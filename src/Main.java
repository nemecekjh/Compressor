public class Main {
	public static void main(String[] args){
		String uncompressed = "aaaabbccc";
		System.out.println(uncompressed);
		String compressed	= Compressor.compress(uncompressed);
		System.out.println(compressed);
		System.out.println(Compressor.uncompress(compressed));
	}
}
