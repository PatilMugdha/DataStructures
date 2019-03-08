package test;

import java.util.Scanner;

public class TemplateForInput {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		while (T > 0) {
			int X = sc.nextInt();
			int L = sc.nextInt();
			int U = sc.nextInt();
			int num = L + 1;
			int count = 0;
			while (num > L && num < U) {
				int temp = num;
				while (num != 0) {
					int rem = num % 10;
					count = (rem == X) ? count + 1 : count;
					num = num / 10;
				}
				num = temp;
				num++;
			}
			System.out.println(count);
			T--;
		}

	}

}
