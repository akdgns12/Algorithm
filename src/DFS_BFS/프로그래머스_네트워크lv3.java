package DFS_BFS;

public class 프로그래머스_네트워크lv3 {
	    public int solution(int n, int[][] computers) {
	        int answer = 0;
	        //DFS로 노드를 탐색한 후 dfs재귀함수가 끝나는 시점에서 
	        //다른 노드들을 for문으로 탐색해보면서 방문 안했던 노드가 존재하는지 찾는다.
	        //만약 방문안한 노드가 있다면 또 다른 네트워크가 추가되는 것을 알 수 있기에
	        //이 거점으로 네트워크 수를 추가한다.
	        boolean[] visited = new boolean[computers.length];
	        
	        for(int i=0; i<computers.length; i++){ //visited[i] = false로 초기화
	            visited[i] = false;
	        }
	        
	        for(int i=0; i<computers.length; i++){
	            if(visited[i] ==false){
	                answer++;
	                dfs(i, visited, computers);
	            }
	        }
	        return answer;
	    }
	    
	    public void dfs(int node, boolean[] visited, int[][] computers){
	        visited[node] = true;
	        
	        for(int i=0; i<computers.length; i++){
	            if(visited[i] == false && computers[node][i] == 1){
	                dfs(i, visited, computers);
	            }
	        }
	    }
	}
