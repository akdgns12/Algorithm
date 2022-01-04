package 하드코어스터디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 텀프로젝트 {
	// 사이클이 존재하면 한팀
	static int[] arr; 
	static int T,N;
	static boolean[] visited, finished;
	static int teamCount = 0;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        StringTokenizer st;

	        T = Integer.parseInt(br.readLine());
	        for(int t=0; t<T; t++){
	            N = Integer.parseInt(br.readLine());
	            arr = new int[N+1];

	            st = new StringTokenizer(br.readLine()," ");
	            for(int i = 1; i<N+1; i++){
	                arr[i] = Integer.parseInt(st.nextToken());
	            }

	            finished = new boolean[N+1];
	             visited = new boolean[N+1];
	            teamCount = 0;
	            for(int node  =1 ; node<=N ; node++){
	                dfs(node);
	            }
	            bw.write(String.valueOf(N-teamCount)+"\n");
	        }
	        bw.flush();
	    }
	    public static void dfs(int node){
	    	if(visited[node]) {
	    		finished[node] = true;
	    		teamCount++;
	    	}else {
	    		visited[node] = true;
	    	}
	    	
	    	int next = arr[node];
	    	if(!finished[next])
	    		dfs(next);
	    	visited[node] = false;
	    	finished[node] = true;
	    }
}
