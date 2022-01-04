package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 로프
public class BOJ2217 {
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int cnt = Integer.parseInt(st.nextToken());
        int arr[] = new int[cnt];
        for(int i=0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 오름차순으로 정렬
        Arrays.sort(arr);
        
        long max = 0;
        // 큰 수부터 탐색 
        // 최대중량이 큰 로프순으로 꺼내면서 순서대로 병렬해서 개수에 맞춰 각 최대중량을 구한다.
        for(int i = cnt-1; i >= 0; i--) {
            arr[i] = arr[i] * (cnt-i);
            if(max < arr[i]) max = arr[i];
        }
        System.out.println(max);
	}
}
