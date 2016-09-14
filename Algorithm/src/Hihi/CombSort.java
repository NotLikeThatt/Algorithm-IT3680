package day_3;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class CombSort {
	private static int DISK_BLOCK_SIZE = 4096;

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("D:\\input.txt");
		BufferedInputStream bis = new BufferedInputStream(fis, DISK_BLOCK_SIZE);
		DataInputStream dis = new DataInputStream(bis);
		Scanner scanner = new Scanner(dis);
		scanner.useDelimiter(" ");
		int n = Integer.parseInt(scanner.nextLine());
		float[] inp = new float[n];
		for (int i = 0; i < n; i++) {
			inp[i] = scanner.nextFloat();
		}
		sort(inp, inp.length);
		for (int i = 0; i < n; i++) {
			System.out.print(inp[i] + " ");
		}
		scanner.close();
	}

	public static void sort(float[] a, int n) {
		int gap = n;
		float shrink = 1.3f;
		boolean sorted = false;

		while (gap > 1 || sorted == false) {
			// Update the gap value for a next comb
			gap = (int) (gap / shrink);
			if (gap < 1) {
				gap = 1;
			}
			int i = 0;
			if (gap == 1) {
				sorted = true;
			}

			// A single " comb " over the input list
			while (i + gap < n) {
				if (a[i] > a[i + gap]) {
					float temp = a[i];
					a[i] = a[i + gap];
					a[i + gap] = temp;
					if (gap == 1) {
						sorted = false;
					}
				}
				i++;
			}
		}
	}
}
