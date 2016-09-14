package day_4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class T9Spelling {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("D:\\input.txt"));
		Scanner scanner = new Scanner(System.in);
		int numOfTestCase = Integer.parseInt(scanner.nextLine());
		if (numOfTestCase >= 1 && numOfTestCase <= 100) {
			for (int i = 0; i < numOfTestCase; i++) {
				char[] input = scanner.nextLine().toCharArray();
				if (input.length <= 1000) {
					int lastNumber = -1;
					String out = "";
					int numPressed[];
					for (int j = 0; j < input.length; j++) {
						numPressed = getNumberPressed(input[j]);
						if (lastNumber == numPressed[0]) {
							out += " ";
						}
						while (numPressed[1] >= 0) {
							out += numPressed[0];
							numPressed[1]--;
						}
						lastNumber = numPressed[0];
					}
					System.out.println("Case #" + (i + 1) + ": " + out);
				}
			}
		}
		scanner.close();
	}

	// Kiểm tra kí tự thuộc số nào và trả về chuỗi tương ứng
	public static int[] getNumberPressed(char c) {
		int data[] = new int[2];
		if (c >= 'a' && c <= 'o') { // Các kí tự thuộc chỉ nhấn từ 1-3 lần
			data[0] = (c - 'a') / 3 + 2; // Số cần nhấn
			data[1] = (c - 'a') % 3; // Số lần nhấn, dư 0, 1, 2
		} else if (c >= 'p' && c <= 's') {
			data[0] = 7;
			data[1] = c - 'p';
		} else if (c >= 't' && c <= 'v') {
			data[0] = 8;
			data[1] = c - 't';
		} else if (c >= 'w' && c <= 'z') {
			data[0] = 9;
			data[1] = c - 'w';
		} else {
			data[0] = 0;
			data[1] = 0;
		}
		return data;
	}
}
