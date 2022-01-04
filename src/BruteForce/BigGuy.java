package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BigGuy {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];
		
		String[] str;
		for(int i=0; i<N; i++) {
			str= br.readLine().split(" "); // 입력받은 정수 공백으로 나눠서 str 배열에 저장
			arr[i][0]=Integer.parseInt(str[0]); // [i][0] : 몸무게
			arr[i][1]=Integer.parseInt(str[1]); // [i][1] : 키
		}
		
		StringBuilder sb = new StringBuilder(); // string끼리 더할 때append 사용하여 문자열 더하는 역할
		// 이중 반복문을 통해 각 배열의 인덱스를 모두 탐색하는 방법	rank=1부터 시작하여 해당 사람보다 덩치가 큰 사람이 있을 경우 해당 사람은 순위는 뒤로 밀리기 때문에
		// rank값을 증가시킨다.
		for(int i =0; i<N; i++) {
			int rank=1;
			
			for(int j=0; j<N; j++) {
				if(i==j) continue;
				if(arr[i][0]<arr[j][0]&&arr[i][1]<arr[j][1]) {
					rank++;
				}
			}
			
			sb.append(rank).append(' ');
		}
		System.out.println(sb);
	}
}

/*
 * 우리는 사람의 덩치를 키와 몸무게, 이 두 개의 값으로 표현하여 그 등수를 매겨보려고 한다. 어떤 사람의 몸무게가 x kg이고, 키가 y cm이라면 이 사람의 덩치는(x,y)로 표시된다.
 * 두 사람 A와B의 덩치가 각(x,y),(p,q)라고 할 때 x>p 그리고 y>p 이라면 우리는 A의 덩치가 B의 덩치보다 "더 크다"고 말한다. 예를들어 어떤
 * A,B 두 사람의 덩치가 각각(56,177),(45,165)라고 한다면 A의 덩치가 B보다 큰 셈이 된다. 그런데 서로 다른 덩치끼리 크기를 정할 수 없는 경우도 있다. 예를 들어 두사람
 * C,D의 덩치가 각각(45,181),(55,173)이라면 몸무게는 D가 C보다 더 무겁고, 키는 C가 더 크므로, "덩치"로만 볼 때 C와D는 누구도 상대방보다 더 크다고 말하 수 없다.
 * N명의 집단에서 각 사람의 덩치 등수는 자신보다 더 "큰 덩치"의 사람의 수로 정해진다. 만일 자신보다 더 큰 덩치의 사람이 k명이라면 그 사람의 덩치 등수는 k+1이 된다. 이렇게 등수를 결정하면
 * 같은 덩치 등수를 가진 사람은 여러명도 가능하다. 아래는 5명으로 이루어진 집단에서 각 사람의 덩치와 그 등수가 표시된 표이다.
 * 여러분은 학생 N명의 몸무게와 키가 담긴 입력을 읽어서 각 사람의 덩치 등수를 계산하여 출력해야 한다.
 * 입력 : 첫 줄에는 전체 사람의 수 N이 주어진다. 그리고 이어지는 N개의 줄에는 각 사람의 몸무게와 키를 나타내는 양의 정수 x와 y가 하나의 공백을 두고 나타난다.
 * 출려 : 여러분은 입력에 나열된 사람의 덩치 등수를 구해서 그 순서대로 첫 줄에 출력해야 한다. 단, 각 덩치 등수는 공백문자로 분리되어야 한다.
 */