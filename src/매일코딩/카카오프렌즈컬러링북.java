package 매일코딩;

// 그림에 몇개의 영역이 있는지와 가장 큰 영역의 넓이
// BFS돌면서 연결되어 있는 영역의 갯수 구하고
// 그 영역의 칸 수 카운팅해서 저장해놓은 뒤 
// 새로운 영역의 카운팅 수와 비교해서 Math.max값 찾기
public class 카카오프렌즈컬러링북 {
	static boolean[][] visited;
	static int temp_cnt = 0; // 한 영역의 칸 수 구하는 변수
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	// 변수 접근을 위한 전역 변수들
	static int numberOfArea;
	static int maxSizeOfOneArea;
    
	public int[] solution(int m, int n, int[][] picture) {
		// 1. 초기화 꼭 하기
		numberOfArea = 0;
		maxSizeOfOneArea = 0;
		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		
		// 2. DFS시 방문여부를 체크할 배열
        visited = new boolean[m][n];
        
        // 3.  picture 배열 탐색
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		// 4. 원소가 0이 아니고, 방문한 적이 없다면
        		if(picture[i][j] != 0 && !visited[i][j]) {
        			// 5. 영역의 수가 1개 증가하며 DFS 탐색 수행
        			numberOfArea++;
        			dfs(i,j,picture,visited);
        		}
        		
        		// 13. 한 영역의 탐색이 모두 끝났다면, 조건에 따라 최대 영역의 수를 변경
        		if(temp_cnt > maxSizeOfOneArea)
        			maxSizeOfOneArea = temp_cnt;
        		// 14. 한 영역의 수는 다시 초기화
        		temp_cnt = 0;
        	}
        }
        // 15. 각 값을 answer 배열에 담아주고 끝.
        answer[0] = numberOfArea; // 영역의 갯수
        answer[1] = maxSizeOfOneArea; // 가장 큰 영역의 넓이
        
        return answer;
    }
	
	public static void dfs(int x, int y, int[][] picture, boolean[][] visited){
		// 6. 방문한 적 있는 좌표라면 dfs종료
		if(visited[x][y])
			return;
		
		// 7. 처음 방문시 방문처리
		visited[x][y] = true;
		// 8. 해당 영역의 수 증가
		temp_cnt++;
		
		// 9. 한 좌표에서 상하좌우 탐색
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 10. picture의 범위 벗어나면 continue;
			if(nx < 0 || nx >= picture.length || ny < 0 || ny >= picture[0].length) {
				continue;
			}
			
			// 11. 현 좌표의 색 == 상하좌우 좌표의 색 && 방문한 적 없는 상하좌우 좌표라면
			if(picture[x][y] == picture[nx][ny] && !visited[nx][ny]) {
				// 12. dfs를 위한 재귀호출
				dfs(nx,ny,picture, visited);
			}
		}
	}
	
}
