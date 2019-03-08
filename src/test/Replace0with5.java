package test;

public class Replace0with5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //call convertfive
	}

	int helper(int num) {
		// Your code here
		if (num == 0)
			return 0;

		int digit = num % 10;
		if (digit == 0) {
			digit = 5;
		}

		return helper(num / 10) * 10 + digit;
	}

	int convertfive(int num) {
		if (num == 0)
			return 5;

		return helper(num);
	}

}
