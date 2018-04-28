package com.ashish.algorithms.strings;

/**
 * @author Ashish Sanagar
 */
public class NumberToString {
	public static void main(String[] args) {
		int num = 20;

		new NumberToString().convert(num);
	}

	public void convert(int num) {
		String[] str1 = {"Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
		String[] str2 = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

		if (num >= 0 && num < 1000) {
			int hundred = num / 100;
			String hundredStr = "";
			if (hundred > 0) {
				hundredStr = str2[hundred - 1] + " Hundred";
				num = num % 100;
			}

			int ten = num / 10;
			String tenStr = "";
			if (ten == 1) {
				tenStr = str2[num - 1];
				num = 0;
			} else if (ten > 1) {
				tenStr = str1[ten - 2];
				num = num % 10;
			}

			String oneStr = "";
			if (num > 0) {
				oneStr = str2[(num % 10) - 1];
			}

			System.out.println((hundredStr + " " + tenStr + " " + oneStr));

		}
	}
}
