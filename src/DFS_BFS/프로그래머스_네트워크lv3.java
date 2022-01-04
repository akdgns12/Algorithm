package DFS_BFS;

public class ���α׷��ӽ�_��Ʈ��ũlv3 {
	    public int solution(int n, int[][] computers) {
	        int answer = 0;
	        //DFS�� ��带 Ž���� �� dfs����Լ��� ������ �������� 
	        //�ٸ� ������ for������ Ž���غ��鼭 �湮 ���ߴ� ��尡 �����ϴ��� ã�´�.
	        //���� �湮���� ��尡 �ִٸ� �� �ٸ� ��Ʈ��ũ�� �߰��Ǵ� ���� �� �� �ֱ⿡
	        //�� �������� ��Ʈ��ũ ���� �߰��Ѵ�.
	        boolean[] visited = new boolean[computers.length];
	        
	        for(int i=0; i<computers.length; i++){ //visited[i] = false�� �ʱ�ȭ
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
