package 투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_배열합치기 {
	public static void main(String[] agrs) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" "); // 첫 번째 개행 읽기
		int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
		int size = n+m;
		int[] result = new int[size];
		
		String[] arrayA = br.readLine().split(" "); // 두 번째 줄 읽기
		String[] arrayB = br.readLine().split(" "); // 세 번째 줄 읽기
		
		int idx = 0;
		for(int i=0; i<n; i++) { // 배열 A넣기
			result[idx++] = Integer.parseInt(arrayA[i]);
		}
		for(int i=0; i<m; i++) { // 배열 B넣기
			result[idx++] = Integer.parseInt(arrayB[i]);
		}
		Arrays.sort(result); //오름차순 정렬
		
		for(int r : result) {
			bw.write(String.valueOf(r) + " ");
		}
		
		//write()는 말그대로 버퍼에 적는 것이기 때문에, flush(), close()를 통해 
		//버퍼에 출력한 후 스트림을 닫아야한다.
		bw.flush();
		bw.close();
	}
}
