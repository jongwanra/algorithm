package study;

public class ParseIntTest {
	public static void main(String[] args) {
		ParseIntTest parseIntTest = new ParseIntTest();
		parseIntTest.convertBinaryToDecimal();
		parseIntTest.convertDecimalToBinary();
	}

	private void convertDecimalToBinary() {
		final int decimal = 138;
		String binary = Integer.toBinaryString(decimal);
		System.out.println("binary = " + binary);
	}

	private void convertBinaryToDecimal() {
		final String binary = "10001010";
		int binaryCode = Integer.parseInt(binary, 2);
		System.out.println("binaryCode = " + binaryCode);
	}
}
