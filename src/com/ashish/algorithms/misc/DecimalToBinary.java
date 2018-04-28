package com.ashish.algorithms.misc;

/**
 * @author Ashish Sanagar
 */
public class DecimalToBinary {

	/**
	 * Given a (decimal - e.g. 3.72) number that is passed in as a string, print the binary rep-
	 * resentation. If the number can not be represented accurately in binary, print “ERROR”
	 */
	public static void main(String[] args) {

		String n = "3.72343444";

		new DecimalToBinary().convert(n);
	}

	public void convert(String n) {

		int intPart = Integer.parseInt(n.substring(0, n.indexOf(".")));
		int decPart = Integer.parseInt(n.substring(n.indexOf(".") + 1));

		String intString = "";

		while (intPart > 0) {
			int r = intPart % 2;
			intPart = intPart / 2;

			intString = r + intString;

		}

		StringBuilder decString = new StringBuilder();

		while (decPart > 0) {

			if (decString.length() > 32) {
				decString = new StringBuilder("error");
				break;
			}

			if (decPart == 1) {
				decString.append(1);
				break;
			}

			int r = decPart * 2;

			if (r >= 1) {
				decString.append(1);
				decPart = r - 1;
			} else {
				decString.append(0);
				decPart = r;
			}
		}

		System.out.println(intString + " : " + decString);
	}
}
