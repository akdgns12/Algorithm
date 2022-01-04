package Algorithm;

import java.io.IOException;
import java.util.Scanner;
// 교수가 된 현우 N! 끝에 0이 몇개 붙는지 출력하는 프로그램
// 2*5 의 갯수를 세면 된다. -> 최종적으로 5의 개수를 세면 된다 
public class BOJ3474 {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int testcase = input.nextInt();
		int count = 0;
		for(int i=0; i<testcase; i++) {
			long num = input.nextLong();
			for(int j = 5; j<=num; j*=5) {
				count += num/j;
			}
			System.out.println(count);
			count = 0;
		}
	}
}
