package Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class UseOfString {

	/**
	 * @param args
	 */
	
	public double getDouble() throws IOException{
		String s = getString();
		Double aDub = Double.valueOf(s);
		return aDub.doubleValue();
	}
	private String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	public static void main(String[] args) {
		UseOfString us = new UseOfString();
		try {
			us.getString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
