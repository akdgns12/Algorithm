package ±×·¡ÇÁÅ½»ö;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_21278 {
	// È£¼®ÀÌ µÎ¸¶¸®Ä¡Å² / °ñ5 / ´ÙÀÍ½ºÆ®¶ó
	/*
	 * ¸ğµç Á¤Á¡À¸·ÎºÎÅÍ ¸ğµç Á¤Á¡±îÁöÀÇ ÃÖ´Ü°Å¸® -> ´ÙÀÍ½ºÆ®¶ó? (X)
	 * ÇÃ·ÎÀÌµå ¿Í¼£
	 * 2Â÷¿ø Å×ÀÌºí¿¡ ­C³ª°Å¸® Á¤º¸¸¦ ÀúÀå
	 * ÇÃ·ÎÀÌµå ¿Í¼£ ¾Ë°í¸®ÁòÀº dp¿¡ ¼ÓÇÔ
	 */
	static int N, M;
	static final int INF = (int)1e9;
	static int[][] graph;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N+1][N+1];
		
		// ÃÖ´Ü°Å¸® Å×ÀÌºíÀ» ¸ğµÎ ¹«ÇÑÀ¸·Î ÃÊ±âÈ­
		for(int i=1; i<=N; i++) {
			Arrays.fill(graph[i], INF);
			//3. °úÁ¤ ¿©±â¼­ ÇÑ¹ø¿¡ Ã³¸®ÇÒ ¼ö ÀÖ´Ù.
			graph[i][i] = 0;
		}
		
//		// 3.ÀÚ±âÀÚ½ÅÀ¸·Î °¡´Â ºñ¿ëÀº ¸ğµÎ 0À¸·Î ÃÊ±âÈ­
//		for(int a=1; a<=N; a++) {
//			for(int b=1; b<=N; b++) {
//				if(a == b) graph[a][b] = 0;
//			}
//		}
//		
		// °£¼± Á¤º¸ ÀÔ·Â¹Ş±â
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = 1;
			graph[b][a] = 1;
		}                           
		
		floydWarshall();
		
		int minSum = Integer.MAX_VALUE;
		String result = "";
		
		for(int i=1; i<graph.length; i++) {
			for(int j=i+1; j<graph.length; j++) {
				int sum = 0;
				// °Ç¹°(k)¿¡¼­ Ä¡Å² ÁıÀÌ ´õ °¡±î¿î ÂÊÀ¸·Î °¡±â ¶§¹®¿¡ (i,k) (j,k) Áß ÃÖ¼Ò °ªÀ» ÃÑÇÕ¿¡ ³Ö½À´Ï´Ù.
				for(int k=1; k<graph.length; k++) {
					sum += Math.min(graph[i][k], graph[j][k]);
				}
				
				if(minSum > sum) {
					minSum = sum;
					result = i + " " + j + " " + minSum*2;
				}
			}
		}
		System.out.println(result);
	}
	
	public static void floydWarshall() {
		for(int k=1; k<=N; k++) {
			for(int a=1; a<=N; a++) {
				for(int b=1; b<=N; b++) {
					graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
				}
			}
		}
	}
}
