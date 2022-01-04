package 프로그래머스_Level_1;

import java.util.Scanner;

/*
 * 표준입력으로 두개의 정수 n,m이 주어진다
 * *문자를 이용해 가로의 길이가 n 세로의 길이가 m인 직사각형 형태를 출력하라
 * 
 */
public class 직사각형별찍기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		for(int i=0; i<b; i++) {
			for(int j=0; j<a; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
