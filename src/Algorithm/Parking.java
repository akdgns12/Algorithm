package Algorithm;

import java.util.Scanner;

public class Parking {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int[] arr = new int[100];
		int start, end, max = 0;
		int min = 0;
		int sum = 0;
		
		for(int i=0; i<3; i++) {
			start = sc.nextInt();
			end = sc.nextInt();
			min = Math.min(min, start); // 가장 빨리 시작하는 시간, Math.min or Math.max 두인자 값 중 작은 값, 큰 값 리턴
			max = Math.max(max, end);	// 가장 늦게 끝나는 시간
			
			//트럭 한대의 start ~ end 시간동안 배열을 +1 해준다.
			for(int j = start; j<end; j++) {
				arr[j]++;
			}
		}
		//가장 처음 들어온 시간부터 가장 마지막 시간까지 계산을 한다.
		for(int i = min; i<max; i++) {
			switch(arr[i]) {
			case 1:
				sum = sum + A*arr[i];
				break;
			case 2:
				sum = sum + B*arr[i];
				break;
			case 3:
				sum = sum + C*arr[i];
				break;
			}
		}
	System.out.println(sum);
	}
}

/*
 * 상근이는 트럭을 총 세 대 가지고 있다. 오늘은 트럭을 주차하는데 비용이 얼마나 필요한지
 * 알아보려고 한다. 상근이가 이용하는 주차장은 주차하는 트럭의 수에 따라서 주차요금을
 * 할인해 준다. 트럭을 한 대 주차할 때는 1분에 한 대당 A원을 내야 한다. 두 대를 주차할 때
 * 는 1분에 한 대당 B원, 세 대를 주차할 때는 1분에 한 대당 C원을 내야 한다.
 * A,B,C가 주어지고, 상근이의 트럭이 주차장에 주차된 시간이 주어졌을 때, 주차요금으로
 * 얼마를 내야 하는지 구하는 프로그램을 작성하시오.
 * 입력 : 첫째 줄에 문제에서 설명한 주차 요금 A,B,C가 주어진다(1<=C<=B<=A<=100)
 * 다음 세개 줄에는 두 정수가 주어진다. 이 정수는 상근이가 가지고 있는 트럭이 주차장에 도착한
 * 시간과 주차장에서 떠난 시간이다. 도착한 시간은 항상 떠난 시간보다 앞선다. 입력으로 주어지는
 * 시간은 1과 100사이 이다.
 * 출력 : 첫 째 줄에 상근이가 내야하는 주차 요금을 출력한다.
 * */
 