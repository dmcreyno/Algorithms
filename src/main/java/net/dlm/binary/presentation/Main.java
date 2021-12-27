package net.dlm.binary.presentation;

/**
 * 
 * 
 *
 */
public class Main {
	
	public Main() {}

	public static void main(String[] args) {
		for(int i = 0; i < args.length; i++) {
			StringBuilder buf = new StringBuilder();
			buf.append(args[i]).append(" = ").append(processInput(args[i]));
			System.out.println(buf.toString());
		}
	}
	
	static String processInput(String inputStr) {
		String result = Integer.toBinaryString(Integer.valueOf(inputStr));
		return result;
	}
	

}
